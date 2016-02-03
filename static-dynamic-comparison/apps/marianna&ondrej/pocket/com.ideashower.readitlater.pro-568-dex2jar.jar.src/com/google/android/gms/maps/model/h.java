package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class h
  implements Parcelable.Creator
{
  static void a(PolygonOptions paramPolygonOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramPolygonOptions.a());
    c.b(paramParcel, 2, paramPolygonOptions.c(), false);
    c.c(paramParcel, 3, paramPolygonOptions.b(), false);
    c.a(paramParcel, 4, paramPolygonOptions.d());
    c.a(paramParcel, 5, paramPolygonOptions.e());
    c.a(paramParcel, 6, paramPolygonOptions.f());
    c.a(paramParcel, 7, paramPolygonOptions.g());
    c.a(paramParcel, 8, paramPolygonOptions.h());
    c.a(paramParcel, 9, paramPolygonOptions.i());
    c.a(paramParcel, paramInt);
  }
  
  public PolygonOptions a(Parcel paramParcel)
  {
    float f1 = 0.0F;
    boolean bool1 = false;
    int m = a.b(paramParcel);
    ArrayList localArrayList1 = null;
    ArrayList localArrayList2 = new ArrayList();
    boolean bool2 = false;
    int i = 0;
    int j = 0;
    float f2 = 0.0F;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.f(paramParcel, n);
        break;
      case 2: 
        localArrayList1 = a.c(paramParcel, n, LatLng.CREATOR);
        break;
      case 3: 
        a.a(paramParcel, n, localArrayList2, getClass().getClassLoader());
        break;
      case 4: 
        f2 = a.i(paramParcel, n);
        break;
      case 5: 
        j = a.f(paramParcel, n);
        break;
      case 6: 
        i = a.f(paramParcel, n);
        break;
      case 7: 
        f1 = a.i(paramParcel, n);
        break;
      case 8: 
        bool2 = a.c(paramParcel, n);
        break;
      case 9: 
        bool1 = a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new b("Overread allowed size end=" + m, paramParcel);
    }
    return new PolygonOptions(k, localArrayList1, localArrayList2, f2, j, i, f1, bool2, bool1);
  }
  
  public PolygonOptions[] a(int paramInt)
  {
    return new PolygonOptions[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */