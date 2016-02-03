package com.go.weatherex.home.hourforecast;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import java.util.ArrayList;

public class ForecastHourTrend
  extends FrameLayout
{
  private TrendGraphs a;
  
  public ForecastHourTrend(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ForecastHourTrend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext) {}
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(String paramString, boolean paramBoolean, ArrayList paramArrayList)
  {
    if (!paramArrayList.isEmpty()) {
      this.a.a(paramString, paramArrayList, paramBoolean);
    }
    invalidate();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((TrendGraphs)findViewById(2131231315));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/hourforecast/ForecastHourTrend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */