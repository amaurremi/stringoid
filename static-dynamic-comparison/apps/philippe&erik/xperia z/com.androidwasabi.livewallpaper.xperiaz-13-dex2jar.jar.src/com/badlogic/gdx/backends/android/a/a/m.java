package com.badlogic.gdx.backends.android.a.a;

class m
{
  private l b;
  
  m(d paramd) {}
  
  public void a(l paraml)
  {
    try
    {
      paraml.a = true;
      if (this.b == paraml) {
        this.b = null;
      }
      notifyAll();
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean b(l paraml)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/badlogic/gdx/backends/android/a/a/m:b	Lcom/badlogic/gdx/backends/android/a/a/l;
    //   6: aload_1
    //   7: if_acmpeq +10 -> 17
    //   10: aload_0
    //   11: getfield 24	com/badlogic/gdx/backends/android/a/a/m:b	Lcom/badlogic/gdx/backends/android/a/a/l;
    //   14: ifnonnull +18 -> 32
    //   17: aload_0
    //   18: aload_1
    //   19: putfield 24	com/badlogic/gdx/backends/android/a/a/m:b	Lcom/badlogic/gdx/backends/android/a/a/l;
    //   22: aload_0
    //   23: invokevirtual 27	java/lang/Object:notifyAll	()V
    //   26: iconst_1
    //   27: istore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_2
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -6 -> 28
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	m
    //   0	42	1	paraml	l
    //   27	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	17	37	finally
    //   17	26	37	finally
  }
  
  public void c(l paraml)
  {
    try
    {
      if (this.b == paraml) {
        this.b = null;
      }
      notifyAll();
      return;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */