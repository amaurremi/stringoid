package com.zestadz.android;

import android.util.Log;
import org.xml.sax.Attributes;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ExampleHandler
  extends DefaultHandler
  implements ErrorHandler
{
  private boolean error = false;
  private ParsedExampleDataSet myParsedExampleDataSet = new ParsedExampleDataSet();
  private boolean picture = false;
  private boolean text = false;
  private boolean url = false;
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    if (this.text) {
      this.myParsedExampleDataSet.setExtractedText(new String(paramArrayOfChar, paramInt1, paramInt2));
    }
    do
    {
      return;
      if (this.picture)
      {
        this.myParsedExampleDataSet.setExtractedPicture(new String(paramArrayOfChar, paramInt1, paramInt2));
        return;
      }
      if (this.url)
      {
        this.myParsedExampleDataSet.setExtractedURL(new String(paramArrayOfChar, paramInt1, paramInt2));
        return;
      }
    } while (!this.error);
    this.myParsedExampleDataSet.setExtractedError(new String(paramArrayOfChar, paramInt1, paramInt2));
  }
  
  public void endDocument()
    throws SAXException
  {}
  
  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    if ((!paramString2.equals("ads")) && (!paramString2.equals("ad")))
    {
      if (!paramString2.equals("text")) {
        break label33;
      }
      this.text = false;
    }
    label33:
    do
    {
      return;
      if (paramString2.equals("picture"))
      {
        this.picture = false;
        return;
      }
      if (paramString2.equals("url"))
      {
        this.url = false;
        return;
      }
    } while (!paramString2.equals("error"));
    this.error = false;
  }
  
  public void error(SAXParseException paramSAXParseException)
  {
    Log.v("ERROR WHILE PARSING", paramSAXParseException.toString());
  }
  
  public ParsedExampleDataSet getParsedData()
  {
    return this.myParsedExampleDataSet;
  }
  
  public void startDocument()
    throws SAXException
  {
    this.myParsedExampleDataSet = new ParsedExampleDataSet();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    if (!paramString2.equals("ads"))
    {
      if (!paramString2.equals("ad")) {
        break label37;
      }
      paramString1 = paramAttributes.getValue("type");
      this.myParsedExampleDataSet.setExtractedAdType(paramString1);
    }
    label37:
    do
    {
      return;
      if (paramString2.equals("text"))
      {
        this.text = true;
        return;
      }
      if (paramString2.equals("picture"))
      {
        this.picture = true;
        return;
      }
      if (paramString2.equals("url"))
      {
        this.url = true;
        return;
      }
    } while (!paramString2.equals("error"));
    this.error = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/zestadz/android/ExampleHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */