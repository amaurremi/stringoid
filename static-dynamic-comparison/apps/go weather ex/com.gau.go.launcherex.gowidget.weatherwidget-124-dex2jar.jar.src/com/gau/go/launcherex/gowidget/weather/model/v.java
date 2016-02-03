package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class v
  implements Parcelable.Creator
{
  public WeatherBean a(Parcel paramParcel)
  {
    return new WeatherBean(paramParcel, null);
  }
  
  public WeatherBean[] a(int paramInt)
  {
    return new WeatherBean[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */