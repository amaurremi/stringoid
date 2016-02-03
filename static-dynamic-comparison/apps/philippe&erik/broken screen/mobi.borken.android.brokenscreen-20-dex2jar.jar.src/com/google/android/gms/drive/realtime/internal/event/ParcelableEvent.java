package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableEvent> CREATOR = new a();
  final String Lj;
  final String Ln;
  final boolean Lp;
  final String Lq;
  final TextInsertedDetails Lr;
  final TextDeletedDetails Ls;
  final ValuesAddedDetails Lt;
  final ValuesRemovedDetails Lu;
  final ValuesSetDetails Lv;
  final ValueChangedDetails Lw;
  final ReferenceShiftedDetails Lx;
  final String rO;
  final int xJ;
  
  ParcelableEvent(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, TextInsertedDetails paramTextInsertedDetails, TextDeletedDetails paramTextDeletedDetails, ValuesAddedDetails paramValuesAddedDetails, ValuesRemovedDetails paramValuesRemovedDetails, ValuesSetDetails paramValuesSetDetails, ValueChangedDetails paramValueChangedDetails, ReferenceShiftedDetails paramReferenceShiftedDetails)
  {
    this.xJ = paramInt;
    this.rO = paramString1;
    this.Lj = paramString2;
    this.Lp = paramBoolean;
    this.Ln = paramString3;
    this.Lq = paramString4;
    this.Lr = paramTextInsertedDetails;
    this.Ls = paramTextDeletedDetails;
    this.Lt = paramValuesAddedDetails;
    this.Lu = paramValuesRemovedDetails;
    this.Lv = paramValuesSetDetails;
    this.Lw = paramValueChangedDetails;
    this.Lx = paramReferenceShiftedDetails;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ParcelableEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */