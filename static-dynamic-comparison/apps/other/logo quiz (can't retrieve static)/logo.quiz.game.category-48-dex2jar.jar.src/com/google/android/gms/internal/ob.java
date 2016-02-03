package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class ob
  implements Parcelable.Creator<ny.b>
{
  static void a(ny.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    Set localSet = paramb.alR;
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramb.BR);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramb.ank, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramb.anl, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.c(paramParcel, 4, paramb.anm);
    }
    b.H(paramParcel, i);
  }
  
  public ny.b df(Parcel paramParcel)
  {
    ny.b.b localb = null;
    int i = 0;
    int k = a.C(paramParcel);
    HashSet localHashSet = new HashSet();
    ny.b.a locala = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.B(paramParcel);
      switch (a.aD(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        locala = (ny.b.a)a.a(paramParcel, m, ny.b.a.CREATOR);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        localb = (ny.b.b)a.a(paramParcel, m, ny.b.b.CREATOR);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        i = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(4));
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new ny.b(localHashSet, j, locala, localb, i);
  }
  
  public ny.b[] eW(int paramInt)
  {
    return new ny.b[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */