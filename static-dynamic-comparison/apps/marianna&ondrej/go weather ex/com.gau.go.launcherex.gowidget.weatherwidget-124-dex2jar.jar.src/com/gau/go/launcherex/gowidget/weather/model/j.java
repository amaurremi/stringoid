package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class j
  implements Parcelable.Creator
{
  public NowBean a(Parcel paramParcel)
  {
    return new NowBean(paramParcel, null);
  }
  
  public NowBean[] a(int paramInt)
  {
    return new NowBean[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */