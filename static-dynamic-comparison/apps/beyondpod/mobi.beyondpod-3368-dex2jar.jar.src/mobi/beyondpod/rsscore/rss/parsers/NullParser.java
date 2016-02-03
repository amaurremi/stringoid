package mobi.beyondpod.rsscore.rss.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class NullParser
  extends ParserBase
{
  public NullParser(ParserBase paramParserBase)
  {
    super(paramParserBase);
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2) {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    GetNullHandler().startHandlingEvents(paramString2, paramAttributes);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/parsers/NullParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */