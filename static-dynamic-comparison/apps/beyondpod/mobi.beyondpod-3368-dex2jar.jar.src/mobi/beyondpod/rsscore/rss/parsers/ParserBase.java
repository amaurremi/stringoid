package mobi.beyondpod.rsscore.rss.parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.helpers.AttributesImpl;

public class ParserBase
  extends DefaultHandler2
{
  static final Pattern RTL_PATTERN = Pattern.compile("<div.*?style=\".*?direction:rtl.*?\".*?>(.*?)</div>");
  protected ParserBase Parent;
  public XMLReader Reader = null;
  protected AttributesImpl _CurrentElementAttributes;
  StringBuilder _CurrentElementText;
  String _HandlesElement;
  protected NullParser _UnhadledHandler;
  protected HashMap<String, ParserBase> _handlers = new HashMap();
  
  protected ParserBase() {}
  
  public ParserBase(ParserBase paramParserBase)
  {
    this(paramParserBase.Reader);
    this.Parent = paramParserBase;
  }
  
  public ParserBase(XMLReader paramXMLReader)
  {
    this.Reader = paramXMLReader;
  }
  
  public static String CleanRTLDivs(String paramString)
  {
    String str = paramString;
    if (paramString != null) {}
    try
    {
      Matcher localMatcher = RTL_PATTERN.matcher(paramString);
      str = paramString;
      if (localMatcher.find()) {
        str = localMatcher.group(1);
      }
      return str;
    }
    catch (IllegalStateException localIllegalStateException) {}
    return paramString;
  }
  
  protected static void HandleEndOfRssFeedItem(FeedParseData paramFeedParseData, RssFeedItem paramRssFeedItem)
    throws SAXException
  {
    ParserUtils.HandleEndOfRssFeedItem(paramFeedParseData, paramRssFeedItem);
    if (paramFeedParseData.RssFeed.Items.size() >= paramFeedParseData.MaxItemsToParse) {
      throw new SAXException("Feed has too many items! Loaded the first " + paramFeedParseData.MaxItemsToParse, new ParserUtils.TooManyItemsException());
    }
  }
  
  private void startHandlingEvents()
  {
    this.Reader.setContentHandler(this);
    this.Reader.setErrorHandler(this);
  }
  
  protected NullParser GetNullHandler()
  {
    if (this._UnhadledHandler == null) {
      this._UnhadledHandler = new NullParser(this);
    }
    return this._UnhadledHandler;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this._CurrentElementText != null) {
      this._CurrentElementText.append(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    stopHandlingEvents();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    if (paramString1.startsWith("http://www.itunes.com")) {
      paramString3 = "itunes:" + paramString2;
    }
    for (;;)
    {
      paramString2 = (ParserBase)this._handlers.get(paramString3);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = GetNullHandler();
      }
      paramString1.startHandlingEvents(paramString3, paramAttributes);
      return;
      if (paramString1.startsWith("http://purl.org/rss/1.0/modules/content"))
      {
        paramString3 = "content:" + paramString2;
      }
      else if (paramString1.startsWith("http://www.w3.org/1999/02/22-rdf-syntax-ns#"))
      {
        paramString3 = "rdf:" + paramString2;
      }
      else if (paramString1.startsWith("http://search.yahoo.com/mrss"))
      {
        paramString3 = "media:" + paramString2;
      }
      else
      {
        paramString3 = paramString2;
        if (paramString1.startsWith("http://www.metachannels.com/channels-mrss")) {
          paramString3 = "channels:" + paramString2;
        }
      }
    }
  }
  
  protected void startHandlingEvents(String paramString, Attributes paramAttributes)
    throws SAXException
  {
    this._HandlesElement = paramString;
    this._CurrentElementAttributes = new AttributesImpl(paramAttributes);
    this._CurrentElementText = new StringBuilder();
    startHandlingEvents();
  }
  
  protected void stopHandlingEvents()
  {
    this.Reader.setContentHandler(this.Parent);
    this.Reader.setErrorHandler(this.Parent);
  }
  
  public static class SimpleElementParser
    extends ParserBase
  {
    ElementHandler _ElementHandler;
    
    public SimpleElementParser(ParserBase paramParserBase, ElementHandler paramElementHandler)
    {
      super();
      this._ElementHandler = paramElementHandler;
    }
    
    public void endElement(String paramString1, String paramString2, String paramString3)
      throws SAXException
    {
      if (this._ElementHandler != null) {}
      try
      {
        this._ElementHandler.OnElement(paramString2, this._CurrentElementAttributes, this._CurrentElementText);
        super.endElement(paramString1, paramString2, paramString3);
        return;
      }
      catch (Exception paramString1)
      {
        throw new SAXException("Exception was thrown during Feed Parsing", paramString1);
      }
    }
    
    public static abstract interface ElementHandler
    {
      public abstract void OnElement(String paramString, AttributesImpl paramAttributesImpl, StringBuilder paramStringBuilder)
        throws Exception;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/parsers/ParserBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */