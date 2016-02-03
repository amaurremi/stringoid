package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class o
  implements Parcelable.Creator
{
  public RequestBean a(Parcel paramParcel)
  {
    return new RequestBean(paramParcel, null);
  }
  
  public RequestBean[] a(int paramInt)
  {
    return new RequestBean[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */