package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g
  implements Parcelable.Creator<f>
{
  static void a(f paramf, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.a(paramParcel, 1, paramf.dB(), paramInt, false);
    b.c(paramParcel, 1000, paramf.getVersionCode());
    b.a(paramParcel, 2, paramf.dC(), false);
    b.D(paramParcel, i);
  }
  
  public f[] aT(int paramInt)
  {
    return new f[paramInt];
  }
  
  public f ag(Parcel paramParcel)
  {
    String str = null;
    int j = a.n(paramParcel);
    int i = 0;
    PendingIntent localPendingIntent = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
      }
      for (;;)
      {
        break;
        localPendingIntent = (PendingIntent)a.a(paramParcel, k, PendingIntent.CREATOR);
        continue;
        i = a.g(paramParcel, k);
        continue;
        str = a.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new f(i, localPendingIntent, str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/location/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */