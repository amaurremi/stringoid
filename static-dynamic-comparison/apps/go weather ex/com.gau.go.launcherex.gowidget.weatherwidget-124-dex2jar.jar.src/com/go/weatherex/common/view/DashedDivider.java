package com.go.weatherex.common.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class DashedDivider
  extends View
{
  private int a = -1;
  private Paint b;
  private float c;
  private float d;
  private Path e;
  private PathEffect f;
  
  public DashedDivider(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public DashedDivider(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public DashedDivider(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.d = getContext().getResources().getDisplayMetrics().density;
    this.b = new Paint(3);
    this.b.setColor(this.a);
    this.b.setTextAlign(Paint.Align.CENTER);
    this.b.setStrokeWidth(1.5F * this.d);
    this.b.setStyle(Paint.Style.STROKE);
    this.e = new Path();
    this.f = new DashPathEffect(new float[] { 6.0F, 5.0F, 6.0F, 5.0F }, 1.0F);
    this.b.setPathEffect(this.f);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.c = getWidth();
    float f1 = getHeight();
    this.e.moveTo(0.0F, f1 / 2.0F);
    this.e.lineTo(this.c, f1 / 2.0F);
    paramCanvas.drawPath(this.e, this.b);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/common/view/DashedDivider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */