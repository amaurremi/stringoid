package com.badlogic.gdx.backends.android.a.a;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.view.SurfaceHolder;
import com.badlogic.gdx.backends.android.b.c;
import java.io.Writer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

class k
{
  EGL10 a;
  EGLDisplay b;
  EGLSurface c;
  EGLConfig d;
  EGLContext e;
  
  public k(d paramd) {}
  
  private void a(String paramString)
  {
    throw new RuntimeException(paramString + " failed: " + this.a.eglGetError());
  }
  
  public GL a(SurfaceHolder paramSurfaceHolder)
  {
    if ((this.c != null) && (this.c != EGL10.EGL_NO_SURFACE))
    {
      this.a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.f.g.a(this.a, this.b, this.c);
    }
    this.c = this.f.g.a(this.a, this.b, this.d, paramSurfaceHolder);
    if ((this.c == null) || (this.c == EGL10.EGL_NO_SURFACE)) {
      a("createWindowSurface");
    }
    if (!this.a.eglMakeCurrent(this.b, this.c, this.c, this.e)) {
      a("eglMakeCurrent");
    }
    Object localObject = this.e.getGL();
    paramSurfaceHolder = (SurfaceHolder)localObject;
    if (this.f.h != null) {
      paramSurfaceHolder = this.f.h.a((GL)localObject);
    }
    localObject = paramSurfaceHolder;
    if ((this.f.i & 0x3) != 0)
    {
      int i = 0;
      localObject = null;
      if ((this.f.i & 0x1) != 0) {
        i = 1;
      }
      if ((this.f.i & 0x2) != 0) {
        localObject = new o(this.f);
      }
      localObject = c.a(paramSurfaceHolder, i, (Writer)localObject);
    }
    return (GL)localObject;
  }
  
  public void a()
  {
    this.a = ((EGL10)EGLContext.getEGL());
    this.b = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int[] arrayOfInt = new int[2];
    this.a.eglInitialize(this.b, arrayOfInt);
    this.d = this.f.e.chooseConfig(this.a, this.b);
    this.e = this.f.f.a(this.a, this.b, this.d);
    if ((this.e == null) || (this.e == EGL10.EGL_NO_CONTEXT)) {
      throw new RuntimeException("createContext failed");
    }
    this.c = null;
  }
  
  public boolean b()
  {
    this.a.eglSwapBuffers(this.b, this.c);
    return this.a.eglGetError() != 12302;
  }
  
  public void c()
  {
    if ((this.c != null) && (this.c != EGL10.EGL_NO_SURFACE))
    {
      this.a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.f.g.a(this.a, this.b, this.c);
      this.c = null;
    }
  }
  
  public void d()
  {
    if (this.e != null)
    {
      this.f.f.a(this.a, this.b, this.e);
      this.e = null;
    }
    if (this.b != null)
    {
      this.a.eglTerminate(this.b);
      this.b = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */