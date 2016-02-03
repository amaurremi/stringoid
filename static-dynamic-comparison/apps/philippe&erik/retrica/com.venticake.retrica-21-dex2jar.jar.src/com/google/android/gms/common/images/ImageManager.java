package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.ip;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  private static final Object EX = new Object();
  private static HashSet<Uri> EY = new HashSet();
  private static ImageManager EZ;
  private static ImageManager Fa;
  private final ExecutorService Fb;
  private final d Fc;
  private final gw Fd;
  private final Map<a, ImageManager.ImageReceiver> Fe;
  private final Map<Uri, ImageManager.ImageReceiver> Ff;
  private final Map<Uri, Long> Fg;
  private final Context mContext;
  private final Handler mHandler;
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(Looper.getMainLooper());
    this.Fb = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      this.Fc = new d(this.mContext);
      if (ip.gf()) {
        fc();
      }
    }
    for (;;)
    {
      this.Fd = new gw();
      this.Fe = new HashMap();
      this.Ff = new HashMap();
      this.Fg = new HashMap();
      return;
      this.Fc = null;
    }
  }
  
  private Bitmap a(i parami)
  {
    if (this.Fc == null) {
      return null;
    }
    return (Bitmap)this.Fc.get(parami);
  }
  
  public static ImageManager a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Fa == null) {
        Fa = new ImageManager(paramContext, true);
      }
      return Fa;
    }
    if (EZ == null) {
      EZ = new ImageManager(paramContext, false);
    }
    return EZ;
  }
  
  public static ImageManager create(Context paramContext)
  {
    return a(paramContext, false);
  }
  
  private void fc()
  {
    this.mContext.registerComponentCallbacks(new g(this.Fc));
  }
  
  public void a(a parama)
  {
    gx.ay("ImageManager.loadImage() must be called in the main thread");
    new f(this, parama).run();
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
  
  public void loadImage(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    a(new a.c(paramOnImageLoadedListener, paramUri));
  }
  
  public void loadImage(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    paramOnImageLoadedListener = new a.c(paramOnImageLoadedListener, paramUri);
    paramOnImageLoadedListener.aj(paramInt);
    a(paramOnImageLoadedListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/images/ImageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */