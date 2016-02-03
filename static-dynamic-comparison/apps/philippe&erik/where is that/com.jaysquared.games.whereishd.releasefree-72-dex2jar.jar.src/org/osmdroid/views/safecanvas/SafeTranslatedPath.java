package org.osmdroid.views.safecanvas;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;

public class SafeTranslatedPath
  extends Path
{
  private static final RectF sRectF = new RectF();
  public int xOffset = 0;
  public int yOffset = 0;
  
  public void addArc(Rect paramRect, float paramFloat1, float paramFloat2)
  {
    paramRect.offset(this.xOffset, this.yOffset);
    super.addArc(toOffsetRectF(paramRect, sRectF), paramFloat1, paramFloat2);
    paramRect.offset(-this.xOffset, -this.yOffset);
  }
  
  @Deprecated
  public void addArc(RectF paramRectF, float paramFloat1, float paramFloat2)
  {
    paramRectF.offset(this.xOffset, this.yOffset);
    super.addArc(paramRectF, paramFloat1, paramFloat2);
    paramRectF.offset(-this.xOffset, -this.yOffset);
  }
  
  public void addCircle(double paramDouble1, double paramDouble2, float paramFloat, Path.Direction paramDirection)
  {
    super.addCircle((float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2), paramFloat, paramDirection);
  }
  
  @Deprecated
  public void addCircle(float paramFloat1, float paramFloat2, float paramFloat3, Path.Direction paramDirection)
  {
    super.addCircle(this.xOffset + paramFloat1, this.yOffset + paramFloat2, paramFloat3, paramDirection);
  }
  
  public void addOval(Rect paramRect, Path.Direction paramDirection)
  {
    paramRect.offset(this.xOffset, this.yOffset);
    super.addOval(toOffsetRectF(paramRect, sRectF), paramDirection);
    paramRect.offset(-this.xOffset, -this.yOffset);
  }
  
  @Deprecated
  public void addOval(RectF paramRectF, Path.Direction paramDirection)
  {
    paramRectF.offset(this.xOffset, this.yOffset);
    super.addOval(paramRectF, paramDirection);
    paramRectF.offset(-this.xOffset, -this.yOffset);
  }
  
  public void addPath(Path paramPath)
  {
    boolean bool = paramPath instanceof SafeTranslatedPath;
    if (!bool) {
      paramPath.offset(this.xOffset, this.yOffset);
    }
    super.addPath(paramPath);
    if (!bool) {
      paramPath.offset(-this.xOffset, -this.yOffset);
    }
  }
  
  public void addPath(Path paramPath, float paramFloat1, float paramFloat2)
  {
    boolean bool = paramPath instanceof SafeTranslatedPath;
    if (!bool) {
      paramPath.offset(this.xOffset, this.yOffset);
    }
    super.addPath(paramPath, paramFloat1, paramFloat2);
    if (!bool) {
      paramPath.offset(-this.xOffset, -this.yOffset);
    }
  }
  
  public void addPath(Path paramPath, Matrix paramMatrix)
  {
    boolean bool = paramPath instanceof SafeTranslatedPath;
    if (!bool) {
      paramMatrix.preTranslate(this.xOffset, this.yOffset);
    }
    super.addPath(paramPath, paramMatrix);
    if (!bool) {
      paramMatrix.preTranslate(-this.xOffset, -this.yOffset);
    }
  }
  
  public void addRect(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, Path.Direction paramDirection)
  {
    super.addRect((float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2), (float)(this.xOffset + paramDouble3), (float)(this.yOffset + paramDouble4), paramDirection);
  }
  
  @Deprecated
  public void addRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Path.Direction paramDirection)
  {
    super.addRect(paramFloat1 + this.xOffset, paramFloat2 + this.yOffset, paramFloat3 + this.xOffset, paramFloat4 + this.yOffset, paramDirection);
  }
  
  public void addRect(Rect paramRect, Path.Direction paramDirection)
  {
    paramRect.offset(this.xOffset, this.yOffset);
    super.addRect(toOffsetRectF(paramRect, sRectF), paramDirection);
    paramRect.offset(-this.xOffset, -this.yOffset);
  }
  
  @Deprecated
  public void addRect(RectF paramRectF, Path.Direction paramDirection)
  {
    paramRectF.offset(this.xOffset, this.yOffset);
    super.addRect(paramRectF, paramDirection);
    paramRectF.offset(-this.xOffset, -this.yOffset);
  }
  
  public void addRoundRect(Rect paramRect, float paramFloat1, float paramFloat2, Path.Direction paramDirection)
  {
    paramRect.offset(this.xOffset, this.yOffset);
    super.addRoundRect(toOffsetRectF(paramRect, sRectF), paramFloat1, paramFloat2, paramDirection);
    paramRect.offset(-this.xOffset, -this.yOffset);
  }
  
  public void addRoundRect(Rect paramRect, float[] paramArrayOfFloat, Path.Direction paramDirection)
  {
    paramRect.offset(this.xOffset, this.yOffset);
    super.addRoundRect(toOffsetRectF(paramRect, sRectF), paramArrayOfFloat, paramDirection);
    paramRect.offset(-this.xOffset, -this.yOffset);
  }
  
  @Deprecated
  public void addRoundRect(RectF paramRectF, float paramFloat1, float paramFloat2, Path.Direction paramDirection)
  {
    paramRectF.offset(this.xOffset, this.yOffset);
    super.addRoundRect(paramRectF, paramFloat1, paramFloat2, paramDirection);
    paramRectF.offset(-this.xOffset, -this.yOffset);
  }
  
  @Deprecated
  public void addRoundRect(RectF paramRectF, float[] paramArrayOfFloat, Path.Direction paramDirection)
  {
    paramRectF.offset(this.xOffset, this.yOffset);
    super.addRoundRect(paramRectF, paramArrayOfFloat, paramDirection);
    paramRectF.offset(-this.xOffset, -this.yOffset);
  }
  
  public void arcTo(Rect paramRect, float paramFloat1, float paramFloat2)
  {
    paramRect.offset(this.xOffset, this.yOffset);
    super.arcTo(toOffsetRectF(paramRect, sRectF), paramFloat1, paramFloat2);
    paramRect.offset(-this.xOffset, -this.yOffset);
  }
  
  public void arcTo(Rect paramRect, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    paramRect.offset(this.xOffset, this.yOffset);
    super.arcTo(toOffsetRectF(paramRect, sRectF), paramFloat1, paramFloat2, paramBoolean);
    paramRect.offset(-this.xOffset, -this.yOffset);
  }
  
  @Deprecated
  public void arcTo(RectF paramRectF, float paramFloat1, float paramFloat2)
  {
    paramRectF.offset(this.xOffset, this.yOffset);
    super.arcTo(paramRectF, paramFloat1, paramFloat2);
    paramRectF.offset(-this.xOffset, -this.yOffset);
  }
  
  @Deprecated
  public void arcTo(RectF paramRectF, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    paramRectF.offset(this.xOffset, this.yOffset);
    super.arcTo(paramRectF, paramFloat1, paramFloat2, paramBoolean);
    paramRectF.offset(-this.xOffset, -this.yOffset);
  }
  
  public void close()
  {
    super.close();
  }
  
  public void computeBounds(Rect paramRect, boolean paramBoolean)
  {
    super.computeBounds(sRectF, paramBoolean);
    paramRect.set((int)sRectF.left, (int)sRectF.top, (int)sRectF.right, (int)sRectF.bottom);
    paramRect.offset(-this.xOffset, -this.yOffset);
  }
  
  @Deprecated
  public void computeBounds(RectF paramRectF, boolean paramBoolean)
  {
    super.computeBounds(paramRectF, paramBoolean);
    paramRectF.offset(-this.xOffset, -this.yOffset);
  }
  
  public void cubicTo(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    super.cubicTo((float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2), (float)(this.xOffset + paramDouble3), (float)(this.yOffset + paramDouble4), (float)(this.xOffset + paramDouble5), (float)(this.yOffset + paramDouble6));
  }
  
  @Deprecated
  public void cubicTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    super.cubicTo(paramFloat1 + this.xOffset, paramFloat2 + this.yOffset, paramFloat3 + this.xOffset, paramFloat4 + this.yOffset, paramFloat5 + this.xOffset, paramFloat6 + this.yOffset);
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
  }
  
  public Path.FillType getFillType()
  {
    return super.getFillType();
  }
  
  public void incReserve(int paramInt)
  {
    super.incReserve(paramInt);
  }
  
  public boolean isEmpty()
  {
    return super.isEmpty();
  }
  
  public boolean isInverseFillType()
  {
    return super.isInverseFillType();
  }
  
  public boolean isRect(Rect paramRect)
  {
    paramRect.offset(this.xOffset, this.yOffset);
    boolean bool = super.isRect(toOffsetRectF(paramRect, sRectF));
    paramRect.offset(-this.xOffset, -this.yOffset);
    return bool;
  }
  
  @Deprecated
  public boolean isRect(RectF paramRectF)
  {
    paramRectF.offset(this.xOffset, this.yOffset);
    boolean bool = super.isRect(paramRectF);
    paramRectF.offset(-this.xOffset, -this.yOffset);
    return bool;
  }
  
  public void lineTo(double paramDouble1, double paramDouble2)
  {
    super.lineTo((float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2));
  }
  
  @Deprecated
  public void lineTo(float paramFloat1, float paramFloat2)
  {
    super.lineTo(this.xOffset + paramFloat1, this.yOffset + paramFloat2);
  }
  
  public void moveTo(double paramDouble1, double paramDouble2)
  {
    super.moveTo((float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2));
  }
  
  @Deprecated
  public void moveTo(float paramFloat1, float paramFloat2)
  {
    super.moveTo(this.xOffset + paramFloat1, this.yOffset + paramFloat2);
  }
  
  public void offset(float paramFloat1, float paramFloat2)
  {
    super.offset(paramFloat1, paramFloat2);
  }
  
  public void offset(float paramFloat1, float paramFloat2, Path paramPath)
  {
    super.offset(paramFloat1, paramFloat2, paramPath);
  }
  
  public void onDrawCycleStart(ISafeCanvas paramISafeCanvas)
  {
    int i = paramISafeCanvas.getXOffset();
    int j = this.xOffset;
    int k = paramISafeCanvas.getYOffset();
    int m = this.yOffset;
    super.offset(i - j, k - m);
    this.xOffset = paramISafeCanvas.getXOffset();
    this.yOffset = paramISafeCanvas.getYOffset();
  }
  
  public void quadTo(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    super.quadTo((float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2), (float)(this.xOffset + paramDouble3), (float)(this.yOffset + paramDouble4));
  }
  
  @Deprecated
  public void quadTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super.quadTo(this.xOffset + paramFloat1, this.yOffset + paramFloat2, this.xOffset + paramFloat3, this.yOffset + paramFloat4);
  }
  
  public void rCubicTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    super.rCubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public void rLineTo(float paramFloat1, float paramFloat2)
  {
    super.rLineTo(paramFloat1, paramFloat2);
  }
  
  public void rMoveTo(float paramFloat1, float paramFloat2)
  {
    super.rMoveTo(paramFloat1, paramFloat2);
  }
  
  public void rQuadTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super.rQuadTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void reset()
  {
    super.reset();
  }
  
  public void rewind()
  {
    super.rewind();
  }
  
  public void set(Path paramPath)
  {
    super.set(paramPath);
  }
  
  public void setFillType(Path.FillType paramFillType)
  {
    super.setFillType(paramFillType);
  }
  
  public void setLastPoint(double paramDouble1, double paramDouble2)
  {
    super.setLastPoint((float)(this.xOffset + paramDouble1), (float)(this.yOffset + paramDouble2));
  }
  
  @Deprecated
  public void setLastPoint(float paramFloat1, float paramFloat2)
  {
    super.setLastPoint(this.xOffset + paramFloat1, this.yOffset + paramFloat2);
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
  
  public void toggleInverseFillType()
  {
    super.toggleInverseFillType();
  }
  
  public void transform(Matrix paramMatrix)
  {
    super.transform(paramMatrix);
  }
  
  public void transform(Matrix paramMatrix, Path paramPath)
  {
    super.transform(paramMatrix, paramPath);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/safecanvas/SafeTranslatedPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */