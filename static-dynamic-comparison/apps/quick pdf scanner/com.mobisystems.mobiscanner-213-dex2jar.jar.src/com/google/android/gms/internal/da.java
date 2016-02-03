package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class da
  implements Parcelable.Creator<ee.a>
{
  static void a(ee.a parama, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.a(paramParcel, 1, parama.qk(), false);
    b.c(paramParcel, 1000, parama.lX());
    b.a(paramParcel, 2, parama.qj(), false);
    b.c(paramParcel, 3, parama.ql());
    b.a(paramParcel, 4, parama.qm(), false);
    b.D(paramParcel, paramInt);
  }
  
  public ee.a ar(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = a.j(paramParcel);
    ArrayList localArrayList = null;
    String str2 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.i(paramParcel);
      switch (a.br(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        str2 = a.m(paramParcel, m);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        localArrayList = a.y(paramParcel, m);
        break;
      case 3: 
        i = a.g(paramParcel, m);
        break;
      case 4: 
        str1 = a.m(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new ee.a(j, str2, localArrayList, i, str1);
  }
  
  public ee.a[] cG(int paramInt)
  {
    return new ee.a[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */