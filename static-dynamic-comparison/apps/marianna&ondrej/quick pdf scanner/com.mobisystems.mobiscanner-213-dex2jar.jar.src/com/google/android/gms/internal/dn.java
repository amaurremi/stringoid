package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class dn
  implements Parcelable.Creator<fe.b>
{
  static void a(fe.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramb.versionCode);
    b.a(paramParcel, 2, paramb.LW, false);
    b.a(paramParcel, 3, paramb.LX, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public fe.b aw(Parcel paramParcel)
  {
    fb.a locala = null;
    int j = a.j(paramParcel);
    int i = 0;
    String str = null;
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
        str = a.m(paramParcel, k);
        break;
      case 3: 
        locala = (fb.a)a.a(paramParcel, k, fb.a.LN);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new fe.b(i, str, locala);
  }
  
  public fe.b[] cL(int paramInt)
  {
    return new fe.b[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */