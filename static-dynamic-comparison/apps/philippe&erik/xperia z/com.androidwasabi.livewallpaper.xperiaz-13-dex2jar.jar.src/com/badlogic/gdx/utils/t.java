package com.badlogic.gdx.utils;

import java.util.Arrays;

public class t
  implements Appendable, CharSequence
{
  private static final char[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
  public char[] a;
  public int b;
  
  public t()
  {
    this.a = new char[16];
  }
  
  public t(int paramInt)
  {
    if (paramInt < 0) {
      throw new NegativeArraySizeException();
    }
    this.a = new char[paramInt];
  }
  
  private void b(int paramInt)
  {
    int i = (this.a.length >> 1) + this.a.length + 2;
    if (paramInt > i) {}
    for (;;)
    {
      char[] arrayOfChar = new char[paramInt];
      System.arraycopy(this.a, 0, arrayOfChar, 0, this.b);
      this.a = arrayOfChar;
      return;
      paramInt = i;
    }
  }
  
  public t a(int paramInt)
  {
    if (paramInt == Integer.MIN_VALUE)
    {
      a("-2147483648");
      return this;
    }
    int i = paramInt;
    if (paramInt < 0)
    {
      a('-');
      i = -paramInt;
    }
    if (i >= 10000)
    {
      if (i >= 1000000000) {
        a(c[((int)(i % 10000000000L / 1000000000L))]);
      }
      if (i >= 100000000) {
        a(c[(i % 1000000000 / 100000000)]);
      }
      if (i >= 10000000) {
        a(c[(i % 100000000 / 10000000)]);
      }
      if (i >= 1000000) {
        a(c[(i % 10000000 / 1000000)]);
      }
      if (i >= 100000) {
        a(c[(i % 1000000 / 100000)]);
      }
      a(c[(i % 100000 / 10000)]);
    }
    if (i >= 1000) {
      a(c[(i % 10000 / 1000)]);
    }
    if (i >= 100) {
      a(c[(i % 1000 / 100)]);
    }
    if (i >= 10) {
      a(c[(i % 100 / 10)]);
    }
    a(c[(i % 10)]);
    return this;
  }
  
  public t a(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
    {
      a();
      return this;
    }
    a(paramCharSequence.toString());
    return this;
  }
  
  public t a(Object paramObject)
  {
    if (paramObject == null)
    {
      a();
      return this;
    }
    a(paramObject.toString());
    return this;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt2) && (paramInt2 <= this.b))
    {
      if (paramInt1 == paramInt2) {
        return "";
      }
      return new String(this.a, paramInt1, paramInt2 - paramInt1);
    }
    throw new StringIndexOutOfBoundsException();
  }
  
  final void a()
  {
    int i = this.b + 4;
    if (i > this.a.length) {
      b(i);
    }
    char[] arrayOfChar = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfChar[i] = 'n';
    arrayOfChar = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfChar[i] = 'u';
    arrayOfChar = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfChar[i] = 'l';
    arrayOfChar = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfChar[i] = 'l';
  }
  
  final void a(char paramChar)
  {
    if (this.b == this.a.length) {
      b(this.b + 1);
    }
    char[] arrayOfChar = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfChar[i] = paramChar;
  }
  
  final void a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "null";
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > paramInt2) || (paramInt2 > ((CharSequence)localObject).length())) {
      throw new IndexOutOfBoundsException();
    }
    a(((CharSequence)localObject).subSequence(paramInt1, paramInt2).toString());
  }
  
  final void a(String paramString)
  {
    if (paramString == null)
    {
      a();
      return;
    }
    int i = paramString.length();
    int j = this.b + i;
    if (j > this.a.length) {
      b(j);
    }
    paramString.getChars(0, i, this.a, this.b);
    this.b = j;
  }
  
  public t b(char paramChar)
  {
    a(paramChar);
    return this;
  }
  
  public t b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    a(paramCharSequence, paramInt1, paramInt2);
    return this;
  }
  
  public t b(String paramString)
  {
    a(paramString);
    return this;
  }
  
  public char charAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.b)) {
      throw new StringIndexOutOfBoundsException(paramInt);
    }
    return this.a[paramInt];
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      Object localObject = (t)paramObject;
      int j = this.b;
      if (j != ((t)localObject).b) {
        return false;
      }
      paramObject = this.a;
      localObject = ((t)localObject).a;
      if (paramObject != localObject)
      {
        if ((paramObject == null) || (localObject == null)) {
          return false;
        }
        int i = 0;
        while (i < j)
        {
          if (paramObject[i] != localObject[i]) {
            return false;
          }
          i += 1;
        }
      }
    }
  }
  
  public int hashCode()
  {
    return (this.b + 31) * 31 + Arrays.hashCode(this.a);
  }
  
  public int length()
  {
    return this.b;
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    if (this.b == 0) {
      return "";
    }
    return new String(this.a, 0, this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */