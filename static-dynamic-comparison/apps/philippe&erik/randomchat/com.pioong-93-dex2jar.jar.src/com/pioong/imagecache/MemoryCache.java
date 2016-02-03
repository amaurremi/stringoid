package com.pioong.imagecache;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MemoryCache
{
  private static final String TAG = "MemoryCache";
  private Map<String, Bitmap> cache = Collections.synchronizedMap(new LinkedHashMap(10, 1.5F, true));
  private long limit = 1000000L;
  private long size = 0L;
  
  public MemoryCache()
  {
    setLimit(Runtime.getRuntime().maxMemory() / 4L);
  }
  
  public MemoryCache(String paramString)
  {
    setLimit(Runtime.getRuntime().maxMemory() / 8L);
  }
  
  private void checkSize()
  {
    Log.i("MemoryCache", "cache size=" + this.size + " length=" + this.cache.size());
    Iterator localIterator;
    if (this.size > this.limit)
    {
      localIterator = this.cache.entrySet().iterator();
      if (localIterator.hasNext()) {
        break label109;
      }
    }
    for (;;)
    {
      Log.i("MemoryCache", "Clean cache. New size " + this.cache.size());
      return;
      label109:
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.size -= getSizeInBytes((Bitmap)localEntry.getValue());
      localIterator.remove();
      if (this.size > this.limit) {
        break;
      }
    }
  }
  
  public void clear()
  {
    try
    {
      this.cache.clear();
      this.size = 0L;
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  public Bitmap get(String paramString)
  {
    try
    {
      if (!this.cache.containsKey(paramString)) {
        return null;
      }
      paramString = (Bitmap)this.cache.get(paramString);
      return paramString;
    }
    catch (NullPointerException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  long getSizeInBytes(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0L;
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public void put(String paramString, Bitmap paramBitmap)
  {
    try
    {
      if (this.cache.containsKey(paramString)) {
        this.size -= getSizeInBytes((Bitmap)this.cache.get(paramString));
      }
      this.cache.put(paramString, paramBitmap);
      this.size += getSizeInBytes(paramBitmap);
      checkSize();
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setLimit(long paramLong)
  {
    this.limit = paramLong;
    Log.i("MemoryCache", "MemoryCache will use up to " + this.limit / 1024.0D / 1024.0D + "MB");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/imagecache/MemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */