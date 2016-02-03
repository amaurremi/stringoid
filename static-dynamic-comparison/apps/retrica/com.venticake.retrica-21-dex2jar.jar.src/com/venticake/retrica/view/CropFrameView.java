package com.venticake.retrica.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.venticake.retrica.engine.a.g;

public class CropFrameView
  extends View
{
  private float[] mCropRegion = g.a;
  private Paint mPaint = null;
  
  public CropFrameView(Context paramContext)
  {
    super(paramContext);
    _init();
  }
  
  public CropFrameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    _init();
  }
  
  public CropFrameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    _init();
  }
  
  private void _init()
  {
    this.mPaint = new Paint();
    this.mPaint.setColor(-16777216);
    this.mPaint.setTextSize(20.0F);
    this.mPaint.setStyle(Paint.Style.FILL);
    setBackgroundColor(0);
    setClickable(false);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mCropRegion == null) || (this.mCropRegion.length < 4)) {}
    float f1;
    float f2;
    float f6;
    do
    {
      return;
      f1 = getMeasuredWidth();
      f2 = getMeasuredHeight();
      float f3 = this.mCropRegion[0] * f1;
      float f4 = this.mCropRegion[1] * f2;
      float f5 = this.mCropRegion[2] * f1;
      f6 = this.mCropRegion[3] * f2;
      if (f3 > 0.0F) {
        paramCanvas.drawRect(0.0F, 0.0F, f3, f2, this.mPaint);
      }
      if (f4 > 0.0F) {
        paramCanvas.drawRect(0.0F, 0.0F, f1, f4, this.mPaint);
      }
      if (f5 < f1) {
        paramCanvas.drawRect(f5, 0.0F, f1, f2, this.mPaint);
      }
    } while (f6 >= f2);
    paramCanvas.drawRect(0.0F, f6, f1, f2, this.mPaint);
  }
  
  public void setCropRegion(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null) {}
    for (this.mCropRegion = g.a;; this.mCropRegion = paramArrayOfFloat)
    {
      invalidate();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/CropFrameView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */