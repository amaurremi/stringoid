package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.google.android.gms.internal.gx;
import java.util.HashSet;
import java.util.Map;

final class f
  implements Runnable
{
  private final a b;
  
  public f(ImageManager paramImageManager, a parama)
  {
    this.b = parama;
  }
  
  public void run()
  {
    gx.ay("LoadImageRunnable must be executed on the main thread");
    Object localObject1 = (ImageManager.ImageReceiver)ImageManager.a(this.a).get(this.b);
    if (localObject1 != null)
    {
      ImageManager.a(this.a).remove(this.b);
      ((ImageManager.ImageReceiver)localObject1).b(this.b);
    }
    i locali = this.b.Fm;
    if (locali.a == null)
    {
      this.b.a(ImageManager.b(this.a), ImageManager.c(this.a), true);
      return;
    }
    localObject1 = ImageManager.a(this.a, locali);
    if (localObject1 != null)
    {
      this.b.a(ImageManager.b(this.a), (Bitmap)localObject1, true);
      return;
    }
    localObject1 = (Long)ImageManager.d(this.a).get(locali.a);
    if (localObject1 != null)
    {
      if (SystemClock.elapsedRealtime() - ((Long)localObject1).longValue() < 3600000L)
      {
        this.b.a(ImageManager.b(this.a), ImageManager.c(this.a), true);
        return;
      }
      ImageManager.d(this.a).remove(locali.a);
    }
    this.b.a(ImageManager.b(this.a), ImageManager.c(this.a));
    ??? = (ImageManager.ImageReceiver)ImageManager.e(this.a).get(locali.a);
    localObject1 = ???;
    if (??? == null)
    {
      localObject1 = new ImageManager.ImageReceiver(this.a, locali.a);
      ImageManager.e(this.a).put(locali.a, localObject1);
    }
    ((ImageManager.ImageReceiver)localObject1).a(this.b);
    if (!(this.b instanceof a.c)) {
      ImageManager.a(this.a).put(this.b, localObject1);
    }
    synchronized (ImageManager.fd())
    {
      if (!ImageManager.fe().contains(locali.a))
      {
        ImageManager.fe().add(locali.a);
        ((ImageManager.ImageReceiver)localObject1).a();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/images/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */