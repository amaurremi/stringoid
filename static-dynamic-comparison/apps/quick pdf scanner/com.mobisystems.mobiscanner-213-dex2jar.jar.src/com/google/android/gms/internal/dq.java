package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class dq
  implements Parcelable.Creator<fh>
{
  static void a(fh paramfh, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramfh.lX());
    b.a(paramParcel, 2, paramfh.qU(), false);
    b.a(paramParcel, 3, paramfh.qV(), paramInt, false);
    b.D(paramParcel, i);
  }
  
  public fh az(Parcel paramParcel)
  {
    fe localfe = null;
    int j = a.j(paramParcel);
    int i = 0;
    Parcel localParcel = null;
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
        localParcel = a.z(paramParcel, k);
        break;
      case 3: 
        localfe = (fe)a.a(paramParcel, k, fe.LO);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new fh(i, localParcel, localfe);
  }
  
  public fh[] cO(int paramInt)
  {
    return new fh[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */