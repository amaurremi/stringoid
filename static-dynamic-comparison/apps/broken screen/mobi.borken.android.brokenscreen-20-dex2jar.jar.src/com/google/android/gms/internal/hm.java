package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class hm
  implements Parcelable.Creator<gz.a>
{
  static void a(gz.a parama, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.a(paramParcel, 1, parama.getAccountName(), false);
    b.c(paramParcel, 1000, parama.getVersionCode());
    b.a(paramParcel, 2, parama.fg(), false);
    b.c(paramParcel, 3, parama.ff());
    b.a(paramParcel, 4, parama.fi(), false);
    b.G(paramParcel, paramInt);
  }
  
  public gz.a[] aq(int paramInt)
  {
    return new gz.a[paramInt];
  }
  
  public gz.a z(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = a.B(paramParcel);
    ArrayList localArrayList = null;
    String str2 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        str2 = a.o(paramParcel, m);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        localArrayList = a.B(paramParcel, m);
        break;
      case 3: 
        i = a.g(paramParcel, m);
        break;
      case 4: 
        str1 = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new gz.a(j, str2, localArrayList, i, str1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/hm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */