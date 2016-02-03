package com.badlogic.gdx.backends.android.b;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.util.Log;
import java.io.Writer;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

class r
{
  EGL10 a;
  EGLDisplay b;
  EGLSurface c;
  EGLConfig d;
  EGLContext e;
  private WeakReference<j> f;
  
  public r(WeakReference<j> paramWeakReference)
  {
    this.f = paramWeakReference;
  }
  
  private void a(String paramString)
  {
    a(paramString, this.a.eglGetError());
  }
  
  public static void a(String paramString, int paramInt)
  {
    throw new RuntimeException(b(paramString, paramInt));
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    Log.w(paramString1, b(paramString2, paramInt));
  }
  
  public static String b(String paramString, int paramInt)
  {
    return paramString + " failed: " + a.a(paramInt);
  }
  
  private void g()
  {
    if ((this.c != null) && (this.c != EGL10.EGL_NO_SURFACE))
    {
      this.a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      j localj = (j)this.f.get();
      if (localj != null) {
        j.d(localj).a(this.a, this.b, this.c);
      }
      this.c = null;
    }
  }
  
  public void a()
  {
    this.a = ((EGL10)EGLContext.getEGL());
    this.b = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.b == EGL10.EGL_NO_DISPLAY) {
      throw new RuntimeException("eglGetDisplay failed");
    }
    Object localObject = new int[2];
    if (!this.a.eglInitialize(this.b, (int[])localObject)) {
      throw new RuntimeException("eglInitialize failed");
    }
    localObject = (j)this.f.get();
    if (localObject == null) {
      this.d = null;
    }
    for (this.e = null;; this.e = j.c((j)localObject).a(this.a, this.b, this.d))
    {
      if ((this.e == null) || (this.e == EGL10.EGL_NO_CONTEXT))
      {
        this.e = null;
        a("createContext");
      }
      this.c = null;
      return;
      this.d = j.b((j)localObject).chooseConfig(this.a, this.b);
    }
  }
  
  public boolean b()
  {
    if (this.a == null) {
      throw new RuntimeException("egl not initialized");
    }
    if (this.b == null) {
      throw new RuntimeException("eglDisplay not initialized");
    }
    if (this.d == null) {
      throw new RuntimeException("mEglConfig not initialized");
    }
    g();
    j localj = (j)this.f.get();
    if (localj != null) {}
    for (this.c = j.d(localj).a(this.a, this.b, this.d, localj.getHolder()); (this.c == null) || (this.c == EGL10.EGL_NO_SURFACE); this.c = null)
    {
      if (this.a.eglGetError() == 12299) {
        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
      }
      return false;
    }
    if (!this.a.eglMakeCurrent(this.b, this.c, this.c, this.e))
    {
      a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
      return false;
    }
    return true;
  }
  
  GL c()
  {
    GL localGL2 = this.e.getGL();
    j localj = (j)this.f.get();
    Object localObject = localGL2;
    GL localGL1;
    int i;
    if (localj != null)
    {
      localGL1 = localGL2;
      if (j.e(localj) != null) {
        localGL1 = j.e(localj).a(localGL2);
      }
      localObject = localGL1;
      if ((j.f(localj) & 0x3) != 0)
      {
        i = 0;
        if ((j.f(localj) & 0x1) != 0) {
          i = 1;
        }
        if ((j.f(localj) & 0x2) == 0) {
          break label106;
        }
      }
    }
    label106:
    for (localObject = new v();; localObject = null)
    {
      localObject = c.a(localGL1, i, (Writer)localObject);
      return (GL)localObject;
    }
  }
  
  public int d()
  {
    if (!this.a.eglSwapBuffers(this.b, this.c)) {
      return this.a.eglGetError();
    }
    return 12288;
  }
  
  public void e()
  {
    g();
  }
  
  public void f()
  {
    if (this.e != null)
    {
      j localj = (j)this.f.get();
      if (localj != null) {
        j.c(localj).a(this.a, this.b, this.e);
      }
      this.e = null;
    }
    if (this.b != null)
    {
      this.a.eglTerminate(this.b);
      this.b = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */