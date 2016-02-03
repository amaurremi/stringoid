package com.badlogic.gdx.backends.android.b;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class af
  implements GLSurfaceView.EGLConfigChooser
{
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected boolean h;
  protected final int[] i;
  private int[] j = new int[1];
  
  public af(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    this.g = paramInt7;
    this.h = paramBoolean;
    if (paramBoolean)
    {
      this.i = new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344 };
      return;
    }
    this.i = new int[] { 12324, 4, 12323, 4, 12322, 4, 12344 };
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
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject2 = null;
    int m = paramArrayOfEGLConfig.length;
    int k = 0;
    Object localObject5;
    int n;
    int i1;
    Object localObject7;
    Object localObject6;
    Object localObject3;
    int i2;
    int i3;
    for (;;)
    {
      if (k < m)
      {
        localObject5 = paramArrayOfEGLConfig[k];
        n = a(paramEGL10, paramEGLDisplay, (EGLConfig)localObject5, 12325, 0);
        i1 = a(paramEGL10, paramEGLDisplay, (EGLConfig)localObject5, 12326, 0);
        localObject7 = localObject2;
        localObject6 = localObject1;
        if (n >= this.e)
        {
          if (i1 < this.f)
          {
            localObject3 = localObject2;
            localObject5 = localObject4;
            localObject2 = localObject1;
            localObject1 = localObject3;
            k += 1;
            localObject4 = localObject5;
            localObject3 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject3;
            continue;
          }
          n = a(paramEGL10, paramEGLDisplay, (EGLConfig)localObject5, 12324, 0);
          i1 = a(paramEGL10, paramEGLDisplay, (EGLConfig)localObject5, 12323, 0);
          i2 = a(paramEGL10, paramEGLDisplay, (EGLConfig)localObject5, 12322, 0);
          i3 = a(paramEGL10, paramEGLDisplay, (EGLConfig)localObject5, 12321, 0);
          localObject3 = localObject2;
          if (localObject2 == null)
          {
            localObject3 = localObject2;
            if (n == 5)
            {
              localObject3 = localObject2;
              if (i1 == 6)
              {
                localObject3 = localObject2;
                if (i2 == 5)
                {
                  localObject3 = localObject2;
                  if (i3 == 0) {
                    localObject3 = localObject5;
                  }
                }
              }
            }
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            if (n == this.a)
            {
              localObject2 = localObject1;
              if (i1 == this.b)
              {
                localObject2 = localObject1;
                if (i2 == this.c)
                {
                  localObject2 = localObject1;
                  if (i3 == this.d) {
                    if (this.g == 0) {
                      localObject2 = localObject3;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject4 != null)
      {
        return (EGLConfig)localObject4;
        localObject2 = localObject5;
        int i4 = a(paramEGL10, paramEGLDisplay, (EGLConfig)localObject5, 12338, 0);
        int i5 = a(paramEGL10, paramEGLDisplay, (EGLConfig)localObject5, 12337, 0);
        if ((localObject4 == null) && (i4 == 1) && (i5 >= this.g) && (n == this.a) && (i1 == this.b) && (i2 == this.c) && (i3 == this.d))
        {
          localObject1 = localObject3;
          break;
        }
        i4 = a(paramEGL10, paramEGLDisplay, (EGLConfig)localObject5, 12512, 0);
        i5 = a(paramEGL10, paramEGLDisplay, (EGLConfig)localObject5, 12513, 0);
        localObject7 = localObject3;
        localObject6 = localObject2;
        if (localObject4 != null) {
          break label566;
        }
        localObject7 = localObject3;
        localObject6 = localObject2;
        if (i4 != 1) {
          break label566;
        }
        localObject7 = localObject3;
        localObject6 = localObject2;
        if (i5 < this.g) {
          break label566;
        }
        localObject7 = localObject3;
        localObject6 = localObject2;
        if (n != this.a) {
          break label566;
        }
        localObject7 = localObject3;
        localObject6 = localObject2;
        if (i1 != this.b) {
          break label566;
        }
        localObject7 = localObject3;
        localObject6 = localObject2;
        if (i2 != this.c) {
          break label566;
        }
        localObject7 = localObject3;
        localObject6 = localObject2;
        if (i3 != this.d) {
          break label566;
        }
        localObject1 = localObject3;
        break;
      }
      if (localObject5 != null) {
        return (EGLConfig)localObject5;
      }
      return (EGLConfig)localObject2;
      label566:
      localObject1 = localObject7;
      localObject2 = localObject6;
      localObject5 = localObject4;
      break;
      localObject5 = localObject1;
    }
  }
  
  public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.i, null, 0, arrayOfInt);
    int k = arrayOfInt[0];
    if (k <= 0) {
      throw new IllegalArgumentException("No configs match configSpec");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[k];
    paramEGL10.eglChooseConfig(paramEGLDisplay, this.i, arrayOfEGLConfig, k, arrayOfInt);
    return a(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */