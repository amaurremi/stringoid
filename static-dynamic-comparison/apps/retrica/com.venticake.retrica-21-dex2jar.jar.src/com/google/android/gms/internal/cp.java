package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class cp
  implements Parcelable.Creator<cq>
{
  static void a(cq paramcq, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramcq.versionCode);
    b.a(paramParcel, 2, paramcq.bd(), false);
    b.a(paramParcel, 3, paramcq.be(), false);
    b.a(paramParcel, 4, paramcq.bf(), false);
    b.a(paramParcel, 5, paramcq.bg(), false);
    b.G(paramParcel, paramInt);
  }
  
  public cq g(Parcel paramParcel)
  {
    IBinder localIBinder1 = null;
    int j = a.B(paramParcel);
    int i = 0;
    IBinder localIBinder2 = null;
    IBinder localIBinder3 = null;
    IBinder localIBinder4 = null;
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
        localIBinder4 = a.p(paramParcel, k);
        break;
      case 3: 
        localIBinder3 = a.p(paramParcel, k);
        break;
      case 4: 
        localIBinder2 = a.p(paramParcel, k);
        break;
      case 5: 
        localIBinder1 = a.p(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new cq(i, localIBinder4, localIBinder3, localIBinder2, localIBinder1);
  }
  
  public cq[] k(int paramInt)
  {
    return new cq[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */