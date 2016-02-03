package com.google.android.gms.internal;

public final class mh
{
  public static final int[] and = new int[0];
  public static final long[] ane = new long[0];
  public static final float[] anf = new float[0];
  public static final double[] ang = new double[0];
  public static final boolean[] anh = new boolean[0];
  public static final String[] ani = new String[0];
  public static final byte[][] anj = new byte[0][];
  public static final byte[] ank = new byte[0];
  
  public static final int b(ly paramly, int paramInt)
  {
    int i = 1;
    int j = paramly.getPosition();
    paramly.ev(paramInt);
    for (;;)
    {
      if ((paramly.nN() <= 0) || (paramly.nB() != paramInt))
      {
        paramly.ez(j);
        return i;
      }
      paramly.ev(paramInt);
      i += 1;
    }
  }
  
  static int eN(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int eO(int paramInt)
  {
    return paramInt >>> 3;
  }
  
  static int u(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/mh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */