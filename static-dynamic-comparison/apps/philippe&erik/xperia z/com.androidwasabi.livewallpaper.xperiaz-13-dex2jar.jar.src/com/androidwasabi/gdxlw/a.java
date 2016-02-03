package com.androidwasabi.gdxlw;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.badlogic.gdx.c;
import com.badlogic.gdx.o;

public abstract class a
  implements SharedPreferences.OnSharedPreferenceChangeListener, c, o
{
  public boolean a;
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a(char paramChar)
  {
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  public void b() {}
  
  public boolean b(int paramInt)
  {
    return false;
  }
  
  public boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/gdxlw/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */