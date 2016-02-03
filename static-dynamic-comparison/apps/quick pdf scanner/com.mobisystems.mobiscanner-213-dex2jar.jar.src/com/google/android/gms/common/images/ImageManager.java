package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.util.Log;
import com.google.android.gms.internal.cq;
import com.google.android.gms.internal.dg;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public final class ImageManager
{
  private static final Object sg = new Object();
  private static HashSet<Uri> sh = new HashSet();
  private final Context mContext;
  private final Handler mHandler;
  private final ExecutorService si;
  private final b sj;
  private final Map<a, ImageReceiver> sk;
  private final Map<Uri, ImageReceiver> sl;
  
  private final class ImageReceiver
    extends ResultReceiver
  {
    private final Uri sm;
    private final ArrayList<a> sn;
    boolean so;
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.d(this.sp).execute(new ImageManager.c(this.sp, this.sm, paramBundle));
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }
  
  private static final class b
    extends dg<a.a, Bitmap>
  {
    protected int a(a.a parama, Bitmap paramBitmap)
    {
      return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    }
    
    protected void a(boolean paramBoolean, a.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super.entryRemoved(paramBoolean, parama, paramBitmap1, paramBitmap2);
    }
  }
  
  private final class c
    implements Runnable
  {
    private final Uri sm;
    private final ParcelFileDescriptor sq;
    
    public c(Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.sm = paramUri;
      this.sq = paramParcelFileDescriptor;
    }
    
    public void run()
    {
      cq.aI("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      boolean bool1 = false;
      boolean bool2 = false;
      Bitmap localBitmap = null;
      CountDownLatch localCountDownLatch = null;
      if (this.sq != null) {}
      try
      {
        localBitmap = BitmapFactory.decodeFileDescriptor(this.sq.getFileDescriptor());
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
            this.sq.close();
            localCountDownLatch = new CountDownLatch(1);
            ImageManager.e(ImageManager.this).post(new ImageManager.d(ImageManager.this, this.sm, localBitmap, bool1, localCountDownLatch));
            try
            {
              localCountDownLatch.await();
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              Log.w("ImageManager", "Latch interrupted while posting " + this.sm);
            }
            localOutOfMemoryError = localOutOfMemoryError;
            Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.sm, localOutOfMemoryError);
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
  
  private final class d
    implements Runnable
  {
    private final CountDownLatch rk;
    private final Uri sm;
    private final Bitmap sr;
    private boolean ss;
    
    public d(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
    {
      this.sm = paramUri;
      this.sr = paramBitmap;
      this.ss = paramBoolean;
      this.rk = paramCountDownLatch;
    }
    
    private void a(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
    {
      paramImageReceiver.so = true;
      ArrayList localArrayList = ImageManager.ImageReceiver.a(paramImageReceiver);
      int j = localArrayList.size();
      int i = 0;
      if (i < j)
      {
        a locala = (a)localArrayList.get(i);
        if (paramBoolean) {
          locala.a(ImageManager.a(ImageManager.this), this.sr, false);
        }
        for (;;)
        {
          if (locala.sw != 1) {
            ImageManager.c(ImageManager.this).remove(locala);
          }
          i += 1;
          break;
          locala.a(ImageManager.a(ImageManager.this), false);
        }
      }
      paramImageReceiver.so = false;
    }
    
    public void run()
    {
      cq.aH("OnBitmapLoadedRunnable must be executed in the main thread");
      boolean bool;
      if (this.sr != null) {
        bool = true;
      }
      while (ImageManager.f(ImageManager.this) != null) {
        if (this.ss)
        {
          ImageManager.f(ImageManager.this).evictAll();
          System.gc();
          this.ss = false;
          ImageManager.e(ImageManager.this).post(this);
          return;
          bool = false;
        }
        else if (bool)
        {
          ImageManager.f(ImageManager.this).put(new a.a(this.sm), this.sr);
        }
      }
      ??? = (ImageManager.ImageReceiver)ImageManager.b(ImageManager.this).remove(this.sm);
      if (??? != null) {
        a((ImageManager.ImageReceiver)???, bool);
      }
      this.rk.countDown();
      synchronized (ImageManager.mN())
      {
        ImageManager.mO().remove(this.sm);
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/images/ImageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */