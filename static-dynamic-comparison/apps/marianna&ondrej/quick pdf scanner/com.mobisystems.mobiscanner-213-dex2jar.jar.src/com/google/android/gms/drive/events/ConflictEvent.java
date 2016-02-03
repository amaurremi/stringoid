package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public final class ConflictEvent
  implements SafeParcelable, DriveEvent
{
  public static final Parcelable.Creator<ConflictEvent> CREATOR = new b();
  final int qh;
  final DriveId sG;
  
  ConflictEvent(int paramInt, DriveId paramDriveId)
  {
    this.qh = paramInt;
    this.sG = paramDriveId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format("ConflictEvent [id=%s]", new Object[] { this.sG });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/events/ConflictEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */