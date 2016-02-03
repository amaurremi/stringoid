package com.pioong.imagecache;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageLoaderThum
{
  ExecutorService executorService;
  FileCache fileCache;
  private Map<ImageView, String> imageViews = Collections.synchronizedMap(new WeakHashMap());
  Context mContext;
  MemoryCache memoryCache = new MemoryCache("thum");
  
  public ImageLoaderThum(Context paramContext)
  {
    this.fileCache = new FileCache(paramContext);
    this.executorService = Executors.newFixedThreadPool(5);
    this.mContext = paramContext;
  }
  
  private Bitmap decodeFile(File paramFile)
  {
    try
    {
      paramFile = BitmapFactory.decodeStream(new FileInputStream(paramFile));
      int j = paramFile.getWidth();
      int k = paramFile.getHeight();
      if (j >= k) {}
      for (int i = dpToPx(80);; i = dpToPx(60))
      {
        float f = j / 100;
        f = i / f;
        return getRoundedCornerBitmap(Bitmap.createScaledBitmap(paramFile, (int)(j * (f / 100.0F)), (int)(k * (f / 100.0F)), true));
      }
      return null;
    }
    catch (FileNotFoundException paramFile) {}
  }
  
  private Bitmap getBitmap(String paramString)
  {
    File localFile = this.fileCache.getFile(paramString);
    Object localObject = decodeFile(localFile);
    if (localObject != null) {
      return (Bitmap)localObject;
    }
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setConnectTimeout(30000);
      paramString.setReadTimeout(30000);
      paramString.setInstanceFollowRedirects(true);
      paramString = paramString.getInputStream();
      localObject = new FileOutputStream(localFile);
      Utils.CopyStream(paramString, (OutputStream)localObject);
      ((OutputStream)localObject).close();
      paramString = decodeFile(localFile);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      if ((paramString instanceof OutOfMemoryError)) {
        this.memoryCache.clear();
      }
    }
    return null;
  }
  
  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-16777216);
    localCanvas.drawRoundRect(localRectF, 15.0F, 15.0F, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  private void queuePhoto(String paramString, ImageView paramImageView, ProgressBar paramProgressBar)
  {
    paramString = new PhotoToLoad(paramString, paramImageView, paramProgressBar);
    this.executorService.submit(new PhotosLoader(paramString));
  }
  
  public void DisplayImage(String paramString, ImageView paramImageView, ProgressBar paramProgressBar)
  {
    this.imageViews.put(paramImageView, paramString);
    Bitmap localBitmap = this.memoryCache.get(paramString);
    if (localBitmap != null)
    {
      paramImageView.setImageBitmap(localBitmap);
      return;
    }
    paramProgressBar.setVisibility(0);
    queuePhoto(paramString, paramImageView, paramProgressBar);
  }
  
  public void clearCache()
  {
    this.memoryCache.clear();
    this.fileCache.clear();
  }
  
  public int dpToPx(int paramInt)
  {
    return (int)(paramInt * this.mContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  boolean imageViewReused(PhotoToLoad paramPhotoToLoad)
  {
    String str = (String)this.imageViews.get(paramPhotoToLoad.imageView);
    return (str == null) || (!str.equals(paramPhotoToLoad.url));
  }
  
  class BitmapDisplayer
    implements Runnable
  {
    Bitmap bitmap;
    ImageLoaderThum.PhotoToLoad photoToLoad;
    
    public BitmapDisplayer(Bitmap paramBitmap, ImageLoaderThum.PhotoToLoad paramPhotoToLoad)
    {
      this.bitmap = paramBitmap;
      this.photoToLoad = paramPhotoToLoad;
    }
    
    public void run()
    {
      if (ImageLoaderThum.this.imageViewReused(this.photoToLoad)) {
        return;
      }
      if (this.bitmap != null) {
        this.photoToLoad.imageView.setImageBitmap(this.bitmap);
      }
      this.photoToLoad.pCircle.setVisibility(8);
    }
  }
  
  private class PhotoToLoad
  {
    public ImageView imageView;
    public ProgressBar pCircle;
    public String url;
    
    public PhotoToLoad(String paramString, ImageView paramImageView, ProgressBar paramProgressBar)
    {
      this.url = paramString;
      this.imageView = paramImageView;
      this.pCircle = paramProgressBar;
    }
  }
  
  class PhotosLoader
    implements Runnable
  {
    ImageLoaderThum.PhotoToLoad photoToLoad;
    
    PhotosLoader(ImageLoaderThum.PhotoToLoad paramPhotoToLoad)
    {
      this.photoToLoad = paramPhotoToLoad;
    }
    
    public void run()
    {
      if (ImageLoaderThum.this.imageViewReused(this.photoToLoad)) {}
      do
      {
        return;
        localObject = ImageLoaderThum.this.getBitmap(this.photoToLoad.url);
        ImageLoaderThum.this.memoryCache.put(this.photoToLoad.url, (Bitmap)localObject);
      } while (ImageLoaderThum.this.imageViewReused(this.photoToLoad));
      Object localObject = new ImageLoaderThum.BitmapDisplayer(ImageLoaderThum.this, (Bitmap)localObject, this.photoToLoad);
      ((Activity)this.photoToLoad.imageView.getContext()).runOnUiThread((Runnable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/imagecache/ImageLoaderThum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */