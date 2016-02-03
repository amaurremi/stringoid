package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class dp
  implements Parcelable.Creator<fe.a>
{
  static void a(fe.a parama, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.c(paramParcel, 1, parama.versionCode);
    b.a(paramParcel, 2, parama.className, false);
    b.b(paramParcel, 3, parama.LT, false);
    b.D(paramParcel, paramInt);
  }
  
  public fe.a ay(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
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
        localArrayList = a.c(paramParcel, k, fe.b.LV);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new fe.a(i, str, localArrayList);
  }
  
  public fe.a[] cN(int paramInt)
  {
    return new fe.a[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */