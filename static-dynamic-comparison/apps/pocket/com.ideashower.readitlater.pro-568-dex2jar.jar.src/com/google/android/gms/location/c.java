package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator
{
  static void a(LocationRequest paramLocationRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramLocationRequest.a);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1000, paramLocationRequest.a());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramLocationRequest.b);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramLocationRequest.c);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 4, paramLocationRequest.d);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 5, paramLocationRequest.e);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 6, paramLocationRequest.f);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 7, paramLocationRequest.g);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, paramInt);
  }
  
  public LocationRequest a(Parcel paramParcel)
  {
    boolean bool = false;
    int m = a.b(paramParcel);
    int j = 102;
    long l3 = 3600000L;
    long l2 = 600000L;
    long l1 = Long.MAX_VALUE;
    int i = Integer.MAX_VALUE;
    float f = 0.0F;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        j = a.f(paramParcel, n);
        break;
      case 1000: 
        k = a.f(paramParcel, n);
        break;
      case 2: 
        l3 = a.g(paramParcel, n);
        break;
      case 3: 
        l2 = a.g(paramParcel, n);
        break;
      case 4: 
        bool = a.c(paramParcel, n);
        break;
      case 5: 
        l1 = a.g(paramParcel, n);
        break;
      case 6: 
        i = a.f(paramParcel, n);
        break;
      case 7: 
        f = a.i(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new b("Overread allowed size end=" + m, paramParcel);
    }
    return new LocationRequest(k, j, l3, l2, bool, l1, i, f);
  }
  
  public LocationRequest[] a(int paramInt)
  {
    return new LocationRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/location/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */