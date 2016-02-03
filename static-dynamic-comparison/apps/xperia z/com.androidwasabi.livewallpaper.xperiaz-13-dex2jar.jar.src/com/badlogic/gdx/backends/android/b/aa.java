package com.badlogic.gdx.backends.android.b;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.view.SurfaceHolder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

class aa
{
  EGL10 a;
  EGLDisplay b;
  EGLSurface c;
  EGLConfig d;
  EGLContext e;
  
  public aa(x paramx) {}
  
  public GL a(SurfaceHolder paramSurfaceHolder)
  {
    if (this.c != null)
    {
      this.a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.a.eglDestroySurface(this.b, this.c);
    }
    this.c = this.a.eglCreateWindowSurface(this.b, this.d, paramSurfaceHolder, null);
    this.a.eglMakeCurrent(this.b, this.c, this.c, this.e);
    GL localGL = this.e.getGL();
    paramSurfaceHolder = localGL;
    if (this.f.d != null) {
      paramSurfaceHolder = this.f.d.a(localGL);
    }
    return paramSurfaceHolder;
  }
  
  public void a()
  {
    this.a = ((EGL10)EGLContext.getEGL());
    this.b = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int[] arrayOfInt = new int[2];
    this.a.eglInitialize(this.b, arrayOfInt);
    this.d = this.f.c.chooseConfig(this.a, this.b);
    this.e = this.a.eglCreateContext(this.b, this.d, EGL10.EGL_NO_CONTEXT, null);
    this.c = null;
  }
  
  public boolean b()
  {
    this.a.eglSwapBuffers(this.b, this.c);
    return this.a.eglGetError() != 12302;
  }
  
  public void c()
  {
    if (this.c != null)
    {
      this.a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.a.eglDestroySurface(this.b, this.c);
      this.c = null;
    }
    if (this.e != null)
    {
      this.a.eglDestroyContext(this.b, this.e);
      this.e = null;
    }
    if (this.b != null)
    {
      this.a.eglTerminate(this.b);
      this.b = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */