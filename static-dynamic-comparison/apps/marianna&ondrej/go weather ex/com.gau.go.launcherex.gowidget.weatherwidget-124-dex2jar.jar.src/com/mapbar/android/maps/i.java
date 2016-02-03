package com.mapbar.android.maps;

import android.graphics.Bitmap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

class i
  extends LinkedHashMap<K, V>
{
  i(h paramh, int paramInt, float paramFloat, boolean paramBoolean)
  {
    super(101, 0.75F, true);
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    if (size() > h.a(this.a))
    {
      Bitmap localBitmap;
      if ((paramEntry.getValue() instanceof Bitmap)) {
        localBitmap = (Bitmap)paramEntry.getValue();
      }
      try
      {
        localBitmap.recycle();
        if ((paramEntry.getValue() instanceof f)) {
          ((f)paramEntry.getValue()).destory();
        }
        if ((paramEntry.getKey() instanceof f)) {
          ((f)paramEntry.getKey()).destory();
        }
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */