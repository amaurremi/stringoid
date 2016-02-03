package com.venticake.retrica.view.album;

import android.graphics.Bitmap;

public class BitmapTexture
  extends Texture
{
  final Bitmap mBitmap;
  
  BitmapTexture(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
  }
  
  protected Bitmap load(RenderView paramRenderView)
  {
    return this.mBitmap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/BitmapTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */