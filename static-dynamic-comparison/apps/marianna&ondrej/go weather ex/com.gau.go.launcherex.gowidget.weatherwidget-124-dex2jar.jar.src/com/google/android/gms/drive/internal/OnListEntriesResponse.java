package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnListEntriesResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnListEntriesResponse> CREATOR = new ad();
  final DataHolder FJ;
  final boolean Fg;
  final int xH;
  
  OnListEntriesResponse(int paramInt, DataHolder paramDataHolder, boolean paramBoolean)
  {
    this.xH = paramInt;
    this.FJ = paramDataHolder;
    this.Fg = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DataHolder fN()
  {
    return this.FJ;
  }
  
  public boolean fO()
  {
    return this.Fg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ad.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/internal/OnListEntriesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */