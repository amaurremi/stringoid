package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemoveEventListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RemoveEventListenerRequest> CREATOR = new au();
  final DriveId Hw;
  final int In;
  final int xJ;
  
  RemoveEventListenerRequest(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    this.xJ = paramInt1;
    this.Hw = paramDriveId;
    this.In = paramInt2;
  }
  
  public RemoveEventListenerRequest(DriveId paramDriveId, int paramInt)
  {
    this(1, paramDriveId, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    au.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/RemoveEventListenerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */