package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.FileConflictEvent;

public class OnEventResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnEventResponse> CREATOR = new aj();
  final int Iq;
  final ChangeEvent Jy;
  final FileConflictEvent Jz;
  final int xM;
  
  OnEventResponse(int paramInt1, int paramInt2, ChangeEvent paramChangeEvent, FileConflictEvent paramFileConflictEvent)
  {
    this.xM = paramInt1;
    this.Iq = paramInt2;
    this.Jy = paramChangeEvent;
    this.Jz = paramFileConflictEvent;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getEventType()
  {
    return this.Iq;
  }
  
  public ChangeEvent gw()
  {
    return this.Jy;
  }
  
  public FileConflictEvent gx()
  {
    return this.Jz;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aj.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/OnEventResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */