package org.osmdroid.views.safecanvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Canvas.EdgeType;
import android.graphics.Canvas.VertexMode;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;

public class SafeTranslatedCanvas
  extends Canvas
  implements ISafeCanvas
{
  private static float[] sFloatAry = new float[0];
  private static final Matrix sMatrix = new Matrix();
  private static final RectF sRectF = new RectF();
  private Canvas mCanvas;
  private final Matrix mMatrix = new Matrix();
  public int xOffset;
  public int yOffset;
  
  public SafeTranslatedCanvas() {}
  
  public SafeTranslatedCanvas(Canvas paramCanvas)
  {
    setCanvas(paramCanvas);
  }
  
  public boolean clipPath(SafeTranslatedPath paramSafeTranslatedPath)
  {
    return getWrappedCanvas().clipPath(paramSafeTranslatedPath);
  }
  
  public boolean clipPath(SafeTranslatedPath paramSafeTranslatedPath, Region.Op paramOp)
  {
    return getWrappedCanvas().clipPath(paramSafeTranslatedPath, paramOp);
  }
  
  public boolean clipRect(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return getWrappedCanvas().clipRect((float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2), (float)(this.xOffset + paramDouble3), (float)(this.yOffset + paramDouble4));
  }
  
  public boolean clipRect(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, Region.Op paramOp)
  {
    return getWrappedCanvas().clipRect((float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2), (float)(this.xOffset + paramDouble3), (float)(this.yOffset + paramDouble4), paramOp);
  }
  
  public boolean clipRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return getWrappedCanvas().clipRect(this.xOffset + paramInt1, this.yOffset + paramInt2, this.xOffset + paramInt3, this.yOffset + paramInt4);
  }
  
  public boolean clipRect(Rect paramRect)
  {
    paramRect.offset(this.xOffset, this.yOffset);
    return getWrappedCanvas().clipRect(paramRect);
  }
  
  public boolean clipRect(Rect paramRect, Region.Op paramOp)
  {
    paramRect.offset(this.xOffset, this.yOffset);
    return getWrappedCanvas().clipRect(paramRect, paramOp);
  }
  
  public boolean clipRegion(Region paramRegion)
  {
    paramRegion.translate(this.xOffset, this.yOffset);
    return getWrappedCanvas().clipRegion(paramRegion);
  }
  
  public boolean clipRegion(Region paramRegion, Region.Op paramOp)
  {
    paramRegion.translate(this.xOffset, this.yOffset);
    return getWrappedCanvas().clipRegion(paramRegion, paramOp);
  }
  
  protected Object clone()
    throws CloneNotSupportedException
  {
    SafeTranslatedCanvas localSafeTranslatedCanvas = new SafeTranslatedCanvas();
    localSafeTranslatedCanvas.setCanvas(this.mCanvas);
    return localSafeTranslatedCanvas;
  }
  
  public void concat(Matrix paramMatrix)
  {
    getWrappedCanvas().concat(paramMatrix);
  }
  
  public void drawARGB(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    getWrappedCanvas().drawARGB(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void drawArc(Rect paramRect, float paramFloat1, float paramFloat2, boolean paramBoolean, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawArc(toOffsetRectF(paramRect, sRectF), paramFloat1, paramFloat2, paramBoolean, paramSafePaint);
  }
  
  public void drawBitmap(Bitmap paramBitmap, double paramDouble1, double paramDouble2, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawBitmap(paramBitmap, (float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2), paramSafePaint);
  }
  
  public void drawBitmap(Bitmap paramBitmap, Matrix paramMatrix, SafePaint paramSafePaint)
  {
    sMatrix.set(paramMatrix);
    sMatrix.postTranslate(this.xOffset, this.yOffset);
    getWrappedCanvas().drawBitmap(paramBitmap, sMatrix, paramSafePaint);
  }
  
  public void drawBitmap(Bitmap paramBitmap, Rect paramRect1, Rect paramRect2, Paint paramPaint)
  {
    paramRect2.offset(this.xOffset, this.yOffset);
    getWrappedCanvas().drawBitmap(paramBitmap, paramRect1, paramRect2, paramPaint);
    paramRect2.offset(-this.xOffset, -this.yOffset);
  }
  
  public void drawBitmap(Bitmap paramBitmap, Rect paramRect1, Rect paramRect2, SafePaint paramSafePaint)
  {
    paramRect2.offset(this.xOffset, this.yOffset);
    getWrappedCanvas().drawBitmap(paramBitmap, paramRect1, paramRect2, paramSafePaint);
    paramRect2.offset(-this.xOffset, -this.yOffset);
  }
  
  public void drawBitmap(int[] paramArrayOfInt, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3, int paramInt4, boolean paramBoolean, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawBitmap(paramArrayOfInt, paramInt1, paramInt2, (float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2), paramInt3, paramInt4, paramBoolean, paramSafePaint);
  }
  
  public void drawBitmap(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawBitmap(paramArrayOfInt, paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt1, paramInt5, paramInt6, paramBoolean, paramSafePaint);
  }
  
  public void drawBitmapMesh(Bitmap paramBitmap, int paramInt1, int paramInt2, double[] paramArrayOfDouble, int paramInt3, int[] paramArrayOfInt, int paramInt4, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawBitmapMesh(paramBitmap, paramInt1, paramInt2, toOffsetFloatAry(paramArrayOfDouble, sFloatAry), paramInt3, paramArrayOfInt, paramInt4, paramSafePaint);
  }
  
  public void drawCircle(double paramDouble1, double paramDouble2, float paramFloat, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawCircle((float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2), paramFloat, paramSafePaint);
  }
  
  public void drawColor(int paramInt)
  {
    getWrappedCanvas().drawColor(paramInt);
  }
  
  public void drawColor(int paramInt, PorterDuff.Mode paramMode)
  {
    getWrappedCanvas().drawColor(paramInt, paramMode);
  }
  
  public void drawLine(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, SafePaint paramSafePaint)
  {
    double d1 = this.xOffset;
    double d2 = this.yOffset;
    double d3 = this.xOffset;
    double d4 = this.yOffset;
    getWrappedCanvas().drawLine((float)(paramDouble1 + d1), (float)(paramDouble2 + d2), (float)(paramDouble3 + d3), (float)(paramDouble4 + d4), paramSafePaint);
  }
  
  public void drawLines(double[] paramArrayOfDouble, int paramInt1, int paramInt2, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawLines(toOffsetFloatAry(paramArrayOfDouble, sFloatAry), paramInt1, paramInt2, paramSafePaint);
  }
  
  public void drawLines(double[] paramArrayOfDouble, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawLines(toOffsetFloatAry(paramArrayOfDouble, sFloatAry), paramSafePaint);
  }
  
  public void drawOval(Rect paramRect, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawOval(toOffsetRectF(paramRect, sRectF), paramSafePaint);
  }
  
  public void drawPaint(SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawPaint(paramSafePaint);
  }
  
  public void drawPath(SafeTranslatedPath paramSafeTranslatedPath, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawPath(paramSafeTranslatedPath, paramSafePaint);
  }
  
  public void drawPicture(Picture paramPicture)
  {
    getWrappedCanvas().drawPicture(paramPicture);
  }
  
  public void drawPicture(Picture paramPicture, Rect paramRect)
  {
    paramRect.offset(this.xOffset, this.yOffset);
    getWrappedCanvas().drawPicture(paramPicture, paramRect);
    paramRect.offset(-this.xOffset, -this.yOffset);
  }
  
  public void drawPoint(double paramDouble1, double paramDouble2, SafePaint paramSafePaint)
  {
    double d1 = this.xOffset;
    double d2 = this.yOffset;
    getWrappedCanvas().drawPoint((float)(paramDouble1 + d1), (float)(paramDouble2 + d2), paramSafePaint);
  }
  
  public void drawPoints(double[] paramArrayOfDouble, int paramInt1, int paramInt2, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawPoints(toOffsetFloatAry(paramArrayOfDouble, sFloatAry), paramInt1, paramInt2, paramSafePaint);
  }
  
  public void drawPoints(double[] paramArrayOfDouble, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawPoints(toOffsetFloatAry(paramArrayOfDouble, sFloatAry), paramSafePaint);
  }
  
  public void drawPosText(String paramString, double[] paramArrayOfDouble, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawPosText(paramString, toOffsetFloatAry(paramArrayOfDouble, sFloatAry), paramSafePaint);
  }
  
  public void drawPosText(char[] paramArrayOfChar, int paramInt1, int paramInt2, double[] paramArrayOfDouble, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawPosText(paramArrayOfChar, paramInt1, paramInt2, toOffsetFloatAry(paramArrayOfDouble, sFloatAry), paramSafePaint);
  }
  
  public void drawRGB(int paramInt1, int paramInt2, int paramInt3)
  {
    getWrappedCanvas().drawRGB(paramInt1, paramInt2, paramInt3);
  }
  
  public void drawRect(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, SafePaint paramSafePaint)
  {
    double d1 = this.xOffset;
    double d2 = this.xOffset;
    double d3 = this.yOffset;
    double d4 = this.yOffset;
    getWrappedCanvas().drawRect((float)(paramDouble1 + d1), (float)(paramDouble2 + d3), (float)(paramDouble3 + d2), (float)(paramDouble4 + d4), paramSafePaint);
  }
  
  public void drawRect(Rect paramRect, SafePaint paramSafePaint)
  {
    paramRect.offset(this.xOffset, this.yOffset);
    getWrappedCanvas().drawRect(paramRect, paramSafePaint);
    paramRect.offset(-this.xOffset, -this.yOffset);
  }
  
  public void drawRoundRect(Rect paramRect, float paramFloat1, float paramFloat2, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawRoundRect(toOffsetRectF(paramRect, sRectF), paramFloat1, paramFloat2, paramSafePaint);
  }
  
  public void drawText(CharSequence paramCharSequence, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawText(paramCharSequence, paramInt1, paramInt2, (float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2), paramSafePaint);
  }
  
  public void drawText(String paramString, double paramDouble1, double paramDouble2, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawText(paramString, (float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2), paramSafePaint);
  }
  
  public void drawText(String paramString, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawText(paramString, paramInt1, paramInt2, (float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2), paramSafePaint);
  }
  
  public void drawText(char[] paramArrayOfChar, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawText(paramArrayOfChar, paramInt1, paramInt2, (float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2), paramSafePaint);
  }
  
  public void drawTextOnPath(String paramString, SafeTranslatedPath paramSafeTranslatedPath, float paramFloat1, float paramFloat2, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawTextOnPath(paramString, paramSafeTranslatedPath, paramFloat1, paramFloat2, paramSafePaint);
  }
  
  public void drawTextOnPath(char[] paramArrayOfChar, int paramInt1, int paramInt2, SafeTranslatedPath paramSafeTranslatedPath, float paramFloat1, float paramFloat2, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawTextOnPath(paramArrayOfChar, paramInt1, paramInt2, paramSafeTranslatedPath, paramFloat1, paramFloat2, paramSafePaint);
  }
  
  public void drawVertices(Canvas.VertexMode paramVertexMode, int paramInt1, double[] paramArrayOfDouble, int paramInt2, float[] paramArrayOfFloat, int paramInt3, int[] paramArrayOfInt, int paramInt4, short[] paramArrayOfShort, int paramInt5, int paramInt6, SafePaint paramSafePaint)
  {
    getWrappedCanvas().drawVertices(paramVertexMode, paramInt1, toOffsetFloatAry(paramArrayOfDouble, sFloatAry), paramInt2, paramArrayOfFloat, paramInt3, paramArrayOfInt, paramInt4, paramArrayOfShort, paramInt5, paramInt6, paramSafePaint);
  }
  
  public boolean equals(Object paramObject)
  {
    return getWrappedCanvas().equals(paramObject);
  }
  
  public boolean getClipBounds(Rect paramRect)
  {
    boolean bool = getWrappedCanvas().getClipBounds(paramRect);
    if (paramRect != null) {
      paramRect.offset(-this.xOffset, -this.yOffset);
    }
    return bool;
  }
  
  public int getDensity()
  {
    return getWrappedCanvas().getDensity();
  }
  
  public DrawFilter getDrawFilter()
  {
    return getWrappedCanvas().getDrawFilter();
  }
  
  public int getHeight()
  {
    return getWrappedCanvas().getHeight();
  }
  
  public void getMatrix(Matrix paramMatrix)
  {
    getWrappedCanvas().getMatrix(paramMatrix);
  }
  
  public Matrix getOriginalMatrix()
  {
    return this.mMatrix;
  }
  
  public Canvas getSafeCanvas()
  {
    return this;
  }
  
  public int getSaveCount()
  {
    return getWrappedCanvas().getSaveCount();
  }
  
  public void getUnsafeCanvas(ISafeCanvas.UnsafeCanvasHandler paramUnsafeCanvasHandler)
  {
    save();
    setMatrix(getOriginalMatrix());
    paramUnsafeCanvasHandler.onUnsafeCanvas(this.mCanvas);
    restore();
  }
  
  public int getWidth()
  {
    return getWrappedCanvas().getWidth();
  }
  
  public Canvas getWrappedCanvas()
  {
    return this.mCanvas;
  }
  
  public int getXOffset()
  {
    return this.xOffset;
  }
  
  public int getYOffset()
  {
    return this.yOffset;
  }
  
  public int hashCode()
  {
    return getWrappedCanvas().hashCode();
  }
  
  public boolean isOpaque()
  {
    return getWrappedCanvas().isOpaque();
  }
  
  public boolean quickReject(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, Canvas.EdgeType paramEdgeType)
  {
    double d1 = this.xOffset;
    double d2 = this.xOffset;
    double d3 = this.yOffset;
    double d4 = this.yOffset;
    return getWrappedCanvas().quickReject((float)(paramDouble1 + d1), (float)(paramDouble2 + d3), (float)(paramDouble3 + d2), (float)(paramDouble4 + d4), paramEdgeType);
  }
  
  public boolean quickReject(Rect paramRect, Canvas.EdgeType paramEdgeType)
  {
    return getWrappedCanvas().quickReject(toOffsetRectF(paramRect, sRectF), paramEdgeType);
  }
  
  public boolean quickReject(SafeTranslatedPath paramSafeTranslatedPath, Canvas.EdgeType paramEdgeType)
  {
    return getWrappedCanvas().quickReject(paramSafeTranslatedPath, paramEdgeType);
  }
  
  public void restore()
  {
    getWrappedCanvas().restore();
  }
  
  public void restoreToCount(int paramInt)
  {
    getWrappedCanvas().restoreToCount(paramInt);
  }
  
  public void rotate(float paramFloat)
  {
    getWrappedCanvas().translate(this.xOffset, this.yOffset);
    getWrappedCanvas().rotate(paramFloat);
    getWrappedCanvas().translate(-this.xOffset, -this.yOffset);
  }
  
  public void rotate(float paramFloat, double paramDouble1, double paramDouble2)
  {
    getWrappedCanvas().rotate(paramFloat, (float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2));
  }
  
  public int save()
  {
    return getWrappedCanvas().save();
  }
  
  public int save(int paramInt)
  {
    return getWrappedCanvas().save(paramInt);
  }
  
  public int saveLayer(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, SafePaint paramSafePaint, int paramInt)
  {
    return getWrappedCanvas().saveLayer((float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2), (float)(this.xOffset + paramDouble3), (float)(this.yOffset + paramDouble4), paramSafePaint, paramInt);
  }
  
  public int saveLayer(Rect paramRect, SafePaint paramSafePaint, int paramInt)
  {
    return getWrappedCanvas().saveLayer(toOffsetRectF(paramRect, sRectF), paramSafePaint, paramInt);
  }
  
  public int saveLayerAlpha(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt1, int paramInt2)
  {
    return getWrappedCanvas().saveLayerAlpha((float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2), (float)(this.xOffset + paramDouble3), (float)(this.yOffset + paramDouble4), paramInt1, paramInt2);
  }
  
  public int saveLayerAlpha(Rect paramRect, int paramInt1, int paramInt2)
  {
    return getWrappedCanvas().saveLayerAlpha(toOffsetRectF(paramRect, sRectF), paramInt1, paramInt2);
  }
  
  public void scale(float paramFloat1, float paramFloat2)
  {
    getWrappedCanvas().scale(paramFloat1, paramFloat2);
  }
  
  public void scale(float paramFloat1, float paramFloat2, double paramDouble1, double paramDouble2)
  {
    getWrappedCanvas().scale(paramFloat1, paramFloat2, (float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2));
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    getWrappedCanvas().setBitmap(paramBitmap);
  }
  
  public void setCanvas(Canvas paramCanvas)
  {
    this.mCanvas = paramCanvas;
    paramCanvas.getMatrix(this.mMatrix);
  }
  
  public void setDensity(int paramInt)
  {
    getWrappedCanvas().setDensity(paramInt);
  }
  
  public void setDrawFilter(DrawFilter paramDrawFilter)
  {
    getWrappedCanvas().setDrawFilter(paramDrawFilter);
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    getWrappedCanvas().setMatrix(paramMatrix);
  }
  
  public void skew(float paramFloat1, float paramFloat2)
  {
    getWrappedCanvas().skew(paramFloat1, paramFloat2);
  }
  
  protected final float[] toOffsetFloatAry(double[] paramArrayOfDouble, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat;
    if (paramArrayOfFloat != null)
    {
      arrayOfFloat = paramArrayOfFloat;
      if (paramArrayOfFloat.length >= paramArrayOfDouble.length) {}
    }
    else
    {
      arrayOfFloat = new float[paramArrayOfDouble.length];
    }
    int i = 0;
    if (i < paramArrayOfDouble.length)
    {
      double d = paramArrayOfDouble[i];
      if (i % 2 == 0) {}
      for (int j = this.xOffset;; j = this.yOffset)
      {
        arrayOfFloat[i] = ((float)(d + j));
        i += 1;
        break;
      }
    }
    return arrayOfFloat;
  }
  
  protected final RectF toOffsetRectF(Rect paramRect, RectF paramRectF)
  {
    RectF localRectF = paramRectF;
    if (paramRectF == null) {
      localRectF = new RectF();
    }
    localRectF.set(paramRect.left + this.xOffset, paramRect.top + this.yOffset, paramRect.right + this.xOffset, paramRect.bottom + this.yOffset);
    return localRectF;
  }
  
  public String toString()
  {
    return getWrappedCanvas().toString();
  }
  
  public void translate(float paramFloat1, float paramFloat2)
  {
    getWrappedCanvas().translate(paramFloat1, paramFloat2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/safecanvas/SafeTranslatedCanvas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */