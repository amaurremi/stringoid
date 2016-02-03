package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class LruCache
  implements Cache
{
  private int evictionCount;
  private int hitCount;
  final LinkedHashMap<String, Bitmap> map;
  private final int maxSize;
  private int missCount;
  private int putCount;
  private int size;
  
  public LruCache(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max size must be positive.");
    }
    this.maxSize = paramInt;
    this.map = new LinkedHashMap(0, 0.75F, true);
  }
  
  public LruCache(Context paramContext)
  {
    this(Utils.calculateMemoryCacheSize(paramContext));
  }
  
  private void trimToSize(int paramInt)
  {
    try
    {
      if ((this.size < 0) || ((this.map.isEmpty()) && (this.size != 0))) {
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
      }
    }
    finally
    {
      throw ((Throwable)localObject1);
      if ((this.size <= paramInt) || (this.map.isEmpty())) {
        return;
      }
      Object localObject2 = (Map.Entry)this.map.entrySet().iterator().next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (Bitmap)((Map.Entry)localObject2).getValue();
      this.map.remove(str);
      this.size -= Utils.getBitmapBytes((Bitmap)localObject2);
      this.evictionCount += 1;
    }
  }
  
  public final void clear()
  {
    try
    {
      evictAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void evictAll()
  {
    trimToSize(-1);
  }
  
  public final int evictionCount()
  {
    try
    {
      int i = this.evictionCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Bitmap get(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      paramString = (Bitmap)this.map.get(paramString);
      if (paramString != null)
      {
        this.hitCount += 1;
        return paramString;
      }
      this.missCount += 1;
      return null;
    }
    finally {}
  }
  
  public final int hitCount()
  {
    try
    {
      int i = this.hitCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int maxSize()
  {
    try
    {
      int i = this.maxSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int missCount()
  {
    try
    {
      int i = this.missCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int putCount()
  {
    try
    {
      int i = this.putCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void set(String paramString, Bitmap paramBitmap)
  {
    if ((paramString == null) || (paramBitmap == null)) {
      throw new NullPointerException("key == null || bitmap == null");
    }
    try
    {
      this.putCount += 1;
      this.size += Utils.getBitmapBytes(paramBitmap);
      paramString = (Bitmap)this.map.put(paramString, paramBitmap);
      if (paramString != null) {
        this.size -= Utils.getBitmapBytes(paramString);
      }
      trimToSize(this.maxSize);
      return;
    }
    finally {}
  }
  
  public final int size()
  {
    try
    {
      int i = this.size;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/picasso/LruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */