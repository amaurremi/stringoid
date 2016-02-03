package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MsgCenterBean
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new i();
  private int a;
  private String b;
  private String c;
  private String d;
  private int e;
  private String f;
  private int g;
  private String h;
  private int i;
  
  public MsgCenterBean()
  {
    this.i = 1;
  }
  
  private MsgCenterBean(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.f = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readString();
    this.i = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeInt(this.i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/MsgCenterBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */