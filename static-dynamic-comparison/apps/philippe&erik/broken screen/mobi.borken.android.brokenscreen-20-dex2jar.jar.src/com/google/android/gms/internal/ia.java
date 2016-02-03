package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ia
  implements Parcelable.Creator<hz.a>
{
  static void a(hz.a parama, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, parama.getVersionCode());
    b.c(paramParcel, 2, parama.fz());
    b.a(paramParcel, 3, parama.fF());
    b.c(paramParcel, 4, parama.fA());
    b.a(paramParcel, 5, parama.fG());
    b.a(paramParcel, 6, parama.fH(), false);
    b.c(paramParcel, 7, parama.fI());
    b.a(paramParcel, 8, parama.fK(), false);
    b.a(paramParcel, 9, parama.fM(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public hz.a H(Parcel paramParcel)
  {
    hu localhu = null;
    int i = 0;
    int n = a.B(paramParcel);
    String str1 = null;
    String str2 = null;
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = false;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = a.A(paramParcel);
      switch (a.ar(i1))
      {
      default: 
        a.b(paramParcel, i1);
        break;
      case 1: 
        m = a.g(paramParcel, i1);
        break;
      case 2: 
        k = a.g(paramParcel, i1);
        break;
      case 3: 
        bool2 = a.c(paramParcel, i1);
        break;
      case 4: 
        j = a.g(paramParcel, i1);
        break;
      case 5: 
        bool1 = a.c(paramParcel, i1);
        break;
      case 6: 
        str2 = a.o(paramParcel, i1);
        break;
      case 7: 
        i = a.g(paramParcel, i1);
        break;
      case 8: 
        str1 = a.o(paramParcel, i1);
        break;
      case 9: 
        localhu = (hu)a.a(paramParcel, i1, hu.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new a.a("Overread allowed size end=" + n, paramParcel);
    }
    return new hz.a(m, k, bool2, j, bool1, str2, i, str1, localhu);
  }
  
  public hz.a[] aw(int paramInt)
  {
    return new hz.a[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */