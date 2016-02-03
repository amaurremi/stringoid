package com.mopub.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.mopub.common.util.Streams;
import com.mopub.nativeads.util.Utils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ImageService
{
  private static int COMPRESSION_QUALITY = 25;
  
  static byte[] bitmapToByteArray(Bitmap paramBitmap)
  {
    Object localObject3 = null;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Streams.closeStream(paramBitmap);
    }
    finally
    {
      try
      {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, COMPRESSION_QUALITY, localByteArrayOutputStream);
        paramBitmap = localByteArrayOutputStream.toByteArray();
        Streams.closeStream(localByteArrayOutputStream);
        return paramBitmap;
      }
      finally
      {
        paramBitmap = (Bitmap)localObject1;
        Object localObject2 = localObject4;
      }
      localObject1 = finally;
      paramBitmap = (Bitmap)localObject3;
    }
    throw ((Throwable)localObject1);
  }
  
  static Bitmap byteArrayToBitmap(byte[] paramArrayOfByte)
  {
    return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  static void get(Context paramContext, List<String> paramList, ImageServiceListener paramImageServiceListener)
  {
    CacheService.initializeCaches(paramContext);
    get(paramList, paramImageServiceListener);
  }
  
  static void get(List<String> paramList, ImageServiceListener paramImageServiceListener)
  {
    HashMap localHashMap = new HashMap(paramList.size());
    paramList = getBitmapsFromMemoryCache(paramList, localHashMap);
    if (paramList.isEmpty())
    {
      paramImageServiceListener.onSuccess(localHashMap);
      return;
    }
    try
    {
      paramList = new ImageDiskTaskManager(paramList, new ImageDiskTaskManagerListener(paramImageServiceListener, localHashMap));
      paramList.execute();
      return;
    }
    catch (IllegalArgumentException paramList)
    {
      Utils.MoPubLog("Unable to initialize ImageDiskTaskManager", paramList);
      paramImageServiceListener.onFail();
    }
  }
  
  @Deprecated
  static Bitmap getBitmapFromDiskCache(String paramString)
  {
    Object localObject = null;
    byte[] arrayOfByte = CacheService.getFromDiskCache(paramString);
    paramString = (String)localObject;
    if (arrayOfByte != null) {
      paramString = byteArrayToBitmap(arrayOfByte);
    }
    return paramString;
  }
  
  static Bitmap getBitmapFromMemoryCache(String paramString)
  {
    Object localObject = null;
    byte[] arrayOfByte = CacheService.getFromMemoryCache(paramString);
    paramString = (String)localObject;
    if (arrayOfByte != null) {
      paramString = byteArrayToBitmap(arrayOfByte);
    }
    return paramString;
  }
  
  static List<String> getBitmapsFromMemoryCache(List<String> paramList, Map<String, Bitmap> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      Bitmap localBitmap = getBitmapFromMemoryCache(str);
      if (localBitmap != null) {
        paramMap.put(str, localBitmap);
      } else {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
  
  static void putBitmapInCache(String paramString, Bitmap paramBitmap)
  {
    CacheService.put(paramString, bitmapToByteArray(paramBitmap));
  }
  
  static void putBitmapsInCache(Map<String, Bitmap> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      Utils.MoPubLog("Caching bitmap: " + (String)localEntry.getKey());
      putBitmapInCache((String)localEntry.getKey(), (Bitmap)localEntry.getValue());
    }
  }
  
  private static class ImageDiskTaskManagerListener
    implements ImageTaskManager.ImageTaskManagerListener
  {
    private final Map<String, Bitmap> mBitmaps;
    private final ImageService.ImageServiceListener mImageServiceListener;
    
    ImageDiskTaskManagerListener(ImageService.ImageServiceListener paramImageServiceListener, Map<String, Bitmap> paramMap)
    {
      this.mImageServiceListener = paramImageServiceListener;
      this.mBitmaps = paramMap;
    }
    
    public void onFail()
    {
      this.mImageServiceListener.onFail();
    }
    
    public void onSuccess(Map<String, Bitmap> paramMap)
    {
      ArrayList localArrayList = new ArrayList();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (localEntry.getValue() == null)
        {
          localArrayList.add(localEntry.getKey());
        }
        else
        {
          ImageService.putBitmapInCache((String)localEntry.getKey(), (Bitmap)localEntry.getValue());
          this.mBitmaps.put(localEntry.getKey(), localEntry.getValue());
        }
      }
      if (localArrayList.isEmpty())
      {
        this.mImageServiceListener.onSuccess(this.mBitmaps);
        return;
      }
      try
      {
        paramMap = new ImageDownloadTaskManager(localArrayList, new ImageService.ImageNetworkTaskManagerListener(this.mImageServiceListener, this.mBitmaps));
        paramMap.execute();
        return;
      }
      catch (IllegalArgumentException paramMap)
      {
        Utils.MoPubLog("Unable to initialize ImageDownloadTaskManager", paramMap);
        this.mImageServiceListener.onFail();
      }
    }
  }
  
  private static class ImageNetworkTaskManagerListener
    implements ImageTaskManager.ImageTaskManagerListener
  {
    private final Map<String, Bitmap> mBitmaps;
    private final ImageService.ImageServiceListener mImageServiceListener;
    
    ImageNetworkTaskManagerListener(ImageService.ImageServiceListener paramImageServiceListener, Map<String, Bitmap> paramMap)
    {
      this.mImageServiceListener = paramImageServiceListener;
      this.mBitmaps = paramMap;
    }
    
    public void onFail()
    {
      this.mImageServiceListener.onFail();
    }
    
    public void onSuccess(Map<String, Bitmap> paramMap)
    {
      ImageService.putBitmapsInCache(paramMap);
      this.mBitmaps.putAll(paramMap);
      this.mImageServiceListener.onSuccess(this.mBitmaps);
    }
  }
  
  static abstract interface ImageServiceListener
  {
    public abstract void onFail();
    
    public abstract void onSuccess(Map<String, Bitmap> paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/ImageService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */