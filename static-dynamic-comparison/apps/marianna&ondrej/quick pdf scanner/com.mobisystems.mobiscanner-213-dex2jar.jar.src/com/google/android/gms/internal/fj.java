package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fj
  implements Parcelable.Creator<id>
{
  static void a(id paramid, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.a(paramParcel, 1, paramid.Qu, false);
    b.c(paramParcel, 1000, paramid.versionCode);
    b.a(paramParcel, 2, paramid.Qv, false);
    b.D(paramParcel, paramInt);
  }
  
  public id aK(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.j(paramParcel);
    int i = 0;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str1 = a.m(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str2 = a.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new id(i, str1, str2);
  }
  
  public id[] de(int paramInt)
  {
    return new id[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/fj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */