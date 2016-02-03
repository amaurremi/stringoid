package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class y
  implements Parcelable.Creator
{
  public WidgetSettingBean a(Parcel paramParcel)
  {
    return new WidgetSettingBean(paramParcel, null);
  }
  
  public WidgetSettingBean[] a(int paramInt)
  {
    return new WidgetSettingBean[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */