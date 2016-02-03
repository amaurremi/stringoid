package com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class DynamicbgDescriptionView
  extends LinearLayout
{
  private Context a = null;
  private int b;
  private int c;
  
  public DynamicbgDescriptionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return this.a.getString(2131166422);
    }
    return this.a.getString(2131166421);
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public String c()
  {
    switch (this.b)
    {
    case 1: 
    default: 
      return "";
    case 2: 
      return this.a.getString(2131166423) + " " + a(this.c);
    case 3: 
      return this.a.getString(2131166424) + " " + a(this.c);
    case 4: 
      return this.a.getString(2131166425) + " " + a(this.c);
    case 5: 
      return this.a.getString(2131166429) + " " + a(this.c);
    case 6: 
      return this.a.getString(2131166427) + " " + a(this.c);
    case 7: 
      return this.a.getString(2131166426) + " " + a(this.c);
    }
    return this.a.getString(2131166428) + " " + a(this.c);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/dynamicbackground/preview/DynamicbgDescriptionView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */