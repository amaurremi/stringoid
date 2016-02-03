package com.mobisystems.mobiscanner.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.common.d;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Iterator;

public class k
{
  private HashSet<SoftReference<Bitmap>> aIB;
  private final c mLog;
  
  private static boolean a(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    int i = paramOptions.outWidth / paramOptions.inSampleSize;
    int j = paramOptions.outHeight / paramOptions.inSampleSize;
    return (paramBitmap.getWidth() == i) && (paramBitmap.getHeight() == j);
  }
  
  protected Bitmap a(BitmapFactory.Options paramOptions)
  {
    Iterator localIterator;
    Bitmap localBitmap;
    if ((this.aIB != null) && (!this.aIB.isEmpty()))
    {
      localIterator = this.aIB.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localBitmap = (Bitmap)((SoftReference)localIterator.next()).get();
          if ((localBitmap != null) && (localBitmap.isMutable()))
          {
            if (!a(localBitmap, paramOptions)) {
              continue;
            }
            localIterator.remove();
          }
        }
      }
    }
    for (paramOptions = localBitmap;; paramOptions = null)
    {
      if (paramOptions != null)
      {
        this.mLog.dl("getBitmapFromReusableSet: Reusable bitmap found: " + d.ay(paramOptions));
        return paramOptions;
        localIterator.remove();
        break;
      }
      this.mLog.dl("getBitmapFromReusableSet: Reusable bitmap not found");
      return paramOptions;
    }
  }
  
  public void f(Bitmap paramBitmap)
  {
    this.mLog.dl("Adding bitmap: " + d.ay(paramBitmap));
    this.aIB.add(new SoftReference(paramBitmap));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/image/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */