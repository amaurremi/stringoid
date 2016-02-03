package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class TrashResourceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<TrashResourceRequest> CREATOR = new am();
  final DriveId EV;
  final int xH;
  
  TrashResourceRequest(int paramInt, DriveId paramDriveId)
  {
    this.xH = paramInt;
    this.EV = paramDriveId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    am.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/internal/TrashResourceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */