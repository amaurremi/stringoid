package com.google.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.ads.util.i;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;

public class m
  extends i
{
  private static final m d = new m();
  public final i.c<String> a = new i.c(this, "marketPackages", null);
  public final i.b<m.a> b = new i.b(this, "constants", new m.a());
  public final i.b<Handler> c = new i.b(this, "uiHandler", new Handler(Looper.getMainLooper()));
  
  public static m a()
  {
    return d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */