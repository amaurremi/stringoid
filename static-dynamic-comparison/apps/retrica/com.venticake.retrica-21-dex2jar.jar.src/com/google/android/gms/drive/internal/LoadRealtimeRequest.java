package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class LoadRealtimeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoadRealtimeRequest> CREATOR = new ae();
  final DriveId Hz;
  final boolean Js;
  final int xM;
  
  LoadRealtimeRequest(int paramInt, DriveId paramDriveId, boolean paramBoolean)
  {
    this.xM = paramInt;
    this.Hz = paramDriveId;
    this.Js = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ae.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/LoadRealtimeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */