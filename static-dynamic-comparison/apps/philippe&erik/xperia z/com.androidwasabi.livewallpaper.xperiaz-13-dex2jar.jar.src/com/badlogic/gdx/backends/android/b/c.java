package com.badlogic.gdx.backends.android.b;

import java.io.Writer;
import javax.microedition.khronos.opengles.GL;

public class c
{
  public static GL a(GL paramGL, int paramInt, Writer paramWriter)
  {
    if (paramInt != 0) {
      paramGL = new d(paramGL, paramInt);
    }
    for (;;)
    {
      if (paramWriter != null)
      {
        if ((paramInt & 0x4) != 0) {}
        for (boolean bool = true;; bool = false) {
          return new f(paramGL, paramWriter, bool);
        }
      }
      return paramGL;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */