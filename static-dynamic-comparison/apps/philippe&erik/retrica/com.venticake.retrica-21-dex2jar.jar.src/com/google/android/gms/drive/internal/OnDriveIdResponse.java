package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OnDriveIdResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnDriveIdResponse> CREATOR = new ai();
  DriveId Iu;
  final int xM;
  
  OnDriveIdResponse(int paramInt, DriveId paramDriveId)
  {
    this.xM = paramInt;
    this.Iu = paramDriveId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveId getDriveId()
  {
    return this.Iu;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ai.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/OnDriveIdResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */