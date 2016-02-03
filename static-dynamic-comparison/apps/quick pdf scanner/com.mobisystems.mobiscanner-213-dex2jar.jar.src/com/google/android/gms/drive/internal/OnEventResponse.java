package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ConflictEvent;

public class OnEventResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnEventResponse> CREATOR = new d();
  final int qh;
  final int ta;
  final ChangeEvent to;
  final ConflictEvent tp;
  
  OnEventResponse(int paramInt1, int paramInt2, ChangeEvent paramChangeEvent, ConflictEvent paramConflictEvent)
  {
    this.qh = paramInt1;
    this.ta = paramInt2;
    this.to = paramChangeEvent;
    this.tp = paramConflictEvent;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getEventType()
  {
    return this.ta;
  }
  
  public ChangeEvent nh()
  {
    return this.to;
  }
  
  public ConflictEvent ni()
  {
    return this.tp;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/internal/OnEventResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */