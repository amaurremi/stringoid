package mobi.beyondpod.rsscore.rss.parsers;

import java.util.HashMap;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class RdfFeedParser
  extends ParserBase
{
  public static final String GOOGLE_ITEM_TAG = "tag:google.com,2005:reader/";
  
  public RdfFeedParser(RootParser paramRootParser)
  {
    super(paramRootParser);
    this._handlers.put("channel", new RdfChannelParser(this));
    this._handlers.put("item", new RdfItemParser(this));
  }
  
  FeedParseData ParseData()
  {
    return ((RootParser)this.Parent).ParseData;
  }
  
  protected void startHandlingEvents(String paramString, Attributes paramAttributes)
    throws SAXException
  {
    ParseData().ParsedFeedType = 4;
    super.startHandlingEvents(paramString, paramAttributes);
  }
  
  private static class RdfChannelParser
    extends ParserBase
  {
    public RdfChannelParser(RdfFeedParser paramRdfFeedParser)
    {
      super();
      this._handlers.put("title", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          RdfFeedParser.RdfChannelParser.this.ParseData().RssFeed.Title = paramAnonymousStringBuilder.toString();
        }
      }));
      this._handlers.put("description", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          RdfFeedParser.RdfChannelParser.this.ParseData().RssFeed.Title = paramAnonymousStringBuilder.toString();
        }
      }));
      this._handlers.put("link", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          RdfFeedParser.RdfChannelParser.this.ParseData().RssFeed.Link = paramAnonymousStringBuilder.toString();
        }
      }));
    }
    
    FeedParseData ParseData()
    {
      return ((RdfFeedParser)this.Parent).ParseData();
    }
  }
  
  private static class RdfItemParser
    extends ParserBase
  {
    RssFeedItem _Item;
    private ParserBase.SimpleElementParser.ElementHandler _OriginatingItemIdHandler = new ParserBase.SimpleElementParser.ElementHandler()
    {
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        RdfFeedParser.RdfItemParser.this.CurrentRssItem().OriginatingItemId = paramAnonymousStringBuilder.toString().replace("tag:google.com,2005:reader/", "");
      }
    };
    
    public RdfItemParser(RdfFeedParser paramRdfFeedParser)
    {
      super();
      this._handlers.put("title", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          RdfFeedParser.RdfItemParser.this.CurrentRssItem().Title = paramAnonymousStringBuilder.toString();
        }
      }));
      this._handlers.put("link", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          RdfFeedParser.RdfItemParser.this.CurrentRssItem().Link = paramAnonymousStringBuilder.toString();
        }
      }));
      this._handlers.put("id", new ParserBase.SimpleElementParser(this, this._OriginatingItemIdHandler));
      if (ParseData().ParseLevel == 0) {
        this._handlers.put("description", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
        {
          public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
            throws Exception
          {
            RdfFeedParser.RdfItemParser.this.CurrentRssItem().Description = paramAnonymousStringBuilder.toString();
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
      return ((RdfFeedParser)this.Parent).ParseData();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/parsers/RdfFeedParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */