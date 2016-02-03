package com.mobisystems.mobiscanner.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class HistogramView
  extends View
{
  private int[] aLU;
  private Rect aLV = new Rect();
  private Paint aLW;
  private Bitmap sr;
  
  public HistogramView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HistogramView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HistogramView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Paint JZ()
  {
    if (this.aLW == null) {
      this.aLW = new Paint();
    }
    return this.aLW;
  }
  
  public void b(int[] paramArrayOfInt)
  {
    this.aLU = paramArrayOfInt;
    if (this.sr == null) {
      this.sr = Bitmap.createBitmap(256, 100, Bitmap.Config.ARGB_8888);
    }
    int i = -1;
    paramArrayOfInt = this.aLU;
    int m = paramArrayOfInt.length;
    int j = 0;
    int k;
    if (j < m)
    {
      k = paramArrayOfInt[j];
      if (k <= i) {
        break label141;
      }
      i = k;
    }
    label141:
    for (;;)
    {
      j += 1;
      break;
      j = 0;
      while (j < this.aLU.length)
      {
        m = this.aLU[j] * 100 / i;
        k = 0;
        while (k < m)
        {
          this.sr.setPixel(j, 100 - k - 1, Color.rgb(0, 0, 255));
          k += 1;
        }
        j += 1;
      }
      return;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.sr != null)
    {
      this.aLV.set(0, 0, getWidth(), getHeight());
      paramCanvas.drawBitmap(this.sr, null, this.aLV, JZ());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/view/HistogramView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */