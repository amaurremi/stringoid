package com.androidwasabi.livewallpaper.xperiaz;

import com.androidwasabi.gdxlw.AndroidWallpaperService;

public class XperiaZ
  extends AndroidWallpaperService
{
  public com.androidwasabi.gdxlw.a a()
  {
    if (getPackageName().equals("com.androidwasabi.livewallpaper.xperiaz")) {
      return new t(this);
    }
    return null;
  }
  
  public com.badlogic.gdx.backends.android.a b()
  {
    com.badlogic.gdx.backends.android.a locala = new com.badlogic.gdx.backends.android.a();
    locala.a = false;
    locala.i = false;
    locala.j = false;
    return locala;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/XperiaZ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */