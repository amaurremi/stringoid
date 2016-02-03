package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d
  implements Parcelable.Creator<c>
{
  static void a(c paramc, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramc.xM);
    b.a(paramParcel, 2, paramc.getName(), false);
    b.a(paramParcel, 3, paramc.getAddress(), false);
    b.c(paramParcel, 4, paramc.getType());
    b.c(paramParcel, 5, paramc.getRole());
    b.a(paramParcel, 6, paramc.isEnabled());
    b.G(paramParcel, paramInt);
  }
  
  public c ct(Parcel paramParcel)
  {
    String str1 = null;
    boolean bool = false;
    int m = a.B(paramParcel);
    int i = 0;
    int j = 0;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.A(paramParcel);
      switch (a.ar(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        str2 = a.o(paramParcel, n);
        break;
      case 3: 
        str1 = a.o(paramParcel, n);
        break;
      case 4: 
        j = a.g(paramParcel, n);
        break;
      case 5: 
        i = a.g(paramParcel, n);
        break;
      case 6: 
        bool = a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new c(k, str2, str1, j, i, bool);
  }
  
  public c[] eb(int paramInt)
  {
    return new c[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */