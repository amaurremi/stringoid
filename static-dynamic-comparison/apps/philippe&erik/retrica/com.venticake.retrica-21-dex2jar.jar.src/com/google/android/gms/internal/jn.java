package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class jn
  implements Parcelable.Creator<jm>
{
  static void a(jm paramjm, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.b(paramParcel, 1, paramjm.Wc, false);
    b.c(paramParcel, 1000, paramjm.xM);
    b.a(paramParcel, 2, paramjm.jg(), false);
    b.a(paramParcel, 3, paramjm.jh());
    b.b(paramParcel, 4, paramjm.Wf, false);
    b.a(paramParcel, 5, paramjm.ji(), false);
    b.a(paramParcel, 6, paramjm.Wh, false);
    b.G(paramParcel, paramInt);
  }
  
  public jm bv(Parcel paramParcel)
  {
    boolean bool = false;
    ArrayList localArrayList1 = null;
    int j = a.B(paramParcel);
    String str1 = null;
    ArrayList localArrayList2 = null;
    String str2 = null;
    ArrayList localArrayList3 = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList3 = a.c(paramParcel, k, js.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str2 = a.o(paramParcel, k);
        break;
      case 3: 
        bool = a.c(paramParcel, k);
        break;
      case 4: 
        localArrayList2 = a.c(paramParcel, k, jw.CREATOR);
        break;
      case 5: 
        str1 = a.o(paramParcel, k);
        break;
      case 6: 
        localArrayList1 = a.B(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new jm(i, localArrayList3, str2, bool, localArrayList2, str1, localArrayList1);
  }
  
  public jm[] cQ(int paramInt)
  {
    return new jm[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */