package com.badlogic.gdx.backends.android;

import android.os.Bundle;
import android.service.wallpaper.WallpaperService.Engine;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

public class o
  extends WallpaperService.Engine
{
  protected boolean a;
  protected int b;
  protected int c;
  protected int d;
  boolean e;
  float f;
  float g;
  float h;
  float i;
  int j;
  int k;
  
  private void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramInt1 == this.l.d) && (paramInt2 == this.l.e) && (paramInt3 == this.l.f)) {
      if (AndroidLiveWallpaperService.a) {
        Log.d("WallpaperService", " > surface is current, skipping surfaceChanged event");
      }
    }
    do
    {
      return;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
      if (this.l.i == this)
      {
        this.l.d = this.b;
        this.l.e = this.c;
        this.l.f = this.d;
        this.l.c.surfaceChanged(getSurfaceHolder(), this.l.d, this.l.e, this.l.f);
        return;
      }
    } while (!AndroidLiveWallpaperService.a);
    Log.d("WallpaperService", " > engine is not active, skipping surfaceChanged event");
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      if (this.a) {
        a();
      }
    }
    while (!AndroidLiveWallpaperService.a)
    {
      return;
      b();
      return;
    }
    Log.d("WallpaperService", " > visible state is current, skipping visibilityChanged event!");
  }
  
  public void a()
  {
    Object localObject = this.l;
    ((AndroidLiveWallpaperService)localObject).h += 1;
    boolean bool;
    if (AndroidLiveWallpaperService.a)
    {
      localObject = new StringBuilder().append(" > AndroidWallpaperEngine - onResume() ").append(hashCode()).append(", running: ").append(this.l.g).append(", linked: ");
      if (this.l.i == this)
      {
        bool = true;
        Log.d("WallpaperService", bool + ", visible: " + this.l.h);
      }
    }
    else
    {
      Log.i("WallpaperService", "engine resumed");
      if (this.l.i != null)
      {
        if (this.l.i == this) {
          break label224;
        }
        this.l.a(this);
        this.l.c.surfaceDestroyed(getSurfaceHolder());
        a(this.b, this.c, this.d, false);
        this.l.c.surfaceCreated(getSurfaceHolder());
      }
    }
    for (;;)
    {
      if (this.l.h == 1) {
        this.l.b.d();
      }
      d();
      c();
      return;
      bool = false;
      break;
      label224:
      a(this.b, this.c, this.d, false);
    }
  }
  
  public void b()
  {
    Object localObject = this.l;
    ((AndroidLiveWallpaperService)localObject).h -= 1;
    if (AndroidLiveWallpaperService.a)
    {
      localObject = new StringBuilder().append(" > AndroidWallpaperEngine - onPause() ").append(hashCode()).append(", running: ").append(this.l.g).append(", linked: ");
      if (this.l.i != this) {
        break label201;
      }
    }
    label201:
    for (boolean bool = true;; bool = false)
    {
      Log.d("WallpaperService", bool + ", visible: " + this.l.h);
      Log.i("WallpaperService", "engine paused");
      if (this.l.h >= this.l.g)
      {
        Log.e("WallpaperService", "wallpaper lifecycle error, counted too many visible engines! repairing..");
        this.l.h = Math.max(this.l.g - 1, 0);
      }
      if ((this.l.i != null) && (this.l.h == 0)) {
        this.l.b.c();
      }
      if (AndroidLiveWallpaperService.a) {
        Log.d("WallpaperService", " > AndroidWallpaperEngine - onPause() done!");
      }
      return;
    }
  }
  
  protected void c()
  {
    if ((this.l.i == this) && ((this.l.b.f instanceof v)) && (!this.e))
    {
      this.e = true;
      this.l.b.a(new p(this));
    }
  }
  
  protected void d()
  {
    if ((this.l.i == this) && ((this.l.b.f instanceof v)))
    {
      boolean bool = this.l.i.isPreview();
      this.l.b.a(new q(this, bool));
    }
  }
  
  public Bundle onCommand(String paramString, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (AndroidLiveWallpaperService.a)
    {
      localStringBuilder = new StringBuilder().append(" > AndroidWallpaperEngine - onCommand(").append(paramString).append(" ").append(paramInt1).append(" ").append(paramInt2).append(" ").append(paramInt3).append(" ").append(paramBundle).append(" ").append(paramBoolean).append(")").append(", linked: ");
      if (this.l.i != this) {
        break label126;
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      Log.d("WallpaperService", bool);
      return super.onCommand(paramString, paramInt1, paramInt2, paramInt3, paramBundle, paramBoolean);
    }
  }
  
  public void onCreate(SurfaceHolder paramSurfaceHolder)
  {
    StringBuilder localStringBuilder;
    if (AndroidLiveWallpaperService.a)
    {
      localStringBuilder = new StringBuilder().append(" > AndroidWallpaperEngine - onCreate() ").append(hashCode()).append(" running: ").append(this.l.g).append(", linked: ");
      if (this.l.i != this) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      Log.d("WallpaperService", bool + ", thread: " + Thread.currentThread().toString());
      super.onCreate(paramSurfaceHolder);
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onOffsetsChanged(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    this.e = false;
    this.f = paramFloat1;
    this.g = paramFloat2;
    this.h = paramFloat3;
    this.i = paramFloat4;
    this.j = paramInt1;
    this.k = paramInt2;
    c();
    super.onOffsetsChanged(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramInt2);
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder;
    if (AndroidLiveWallpaperService.a)
    {
      localStringBuilder = new StringBuilder().append(" > AndroidWallpaperEngine - onSurfaceChanged() isPreview: ").append(isPreview()).append(", ").append(hashCode()).append(", running: ").append(this.l.g).append(", linked: ");
      if (this.l.i != this) {
        break label136;
      }
    }
    label136:
    for (boolean bool = true;; bool = false)
    {
      Log.d("WallpaperService", bool + ", sufcace valid: " + getSurfaceHolder().getSurface().isValid());
      Log.i("WallpaperService", "engine surface changed");
      super.onSurfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
      a(paramInt1, paramInt2, paramInt3, true);
      return;
    }
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    Object localObject = this.l;
    ((AndroidLiveWallpaperService)localObject).g += 1;
    this.l.a(this);
    if (AndroidLiveWallpaperService.a)
    {
      localObject = new StringBuilder().append(" > AndroidWallpaperEngine - onSurfaceCreated() ").append(hashCode()).append(", running: ").append(this.l.g).append(", linked: ");
      if (this.l.i != this) {
        break label222;
      }
    }
    label222:
    for (boolean bool = true;; bool = false)
    {
      Log.d("WallpaperService", bool);
      Log.i("WallpaperService", "engine surface created");
      super.onSurfaceCreated(paramSurfaceHolder);
      if (this.l.g == 1) {
        this.l.h = 0;
      }
      if ((this.l.g != 1) || (this.l.b != null)) {
        break;
      }
      this.l.d = 0;
      this.l.e = 0;
      this.l.f = 0;
      this.l.b = new n(this.l);
      this.l.a();
      if (this.l.b.b != null) {
        break;
      }
      throw new Error("You must override 'AndroidLiveWallpaperService.onCreateApplication' method and call 'initialize' from its body.");
    }
    this.l.c = ((SurfaceHolder.Callback)this.l.b.b.a);
    getSurfaceHolder().removeCallback(this.l.c);
    this.b = this.l.d;
    this.c = this.l.e;
    this.d = this.l.f;
    if (this.l.g == 1) {
      this.l.c.surfaceCreated(paramSurfaceHolder);
    }
    for (;;)
    {
      d();
      c();
      return;
      this.l.c.surfaceDestroyed(paramSurfaceHolder);
      a(this.b, this.c, this.d, false);
      this.l.c.surfaceCreated(paramSurfaceHolder);
    }
  }
  
  public void onSurfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    Object localObject = this.l;
    ((AndroidLiveWallpaperService)localObject).g -= 1;
    if (AndroidLiveWallpaperService.a)
    {
      localObject = new StringBuilder().append(" > AndroidWallpaperEngine - onSurfaceDestroyed() ").append(hashCode()).append(", running: ").append(this.l.g).append(" ,linked: ");
      if (this.l.i != this) {
        break label202;
      }
    }
    label202:
    for (boolean bool = true;; bool = false)
    {
      Log.d("WallpaperService", bool + ", isVisible: " + this.a);
      Log.i("WallpaperService", "engine surface destroyed");
      if (this.l.g == 0) {
        this.l.b();
      }
      if ((this.l.i == this) && (this.l.c != null)) {
        this.l.c.surfaceDestroyed(paramSurfaceHolder);
      }
      this.b = 0;
      this.c = 0;
      this.d = 0;
      if (this.l.g == 0) {
        this.l.i = null;
      }
      super.onSurfaceDestroyed(paramSurfaceHolder);
      return;
    }
  }
  
  public void onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.l.i == this) {
      this.l.b.c.onTouch(null, paramMotionEvent);
    }
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    boolean bool = isVisible();
    if (AndroidLiveWallpaperService.a) {
      Log.d("WallpaperService", " > AndroidWallpaperEngine - onVisibilityChanged(paramVisible: " + paramBoolean + " reportedVisible: " + bool + ") " + hashCode() + ", sufcace valid: " + getSurfaceHolder().getSurface().isValid());
    }
    super.onVisibilityChanged(paramBoolean);
    if ((!bool) && (paramBoolean == true))
    {
      if (AndroidLiveWallpaperService.a) {
        Log.d("WallpaperService", " > fake visibilityChanged event! Android WallpaperService likes do that!");
      }
      return;
    }
    a(paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */