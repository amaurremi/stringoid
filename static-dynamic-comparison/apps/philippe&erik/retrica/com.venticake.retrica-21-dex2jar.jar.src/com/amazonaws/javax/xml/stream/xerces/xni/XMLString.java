package com.amazonaws.javax.xml.stream.xerces.xni;

public class XMLString
{
  public char[] ch;
  public int length;
  public int offset;
  
  public void clear()
  {
    this.ch = null;
    this.offset = 0;
    this.length = -1;
  }
  
  public void setValues(XMLString paramXMLString)
  {
    setValues(paramXMLString.ch, paramXMLString.offset, paramXMLString.length);
  }
  
  public void setValues(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.ch = paramArrayOfChar;
    this.offset = paramInt1;
    this.length = paramInt2;
  }
  
  public String toString()
  {
    if (this.length > 0) {
      return new String(this.ch, this.offset, this.length);
    }
    return "";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/xni/XMLString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */