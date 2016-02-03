package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.ja;
import com.google.android.gms.internal.kc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  private static final Object Kl = new Object();
  private static HashSet<Uri> Km = new HashSet();
  private static ImageManager Kn;
  private static ImageManager Ko;
  private final ExecutorService Kp;
  private final b Kq;
  private final iz Kr;
  private final Map<a, ImageReceiver> Ks;
  private final Map<Uri, ImageReceiver> Kt;
  private final Map<Uri, Long> Ku;
  private final Context mContext;
  private final Handler mHandler;
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(Looper.getMainLooper());
    this.Kp = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      this.Kq = new b(this.mContext);
      if (kc.hE()) {
        gH();
      }
    }
    for (;;)
    {
      this.Kr = new iz();
      this.Ks = new HashMap();
      this.Kt = new HashMap();
      this.Ku = new HashMap();
      return;
      this.Kq = null;
    }
  }
  
  private Bitmap a(a.a parama)
  {
    if (this.Kq == null) {
      return null;
    }
    return (Bitmap)this.Kq.get(parama);
  }
  
  public static ImageManager c(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Ko == null) {
        Ko = new ImageManager(paramContext, true);
      }
      return Ko;
    }
    if (Kn == null) {
      Kn = new ImageManager(paramContext, false);
    }
    return Kn;
  }
  
  public static ImageManager create(Context paramContext)
  {
    return c(paramContext, false);
  }
  
  private void gH()
  {
    this.mContext.registerComponentCallbacks(new e(this.Kq));
  }
  
  public void a(a parama)
  {
    com.google.android.gms.common.internal.a.aT("ImageManager.loadImage() must be called in the main thread");
    new d(parama).run();
  }
  
  public void loadImage(ImageView paramImageView, int paramInt)
  {
    a(new a.b(paramImageView, paramInt));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri)
  {
    a(new a.b(paramImageView, paramUri));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    paramImageView = new a.b(paramImageView, paramUri);
    paramImageView.aw(paramInt);
    a(paramImageView);
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    a(new a.c(paramOnImageLoadedListener, paramUri));
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    paramOnImageLoadedListener = new a.c(paramOnImageLoadedListener, paramUri);
    paramOnImageLoadedListener.aw(paramInt);
    a(paramOnImageLoadedListener);
  }
  
  private final class ImageReceiver
    extends ResultReceiver
  {
    private final ArrayList<a> Kv;
    private final Uri mUri;
    
    ImageReceiver(Uri paramUri)
    {
      super();
      this.mUri = paramUri;
      this.Kv = new ArrayList();
    }
    
    public void b(a parama)
    {
      com.google.android.gms.common.internal.a.aT("ImageReceiver.addImageRequest() must be called in the main thread");
      this.Kv.add(parama);
    }
    
    public void c(a parama)
    {
      com.google.android.gms.common.internal.a.aT("ImageReceiver.removeImageRequest() must be called in the main thread");
      this.Kv.remove(parama);
    }
    
    public void gK()
    {
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.b(ImageManager.this).sendBroadcast(localIntent);
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.f(ImageManager.this).execute(new ImageManager.c(ImageManager.this, this.mUri, paramBundle));
    }
  }
  
  public static abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }
  
  private static final class a
  {
    static int a(ActivityManager paramActivityManager)
    {
      return paramActivityManager.getLargeMemoryClass();
    }
  }
  
  private static final class b
    extends ja<a.a, Bitmap>
  {
    public b(Context paramContext)
    {
      super();
    }
    
    private static int I(Context paramContext)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      if ((paramContext.getApplicationInfo().flags & 0x100000) != 0)
      {
        i = 1;
        if ((i == 0) || (!kc.hB())) {
          break label55;
        }
      }
      label55:
      for (int i = ImageManager.a.a(localActivityManager);; i = localActivityManager.getMemoryClass())
      {
        return (int)(i * 1048576 * 0.33F);
        i = 0;
        break;
      }
    }
    
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
    private final ParcelFileDescriptor Kx;
    private final Uri mUri;
    
    public c(Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.mUri = paramUri;
      this.Kx = paramParcelFileDescriptor;
    }
    
    public void run()
    {
      com.google.android.gms.common.internal.a.aU("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      boolean bool1 = false;
      boolean bool2 = false;
      Bitmap localBitmap = null;
      CountDownLatch localCountDownLatch = null;
      if (this.Kx != null) {}
      try
      {
        localBitmap = BitmapFactory.decodeFileDescriptor(this.Kx.getFileDescriptor());
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
            this.Kx.close();
            localCountDownLatch = new CountDownLatch(1);
            ImageManager.g(ImageManager.this).post(new ImageManager.f(ImageManager.this, this.mUri, localBitmap, bool1, localCountDownLatch));
            try
            {
              localCountDownLatch.await();
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
            localOutOfMemoryError = localOutOfMemoryError;
            Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, localOutOfMemoryError);
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
    private final a Ky;
    
    public d(a parama)
    {
      this.Ky = parama;
    }
    
    public void run()
    {
      com.google.android.gms.common.internal.a.aT("LoadImageRunnable must be executed on the main thread");
      Object localObject1 = (ImageManager.ImageReceiver)ImageManager.a(ImageManager.this).get(this.Ky);
      if (localObject1 != null)
      {
        ImageManager.a(ImageManager.this).remove(this.Ky);
        ((ImageManager.ImageReceiver)localObject1).c(this.Ky);
      }
      a.a locala = this.Ky.KA;
      if (locala.uri == null)
      {
        this.Ky.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), true);
        return;
      }
      localObject1 = ImageManager.a(ImageManager.this, locala);
      if (localObject1 != null)
      {
        this.Ky.a(ImageManager.b(ImageManager.this), (Bitmap)localObject1, true);
        return;
      }
      localObject1 = (Long)ImageManager.d(ImageManager.this).get(locala.uri);
      if (localObject1 != null)
      {
        if (SystemClock.elapsedRealtime() - ((Long)localObject1).longValue() < 3600000L)
        {
          this.Ky.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), true);
          return;
        }
        ImageManager.d(ImageManager.this).remove(locala.uri);
      }
      this.Ky.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this));
      ??? = (ImageManager.ImageReceiver)ImageManager.e(ImageManager.this).get(locala.uri);
      localObject1 = ???;
      if (??? == null)
      {
        localObject1 = new ImageManager.ImageReceiver(ImageManager.this, locala.uri);
        ImageManager.e(ImageManager.this).put(locala.uri, localObject1);
      }
      ((ImageManager.ImageReceiver)localObject1).b(this.Ky);
      if (!(this.Ky instanceof a.c)) {
        ImageManager.a(ImageManager.this).put(this.Ky, localObject1);
      }
      synchronized (ImageManager.gI())
      {
        if (!ImageManager.gJ().contains(locala.uri))
        {
          ImageManager.gJ().add(locala.uri);
          ((ImageManager.ImageReceiver)localObject1).gK();
        }
        return;
      }
    }
  }
  
  private static final class e
    implements ComponentCallbacks2
  {
    private final ImageManager.b Kq;
    
    public e(ImageManager.b paramb)
    {
      this.Kq = paramb;
    }
    
    public void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public void onLowMemory()
    {
      this.Kq.evictAll();
    }
    
    public void onTrimMemory(int paramInt)
    {
      if (paramInt >= 60) {
        this.Kq.evictAll();
      }
      while (paramInt < 20) {
        return;
      }
      this.Kq.trimToSize(this.Kq.size() / 2);
    }
  }
  
  private final class f
    implements Runnable
  {
    private boolean Kz;
    private final Bitmap mBitmap;
    private final Uri mUri;
    private final CountDownLatch mg;
    
    public f(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
    {
      this.mUri = paramUri;
      this.mBitmap = paramBitmap;
      this.Kz = paramBoolean;
      this.mg = paramCountDownLatch;
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
          locala.a(ImageManager.b(ImageManager.this), this.mBitmap, false);
        }
        for (;;)
        {
          if (!(locala instanceof a.c)) {
            ImageManager.a(ImageManager.this).remove(locala);
          }
          i += 1;
          break;
          ImageManager.d(ImageManager.this).put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
          locala.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), false);
        }
      }
    }
    
    public void run()
    {
      com.google.android.gms.common.internal.a.aT("OnBitmapLoadedRunnable must be executed in the main thread");
      boolean bool;
      if (this.mBitmap != null) {
        bool = true;
      }
      while (ImageManager.h(ImageManager.this) != null) {
        if (this.Kz)
        {
          ImageManager.h(ImageManager.this).evictAll();
          System.gc();
          this.Kz = false;
          ImageManager.g(ImageManager.this).post(this);
          return;
          bool = false;
        }
        else if (bool)
        {
          ImageManager.h(ImageManager.this).put(new a.a(this.mUri), this.mBitmap);
        }
      }
      ??? = (ImageManager.ImageReceiver)ImageManager.e(ImageManager.this).remove(this.mUri);
      if (??? != null) {
        a((ImageManager.ImageReceiver)???, bool);
      }
      this.mg.countDown();
      synchronized (ImageManager.gI())
      {
        ImageManager.gJ().remove(this.mUri);
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/images/ImageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */