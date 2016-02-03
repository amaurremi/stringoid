package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ga
  implements Parcelable.Creator<jl>
{
  static void a(jl paramjl, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramjl.lX());
    b.a(paramParcel, 2, paramjl.label, false);
    b.a(paramParcel, 3, paramjl.SD, paramInt, false);
    b.a(paramParcel, 4, paramjl.type, false);
    b.a(paramParcel, 5, paramjl.SE, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public jl ba(Parcel paramParcel)
  {
    jr localjr = null;
    int j = a.j(paramParcel);
    int i = 0;
    String str1 = null;
    jm localjm = null;
    String str2 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str2 = a.m(paramParcel, k);
        break;
      case 3: 
        localjm = (jm)a.a(paramParcel, k, jm.CREATOR);
        break;
      case 4: 
        str1 = a.m(paramParcel, k);
        break;
      case 5: 
        localjr = (jr)a.a(paramParcel, k, jr.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new jl(i, str2, localjm, str1, localjr);
  }
  
  public jl[] du(int paramInt)
  {
    return new jl[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */