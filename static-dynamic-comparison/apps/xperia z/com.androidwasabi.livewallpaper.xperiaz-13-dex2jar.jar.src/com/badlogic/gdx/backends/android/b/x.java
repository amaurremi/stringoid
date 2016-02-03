package com.badlogic.gdx.backends.android.b;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.Renderer;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class x
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  static final Object b = new Object();
  final ag a;
  GLSurfaceView.EGLConfigChooser c;
  ac d;
  private ab e;
  private int f;
  private int g;
  private GLSurfaceView.Renderer h;
  private int i;
  private int j;
  private boolean k;
  
  public void a()
  {
    ab localab = this.e;
    if (localab != null) {
      localab.a();
    }
  }
  
  public void b()
  {
    this.e.d();
    this.e.f();
    this.e = null;
  }
  
  public void c()
  {
    if (this.c == null) {
      this.c = new ad(true);
    }
    this.e = new ab(this, this.h);
    this.e.start();
    this.e.a(this.g);
    if (this.k) {
      this.e.b();
    }
    if ((this.i > 0) && (this.j > 0)) {
      this.e.a(this.i, this.j);
    }
    this.e.e();
  }
  
  public int getDebugFlags()
  {
    return this.f;
  }
  
  public int getRenderMode()
  {
    return this.g;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    ah localah = this.a.a(paramInt1, paramInt2);
    setMeasuredDimension(localah.a, localah.b);
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser paramEGLConfigChooser)
  {
    if (this.h != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
    this.c = paramEGLConfigChooser;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new ad(paramBoolean));
  }
  
  public void setGLWrapper(ac paramac)
  {
    this.d = paramac;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.g = paramInt;
    if (this.e != null) {
      this.e.a(paramInt);
    }
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    if (this.h != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
    this.h = paramRenderer;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.e != null) {
      this.e.a(paramInt2, paramInt3);
    }
    this.i = paramInt2;
    this.j = paramInt3;
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.e != null) {
      this.e.b();
    }
    this.k = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.e != null) {
      this.e.c();
    }
    this.k = false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */