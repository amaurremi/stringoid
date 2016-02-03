package com.flurry.android.monolithic.sdk.impl;

import java.util.Arrays;

public final class afj
{
  static final afj a = new afj();
  protected afj b;
  protected final boolean c;
  protected final boolean d;
  protected String[] e;
  protected afk[] f;
  protected int g;
  protected int h;
  protected int i;
  protected boolean j;
  
  private afj()
  {
    this.d = true;
    this.c = true;
    this.j = true;
    a(64);
  }
  
  private afj(afj paramafj, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, afk[] paramArrayOfafk, int paramInt)
  {
    this.b = paramafj;
    this.d = paramBoolean1;
    this.c = paramBoolean2;
    this.e = paramArrayOfString;
    this.f = paramArrayOfafk;
    this.g = paramInt;
    paramInt = paramArrayOfString.length;
    this.h = (paramInt - (paramInt >> 2));
    this.i = (paramInt - 1);
    this.j = false;
  }
  
  public static int a(String paramString)
  {
    int m = paramString.charAt(0);
    int k = 1;
    int n = paramString.length();
    while (k < n)
    {
      m = m * 31 + paramString.charAt(k);
      k += 1;
    }
    return m;
  }
  
  public static int a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int k = paramArrayOfChar[0];
    paramInt1 = 1;
    while (paramInt1 < paramInt2)
    {
      k = k * 31 + paramArrayOfChar[paramInt1];
      paramInt1 += 1;
    }
    return k;
  }
  
  public static afj a()
  {
    return a.e();
  }
  
  private void a(int paramInt)
  {
    this.e = new String[paramInt];
    this.f = new afk[paramInt >> 1];
    this.i = (paramInt - 1);
    this.g = 0;
    this.h = (paramInt - (paramInt >> 2));
  }
  
  /* Error */
  private void a(afj paramafj)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 70	com/flurry/android/monolithic/sdk/impl/afj:c	()I
    //   6: sipush 12000
    //   9: if_icmple +17 -> 26
    //   12: aload_0
    //   13: bipush 64
    //   15: invokespecial 37	com/flurry/android/monolithic/sdk/impl/afj:a	(I)V
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 34	com/flurry/android/monolithic/sdk/impl/afj:j	Z
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_1
    //   27: invokevirtual 70	com/flurry/android/monolithic/sdk/impl/afj:c	()I
    //   30: aload_0
    //   31: invokevirtual 70	com/flurry/android/monolithic/sdk/impl/afj:c	()I
    //   34: if_icmple -11 -> 23
    //   37: aload_0
    //   38: aload_1
    //   39: getfield 42	com/flurry/android/monolithic/sdk/impl/afj:e	[Ljava/lang/String;
    //   42: putfield 42	com/flurry/android/monolithic/sdk/impl/afj:e	[Ljava/lang/String;
    //   45: aload_0
    //   46: aload_1
    //   47: getfield 44	com/flurry/android/monolithic/sdk/impl/afj:f	[Lcom/flurry/android/monolithic/sdk/impl/afk;
    //   50: putfield 44	com/flurry/android/monolithic/sdk/impl/afj:f	[Lcom/flurry/android/monolithic/sdk/impl/afk;
    //   53: aload_0
    //   54: aload_1
    //   55: getfield 46	com/flurry/android/monolithic/sdk/impl/afj:g	I
    //   58: putfield 46	com/flurry/android/monolithic/sdk/impl/afj:g	I
    //   61: aload_0
    //   62: aload_1
    //   63: getfield 48	com/flurry/android/monolithic/sdk/impl/afj:h	I
    //   66: putfield 48	com/flurry/android/monolithic/sdk/impl/afj:h	I
    //   69: aload_0
    //   70: aload_1
    //   71: getfield 50	com/flurry/android/monolithic/sdk/impl/afj:i	I
    //   74: putfield 50	com/flurry/android/monolithic/sdk/impl/afj:i	I
    //   77: goto -59 -> 18
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	afj
    //   0	85	1	paramafj	afj
    // Exception table:
    //   from	to	target	type
    //   2	18	80	finally
    //   18	23	80	finally
    //   26	77	80	finally
  }
  
  private afj e()
  {
    return new afj(null, true, true, this.e, this.f, this.g);
  }
  
  private void f()
  {
    Object localObject = this.e;
    int k = localObject.length;
    this.e = new String[k];
    System.arraycopy(localObject, 0, this.e, 0, k);
    localObject = this.f;
    k = localObject.length;
    this.f = new afk[k];
    System.arraycopy(localObject, 0, this.f, 0, k);
  }
  
  private void g()
  {
    int i1 = this.e.length;
    int k = i1 + i1;
    if (k > 65536)
    {
      this.g = 0;
      Arrays.fill(this.e, null);
      Arrays.fill(this.f, null);
      this.j = true;
    }
    int m;
    label160:
    do
    {
      return;
      Object localObject = this.e;
      afk[] arrayOfafk = this.f;
      this.e = new String[k];
      this.f = new afk[k >> 1];
      this.i = (k - 1);
      this.h += this.h;
      m = 0;
      k = 0;
      String str;
      if (m < i1)
      {
        str = localObject[m];
        n = k;
        if (str != null)
        {
          n = k + 1;
          k = a(str) & this.i;
          if (this.e[k] != null) {
            break label160;
          }
          this.e[k] = str;
        }
        for (;;)
        {
          m += 1;
          k = n;
          break;
          k >>= 1;
          this.f[k] = new afk(str, this.f[k]);
        }
      }
      int n = 0;
      m = k;
      k = n;
      while (k < i1 >> 1)
      {
        localObject = arrayOfafk[k];
        if (localObject != null)
        {
          m += 1;
          str = ((afk)localObject).a();
          n = a(str) & this.i;
          if (this.e[n] == null) {
            this.e[n] = str;
          }
          for (;;)
          {
            localObject = ((afk)localObject).b();
            break;
            n >>= 1;
            this.f[n] = new afk(str, this.f[n]);
          }
        }
        k += 1;
      }
    } while (m == this.g);
    throw new Error("Internal error on SymbolTable.rehash(): had " + this.g + " entries; now have " + m + ".");
  }
  
  public afj a(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      afj localafj = new afj(this, paramBoolean1, paramBoolean2, this.e, this.f, this.g);
      return localafj;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < 1) {
      return "";
    }
    if (!this.d) {
      return new String(paramArrayOfChar, paramInt1, paramInt2);
    }
    int k = paramInt3 & this.i;
    Object localObject = this.e[k];
    if (localObject != null)
    {
      if (((String)localObject).length() == paramInt2)
      {
        paramInt3 = 0;
        if (((String)localObject).charAt(paramInt3) != paramArrayOfChar[(paramInt1 + paramInt3)]) {}
        for (;;)
        {
          if (paramInt3 != paramInt2) {
            break label109;
          }
          return (String)localObject;
          int m = paramInt3 + 1;
          paramInt3 = m;
          if (m < paramInt2) {
            break;
          }
          paramInt3 = m;
        }
      }
      label109:
      localObject = this.f[(k >> 1)];
      if (localObject != null)
      {
        localObject = ((afk)localObject).a(paramArrayOfChar, paramInt1, paramInt2);
        if (localObject != null) {
          return (String)localObject;
        }
      }
    }
    if (!this.j)
    {
      f();
      this.j = true;
      paramInt3 = k;
    }
    for (;;)
    {
      this.g += 1;
      localObject = new String(paramArrayOfChar, paramInt1, paramInt2);
      paramArrayOfChar = (char[])localObject;
      if (this.c) {
        paramArrayOfChar = afv.a.a((String)localObject);
      }
      if (this.e[paramInt3] == null)
      {
        this.e[paramInt3] = paramArrayOfChar;
        return paramArrayOfChar;
        if (this.g >= this.h)
        {
          g();
          paramInt3 = a(paramArrayOfChar, paramInt1, paramInt2) & this.i;
        }
      }
      else
      {
        paramInt1 = paramInt3 >> 1;
        this.f[paramInt1] = new afk(paramArrayOfChar, this.f[paramInt1]);
        return paramArrayOfChar;
      }
      paramInt3 = k;
    }
  }
  
  public void b()
  {
    if (!d()) {}
    while (this.b == null) {
      return;
    }
    this.b.a(this);
    this.j = false;
  }
  
  public int c()
  {
    return this.g;
  }
  
  public boolean d()
  {
    return this.j;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/afj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */