package org.osmdroid.tileprovider;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import java.util.Iterator;
import java.util.LinkedList;

public class BitmapPool
{
  private static BitmapPool sInstance;
  final LinkedList<Bitmap> mPool = new LinkedList();
  
  public static BitmapPool getInstance()
  {
    if (sInstance == null) {
      sInstance = new BitmapPool();
    }
    return sInstance;
  }
  
  public void applyReusableOptions(BitmapFactory.Options paramOptions)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramOptions.inBitmap = obtainBitmapFromPool();
      paramOptions.inSampleSize = 1;
      paramOptions.inMutable = true;
    }
  }
  
  public void clearBitmapPool()
  {
    synchronized (sInstance.mPool)
    {
      if (!sInstance.mPool.isEmpty()) {
        ((Bitmap)sInstance.mPool.remove()).recycle();
      }
    }
  }
  
  public Bitmap obtainBitmapFromPool()
  {
    synchronized (this.mPool)
    {
      if (this.mPool.isEmpty()) {
        return null;
      }
      Bitmap localBitmap1 = (Bitmap)this.mPool.removeFirst();
      if (localBitmap1.isRecycled())
      {
        localBitmap1 = obtainBitmapFromPool();
        return localBitmap1;
      }
    }
    return localBitmap2;
  }
  
  public Bitmap obtainSizedBitmapFromPool(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Bitmap localBitmap;
      synchronized (this.mPool)
      {
        if (this.mPool.isEmpty()) {
          return null;
        }
        Object localObject1 = this.mPool.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localBitmap = (Bitmap)((Iterator)localObject1).next();
        if (localBitmap.isRecycled())
        {
          this.mPool.remove(localBitmap);
          localObject1 = obtainSizedBitmapFromPool(paramInt1, paramInt2);
          return (Bitmap)localObject1;
        }
      }
      if ((localBitmap.getWidth() == paramInt1) && (localBitmap.getHeight() == paramInt2))
      {
        this.mPool.remove(localBitmap);
        return localBitmap;
      }
    }
    return null;
  }
  
  public void returnDrawableToPool(ReusableBitmapDrawable arg1)
  {
    Bitmap localBitmap = ???.tryRecycle();
    if ((localBitmap != null) && (localBitmap.isMutable())) {
      synchronized (this.mPool)
      {
        this.mPool.addLast(localBitmap);
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/BitmapPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */