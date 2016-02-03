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
  final int ES;
  final PendingIntent ET;
  final DriveId Ew;
  final int xH;
  
  AddEventListenerRequest(int paramInt1, DriveId paramDriveId, int paramInt2, PendingIntent paramPendingIntent)
  {
    this.xH = paramInt1;
    this.Ew = paramDriveId;
    this.ES = paramInt2;
    this.ET = paramPendingIntent;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/internal/AddEventListenerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */