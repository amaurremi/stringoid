package com.go.weatherex.home.rain;

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
  private String b = "";
  private i c = new i(this, null);
  private Time d;
  private boolean e = true;
  private ForecastRainProbability f;
  
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
      for (String str = ((WeatherBean)localArrayList.get(i)).c(); str.equals(this.b); str = "")
      {
        this.f.a(str, paramBoolean, false);
        return;
      }
      i += 1;
    }
  }
  
  private boolean b()
  {
    Time localTime = new Time();
    localTime.setToNow();
    if ((this.d.year == localTime.year) && (this.d.month == localTime.month) && (this.d.monthDay == localTime.monthDay)) {
      return false;
    }
    this.d.setToNow();
    return true;
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString("cityId");; paramBundle = "")
    {
      if ((!TextUtils.isEmpty(paramBundle)) && (!paramBundle.equals(this.b))) {
        this.b = paramBundle;
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
    } while ((TextUtils.isEmpty((CharSequence)paramObject)) || (((String)paramObject).equals(this.b)));
    this.b = ((String)paramObject);
  }
  
  protected void f()
  {
    super.f();
    this.f.c();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(new int[] { 10 });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903148, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    b(this.c);
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.a = c.a(getActivity().getApplicationContext()).h();
    this.f = ((ForecastRainProbability)c(2131231377));
    this.f.a(this);
    this.d = new Time();
    this.d.setToNow();
    paramView = getArguments();
    if (paramView != null) {}
    for (paramView = paramView.getString("cityId");; paramView = "")
    {
      this.b = paramView;
      a(true);
      a(this.c);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/rain/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */