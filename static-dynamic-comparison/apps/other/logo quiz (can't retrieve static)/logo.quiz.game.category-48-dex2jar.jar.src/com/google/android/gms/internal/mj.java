package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class mj
  implements Parcelable.Creator<mi>
{
  static void a(mi parammi, Parcel paramParcel, int paramInt)
  {
    paramInt = b.D(paramParcel);
    b.c(paramParcel, 1, parammi.afg, false);
    b.c(paramParcel, 1000, parammi.BR);
    b.a(paramParcel, 2, parammi.mg(), false);
    b.a(paramParcel, 3, parammi.mh());
    b.c(paramParcel, 4, parammi.afj, false);
    b.b(paramParcel, 6, parammi.afk, false);
    b.H(paramParcel, paramInt);
  }
  
  public mi cz(Parcel paramParcel)
  {
    boolean bool = false;
    ArrayList localArrayList1 = null;
    int j = a.C(paramParcel);
    ArrayList localArrayList2 = null;
    String str = null;
    ArrayList localArrayList3 = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList3 = a.c(paramParcel, k, mo.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str = a.o(paramParcel, k);
        break;
      case 3: 
        bool = a.c(paramParcel, k);
        break;
      case 4: 
        localArrayList2 = a.c(paramParcel, k, ms.CREATOR);
        break;
      case 6: 
        localArrayList1 = a.C(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new mi(i, localArrayList3, str, bool, localArrayList2, localArrayList1);
  }
  
  public mi[] eo(int paramInt)
  {
    return new mi[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/mj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */