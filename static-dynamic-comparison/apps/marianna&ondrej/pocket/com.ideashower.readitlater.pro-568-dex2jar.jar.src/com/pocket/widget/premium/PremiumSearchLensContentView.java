package com.pocket.widget.premium;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.views.a;
import com.pocket.widget.y;

public class PremiumSearchLensContentView
  extends a
  implements y
{
  private final PointF a = new PointF();
  private Paint b;
  private int c;
  private int d;
  private Matrix e;
  private boolean f;
  private float g;
  private float h;
  
  public PremiumSearchLensContentView(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public PremiumSearchLensContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public PremiumSearchLensContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.PremiumIcon);
      this.g = paramAttributeSet.getFloat(0, 1.0F);
      this.h = paramAttributeSet.getFloat(1, this.g);
    }
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setColor(-16777216);
    this.e = new Matrix();
    setImageMatrix(this.e);
    setScaleType(ImageView.ScaleType.MATRIX);
    setImageResource(2130837908);
    paramAttributeSet = getDrawable();
    this.c = paramAttributeSet.getIntrinsicWidth();
    this.d = paramAttributeSet.getIntrinsicHeight();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.a.set(paramFloat1, paramFloat2);
    if (getWidth() == 0)
    {
      this.f = true;
      return;
    }
    Matrix localMatrix = this.e;
    float f1 = (getWidth() - this.c) / 2.0F;
    float f2 = (getHeight() - this.d) / 2.0F;
    paramFloat1 = -paramFloat1;
    paramFloat2 = -paramFloat2;
    localMatrix.reset();
    localMatrix.postTranslate(f1 + paramFloat1 * 2.5F, f2 + paramFloat2 * 2.5F);
    setImageMatrix(localMatrix);
  }
  
  protected void a(Canvas paramCanvas, RectF paramRectF)
  {
    float f1 = (paramRectF.width() - getPaddingLeft() - getPaddingRight()) / 2.0F;
    paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, f1, this.b);
  }
  
  public float getDepthX()
  {
    return this.g;
  }
  
  public float getDepthY()
  {
    return this.h;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.f) {
      a(this.a.x, this.a.y);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/PremiumSearchLensContentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */