package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AlarmBean
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  String a = "";
  
  AlarmBean() {}
  
  private AlarmBean(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/AlarmBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */