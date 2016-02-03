package com.flurry.android.monolithic.sdk.impl;

public class afn
{
  protected final byte[][] a = new byte[afo.values().length][];
  protected final char[][] b = new char[afp.values().length][];
  
  private final byte[] a(int paramInt)
  {
    return new byte[paramInt];
  }
  
  private final char[] b(int paramInt)
  {
    return new char[paramInt];
  }
  
  public final void a(afp paramafp, char[] paramArrayOfChar)
  {
    this.b[paramafp.ordinal()] = paramArrayOfChar;
  }
  
  public final byte[] a(afo paramafo)
  {
    int i = paramafo.ordinal();
    byte[] arrayOfByte = this.a[i];
    if (arrayOfByte == null) {
      return a(afo.a(paramafo));
    }
    this.a[i] = null;
    return arrayOfByte;
  }
  
  public final char[] a(afp paramafp)
  {
    return a(paramafp, 0);
  }
  
  public final char[] a(afp paramafp, int paramInt)
  {
    int i = paramInt;
    if (afp.a(paramafp) > paramInt) {
      i = afp.a(paramafp);
    }
    paramInt = paramafp.ordinal();
    paramafp = this.b[paramInt];
    if ((paramafp == null) || (paramafp.length < i)) {
      return b(i);
    }
    this.b[paramInt] = null;
    return paramafp;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/afn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */