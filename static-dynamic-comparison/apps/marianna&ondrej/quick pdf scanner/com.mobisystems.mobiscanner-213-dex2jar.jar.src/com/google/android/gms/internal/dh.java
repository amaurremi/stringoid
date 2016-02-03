package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class dh
  implements Parcelable.Creator<ew>
{
  static void a(ew paramew, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramew.lX());
    b.a(paramParcel, 2, paramew.qz(), paramInt, false);
    b.D(paramParcel, i);
  }
  
  public ew as(Parcel paramParcel)
  {
    int j = a.j(paramParcel);
    int i = 0;
    ey localey = null;
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
        localey = (ey)a.a(paramParcel, k, ey.HI);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ew(i, localey);
  }
  
  public ew[] cH(int paramInt)
  {
    return new ew[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */