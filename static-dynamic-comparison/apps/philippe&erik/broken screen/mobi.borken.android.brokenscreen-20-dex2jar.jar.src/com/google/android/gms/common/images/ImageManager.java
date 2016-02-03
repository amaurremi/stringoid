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
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.iq;
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
  private static final Object EU = new Object();
  private static HashSet<Uri> EV = new HashSet();
  private static ImageManager EW;
  private static ImageManager EX;
  private final ExecutorService EY;
  private final b EZ;
  private final gx Fa;
  private final Map<a, ImageReceiver> Fb;
  private final Map<Uri, ImageReceiver> Fc;
  private final Map<Uri, Long> Fd;
  private final Context mContext;
  private final Handler mHandler;
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(Looper.getMainLooper());
    this.EY = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      this.EZ = new b(this.mContext);
      if (iq.ga()) {
        eX();
      }
    }
    for (;;)
    {
      this.Fa = new gx();
      this.Fb = new HashMap();
      this.Fc = new HashMap();
      this.Fd = new HashMap();
      return;
      this.EZ = null;
    }
  }
  
  private Bitmap a(a.a parama)
  {
    if (this.EZ == null) {
      return null;
    }
    return (Bitmap)this.EZ.get(parama);
  }
  
  public static ImageManager a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (EX == null) {
        EX = new ImageManager(paramContext, true);
      }
      return EX;
    }
    if (EW == null) {
      EW = new ImageManager(paramContext, false);
    }
    return EW;
  }
  
  public static ImageManager create(Context paramContext)
  {
    return a(paramContext, false);
  }
  
  private void eX()
  {
    this.mContext.registerComponentCallbacks(new e(this.EZ));
  }
  
  public void a(a parama)
  {
    gy.ay("ImageManager.loadImage() must be called in the main thread");
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
    paramImageView.aj(paramInt);
    a(paramImageView);
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    a(new a.c(paramOnImageLoadedListener, paramUri));
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    paramOnImageLoadedListener = new a.c(paramOnImageLoadedListener, paramUri);
    paramOnImageLoadedListener.aj(paramInt);
    a(paramOnImageLoadedListener);
  }
  
  private final class ImageReceiver
    extends ResultReceiver
  {
    private final ArrayList<a> Fe;
    private final Uri mUri;
    
    ImageReceiver(Uri paramUri)
    {
      super();
      this.mUri = paramUri;
      this.Fe = new ArrayList();
    }
    
    public void b(a parama)
    {
      gy.ay("ImageReceiver.addImageRequest() must be called in the main thread");
      this.Fe.add(parama);
    }
    
    public void c(a parama)
    {
      gy.ay("ImageReceiver.removeImageRequest() must be called in the main thread");
      this.Fe.remove(parama);
    }
    
    public void fa()
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
    extends hr<a.a, Bitmap>
  {
    public b(Context paramContext)
    {
      super();
    }
    
    private static int A(Context paramContext)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      if ((paramContext.getApplicationInfo().flags & 0x100000) != 0)
      {
        i = 1;
        if ((i == 0) || (!iq.fX())) {
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
    private final ParcelFileDescriptor Fg;
    private final Uri mUri;
    
    public c(Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.mUri = paramUri;
      this.Fg = paramParcelFileDescriptor;
    }
    
    public void run()
    {
      gy.az("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      boolean bool1 = false;
      boolean bool2 = false;
      Bitmap localBitmap = null;
      CountDownLatch localCountDownLatch = null;
      if (this.Fg != null) {}
      try
      {
        localBitmap = BitmapFactory.decodeFileDescriptor(this.Fg.getFileDescriptor());
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
            this.Fg.close();
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
    private final a Fh;
    
    public d(a parama)
    {
      this.Fh = parama;
    }
    
    public void run()
    {
      gy.ay("LoadImageRunnable must be executed on the main thread");
      Object localObject1 = (ImageManager.ImageReceiver)ImageManager.a(ImageManager.this).get(this.Fh);
      if (localObject1 != null)
      {
        ImageManager.a(ImageManager.this).remove(this.Fh);
        ((ImageManager.ImageReceiver)localObject1).c(this.Fh);
      }
      a.a locala = this.Fh.Fj;
      if (locala.uri == null)
      {
        this.Fh.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), true);
        return;
      }
      localObject1 = ImageManager.a(ImageManager.this, locala);
      if (localObject1 != null)
      {
        this.Fh.a(ImageManager.b(ImageManager.this), (Bitmap)localObject1, true);
        return;
      }
      localObject1 = (Long)ImageManager.d(ImageManager.this).get(locala.uri);
      if (localObject1 != null)
      {
        if (SystemClock.elapsedRealtime() - ((Long)localObject1).longValue() < 3600000L)
        {
          this.Fh.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), true);
          return;
        }
        ImageManager.d(ImageManager.this).remove(locala.uri);
      }
      this.Fh.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this));
      ??? = (ImageManager.ImageReceiver)ImageManager.e(ImageManager.this).get(locala.uri);
      localObject1 = ???;
      if (??? == null)
      {
        localObject1 = new ImageManager.ImageReceiver(ImageManager.this, locala.uri);
        ImageManager.e(ImageManager.this).put(locala.uri, localObject1);
      }
      ((ImageManager.ImageReceiver)localObject1).b(this.Fh);
      if (!(this.Fh instanceof a.c)) {
        ImageManager.a(ImageManager.this).put(this.Fh, localObject1);
      }
      synchronized (ImageManager.eY())
      {
        if (!ImageManager.eZ().contains(locala.uri))
        {
          ImageManager.eZ().add(locala.uri);
          ((ImageManager.ImageReceiver)localObject1).fa();
        }
        return;
      }
    }
  }
  
  private static final class e
    implements ComponentCallbacks2
  {
    private final ImageManager.b EZ;
    
    public e(ImageManager.b paramb)
    {
      this.EZ = paramb;
    }
    
    public void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public void onLowMemory()
    {
      this.EZ.evictAll();
    }
    
    public void onTrimMemory(int paramInt)
    {
      if (paramInt >= 60) {
        this.EZ.evictAll();
      }
      while (paramInt < 20) {
        return;
      }
      this.EZ.trimToSize(this.EZ.size() / 2);
    }
  }
  
  private final class f
    implements Runnable
  {
    private boolean Fi;
    private final CountDownLatch kI;
    private final Bitmap mBitmap;
    private final Uri mUri;
    
    public f(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
    {
      this.mUri = paramUri;
      this.mBitmap = paramBitmap;
      this.Fi = paramBoolean;
      this.kI = paramCountDownLatch;
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
      gy.ay("OnBitmapLoadedRunnable must be executed in the main thread");
      boolean bool;
      if (this.mBitmap != null) {
        bool = true;
      }
      while (ImageManager.h(ImageManager.this) != null) {
        if (this.Fi)
        {
          ImageManager.h(ImageManager.this).evictAll();
          System.gc();
          this.Fi = false;
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
      this.kI.countDown();
      synchronized (ImageManager.eY())
      {
        ImageManager.eZ().remove(this.mUri);
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/images/ImageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */