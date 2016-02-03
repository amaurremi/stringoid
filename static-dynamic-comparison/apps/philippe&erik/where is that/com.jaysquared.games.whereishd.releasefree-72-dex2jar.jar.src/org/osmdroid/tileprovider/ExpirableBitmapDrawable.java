package org.osmdroid.tileprovider;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class ExpirableBitmapDrawable
  extends BitmapDrawable
{
  public static final int EXPIRED = -1;
  private int[] mState = new int[0];
  
  public ExpirableBitmapDrawable(Bitmap paramBitmap)
  {
    super(paramBitmap);
  }
  
  public static boolean isDrawableExpired(Drawable paramDrawable)
  {
    if (!paramDrawable.isStateful()) {}
    for (;;)
    {
      return false;
      paramDrawable = paramDrawable.getState();
      int i = 0;
      while (i < paramDrawable.length)
      {
        if (paramDrawable[i] == -1) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public int[] getState()
  {
    return this.mState;
  }
  
  public boolean isStateful()
  {
    return this.mState.length > 0;
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    this.mState = paramArrayOfInt;
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/ExpirableBitmapDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */