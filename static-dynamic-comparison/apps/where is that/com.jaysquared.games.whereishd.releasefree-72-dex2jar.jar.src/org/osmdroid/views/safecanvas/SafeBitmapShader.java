package org.osmdroid.views.safecanvas;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Matrix;
import android.graphics.Shader.TileMode;

public class SafeBitmapShader
  extends BitmapShader
{
  private final int mBitmapHeight;
  private final int mBitmapWidth;
  private final Matrix mMatrix = new Matrix();
  
  public SafeBitmapShader(Bitmap paramBitmap, Shader.TileMode paramTileMode1, Shader.TileMode paramTileMode2)
  {
    super(paramBitmap, paramTileMode1, paramTileMode2);
    this.mBitmapWidth = paramBitmap.getWidth();
    this.mBitmapHeight = paramBitmap.getHeight();
  }
  
  public void onDrawCycleStart(ISafeCanvas paramISafeCanvas)
  {
    this.mMatrix.setTranslate(paramISafeCanvas.getXOffset() % this.mBitmapWidth, paramISafeCanvas.getYOffset() % this.mBitmapHeight);
    setLocalMatrix(this.mMatrix);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/safecanvas/SafeBitmapShader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */