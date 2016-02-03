package mobi.beyondpod.rsscore.rss.parsers;

import java.util.HashMap;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class AtomFeedParser
  extends ParserBase
{
  public static final String GOOGLE_ITEM_TAG = "tag:google.com,2005:reader/";
  private ParserBase.SimpleElementParser.ElementHandler _PubDateHandler = new ParserBase.SimpleElementParser.ElementHandler()
  {
    public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
      throws Exception
    {
      if (AtomFeedParser.this.ParseData().RssFeed.PubDate == null) {
        AtomFeedParser.this.ParseData().RssFeed.PubDate = DateTime.TryParseRFC822Time(paramAnonymousStringBuilder.toString(), null);
      }
    }
  };
  
  public AtomFeedParser(RootParser paramRootParser)
  {
    super(paramRootParser);
    this._handlers.put("title", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
    {
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        AtomFeedParser.this.ParseData().RssFeed.Title = paramAnonymousStringBuilder.toString();
      }
    }));
    this._handlers.put("link", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
    {
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        paramAnonymousString = paramAnonymousAttributesImpl.getValue("", "rel");
        paramAnonymousAttributesImpl = paramAnonymousAttributesImpl.getValue("", "href");
        if ((paramAnonymousString != null) && ("self".equals(paramAnonymousString)) && (paramAnonymousAttributesImpl != null)) {
          AtomFeedParser.this.ParseData().RssFeed.IsSuspectedNotSubscribedInGoogleReader = true;
        }
        if (StringUtils.IsNullOrEmpty(AtomFeedParser.this.ParseData().RssFeed.Link))
        {
          if ((paramAnonymousString != null) && ("alternate".equals(paramAnonymousString)) && (!StringUtils.IsNullOrEmpty(paramAnonymousAttributesImpl))) {
            AtomFeedParser.this.ParseData().RssFeed.Link = paramAnonymousAttributesImpl;
          }
        }
        else {
          return;
        }
        AtomFeedParser.this.ParseData().RssFeed.Link = paramAnonymousStringBuilder.toString();
      }
    }));
    this._handlers.put("updated", new ParserBase.SimpleElementParser(this, this._PubDateHandler));
    this._handlers.put("item", new AtomItemParser(this));
    this._handlers.put("entry", new AtomItemParser(this));
  }
  
  FeedParseData ParseData()
  {
    return ((RootParser)this.Parent).ParseData;
  }
  
  protected void startHandlingEvents(String paramString, Attributes paramAttributes)
    throws SAXException
  {
    ParseData().ParsedFeedType = 2;
    RssFeed localRssFeed;
    if (paramAttributes != null)
    {
      String str = paramAttributes.getValue("http://www.google.com/schemas/reader/atom/", "dir");
      localRssFeed = ParseData().RssFeed;
      if ((str == null) || (!"rtl".equals(str))) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      localRssFeed.RTL = bool;
      super.startHandlingEvents(paramString, paramAttributes);
      return;
    }
  }
  
  private static class AtomItemParser
    extends ParserBase
  {
    RssFeedItem _Item;
    private ParserBase.SimpleElementParser.ElementHandler _OriginatingItemIdHandler = new ParserBase.SimpleElementParser.ElementHandler()
    {
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        AtomFeedParser.AtomItemParser.this.CurrentRssItem().OriginatingItemId = paramAnonymousStringBuilder.toString().replace("tag:google.com,2005:reader/", "");
        AtomFeedParser.AtomItemParser.this.CurrentRssItem().Guid = paramAnonymousStringBuilder.toString().trim();
      }
    };
    private ParserBase.SimpleElementParser.ElementHandler _categoryHandler = new ParserBase.SimpleElementParser.ElementHandler()
    {
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        paramAnonymousString = paramAnonymousAttributesImpl.getValue("", "label");
        if (!StringUtils.IsNullOrEmpty(paramAnonymousString))
        {
          if (!"read".equals(paramAnonymousString)) {
            break label36;
          }
          AtomFeedParser.AtomItemParser.this.CurrentRssItem().setGoogleRead();
        }
        label36:
        do
        {
          return;
          if ("starred".equals(paramAnonymousString))
          {
            AtomFeedParser.AtomItemParser.this.CurrentRssItem().setGoogleStarred();
            return;
          }
        } while (!"reading-list".equals(paramAnonymousString));
        AtomFeedParser.AtomItemParser.this.CurrentRssItem().setInGoogleReadingList();
      }
    };
    private ParserBase.SimpleElementParser.ElementHandler _dateHandler = new ParserBase.SimpleElementParser.ElementHandler()
    {
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        paramAnonymousAttributesImpl = paramAnonymousStringBuilder.toString();
        if (!StringUtils.IsNullOrEmpty(paramAnonymousAttributesImpl))
        {
          if (!"updated".equals(paramAnonymousString)) {
            break label49;
          }
          if (StringUtils.IsNullOrEmpty(AtomFeedParser.AtomItemParser.this.CurrentRssItem().OriginalPubDateString)) {
            AtomFeedParser.AtomItemParser.this.CurrentRssItem().OriginalPubDateString = paramAnonymousAttributesImpl;
          }
        }
        return;
        label49:
        AtomFeedParser.AtomItemParser.this.CurrentRssItem().OriginalPubDateString = paramAnonymousAttributesImpl;
      }
    };
    private ParserBase.SimpleElementParser.ElementHandler _linkHandler = new ParserBase.SimpleElementParser.ElementHandler()
    {
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        paramAnonymousStringBuilder = paramAnonymousAttributesImpl.getValue("", "href");
        paramAnonymousString = paramAnonymousAttributesImpl.getValue("", "rel");
        if (!StringUtils.IsNullOrEmpty(paramAnonymousString))
        {
          if (!"alternate".equals(paramAnonymousString)) {
            break label46;
          }
          AtomFeedParser.AtomItemParser.this.CurrentRssItem().Link = paramAnonymousStringBuilder;
        }
        label46:
        while ((!"enclosure".equals(paramAnonymousString)) || ((AtomFeedParser.AtomItemParser.this.ParseData().ParseLevel != 0) && (AtomFeedParser.AtomItemParser.this.ParseData().ParseLevel != 2))) {
          return;
        }
        paramAnonymousString = new RssEnclosure(AtomFeedParser.AtomItemParser.this.ParseData().EnclosureDownloadPath, AtomFeedParser.AtomItemParser.this.ParseData().ForceUniqueEnclosureNames);
        paramAnonymousString.Url = paramAnonymousStringBuilder;
        paramAnonymousStringBuilder = paramAnonymousAttributesImpl.getValue("", "length");
        if (!StringUtils.IsNullOrEmpty(paramAnonymousStringBuilder)) {
          paramAnonymousString.setEnclosureFileLength(StringUtils.TryParseLongFromString(paramAnonymousStringBuilder, Long.valueOf(0L)));
        }
        paramAnonymousAttributesImpl = paramAnonymousAttributesImpl.getValue("", "type");
        if (!StringUtils.IsNullOrEmpty(paramAnonymousAttributesImpl)) {
          paramAnonymousString.Type = paramAnonymousAttributesImpl;
        }
        AtomFeedParser.AtomItemParser.this.CurrentRssItem().SetEnclosure(paramAnonymousString);
      }
    };
    private ParserBase.SimpleElementParser.ElementHandler _mediaRssContentHandler = new ParserBase.SimpleElementParser.ElementHandler()
    {
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        AtomFeedParser.AtomItemParser.this.CurrentRssItem().SetEnclosure(AtomFeedParser.MediaRssGroupParser.ParseEnclosure(AtomFeedParser.AtomItemParser.this.ParseData(), paramAnonymousAttributesImpl));
      }
    };
    
    public AtomItemParser(AtomFeedParser paramAtomFeedParser)
    {
      super();
      this._handlers.put("title", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          paramAnonymousAttributesImpl = AtomFeedParser.AtomItemParser.this.CurrentRssItem();
          if (AtomFeedParser.AtomItemParser.this.CurrentRssItem().ParentFeed().RTL) {}
          for (paramAnonymousString = AtomFeedParser.AtomItemParser.CleanRTLDivs(paramAnonymousStringBuilder.toString());; paramAnonymousString = paramAnonymousStringBuilder.toString())
          {
            paramAnonymousAttributesImpl.Title = paramAnonymousString;
            return;
          }
        }
      }));
      this._handlers.put("link", new ParserBase.SimpleElementParser(this, this._linkHandler));
      this._handlers.put("updated", new ParserBase.SimpleElementParser(this, this._dateHandler));
      this._handlers.put("published", new ParserBase.SimpleElementParser(this, this._dateHandler));
      this._handlers.put("id", new ParserBase.SimpleElementParser(this, this._OriginatingItemIdHandler));
      this._handlers.put("source", new AtomFeedParser.AtomItemSourceParser(this));
      this._handlers.put("category", new ParserBase.SimpleElementParser(this, this._categoryHandler));
      if ((ParseData().ParseLevel == 2) || (ParseData().ParseLevel == 0))
      {
        this._handlers.put("media:content", new ParserBase.SimpleElementParser(this, this._mediaRssContentHandler));
        this._handlers.put("media:group", new AtomFeedParser.MediaRssGroupParser(this));
      }
      if (ParseData().ParseLevel == 0)
      {
        this._handlers.put("summary", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
        {
          public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
            throws Exception
          {
            AtomFeedParser.AtomItemParser.this.CurrentRssItem().Description = paramAnonymousStringBuilder.toString();
          }
        }));
        this._handlers.put("content", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
        {
          public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
            throws Exception
          {
            AtomFeedParser.AtomItemParser.this.CurrentRssItem().Description = paramAnonymousStringBuilder.toString();
          }
        }));
      }
    }
    
    private RssFeedItem CurrentRssItem()
    {
      if (this._Item == null) {
        this._Item = new RssFeedItem(ParseData().RssFeed);
      }
      return this._Item;
    }
    
    FeedParseData ParseData()
    {
      return ((AtomFeedParser)this.Parent).ParseData();
    }
    
    public void endElement(String paramString1, String paramString2, String paramString3)
      throws SAXException
    {
      String str = this._CurrentElementAttributes.getValue("http://www.google.com/schemas/reader/atom/", "is-read-state-locked");
      if ((!StringUtils.IsNullOrEmpty(str)) && ("true".equals(str))) {
        CurrentRssItem().IsGoogleReadLocked = true;
      }
      HandleEndOfRssFeedItem(ParseData(), CurrentRssItem());
      this._Item = null;
      super.endElement(paramString1, paramString2, paramString3);
    }
  }
  
  private static class AtomItemSourceParser
    extends ParserBase
  {
    RssFeedItem _Item;
    
    public AtomItemSourceParser(AtomFeedParser.AtomItemParser paramAtomItemParser)
    {
      super();
      this._handlers.put("id", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          AtomFeedParser.AtomItemSourceParser.this.CurrentRssItem().OriginatingFeed = paramAnonymousStringBuilder.toString().replace("tag:google.com,2005:reader/", "");
        }
      }));
      this._handlers.put("title", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          paramAnonymousAttributesImpl = AtomFeedParser.AtomItemSourceParser.this.CurrentRssItem();
          if (AtomFeedParser.AtomItemSourceParser.this.CurrentRssItem().ParentFeed().RTL) {}
          for (paramAnonymousString = AtomFeedParser.AtomItemSourceParser.CleanRTLDivs(paramAnonymousStringBuilder.toString());; paramAnonymousString = paramAnonymousStringBuilder.toString())
          {
            paramAnonymousAttributesImpl.OriginatingFeedTitle = paramAnonymousString;
            return;
          }
        }
      }));
    }
    
    private RssFeedItem CurrentRssItem()
    {
      return ((AtomFeedParser.AtomItemParser)this.Parent).CurrentRssItem();
    }
  }
  
  private static class MediaRssGroupParser
    extends ParserBase
  {
    RssFeedItem _Item;
    private ParserBase.SimpleElementParser.ElementHandler _mediaRssContentHandler = new ParserBase.SimpleElementParser.ElementHandler()
    {
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        AtomFeedParser.MediaRssGroupParser.this.CurrentRssItem().SetEnclosure(AtomFeedParser.MediaRssGroupParser.ParseEnclosure(AtomFeedParser.MediaRssGroupParser.this.ParseData(), paramAnonymousAttributesImpl));
      }
    };
    
    public MediaRssGroupParser(AtomFeedParser.AtomItemParser paramAtomItemParser)
    {
      super();
      this._handlers.put("media:content", new ParserBase.SimpleElementParser(this, this._mediaRssContentHandler));
    }
    
    private RssFeedItem CurrentRssItem()
    {
      return ((AtomFeedParser.AtomItemParser)this.Parent).CurrentRssItem();
    }
    
    public static RssEnclosure ParseEnclosure(FeedParseData paramFeedParseData, AttributesImpl paramAttributesImpl)
    {
      return RssFeedParser.MediaRssContentParser.ParseEnclosure(paramFeedParseData, paramAttributesImpl);
    }
    
    FeedParseData ParseData()
    {
      return ((AtomFeedParser.AtomItemParser)this.Parent).ParseData();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/parsers/AtomFeedParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */