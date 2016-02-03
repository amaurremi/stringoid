package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator
{
  public AlarmBean a(Parcel paramParcel)
  {
    return new AlarmBean(paramParcel, null);
  }
  
  public AlarmBean[] a(int paramInt)
  {
    return new AlarmBean[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */