package com.badlogic.gdx.backends.android.b;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.Renderer;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import java.lang.ref.WeakReference;

public class j
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private static final t b = new t(null);
  final ag a;
  private final WeakReference<j> c;
  private s d;
  private GLSurfaceView.Renderer e;
  private boolean f;
  private GLSurfaceView.EGLConfigChooser g;
  private p h;
  private q i;
  private u j;
  private int k;
  private int l;
  private boolean m;
  
  private void e()
  {
    if (this.d != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  public void a()
  {
    this.d.c();
  }
  
  public void b()
  {
    this.d.f();
  }
  
  public void c()
  {
    this.d.g();
  }
  
  protected void finalize()
  {
    try
    {
      if (this.d != null) {
        this.d.h();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getDebugFlags()
  {
    return this.k;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.m;
  }
  
  public int getRenderMode()
  {
    return this.d.b();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.f) && (this.e != null)) {
      if (this.d == null) {
        break label74;
      }
    }
    label74:
    for (int n = this.d.b();; n = 1)
    {
      this.d = new s(this.c);
      if (n != 1) {
        this.d.a(n);
      }
      this.d.start();
      this.f = false;
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.d != null) {
      this.d.h();
    }
    this.f = true;
    super.onDetachedFromWindow();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    ah localah = this.a.a(paramInt1, paramInt2);
    setMeasuredDimension(localah.a, localah.b);
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser paramEGLConfigChooser)
  {
    e();
    this.g = paramEGLConfigChooser;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new w(this, paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    e();
    this.l = paramInt;
  }
  
  public void setEGLContextFactory(p paramp)
  {
    e();
    this.h = paramp;
  }
  
  public void setEGLWindowSurfaceFactory(q paramq)
  {
    e();
    this.i = paramq;
  }
  
  public void setGLWrapper(u paramu)
  {
    this.j = paramu;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.d.a(paramInt);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    e();
    if (this.g == null) {
      this.g = new w(this, true);
    }
    if (this.h == null) {
      this.h = new n(this, null);
    }
    if (this.i == null) {
      this.i = new o(null);
    }
    this.e = paramRenderer;
    this.d = new s(this.c);
    this.d.start();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.d.a(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.d.d();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.d.e();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */