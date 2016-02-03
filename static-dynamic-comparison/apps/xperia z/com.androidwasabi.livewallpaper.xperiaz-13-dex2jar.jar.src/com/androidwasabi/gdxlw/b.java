package com.androidwasabi.gdxlw;

import android.service.wallpaper.WallpaperService.Engine;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.badlogic.gdx.backends.android.a.d;
import com.badlogic.gdx.backends.android.a.f;

public class b
  extends WallpaperService.Engine
{
  protected com.badlogic.gdx.backends.android.a.a a = new com.badlogic.gdx.backends.android.a.a(paramAndroidWallpaperService, this);
  protected a b;
  protected com.badlogic.gdx.backends.android.a.a.c c;
  
  public b(AndroidWallpaperService paramAndroidWallpaperService, a parama, com.badlogic.gdx.backends.android.a parama1, boolean paramBoolean)
  {
    super(paramAndroidWallpaperService);
    this.a.a(parama, parama1, paramBoolean);
    this.b = parama;
    this.c = ((d)this.a.a()).m();
    setTouchEventsEnabled(true);
  }
  
  public void a()
  {
    this.a.c();
    this.c.b();
  }
  
  public void b()
  {
    this.a.d();
    this.c.c();
  }
  
  public void onCreate(SurfaceHolder paramSurfaceHolder)
  {
    super.onCreate(paramSurfaceHolder);
    this.b.a(isPreview());
  }
  
  public void onDestroy()
  {
    this.c.d();
    this.a.e();
    super.onDestroy();
  }
  
  public void onOffsetsChanged(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    this.a.a(new c(this, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramInt2));
    super.onOffsetsChanged(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramInt2);
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onSurfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    super.onSurfaceCreated(paramSurfaceHolder);
  }
  
  public void onSurfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.onSurfaceDestroyed(paramSurfaceHolder);
  }
  
  public void onTouchEvent(MotionEvent paramMotionEvent)
  {
    ((f)this.a.k()).a(paramMotionEvent);
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean) {
      b();
    }
    for (;;)
    {
      super.onVisibilityChanged(paramBoolean);
      return;
      a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/gdxlw/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */