package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ar
  implements Parcelable.Creator<bq>
{
  static void a(bq parambq, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, parambq.versionCode);
    b.a(paramParcel, 2, parambq.CN, paramInt, false);
    b.a(paramParcel, 3, parambq.pn(), false);
    b.a(paramParcel, 4, parambq.po(), false);
    b.a(paramParcel, 5, parambq.pp(), false);
    b.a(paramParcel, 6, parambq.pq(), false);
    b.a(paramParcel, 7, parambq.CT, false);
    b.a(paramParcel, 8, parambq.CU);
    b.a(paramParcel, 9, parambq.CV, false);
    b.a(paramParcel, 10, parambq.pr(), false);
    b.c(paramParcel, 11, parambq.orientation);
    b.c(paramParcel, 12, parambq.CX);
    b.a(paramParcel, 13, parambq.Cu, false);
    b.a(paramParcel, 14, parambq.CY, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public bq am(Parcel paramParcel)
  {
    int m = a.j(paramParcel);
    int k = 0;
    bn localbn = null;
    IBinder localIBinder5 = null;
    IBinder localIBinder4 = null;
    IBinder localIBinder3 = null;
    IBinder localIBinder2 = null;
    String str3 = null;
    boolean bool = false;
    String str2 = null;
    IBinder localIBinder1 = null;
    int j = 0;
    int i = 0;
    String str1 = null;
    db localdb = null;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.i(paramParcel);
      switch (a.br(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        localbn = (bn)a.a(paramParcel, n, bn.Cs);
        break;
      case 3: 
        localIBinder5 = a.n(paramParcel, n);
        break;
      case 4: 
        localIBinder4 = a.n(paramParcel, n);
        break;
      case 5: 
        localIBinder3 = a.n(paramParcel, n);
        break;
      case 6: 
        localIBinder2 = a.n(paramParcel, n);
        break;
      case 7: 
        str3 = a.m(paramParcel, n);
        break;
      case 8: 
        bool = a.c(paramParcel, n);
        break;
      case 9: 
        str2 = a.m(paramParcel, n);
        break;
      case 10: 
        localIBinder1 = a.n(paramParcel, n);
        break;
      case 11: 
        j = a.g(paramParcel, n);
        break;
      case 12: 
        i = a.g(paramParcel, n);
        break;
      case 13: 
        str1 = a.m(paramParcel, n);
        break;
      case 14: 
        localdb = (db)a.a(paramParcel, n, db.FJ);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new bq(k, localbn, localIBinder5, localIBinder4, localIBinder3, localIBinder2, str3, bool, str2, localIBinder1, j, i, str1, localdb);
  }
  
  public bq[] cx(int paramInt)
  {
    return new bq[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */