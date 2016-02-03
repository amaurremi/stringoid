package com.androidwasabi.livewallpaper.xperiaz;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.service.wallpaper.WallpaperService;
import com.androidwasabi.a.d;
import com.badlogic.gdx.h;
import java.util.Random;

public class t
  extends com.androidwasabi.gdxlw.a
{
  v b = v.a;
  Boolean c = Boolean.valueOf(false);
  WallpaperService d;
  SharedPreferences e;
  com.badlogic.gdx.graphics.j f;
  com.badlogic.gdx.graphics.g2d.a g;
  com.badlogic.gdx.math.g h;
  float i = 0.0F;
  j j = new j();
  int k = 30;
  int l = 0;
  long m = 0L;
  long n = 0L;
  float o = 0.0F;
  k p;
  boolean q;
  boolean r;
  l[] s = null;
  int t = 20;
  float u = 1.0F;
  float v = 1.0F;
  boolean w = true;
  int x = 0;
  u y;
  com.badlogic.gdx.d.a z;
  
  public t(WallpaperService paramWallpaperService)
  {
    this.d = paramWallpaperService;
    this.e = paramWallpaperService.getSharedPreferences("settings", 0);
  }
  
  private void g()
  {
    Boolean localBoolean = d.a;
    if (this.d.getResources().getConfiguration().orientation == 2) {}
    for (boolean bool = true;; bool = false)
    {
      d.a(Boolean.valueOf(bool));
      if (d.a != localBoolean) {
        this.b = v.a;
      }
      return;
    }
  }
  
  private void h()
  {
    if (!"https://play.google.com/store/apps/details?id=com.androidwasabi.livewallpaper.xperiaz".substring(46).equals(this.d.getPackageName())) {
      return;
    }
    this.h = new com.badlogic.gdx.math.g();
    this.p = new k(d.a() / 2.0F - d.c() / 2.0F, d.b() / 2.0F - d.c() / 2.0F, d.c(), d.c());
    this.p.a(s.a);
    Random localRandom = new Random();
    this.s = new l[this.t];
    int i1 = 0;
    for (;;)
    {
      if (i1 >= this.s.length)
      {
        this.y.a(5);
        return;
      }
      float f1 = (localRandom.nextFloat() * 20.0F + 6.0F) * this.u;
      float f2 = localRandom.nextFloat();
      float f3 = d.a();
      float f4 = localRandom.nextFloat();
      float f5 = d.b() / 4.0F;
      float f6 = d.b() / 4.0F;
      this.s[i1] = new l(f2 * f3, f4 * (f5 * 2.0F) + f6, f1, f1);
      this.s[i1].a(0.0F, localRandom.nextFloat() * 0.4F + 0.6F, localRandom.nextFloat() * 1.6F + 0.4F, true);
      this.s[i1].a.a(localRandom.nextFloat() * 70.0F + 10.0F, localRandom.nextFloat() * 15.0F + 5.0F);
      this.s[i1].b.a(localRandom.nextFloat() * 1.0F, localRandom.nextFloat() * 1.0F);
      this.s[i1].i = (localRandom.nextFloat() * 0.6F + 0.4F);
      i1 += 1;
    }
  }
  
  public void a()
  {
    this.j.a();
    this.y = new u(this);
    this.z = new com.badlogic.gdx.d.a(this.y);
    com.badlogic.gdx.g.d.a(this.z);
    if (this.d.getResources().getConfiguration().orientation == 2) {}
    for (boolean bool = true;; bool = false)
    {
      d.a(Boolean.valueOf(bool));
      if (this.d.getPackageName().length() == 39) {
        this.e.registerOnSharedPreferenceChangeListener(this);
      }
      onSharedPreferenceChanged(this.e, "");
      return;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    if (this.b != v.b) {}
    for (;;)
    {
      return;
      if (this.x > 3) {
        this.w = false;
      }
      while (!this.w)
      {
        if (!this.a) {
          break label80;
        }
        this.o = ((d.a() - d.c()) / 2.0F);
        this.p.g.d = this.o;
        return;
        this.x += 1;
      }
      continue;
      label80:
      if (this.q) {}
      for (this.o = ((d.a() - d.c()) * paramFloat1); this.o != 0.0F; this.o = ((d.a() - d.c()) / 2.0F))
      {
        this.p.g.d = this.o;
        return;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    g();
  }
  
  public void b() {}
  
  public void c()
  {
    if (this.b == v.a) {
      f();
    }
    if (this.b != v.b) {
      return;
    }
    this.i = (com.badlogic.gdx.g.b.g() * this.v);
    com.badlogic.gdx.g.g.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    com.badlogic.gdx.g.g.glClear(16384);
    this.g.f();
    this.g.b();
    this.p.a();
    this.p.a(this.g, this.j.d);
    this.g.d();
    this.g.g();
    this.g.b();
    this.g.a(770, 1);
    int i1 = 0;
    for (;;)
    {
      if (i1 >= this.s.length)
      {
        this.g.a(770, 771);
        this.g.d();
        try
        {
          this.n = (System.currentTimeMillis() - this.m);
          if (this.n >= this.l) {
            break;
          }
          Thread.sleep(this.l - this.n);
          this.m = System.currentTimeMillis();
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          return;
        }
      }
      this.s[i1].a(this.i);
      this.s[i1].b(this.i);
      this.s[i1].a(this.g, this.j.e);
      i1 += 1;
    }
    this.m = System.currentTimeMillis();
  }
  
  public void d()
  {
    this.x = 0;
  }
  
  public void e() {}
  
  public void f()
  {
    this.j.a(this.e.getBoolean("smooth", true));
    if (this.d.getPackageName().hashCode() != 990862200) {
      return;
    }
    d.a(800, 480);
    if (this.f == null) {
      this.f = new com.badlogic.gdx.graphics.j(d.a(), d.b());
    }
    this.f.j = d.a();
    this.f.k = d.b();
    this.f.a.a(d.a() / 2, d.b() / 2, 0.0F);
    this.f.a();
    if (this.g == null) {
      this.g = new com.badlogic.gdx.graphics.g2d.a();
    }
    this.g.a(this.f.f);
    h();
    this.c = Boolean.valueOf(true);
    this.b = v.b;
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (!"https://play.google.com/store/apps/details?id=com.androidwasabi.livewallpaper.xperiaz".substring(46).equals(this.d.getPackageName())) {}
    do
    {
      return;
      if (paramString.equals(""))
      {
        s.a(this.e.getString("color", "5"));
        this.t = Integer.valueOf(this.e.getString("quantity", "20")).intValue();
        this.u = Float.valueOf(this.e.getString("size", "1")).floatValue();
        this.v = Float.valueOf(this.e.getString("speed", "1")).floatValue();
        this.r = this.e.getBoolean("touch", false);
        this.q = this.e.getBoolean("scrolling", true);
        this.k = Integer.valueOf(this.e.getString("fps", "30")).intValue();
        this.m = System.currentTimeMillis();
        this.l = (1000 / this.k);
        this.b = v.a;
        return;
      }
      if (paramString.equals("smooth"))
      {
        this.b = v.a;
        return;
      }
      if (paramString.equals("fps"))
      {
        this.k = Integer.valueOf(this.e.getString("fps", "30")).intValue();
        this.m = System.currentTimeMillis();
        this.l = (1000 / this.k);
        return;
      }
      if (paramString.equals("color"))
      {
        s.a(this.e.getString("color", "5"));
        this.b = v.a;
        return;
      }
      if (paramString.equals("quantity"))
      {
        this.t = Integer.valueOf(this.e.getString("quantity", "20")).intValue();
        this.b = v.a;
        return;
      }
      if (paramString.equals("size"))
      {
        this.u = Float.valueOf(this.e.getString("size", "1")).floatValue();
        this.b = v.a;
        return;
      }
      if (paramString.equals("speed"))
      {
        this.v = Float.valueOf(this.e.getString("speed", "1")).floatValue();
        return;
      }
      if (paramString.equals("touch"))
      {
        this.r = this.e.getBoolean("touch", false);
        return;
      }
    } while (!paramString.equals("scrolling"));
    this.q = this.e.getBoolean("scrolling", true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */