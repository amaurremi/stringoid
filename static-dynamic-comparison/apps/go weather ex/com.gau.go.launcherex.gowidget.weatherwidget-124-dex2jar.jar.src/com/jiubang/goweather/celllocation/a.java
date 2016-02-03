package com.jiubang.goweather.celllocation;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator
{
  public CellIDInfo a(Parcel paramParcel)
  {
    return new CellIDInfo(paramParcel, null);
  }
  
  public CellIDInfo[] a(int paramInt)
  {
    return new CellIDInfo[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/celllocation/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */