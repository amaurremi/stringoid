package com.badlogic.gdx.math;

import java.util.Random;

public class b
{
  static final int a = (int)Math.sqrt(16384.0D);
  public static Random b = new Random();
  private static final float c = 1.0F / (a - 1);
  
  public static final int a(int paramInt)
  {
    return b.nextInt(paramInt + 1);
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    paramInt -= 1;
    paramInt |= paramInt >> 1;
    paramInt |= paramInt >> 2;
    paramInt |= paramInt >> 4;
    paramInt |= paramInt >> 8;
    return (paramInt | paramInt >> 16) + 1;
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt != 0) && ((paramInt - 1 & paramInt) == 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/math/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */