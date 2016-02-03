package com.amazonaws.javax.xml.stream.xerces.util;

import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLErrorHandler;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLParseException;
import java.io.PrintWriter;

public class DefaultErrorHandler
  implements XMLErrorHandler
{
  protected PrintWriter fOut;
  
  public DefaultErrorHandler()
  {
    this(new PrintWriter(System.err));
  }
  
  public DefaultErrorHandler(PrintWriter paramPrintWriter)
  {
    this.fOut = paramPrintWriter;
  }
  
  private void printError(String paramString, XMLParseException paramXMLParseException)
  {
    this.fOut.print("[");
    this.fOut.print(paramString);
    this.fOut.print("] ");
    String str = paramXMLParseException.getExpandedSystemId();
    if (str != null)
    {
      int i = str.lastIndexOf('/');
      paramString = str;
      if (i != -1) {
        paramString = str.substring(i + 1);
      }
      this.fOut.print(paramString);
    }
    this.fOut.print(':');
    this.fOut.print(paramXMLParseException.getLineNumber());
    this.fOut.print(':');
    this.fOut.print(paramXMLParseException.getColumnNumber());
    this.fOut.print(": ");
    this.fOut.print(paramXMLParseException.getMessage());
    this.fOut.println();
    this.fOut.flush();
  }
  
  public void error(String paramString1, String paramString2, XMLParseException paramXMLParseException)
  {
    printError("Error", paramXMLParseException);
  }
  
  public void fatalError(String paramString1, String paramString2, XMLParseException paramXMLParseException)
  {
    printError("Fatal Error", paramXMLParseException);
    throw paramXMLParseException;
  }
  
  public void warning(String paramString1, String paramString2, XMLParseException paramXMLParseException)
  {
    printError("Warning", paramXMLParseException);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/util/DefaultErrorHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */