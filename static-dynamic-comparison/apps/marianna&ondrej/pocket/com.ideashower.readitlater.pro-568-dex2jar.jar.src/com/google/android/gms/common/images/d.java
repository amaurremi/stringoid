package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import com.google.android.gms.internal.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class d
  implements Runnable
{
  private final Uri b;
  private final Bitmap c;
  private final CountDownLatch d;
  private boolean e;
  
  public d(ImageManager paramImageManager, Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
  {
    this.b = paramUri;
    this.c = paramBitmap;
    this.e = paramBoolean;
    this.d = paramCountDownLatch;
  }
  
  private void a(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
  {
    paramImageReceiver.a = true;
    ArrayList localArrayList = ImageManager.ImageReceiver.a(paramImageReceiver);
    int j = localArrayList.size();
    int i = 0;
    if (i < j)
    {
      e locale = (e)localArrayList.get(i);
      if (paramBoolean) {
        locale.a(ImageManager.a(this.a), this.c, false);
      }
      for (;;)
      {
        if (locale.b != 1) {
          ImageManager.c(this.a).remove(locale);
        }
        i += 1;
        break;
        locale.a(ImageManager.a(this.a), false);
      }
    }
    paramImageReceiver.a = false;
  }
  
  public void run()
  {
    q.a("OnBitmapLoadedRunnable must be executed in the main thread");
    boolean bool;
    if (this.c != null) {
      bool = true;
    }
    while (ImageManager.f(this.a) != null) {
      if (this.e)
      {
        ImageManager.f(this.a).a();
        System.gc();
        this.e = false;
        ImageManager.e(this.a).post(this);
        return;
        bool = false;
      }
      else if (bool)
      {
        ImageManager.f(this.a).b(new f(this.b), this.c);
      }
    }
    ??? = (ImageManager.ImageReceiver)ImageManager.b(this.a).remove(this.b);
    if (??? != null) {
      a((ImageManager.ImageReceiver)???, bool);
    }
    this.d.countDown();
    synchronized (ImageManager.a())
    {
      ImageManager.b().remove(this.b);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/common/images/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */