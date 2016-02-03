package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class b
  implements Parcelable.Creator<ParcelableEventList>
{
  static void a(ParcelableEventList paramParcelableEventList, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramParcelableEventList.xJ);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramParcelableEventList.Ly, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramParcelableEventList.Lz, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 4, paramParcelableEventList.LA);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 5, paramParcelableEventList.LB, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public ParcelableEventList aU(Parcel paramParcel)
  {
    boolean bool = false;
    ParcelableObjectChangedEvent[] arrayOfParcelableObjectChangedEvent = null;
    int j = a.B(paramParcel);
    DataHolder localDataHolder = null;
    ParcelableEvent[] arrayOfParcelableEvent = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        arrayOfParcelableEvent = (ParcelableEvent[])a.b(paramParcel, k, ParcelableEvent.CREATOR);
        break;
      case 3: 
        localDataHolder = (DataHolder)a.a(paramParcel, k, DataHolder.CREATOR);
        break;
      case 4: 
        bool = a.c(paramParcel, k);
        break;
      case 5: 
        arrayOfParcelableObjectChangedEvent = (ParcelableObjectChangedEvent[])a.b(paramParcel, k, ParcelableObjectChangedEvent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ParcelableEventList(i, arrayOfParcelableEvent, localDataHolder, bool, arrayOfParcelableObjectChangedEvent);
  }
  
  public ParcelableEventList[] bR(int paramInt)
  {
    return new ParcelableEventList[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */