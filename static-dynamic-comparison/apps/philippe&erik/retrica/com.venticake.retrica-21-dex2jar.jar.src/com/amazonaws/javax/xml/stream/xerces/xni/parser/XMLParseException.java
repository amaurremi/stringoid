package com.amazonaws.javax.xml.stream.xerces.xni.parser;

import com.amazonaws.javax.xml.stream.xerces.xni.XMLLocator;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;

public class XMLParseException
  extends XNIException
{
  protected String fBaseSystemId;
  protected int fColumnNumber = -1;
  protected String fExpandedSystemId;
  protected int fLineNumber = -1;
  protected String fLiteralSystemId;
  protected String fPublicId;
  
  public XMLParseException(XMLLocator paramXMLLocator, String paramString)
  {
    super(paramString);
    if (paramXMLLocator != null)
    {
      this.fPublicId = paramXMLLocator.getPublicId();
      this.fLiteralSystemId = paramXMLLocator.getLiteralSystemId();
      this.fExpandedSystemId = paramXMLLocator.getExpandedSystemId();
      this.fBaseSystemId = paramXMLLocator.getBaseSystemId();
      this.fLineNumber = paramXMLLocator.getLineNumber();
      this.fColumnNumber = paramXMLLocator.getColumnNumber();
    }
  }
  
  public int getColumnNumber()
  {
    return this.fColumnNumber;
  }
  
  public String getExpandedSystemId()
  {
    return this.fExpandedSystemId;
  }
  
  public int getLineNumber()
  {
    return this.fLineNumber;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.fPublicId != null) {
      localStringBuffer.append(this.fPublicId);
    }
    localStringBuffer.append(':');
    if (this.fPublicId != null) {
      localStringBuffer.append(this.fPublicId);
    }
    localStringBuffer.append(':');
    if (this.fLiteralSystemId != null) {
      localStringBuffer.append(this.fLiteralSystemId);
    }
    localStringBuffer.append(':');
    if (this.fExpandedSystemId != null) {
      localStringBuffer.append(this.fExpandedSystemId);
    }
    localStringBuffer.append(':');
    if (this.fBaseSystemId != null) {
      localStringBuffer.append(this.fBaseSystemId);
    }
    localStringBuffer.append(':');
    localStringBuffer.append(this.fLineNumber);
    localStringBuffer.append(':');
    localStringBuffer.append(this.fColumnNumber);
    localStringBuffer.append(':');
    String str2 = getMessage();
    String str1 = str2;
    if (str2 == null)
    {
      Exception localException = getException();
      str1 = str2;
      if (localException != null) {
        str1 = localException.getMessage();
      }
    }
    if (str1 != null) {
      localStringBuffer.append(str1);
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/xni/parser/XMLParseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */