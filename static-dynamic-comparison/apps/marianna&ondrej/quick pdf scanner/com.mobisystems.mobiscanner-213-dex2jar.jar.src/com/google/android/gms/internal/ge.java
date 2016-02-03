package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ge
  implements Parcelable.Creator<jv>
{
  static void a(jv paramjv, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramjv.lX());
    b.a(paramParcel, 2, paramjv.SL, false);
    b.a(paramParcel, 3, paramjv.DL, false);
    b.a(paramParcel, 4, paramjv.SP, paramInt, false);
    b.a(paramParcel, 5, paramjv.SQ, paramInt, false);
    b.a(paramParcel, 6, paramjv.SR, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public jv be(Parcel paramParcel)
  {
    jt localjt1 = null;
    int j = a.j(paramParcel);
    int i = 0;
    jt localjt2 = null;
    jr localjr = null;
    String str1 = null;
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
        str1 = a.m(paramParcel, k);
        break;
      case 4: 
        localjr = (jr)a.a(paramParcel, k, jr.CREATOR);
        break;
      case 5: 
        localjt2 = (jt)a.a(paramParcel, k, jt.CREATOR);
        break;
      case 6: 
        localjt1 = (jt)a.a(paramParcel, k, jt.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new jv(i, str2, str1, localjr, localjt2, localjt1);
  }
  
  public jv[] dy(int paramInt)
  {
    return new jv[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */