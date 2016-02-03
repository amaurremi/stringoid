package com.vungle.publisher;

public final class ci
{
  public static int a(int paramInt1, int paramInt2)
  {
    a(paramInt2);
    if (paramInt2 == 1) {
      return b(1) | paramInt1;
    }
    return b(0) & paramInt1;
  }
  
  public static void a(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt < 0) || (paramInt > 1)) {
      throw new IllegalArgumentException("bit must be 0 or 1");
    }
  }
  
  private static int b(int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      i = -2;
    }
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */