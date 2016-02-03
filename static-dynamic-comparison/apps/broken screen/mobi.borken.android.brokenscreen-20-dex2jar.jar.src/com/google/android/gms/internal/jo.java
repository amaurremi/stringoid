package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class jo
  implements Parcelable.Creator<jn>
{
  static void a(jn paramjn, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.b(paramParcel, 1, paramjn.VZ, false);
    b.c(paramParcel, 1000, paramjn.xJ);
    b.a(paramParcel, 2, paramjn.jb(), false);
    b.a(paramParcel, 3, paramjn.jc());
    b.b(paramParcel, 4, paramjn.Wc, false);
    b.a(paramParcel, 5, paramjn.jd(), false);
    b.a(paramParcel, 6, paramjn.We, false);
    b.G(paramParcel, paramInt);
  }
  
  public jn bv(Parcel paramParcel)
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
        localArrayList3 = a.c(paramParcel, k, jt.CREATOR);
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
        localArrayList2 = a.c(paramParcel, k, jx.CREATOR);
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
    return new jn(i, localArrayList3, str2, bool, localArrayList2, str1, localArrayList1);
  }
  
  public jn[] cQ(int paramInt)
  {
    return new jn[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/jo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */