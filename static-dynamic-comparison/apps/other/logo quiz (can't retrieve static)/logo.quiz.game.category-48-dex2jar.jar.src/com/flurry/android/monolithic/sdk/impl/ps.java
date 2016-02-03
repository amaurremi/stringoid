package com.flurry.android.monolithic.sdk.impl;

import java.lang.ref.SoftReference;

public final class ps
{
  protected static final ThreadLocal<SoftReference<ps>> a = new ThreadLocal();
  private static final char[] d = ;
  private static final byte[] e = afr.e();
  protected afy b;
  protected final char[] c = new char[6];
  
  public ps()
  {
    this.c[0] = '\\';
    this.c[2] = '0';
    this.c[3] = '0';
  }
  
  private int a(int paramInt, char[] paramArrayOfChar)
  {
    if (paramInt < 0)
    {
      paramInt = -(paramInt + 1);
      paramArrayOfChar[1] = 'u';
      paramArrayOfChar[4] = d[(paramInt >> 4)];
      paramArrayOfChar[5] = d[(paramInt & 0xF)];
      return 6;
    }
    paramArrayOfChar[1] = ((char)paramInt);
    return 2;
  }
  
  public static ps a()
  {
    Object localObject1 = (SoftReference)a.get();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = (ps)((SoftReference)localObject1).get())
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new ps();
        a.set(new SoftReference(localObject2));
      }
      return (ps)localObject2;
    }
  }
  
  public char[] a(String paramString)
  {
    Object localObject1 = this.b;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new afy(null);
      this.b = ((afy)localObject2);
    }
    localObject1 = ((afy)localObject2).k();
    int[] arrayOfInt = afr.c();
    int i1 = arrayOfInt.length;
    int i2 = paramString.length();
    int j = 0;
    int k = 0;
    int m;
    int i;
    int n;
    for (;;)
    {
      m = j;
      if (k >= i2) {
        break label231;
      }
      i = paramString.charAt(k);
      if ((i >= i1) || (arrayOfInt[i] == 0)) {
        break;
      }
      n = a(arrayOfInt[paramString.charAt(k)], this.c);
      if (j + n <= localObject1.length) {
        break label244;
      }
      m = localObject1.length - j;
      if (m > 0) {
        System.arraycopy(this.c, 0, localObject1, j, m);
      }
      localObject1 = ((afy)localObject2).m();
      n -= m;
      System.arraycopy(this.c, m, localObject1, j, n);
      j += n;
      label176:
      k += 1;
    }
    if (j >= localObject1.length)
    {
      localObject1 = ((afy)localObject2).m();
      j = 0;
    }
    for (;;)
    {
      m = j + 1;
      localObject1[j] = i;
      n = k + 1;
      j = m;
      k = n;
      if (n < i2) {
        break;
      }
      label231:
      ((afy)localObject2).a(m);
      return ((afy)localObject2).g();
      label244:
      System.arraycopy(this.c, 0, localObject1, j, n);
      j += n;
      break label176;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */