package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public final class ChangeEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator<ChangeEvent> CREATOR = new a();
  final DriveId Hz;
  final int Ig;
  final int xM;
  
  ChangeEvent(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    this.xM = paramInt1;
    this.Hz = paramDriveId;
    this.Ig = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveId getDriveId()
  {
    return this.Hz;
  }
  
  public int getType()
  {
    return 1;
  }
  
  public boolean hasContentChanged()
  {
    return (this.Ig & 0x2) != 0;
  }
  
  public boolean hasMetadataChanged()
  {
    return (this.Ig & 0x1) != 0;
  }
  
  public String toString()
  {
    return String.format("ChangeEvent [id=%s,changeFlags=%x]", new Object[] { this.Hz, Integer.valueOf(this.Ig) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/events/ChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */