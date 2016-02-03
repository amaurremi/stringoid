package com.mapbar.android.maps;

import android.util.Log;
import java.io.File;
import java.util.Collections;
import java.util.Map;

public abstract class d<K, V>
{
  private static String a = "CacheBase";
  private File b = null;
  private int c = 0;
  private b d;
  private Map<K, V> e = Collections.synchronizedMap(new e(this, 101, 0.75F, true));
  
  public d(File paramFile, b paramb, int paramInt)
  {
    this.b = paramFile;
    this.c = paramInt;
    this.d = paramb;
    if (this.b != null) {
      new a().b(new b[] { paramb });
    }
  }
  
  public final V a(K paramK)
  {
    try
    {
      paramK = this.e.get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/mapbar/android/maps/d:e	Ljava/util/Map;
    //   6: invokeinterface 74 1 0
    //   11: invokeinterface 80 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 86 1 0
    //   23: ifeq +133 -> 156
    //   26: aload_1
    //   27: invokeinterface 90 1 0
    //   32: checkcast 92	java/util/Map$Entry
    //   35: astore_2
    //   36: aload_2
    //   37: invokeinterface 95 1 0
    //   42: instanceof 97
    //   45: ifeq +17 -> 62
    //   48: aload_2
    //   49: invokeinterface 95 1 0
    //   54: checkcast 97	android/graphics/Bitmap
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 100	android/graphics/Bitmap:recycle	()V
    //   62: aload_2
    //   63: invokeinterface 103 1 0
    //   68: instanceof 97
    //   71: ifeq +17 -> 88
    //   74: aload_2
    //   75: invokeinterface 103 1 0
    //   80: checkcast 97	android/graphics/Bitmap
    //   83: astore_3
    //   84: aload_3
    //   85: invokevirtual 100	android/graphics/Bitmap:recycle	()V
    //   88: aload_2
    //   89: invokeinterface 95 1 0
    //   94: instanceof 105
    //   97: ifeq +17 -> 114
    //   100: aload_2
    //   101: invokeinterface 95 1 0
    //   106: checkcast 105	com/mapbar/android/maps/f
    //   109: invokeinterface 108 1 0
    //   114: aload_2
    //   115: invokeinterface 103 1 0
    //   120: instanceof 105
    //   123: ifeq -106 -> 17
    //   126: aload_2
    //   127: invokeinterface 103 1 0
    //   132: checkcast 105	com/mapbar/android/maps/f
    //   135: invokeinterface 108 1 0
    //   140: goto -123 -> 17
    //   143: astore_1
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    //   148: astore_3
    //   149: aload_3
    //   150: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   153: goto -65 -> 88
    //   156: aload_0
    //   157: getfield 49	com/mapbar/android/maps/d:e	Ljava/util/Map;
    //   160: invokeinterface 114 1 0
    //   165: aload_0
    //   166: monitorexit
    //   167: return
    //   168: astore_3
    //   169: goto -107 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	d
    //   16	11	1	localIterator	java.util.Iterator
    //   143	4	1	localObject	Object
    //   35	92	2	localEntry	java.util.Map.Entry
    //   57	28	3	localBitmap	android.graphics.Bitmap
    //   148	2	3	localException1	Exception
    //   168	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	17	143	finally
    //   17	58	143	finally
    //   58	62	143	finally
    //   62	84	143	finally
    //   84	88	143	finally
    //   88	114	143	finally
    //   114	140	143	finally
    //   149	153	143	finally
    //   156	165	143	finally
    //   84	88	148	java/lang/Exception
    //   58	62	168	java/lang/Exception
  }
  
  protected final void a(K paramK, V paramV)
  {
    try
    {
      this.e.put(paramK, paramV);
      return;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public final void b()
  {
    if (this.b != null) {
      new a().b(new b[] { this.d });
    }
  }
  
  public final boolean b(K paramK)
  {
    try
    {
      boolean bool = this.e.containsKey(paramK);
      return bool;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  protected final File c()
  {
    return this.b;
  }
  
  class a
    extends I<d.b, Void, Void>
  {
    a() {}
    
    private Void a(d.b... paramVarArgs)
    {
      try
      {
        a(d.b(d.this), paramVarArgs[0]);
        return null;
      }
      catch (Throwable paramVarArgs)
      {
        for (;;)
        {
          Log.e(d.d(), "Exception cleaning cache", paramVarArgs);
        }
      }
    }
    
    private void a(File paramFile, d.b paramb)
    {
      if (paramFile.isDirectory())
      {
        String[] arrayOfString = paramFile.list();
        int i = 0;
        while (i < arrayOfString.length)
        {
          a(new File(paramFile, arrayOfString[i]), paramb);
          i += 1;
        }
      }
      if (paramb.eject(paramFile)) {
        paramFile.delete();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean eject(File paramFile);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */