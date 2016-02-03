package com.mobisystems.mobiscanner.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.view.View;
import com.mobisystems.mobiscanner.common.c;

public class CameraGridView
  extends View
{
  private static float aKi;
  private static int aKj;
  private static int aKk;
  private a aKl;
  private boolean aKm = false;
  private final c mLog = new c(this);
  
  public CameraGridView(Context paramContext)
  {
    super(paramContext);
    aKi = paramContext.getResources().getDimension(2131230798);
    aKj = 0;
    aKk = paramContext.getResources().getColor(2131427362);
  }
  
  private int JB()
  {
    if (this.aKm) {
      return aKk;
    }
    return aKj;
  }
  
  private void JC()
  {
    if (this.aKl != null) {
      this.aKl.getPaint().setColor(JB());
    }
  }
  
  private void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.aKl = new a(3, 3);
    Paint localPaint = this.aKl.getPaint();
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(aKi);
    JC();
    this.aKl.setBounds(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
  
  public void bt(boolean paramBoolean)
  {
    this.mLog.dl("setGridVisible, visible=" + paramBoolean);
    if (this.aKm != paramBoolean)
    {
      this.aKm = paramBoolean;
      JC();
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.aKl.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      this.mLog.dl("onLayout called, l=" + paramInt1 + ", t=" + paramInt2 + ", r=" + paramInt3 + ", b=" + paramInt4);
      i(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  private class a
    extends ShapeDrawable
  {
    private int aKn;
    private int aKo;
    
    public a(int paramInt1, int paramInt2)
    {
      super();
      this.aKn = paramInt1;
      this.aKo = paramInt2;
    }
    
    public void onDraw(Shape paramShape, Canvas paramCanvas, Paint paramPaint)
    {
      int k = 0;
      super.onDraw(paramShape, paramCanvas, paramPaint);
      paramShape = getBounds();
      int m = paramShape.right;
      int n = paramShape.left;
      int i1 = paramShape.bottom;
      int i2 = paramShape.top;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.aKn - 1) {
          break;
        }
        j = (i1 - i2) / this.aKn * (i + 1);
        paramCanvas.drawLine(paramShape.left, j, paramShape.right, j, paramPaint);
        i += 1;
      }
      while (j < this.aKo - 1)
      {
        i = (m - n) / this.aKo * (j + 1);
        paramCanvas.drawLine(i, paramShape.top, i, paramShape.bottom, paramPaint);
        j += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/view/CameraGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */