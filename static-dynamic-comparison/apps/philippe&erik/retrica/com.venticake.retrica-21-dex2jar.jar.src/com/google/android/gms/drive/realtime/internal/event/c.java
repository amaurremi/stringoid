package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<ParcelableObjectChangedEvent>
{
  static void a(ParcelableObjectChangedEvent paramParcelableObjectChangedEvent, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramParcelableObjectChangedEvent.xM);
    b.a(paramParcel, 2, paramParcelableObjectChangedEvent.rR, false);
    b.a(paramParcel, 3, paramParcelableObjectChangedEvent.Lm, false);
    b.a(paramParcel, 4, paramParcelableObjectChangedEvent.Ls);
    b.a(paramParcel, 5, paramParcelableObjectChangedEvent.Lq, false);
    b.a(paramParcel, 6, paramParcelableObjectChangedEvent.Lt, false);
    b.c(paramParcel, 7, paramParcelableObjectChangedEvent.LF);
    b.c(paramParcel, 8, paramParcelableObjectChangedEvent.LG);
    b.G(paramParcel, paramInt);
  }
  
  public ParcelableObjectChangedEvent aV(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int m = a.B(paramParcel);
    int j = 0;
    String str2 = null;
    boolean bool = false;
    String str3 = null;
    String str4 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.A(paramParcel);
      switch (a.ar(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        str4 = a.o(paramParcel, n);
        break;
      case 3: 
        str3 = a.o(paramParcel, n);
        break;
      case 4: 
        bool = a.c(paramParcel, n);
        break;
      case 5: 
        str2 = a.o(paramParcel, n);
        break;
      case 6: 
        str1 = a.o(paramParcel, n);
        break;
      case 7: 
        j = a.g(paramParcel, n);
        break;
      case 8: 
        i = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new ParcelableObjectChangedEvent(k, str4, str3, bool, str2, str1, j, i);
  }
  
  public ParcelableObjectChangedEvent[] bS(int paramInt)
  {
    return new ParcelableObjectChangedEvent[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */