package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

public final class ChangeEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator<ChangeEvent> CREATOR = new a();
  final int BR;
  final DriveId MO;
  final int NE;
  
  ChangeEvent(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    this.BR = paramInt1;
    this.MO = paramDriveId;
    this.NE = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveId getDriveId()
  {
    return this.MO;
  }
  
  public int getType()
  {
    return 1;
  }
  
  public boolean hasContentChanged()
  {
    return (this.NE & 0x2) != 0;
  }
  
  public boolean hasMetadataChanged()
  {
    return (this.NE & 0x1) != 0;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", new Object[] { this.MO, Integer.valueOf(this.NE) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/events/ChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */