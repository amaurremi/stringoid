package com.badlogic.gdx.backends.android.b;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class z
  extends y
{
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  private int[] h = new int[1];
  
  public z(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, paramInt6, 12344 });
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramInt6;
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
  {
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.h)) {
      paramInt2 = this.h[0];
    }
    return paramInt2;
  }
  
  public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    Object localObject = null;
    int i = 1000;
    int m = paramArrayOfEGLConfig.length;
    int j = 0;
    if (j < m)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[j];
      int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
      int i3 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
      int i4 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
      int i2 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
      int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
      int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
      i1 = Math.abs(i1 - this.b);
      i3 = Math.abs(i3 - this.c);
      i4 = Math.abs(i4 - this.d);
      i2 = Math.abs(i2 - this.e);
      n = Math.abs(n - this.f);
      k = Math.abs(k - this.g) + (i1 + i3 + i4 + i2 + n);
      if (k >= i) {
        break label226;
      }
      localObject = localEGLConfig;
      i = k;
    }
    label226:
    for (;;)
    {
      j += 1;
      break;
      return (EGLConfig)localObject;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */