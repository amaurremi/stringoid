package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e
  implements Parcelable.Creator<LocationRequest>
{
  static void a(LocationRequest paramLocationRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.c(paramParcel, 1, paramLocationRequest.mPriority);
    b.c(paramParcel, 1000, paramLocationRequest.lX());
    b.a(paramParcel, 2, paramLocationRequest.Uc);
    b.a(paramParcel, 3, paramLocationRequest.Ud);
    b.a(paramParcel, 4, paramLocationRequest.Ue);
    b.a(paramParcel, 5, paramLocationRequest.Uf);
    b.c(paramParcel, 6, paramLocationRequest.Ug);
    b.a(paramParcel, 7, paramLocationRequest.Uh);
    b.D(paramParcel, paramInt);
  }
  
  public LocationRequest bh(Parcel paramParcel)
  {
    boolean bool = false;
    int m = a.j(paramParcel);
    int j = 102;
    long l3 = 3600000L;
    long l2 = 600000L;
    long l1 = Long.MAX_VALUE;
    int i = Integer.MAX_VALUE;
    float f = 0.0F;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.i(paramParcel);
      switch (a.br(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        j = a.g(paramParcel, n);
        break;
      case 1000: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        l3 = a.h(paramParcel, n);
        break;
      case 3: 
        l2 = a.h(paramParcel, n);
        break;
      case 4: 
        bool = a.c(paramParcel, n);
        break;
      case 5: 
        l1 = a.h(paramParcel, n);
        break;
      case 6: 
        i = a.g(paramParcel, n);
        break;
      case 7: 
        f = a.j(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new LocationRequest(k, j, l3, l2, bool, l1, i, f);
  }
  
  public LocationRequest[] dM(int paramInt)
  {
    return new LocationRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/location/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */