package com.androidwasabi.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ImageLoader
{
  private static final int IMAGE_CACHING_TIME = 14;
  public static final String TAG = "ImageLoader";
  public static final boolean debug = false;
  private File cacheDir;
  private ImageLoader.OnImageCacheListener cacheListener;
  private final Handler downloadImageHandler = new ImageLoader.1(this);
  private final Map<String, ImageLoader.ImageItem> imageMap = new HashMap();
  private ImageLoader.OnImageLoaderListener listener;
  private boolean useCache = true;
  
  public ImageLoader()
  {
    this.listener = null;
  }
  
  public ImageLoader(ImageLoader.OnImageLoaderListener paramOnImageLoaderListener)
  {
    this.listener = paramOnImageLoaderListener;
  }
  
  private void downloadImageTask(String paramString)
  {
    new Thread(new ImageLoader.2(this, paramString)).start();
  }
  
  public void destroy()
  {
    this.imageMap.clear();
    this.listener = null;
  }
  
  public Bitmap getImage(String paramString)
  {
    if (this.imageMap.containsKey(paramString))
    {
      paramString = (ImageLoader.ImageItem)this.imageMap.get(paramString);
      if (paramString.bitmap == null) {
        return null;
      }
      if (paramString.bitmap.isRecycled())
      {
        paramString.bitmap = null;
        return null;
      }
      return paramString.bitmap;
    }
    return null;
  }
  
  public Bitmap getImageFromCache(String paramString)
  {
    try
    {
      paramString = paramString.substring(paramString.lastIndexOf('/') + 1);
      paramString = new File(this.cacheDir, paramString);
      if (!paramString.exists()) {
        throw new IOException();
      }
      if (!paramString.canRead()) {
        throw new IOException();
      }
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramString));
      Bitmap localBitmap = BitmapFactory.decodeStream(localBufferedInputStream);
      paramString = localBitmap;
      if (localBufferedInputStream != null)
      {
        localBufferedInputStream.close();
        return localBitmap;
      }
    }
    catch (Exception paramString)
    {
      paramString = null;
    }
    return paramString;
  }
  
  public void loadImage(String paramString)
  {
    loadImage(paramString, null);
  }
  
  public void loadImage(String paramString, Object paramObject)
  {
    if (this.imageMap.containsKey(paramString))
    {
      localImageItem = (ImageLoader.ImageItem)this.imageMap.get(paramString);
      if (localImageItem.bitmap == null)
      {
        localImageItem.data = paramObject;
        if (!localImageItem.loading.booleanValue()) {}
      }
      do
      {
        return;
        localImageItem.loading = Boolean.valueOf(true);
        downloadImageTask(paramString);
        return;
        localImageItem.data = paramObject;
        if (localImageItem.bitmap.isRecycled())
        {
          localImageItem.bitmap = null;
          loadImage(paramString, paramObject);
          return;
        }
      } while (this.listener == null);
      this.listener.onImageLoaded(localImageItem.bitmap, localImageItem.data);
      return;
    }
    ImageLoader.ImageItem localImageItem = new ImageLoader.ImageItem();
    localImageItem.data = paramObject;
    this.imageMap.put(paramString, localImageItem);
    localImageItem.loading = Boolean.valueOf(true);
    downloadImageTask(paramString);
  }
  
  public void saveImageCache(String[] paramArrayOfString)
  {
    new ImageLoader.SaveImageCacheTask(this, null).execute(new String[][] { paramArrayOfString });
  }
  
  public void setCache(boolean paramBoolean, File paramFile)
  {
    this.useCache = paramBoolean;
    this.cacheDir = paramFile;
  }
  
  public void setCacheListener(ImageLoader.OnImageCacheListener paramOnImageCacheListener)
  {
    this.cacheListener = paramOnImageCacheListener;
  }
  
  public void setListener(ImageLoader.OnImageLoaderListener paramOnImageLoaderListener)
  {
    this.listener = paramOnImageLoaderListener;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/ImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */