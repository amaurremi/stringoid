package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.gau.go.launcherex.gowidget.weather.scroller.j;

public class MultiDayScrollView
  extends LinearLayout
{
  private Context a = null;
  private Scroller b = null;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public MultiDayScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    c();
  }
  
  private void c()
  {
    this.b = new Scroller(this.a, new j());
  }
  
  public void a()
  {
    this.b.forceFinished(false);
    this.d = 0;
    scrollTo(0, 0);
    this.c = 0;
  }
  
  public void a(int paramInt)
  {
    this.d = b(paramInt);
    paramInt = this.d * this.e - this.c;
    this.b.startScroll(this.c, 0, paramInt, 0, 600);
    this.c += paramInt;
    invalidate();
  }
  
  protected int b(int paramInt)
  {
    return Math.max(0, Math.min(paramInt, this.g - 3));
  }
  
  public void b()
  {
    a(c(this.c) + 1);
  }
  
  protected int c(int paramInt)
  {
    if (this.e == 0) {
      return 0;
    }
    return (this.e / 2 + paramInt) / this.e;
  }
  
  public void computeScroll()
  {
    if (this.b.computeScrollOffset())
    {
      scrollTo(this.b.getCurrX(), 0);
      postInvalidate();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = (paramInt4 - paramInt2);
    this.e = ((paramInt3 - paramInt1) / 3);
    paramInt3 = getChildCount();
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = getChildAt(paramInt1);
      localView.measure(-1, -1);
      localView.layout(paramInt2, 0, this.e + paramInt2, this.f);
      paramInt2 += this.e;
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.g = getChildCount();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/MultiDayScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */