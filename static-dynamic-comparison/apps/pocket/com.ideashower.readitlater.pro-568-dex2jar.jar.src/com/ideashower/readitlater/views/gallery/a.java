package com.ideashower.readitlater.views.gallery;

import android.graphics.Bitmap;
import com.pocket.m.a.l;
import java.lang.ref.SoftReference;
import java.util.concurrent.ExecutorService;

public class a
{
  private final com.pocket.m.a.a a;
  private final String b;
  private SoftReference c;
  private final Object d = new Object();
  
  public a(com.ideashower.readitlater.e.a parama, ExecutorService paramExecutorService)
  {
    this.a = com.pocket.m.a.a.a(parama.a(), 1, l.c());
    if (this.a == null) {
      throw new IllegalArgumentException("Asset not found for URL");
    }
    this.b = this.a.c();
    if ((this.b == null) || (this.b.length() == 0)) {
      throw new IllegalArgumentException("Asset path not found");
    }
  }
  
  private Bitmap b()
  {
    synchronized (this.d)
    {
      if ((this.c != null) && (this.c.get() != null))
      {
        if (((Bitmap)this.c.get()).isRecycled())
        {
          this.c = null;
          return null;
        }
        Bitmap localBitmap = (Bitmap)this.c.get();
        return localBitmap;
      }
    }
    return null;
  }
  
  /* Error */
  private Bitmap c()
  {
    // Byte code:
    //   0: new 75	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 76	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: getstatic 82	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   12: putfield 85	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   15: aload_1
    //   16: iconst_1
    //   17: putfield 89	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   20: aload_0
    //   21: getfield 47	com/ideashower/readitlater/views/gallery/a:b	Ljava/lang/String;
    //   24: aload_1
    //   25: invokestatic 95	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   28: astore_2
    //   29: aload_0
    //   30: getfield 19	com/ideashower/readitlater/views/gallery/a:d	Ljava/lang/Object;
    //   33: astore_1
    //   34: aload_1
    //   35: monitorenter
    //   36: aload_2
    //   37: ifnull +7 -> 44
    //   40: aload_1
    //   41: monitorexit
    //   42: aload_2
    //   43: areturn
    //   44: aload_0
    //   45: aconst_null
    //   46: putfield 59	com/ideashower/readitlater/views/gallery/a:c	Ljava/lang/ref/SoftReference;
    //   49: aload_1
    //   50: monitorexit
    //   51: aconst_null
    //   52: areturn
    //   53: astore_2
    //   54: aload_1
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    //   58: astore_1
    //   59: aload_1
    //   60: invokestatic 100	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   63: aconst_null
    //   64: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	a
    //   7	48	1	localObject1	Object
    //   58	2	1	localOutOfMemoryError	OutOfMemoryError
    //   28	15	2	localBitmap	Bitmap
    //   53	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	42	53	finally
    //   44	51	53	finally
    //   54	56	53	finally
    //   0	36	58	java/lang/OutOfMemoryError
    //   56	58	58	java/lang/OutOfMemoryError
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap = b();
    if (localBitmap != null) {
      return localBitmap;
    }
    return c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/gallery/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */