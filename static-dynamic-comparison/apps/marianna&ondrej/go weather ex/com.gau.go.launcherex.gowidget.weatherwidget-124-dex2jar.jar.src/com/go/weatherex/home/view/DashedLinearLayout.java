package com.go.weatherex.home.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class DashedLinearLayout
  extends LinearLayout
{
  private View a;
  private boolean b = true;
  private Context c;
  
  public DashedLinearLayout(Context paramContext)
  {
    super(paramContext);
    this.c = paramContext;
  }
  
  public DashedLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
  }
  
  public DashedLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
  }
  
  private void a()
  {
    this.a = new View(this.c);
    this.a.setBackgroundDrawable(getResources().getDrawable(2130837708));
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.b)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, getHeight() - this.a.getHeight());
      paramCanvas.clipRect(this.a.getLeft(), 0, this.a.getRight(), getHeight());
      this.a.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.layout(0, paramInt4 - 1, paramInt3, paramInt4);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/view/DashedLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */