package com.badlogic.gdx.backends.android.b;

import java.io.IOException;
import java.io.Writer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class a
  implements EGL11
{
  Writer a;
  boolean b;
  boolean c;
  private EGL10 d;
  private int e;
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return c(paramInt);
    case 12288: 
      return "EGL_SUCCESS";
    case 12289: 
      return "EGL_NOT_INITIALIZED";
    case 12290: 
      return "EGL_BAD_ACCESS";
    case 12291: 
      return "EGL_BAD_ALLOC";
    case 12292: 
      return "EGL_BAD_ATTRIBUTE";
    case 12293: 
      return "EGL_BAD_CONFIG";
    case 12294: 
      return "EGL_BAD_CONTEXT";
    case 12295: 
      return "EGL_BAD_CURRENT_SURFACE";
    case 12296: 
      return "EGL_BAD_DISPLAY";
    case 12297: 
      return "EGL_BAD_MATCH";
    case 12298: 
      return "EGL_BAD_NATIVE_PIXMAP";
    case 12299: 
      return "EGL_BAD_NATIVE_WINDOW";
    case 12300: 
      return "EGL_BAD_PARAMETER";
    case 12301: 
      return "EGL_BAD_SURFACE";
    }
    return "EGL_CONTEXT_LOST";
  }
  
  private String a(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\n");
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < paramInt1)
    {
      int k = paramInt2 + i;
      localStringBuilder.append(" [" + k + "] = ");
      if ((k < 0) || (k >= j)) {
        localStringBuilder.append("out of bounds");
      }
      for (;;)
      {
        localStringBuilder.append('\n');
        i += 1;
        break;
        localStringBuilder.append(paramArrayOfInt[k]);
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private String a(int paramInt1, Object[] paramArrayOfObject, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\n");
    int j = paramArrayOfObject.length;
    int i = 0;
    if (i < paramInt1)
    {
      int k = paramInt2 + i;
      localStringBuilder.append(" [" + k + "] = ");
      if ((k < 0) || (k >= j)) {
        localStringBuilder.append("out of bounds");
      }
      for (;;)
      {
        localStringBuilder.append('\n');
        i += 1;
        break;
        localStringBuilder.append(paramArrayOfObject[k]);
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    int i = this.d.eglGetError();
    if (i != 12288)
    {
      String str = "eglError: " + a(i);
      a(str);
      if (this.c) {
        throw new e(i, str);
      }
    }
  }
  
  private void a(Object paramObject)
  {
    d(b(paramObject));
  }
  
  private void a(String paramString)
  {
    b(paramString + '\n');
  }
  
  private void a(String paramString, int paramInt)
  {
    a(paramString, Integer.toString(paramInt));
  }
  
  private void a(String paramString, Object paramObject)
  {
    a(paramString, b(paramObject));
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i = this.e;
    this.e = (i + 1);
    if (i > 0) {
      b(", ");
    }
    if (this.b) {
      b(paramString1 + "=");
    }
    b(paramString2);
  }
  
  private void a(String paramString, EGLContext paramEGLContext)
  {
    if (paramEGLContext == EGL10.EGL_NO_CONTEXT)
    {
      a(paramString, "EGL10.EGL_NO_CONTEXT");
      return;
    }
    a(paramString, b(paramEGLContext));
  }
  
  private void a(String paramString, EGLDisplay paramEGLDisplay)
  {
    if (paramEGLDisplay == EGL10.EGL_DEFAULT_DISPLAY)
    {
      a(paramString, "EGL10.EGL_DEFAULT_DISPLAY");
      return;
    }
    if (paramEGLDisplay == EGL_NO_DISPLAY)
    {
      a(paramString, "EGL10.EGL_NO_DISPLAY");
      return;
    }
    a(paramString, b(paramEGLDisplay));
  }
  
  private void a(String paramString, EGLSurface paramEGLSurface)
  {
    if (paramEGLSurface == EGL10.EGL_NO_SURFACE)
    {
      a(paramString, "EGL10.EGL_NO_SURFACE");
      return;
    }
    a(paramString, b(paramEGLSurface));
  }
  
  private void a(String paramString, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null)
    {
      a(paramString, "null");
      return;
    }
    a(paramString, a(paramArrayOfInt.length, paramArrayOfInt, 0));
  }
  
  private void a(String paramString, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
    {
      a(paramString, "null");
      return;
    }
    a(paramString, a(paramArrayOfObject.length, paramArrayOfObject, 0));
  }
  
  private void a(boolean paramBoolean)
  {
    d(Boolean.toString(paramBoolean));
  }
  
  private String b(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    return paramObject.toString();
  }
  
  private void b()
  {
    b(");\n");
    c();
  }
  
  private void b(int paramInt)
  {
    d(Integer.toString(paramInt));
  }
  
  private void b(String paramString)
  {
    try
    {
      this.a.write(paramString);
      return;
    }
    catch (IOException paramString) {}
  }
  
  private static String c(int paramInt)
  {
    return "0x" + Integer.toHexString(paramInt);
  }
  
  private void c()
  {
    try
    {
      this.a.flush();
      return;
    }
    catch (IOException localIOException)
    {
      this.a = null;
    }
  }
  
  private void c(String paramString)
  {
    b(paramString + '(');
    this.e = 0;
  }
  
  private void d(String paramString)
  {
    b(" returns " + paramString + ";\n");
    c();
  }
  
  public boolean eglChooseConfig(EGLDisplay paramEGLDisplay, int[] paramArrayOfInt1, EGLConfig[] paramArrayOfEGLConfig, int paramInt, int[] paramArrayOfInt2)
  {
    c("eglChooseConfig");
    a("display", paramEGLDisplay);
    a("attrib_list", paramArrayOfInt1);
    a("config_size", paramInt);
    b();
    boolean bool = this.d.eglChooseConfig(paramEGLDisplay, paramArrayOfInt1, paramArrayOfEGLConfig, paramInt, paramArrayOfInt2);
    a("configs", paramArrayOfEGLConfig);
    a("num_config", paramArrayOfInt2);
    a(bool);
    a();
    return bool;
  }
  
  public boolean eglCopyBuffers(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface, Object paramObject)
  {
    c("eglCopyBuffers");
    a("display", paramEGLDisplay);
    a("surface", paramEGLSurface);
    a("native_pixmap", paramObject);
    b();
    boolean bool = this.d.eglCopyBuffers(paramEGLDisplay, paramEGLSurface, paramObject);
    a(bool);
    a();
    return bool;
  }
  
  public EGLContext eglCreateContext(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext, int[] paramArrayOfInt)
  {
    c("eglCreateContext");
    a("display", paramEGLDisplay);
    a("config", paramEGLConfig);
    a("share_context", paramEGLContext);
    a("attrib_list", paramArrayOfInt);
    b();
    paramEGLDisplay = this.d.eglCreateContext(paramEGLDisplay, paramEGLConfig, paramEGLContext, paramArrayOfInt);
    a(paramEGLDisplay);
    a();
    return paramEGLDisplay;
  }
  
  public EGLSurface eglCreatePbufferSurface(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int[] paramArrayOfInt)
  {
    c("eglCreatePbufferSurface");
    a("display", paramEGLDisplay);
    a("config", paramEGLConfig);
    a("attrib_list", paramArrayOfInt);
    b();
    paramEGLDisplay = this.d.eglCreatePbufferSurface(paramEGLDisplay, paramEGLConfig, paramArrayOfInt);
    a(paramEGLDisplay);
    a();
    return paramEGLDisplay;
  }
  
  public EGLSurface eglCreatePixmapSurface(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject, int[] paramArrayOfInt)
  {
    c("eglCreatePixmapSurface");
    a("display", paramEGLDisplay);
    a("config", paramEGLConfig);
    a("native_pixmap", paramObject);
    a("attrib_list", paramArrayOfInt);
    b();
    paramEGLDisplay = this.d.eglCreatePixmapSurface(paramEGLDisplay, paramEGLConfig, paramObject, paramArrayOfInt);
    a(paramEGLDisplay);
    a();
    return paramEGLDisplay;
  }
  
  public EGLSurface eglCreateWindowSurface(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject, int[] paramArrayOfInt)
  {
    c("eglCreateWindowSurface");
    a("display", paramEGLDisplay);
    a("config", paramEGLConfig);
    a("native_window", paramObject);
    a("attrib_list", paramArrayOfInt);
    b();
    paramEGLDisplay = this.d.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, paramArrayOfInt);
    a(paramEGLDisplay);
    a();
    return paramEGLDisplay;
  }
  
  public boolean eglDestroyContext(EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    c("eglDestroyContext");
    a("display", paramEGLDisplay);
    a("context", paramEGLContext);
    b();
    boolean bool = this.d.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    a(bool);
    a();
    return bool;
  }
  
  public boolean eglDestroySurface(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    c("eglDestroySurface");
    a("display", paramEGLDisplay);
    a("surface", paramEGLSurface);
    b();
    boolean bool = this.d.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    a(bool);
    a();
    return bool;
  }
  
  public boolean eglGetConfigAttrib(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt, int[] paramArrayOfInt)
  {
    c("eglGetConfigAttrib");
    a("display", paramEGLDisplay);
    a("config", paramEGLConfig);
    a("attribute", paramInt);
    b();
    boolean bool = this.d.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, paramArrayOfInt);
    a("value", paramArrayOfInt);
    a(bool);
    a();
    return false;
  }
  
  public boolean eglGetConfigs(EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig, int paramInt, int[] paramArrayOfInt)
  {
    c("eglGetConfigs");
    a("display", paramEGLDisplay);
    a("config_size", paramInt);
    b();
    boolean bool = this.d.eglGetConfigs(paramEGLDisplay, paramArrayOfEGLConfig, paramInt, paramArrayOfInt);
    a("configs", paramArrayOfEGLConfig);
    a("num_config", paramArrayOfInt);
    a(bool);
    a();
    return bool;
  }
  
  public EGLContext eglGetCurrentContext()
  {
    c("eglGetCurrentContext");
    b();
    EGLContext localEGLContext = this.d.eglGetCurrentContext();
    a(localEGLContext);
    a();
    return localEGLContext;
  }
  
  public EGLDisplay eglGetCurrentDisplay()
  {
    c("eglGetCurrentDisplay");
    b();
    EGLDisplay localEGLDisplay = this.d.eglGetCurrentDisplay();
    a(localEGLDisplay);
    a();
    return localEGLDisplay;
  }
  
  public EGLSurface eglGetCurrentSurface(int paramInt)
  {
    c("eglGetCurrentSurface");
    a("readdraw", paramInt);
    b();
    EGLSurface localEGLSurface = this.d.eglGetCurrentSurface(paramInt);
    a(localEGLSurface);
    a();
    return localEGLSurface;
  }
  
  public EGLDisplay eglGetDisplay(Object paramObject)
  {
    c("eglGetDisplay");
    a("native_display", paramObject);
    b();
    paramObject = this.d.eglGetDisplay(paramObject);
    a(paramObject);
    a();
    return (EGLDisplay)paramObject;
  }
  
  public int eglGetError()
  {
    c("eglGetError");
    b();
    int i = this.d.eglGetError();
    d(a(i));
    return i;
  }
  
  public boolean eglInitialize(EGLDisplay paramEGLDisplay, int[] paramArrayOfInt)
  {
    c("eglInitialize");
    a("display", paramEGLDisplay);
    b();
    boolean bool = this.d.eglInitialize(paramEGLDisplay, paramArrayOfInt);
    a(bool);
    a("major_minor", paramArrayOfInt);
    a();
    return bool;
  }
  
  public boolean eglMakeCurrent(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface1, EGLSurface paramEGLSurface2, EGLContext paramEGLContext)
  {
    c("eglMakeCurrent");
    a("display", paramEGLDisplay);
    a("draw", paramEGLSurface1);
    a("read", paramEGLSurface2);
    a("context", paramEGLContext);
    b();
    boolean bool = this.d.eglMakeCurrent(paramEGLDisplay, paramEGLSurface1, paramEGLSurface2, paramEGLContext);
    a(bool);
    a();
    return bool;
  }
  
  public boolean eglQueryContext(EGLDisplay paramEGLDisplay, EGLContext paramEGLContext, int paramInt, int[] paramArrayOfInt)
  {
    c("eglQueryContext");
    a("display", paramEGLDisplay);
    a("context", paramEGLContext);
    a("attribute", paramInt);
    b();
    boolean bool = this.d.eglQueryContext(paramEGLDisplay, paramEGLContext, paramInt, paramArrayOfInt);
    b(paramArrayOfInt[0]);
    a(bool);
    a();
    return bool;
  }
  
  public String eglQueryString(EGLDisplay paramEGLDisplay, int paramInt)
  {
    c("eglQueryString");
    a("display", paramEGLDisplay);
    a("name", paramInt);
    b();
    paramEGLDisplay = this.d.eglQueryString(paramEGLDisplay, paramInt);
    d(paramEGLDisplay);
    a();
    return paramEGLDisplay;
  }
  
  public boolean eglQuerySurface(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface, int paramInt, int[] paramArrayOfInt)
  {
    c("eglQuerySurface");
    a("display", paramEGLDisplay);
    a("surface", paramEGLSurface);
    a("attribute", paramInt);
    b();
    boolean bool = this.d.eglQuerySurface(paramEGLDisplay, paramEGLSurface, paramInt, paramArrayOfInt);
    b(paramArrayOfInt[0]);
    a(bool);
    a();
    return bool;
  }
  
  public boolean eglSwapBuffers(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    c("eglInitialize");
    a("display", paramEGLDisplay);
    a("surface", paramEGLSurface);
    b();
    boolean bool = this.d.eglSwapBuffers(paramEGLDisplay, paramEGLSurface);
    a(bool);
    a();
    return bool;
  }
  
  public boolean eglTerminate(EGLDisplay paramEGLDisplay)
  {
    c("eglTerminate");
    a("display", paramEGLDisplay);
    b();
    boolean bool = this.d.eglTerminate(paramEGLDisplay);
    a(bool);
    a();
    return bool;
  }
  
  public boolean eglWaitGL()
  {
    c("eglWaitGL");
    b();
    boolean bool = this.d.eglWaitGL();
    a(bool);
    a();
    return bool;
  }
  
  public boolean eglWaitNative(int paramInt, Object paramObject)
  {
    c("eglWaitNative");
    a("engine", paramInt);
    a("bindTarget", paramObject);
    b();
    boolean bool = this.d.eglWaitNative(paramInt, paramObject);
    a(bool);
    a();
    return bool;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */