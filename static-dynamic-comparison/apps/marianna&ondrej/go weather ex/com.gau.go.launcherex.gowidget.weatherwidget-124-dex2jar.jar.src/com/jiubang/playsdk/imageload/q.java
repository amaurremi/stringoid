package com.jiubang.playsdk.imageload;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

class q
  extends LruCache
{
  q(p paramp, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  protected void a(boolean paramBoolean, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (paramBoolean) {
      p.a(this.a).put(paramString, new SoftReference(paramBitmap1));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/imageload/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */