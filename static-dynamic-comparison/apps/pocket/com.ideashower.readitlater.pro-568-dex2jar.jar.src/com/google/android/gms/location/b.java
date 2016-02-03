package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
  implements Parcelable.Creator
{
  static void a(DetectedActivity paramDetectedActivity, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramDetectedActivity.a);
    c.a(paramParcel, 1000, paramDetectedActivity.b());
    c.a(paramParcel, 2, paramDetectedActivity.b);
    c.a(paramParcel, paramInt);
  }
  
  public DetectedActivity a(Parcel paramParcel)
  {
    int k = 0;
    int m = a.b(paramParcel);
    int j = 0;
    int i = 0;
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
        i = a.f(paramParcel, n);
        break;
      case 2: 
        k = a.f(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + m, paramParcel);
    }
    return new DetectedActivity(i, j, k);
  }
  
  public DetectedActivity[] a(int paramInt)
  {
    return new DetectedActivity[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/location/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */