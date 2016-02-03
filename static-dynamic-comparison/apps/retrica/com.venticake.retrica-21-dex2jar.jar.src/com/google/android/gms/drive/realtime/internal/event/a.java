package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
  implements Parcelable.Creator<ParcelableEvent>
{
  static void a(ParcelableEvent paramParcelableEvent, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramParcelableEvent.xM);
    b.a(paramParcel, 2, paramParcelableEvent.rR, false);
    b.a(paramParcel, 3, paramParcelableEvent.Lm, false);
    b.a(paramParcel, 4, paramParcelableEvent.Ls);
    b.a(paramParcel, 5, paramParcelableEvent.Lq, false);
    b.a(paramParcel, 6, paramParcelableEvent.Lt, false);
    b.a(paramParcel, 7, paramParcelableEvent.Lu, paramInt, false);
    b.a(paramParcel, 8, paramParcelableEvent.Lv, paramInt, false);
    b.a(paramParcel, 9, paramParcelableEvent.Lw, paramInt, false);
    b.a(paramParcel, 10, paramParcelableEvent.Lx, paramInt, false);
    b.a(paramParcel, 11, paramParcelableEvent.Ly, paramInt, false);
    b.a(paramParcel, 12, paramParcelableEvent.Lz, paramInt, false);
    b.a(paramParcel, 13, paramParcelableEvent.LA, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public ParcelableEvent aT(Parcel paramParcel)
  {
    int j = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    int i = 0;
    String str4 = null;
    String str3 = null;
    boolean bool = false;
    String str2 = null;
    String str1 = null;
    TextInsertedDetails localTextInsertedDetails = null;
    TextDeletedDetails localTextDeletedDetails = null;
    ValuesAddedDetails localValuesAddedDetails = null;
    ValuesRemovedDetails localValuesRemovedDetails = null;
    ValuesSetDetails localValuesSetDetails = null;
    ValueChangedDetails localValueChangedDetails = null;
    ReferenceShiftedDetails localReferenceShiftedDetails = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2: 
        str4 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 3: 
        str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 4: 
        bool = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k);
        break;
      case 5: 
        str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 6: 
        str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 7: 
        localTextInsertedDetails = (TextInsertedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, TextInsertedDetails.CREATOR);
        break;
      case 8: 
        localTextDeletedDetails = (TextDeletedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, TextDeletedDetails.CREATOR);
        break;
      case 9: 
        localValuesAddedDetails = (ValuesAddedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, ValuesAddedDetails.CREATOR);
        break;
      case 10: 
        localValuesRemovedDetails = (ValuesRemovedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, ValuesRemovedDetails.CREATOR);
        break;
      case 11: 
        localValuesSetDetails = (ValuesSetDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, ValuesSetDetails.CREATOR);
        break;
      case 12: 
        localValueChangedDetails = (ValueChangedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, ValueChangedDetails.CREATOR);
        break;
      case 13: 
        localReferenceShiftedDetails = (ReferenceShiftedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, ReferenceShiftedDetails.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ParcelableEvent(i, str4, str3, bool, str2, str1, localTextInsertedDetails, localTextDeletedDetails, localValuesAddedDetails, localValuesRemovedDetails, localValuesSetDetails, localValueChangedDetails, localReferenceShiftedDetails);
  }
  
  public ParcelableEvent[] bQ(int paramInt)
  {
    return new ParcelableEvent[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */