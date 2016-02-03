package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f
  implements Parcelable.Creator
{
  public ForecastBean a(Parcel paramParcel)
  {
    return new ForecastBean(paramParcel, null);
  }
  
  public ForecastBean[] a(int paramInt)
  {
    return new ForecastBean[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */