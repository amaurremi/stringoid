package com.gau.go.launcherex.goweather.livewallpaper;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import com.jiubang.core.a.l;

public class f
{
  private l a;
  private volatile l b = null;
  private Paint c;
  private volatile int d;
  private Canvas e;
  private Bitmap f;
  private boolean g;
  private Handler h;
  private com.gau.go.launcherex.goweather.livewallpaper.b.e i;
  
  public f(com.gau.go.launcherex.goweather.livewallpaper.b.e parame)
  {
    this.i = parame;
  }
  
  private void e()
  {
    this.h = new g(this);
  }
  
  private void f()
  {
    this.d = 0;
  }
  
  public void a()
  {
    this.d = 0;
    this.c = new Paint();
    e();
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint, float paramFloat, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramCanvas, this.a.f(), this.a.g(), paramFloat, paramInt, 255, this.g);
    }
    if ((this.b != null) && (this.f != null))
    {
      this.d = ((int)(this.d + 35L));
      if (this.d > 255) {
        this.d = 255;
      }
      this.c.setAlpha(this.d);
      this.b.a(this.e, this.b.f(), this.b.g(), paramFloat, paramInt, 255, this.g);
      paramCanvas.drawBitmap(this.f, 0.0F, 0.0F, this.c);
      if (this.d >= 255)
      {
        this.d = 0;
        paramCanvas = this.h.obtainMessage();
        paramCanvas.what = 2;
        paramCanvas.obj = this.a;
        this.h.sendMessage(paramCanvas);
        this.a = this.b;
        this.b = null;
      }
    }
  }
  
  public void a(l paraml, boolean paramBoolean)
  {
    this.g = paramBoolean;
    if (this.f == null)
    {
      this.f = Bitmap.createBitmap(com.jiubang.core.a.e.a(), com.jiubang.core.a.e.b(), Bitmap.Config.ARGB_8888);
      this.e = new Canvas(this.f);
    }
    if ((this.b == null) && (this.a == null))
    {
      this.a = paraml;
      this.a.a(0, 0, com.jiubang.core.a.e.a(), com.jiubang.core.a.e.b());
      this.i.a(this.g);
      return;
    }
    if (this.d == 0)
    {
      this.b = paraml;
      this.b.a(0, 0, com.jiubang.core.a.e.a(), com.jiubang.core.a.e.b());
    }
    for (;;)
    {
      f();
      return;
      this.b.h();
      this.b = paraml;
      this.b.a(0, 0, com.jiubang.core.a.e.a(), com.jiubang.core.a.e.b());
    }
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      bool1 = bool2;
      if (this.a.c())
      {
        bool1 = bool2;
        if (this.a.a(paramLong)) {
          bool1 = true;
        }
      }
    }
    bool2 = bool1;
    if (this.b != null)
    {
      bool2 = bool1;
      if (this.b.c())
      {
        bool2 = bool1;
        if (this.b.a(paramLong)) {
          bool2 = true;
        }
      }
    }
    if ((!bool2) && (this.a != null) && (this.b != null)) {
      return true;
    }
    return bool2;
  }
  
  public void b()
  {
    if (this.a != null)
    {
      this.a.h();
      this.a = null;
    }
    if (this.b != null)
    {
      this.b.h();
      this.b = null;
    }
    if ((this.f != null) && (!this.f.isRecycled()))
    {
      this.f.recycle();
      this.f = null;
    }
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.q();
    }
  }
  
  public void d()
  {
    if (this.a != null) {
      this.a.p();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */