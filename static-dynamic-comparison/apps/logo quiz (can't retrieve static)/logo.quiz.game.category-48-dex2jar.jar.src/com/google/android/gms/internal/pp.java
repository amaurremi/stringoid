package com.google.android.gms.internal;

import java.io.IOException;

public final class pp
{
  public static final int[] awL = new int[0];
  public static final long[] awM = new long[0];
  public static final float[] awN = new float[0];
  public static final double[] awO = new double[0];
  public static final boolean[] awP = new boolean[0];
  public static final String[] awQ = new String[0];
  public static final byte[][] awR = new byte[0][];
  public static final byte[] awS = new byte[0];
  
  public static final int b(pe parampe, int paramInt)
    throws IOException
  {
    int i = 1;
    int j = parampe.getPosition();
    parampe.gm(paramInt);
    while (parampe.qg() == paramInt)
    {
      parampe.gm(paramInt);
      i += 1;
    }
    parampe.gq(j);
    return i;
  }
  
  static int gG(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int gH(int paramInt)
  {
    return paramInt >>> 3;
  }
  
  static int x(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/pp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */