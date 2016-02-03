package mobi.beyondpod.aggregators.greader;

import java.util.HashMap;
import mobi.beyondpod.aggregators.GDataObject;
import mobi.beyondpod.aggregators.GDataObjectList;
import mobi.beyondpod.rsscore.rss.parsers.ParserBase;
import mobi.beyondpod.rsscore.rss.parsers.ParserBase.SimpleElementParser;
import mobi.beyondpod.rsscore.rss.parsers.ParserBase.SimpleElementParser.ElementHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

public class GoogleObjectParser
  extends ParserBase
{
  public GDataObject _GObject;
  private GDataObjectList _OwnerList;
  
  public GoogleObjectParser(ListParser paramListParser)
  {
    super(paramListParser);
    this._OwnerList = paramListParser.GObjectOwner.List;
  }
  
  public GoogleObjectParser(ParserBase paramParserBase)
  {
    super(paramParserBase);
  }
  
  GDataObject GObject()
  {
    return this._GObject;
  }
  
  void SetHandlers()
  {
    this._handlers.put("string", new ParserBase.SimpleElementParser(this, new ParserBase.SimpleElementParser.ElementHandler()
    {
      public void OnElement(String paramAnonymousString, AttributesImpl paramAnonymousAttributesImpl, StringBuilder paramAnonymousStringBuilder)
        throws Exception
      {
        paramAnonymousString = paramAnonymousAttributesImpl.getValue("", "name");
        if ("id".equals(paramAnonymousString)) {
          GoogleObjectParser.this._GObject.ID = paramAnonymousStringBuilder.toString();
        }
        do
        {
          return;
          if ("title".equals(paramAnonymousString))
          {
            GoogleObjectParser.this._GObject.Title = paramAnonymousStringBuilder.toString();
            return;
          }
        } while (!"label".equals(paramAnonymousString));
        GoogleObjectParser.this._GObject.Label = paramAnonymousStringBuilder.toString();
      }
    }));
    this._handlers.put("list", new ListParser(this));
  }
  
  protected void startHandlingEvents(String paramString, Attributes paramAttributes)
    throws SAXException
  {
    super.startHandlingEvents(paramString, paramAttributes);
    this._GObject = new GDataObject();
    if (this._OwnerList != null) {
      this._OwnerList.add(this._GObject);
    }
    SetHandlers();
  }
  
  private static class ListParser
    extends ParserBase
  {
    GDataObject GObjectOwner;
    
    public ListParser(GoogleObjectParser paramGoogleObjectParser)
    {
      super();
      this.GObjectOwner = paramGoogleObjectParser.GObject();
    }
    
    protected void startHandlingEvents(String paramString, Attributes paramAttributes)
      throws SAXException
    {
      super.startHandlingEvents(paramString, paramAttributes);
      this.GObjectOwner.List = new GDataObjectList();
      this.GObjectOwner.List.Name = this._CurrentElementAttributes.getValue("", "name");
      if (this._handlers.get("object") == null) {
        this._handlers.put("object", new GoogleObjectParser(this));
      }
    }
  }
  
  public static class RootParser
    extends ParserBase
  {
    GoogleObjectParser _RootObject = new GoogleObjectParser(this);
    
    public RootParser(XMLReader paramXMLReader)
    {
      super();
      this._handlers.put("object", this._RootObject);
    }
    
    GDataObject Root()
    {
      return this._RootObject.GObject();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/aggregators/greader/GoogleObjectParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */