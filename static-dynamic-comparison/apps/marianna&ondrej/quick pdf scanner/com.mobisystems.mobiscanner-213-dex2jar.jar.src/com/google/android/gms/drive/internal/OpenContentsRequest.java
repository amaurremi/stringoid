package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenContentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<OpenContentsRequest> CREATOR = new h();
  final int CR;
  final int qh;
  final DriveId tc;
  
  OpenContentsRequest(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    this.qh = paramInt1;
    this.tc = paramDriveId;
    this.CR = paramInt2;
  }
  
  public OpenContentsRequest(DriveId paramDriveId, int paramInt)
  {
    this(1, paramDriveId, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/internal/OpenContentsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */