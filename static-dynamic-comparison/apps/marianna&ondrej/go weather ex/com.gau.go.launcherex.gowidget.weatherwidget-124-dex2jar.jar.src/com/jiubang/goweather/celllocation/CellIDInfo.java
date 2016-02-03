package com.jiubang.goweather.celllocation;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CellIDInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  public int a;
  public int b;
  public int c;
  public int d;
  public String e;
  public int f = -50;
  
  public CellIDInfo() {}
  
  private CellIDInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/celllocation/CellIDInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */