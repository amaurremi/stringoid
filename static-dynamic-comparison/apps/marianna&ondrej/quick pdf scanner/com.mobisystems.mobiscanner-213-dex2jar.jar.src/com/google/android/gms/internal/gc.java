package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class gc
  implements Parcelable.Creator<jr>
{
  static void a(jr paramjr, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.c(paramParcel, 1, paramjr.lX());
    b.a(paramParcel, 2, paramjr.SM);
    b.a(paramParcel, 3, paramjr.SN);
    b.D(paramParcel, paramInt);
  }
  
  public jr bc(Parcel paramParcel)
  {
    long l1 = 0L;
    int j = a.j(paramParcel);
    int i = 0;
    long l2 = 0L;
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
        l2 = a.h(paramParcel, k);
        break;
      case 3: 
        l1 = a.h(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new jr(i, l2, l1);
  }
  
  public jr[] dw(int paramInt)
  {
    return new jr[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/gc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */