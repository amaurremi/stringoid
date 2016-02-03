package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.internal.gx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class h
  implements Runnable
{
  private final Uri b;
  private final Bitmap c;
  private final CountDownLatch d;
  private boolean e;
  
  public h(ImageManager paramImageManager, Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
  {
    this.b = paramUri;
    this.c = paramBitmap;
    this.e = paramBoolean;
    this.d = paramCountDownLatch;
  }
  
  private void a(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
  {
    paramImageReceiver = ImageManager.ImageReceiver.a(paramImageReceiver);
    int j = paramImageReceiver.size();
    int i = 0;
    if (i < j)
    {
      a locala = (a)paramImageReceiver.get(i);
      if (paramBoolean) {
        locala.a(ImageManager.b(this.a), this.c, false);
      }
      for (;;)
      {
        if (!(locala instanceof a.c)) {
          ImageManager.a(this.a).remove(locala);
        }
        i += 1;
        break;
        ImageManager.d(this.a).put(this.b, Long.valueOf(SystemClock.elapsedRealtime()));
        locala.a(ImageManager.b(this.a), ImageManager.c(this.a), false);
      }
    }
  }
  
  public void run()
  {
    gx.ay("OnBitmapLoadedRunnable must be executed in the main thread");
    boolean bool;
    if (this.c != null) {
      bool = true;
    }
    while (ImageManager.h(this.a) != null) {
      if (this.e)
      {
        ImageManager.h(this.a).evictAll();
        System.gc();
        this.e = false;
        ImageManager.g(this.a).post(this);
        return;
        bool = false;
      }
      else if (bool)
      {
        ImageManager.h(this.a).put(new i(this.b), this.c);
      }
    }
    ??? = (ImageManager.ImageReceiver)ImageManager.e(this.a).remove(this.b);
    if (??? != null) {
      a((ImageManager.ImageReceiver)???, bool);
    }
    this.d.countDown();
    synchronized (ImageManager.fd())
    {
      ImageManager.fe().remove(this.b);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/images/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */