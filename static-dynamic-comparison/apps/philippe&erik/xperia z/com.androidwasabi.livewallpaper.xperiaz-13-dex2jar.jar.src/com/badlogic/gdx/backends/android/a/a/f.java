package com.badlogic.gdx.backends.android.a.a;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class f
  extends e
{
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  private int[] j = new int[1];
  
  public f(d paramd, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramd, new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, paramInt6, 12344 });
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
    this.g = paramInt5;
    this.h = paramInt6;
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
  {
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.j)) {
      paramInt2 = this.j[0];
    }
    return paramInt2;
  }
  
  public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    Object localObject = null;
    int k = 1000;
    int i1 = paramArrayOfEGLConfig.length;
    int m = 0;
    if (m >= i1) {
      return (EGLConfig)localObject;
    }
    EGLConfig localEGLConfig = paramArrayOfEGLConfig[m];
    int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
    int i2 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
    if ((n >= this.g) && (i2 >= this.h))
    {
      int i3 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
      int i4 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
      i2 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
      n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
      i3 = Math.abs(i3 - this.c);
      i4 = Math.abs(i4 - this.d);
      i2 = Math.abs(i2 - this.e);
      n = Math.abs(n - this.f) + (i3 + i4 + i2);
      if (n < k)
      {
        localObject = localEGLConfig;
        k = n;
      }
    }
    for (;;)
    {
      m += 1;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */