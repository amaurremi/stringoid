package mobi.beyondpod.rsscore.rss.parsers;

import java.util.HashMap;
import java.util.UUID;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class OpmlFeedParser
  extends ParserBase
  implements IParent
{
  public OpmlFeedParser(RootParser paramRootParser)
  {
    super(paramRootParser);
    this._handlers.put("head", new OpmlHeadParser(this));
    this._handlers.put("body", new OpmlBodyParser(this));
    this._handlers.put("outline", new OpmlOutlineHandler(this));
  }
  
  public Feed Feed()
  {
    return ParseData().Feed;
  }
  
  FeedParseData ParseData()
  {
    return ((RootParser)this.Parent).ParseData;
  }
  
  protected void startHandlingEvents(String paramString, Attributes paramAttributes)
    throws SAXException
  {
    ParseData().ParsedFeedType = 3;
    super.startHandlingEvents(paramString, paramAttributes);
  }
  
  private static class OpmlBodyParser
    extends ParserBase
    implements IParent
  {
    public OpmlBodyParser(OpmlFeedParser paramOpmlFeedParser)
    {
      super();
      this._handlers.put("outline", new OpmlFeedParser.OpmlOutlineHandler(this));
    }
    
    public Feed Feed()
    {
      return ParseData().Feed;
    }
    
    FeedParseData ParseData()
    {
      return ((OpmlFeedParser)this.Parent).ParseData();
    }
  }
  
  private static class OpmlHeadParser
    extends ParserBase
  {
    private ParserBase.SimpleElementParser.ElementHandler _PubDateHandler = new ParserBase.SimpleElementParser.ElementHandler()
    {
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        if (OpmlFeedParser.OpmlHeadParser.this.ParseData().Feed.getLastModifiedDate() == null) {
          OpmlFeedParser.OpmlHeadParser.this.ParseData().Feed.setLastModifiedDate(DateTime.TryParseRFC822Time(paramAnonymousStringBuilder.toString(), null));
        }
      }
    };
    
    public OpmlHeadParser(OpmlFeedParser paramOpmlFeedParser)
    {
      super();
      this._handlers.put("title", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
      {
        public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
          throws Exception
        {
          OpmlFeedParser.OpmlHeadParser.this.ParseData().Feed.setName(paramAnonymousStringBuilder.toString());
        }
      }));
      this._handlers.put("dateModified", new ParserBase.SimpleElementParser(this, this._PubDateHandler));
    }
    
    FeedParseData ParseData()
    {
      return ((OpmlFeedParser)this.Parent).ParseData();
    }
  }
  
  private static class OpmlOutlineHandler
    extends ParserBase
    implements IParent
  {
    Feed _Feed;
    
    public OpmlOutlineHandler(ParserBase paramParserBase)
    {
      super();
    }
    
    public Feed Feed()
    {
      return this._Feed;
    }
    
    protected void startHandlingEvents(String paramString, Attributes paramAttributes)
      throws SAXException
    {
      super.startHandlingEvents(paramString, paramAttributes);
      paramAttributes = this._CurrentElementAttributes.getValue("", "xmlUrl");
      paramString = paramAttributes;
      if (StringUtils.IsNullOrEmpty(paramAttributes)) {
        paramString = this._CurrentElementAttributes.getValue("", "xmlURL");
      }
      paramAttributes = paramString;
      if (StringUtils.IsNullOrEmpty(paramString)) {
        paramAttributes = this._CurrentElementAttributes.getValue("", "url");
      }
      paramString = paramAttributes;
      if (StringUtils.IsNullOrEmpty(paramAttributes)) {
        paramString = this._CurrentElementAttributes.getValue("", "URL");
      }
      paramAttributes = paramString;
      if (StringUtils.IsNullOrEmpty(paramString)) {
        paramAttributes = this._CurrentElementAttributes.getValue("", "url");
      }
      paramString = this._CurrentElementAttributes.getValue("", "title");
      Object localObject = this._CurrentElementAttributes.getValue("", "text");
      if (!StringUtils.IsNullOrEmpty(paramString)) {}
      for (;;)
      {
        localObject = ((IParent)this.Parent).Feed();
        this._Feed = new Feed(UUID.randomUUID(), (Feed)localObject, paramString, paramAttributes, 4);
        ((Feed)localObject).SubFeeds().add(this._Feed);
        if (this._handlers.get("outline") == null) {
          this._handlers.put("outline", new OpmlOutlineHandler(this));
        }
        return;
        if (!StringUtils.IsNullOrEmpty((String)localObject)) {
          paramString = (String)localObject;
        } else {
          paramString = "<No name>";
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/parsers/OpmlFeedParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */