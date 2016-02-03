package com.venticake.retrica.view.album;

import android.graphics.Bitmap;

public abstract class Texture
{
  public static final int STATE_ERROR = 4;
  public static final int STATE_LOADED = 3;
  public static final int STATE_LOADING = 2;
  public static final int STATE_QUEUED = 1;
  public static final int STATE_UNLOADED = 0;
  Bitmap mBitmap;
  int mHeight;
  int mId;
  float mNormalizedHeight;
  float mNormalizedWidth;
  int mState = 0;
  int mWidth;
  
  public final void clear()
  {
    this.mId = 0;
    this.mState = 0;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mNormalizedWidth = 0.0F;
    this.mNormalizedHeight = 0.0F;
    if (this.mBitmap != null)
    {
      this.mBitmap.recycle();
      this.mBitmap = null;
    }
  }
  
  public final int getHeight()
  {
    return this.mHeight;
  }
  
  public final float getNormalizedHeight()
  {
    return this.mNormalizedHeight;
  }
  
  public final float getNormalizedWidth()
  {
    return this.mNormalizedWidth;
  }
  
  public final int getState()
  {
    return this.mState;
  }
  
  public final int getWidth()
  {
    return this.mWidth;
  }
  
  public boolean isCached()
  {
    return false;
  }
  
  public final boolean isLoaded()
  {
    return this.mState == 3;
  }
  
  public boolean isUncachedVideo()
  {
    return false;
  }
  
  protected abstract Bitmap load(RenderView paramRenderView);
  
  protected boolean shouldQueue()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/Texture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */