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
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.ek;
import com.google.android.gms.internal.fg;
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
  private static final Object ob = new Object();
  private static HashSet<Uri> oc = new HashSet();
  private static ImageManager od;
  private static ImageManager oe;
  private final Context mContext;
  private final Handler mHandler;
  private final ExecutorService of;
  private final b og;
  private final Map<a, ImageReceiver> oh;
  private final Map<Uri, ImageReceiver> oi;
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(Looper.getMainLooper());
    this.of = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      this.og = new b(this.mContext);
      if (fg.cG()) {
        bz();
      }
    }
    for (;;)
    {
      this.oh = new HashMap();
      this.oi = new HashMap();
      return;
      this.og = null;
    }
  }
  
  private Bitmap a(a.a parama)
  {
    if (this.og == null) {
      return null;
    }
    return (Bitmap)this.og.get(parama);
  }
  
  public static ImageManager a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (oe == null) {
        oe = new ImageManager(paramContext, true);
      }
      return oe;
    }
    if (od == null) {
      od = new ImageManager(paramContext, false);
    }
    return od;
  }
  
  private boolean b(a parama)
  {
    ds.N("ImageManager.cleanupHashMaps() must be called in the main thread");
    if (parama.os == 1) {
      return true;
    }
    ImageReceiver localImageReceiver = (ImageReceiver)this.oh.get(parama);
    if (localImageReceiver == null) {
      return true;
    }
    if (localImageReceiver.ok) {
      return false;
    }
    this.oh.remove(parama);
    localImageReceiver.d(parama);
    return true;
  }
  
  private void bz()
  {
    this.mContext.registerComponentCallbacks(new e(this.og));
  }
  
  public static ImageManager create(Context paramContext)
  {
    return a(paramContext, false);
  }
  
  public void a(a parama)
  {
    ds.N("ImageManager.loadImage() must be called in the main thread");
    boolean bool = b(parama);
    parama = new d(parama);
    if (bool)
    {
      parama.run();
      return;
    }
    this.mHandler.post(parama);
  }
  
  public void loadImage(ImageView paramImageView, int paramInt)
  {
    a locala = new a(paramInt);
    locala.a(paramImageView);
    a(locala);
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri)
  {
    paramUri = new a(paramUri);
    paramUri.a(paramImageView);
    a(paramUri);
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    paramUri = new a(paramUri);
    paramUri.F(paramInt);
    paramUri.a(paramImageView);
    a(paramUri);
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    paramUri = new a(paramUri);
    paramUri.a(paramOnImageLoadedListener);
    a(paramUri);
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    paramUri = new a(paramUri);
    paramUri.F(paramInt);
    paramUri.a(paramOnImageLoadedListener);
    a(paramUri);
  }
  
  private final class ImageReceiver
    extends ResultReceiver
  {
    private final Uri mUri;
    private final ArrayList<a> oj;
    boolean ok = false;
    
    ImageReceiver(Uri paramUri)
    {
      super();
      this.mUri = paramUri;
      this.oj = new ArrayList();
    }
    
    public void bB()
    {
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.a(ImageManager.this).sendBroadcast(localIntent);
    }
    
    public void c(a parama)
    {
      if (!this.ok) {}
      for (boolean bool = true;; bool = false)
      {
        ds.a(bool, "Cannot add an ImageRequest when mHandlingRequests is true");
        ds.N("ImageReceiver.addImageRequest() must be called in the main thread");
        this.oj.add(parama);
        return;
      }
    }
    
    public void d(a parama)
    {
      if (!this.ok) {}
      for (boolean bool = true;; bool = false)
      {
        ds.a(bool, "Cannot remove an ImageRequest when mHandlingRequests is true");
        ds.N("ImageReceiver.removeImageRequest() must be called in the main thread");
        this.oj.remove(parama);
        return;
      }
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.d(ImageManager.this).execute(new ImageManager.c(ImageManager.this, this.mUri, paramBundle));
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
    extends ek<a.a, Bitmap>
  {
    public b(Context paramContext)
    {
      super();
    }
    
    private static int q(Context paramContext)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      if ((paramContext.getApplicationInfo().flags & 0x100000) != 0)
      {
        i = 1;
        if ((i == 0) || (!fg.cD())) {
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
    private final Uri mUri;
    private final ParcelFileDescriptor om;
    
    public c(Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.mUri = paramUri;
      this.om = paramParcelFileDescriptor;
    }
    
    public void run()
    {
      ds.O("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      boolean bool1 = false;
      boolean bool2 = false;
      Bitmap localBitmap = null;
      CountDownLatch localCountDownLatch = null;
      if (this.om != null) {}
      try
      {
        localBitmap = BitmapFactory.decodeFileDescriptor(this.om.getFileDescriptor());
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
            this.om.close();
            localCountDownLatch = new CountDownLatch(1);
            ImageManager.e(ImageManager.this).post(new ImageManager.f(ImageManager.this, this.mUri, localBitmap, bool1, localCountDownLatch));
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
    private final a on;
    
    public d(a parama)
    {
      this.on = parama;
    }
    
    public void run()
    {
      ds.N("LoadImageRunnable must be executed on the main thread");
      ImageManager.a(ImageManager.this, this.on);
      a.a locala = this.on.op;
      if (locala.uri == null)
      {
        this.on.b(ImageManager.a(ImageManager.this), true);
        return;
      }
      Object localObject1 = ImageManager.a(ImageManager.this, locala);
      if (localObject1 != null)
      {
        this.on.a(ImageManager.a(ImageManager.this), (Bitmap)localObject1, true);
        return;
      }
      this.on.r(ImageManager.a(ImageManager.this));
      ??? = (ImageManager.ImageReceiver)ImageManager.b(ImageManager.this).get(locala.uri);
      localObject1 = ???;
      if (??? == null)
      {
        localObject1 = new ImageManager.ImageReceiver(ImageManager.this, locala.uri);
        ImageManager.b(ImageManager.this).put(locala.uri, localObject1);
      }
      ((ImageManager.ImageReceiver)localObject1).c(this.on);
      if (this.on.os != 1) {
        ImageManager.c(ImageManager.this).put(this.on, localObject1);
      }
      synchronized (ImageManager.aZ())
      {
        if (!ImageManager.bA().contains(locala.uri))
        {
          ImageManager.bA().add(locala.uri);
          ((ImageManager.ImageReceiver)localObject1).bB();
        }
        return;
      }
    }
  }
  
  private static final class e
    implements ComponentCallbacks2
  {
    private final ImageManager.b og;
    
    public e(ImageManager.b paramb)
    {
      this.og = paramb;
    }
    
    public void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public void onLowMemory()
    {
      this.og.evictAll();
    }
    
    public void onTrimMemory(int paramInt)
    {
      if (paramInt >= 60) {
        this.og.evictAll();
      }
      while (paramInt < 20) {
        return;
      }
      this.og.trimToSize(this.og.size() / 2);
    }
  }
  
  private final class f
    implements Runnable
  {
    private final Bitmap mBitmap;
    private final Uri mUri;
    private final CountDownLatch mX;
    private boolean oo;
    
    public f(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
    {
      this.mUri = paramUri;
      this.mBitmap = paramBitmap;
      this.oo = paramBoolean;
      this.mX = paramCountDownLatch;
    }
    
    private void a(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
    {
      paramImageReceiver.ok = true;
      ArrayList localArrayList = ImageManager.ImageReceiver.a(paramImageReceiver);
      int j = localArrayList.size();
      int i = 0;
      if (i < j)
      {
        a locala = (a)localArrayList.get(i);
        if (paramBoolean) {
          locala.a(ImageManager.a(ImageManager.this), this.mBitmap, false);
        }
        for (;;)
        {
          if (locala.os != 1) {
            ImageManager.c(ImageManager.this).remove(locala);
          }
          i += 1;
          break;
          locala.b(ImageManager.a(ImageManager.this), false);
        }
      }
      paramImageReceiver.ok = false;
    }
    
    public void run()
    {
      ds.N("OnBitmapLoadedRunnable must be executed in the main thread");
      boolean bool;
      if (this.mBitmap != null) {
        bool = true;
      }
      while (ImageManager.f(ImageManager.this) != null) {
        if (this.oo)
        {
          ImageManager.f(ImageManager.this).evictAll();
          System.gc();
          this.oo = false;
          ImageManager.e(ImageManager.this).post(this);
          return;
          bool = false;
        }
        else if (bool)
        {
          ImageManager.f(ImageManager.this).put(new a.a(this.mUri), this.mBitmap);
        }
      }
      ??? = (ImageManager.ImageReceiver)ImageManager.b(ImageManager.this).remove(this.mUri);
      if (??? != null) {
        a((ImageManager.ImageReceiver)???, bool);
      }
      this.mX.countDown();
      synchronized (ImageManager.aZ())
      {
        ImageManager.bA().remove(this.mUri);
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/common/images/ImageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */