package com.badlogic.gdx.backends.android;

import android.content.res.AssetManager;
import android.os.Environment;
import com.badlogic.gdx.c.a;
import com.badlogic.gdx.e;
import com.badlogic.gdx.f;
import java.io.File;

public class d
  implements e
{
  protected final String a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
  protected final String b;
  protected final AssetManager c;
  
  public d(AssetManager paramAssetManager)
  {
    this.c = paramAssetManager;
    this.b = this.a;
  }
  
  public a a(String paramString)
  {
    return new c(this.c, paramString, f.b);
  }
  
  public String a()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */