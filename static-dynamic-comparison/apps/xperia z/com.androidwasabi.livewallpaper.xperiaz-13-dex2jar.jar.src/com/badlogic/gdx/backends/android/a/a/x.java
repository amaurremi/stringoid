package com.badlogic.gdx.backends.android.a.a;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.view.SurfaceHolder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

class x
{
  EGLConfig a;
  private EGL10 c;
  private EGLDisplay d;
  private EGLSurface e;
  private EGLContext f;
  private GLSurfaceView.EGLConfigChooser g;
  private v h;
  private w i;
  private aa j;
  
  public x(q paramq, GLSurfaceView.EGLConfigChooser paramEGLConfigChooser, v paramv, w paramw, aa paramaa)
  {
    this.g = paramEGLConfigChooser;
    this.h = paramv;
    this.i = paramw;
    this.j = paramaa;
  }
  
  public GL a(SurfaceHolder paramSurfaceHolder)
  {
    if ((this.e != null) && (this.e != EGL10.EGL_NO_SURFACE))
    {
      this.c.eglMakeCurrent(this.d, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.i.a(this.c, this.d, this.e);
    }
    this.e = this.i.a(this.c, this.d, this.a, paramSurfaceHolder);
    if ((this.e == null) || (this.e == EGL10.EGL_NO_SURFACE)) {
      throw new RuntimeException("createWindowSurface failed");
    }
    if (!this.c.eglMakeCurrent(this.d, this.e, this.e, this.f)) {
      throw new RuntimeException("eglMakeCurrent failed.");
    }
    GL localGL = this.f.getGL();
    paramSurfaceHolder = localGL;
    if (this.j != null) {
      paramSurfaceHolder = this.j.a(localGL);
    }
    return paramSurfaceHolder;
  }
  
  public void a()
  {
    if (this.c == null) {
      this.c = ((EGL10)EGLContext.getEGL());
    }
    if (this.d == null) {
      this.d = this.c.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    }
    if (this.a == null)
    {
      int[] arrayOfInt = new int[2];
      this.c.eglInitialize(this.d, arrayOfInt);
      this.a = this.g.chooseConfig(this.c, this.d);
    }
    if (this.f == null)
    {
      this.f = this.h.a(this.c, this.d, this.a);
      if ((this.f == null) || (this.f == EGL10.EGL_NO_CONTEXT)) {
        throw new RuntimeException("createContext failed");
      }
    }
    this.e = null;
  }
  
  public boolean b()
  {
    this.c.eglSwapBuffers(this.d, this.e);
    return this.c.eglGetError() != 12302;
  }
  
  public void c()
  {
    if ((this.e != null) && (this.e != EGL10.EGL_NO_SURFACE))
    {
      this.c.eglMakeCurrent(this.d, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.i.a(this.c, this.d, this.e);
      this.e = null;
    }
  }
  
  public void d()
  {
    if (this.f != null)
    {
      this.h.a(this.c, this.d, this.f);
      this.f = null;
    }
    if (this.d != null)
    {
      this.c.eglTerminate(this.d);
      this.d = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */