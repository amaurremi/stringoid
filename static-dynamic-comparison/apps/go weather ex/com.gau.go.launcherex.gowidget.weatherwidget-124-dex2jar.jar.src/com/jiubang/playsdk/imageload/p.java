package com.jiubang.playsdk.imageload;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

public class p
{
  private static volatile p b;
  private LruCache a = null;
  private ConcurrentHashMap c = new ConcurrentHashMap();
  
  private p(int paramInt)
  {
    this.a = new q(this, paramInt);
  }
  
  public static p a()
  {
    int i = 5242880;
    if (b == null) {}
    for (;;)
    {
      int j;
      try
      {
        if (b == null)
        {
          j = (int)Runtime.getRuntime().maxMemory() / 8;
          if (j > 5242880) {
            b = new p(i);
          }
        }
        else
        {
          return b;
        }
      }
      finally {}
      i = j;
    }
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    do
    {
      Bitmap localBitmap;
      do
      {
        return (Bitmap)localObject;
        localBitmap = (Bitmap)this.a.get(paramString);
        localObject = localBitmap;
      } while (localBitmap != null);
      paramString = (SoftReference)this.c.get(paramString);
      localObject = localBitmap;
    } while (paramString == null);
    return (Bitmap)paramString.get();
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if ((paramString == null) || (paramBitmap == null)) {}
    while (this.a == null) {
      return;
    }
    this.a.put(paramString, paramBitmap);
  }
  
  public void b()
  {
    this.a.evictAll();
    this.c.clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/imageload/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */