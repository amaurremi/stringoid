package com.magmamobile.game.engine.tmp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

public final class CanvasEx
  extends Canvas
{
  protected static Matrix matrix = new Matrix();
  protected static Rect rcDst;
  protected static Rect rcSrc = new Rect();
  
  static
  {
    rcDst = new Rect();
  }
  
  public CanvasEx(Bitmap paramBitmap)
  {
    super(paramBitmap);
  }
  
  public void draw(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    drawBitmap(paramBitmap, paramInt1, paramInt2, null);
  }
  
  public void draw(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, float paramFloat, Paint paramPaint)
  {
    matrix.reset();
    if (paramInt3 != 0) {
      matrix.postRotate(paramInt3);
    }
    matrix.preTranslate(-paramBitmap.getWidth() >> 1, -paramBitmap.getHeight() >> 1);
    if (paramFloat != 1.0F) {
      matrix.postScale(paramFloat, paramFloat);
    }
    matrix.postTranslate(paramInt1, paramInt2);
    drawBitmap(paramBitmap, matrix, paramPaint);
  }
  
  public void draw(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint paramPaint)
  {
    rcSrc.set(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    rcDst.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    drawBitmap(paramBitmap, rcSrc, rcDst, paramPaint);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/tmp/CanvasEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */