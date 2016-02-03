package com.badlogic.gdx.backends.android.a.a;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class ag
  implements GLSurfaceView.EGLConfigChooser
{
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  private int[] h = { 12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344 };
  private int[] i = new int[1];
  
  public ag(af paramaf, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
  {
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.i)) {
      paramInt2 = this.i[0];
    }
    return paramInt2;
  }
  
  public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    int k = paramArrayOfEGLConfig.length;
    int j = 0;
    if (j >= k) {
      return null;
    }
    EGLConfig localEGLConfig = paramArrayOfEGLConfig[j];
    int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
    int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
    if ((m < this.e) || (n < this.f)) {}
    int i1;
    int i2;
    do
    {
      j += 1;
      break;
      m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
      n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
      i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
      i2 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
    } while ((m != this.a) || (n != this.b) || (i1 != this.c) || (i2 != this.d));
    return localEGLConfig;
  }
  
  public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.h, null, 0, arrayOfInt);
    int j = arrayOfInt[0];
    if (j <= 0) {
      throw new IllegalArgumentException("No configs match configSpec");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[j];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.h, arrayOfEGLConfig, j, arrayOfInt);
    return a(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/a/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */