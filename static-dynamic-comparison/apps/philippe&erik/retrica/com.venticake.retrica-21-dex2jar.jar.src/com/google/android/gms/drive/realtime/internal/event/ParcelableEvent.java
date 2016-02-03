package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableEvent> CREATOR = new a();
  final ReferenceShiftedDetails LA;
  final String Lm;
  final String Lq;
  final boolean Ls;
  final String Lt;
  final TextInsertedDetails Lu;
  final TextDeletedDetails Lv;
  final ValuesAddedDetails Lw;
  final ValuesRemovedDetails Lx;
  final ValuesSetDetails Ly;
  final ValueChangedDetails Lz;
  final String rR;
  final int xM;
  
  ParcelableEvent(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, TextInsertedDetails paramTextInsertedDetails, TextDeletedDetails paramTextDeletedDetails, ValuesAddedDetails paramValuesAddedDetails, ValuesRemovedDetails paramValuesRemovedDetails, ValuesSetDetails paramValuesSetDetails, ValueChangedDetails paramValueChangedDetails, ReferenceShiftedDetails paramReferenceShiftedDetails)
  {
    this.xM = paramInt;
    this.rR = paramString1;
    this.Lm = paramString2;
    this.Ls = paramBoolean;
    this.Lq = paramString3;
    this.Lt = paramString4;
    this.Lu = paramTextInsertedDetails;
    this.Lv = paramTextDeletedDetails;
    this.Lw = paramValuesAddedDetails;
    this.Lx = paramValuesRemovedDetails;
    this.Ly = paramValuesSetDetails;
    this.Lz = paramValueChangedDetails;
    this.LA = paramReferenceShiftedDetails;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ParcelableEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */