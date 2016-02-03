package com.badlogic.gdx.backends.android.b;

class t
{
  private static String a = "GLThreadManager";
  private boolean b;
  private int c;
  private boolean d;
  private boolean e;
  private boolean f;
  private s g;
  
  private void c()
  {
    if (!this.b)
    {
      this.c = 65536;
      if (this.c >= 131072) {
        this.e = true;
      }
      this.b = true;
    }
  }
  
  public void a(s params)
  {
    try
    {
      s.a(params, true);
      if (this.g == params) {
        this.g = null;
      }
      notifyAll();
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(javax.microedition.khronos.opengles.GL10 paramGL10)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 49	com/badlogic/gdx/backends/android/b/t:d	Z
    //   8: ifne +65 -> 73
    //   11: aload_0
    //   12: invokespecial 51	com/badlogic/gdx/backends/android/b/t:c	()V
    //   15: aload_1
    //   16: sipush 7937
    //   19: invokeinterface 57 2 0
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 32	com/badlogic/gdx/backends/android/b/t:c	I
    //   29: ldc 33
    //   31: if_icmpge +23 -> 54
    //   34: aload_1
    //   35: ldc 59
    //   37: invokevirtual 65	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   40: ifne +36 -> 76
    //   43: iconst_1
    //   44: istore_2
    //   45: aload_0
    //   46: iload_2
    //   47: putfield 35	com/badlogic/gdx/backends/android/b/t:e	Z
    //   50: aload_0
    //   51: invokevirtual 46	java/lang/Object:notifyAll	()V
    //   54: aload_0
    //   55: getfield 35	com/badlogic/gdx/backends/android/b/t:e	Z
    //   58: ifne +23 -> 81
    //   61: iload_3
    //   62: istore_2
    //   63: aload_0
    //   64: iload_2
    //   65: putfield 67	com/badlogic/gdx/backends/android/b/t:f	Z
    //   68: aload_0
    //   69: iconst_1
    //   70: putfield 49	com/badlogic/gdx/backends/android/b/t:d	Z
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: iconst_0
    //   77: istore_2
    //   78: goto -33 -> 45
    //   81: iconst_0
    //   82: istore_2
    //   83: goto -20 -> 63
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	t
    //   0	91	1	paramGL10	javax.microedition.khronos.opengles.GL10
    //   44	39	2	bool1	boolean
    //   1	61	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	43	86	finally
    //   45	54	86	finally
    //   54	61	86	finally
    //   63	73	86	finally
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 51	com/badlogic/gdx/backends/android/b/t:c	()V
    //   6: aload_0
    //   7: getfield 35	com/badlogic/gdx/backends/android/b/t:e	Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifne +9 -> 21
    //   15: iconst_1
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	t
    //   10	13	1	bool	boolean
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	26	finally
  }
  
  public boolean b(s params)
  {
    if ((this.g == params) || (this.g == null))
    {
      this.g = params;
      notifyAll();
    }
    do
    {
      return true;
      c();
    } while (this.e);
    if (this.g != null) {
      this.g.i();
    }
    return false;
  }
  
  public void c(s params)
  {
    if (this.g == params) {
      this.g = null;
    }
    notifyAll();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */