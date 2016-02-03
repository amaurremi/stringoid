package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class jw
  implements Parcelable.Creator<jv>
{
  static void a(jv paramjv, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramjv.getName(), false);
    b.c(paramParcel, 1000, paramjv.xJ);
    b.a(paramParcel, 2, paramjv.jf(), paramInt, false);
    b.a(paramParcel, 3, paramjv.getAddress(), false);
    b.b(paramParcel, 4, paramjv.jg(), false);
    b.a(paramParcel, 5, paramjv.getPhoneNumber(), false);
    b.a(paramParcel, 6, paramjv.jh(), false);
    b.G(paramParcel, i);
  }
  
  public jv bz(Parcel paramParcel)
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
        localArrayList = a.c(paramParcel, k, jt.CREATOR);
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
    return new jv(i, str4, localLatLng, str3, localArrayList, str2, str1);
  }
  
  public jv[] cU(int paramInt)
  {
    return new jv[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/jw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */