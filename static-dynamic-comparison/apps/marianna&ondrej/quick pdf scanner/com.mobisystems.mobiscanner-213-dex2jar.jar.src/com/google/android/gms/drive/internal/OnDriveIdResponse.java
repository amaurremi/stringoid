package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OnDriveIdResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnDriveIdResponse> CREATOR = new c();
  final int qh;
  DriveId tc;
  
  OnDriveIdResponse(int paramInt, DriveId paramDriveId)
  {
    this.qh = paramInt;
    this.tc = paramDriveId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveId mV()
  {
    return this.tc;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/internal/OnDriveIdResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */