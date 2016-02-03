package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class i
  implements Parcelable.Creator
{
  public MsgCenterBean a(Parcel paramParcel)
  {
    return new MsgCenterBean(paramParcel, null);
  }
  
  public MsgCenterBean[] a(int paramInt)
  {
    return new MsgCenterBean[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */