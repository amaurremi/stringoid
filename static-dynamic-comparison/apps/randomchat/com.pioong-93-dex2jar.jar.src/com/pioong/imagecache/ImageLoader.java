package com.pioong.imagecache;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

public class ImageLoader
{
  ExecutorService executorService;
  FileCache fileCache;
  private Map<ImageView, String> imageViews = Collections.synchronizedMap(new WeakHashMap());
  MemoryCache memoryCache = new MemoryCache();
  
  public ImageLoader(Context paramContext)
  {
    this.fileCache = new FileCache(paramContext);
    this.executorService = Executors.newFixedThreadPool(5);
  }
  
  private Bitmap decodeFile(File paramFile)
  {
    try
    {
      paramFile = BitmapFactory.decodeStream(new FileInputStream(paramFile));
      return paramFile;
    }
    catch (FileNotFoundException paramFile) {}
    return null;
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
  
  public Bitmap getImage(String paramString)
  {
    Bitmap localBitmap = this.memoryCache.get(paramString);
    paramString = localBitmap;
    if (localBitmap == null) {
      paramString = null;
    }
    return paramString;
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
    ImageLoader.PhotoToLoad photoToLoad;
    
    public BitmapDisplayer(Bitmap paramBitmap, ImageLoader.PhotoToLoad paramPhotoToLoad)
    {
      this.bitmap = paramBitmap;
      this.photoToLoad = paramPhotoToLoad;
    }
    
    public void run()
    {
      if (ImageLoader.this.imageViewReused(this.photoToLoad)) {
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
    ImageLoader.PhotoToLoad photoToLoad;
    
    PhotosLoader(ImageLoader.PhotoToLoad paramPhotoToLoad)
    {
      this.photoToLoad = paramPhotoToLoad;
    }
    
    public void run()
    {
      if (ImageLoader.this.imageViewReused(this.photoToLoad)) {}
      do
      {
        return;
        localObject = ImageLoader.this.getBitmap(this.photoToLoad.url);
        ImageLoader.this.memoryCache.put(this.photoToLoad.url, (Bitmap)localObject);
      } while (ImageLoader.this.imageViewReused(this.photoToLoad));
      Object localObject = new ImageLoader.BitmapDisplayer(ImageLoader.this, (Bitmap)localObject, this.photoToLoad);
      ((Activity)this.photoToLoad.imageView.getContext()).runOnUiThread((Runnable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/imagecache/ImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */