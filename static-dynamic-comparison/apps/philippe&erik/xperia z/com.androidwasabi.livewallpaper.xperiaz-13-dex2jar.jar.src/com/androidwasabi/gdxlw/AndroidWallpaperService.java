package com.androidwasabi.gdxlw;

import android.service.wallpaper.WallpaperService;
import android.service.wallpaper.WallpaperService.Engine;

public abstract class AndroidWallpaperService
  extends WallpaperService
{
  private final String a = "AndroidWallpaperService";
  
  public abstract a a();
  
  public abstract com.badlogic.gdx.backends.android.a b();
  
  public boolean c()
  {
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public WallpaperService.Engine onCreateEngine()
  {
    return new b(this, a(), b(), c());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/gdxlw/AndroidWallpaperService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */