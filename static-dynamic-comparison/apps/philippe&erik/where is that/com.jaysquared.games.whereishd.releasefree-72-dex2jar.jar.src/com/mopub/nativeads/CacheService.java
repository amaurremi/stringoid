package com.mopub.nativeads;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.LruCache;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Streams;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class CacheService
{
  private static final int APP_VERSION = 1;
  static final String UNIQUE_CACHE_NAME = "mopub-cache";
  private static final int VALUE_COUNT = 1;
  private static DiskLruCache sDiskLruCache;
  private static MemoryLruCache sMemoryLruCache;
  
  @Deprecated
  static void clearAndNullCaches()
  {
    if (sDiskLruCache != null) {}
    try
    {
      sDiskLruCache.delete();
      sDiskLruCache = null;
      if (sMemoryLruCache != null)
      {
        sMemoryLruCache.evictAll();
        sMemoryLruCache = null;
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        sDiskLruCache = null;
      }
    }
  }
  
  static String createValidDiskCacheKey(String paramString)
  {
    return com.mopub.common.util.Utils.sha1(paramString);
  }
  
  static byte[] get(String paramString)
  {
    byte[] arrayOfByte = getFromMemoryCache(paramString);
    if (arrayOfByte != null) {
      return arrayOfByte;
    }
    return getFromDiskCache(paramString);
  }
  
  static File getDiskCacheDirectory(Context paramContext)
  {
    paramContext = paramContext.getCacheDir().getPath();
    return new File(paramContext + File.separator + "mopub-cache");
  }
  
  @Deprecated
  static DiskLruCache getDiskLruCache()
  {
    return sDiskLruCache;
  }
  
  static byte[] getFromDiskCache(String paramString)
  {
    Object localObject2;
    if (sDiskLruCache == null) {
      localObject2 = null;
    }
    for (;;)
    {
      return (byte[])localObject2;
      byte[] arrayOfByte = null;
      BufferedInputStream localBufferedInputStream = null;
      localObject2 = null;
      String str = null;
      Object localObject1 = arrayOfByte;
      try
      {
        paramString = sDiskLruCache.get(createValidDiskCacheKey(paramString));
        if (paramString == null)
        {
          if (paramString != null) {
            paramString.close();
          }
          return null;
        }
        localObject1 = arrayOfByte;
        str = paramString;
        localObject2 = paramString;
        InputStream localInputStream = paramString.getInputStream(0);
        localObject1 = localBufferedInputStream;
        if (localInputStream != null)
        {
          localObject1 = arrayOfByte;
          str = paramString;
          localObject2 = paramString;
          arrayOfByte = new byte[(int)paramString.getLength(0)];
          localObject1 = arrayOfByte;
          str = paramString;
          localObject2 = paramString;
          localBufferedInputStream = new BufferedInputStream(localInputStream);
        }
        try
        {
          Streams.readStream(localBufferedInputStream, arrayOfByte);
          localObject1 = arrayOfByte;
          str = paramString;
          localObject2 = paramString;
          Streams.closeStream(localBufferedInputStream);
          localObject1 = arrayOfByte;
          localObject2 = localObject1;
          if (paramString == null) {
            continue;
          }
          paramString.close();
          return (byte[])localObject1;
        }
        finally
        {
          localObject1 = arrayOfByte;
          str = paramString;
          localObject2 = paramString;
          Streams.closeStream(localBufferedInputStream);
          localObject1 = arrayOfByte;
          str = paramString;
          localObject2 = paramString;
        }
      }
      catch (Exception paramString)
      {
        localObject2 = str;
        com.mopub.nativeads.util.Utils.MoPubLog("Unable to get from DiskLruCache", paramString);
        localObject2 = localObject1;
        if (str == null) {
          continue;
        }
        str.close();
        return (byte[])localObject1;
      }
      finally
      {
        if (localObject2 != null) {
          ((DiskLruCache.Snapshot)localObject2).close();
        }
      }
    }
  }
  
  static void getFromDiskCacheAsync(String paramString, DiskLruCacheGetListener paramDiskLruCacheGetListener)
  {
    new DiskLruCacheGetTask(paramString, paramDiskLruCacheGetListener).execute(new Void[0]);
  }
  
  static byte[] getFromMemoryCache(String paramString)
  {
    if (sMemoryLruCache == null) {
      return null;
    }
    return (byte[])sMemoryLruCache.get(paramString);
  }
  
  @Deprecated
  static LruCache<String, byte[]> getMemoryLruCache()
  {
    return sMemoryLruCache;
  }
  
  static void initializeCaches(Context paramContext)
  {
    File localFile;
    long l;
    if (sDiskLruCache == null)
    {
      localFile = getDiskCacheDirectory(paramContext);
      l = DeviceUtils.diskCacheSizeBytes(localFile);
    }
    try
    {
      sDiskLruCache = DiskLruCache.open(localFile, 1, 1, l);
      if (sMemoryLruCache == null) {
        sMemoryLruCache = new MemoryLruCache(DeviceUtils.memoryCacheSizeBytes(paramContext));
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        com.mopub.nativeads.util.Utils.MoPubLog("Unable to create DiskLruCache", localIOException);
      }
    }
  }
  
  static void put(String paramString, byte[] paramArrayOfByte)
  {
    putToMemoryCache(paramString, paramArrayOfByte);
    putToDiskCacheAsync(paramString, paramArrayOfByte);
  }
  
  static void putToDiskCache(String paramString, byte[] paramArrayOfByte)
  {
    if (sDiskLruCache == null) {}
    String str;
    do
    {
      for (;;)
      {
        return;
        str = null;
        try
        {
          paramString = sDiskLruCache.edit(createValidDiskCacheKey(paramString));
          if (paramString != null)
          {
            str = paramString;
            OutputStream localOutputStream = paramString.newOutputStream(0);
            str = paramString;
            localOutputStream.write(paramArrayOfByte);
            str = paramString;
            localOutputStream.close();
            str = paramString;
            sDiskLruCache.flush();
            str = paramString;
            paramString.commit();
            return;
          }
        }
        catch (Exception paramString)
        {
          com.mopub.nativeads.util.Utils.MoPubLog("Unable to put to DiskLruCache", paramString);
        }
      }
    } while (str == null);
    try
    {
      str.abort();
      return;
    }
    catch (IOException paramString) {}
  }
  
  static void putToDiskCacheAsync(String paramString, byte[] paramArrayOfByte)
  {
    new DiskLruCachePutTask(paramString, paramArrayOfByte).execute(new Void[0]);
  }
  
  static void putToMemoryCache(String paramString, byte[] paramArrayOfByte)
  {
    if (sMemoryLruCache == null) {
      return;
    }
    sMemoryLruCache.put(paramString, paramArrayOfByte);
  }
  
  static abstract interface DiskLruCacheGetListener
  {
    public abstract void onComplete(String paramString, byte[] paramArrayOfByte);
  }
  
  private static class DiskLruCacheGetTask
    extends AsyncTask<Void, Void, byte[]>
  {
    private final CacheService.DiskLruCacheGetListener mDiskLruCacheGetListener;
    private final String mKey;
    
    DiskLruCacheGetTask(String paramString, CacheService.DiskLruCacheGetListener paramDiskLruCacheGetListener)
    {
      this.mDiskLruCacheGetListener = paramDiskLruCacheGetListener;
      this.mKey = paramString;
    }
    
    protected byte[] doInBackground(Void... paramVarArgs)
    {
      return CacheService.getFromDiskCache(this.mKey);
    }
    
    protected void onCancelled()
    {
      if (this.mDiskLruCacheGetListener != null) {
        this.mDiskLruCacheGetListener.onComplete(this.mKey, null);
      }
    }
    
    protected void onPostExecute(byte[] paramArrayOfByte)
    {
      if (isCancelled()) {
        onCancelled();
      }
      while (this.mDiskLruCacheGetListener == null) {
        return;
      }
      this.mDiskLruCacheGetListener.onComplete(this.mKey, paramArrayOfByte);
    }
  }
  
  private static class DiskLruCachePutTask
    extends AsyncTask<Void, Void, Void>
  {
    private final byte[] mContent;
    private final String mKey;
    
    DiskLruCachePutTask(String paramString, byte[] paramArrayOfByte)
    {
      this.mKey = paramString;
      this.mContent = paramArrayOfByte;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      CacheService.putToDiskCache(this.mKey, this.mContent);
      return null;
    }
  }
  
  private static class MemoryLruCache
    extends LruCache<String, byte[]>
  {
    public MemoryLruCache(int paramInt)
    {
      super();
    }
    
    protected int sizeOf(String paramString, byte[] paramArrayOfByte)
    {
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
        return paramArrayOfByte.length;
      }
      return super.sizeOf(paramString, paramArrayOfByte);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/CacheService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */