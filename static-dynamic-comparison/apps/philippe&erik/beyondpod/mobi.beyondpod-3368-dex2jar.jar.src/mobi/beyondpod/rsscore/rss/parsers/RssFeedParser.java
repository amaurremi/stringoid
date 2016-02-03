package mobi.beyondpod.rsscore.rss.parsers;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.UUID;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.MediaFile;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure.ExtendedEncoding;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem.RssItemImage;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class RssFeedParser
  extends ParserBase
{
  public RssFeedParser(RootParser paramRootParser)
  {
    super(paramRootParser);
    this._handlers.put("channel", new ChannelParser(this));
  }
  
  FeedParseData ParseData()
  {
    return ((RootParser)this.Parent).ParseData;
  }
  
  protected void startHandlingEvents(String paramString, Attributes paramAttributes)
    throws SAXException
  {
    ParseData().ParsedFeedType = 1;
    super.startHandlingEvents(paramString, paramAttributes);
  }
  
  private static class ChannelParser
    extends ParserBase
  {
    private ParserBase.SimpleElementParser.ElementHandler _PubDateHandler = new ParserBase.SimpleElementParser.ElementHandler()
    {
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        if (RssFeedParser.ChannelParser.this.ParseData().RssFeed.PubDate == null) {
          RssFeedParser.ChannelParser.this.ParseData().RssFeed.PubDate = DateTime.TryParseRFC822Time(paramAnonymousStringBuilder.toString(), null);
        }
      }
    };
    private ParserBase.SimpleElementParser.ElementHandler _iTunesImageHandler = new ParserBase.SimpleElementParser.ElementHandler()
    {
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        paramAnonymousString = paramAnonymousAttributesImpl.getValue("", "href");
        if (!StringUtils.IsNullOrEmpty(paramAnonymousString)) {
          RssFeedParser.ChannelParser.this.ParseData().RssFeed.FeedImageLinks.put("itunes", paramAnonymousString);
        }
      }
    };
    
    public ChannelParser(RssFeedParser paramRssFeedParser)
    {
      super();
      this._handlers.put("title", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          RssFeedParser.ChannelParser.this.ParseData().RssFeed.Title = paramAnonymousStringBuilder.toString();
        }
      }));
      this._handlers.put("link", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          RssFeedParser.ChannelParser.this.ParseData().RssFeed.Link = paramAnonymousStringBuilder.toString();
        }
      }));
      this._handlers.put("description", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          RssFeedParser.ChannelParser.this.ParseData().RssFeed.Description = paramAnonymousStringBuilder.toString();
        }
      }));
      this._handlers.put("lastBuildDate", new ParserBase.SimpleElementParser(this, this._PubDateHandler));
      this._handlers.put("pubDate", new ParserBase.SimpleElementParser(this, this._PubDateHandler));
      this._handlers.put("itunes:image", new ParserBase.SimpleElementParser(this, this._iTunesImageHandler));
      this._handlers.put("image", new RssFeedParser.ImageParser(this));
      this._handlers.put("item", new RssFeedParser.RssItemParser(this));
    }
    
    FeedParseData ParseData()
    {
      return ((RssFeedParser)this.Parent).ParseData();
    }
  }
  
  private static class ImageParser
    extends ParserBase
  {
    public ImageParser(final RssFeedParser.ChannelParser paramChannelParser)
    {
      super();
      this._handlers.put("url", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          paramChannelParser.ParseData().RssFeed.FeedImageLinks.put("rss", paramAnonymousStringBuilder.toString());
        }
      }));
    }
  }
  
  public static class MediaRssContentParser
    extends ParserBase
  {
    public MediaRssContentParser(ParserBase paramParserBase)
    {
      super();
      this._handlers.put("channels:extended_encoding", new RssFeedParser.MetaChannelsExtendedEncodingParser(this));
    }
    
    private RssFeedItem CurrentRssItem()
    {
      return RssFeedParser.RssItemParser.RssItemFromParent(this).CurrentRssItem();
    }
    
    public static RssEnclosure ParseEnclosure(FeedParseData paramFeedParseData, AttributesImpl paramAttributesImpl)
    {
      paramFeedParseData = new RssEnclosure(paramFeedParseData.EnclosureDownloadPath, paramFeedParseData.ForceUniqueEnclosureNames);
      String str = paramAttributesImpl.getValue("", "url");
      if (!StringUtils.IsNullOrEmpty(str)) {
        paramFeedParseData.Url = str;
      }
      str = paramAttributesImpl.getValue("", "fileSize");
      if (!StringUtils.IsNullOrEmpty(str)) {
        paramFeedParseData.setEnclosureFileLength(StringUtils.TryParseLongFromString(str, Long.valueOf(0L)));
      }
      str = paramAttributesImpl.getValue("", "type");
      if (!StringUtils.IsNullOrEmpty(str)) {
        paramFeedParseData.Type = str;
      }
      str = paramAttributesImpl.getValue("", "media_type");
      if ((!StringUtils.IsNullOrEmpty(str)) && (StringUtils.IsNullOrEmpty(paramFeedParseData.Type))) {
        paramFeedParseData.Type = str;
      }
      paramAttributesImpl = paramAttributesImpl.getValue("", "medium");
      if ((!StringUtils.IsNullOrEmpty(paramAttributesImpl)) && (StringUtils.IsNullOrEmpty(paramFeedParseData.Type))) {
        paramFeedParseData.Type = MediaFile.mapMediaRssMediumToMime(paramAttributesImpl);
      }
      return paramFeedParseData;
    }
    
    FeedParseData ParseData()
    {
      return RssFeedParser.RssItemParser.RssItemFromParent(this).ParseData();
    }
    
    public void endElement(String paramString1, String paramString2, String paramString3)
      throws SAXException
    {
      CurrentRssItem().SetEnclosure(ParseEnclosure(ParseData(), this._CurrentElementAttributes));
      super.endElement(paramString1, paramString2, paramString3);
    }
  }
  
  public static class MediaRssGroupParser
    extends ParserBase
  {
    public MediaRssGroupParser(RssFeedParser.RssItemParser paramRssItemParser)
    {
      super();
      this._handlers.put("media:content", new RssFeedParser.MediaRssContentParser(this));
    }
    
    FeedParseData ParseData()
    {
      return RssFeedParser.RssItemParser.RssItemFromParent(this).ParseData();
    }
  }
  
  public static class MetaChannelsExtendedEncodingParser
    extends ParserBase
  {
    private ParserBase.SimpleElementParser.ElementHandler _mediaChannelsStreamContentHandler = new ParserBase.SimpleElementParser.ElementHandler()
    {
      private RssEnclosure.ExtendedEncoding ParseExtendedEncoding(AttributesImpl paramAnonymousAttributesImpl)
      {
        RssEnclosure.ExtendedEncoding localExtendedEncoding = new RssEnclosure.ExtendedEncoding();
        localExtendedEncoding.Type = ReadStringAttributeValue(paramAnonymousAttributesImpl, "stream_kind-string", "UNKNOWN");
        localExtendedEncoding.FileSize = ReadLongAttributeValue(paramAnonymousAttributesImpl, "stream_size", -1L);
        localExtendedEncoding.FileSizeString = ReadStringAttributeValue(paramAnonymousAttributesImpl, "file_size-string3", "N/A");
        localExtendedEncoding.Bitrate = ReadIntAttributeValue(paramAnonymousAttributesImpl, "bit_rate", -1);
        localExtendedEncoding.BitrateString = ReadStringAttributeValue(paramAnonymousAttributesImpl, "bit_rate-string", "N/A");
        localExtendedEncoding.Duration = (ReadLongAttributeValue(paramAnonymousAttributesImpl, "duration", -1L) / 1000L);
        localExtendedEncoding.Height = ReadIntAttributeValue(paramAnonymousAttributesImpl, "height", -1);
        localExtendedEncoding.Width = ReadIntAttributeValue(paramAnonymousAttributesImpl, "width", -1);
        localExtendedEncoding.DisplayAspectRatio = ReadStringAttributeValue(paramAnonymousAttributesImpl, "display_aspect_ratio-string", "N/A");
        localExtendedEncoding.Standard = ReadStringAttributeValue(paramAnonymousAttributesImpl, "standard", "N/A");
        localExtendedEncoding.FrameRateMode = ReadStringAttributeValue(paramAnonymousAttributesImpl, "frame_rate_mode", "N/A");
        localExtendedEncoding.BitRateMode = ReadStringAttributeValue(paramAnonymousAttributesImpl, "bit_rate_mode", "N/A");
        localExtendedEncoding.FrameRate = ReadStringAttributeValue(paramAnonymousAttributesImpl, "frame_rate", "N/A");
        localExtendedEncoding.CodecID = ReadStringAttributeValue(paramAnonymousAttributesImpl, "codec_id", "N/A");
        localExtendedEncoding.Format = ReadStringAttributeValue(paramAnonymousAttributesImpl, "format", "N/A");
        localExtendedEncoding.MimeType = ReadStringAttributeValue(paramAnonymousAttributesImpl, "internet_media_type", "N/A");
        return localExtendedEncoding;
      }
      
      private int ReadIntAttributeValue(AttributesImpl paramAnonymousAttributesImpl, String paramAnonymousString, int paramAnonymousInt)
      {
        return StringUtils.TryParseIntFromString(paramAnonymousAttributesImpl.getValue("", paramAnonymousString), Integer.valueOf(paramAnonymousInt)).intValue();
      }
      
      private long ReadLongAttributeValue(AttributesImpl paramAnonymousAttributesImpl, String paramAnonymousString, long paramAnonymousLong)
      {
        return StringUtils.TryParseLongFromString(paramAnonymousAttributesImpl.getValue("", paramAnonymousString), Long.valueOf(paramAnonymousLong)).longValue();
      }
      
      private String ReadStringAttributeValue(AttributesImpl paramAnonymousAttributesImpl, String paramAnonymousString1, String paramAnonymousString2)
      {
        return StringUtils.TryParseStringFromString(paramAnonymousAttributesImpl.getValue("", paramAnonymousString1), paramAnonymousString2);
      }
      
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        float f1;
        float f2;
        if (RssFeedParser.MetaChannelsExtendedEncodingParser.this.CurrentRssItem().Enclosure() != null)
        {
          paramAnonymousString = ParseExtendedEncoding(paramAnonymousAttributesImpl);
          RssFeedParser.MetaChannelsExtendedEncodingParser.this.CurrentRssItem().Enclosure().AddExtendedEncoding(paramAnonymousString);
          if ((RssFeedParser.MetaChannelsExtendedEncodingParser.this.CurrentRssItem().Enclosure().EnclosureFileLength() == null) && ("General".equals(paramAnonymousString.Type)))
          {
            f1 = 0.0F;
            if (!paramAnonymousString.FileSizeString.contains("MiB")) {
              break label142;
            }
            f2 = StringUtils.SafeParseFloat(paramAnonymousString.FileSizeString.replace("MiB", "").trim(), -1.0F);
            f1 = f2;
            if (f2 > 0.0F) {
              f1 = f2 * 1048576.0F;
            }
          }
        }
        for (;;)
        {
          if (f1 > 0.0F) {
            RssFeedParser.MetaChannelsExtendedEncodingParser.this.CurrentRssItem().Enclosure().setEnclosureFileLength(Long.valueOf(f1));
          }
          return;
          label142:
          if (paramAnonymousString.FileSizeString.contains("GiB"))
          {
            f2 = StringUtils.SafeParseFloat(paramAnonymousString.FileSizeString.replace("GiB", "").trim(), -1.0F);
            f1 = f2;
            if (f2 > 0.0F) {
              f1 = f2 * 1.07374182E9F;
            }
          }
          else if (paramAnonymousString.FileSizeString.contains("KiB"))
          {
            f2 = StringUtils.SafeParseFloat(paramAnonymousString.FileSizeString.replace("KiB", "").trim(), -1.0F);
            f1 = f2;
            if (f2 > 0.0F) {
              f1 = f2 * 1024.0F;
            }
          }
        }
      }
    };
    
    public MetaChannelsExtendedEncodingParser(ParserBase paramParserBase)
    {
      super();
      this._handlers.put("channels:stream", new ParserBase.SimpleElementParser(this, this._mediaChannelsStreamContentHandler));
    }
    
    private RssFeedItem CurrentRssItem()
    {
      return RssFeedParser.RssItemParser.RssItemFromParent(this).CurrentRssItem();
    }
    
    FeedParseData ParseData()
    {
      return RssFeedParser.RssItemParser.RssItemFromParent(this).ParseData();
    }
  }
  
  private static class RssItemParser
    extends ParserBase
  {
    RssFeedItem _Item;
    private ParserBase.SimpleElementParser.ElementHandler _enclosureHandler = new ParserBase.SimpleElementParser.ElementHandler()
    {
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        paramAnonymousString = new RssEnclosure(RssFeedParser.RssItemParser.this.ParseData().EnclosureDownloadPath, RssFeedParser.RssItemParser.this.ParseData().ForceUniqueEnclosureNames);
        paramAnonymousStringBuilder = paramAnonymousAttributesImpl.getValue("", "url");
        if (!StringUtils.IsNullOrEmpty(paramAnonymousStringBuilder)) {
          paramAnonymousString.Url = paramAnonymousStringBuilder;
        }
        paramAnonymousStringBuilder = paramAnonymousAttributesImpl.getValue("", "href");
        if ((!StringUtils.IsNullOrEmpty(paramAnonymousStringBuilder)) && (StringUtils.IsNullOrEmpty(paramAnonymousString.Url))) {
          paramAnonymousString.Url = paramAnonymousStringBuilder;
        }
        paramAnonymousStringBuilder = paramAnonymousAttributesImpl.getValue("", "length");
        if (!StringUtils.IsNullOrEmpty(paramAnonymousStringBuilder)) {
          paramAnonymousString.setEnclosureFileLength(StringUtils.TryParseLongFromString(paramAnonymousStringBuilder, Long.valueOf(0L)));
        }
        paramAnonymousAttributesImpl = paramAnonymousAttributesImpl.getValue("", "type");
        if (!StringUtils.IsNullOrEmpty(paramAnonymousAttributesImpl)) {
          paramAnonymousString.Type = paramAnonymousAttributesImpl;
        }
        RssFeedParser.RssItemParser.this.CurrentRssItem().SetEnclosure(paramAnonymousString);
      }
    };
    private ParserBase.SimpleElementParser.ElementHandler _mediaThumbnailHandler = new ParserBase.SimpleElementParser.ElementHandler()
    {
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        paramAnonymousString = new RssFeedItem.RssItemImage();
        paramAnonymousStringBuilder = paramAnonymousAttributesImpl.getValue("", "url");
        if (!StringUtils.IsNullOrEmpty(paramAnonymousStringBuilder)) {
          paramAnonymousString.Url = paramAnonymousStringBuilder;
        }
        paramAnonymousStringBuilder = paramAnonymousAttributesImpl.getValue("", "width");
        if (!StringUtils.IsNullOrEmpty(paramAnonymousStringBuilder)) {
          paramAnonymousString.Width = StringUtils.TryParseIntFromString(paramAnonymousStringBuilder, Integer.valueOf(0)).intValue();
        }
        paramAnonymousAttributesImpl = paramAnonymousAttributesImpl.getValue("", "height");
        if (!StringUtils.IsNullOrEmpty(paramAnonymousAttributesImpl)) {
          paramAnonymousString.Height = StringUtils.TryParseIntFromString(paramAnonymousAttributesImpl, Integer.valueOf(0)).intValue();
        }
        if (paramAnonymousString.IsValid())
        {
          RssFeedParser.RssItemParser.this.CurrentRssItem().Image = paramAnonymousString;
          if (RssFeedParser.RssItemParser.this.CurrentRssItem().ParentFeed().getFeedImageLink() == null) {
            RssFeedParser.RssItemParser.this.CurrentRssItem().ParentFeed().FeedImageLinks.put("rssChildItem", paramAnonymousString.Url);
          }
        }
      }
    };
    
    public RssItemParser(RssFeedParser.ChannelParser paramChannelParser)
    {
      super();
      this._handlers.put("title", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          RssFeedParser.RssItemParser.this.CurrentRssItem().Title = paramAnonymousStringBuilder.toString();
        }
      }));
      this._handlers.put("guid", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          RssFeedParser.RssItemParser.this.CurrentRssItem().Guid = paramAnonymousStringBuilder.toString().trim();
        }
      }));
      this._handlers.put("link", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          RssFeedParser.RssItemParser.this.CurrentRssItem().Link = paramAnonymousStringBuilder.toString();
        }
      }));
      this._handlers.put("pubDate", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          RssFeedParser.RssItemParser.this.CurrentRssItem().OriginalPubDateString = paramAnonymousStringBuilder.toString();
        }
      }));
      this._handlers.put("originatingFeedID", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          RssFeedParser.RssItemParser.this.CurrentRssItem().SetOriginatingFeedID(UUID.fromString(paramAnonymousStringBuilder.toString()));
        }
      }));
      if ((ParseData().ParseLevel == 2) || (ParseData().ParseLevel == 0))
      {
        this._handlers.put("enclosure", new ParserBase.SimpleElementParser(this, this._enclosureHandler));
        this._handlers.put("media:content", new RssFeedParser.MediaRssContentParser(this));
        this._handlers.put("media:thumbnail", new ParserBase.SimpleElementParser(this, this._mediaThumbnailHandler));
        this._handlers.put("media:group", new RssFeedParser.MediaRssGroupParser(this));
        this._handlers.put("itunes:duration", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
        {
          public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
            throws Exception
          {
            if ((paramAnonymousStringBuilder.length() > 0) && (paramAnonymousStringBuilder.length() < 10)) {
              RssFeedParser.RssItemParser.this.CurrentRssItem().EnclosureDuration = paramAnonymousStringBuilder.toString();
            }
          }
        }));
      }
      if (ParseData().ParseLevel == 0)
      {
        this._handlers.put("description", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
        {
          public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
            throws Exception
          {
            if (StringUtils.IsNullOrEmpty(RssFeedParser.RssItemParser.this.CurrentRssItem().Description)) {
              RssFeedParser.RssItemParser.this.CurrentRssItem().Description = paramAnonymousStringBuilder.toString();
            }
          }
        }));
        this._handlers.put("content:encoded", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
        {
          public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
            throws Exception
          {
            RssFeedParser.RssItemParser.this.CurrentRssItem().Description = paramAnonymousStringBuilder.toString();
          }
        }));
        this._handlers.put("category", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
        {
          public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
            throws Exception
          {
            RssFeedParser.RssItemParser.this.CurrentRssItem().Category = paramAnonymousStringBuilder.toString();
          }
        }));
        this._handlers.put("author", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
        {
          public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
            throws Exception
          {
            RssFeedParser.RssItemParser.this.CurrentRssItem().Author = paramAnonymousStringBuilder.toString();
          }
        }));
      }
    }
    
    public static RssItemParser RssItemFromParent(ParserBase paramParserBase)
    {
      for (;;)
      {
        if ((paramParserBase == null) || ((paramParserBase instanceof RssItemParser))) {
          return (RssItemParser)paramParserBase;
        }
        paramParserBase = paramParserBase.Parent;
      }
    }
    
    public RssFeedItem CurrentRssItem()
    {
      if (this._Item == null) {
        this._Item = new RssFeedItem(ParseData().RssFeed);
      }
      return this._Item;
    }
    
    FeedParseData ParseData()
    {
      return ((RssFeedParser.ChannelParser)this.Parent).ParseData();
    }
    
    public void endElement(String paramString1, String paramString2, String paramString3)
      throws SAXException
    {
      HandleEndOfRssFeedItem(ParseData(), CurrentRssItem());
      this._Item = null;
      super.endElement(paramString1, paramString2, paramString3);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/parsers/RssFeedParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */