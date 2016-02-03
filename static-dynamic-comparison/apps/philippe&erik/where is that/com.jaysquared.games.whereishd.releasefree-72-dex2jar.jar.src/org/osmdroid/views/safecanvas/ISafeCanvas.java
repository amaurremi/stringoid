package org.osmdroid.views.safecanvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Canvas.EdgeType;
import android.graphics.Canvas.VertexMode;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;

public abstract interface ISafeCanvas
{
  public abstract boolean clipPath(SafeTranslatedPath paramSafeTranslatedPath);
  
  public abstract boolean clipPath(SafeTranslatedPath paramSafeTranslatedPath, Region.Op paramOp);
  
  public abstract boolean clipRect(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4);
  
  public abstract boolean clipRect(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, Region.Op paramOp);
  
  public abstract boolean clipRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean clipRect(Rect paramRect);
  
  public abstract boolean clipRect(Rect paramRect, Region.Op paramOp);
  
  public abstract boolean clipRegion(Region paramRegion);
  
  public abstract boolean clipRegion(Region paramRegion, Region.Op paramOp);
  
  public abstract void concat(Matrix paramMatrix);
  
  public abstract void drawARGB(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void drawArc(Rect paramRect, float paramFloat1, float paramFloat2, boolean paramBoolean, SafePaint paramSafePaint);
  
  public abstract void drawBitmap(Bitmap paramBitmap, double paramDouble1, double paramDouble2, SafePaint paramSafePaint);
  
  public abstract void drawBitmap(Bitmap paramBitmap, Matrix paramMatrix, SafePaint paramSafePaint);
  
  public abstract void drawBitmap(Bitmap paramBitmap, Rect paramRect1, Rect paramRect2, SafePaint paramSafePaint);
  
  public abstract void drawBitmap(int[] paramArrayOfInt, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3, int paramInt4, boolean paramBoolean, SafePaint paramSafePaint);
  
  public abstract void drawBitmap(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, SafePaint paramSafePaint);
  
  public abstract void drawBitmapMesh(Bitmap paramBitmap, int paramInt1, int paramInt2, double[] paramArrayOfDouble, int paramInt3, int[] paramArrayOfInt, int paramInt4, SafePaint paramSafePaint);
  
  public abstract void drawCircle(double paramDouble1, double paramDouble2, float paramFloat, SafePaint paramSafePaint);
  
  public abstract void drawColor(int paramInt);
  
  public abstract void drawColor(int paramInt, PorterDuff.Mode paramMode);
  
  public abstract void drawLine(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, SafePaint paramSafePaint);
  
  public abstract void drawLines(double[] paramArrayOfDouble, int paramInt1, int paramInt2, SafePaint paramSafePaint);
  
  public abstract void drawLines(double[] paramArrayOfDouble, SafePaint paramSafePaint);
  
  public abstract void drawOval(Rect paramRect, SafePaint paramSafePaint);
  
  public abstract void drawPaint(SafePaint paramSafePaint);
  
  public abstract void drawPath(SafeTranslatedPath paramSafeTranslatedPath, SafePaint paramSafePaint);
  
  public abstract void drawPicture(Picture paramPicture);
  
  public abstract void drawPicture(Picture paramPicture, Rect paramRect);
  
  public abstract void drawPoint(double paramDouble1, double paramDouble2, SafePaint paramSafePaint);
  
  public abstract void drawPoints(double[] paramArrayOfDouble, int paramInt1, int paramInt2, SafePaint paramSafePaint);
  
  public abstract void drawPoints(double[] paramArrayOfDouble, SafePaint paramSafePaint);
  
  public abstract void drawPosText(String paramString, double[] paramArrayOfDouble, SafePaint paramSafePaint);
  
  public abstract void drawPosText(char[] paramArrayOfChar, int paramInt1, int paramInt2, double[] paramArrayOfDouble, SafePaint paramSafePaint);
  
  public abstract void drawRGB(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void drawRect(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, SafePaint paramSafePaint);
  
  public abstract void drawRect(Rect paramRect, SafePaint paramSafePaint);
  
  public abstract void drawRoundRect(Rect paramRect, float paramFloat1, float paramFloat2, SafePaint paramSafePaint);
  
  public abstract void drawText(CharSequence paramCharSequence, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, SafePaint paramSafePaint);
  
  public abstract void drawText(String paramString, double paramDouble1, double paramDouble2, SafePaint paramSafePaint);
  
  public abstract void drawText(String paramString, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, SafePaint paramSafePaint);
  
  public abstract void drawText(char[] paramArrayOfChar, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, SafePaint paramSafePaint);
  
  public abstract void drawTextOnPath(String paramString, SafeTranslatedPath paramSafeTranslatedPath, float paramFloat1, float paramFloat2, SafePaint paramSafePaint);
  
  public abstract void drawTextOnPath(char[] paramArrayOfChar, int paramInt1, int paramInt2, SafeTranslatedPath paramSafeTranslatedPath, float paramFloat1, float paramFloat2, SafePaint paramSafePaint);
  
  public abstract void drawVertices(Canvas.VertexMode paramVertexMode, int paramInt1, double[] paramArrayOfDouble, int paramInt2, float[] paramArrayOfFloat, int paramInt3, int[] paramArrayOfInt, int paramInt4, short[] paramArrayOfShort, int paramInt5, int paramInt6, SafePaint paramSafePaint);
  
  public abstract Rect getClipBounds();
  
  public abstract boolean getClipBounds(Rect paramRect);
  
  public abstract int getDensity();
  
  public abstract DrawFilter getDrawFilter();
  
  public abstract int getHeight();
  
  public abstract Matrix getMatrix();
  
  public abstract void getMatrix(Matrix paramMatrix);
  
  public abstract Canvas getSafeCanvas();
  
  public abstract int getSaveCount();
  
  public abstract void getUnsafeCanvas(UnsafeCanvasHandler paramUnsafeCanvasHandler);
  
  public abstract int getWidth();
  
  public abstract Canvas getWrappedCanvas();
  
  public abstract int getXOffset();
  
  public abstract int getYOffset();
  
  public abstract boolean isOpaque();
  
  public abstract boolean quickReject(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, Canvas.EdgeType paramEdgeType);
  
  public abstract boolean quickReject(Rect paramRect, Canvas.EdgeType paramEdgeType);
  
  public abstract boolean quickReject(SafeTranslatedPath paramSafeTranslatedPath, Canvas.EdgeType paramEdgeType);
  
  public abstract void restore();
  
  public abstract void restoreToCount(int paramInt);
  
  public abstract void rotate(float paramFloat);
  
  public abstract void rotate(float paramFloat, double paramDouble1, double paramDouble2);
  
  public abstract int save();
  
  public abstract int save(int paramInt);
  
  public abstract int saveLayer(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, SafePaint paramSafePaint, int paramInt);
  
  public abstract int saveLayer(Rect paramRect, SafePaint paramSafePaint, int paramInt);
  
  public abstract int saveLayerAlpha(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt1, int paramInt2);
  
  public abstract int saveLayerAlpha(Rect paramRect, int paramInt1, int paramInt2);
  
  public abstract void scale(float paramFloat1, float paramFloat2);
  
  public abstract void scale(float paramFloat1, float paramFloat2, double paramDouble1, double paramDouble2);
  
  public abstract void setBitmap(Bitmap paramBitmap);
  
  public abstract void setDensity(int paramInt);
  
  public abstract void setDrawFilter(DrawFilter paramDrawFilter);
  
  public abstract void setMatrix(Matrix paramMatrix);
  
  public abstract void skew(float paramFloat1, float paramFloat2);
  
  public abstract void translate(float paramFloat1, float paramFloat2);
  
  public static abstract interface UnsafeCanvasHandler
  {
    public abstract void onUnsafeCanvas(Canvas paramCanvas);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/safecanvas/ISafeCanvas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */