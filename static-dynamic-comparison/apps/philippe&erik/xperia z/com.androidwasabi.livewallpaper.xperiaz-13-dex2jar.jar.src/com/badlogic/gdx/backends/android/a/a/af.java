package com.badlogic.gdx.backends.android.a.a;

import android.service.wallpaper.WallpaperService.Engine;
import android.util.Log;
import android.view.SurfaceHolder;
import javax.microedition.khronos.egl.EGL10;

public class af
  extends b
{
  static String c = "GL2JNIView";
  final com.badlogic.gdx.backends.android.b.ag d;
  
  public af(WallpaperService.Engine paramEngine, com.badlogic.gdx.backends.android.b.ag paramag)
  {
    super(paramEngine, paramag);
    this.d = paramag;
    a(false, 16, 0);
  }
  
  static void a(String paramString, EGL10 paramEGL10)
  {
    for (;;)
    {
      int i = paramEGL10.eglGetError();
      if (i == 12288) {
        return;
      }
      Log.e(c, String.format("%s: EGL error: 0x%x", new Object[] { paramString, Integer.valueOf(i) }));
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      f().setFormat(-3);
    }
    a(new ah());
    if (paramBoolean) {}
    for (ag localag = new ag(this, 8, 8, 8, 8, paramInt1, paramInt2);; localag = new ag(this, 5, 6, 5, 0, paramInt1, paramInt2))
    {
      a(localag);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/a/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */