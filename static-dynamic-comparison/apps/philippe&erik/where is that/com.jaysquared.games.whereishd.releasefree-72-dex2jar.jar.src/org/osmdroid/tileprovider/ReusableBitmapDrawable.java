package org.osmdroid.tileprovider;

import android.graphics.Bitmap;

public class ReusableBitmapDrawable
  extends ExpirableBitmapDrawable
{
  private boolean mBitmapRecycled = false;
  private int mUsageRefCount = 0;
  
  public ReusableBitmapDrawable(Bitmap paramBitmap)
  {
    super(paramBitmap);
  }
  
  public void beginUsingDrawable()
  {
    try
    {
      this.mUsageRefCount += 1;
      return;
    }
    finally {}
  }
  
  public void finishUsingDrawable()
  {
    try
    {
      this.mUsageRefCount -= 1;
      if (this.mUsageRefCount < 0) {
        throw new IllegalStateException("Unbalanced endUsingDrawable() called.");
      }
    }
    finally {}
  }
  
  public boolean isBitmapValid()
  {
    for (;;)
    {
      try
      {
        if (!this.mBitmapRecycled)
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public Bitmap tryRecycle()
  {
    try
    {
      if (this.mUsageRefCount == 0)
      {
        this.mBitmapRecycled = true;
        Bitmap localBitmap = getBitmap();
        return localBitmap;
      }
      return null;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/ReusableBitmapDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */