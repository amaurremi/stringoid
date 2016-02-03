package com.gau.go.launcherex.gowidget.scriptengine.parser;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class h
  implements Parcelable.Creator
{
  public DescriptionBean a(Parcel paramParcel)
  {
    return new DescriptionBean(paramParcel, null);
  }
  
  public DescriptionBean[] a(int paramInt)
  {
    return new DescriptionBean[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */