package com.jirbo.adcolony;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class y
  extends af
{
  static final int a = 1024;
  String b;
  OutputStream c;
  byte[] d = new byte['Ѐ'];
  int e = 0;
  int f;
  int g;
  
  y(String paramString)
  {
    this.b = paramString;
    if (a.n != 0)
    {
      this.g = 23;
      this.f = this.g;
    }
    try
    {
      if ((a.l != null) && (a.l.f != null)) {
        a.l.f.b();
      }
      this.c = new FileOutputStream(paramString);
      return;
    }
    catch (IOException paramString)
    {
      a(paramString);
    }
  }
  
  y(String paramString, OutputStream paramOutputStream)
  {
    this.b = paramString;
    this.c = paramOutputStream;
  }
  
  public static void a(String[] paramArrayOfString)
  {
    paramArrayOfString = new y("test.txt");
    paramArrayOfString.b("A king who was mad at the time");
    paramArrayOfString.b("Declared limerick writing a crime");
    paramArrayOfString.i += 2;
    paramArrayOfString.b("So late in the night");
    paramArrayOfString.b("All the poets would write");
    paramArrayOfString.i -= 2;
    paramArrayOfString.b("Verses without any rhyme or meter");
    paramArrayOfString.d();
    paramArrayOfString.i += 4;
    paramArrayOfString.b("David\nGerrold");
    paramArrayOfString.i += 2;
    paramArrayOfString.b(4.0D);
    paramArrayOfString.i += 2;
    paramArrayOfString.b(0.0D);
    paramArrayOfString.i += 2;
    paramArrayOfString.b(-100023.0D);
    paramArrayOfString.i += 2;
    paramArrayOfString.c(-6L);
    paramArrayOfString.i += 2;
    paramArrayOfString.c(0L);
    paramArrayOfString.i += 2;
    paramArrayOfString.c(234L);
    paramArrayOfString.i += 2;
    paramArrayOfString.c(Long.MIN_VALUE);
    paramArrayOfString.i += 2;
    paramArrayOfString.b(true);
    paramArrayOfString.i += 2;
    paramArrayOfString.b(false);
    paramArrayOfString.i += 2;
    paramArrayOfString.b();
  }
  
  void a()
  {
    if ((this.e > 0) && (this.c != null)) {}
    try
    {
      this.c.write(this.d, 0, this.e);
      this.e = 0;
      this.c.flush();
      return;
    }
    catch (IOException localIOException)
    {
      this.e = 0;
      a(localIOException);
    }
  }
  
  void a(char paramChar)
  {
    this.d[this.e] = ((byte)(this.f ^ paramChar));
    this.f += this.g;
    paramChar = this.e + 1;
    this.e = paramChar;
    if (paramChar == 'Ѐ') {
      a();
    }
  }
  
  void a(IOException paramIOException)
  {
    l.d.a("Error writing \"").a(this.b).b("\":");
    l.d.b(paramIOException.toString());
    b();
  }
  
  void b()
  {
    a();
    try
    {
      if (this.c != null)
      {
        this.c.close();
        this.c = null;
      }
      return;
    }
    catch (IOException localIOException)
    {
      this.c = null;
      a(localIOException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */