package com.go.weatherex.home.dayforecast;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.go.weatherex.framework.fragment.a;
import java.util.ArrayList;

public class g
  extends a
{
  private f a;
  private ForecastDaysForm b;
  private String c = "";
  private i d = new i(this, null);
  private Time e;
  
  private void a(boolean paramBoolean)
  {
    ArrayList localArrayList = this.a.d();
    int i = 0;
    for (;;)
    {
      if (i < localArrayList.size()) {
        if (localArrayList.get(i) == null) {
          break label64;
        }
      }
      label64:
      for (String str = ((WeatherBean)localArrayList.get(i)).c(); str.equals(this.c); str = "")
      {
        this.b.a(str, paramBoolean, false);
        return;
      }
      i += 1;
    }
  }
  
  private boolean b()
  {
    Time localTime = new Time();
    localTime.setToNow();
    if ((this.e.year == localTime.year) && (this.e.month == localTime.month) && (this.e.monthDay == localTime.monthDay)) {
      return false;
    }
    this.e.setToNow();
    return true;
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString("cityId");; paramBundle = "")
    {
      if ((!TextUtils.isEmpty(paramBundle)) && (!paramBundle.equals(this.c))) {
        this.c = paramBundle;
      }
      return;
    }
  }
  
  protected void b(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (isHidden());
      paramObject = String.valueOf(paramObject);
    } while ((TextUtils.isEmpty((CharSequence)paramObject)) || (((String)paramObject).equals(this.c)));
    this.c = ((String)paramObject);
  }
  
  protected void f()
  {
    super.f();
    this.b.b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(new int[] { 10 });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903141, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    b(this.d);
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.a = c.a(getActivity().getApplicationContext()).h();
    this.b = ((ForecastDaysForm)c(2131231347));
    this.b.a(this);
    this.e = new Time();
    this.e.setToNow();
    paramView = getArguments();
    if (paramView != null) {}
    for (paramView = paramView.getString("cityId");; paramView = "")
    {
      this.c = paramView;
      a(true);
      a(this.d);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/dayforecast/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */