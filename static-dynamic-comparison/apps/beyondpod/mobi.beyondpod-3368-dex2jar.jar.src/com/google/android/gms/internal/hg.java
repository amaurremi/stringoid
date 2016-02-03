package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class hg
  implements Parcelable.Creator<hf>
{
  static void a(hf paramhf, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    b.a(paramParcel, 1, paramhf.name, false);
    b.c(paramParcel, 1000, paramhf.versionCode);
    b.a(paramParcel, 2, paramhf.Bf, false);
    b.a(paramParcel, 3, paramhf.Bg, false);
    b.a(paramParcel, 4, paramhf.Bh, false);
    b.a(paramParcel, 5, paramhf.Bi, false);
    b.D(paramParcel, paramInt);
  }
  
  public hf ap(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = a.n(paramParcel);
    int i = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str4 = a.m(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str3 = a.m(paramParcel, k);
        break;
      case 3: 
        str2 = a.m(paramParcel, k);
        break;
      case 4: 
        str1 = a.m(paramParcel, k);
        break;
      case 5: 
        localArrayList = a.y(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new hf(i, str4, str3, str2, str1, localArrayList);
  }
  
  public hf[] bf(int paramInt)
  {
    return new hf[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */