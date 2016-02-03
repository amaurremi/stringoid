package com.badlogic.gdx.backends.android.a.a;

class z
{
  private z(y paramy) {}
  
  public void a(y paramy)
  {
    try
    {
      paramy.b = true;
      if (y.a(this.a) == paramy) {
        y.a(this.a, null);
      }
      notifyAll();
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean b(y paramy)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 10	com/badlogic/gdx/backends/android/a/a/z:a	Lcom/badlogic/gdx/backends/android/a/a/y;
    //   6: invokestatic 26	com/badlogic/gdx/backends/android/a/a/y:a	(Lcom/badlogic/gdx/backends/android/a/a/y;)Lcom/badlogic/gdx/backends/android/a/a/y;
    //   9: aload_1
    //   10: if_acmpeq +13 -> 23
    //   13: aload_0
    //   14: getfield 10	com/badlogic/gdx/backends/android/a/a/z:a	Lcom/badlogic/gdx/backends/android/a/a/y;
    //   17: invokestatic 26	com/badlogic/gdx/backends/android/a/a/y:a	(Lcom/badlogic/gdx/backends/android/a/a/y;)Lcom/badlogic/gdx/backends/android/a/a/y;
    //   20: ifnonnull +21 -> 41
    //   23: aload_0
    //   24: getfield 10	com/badlogic/gdx/backends/android/a/a/z:a	Lcom/badlogic/gdx/backends/android/a/a/y;
    //   27: aload_1
    //   28: invokestatic 29	com/badlogic/gdx/backends/android/a/a/y:a	(Lcom/badlogic/gdx/backends/android/a/a/y;Lcom/badlogic/gdx/backends/android/a/a/y;)V
    //   31: aload_0
    //   32: invokevirtual 32	java/lang/Object:notifyAll	()V
    //   35: iconst_1
    //   36: istore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: iload_2
    //   40: ireturn
    //   41: iconst_0
    //   42: istore_2
    //   43: goto -6 -> 37
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	z
    //   0	51	1	paramy	y
    //   36	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	23	46	finally
    //   23	35	46	finally
  }
  
  public void c(y paramy)
  {
    try
    {
      if (y.a(this.a) == paramy) {
        y.a(this.a, null);
      }
      notifyAll();
      return;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */