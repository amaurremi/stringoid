package com.jirbo.adcolony;

import java.io.InputStream;

class s
{
  char[] a;
  int b;
  int c;
  
  s(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramInputStream.available());
    int i = paramInputStream.read();
    if (i != -1)
    {
      if (((i >= 32) && (i <= 126)) || (i == 10)) {
        localStringBuilder.append((char)i);
      }
      for (;;)
      {
        i = paramInputStream.read();
        break;
        if ((i & 0x80) != 0)
        {
          if ((i & 0xE0) == 192) {
            localStringBuilder.append((char)((i & 0x1F) << 6 | paramInputStream.read() & 0x3F));
          } else {
            localStringBuilder.append((char)((i & 0xF) << 12 | (paramInputStream.read() & 0x3F) << 6 | paramInputStream.read() & 0x3F));
          }
        }
        else {
          localStringBuilder.append(' ');
        }
      }
    }
    this.c = localStringBuilder.length();
    this.a = new char[this.c];
    localStringBuilder.getChars(0, this.c, this.a, 0);
  }
  
  s(String paramString)
  {
    this.c = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(this.c);
    int i = 0;
    if (i < this.c)
    {
      char c1 = paramString.charAt(i);
      if (((c1 >= ' ') && (c1 <= '~')) || (c1 == '\n')) {
        localStringBuilder.append(c1);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((c1 & 0x80) != 0)
        {
          if (((c1 & 0xE0) == 'À') && (i + 1 < this.c))
          {
            localStringBuilder.append((char)((c1 & 0x1F) << '\006' | paramString.charAt(i + 1) & 0x3F));
            i += 1;
          }
          else if (i + 2 < this.c)
          {
            localStringBuilder.append((char)((c1 & 0xF) << '\f' | (paramString.charAt(i + 1) & 0x3F) << '\006' | paramString.charAt(i + 2) & 0x3F));
            i += 2;
          }
          else
          {
            localStringBuilder.append('?');
          }
        }
        else {
          localStringBuilder.append(' ');
        }
      }
    }
    this.c = localStringBuilder.length();
    this.a = new char[this.c];
    localStringBuilder.getChars(0, this.c, this.a, 0);
  }
  
  public static void a(String[] paramArrayOfString) {}
  
  boolean a()
  {
    return this.b < this.c;
  }
  
  boolean a(char paramChar)
  {
    if ((this.b == this.c) || (this.a[this.b] != paramChar)) {
      return false;
    }
    this.b += 1;
    return true;
  }
  
  boolean a(String paramString)
  {
    int j = paramString.length();
    if (this.b + j > this.c) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label53;
      }
      if (paramString.charAt(i) != this.a[(this.b + i)]) {
        break;
      }
      i += 1;
    }
    label53:
    this.b += j;
    return true;
  }
  
  char b()
  {
    if (this.b == this.c) {
      return '\000';
    }
    return this.a[this.b];
  }
  
  void b(char paramChar)
  {
    if (!a(paramChar)) {
      throw new AdColonyException("'" + paramChar + "' expected.");
    }
  }
  
  void b(String paramString)
  {
    if (!a(paramString)) {
      throw new AdColonyException("\"" + paramString + "\" expected.");
    }
  }
  
  char c()
  {
    char[] arrayOfChar = this.a;
    int i = this.b;
    this.b = (i + 1);
    return arrayOfChar[i];
  }
  
  void d()
  {
    for (;;)
    {
      if (this.b == this.c) {}
      int i;
      do
      {
        return;
        i = this.a[this.b];
      } while ((i != 32) && (i != 10));
      this.b += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */