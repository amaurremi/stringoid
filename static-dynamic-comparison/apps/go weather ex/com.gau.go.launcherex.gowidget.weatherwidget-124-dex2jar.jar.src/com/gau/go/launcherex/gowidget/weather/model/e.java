package com.gau.go.launcherex.gowidget.weather.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class e
  implements Parcelable.Creator
{
  public FeedbackBean a(Parcel paramParcel)
  {
    return new FeedbackBean(paramParcel, null);
  }
  
  public FeedbackBean[] a(int paramInt)
  {
    return new FeedbackBean[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */