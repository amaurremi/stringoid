package com.gau.go.launcherex.gowidget.service.error.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator
{
  public LocationErrorBean a(Parcel paramParcel)
  {
    return new LocationErrorBean(paramParcel, null);
  }
  
  public LocationErrorBean[] a(int paramInt)
  {
    return new LocationErrorBean[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/service/error/model/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */