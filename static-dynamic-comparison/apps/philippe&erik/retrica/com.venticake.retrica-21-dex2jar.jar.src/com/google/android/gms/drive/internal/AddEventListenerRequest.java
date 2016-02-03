package com.google.android.gms.drive.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AddEventListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddEventListenerRequest> CREATOR = new a();
  final DriveId Hz;
  final int Iq;
  final PendingIntent Ir;
  final int xM;
  
  AddEventListenerRequest(int paramInt1, DriveId paramDriveId, int paramInt2, PendingIntent paramPendingIntent)
  {
    this.xM = paramInt1;
    this.Hz = paramDriveId;
    this.Iq = paramInt2;
    this.Ir = paramPendingIntent;
  }
  
  public AddEventListenerRequest(DriveId paramDriveId, int paramInt, PendingIntent paramPendingIntent)
  {
    this(1, paramDriveId, paramInt, paramPendingIntent);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/AddEventListenerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */