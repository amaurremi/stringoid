package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewPage
  extends LinearLayout
{
  private LayoutInflater a;
  private FrameLayout b;
  private AdvancedAnimationView c;
  private TextView d;
  private int e = -1;
  private int f = -1;
  
  public ViewPage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = LayoutInflater.from(paramContext);
  }
  
  private boolean e()
  {
    boolean bool = false;
    if (this.f != -1)
    {
      this.c = ((AdvancedAnimationView)this.a.inflate(this.f, null));
      this.b.addView(this.c, -1, -1);
      bool = true;
    }
    return bool;
  }
  
  public void a()
  {
    if ((this.c != null) || (e())) {
      this.c.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    if (paramInt3 != -1) {
      this.d.setText(paramInt3);
    }
  }
  
  public void a(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public void b()
  {
    if (this.c != null) {
      this.c.b();
    }
  }
  
  public long c()
  {
    if (this.c != null) {
      return this.c.c();
    }
    return 0L;
  }
  
  public int d()
  {
    return this.e;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((FrameLayout)findViewById(2131230860));
    this.d = ((TextView)findViewById(2131230861));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/ViewPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */