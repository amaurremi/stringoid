package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hz
  implements Parcelable.Creator<hy.a>
{
  static void a(hy.a parama, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, parama.getVersionCode());
    b.c(paramParcel, 2, parama.fE());
    b.a(paramParcel, 3, parama.fK());
    b.c(paramParcel, 4, parama.fF());
    b.a(paramParcel, 5, parama.fL());
    b.a(paramParcel, 6, parama.fM(), false);
    b.c(paramParcel, 7, parama.fN());
    b.a(paramParcel, 8, parama.fP(), false);
    b.a(paramParcel, 9, parama.fR(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public hy.a H(Parcel paramParcel)
  {
    ht localht = null;
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
        localht = (ht)a.a(paramParcel, i1, ht.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new a.a("Overread allowed size end=" + n, paramParcel);
    }
    return new hy.a(m, k, bool2, j, bool1, str2, i, str1, localht);
  }
  
  public hy.a[] aw(int paramInt)
  {
    return new hy.a[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */