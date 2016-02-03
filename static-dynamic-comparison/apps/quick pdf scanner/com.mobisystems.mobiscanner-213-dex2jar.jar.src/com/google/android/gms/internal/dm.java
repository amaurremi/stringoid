package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class dm
  implements Parcelable.Creator<fb.a>
{
  static void a(fb.a parama, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, parama.lX());
    b.c(paramParcel, 2, parama.qC());
    b.a(paramParcel, 3, parama.qH());
    b.c(paramParcel, 4, parama.qD());
    b.a(paramParcel, 5, parama.qI());
    b.a(paramParcel, 6, parama.qJ(), false);
    b.c(paramParcel, 7, parama.qK());
    b.a(paramParcel, 8, parama.qM(), false);
    b.a(paramParcel, 9, parama.qO(), paramInt, false);
    b.D(paramParcel, i);
  }
  
  public fb.a av(Parcel paramParcel)
  {
    ew localew = null;
    int i = 0;
    int n = a.j(paramParcel);
    String str1 = null;
    String str2 = null;
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = false;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = a.i(paramParcel);
      switch (a.br(i1))
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
        str2 = a.m(paramParcel, i1);
        break;
      case 7: 
        i = a.g(paramParcel, i1);
        break;
      case 8: 
        str1 = a.m(paramParcel, i1);
        break;
      case 9: 
        localew = (ew)a.a(paramParcel, i1, ew.HG);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new a.a("Overread allowed size end=" + n, paramParcel);
    }
    return new fb.a(m, k, bool2, j, bool1, str2, i, str1, localew);
  }
  
  public fb.a[] cK(int paramInt)
  {
    return new fb.a[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */