package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

public class Water
  extends ImageView
{
  public WaterDropView a;
  private boolean b = false;
  private float c = 0.0F;
  private Drawable d = getResources().getDrawable(2130837576);
  private int e = this.d.getIntrinsicWidth();
  private int f = this.d.getIntrinsicHeight();
  private TextView g;
  private int h = (int)(getResources().getDisplayMetrics().density * 75.0F);
  
  public Water(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    clearAnimation();
    this.b = false;
    this.c = 0.0F;
    if (this.g != null) {
      this.g.setText(String.valueOf(12) + "%");
    }
    invalidate();
  }
  
  public void a(TextView paramTextView)
  {
    this.g = paramTextView;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.b) {
      super.onDraw(paramCanvas);
    }
    Rect localRect;
    do
    {
      do
      {
        return;
      } while (this.d == null);
      localRect = this.d.getBounds();
      localRect.left = 0;
      localRect.top = (getHeight() - this.f + (int)(-this.h * this.c));
      localRect.right = getRight();
      localRect.bottom = getHeight();
      this.d.draw(paramCanvas);
    } while (this.a == null);
    this.a.a = localRect.top;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/Water.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */