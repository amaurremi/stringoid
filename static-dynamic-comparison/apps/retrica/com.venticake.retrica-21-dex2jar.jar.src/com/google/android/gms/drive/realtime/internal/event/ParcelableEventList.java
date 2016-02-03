package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableEventList
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableEventList> CREATOR = new b();
  final ParcelableEvent[] LB;
  final DataHolder LC;
  final boolean LD;
  final ParcelableObjectChangedEvent[] LE;
  final int xM;
  
  ParcelableEventList(int paramInt, ParcelableEvent[] paramArrayOfParcelableEvent, DataHolder paramDataHolder, boolean paramBoolean, ParcelableObjectChangedEvent[] paramArrayOfParcelableObjectChangedEvent)
  {
    this.xM = paramInt;
    this.LB = paramArrayOfParcelableEvent;
    this.LC = paramDataHolder;
    this.LD = paramBoolean;
    this.LE = paramArrayOfParcelableObjectChangedEvent;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ParcelableEventList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */