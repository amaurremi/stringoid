package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class n
  implements Parcelable.Creator
{
  public RecommendedAppsBean a(Parcel paramParcel)
  {
    return new RecommendedAppsBean(paramParcel, null);
  }
  
  public RecommendedAppsBean[] a(int paramInt)
  {
    return new RecommendedAppsBean[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */