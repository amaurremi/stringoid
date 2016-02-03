package com.badlogic.gdx.backends.android.a.a;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.Renderer;
import android.service.wallpaper.WallpaperService.Engine;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

public class d
  implements SurfaceHolder.Callback, c
{
  private final String a = "GLBaseSurfaceView";
  protected WallpaperService.Engine b;
  final m c = new m(this);
  boolean d = true;
  GLSurfaceView.EGLConfigChooser e;
  i f;
  j g;
  n h;
  int i;
  private l j;
  
  public d(WallpaperService.Engine paramEngine)
  {
    this.b = paramEngine;
    e();
  }
  
  private void g()
  {
    if (this.j != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  public void a()
  {
    this.j.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    a(new f(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void a(GLSurfaceView.EGLConfigChooser paramEGLConfigChooser)
  {
    g();
    this.e = paramEGLConfigChooser;
  }
  
  public void a(GLSurfaceView.Renderer paramRenderer)
  {
    g();
    if (this.e == null) {
      this.e = new p(this, true);
    }
    if (this.f == null) {
      this.f = new g(this);
    }
    if (this.g == null) {
      this.g = new h(this);
    }
    this.j = new l(this, paramRenderer);
    this.j.start();
  }
  
  public void a(i parami)
  {
    g();
    this.f = parami;
  }
  
  public void b()
  {
    this.j.d();
  }
  
  public void c()
  {
    this.j.e();
  }
  
  public void d()
  {
    this.j.f();
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
    this.j.a(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.j.b();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.j.c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */