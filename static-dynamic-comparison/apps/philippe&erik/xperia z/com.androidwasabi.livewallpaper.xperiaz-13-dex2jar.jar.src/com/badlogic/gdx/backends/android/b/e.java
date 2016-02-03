package com.badlogic.gdx.backends.android.b;

import android.opengl.GLU;

public class e
  extends RuntimeException
{
  private final int a;
  
  public e(int paramInt)
  {
    super(a(paramInt));
    this.a = paramInt;
  }
  
  public e(int paramInt, String paramString)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  private static String a(int paramInt)
  {
    String str2 = GLU.gluErrorString(paramInt);
    String str1 = str2;
    if (str2 == null) {
      str1 = "Unknown error 0x" + Integer.toHexString(paramInt);
    }
    return str1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */