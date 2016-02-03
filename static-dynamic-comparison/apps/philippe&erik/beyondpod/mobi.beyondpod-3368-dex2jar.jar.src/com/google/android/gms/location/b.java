package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class b
  implements Parcelable.Creator<a>
{
  static void a(a parama, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.o(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 1, parama.dB(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1000, parama.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.b.D(paramParcel, i);
  }
  
  public a[] aN(int paramInt)
  {
    return new a[paramInt];
  }
  
  public a ae(Parcel paramParcel)
  {
    int j = com.google.android.gms.common.internal.safeparcel.a.n(paramParcel);
    int i = 0;
    PendingIntent localPendingIntent = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.M(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1: 
        localPendingIntent = (PendingIntent)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, PendingIntent.CREATOR);
        break;
      case 1000: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new a(i, localPendingIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/location/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */