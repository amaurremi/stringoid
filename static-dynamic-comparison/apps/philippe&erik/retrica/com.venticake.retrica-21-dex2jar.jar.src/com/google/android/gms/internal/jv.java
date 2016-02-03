package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class jv
  implements Parcelable.Creator<ju>
{
  static void a(ju paramju, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramju.getName(), false);
    b.c(paramParcel, 1000, paramju.xM);
    b.a(paramParcel, 2, paramju.jk(), paramInt, false);
    b.a(paramParcel, 3, paramju.getAddress(), false);
    b.b(paramParcel, 4, paramju.jl(), false);
    b.a(paramParcel, 5, paramju.getPhoneNumber(), false);
    b.a(paramParcel, 6, paramju.jm(), false);
    b.G(paramParcel, i);
  }
  
  public ju bz(Parcel paramParcel)
  {
    String str1 = null;
    int j = a.B(paramParcel);
    int i = 0;
    String str2 = null;
    ArrayList localArrayList = null;
    String str3 = null;
    LatLng localLatLng = null;
    String str4 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str4 = a.o(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localLatLng = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 3: 
        str3 = a.o(paramParcel, k);
        break;
      case 4: 
        localArrayList = a.c(paramParcel, k, js.CREATOR);
        break;
      case 5: 
        str2 = a.o(paramParcel, k);
        break;
      case 6: 
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ju(i, str4, localLatLng, str3, localArrayList, str2, str1);
  }
  
  public ju[] cU(int paramInt)
  {
    return new ju[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */