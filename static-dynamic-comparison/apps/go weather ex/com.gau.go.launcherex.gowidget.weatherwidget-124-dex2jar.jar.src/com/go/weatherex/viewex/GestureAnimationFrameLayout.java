package com.go.weatherex.viewex;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class GestureAnimationFrameLayout
  extends FrameLayout
  implements c
{
  private f a;
  private boolean b = false;
  
  public GestureAnimationFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public GestureAnimationFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GestureAnimationFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(f paramf)
  {
    this.a = paramf;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.b)
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    if ((this.a != null) && (this.a.a()))
    {
      int i = paramCanvas.save();
      if (this.a.a(this, paramCanvas)) {
        super.dispatchDraw(paramCanvas);
      }
      paramCanvas.restoreToCount(i);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.b = true;
    if ((this.a != null) && (this.a.a()))
    {
      int i = paramCanvas.save();
      if (this.a.a(this, paramCanvas)) {
        super.draw(paramCanvas);
      }
      paramCanvas.restoreToCount(i);
    }
    for (;;)
    {
      this.b = false;
      return;
      super.draw(paramCanvas);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/viewex/GestureAnimationFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */