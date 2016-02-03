package com.mobisystems.mobiscanner.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;
import com.mobisystems.mobiscanner.common.c;

public class CameraFocusView
  extends View
{
  private static float aKb;
  private static int aKc;
  private static int aKd;
  private static int aKe;
  private static int aKf;
  private ShapeDrawable aKg;
  private int aKh = aKc;
  private final c mLog = new c(this);
  
  public CameraFocusView(Context paramContext)
  {
    super(paramContext);
    aKb = paramContext.getResources().getDimension(2131230799);
    aKc = 0;
    aKd = paramContext.getResources().getColor(2131427363);
    aKe = paramContext.getResources().getColor(2131427364);
    aKf = paramContext.getResources().getColor(2131427365);
  }
  
  private void JA()
  {
    this.aKg = new ShapeDrawable(new RectShape());
    Paint localPaint = this.aKg.getPaint();
    localPaint.setColor(this.aKh);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(aKb);
  }
  
  private void gB(int paramInt)
  {
    if (paramInt != this.aKh)
    {
      this.aKh = paramInt;
      if (this.aKg != null)
      {
        this.aKg.getPaint().setColor(this.aKh);
        invalidate();
      }
    }
  }
  
  public void EX()
  {
    this.mLog.dl("startAutoFocus");
    gB(aKd);
  }
  
  public void Jz()
  {
    this.mLog.dl("hideFocus");
    gB(aKc);
  }
  
  public void bs(boolean paramBoolean)
  {
    this.mLog.dl("finishAutoFocus, success=" + paramBoolean);
    if (paramBoolean)
    {
      gB(aKe);
      return;
    }
    gB(aKf);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.aKg.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      this.mLog.dl("onLayout called, l=" + paramInt1 + ", t=" + paramInt2 + ", r=" + paramInt3 + ", b=" + paramInt4);
      paramInt1 = paramInt3 - paramInt1;
      paramInt2 = paramInt4 - paramInt2;
      paramInt3 = Math.min(paramInt1, paramInt2) / 5;
      paramInt4 = Math.min(paramInt1, paramInt2) / 5;
      JA();
      this.aKg.setBounds((paramInt1 - paramInt3) / 2, (paramInt2 - paramInt4) / 2, (paramInt1 + paramInt3) / 2, (paramInt2 + paramInt4) / 2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/view/CameraFocusView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */