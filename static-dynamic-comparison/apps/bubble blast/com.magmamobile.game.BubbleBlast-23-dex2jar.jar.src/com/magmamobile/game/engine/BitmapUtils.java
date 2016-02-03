package com.magmamobile.game.engine;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;

public final class BitmapUtils
{
  public static final Bitmap createBitmap(Bitmap paramBitmap, int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return paramBitmap;
    case 1: 
      return createBitmap90(paramBitmap);
    case 2: 
      return createBitmap180(paramBitmap);
    case 3: 
      return createBitmap270(paramBitmap);
    }
    return createBitmapFlipH(paramBitmap);
  }
  
  public static final Bitmap createBitmap180(Bitmap paramBitmap)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Matrix localMatrix = new Matrix();
    Paint localPaint = new Paint();
    localMatrix.postRotate(180.0F);
    localMatrix.preTranslate(-paramBitmap.getWidth(), -paramBitmap.getHeight());
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    localCanvas.drawBitmap(paramBitmap, localMatrix, localPaint);
    return localBitmap;
  }
  
  public static final Bitmap createBitmap270(Bitmap paramBitmap)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getHeight(), paramBitmap.getWidth(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Matrix localMatrix = new Matrix();
    Paint localPaint = new Paint();
    localMatrix.postRotate(270.0F);
    localMatrix.preTranslate(-paramBitmap.getWidth(), 0.0F);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    localCanvas.drawBitmap(paramBitmap, localMatrix, localPaint);
    return localBitmap;
  }
  
  public static final Bitmap createBitmap90(Bitmap paramBitmap)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getHeight(), paramBitmap.getWidth(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Matrix localMatrix = new Matrix();
    Paint localPaint = new Paint();
    localMatrix.postRotate(90.0F);
    localMatrix.preTranslate(0.0F, -paramBitmap.getHeight());
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    localCanvas.drawBitmap(paramBitmap, localMatrix, localPaint);
    return localBitmap;
  }
  
  public static final Bitmap createBitmapFlipH(Bitmap paramBitmap)
  {
    Matrix localMatrix1 = new Matrix();
    localMatrix1.setValues(new float[] { -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
    Matrix localMatrix2 = new Matrix();
    localMatrix2.postConcat(localMatrix1);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix2, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/BitmapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */