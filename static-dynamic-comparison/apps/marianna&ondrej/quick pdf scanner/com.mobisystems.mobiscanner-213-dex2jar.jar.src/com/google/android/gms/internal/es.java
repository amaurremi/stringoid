package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class es
  implements Parcelable.Creator<hn>
{
  static void a(hn paramhn, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.b(paramParcel, 1, paramhn.Nc, false);
    b.c(paramParcel, 1000, paramhn.qh);
    b.a(paramParcel, 2, paramhn.rn(), false);
    b.a(paramParcel, 3, paramhn.ro());
    b.D(paramParcel, paramInt);
  }
  
  public hn aD(Parcel paramParcel)
  {
    String str = null;
    boolean bool = false;
    int j = a.j(paramParcel);
    ArrayList localArrayList = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList = a.c(paramParcel, k, ht.PH);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str = a.m(paramParcel, k);
        break;
      case 3: 
        bool = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new hn(i, localArrayList, str, bool);
  }
  
  public hn[] cW(int paramInt)
  {
    return new hn[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/es.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */