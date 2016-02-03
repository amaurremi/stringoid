package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AuthorizeAccessRequest> CREATOR = new o();
  final int qh;
  final DriveId sG;
  final long tb;
  
  AuthorizeAccessRequest(int paramInt, long paramLong, DriveId paramDriveId)
  {
    this.qh = paramInt;
    this.tb = paramLong;
    this.sG = paramDriveId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    o.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/internal/AuthorizeAccessRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */