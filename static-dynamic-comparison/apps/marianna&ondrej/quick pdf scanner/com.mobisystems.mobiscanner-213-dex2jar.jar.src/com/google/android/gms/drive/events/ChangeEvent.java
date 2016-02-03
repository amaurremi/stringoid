package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public final class ChangeEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator<ChangeEvent> CREATOR = new a();
  final int qh;
  final DriveId sG;
  final int sZ;
  
  ChangeEvent(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    this.qh = paramInt1;
    this.sG = paramDriveId;
    this.sZ = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getType()
  {
    return 1;
  }
  
  public boolean nc()
  {
    return (this.sZ & 0x1) != 0;
  }
  
  public boolean nd()
  {
    return (this.sZ & 0x2) != 0;
  }
  
  public String toString()
  {
    return String.format("ChangeEvent [id=%s,changeFlags=%x]", new Object[] { this.sG, Integer.valueOf(this.sZ) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/events/ChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */