package com.jiubang.playsdk.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class TouchMaskFrameLayout
  extends FrameLayout
{
  private s a = new s(this);
  
  public TouchMaskFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TouchMaskFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null) {
      this.a.a(paramContext, paramAttributeSet);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.a != null) {
      this.a.a(paramCanvas);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
  }
  
  public void refreshDrawableState()
  {
    super.refreshDrawableState();
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/TouchMaskFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */