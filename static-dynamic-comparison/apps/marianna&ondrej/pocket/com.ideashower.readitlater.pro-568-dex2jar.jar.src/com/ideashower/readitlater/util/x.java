package com.ideashower.readitlater.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class x
  extends InputStream
{
  private PushbackInputStream a;
  private boolean b = false;
  private int c = -1;
  private String d;
  private String e;
  
  public x(InputStream paramInputStream, String paramString)
  {
    this.a = new PushbackInputStream(paramInputStream, 4);
    this.d = paramString;
  }
  
  public String a()
  {
    if (!this.b) {}
    try
    {
      b();
      return this.e;
    }
    catch (IOException localIOException)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Init method failed.");
      localIllegalStateException.initCause(localIllegalStateException);
      throw localIllegalStateException;
    }
  }
  
  protected void b()
  {
    if (this.b) {
      return;
    }
    byte[] arrayOfByte = new byte[4];
    int j = this.a.read(arrayOfByte, 0, arrayOfByte.length);
    int i;
    if ((arrayOfByte[0] == 0) && (arrayOfByte[1] == 0) && (arrayOfByte[2] == -2) && (arrayOfByte[3] == -1))
    {
      this.e = "UTF-32BE";
      i = j - 4;
    }
    for (;;)
    {
      this.c = (4 - i);
      if (i > 0) {
        this.a.unread(arrayOfByte, j - i, i);
      }
      this.b = true;
      return;
      if ((arrayOfByte[0] == -1) && (arrayOfByte[1] == -2) && (arrayOfByte[2] == 0) && (arrayOfByte[3] == 0))
      {
        this.e = "UTF-32LE";
        i = j - 4;
      }
      else if ((arrayOfByte[0] == -17) && (arrayOfByte[1] == -69) && (arrayOfByte[2] == -65))
      {
        this.e = "UTF-8";
        i = j - 3;
      }
      else if ((arrayOfByte[0] == -2) && (arrayOfByte[1] == -1))
      {
        this.e = "UTF-16BE";
        i = j - 2;
      }
      else if ((arrayOfByte[0] == -1) && (arrayOfByte[1] == -2))
      {
        this.e = "UTF-16LE";
        i = j - 2;
      }
      else
      {
        this.e = this.d;
        i = j;
      }
    }
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void close()
  {
    this.b = true;
    this.a.close();
  }
  
  public int read()
  {
    this.b = true;
    return this.a.read();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */