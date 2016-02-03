package com.pocket.p;

import android.graphics.Color;

public abstract class e
{
  public static final int a(float paramFloat)
  {
    return (int)(255.0F * paramFloat);
  }
  
  public static final int a(float paramFloat, int paramInt)
  {
    return a(a(paramFloat), paramInt);
  }
  
  public static final int a(int paramInt1, int paramInt2)
  {
    return Color.argb(paramInt1, paramInt2, paramInt2, paramInt2);
  }
  
  public static int b(float paramFloat, int paramInt)
  {
    return b(a(paramFloat), paramInt);
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    return Color.argb(paramInt1, Color.red(paramInt2), Color.green(paramInt2), Color.blue(paramInt2));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */