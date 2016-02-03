package com.badlogic.gdx.utils;

public class i
{
  public static boolean a = true;
  
  public static float a(int paramInt)
  {
    int i = paramInt;
    if (a) {
      i = paramInt & 0xFEFFFFFF;
    }
    return Float.intBitsToFloat(i);
  }
  
  public static int a(float paramFloat)
  {
    return Float.floatToIntBits(paramFloat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */