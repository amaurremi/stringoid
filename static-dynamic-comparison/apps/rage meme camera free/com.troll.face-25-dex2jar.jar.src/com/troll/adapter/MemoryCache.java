package com.troll.adapter;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class MemoryCache
{
  private HashMap<String, SoftReference<Bitmap>> cache = new HashMap();
  
  public void clear()
  {
    this.cache.clear();
  }
  
  public Bitmap get(String paramString)
  {
    if (!this.cache.containsKey(paramString)) {
      return null;
    }
    return (Bitmap)((SoftReference)this.cache.get(paramString)).get();
  }
  
  public void put(String paramString, Bitmap paramBitmap)
  {
    this.cache.put(paramString, new SoftReference(paramBitmap));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/adapter/MemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */