package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class l
  implements Parcelable.Creator
{
  public PollenIndexBean a(Parcel paramParcel)
  {
    return new PollenIndexBean(paramParcel, null);
  }
  
  public PollenIndexBean[] a(int paramInt)
  {
    return new PollenIndexBean[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */