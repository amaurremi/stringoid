package com.go.weatherex.viewex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class AlphaChangeFrameLayout
  extends FrameLayout
{
  private int a = 255;
  private Rect b = new Rect();
  
  public AlphaChangeFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public AlphaChangeFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AlphaChangeFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
    invalidate();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    getDrawingRect(this.b);
    paramCanvas.saveLayerAlpha(0.0F, 0.0F, this.b.right, this.b.bottom, this.a, 31);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/viewex/AlphaChangeFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */