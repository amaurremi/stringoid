package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.LocationRequest;

public class ev
  implements Parcelable.Creator<hr>
{
  static void a(hr paramhr, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.a(paramParcel, 1, paramhr.rq(), paramInt, false);
    b.c(paramParcel, 1000, paramhr.qh);
    b.a(paramParcel, 2, paramhr.rr(), paramInt, false);
    b.D(paramParcel, i);
  }
  
  public hr aF(Parcel paramParcel)
  {
    hn localhn = null;
    int j = a.j(paramParcel);
    int i = 0;
    LocationRequest localLocationRequest = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
      }
      for (;;)
      {
        break;
        localLocationRequest = (LocationRequest)a.a(paramParcel, k, LocationRequest.Ui);
        continue;
        i = a.g(paramParcel, k);
        continue;
        localhn = (hn)a.a(paramParcel, k, hn.Nb);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new hr(i, localLocationRequest, localhn);
  }
  
  public hr[] cY(int paramInt)
  {
    return new hr[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */