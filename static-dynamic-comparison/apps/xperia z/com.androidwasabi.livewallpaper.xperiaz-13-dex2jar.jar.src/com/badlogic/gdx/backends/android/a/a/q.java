package com.badlogic.gdx.backends.android.a.a;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.Renderer;
import android.service.wallpaper.WallpaperService.Engine;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

public class q
  implements SurfaceHolder.Callback, c
{
  private final String a = "GLBaseSurfaceViewLWPC";
  protected WallpaperService.Engine b;
  private y c;
  private GLSurfaceView.EGLConfigChooser d;
  private v e;
  private w f;
  private aa g;
  
  public q(WallpaperService.Engine paramEngine)
  {
    this.b = paramEngine;
    e();
  }
  
  private void g()
  {
    if (this.c != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  public void a()
  {
    this.c.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    a(new s(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void a(GLSurfaceView.EGLConfigChooser paramEGLConfigChooser)
  {
    g();
    this.d = paramEGLConfigChooser;
  }
  
  public void a(GLSurfaceView.Renderer paramRenderer)
  {
    g();
    if (this.d == null) {
      this.d = new ab(this, true);
    }
    if (this.e == null) {
      this.e = new t(this);
    }
    if (this.f == null) {
      this.f = new u(this);
    }
    this.c = new y(this, paramRenderer, this.d, this.e, this.f, this.g);
    this.c.start();
  }
  
  public void a(v paramv)
  {
    g();
    this.e = paramv;
  }
  
  public void b()
  {
    this.c.c();
  }
  
  public void c()
  {
    this.c.d();
  }
  
  public void d()
  {
    this.c.e();
  }
  
  protected void e()
  {
    f().addCallback(this);
  }
  
  public SurfaceHolder f()
  {
    return this.b.getSurfaceHolder();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c.a(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.c.a(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.c.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */