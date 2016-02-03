package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class nw
  implements Parcelable.Creator<nv>
{
  static void a(nv paramnv, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    Set localSet = paramnv.alR;
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramnv.BR);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramnv.BL, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, paramnv.amM, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, paramnv.amE, true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.a(paramParcel, 6, paramnv.amN, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      b.a(paramParcel, 7, paramnv.uO, true);
    }
    b.H(paramParcel, i);
  }
  
  public nv dc(Parcel paramParcel)
  {
    String str1 = null;
    int j = a.C(paramParcel);
    HashSet localHashSet = new HashSet();
    int i = 0;
    nt localnt1 = null;
    String str2 = null;
    nt localnt2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      case 3: 
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        str3 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 4: 
        localnt2 = (nt)a.a(paramParcel, k, nt.CREATOR);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str2 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        localnt1 = (nt)a.a(paramParcel, k, nt.CREATOR);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7: 
        str1 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(7));
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new nv(localHashSet, i, str3, localnt2, str2, localnt1, str1);
  }
  
  public nv[] eT(int paramInt)
  {
    return new nv[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/nw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */