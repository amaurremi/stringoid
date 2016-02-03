package com.mobisystems.pdf.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

public class OpacityPreviewView
  extends View
{
  private static final float BACKGROUND_RECT_SIZE_DP = 10.0F;
  private int _height;
  private Paint _paint = new Paint();
  private RectF _rectDest = new RectF();
  private int _width;
  public int previewedColor;
  
  public OpacityPreviewView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public OpacityPreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OpacityPreviewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this._rectDest.set(0.0F, 0.0F, this._width, this._height);
    this._paint.setStyle(Paint.Style.FILL_AND_STROKE);
    this._paint.setColor(-1);
    paramCanvas.drawRect(this._rectDest, this._paint);
    this._paint.setColor(-4144960);
    int k = (int)(getResources().getDisplayMetrics().density * 10.0F + 0.5F);
    int m = Math.max(this._width, this._height) / k + 1;
    int i = 0;
    while (i < m)
    {
      int j = 0;
      while (j < m)
      {
        if ((i + j) % 2 == 1)
        {
          this._rectDest.set(i * k, j * k, (i + 1) * k, (j + 1) * k);
          paramCanvas.drawRect(this._rectDest, this._paint);
        }
        j += 1;
      }
      i += 1;
    }
    this._paint.setColor(this.previewedColor);
    this._rectDest.set(0.0F, 0.0F, this._width, this._height);
    paramCanvas.drawRect(this._rectDest, this._paint);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getSize(paramInt1) / 2;
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this._width = paramInt1;
    this._height = paramInt2;
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/OpacityPreviewView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */