package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class g
  implements Parcelable.Creator
{
  public HourlyBean a(Parcel paramParcel)
  {
    return new HourlyBean(paramParcel, null);
  }
  
  public HourlyBean[] a(int paramInt)
  {
    return new HourlyBean[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */