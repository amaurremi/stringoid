package com.gau.go.launcherex.goweather.livewallpaper;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.service.wallpaper.WallpaperService.Engine;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.gau.go.launcherex.goweather.livewallpaper.b.h;
import java.util.ArrayList;

class d
  extends WallpaperService.Engine
  implements GestureDetector.OnGestureListener
{
  private GestureDetector b;
  private final Handler c = new Handler();
  private Paint d;
  private boolean e = false;
  private boolean f;
  private float g = 0.0F;
  private int h;
  private final Runnable i = new e(this);
  
  d(GOWeatherWallpaperService paramGOWeatherWallpaperService)
  {
    super(paramGOWeatherWallpaperService);
  }
  
  private boolean a(long paramLong)
  {
    boolean bool1 = false;
    if (GOWeatherWallpaperService.b(this.a).a(paramLong)) {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (!GOWeatherWallpaperService.c(this.a))
    {
      bool2 = bool1;
      if (this.h > 0)
      {
        this.h -= 1;
        bool2 = bool1 | true;
      }
    }
    return bool2;
  }
  
  private void b()
  {
    SurfaceHolder localSurfaceHolder = getSurfaceHolder();
    long l = System.currentTimeMillis();
    Object localObject = null;
    try
    {
      Canvas localCanvas = localSurfaceHolder.lockCanvas();
      localObject = localCanvas;
    }
    catch (Exception localException2)
    {
      try
      {
        localSurfaceHolder.unlockCanvasAndPost((Canvas)localObject);
        this.c.removeCallbacks(this.i);
        l = System.currentTimeMillis() - l;
        if ((!this.e) || ((!GOWeatherWallpaperService.c(this.a)) && (this.h <= 0))) {
          break label281;
        }
        if (l >= 25L) {
          break label267;
        }
        this.c.postDelayed(this.i, 25L - l);
        return;
        localException2 = localException2;
        localException2.printStackTrace();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
        }
        label267:
        this.c.postDelayed(this.i, 1L);
        return;
      }
    }
    if (localObject != null) {
      if (a(l))
      {
        ((Canvas)localObject).drawRect(0.0F, 0.0F, GOWeatherWallpaperService.d(this.a), GOWeatherWallpaperService.e(this.a), this.d);
        if (GOWeatherWallpaperService.f(this.a))
        {
          ((Canvas)localObject).rotate(GOWeatherWallpaperService.g(this.a), GOWeatherWallpaperService.h(this.a), GOWeatherWallpaperService.i(this.a));
          ((Canvas)localObject).translate(GOWeatherWallpaperService.j(this.a), GOWeatherWallpaperService.k(this.a));
        }
        ((Canvas)localObject).save();
        ((Canvas)localObject).translate(this.g, 0.0F);
        GOWeatherWallpaperService.b(this.a).a((Canvas)localObject, this.d, this.g, GOWeatherWallpaperService.d(this.a));
        ((Canvas)localObject).restore();
        GOWeatherWallpaperService.l(this.a).a((Canvas)localObject, this.d);
      }
    }
    label281:
    this.c.removeCallbacks(this.i);
  }
  
  public void a()
  {
    this.c.removeCallbacks(this.i);
    this.c.post(this.i);
  }
  
  public void a(float paramFloat)
  {
    this.g = ((GOWeatherWallpaperService.d(this.a) - paramFloat) * 0.5F);
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.e) && (!paramBoolean) && (this.h <= 0))
    {
      this.c.removeCallbacks(this.i);
      this.c.post(this.i);
    }
  }
  
  public void onCreate(SurfaceHolder paramSurfaceHolder)
  {
    super.onCreate(paramSurfaceHolder);
    setTouchEventsEnabled(true);
    this.b = new GestureDetector(this.a.getApplicationContext(), this);
    this.d = new Paint();
    this.d.setAntiAlias(true);
    this.d.setAlpha(255);
    this.h = 20;
    if ((!GOWeatherWallpaperService.a(this.a)) && (!isPreview()))
    {
      GOWeatherWallpaperService.a(this.a, true);
      paramSurfaceHolder = this.a.getApplicationContext();
      if (h.c(paramSurfaceHolder)) {
        h.b(paramSurfaceHolder);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.c.removeCallbacks(this.i);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public void onOffsetsChanged(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    if ((!isPreview()) && (!GOWeatherWallpaperService.p(this.a)) && (!this.f))
    {
      this.g = ((GOWeatherWallpaperService.d(this.a) - com.jiubang.core.a.e.a()) * paramFloat1);
      a(GOWeatherWallpaperService.c(this.a));
      GOWeatherWallpaperService.q(this.a);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 > 0) && (paramInt3 > 0) && ((GOWeatherWallpaperService.m(this.a) != paramInt2) || (GOWeatherWallpaperService.n(this.a) != paramInt3))) || (this.f != GOWeatherWallpaperService.f(this.a)))
    {
      if (paramInt2 >= paramInt3) {
        break label124;
      }
      this.f = false;
      GOWeatherWallpaperService.a(this.a, paramInt2);
      GOWeatherWallpaperService.b(this.a, paramInt3);
      GOWeatherWallpaperService.a(this.a, paramInt2, paramInt3);
      if (GOWeatherWallpaperService.c(this.a)) {
        break label132;
      }
    }
    label124:
    label132:
    for (this.h = 20;; this.h = 0)
    {
      if ((this.e) && (!GOWeatherWallpaperService.c(this.a))) {
        a();
      }
      return;
      this.f = true;
      break;
    }
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    super.onSurfaceCreated(paramSurfaceHolder);
    b();
  }
  
  public void onSurfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.onSurfaceDestroyed(paramSurfaceHolder);
    this.e = false;
    this.c.removeCallbacks(this.i);
    GOWeatherWallpaperService.o(this.a).remove(this);
  }
  
  public void onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    this.b.onTouchEvent(paramMotionEvent);
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    super.onVisibilityChanged(paramBoolean);
    this.e = paramBoolean;
    if (paramBoolean)
    {
      if (!GOWeatherWallpaperService.c(this.a)) {}
      for (int j = 20;; j = 0)
      {
        this.h = j;
        b();
        GOWeatherWallpaperService.b(this.a).c();
        return;
      }
    }
    this.c.removeCallbacks(this.i);
    GOWeatherWallpaperService.b(this.a).d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */