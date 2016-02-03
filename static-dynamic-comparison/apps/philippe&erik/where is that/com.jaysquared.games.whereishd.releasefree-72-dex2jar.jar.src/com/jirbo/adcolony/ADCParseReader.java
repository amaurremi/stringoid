package com.jirbo.adcolony;

import java.io.IOException;
import java.io.InputStream;

class ADCParseReader
{
  int count;
  char[] data;
  int position;
  
  ADCParseReader(InputStream paramInputStream)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder(paramInputStream.available());
    int i = paramInputStream.read();
    if (i != -1)
    {
      if (((i >= 32) && (i <= 126)) || (i == 10) || (i >= 128)) {
        localStringBuilder.append((char)i);
      }
      for (;;)
      {
        i = paramInputStream.read();
        break;
        localStringBuilder.append(' ');
      }
    }
    this.count = localStringBuilder.length();
    this.data = new char[this.count];
    localStringBuilder.getChars(0, this.count, this.data, 0);
  }
  
  ADCParseReader(String paramString)
  {
    this.count = paramString.length();
    this.data = new char[this.count];
    int j = 0;
    if (j < this.count)
    {
      int i = paramString.charAt(j);
      if (((i >= 32) && (i <= 126)) || (i == 10) || (i >= 128)) {
        this.data[j] = i;
      }
      for (;;)
      {
        j += 1;
        break;
        this.data[j] = ' ';
      }
    }
  }
  
  public static void main(String[] paramArrayOfString) {}
  
  boolean consume(char paramChar)
  {
    if ((this.position == this.count) || (this.data[this.position] != paramChar)) {
      return false;
    }
    this.position += 1;
    return true;
  }
  
  boolean consume(String paramString)
  {
    int j = paramString.length();
    if (this.position + j > this.count) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label53;
      }
      if (paramString.charAt(i) != this.data[(this.position + i)]) {
        break;
      }
      i += 1;
    }
    label53:
    this.position += j;
    return true;
  }
  
  void consume_ws()
  {
    for (;;)
    {
      if (this.position == this.count) {}
      int i;
      do
      {
        return;
        i = this.data[this.position];
      } while ((i != 32) && (i != 10));
      this.position += 1;
    }
  }
  
  boolean has_another()
  {
    return this.position < this.count;
  }
  
  void must_consume(char paramChar)
  {
    if (!consume(paramChar)) {
      throw new AdColonyException("'" + paramChar + "' expected.");
    }
  }
  
  void must_consume(String paramString)
  {
    if (!consume(paramString)) {
      throw new AdColonyException("\"" + paramString + "\" expected.");
    }
  }
  
  char peek()
  {
    if (this.position == this.count) {
      return '\000';
    }
    return this.data[this.position];
  }
  
  char read()
  {
    char[] arrayOfChar = this.data;
    int i = this.position;
    this.position = (i + 1);
    return arrayOfChar[i];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCParseReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */