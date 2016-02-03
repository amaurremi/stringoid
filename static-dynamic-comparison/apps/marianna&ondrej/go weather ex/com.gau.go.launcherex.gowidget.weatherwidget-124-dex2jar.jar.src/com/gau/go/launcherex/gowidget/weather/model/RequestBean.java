package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RequestBean
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new o();
  public String a;
  public String b;
  public long c;
  
  public RequestBean() {}
  
  private RequestBean(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readLong();
  }
  
  public RequestBean(String paramString1, String paramString2, long paramLong)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramLong;
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/RequestBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */