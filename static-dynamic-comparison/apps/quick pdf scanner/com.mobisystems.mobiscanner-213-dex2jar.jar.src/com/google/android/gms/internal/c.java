package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<ab>
{
  static void a(ab paramab, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramab.versionCode);
    b.a(paramParcel, 2, paramab.wZ, false);
    b.c(paramParcel, 3, paramab.height);
    b.c(paramParcel, 4, paramab.heightPixels);
    b.a(paramParcel, 5, paramab.xa);
    b.c(paramParcel, 6, paramab.width);
    b.c(paramParcel, 7, paramab.widthPixels);
    b.a(paramParcel, 8, paramab.xb, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public ab aj(Parcel paramParcel)
  {
    ab[] arrayOfab = null;
    int i = 0;
    int i1 = a.j(paramParcel);
    int j = 0;
    boolean bool = false;
    int k = 0;
    int m = 0;
    String str = null;
    int n = 0;
    while (paramParcel.dataPosition() < i1)
    {
      int i2 = a.i(paramParcel);
      switch (a.br(i2))
      {
      default: 
        a.b(paramParcel, i2);
        break;
      case 1: 
        n = a.g(paramParcel, i2);
        break;
      case 2: 
        str = a.m(paramParcel, i2);
        break;
      case 3: 
        m = a.g(paramParcel, i2);
        break;
      case 4: 
        k = a.g(paramParcel, i2);
        break;
      case 5: 
        bool = a.c(paramParcel, i2);
        break;
      case 6: 
        j = a.g(paramParcel, i2);
        break;
      case 7: 
        i = a.g(paramParcel, i2);
        break;
      case 8: 
        arrayOfab = (ab[])a.b(paramParcel, i2, ab.wY);
      }
    }
    if (paramParcel.dataPosition() != i1) {
      throw new a.a("Overread allowed size end=" + i1, paramParcel);
    }
    return new ab(n, str, m, k, bool, j, i, arrayOfab);
  }
  
  public ab[] cs(int paramInt)
  {
    return new ab[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */