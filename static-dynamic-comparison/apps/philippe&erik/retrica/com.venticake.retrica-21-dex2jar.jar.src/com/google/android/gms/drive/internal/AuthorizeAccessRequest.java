package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AuthorizeAccessRequest> CREATOR = new b();
  final DriveId Hz;
  final long Is;
  final int xM;
  
  AuthorizeAccessRequest(int paramInt, long paramLong, DriveId paramDriveId)
  {
    this.xM = paramInt;
    this.Is = paramLong;
    this.Hz = paramDriveId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/AuthorizeAccessRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */