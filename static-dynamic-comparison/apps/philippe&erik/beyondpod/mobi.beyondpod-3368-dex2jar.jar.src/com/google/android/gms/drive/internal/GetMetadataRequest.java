package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetMetadataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetMetadataRequest> CREATOR = new n();
  final int kg;
  final DriveId rr;
  
  GetMetadataRequest(int paramInt, DriveId paramDriveId)
  {
    this.kg = paramInt;
    this.rr = paramDriveId;
  }
  
  public GetMetadataRequest(DriveId paramDriveId)
  {
    this(1, paramDriveId);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    n.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/internal/GetMetadataRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */