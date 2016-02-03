package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.internal.gx;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

final class e
  implements Runnable
{
  private final Uri b;
  private final ParcelFileDescriptor c;
  
  public e(ImageManager paramImageManager, Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.b = paramUri;
    this.c = paramParcelFileDescriptor;
  }
  
  public void run()
  {
    gx.az("LoadBitmapFromDiskRunnable can't be executed in the main thread");
    boolean bool1 = false;
    boolean bool2 = false;
    Bitmap localBitmap = null;
    CountDownLatch localCountDownLatch = null;
    if (this.c != null) {}
    try
    {
      localBitmap = BitmapFactory.decodeFileDescriptor(this.c.getFileDescriptor());
      bool1 = bool2;
      Object localObject;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        for (;;)
        {
          this.c.close();
          localCountDownLatch = new CountDownLatch(1);
          ImageManager.g(this.a).post(new h(this.a, this.b, localBitmap, bool1, localCountDownLatch));
          try
          {
            localCountDownLatch.await();
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.w("ImageManager", "Latch interrupted while posting " + this.b);
          }
          localOutOfMemoryError = localOutOfMemoryError;
          Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.b, localOutOfMemoryError);
          bool1 = true;
          localObject = localCountDownLatch;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("ImageManager", "closed failed", localIOException);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/images/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */