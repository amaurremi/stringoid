package com.amazonaws.javax.xml.stream.xerces.util;

import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;

public class XMLStringBuffer
  extends XMLString
{
  public XMLStringBuffer()
  {
    this(32);
  }
  
  public XMLStringBuffer(int paramInt)
  {
    this.ch = new char[paramInt];
  }
  
  public void append(char paramChar)
  {
    if (this.length + 1 > this.ch.length)
    {
      int j = this.ch.length * 2;
      int i = j;
      if (j < this.ch.length + 32) {
        i = this.ch.length + 32;
      }
      char[] arrayOfChar = new char[i];
      System.arraycopy(this.ch, 0, arrayOfChar, 0, this.length);
      this.ch = arrayOfChar;
    }
    this.ch[this.length] = paramChar;
    this.length += 1;
  }
  
  public void append(XMLString paramXMLString)
  {
    append(paramXMLString.ch, paramXMLString.offset, paramXMLString.length);
  }
  
  public void append(String paramString)
  {
    int k = paramString.length();
    if (this.length + k > this.ch.length)
    {
      int j = this.ch.length * 2;
      int i = j;
      if (j < this.ch.length + k + 32) {
        i = this.ch.length + k + 32;
      }
      char[] arrayOfChar = new char[i];
      System.arraycopy(this.ch, 0, arrayOfChar, 0, this.length);
      this.ch = arrayOfChar;
    }
    paramString.getChars(0, k, this.ch, this.length);
    this.length += k;
  }
  
  public void append(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.length + paramInt2 > this.ch.length)
    {
      int j = this.ch.length * 2;
      int i = j;
      if (j < this.ch.length + paramInt2 + 32) {
        i = this.ch.length + paramInt2 + 32;
      }
      char[] arrayOfChar = new char[i];
      System.arraycopy(this.ch, 0, arrayOfChar, 0, this.length);
      this.ch = arrayOfChar;
    }
    if ((paramArrayOfChar != null) && (paramInt2 > 0))
    {
      System.arraycopy(paramArrayOfChar, paramInt1, this.ch, this.length, paramInt2);
      this.length += paramInt2;
    }
  }
  
  public void clear()
  {
    this.offset = 0;
    this.length = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/util/XMLStringBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */