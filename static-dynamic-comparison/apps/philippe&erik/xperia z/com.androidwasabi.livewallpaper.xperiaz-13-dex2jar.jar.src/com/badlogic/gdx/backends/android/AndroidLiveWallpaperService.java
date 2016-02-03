package com.badlogic.gdx.backends.android;

import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.SurfaceHolder.Callback;
import android.view.WindowManager;
import com.badlogic.gdx.utils.e;

public abstract class AndroidLiveWallpaperService
  extends WallpaperService
{
  static boolean a = false;
  protected volatile n b = null;
  protected SurfaceHolder.Callback c = null;
  protected int d;
  protected int e;
  protected int f;
  protected int g = 0;
  protected int h = 0;
  protected volatile o i = null;
  protected volatile boolean j = false;
  protected volatile boolean k = false;
  volatile int[] l = new int[0];
  
  static {}
  
  public void a()
  {
    if (a) {
      Log.d("WallpaperService", " > AndroidLiveWallpaperService - onCreateApplication()");
    }
  }
  
  protected void a(o paramo)
  {
    synchronized (this.l)
    {
      this.i = paramo;
      return;
    }
  }
  
  public void b()
  {
    if (a) {
      Log.d("WallpaperService", " > AndroidLiveWallpaperService - onDeepPauseApplication()");
    }
    if (this.b != null) {
      this.b.b.j();
    }
  }
  
  public WindowManager c()
  {
    return (WindowManager)getSystemService("window");
  }
  
  protected void finalize()
  {
    Log.i("WallpaperService", "service finalized");
    super.finalize();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/AndroidLiveWallpaperService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */