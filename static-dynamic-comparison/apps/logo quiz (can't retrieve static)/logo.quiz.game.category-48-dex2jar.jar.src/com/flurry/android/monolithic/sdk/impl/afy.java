package com.flurry.android.monolithic.sdk.impl;

import java.math.BigDecimal;
import java.util.ArrayList;

public final class afy
{
  static final char[] a = new char[0];
  private final afn b;
  private char[] c;
  private int d;
  private int e;
  private ArrayList<char[]> f;
  private boolean g = false;
  private int h;
  private char[] i;
  private int j;
  private String k;
  private char[] l;
  
  public afy(afn paramafn)
  {
    this.b = paramafn;
  }
  
  private final char[] b(int paramInt)
  {
    if (this.b != null) {
      return this.b.a(afp.c, paramInt);
    }
    return new char[Math.max(paramInt, 1000)];
  }
  
  private void c(int paramInt)
  {
    int m = this.e;
    this.e = 0;
    char[] arrayOfChar = this.c;
    this.c = null;
    int n = this.d;
    this.d = -1;
    paramInt = m + paramInt;
    if ((this.i == null) || (paramInt > this.i.length)) {
      this.i = b(paramInt);
    }
    if (m > 0) {
      System.arraycopy(arrayOfChar, n, this.i, 0, m);
    }
    this.h = 0;
    this.j = m;
  }
  
  private void d(int paramInt)
  {
    if (this.f == null) {
      this.f = new ArrayList();
    }
    char[] arrayOfChar = this.i;
    this.g = true;
    this.f.add(arrayOfChar);
    this.h += arrayOfChar.length;
    int n = arrayOfChar.length;
    int m = n >> 1;
    if (m < paramInt) {}
    for (;;)
    {
      arrayOfChar = e(Math.min(262144, n + paramInt));
      this.j = 0;
      this.i = arrayOfChar;
      return;
      paramInt = m;
    }
  }
  
  private final char[] e(int paramInt)
  {
    return new char[paramInt];
  }
  
  private final void n()
  {
    this.g = false;
    this.f.clear();
    this.h = 0;
    this.j = 0;
  }
  
  private char[] o()
  {
    if (this.k != null) {
      return this.k.toCharArray();
    }
    if (this.d >= 0)
    {
      if (this.e < 1) {
        return a;
      }
      arrayOfChar1 = e(this.e);
      System.arraycopy(this.c, this.d, arrayOfChar1, 0, this.e);
      return arrayOfChar1;
    }
    int m = c();
    if (m < 1) {
      return a;
    }
    char[] arrayOfChar1 = e(m);
    if (this.f != null)
    {
      int i1 = this.f.size();
      int n = 0;
      m = 0;
      while (n < i1)
      {
        char[] arrayOfChar2 = (char[])this.f.get(n);
        int i2 = arrayOfChar2.length;
        System.arraycopy(arrayOfChar2, 0, arrayOfChar1, m, i2);
        m += i2;
        n += 1;
      }
    }
    for (;;)
    {
      System.arraycopy(this.i, 0, arrayOfChar1, m, this.j);
      return arrayOfChar1;
      m = 0;
    }
  }
  
  public void a()
  {
    if (this.b == null) {
      b();
    }
    while (this.i == null) {
      return;
    }
    b();
    char[] arrayOfChar = this.i;
    this.i = null;
    this.b.a(afp.c, arrayOfChar);
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(String paramString)
  {
    this.c = null;
    this.d = -1;
    this.e = 0;
    this.k = paramString;
    this.l = null;
    if (this.g) {
      n();
    }
    this.j = 0;
  }
  
  public void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.k = null;
    this.l = null;
    this.c = paramArrayOfChar;
    this.d = paramInt1;
    this.e = paramInt2;
    if (this.g) {
      n();
    }
  }
  
  public void b()
  {
    this.d = -1;
    this.j = 0;
    this.e = 0;
    this.c = null;
    this.k = null;
    this.l = null;
    if (this.g) {
      n();
    }
  }
  
  public void b(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.c = null;
    this.d = -1;
    this.e = 0;
    this.k = null;
    this.l = null;
    if (this.g) {
      n();
    }
    for (;;)
    {
      this.h = 0;
      this.j = 0;
      c(paramArrayOfChar, paramInt1, paramInt2);
      return;
      if (this.i == null) {
        this.i = b(paramInt2);
      }
    }
  }
  
  public int c()
  {
    if (this.d >= 0) {
      return this.e;
    }
    if (this.l != null) {
      return this.l.length;
    }
    if (this.k != null) {
      return this.k.length();
    }
    return this.h + this.j;
  }
  
  public void c(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.d >= 0) {
      c(paramInt2);
    }
    this.k = null;
    this.l = null;
    char[] arrayOfChar = this.i;
    int i1 = arrayOfChar.length - this.j;
    if (i1 >= paramInt2)
    {
      System.arraycopy(paramArrayOfChar, paramInt1, arrayOfChar, this.j, paramInt2);
      this.j += paramInt2;
      return;
    }
    int n = paramInt1;
    int m = paramInt2;
    if (i1 > 0)
    {
      System.arraycopy(paramArrayOfChar, paramInt1, arrayOfChar, this.j, i1);
      n = paramInt1 + i1;
      m = paramInt2 - i1;
    }
    d(m);
    System.arraycopy(paramArrayOfChar, n, this.i, 0, m);
    this.j = m;
  }
  
  public int d()
  {
    if (this.d >= 0) {
      return this.d;
    }
    return 0;
  }
  
  public char[] e()
  {
    if (this.d >= 0) {
      return this.c;
    }
    if (this.l != null) {
      return this.l;
    }
    if (this.k != null)
    {
      char[] arrayOfChar = this.k.toCharArray();
      this.l = arrayOfChar;
      return arrayOfChar;
    }
    if (!this.g) {
      return this.i;
    }
    return g();
  }
  
  public String f()
  {
    if (this.k == null)
    {
      if (this.l == null) {
        break label34;
      }
      this.k = new String(this.l);
    }
    for (;;)
    {
      return this.k;
      label34:
      if (this.d >= 0)
      {
        if (this.e < 1)
        {
          this.k = "";
          return "";
        }
        this.k = new String(this.c, this.d, this.e);
      }
      else
      {
        int m = this.h;
        int n = this.j;
        if (m == 0)
        {
          if (n == 0) {}
          for (localObject = "";; localObject = new String(this.i, 0, n))
          {
            this.k = ((String)localObject);
            break;
          }
        }
        Object localObject = new StringBuilder(m + n);
        if (this.f != null)
        {
          n = this.f.size();
          m = 0;
          while (m < n)
          {
            char[] arrayOfChar = (char[])this.f.get(m);
            ((StringBuilder)localObject).append(arrayOfChar, 0, arrayOfChar.length);
            m += 1;
          }
        }
        ((StringBuilder)localObject).append(this.i, 0, this.j);
        this.k = ((StringBuilder)localObject).toString();
      }
    }
  }
  
  public char[] g()
  {
    char[] arrayOfChar2 = this.l;
    char[] arrayOfChar1 = arrayOfChar2;
    if (arrayOfChar2 == null)
    {
      arrayOfChar1 = o();
      this.l = arrayOfChar1;
    }
    return arrayOfChar1;
  }
  
  public BigDecimal h()
    throws NumberFormatException
  {
    if (this.l != null) {
      return new BigDecimal(this.l);
    }
    if (this.d >= 0) {
      return new BigDecimal(this.c, this.d, this.e);
    }
    if (this.h == 0) {
      return new BigDecimal(this.i, 0, this.j);
    }
    return new BigDecimal(g());
  }
  
  public double i()
    throws NumberFormatException
  {
    return pt.c(f());
  }
  
  public char[] j()
  {
    if (this.d >= 0) {
      c(1);
    }
    for (;;)
    {
      return this.i;
      char[] arrayOfChar = this.i;
      if (arrayOfChar == null) {
        this.i = b(0);
      } else if (this.j >= arrayOfChar.length) {
        d(1);
      }
    }
  }
  
  public final char[] k()
  {
    this.d = -1;
    this.j = 0;
    this.e = 0;
    this.c = null;
    this.k = null;
    this.l = null;
    if (this.g) {
      n();
    }
    char[] arrayOfChar2 = this.i;
    char[] arrayOfChar1 = arrayOfChar2;
    if (arrayOfChar2 == null)
    {
      arrayOfChar1 = b(0);
      this.i = arrayOfChar1;
    }
    return arrayOfChar1;
  }
  
  public int l()
  {
    return this.j;
  }
  
  public char[] m()
  {
    if (this.f == null) {
      this.f = new ArrayList();
    }
    this.g = true;
    this.f.add(this.i);
    int m = this.i.length;
    this.h += m;
    char[] arrayOfChar = e(Math.min(m + (m >> 1), 262144));
    this.j = 0;
    this.i = arrayOfChar;
    return arrayOfChar;
  }
  
  public String toString()
  {
    return f();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/afy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */