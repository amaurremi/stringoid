package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class DeleteCustomPropertyRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DeleteCustomPropertyRequest> CREATOR = new m();
  final DriveId Hz;
  final CustomPropertyKey IJ;
  final int xM;
  
  DeleteCustomPropertyRequest(int paramInt, DriveId paramDriveId, CustomPropertyKey paramCustomPropertyKey)
  {
    this.xM = paramInt;
    this.Hz = paramDriveId;
    this.IJ = paramCustomPropertyKey;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    m.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/DeleteCustomPropertyRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */