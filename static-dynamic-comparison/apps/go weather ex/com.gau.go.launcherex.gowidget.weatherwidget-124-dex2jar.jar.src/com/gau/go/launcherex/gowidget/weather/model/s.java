package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class s
  implements Parcelable.Creator
{
  public ThemeDataBean a(Parcel paramParcel)
  {
    return new ThemeDataBean(paramParcel, null);
  }
  
  public ThemeDataBean[] a(int paramInt)
  {
    return new ThemeDataBean[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */