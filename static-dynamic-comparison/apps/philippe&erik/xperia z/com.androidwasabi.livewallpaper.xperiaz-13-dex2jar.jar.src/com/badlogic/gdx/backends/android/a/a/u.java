package com.badlogic.gdx.backends.android.a.a;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class u
  implements w
{
  u(q paramq) {}
  
  /* Error */
  public EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, javax.microedition.khronos.egl.EGLConfig paramEGLConfig, Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload 5
    //   5: ifnull +6 -> 11
    //   8: aload 5
    //   10: areturn
    //   11: aload_1
    //   12: aload_2
    //   13: aload_3
    //   14: aload 4
    //   16: aconst_null
    //   17: invokeinterface 27 5 0
    //   22: astore 6
    //   24: aload 6
    //   26: astore 5
    //   28: aload 6
    //   30: ifnonnull -27 -> 3
    //   33: ldc2_w 28
    //   36: invokestatic 35	java/lang/Thread:sleep	(J)V
    //   39: aload 6
    //   41: astore 5
    //   43: goto -40 -> 3
    //   46: astore 5
    //   48: aload 6
    //   50: astore 5
    //   52: goto -49 -> 3
    //   55: astore 6
    //   57: aload 5
    //   59: ifnonnull -56 -> 3
    //   62: ldc2_w 28
    //   65: invokestatic 35	java/lang/Thread:sleep	(J)V
    //   68: goto -65 -> 3
    //   71: astore 6
    //   73: goto -70 -> 3
    //   76: astore_1
    //   77: aload 5
    //   79: ifnonnull +9 -> 88
    //   82: ldc2_w 28
    //   85: invokestatic 35	java/lang/Thread:sleep	(J)V
    //   88: aload_1
    //   89: athrow
    //   90: astore_2
    //   91: goto -3 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	u
    //   0	94	1	paramEGL10	EGL10
    //   0	94	2	paramEGLDisplay	EGLDisplay
    //   0	94	3	paramEGLConfig	javax.microedition.khronos.egl.EGLConfig
    //   0	94	4	paramObject	Object
    //   1	41	5	localObject1	Object
    //   46	1	5	localInterruptedException1	InterruptedException
    //   50	28	5	localObject2	Object
    //   22	27	6	localEGLSurface	EGLSurface
    //   55	1	6	localThrowable	Throwable
    //   71	1	6	localInterruptedException2	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   33	39	46	java/lang/InterruptedException
    //   11	24	55	java/lang/Throwable
    //   62	68	71	java/lang/InterruptedException
    //   11	24	76	finally
    //   82	88	90	java/lang/InterruptedException
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */