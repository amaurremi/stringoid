package com.flurry.android.monolithic.sdk.impl;

import java.io.UnsupportedEncodingException;

public class nw
  implements CharSequence, Comparable<nw>
{
  private static final byte[] a = new byte[0];
  private byte[] b = a;
  private int c;
  private String d;
  
  public nw() {}
  
  public nw(nw paramnw)
  {
    this.c = paramnw.c;
    this.b = new byte[paramnw.c];
    System.arraycopy(paramnw.b, 0, this.b, 0, this.c);
    this.d = paramnw.d;
  }
  
  public nw(String paramString)
  {
    this.b = a(paramString);
    this.c = this.b.length;
    this.d = paramString;
  }
  
  public static final byte[] a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return new byte[0];
  }
  
  public int a(nw paramnw)
  {
    return lg.a(this.b, 0, this.c, paramnw.b, 0, paramnw.c);
  }
  
  public nw a(int paramInt)
  {
    if (this.c < paramInt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.b, 0, arrayOfByte, 0, this.c);
      this.b = arrayOfByte;
    }
    this.c = paramInt;
    this.d = null;
    return this;
  }
  
  public byte[] a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public char charAt(int paramInt)
  {
    return toString().charAt(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof nw));
      paramObject = (nw)paramObject;
      bool1 = bool2;
    } while (this.c != ((nw)paramObject).c);
    paramObject = ((nw)paramObject).b;
    int i = 0;
    for (;;)
    {
      if (i >= this.c) {
        break label78;
      }
      bool1 = bool2;
      if (this.b[i] != paramObject[i]) {
        break;
      }
      i += 1;
    }
    label78:
    return true;
  }
  
  public int hashCode()
  {
    int i = 0;
    int j = 0;
    while (i < this.c)
    {
      j = j * 31 + this.b[i];
      i += 1;
    }
    return j;
  }
  
  public int length()
  {
    return toString().length();
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return toString().subSequence(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    if (this.d == null) {}
    try
    {
      this.d = new String(this.b, 0, this.c, "UTF-8");
      return this.d;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/nw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */