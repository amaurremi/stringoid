package com.go.weatherex.home.windforecast;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.go.weatherex.framework.fragment.a;
import java.util.ArrayList;

public class c
  extends a
  implements SensorEventListener
{
  private f a;
  private String b = "";
  private final e c = new e(this, null);
  private Time d;
  private WeatherWindViewHolder e;
  private SensorManager f;
  
  private void a(boolean paramBoolean)
  {
    ArrayList localArrayList = this.a.d();
    int i = 0;
    for (;;)
    {
      if (i < localArrayList.size()) {
        if (localArrayList.get(i) == null) {
          break label71;
        }
      }
      label71:
      for (String str = ((WeatherBean)localArrayList.get(i)).c();; str = "")
      {
        this.e.a(this);
        if (!str.equals(this.b)) {
          break;
        }
        this.e.a(str, paramBoolean);
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
      return;
    } while (isHidden());
    this.b = String.valueOf(paramObject);
  }
  
  protected void f()
  {
    super.f();
    this.e.a();
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(new int[] { 10 });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903167, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    b(this.c);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.f != null)
    {
      this.f.unregisterListener(this);
      this.f = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((!com.gtp.a.a.c.c.b()) && (this.f == null))
    {
      this.f = ((SensorManager)getActivity().getSystemService("sensor"));
      if (this.f != null) {}
    }
    else
    {
      return;
    }
    this.f.registerListener(this, this.f.getDefaultSensor(3), 0);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    this.e.a(paramSensorEvent.values[0]);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.a = f.a(getActivity().getApplicationContext());
    this.e = ((WeatherWindViewHolder)c(2131231558));
    paramView = getArguments();
    if (paramView != null) {}
    for (paramView = paramView.getString("cityId");; paramView = "")
    {
      this.b = paramView;
      this.d = new Time();
      this.d.setToNow();
      a(true);
      a(this.c);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/windforecast/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */