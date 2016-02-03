package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableEvent> CREATOR = new b();
  final int BR;
  final String Re;
  final String Rh;
  final List<String> Rl;
  final boolean Rm;
  final String Rn;
  final TextInsertedDetails Ro;
  final TextDeletedDetails Rp;
  final ValuesAddedDetails Rq;
  final ValuesRemovedDetails Rr;
  final ValuesSetDetails Rs;
  final ValueChangedDetails Rt;
  final ReferenceShiftedDetails Ru;
  final ObjectChangedDetails Rv;
  final String vL;
  
  ParcelableEvent(int paramInt, String paramString1, String paramString2, List<String> paramList, boolean paramBoolean, String paramString3, String paramString4, TextInsertedDetails paramTextInsertedDetails, TextDeletedDetails paramTextDeletedDetails, ValuesAddedDetails paramValuesAddedDetails, ValuesRemovedDetails paramValuesRemovedDetails, ValuesSetDetails paramValuesSetDetails, ValueChangedDetails paramValueChangedDetails, ReferenceShiftedDetails paramReferenceShiftedDetails, ObjectChangedDetails paramObjectChangedDetails)
  {
    this.BR = paramInt;
    this.vL = paramString1;
    this.Re = paramString2;
    this.Rl = paramList;
    this.Rm = paramBoolean;
    this.Rh = paramString3;
    this.Rn = paramString4;
    this.Ro = paramTextInsertedDetails;
    this.Rp = paramTextDeletedDetails;
    this.Rq = paramValuesAddedDetails;
    this.Rr = paramValuesRemovedDetails;
    this.Rs = paramValuesSetDetails;
    this.Rt = paramValueChangedDetails;
    this.Ru = paramReferenceShiftedDetails;
    this.Rv = paramObjectChangedDetails;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ParcelableEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */