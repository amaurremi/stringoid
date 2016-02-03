package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;

public class fc
  implements Parcelable.Creator<hx>
{
  static void a(hx paramhx, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.a(paramParcel, 1, paramhx.getId(), false);
    b.a(paramParcel, 2, paramhx.rA(), false);
    b.a(paramParcel, 3, paramhx.rB(), paramInt, false);
    b.a(paramParcel, 4, paramhx.rt(), paramInt, false);
    b.a(paramParcel, 5, paramhx.ru());
    b.a(paramParcel, 6, paramhx.rv(), paramInt, false);
    b.a(paramParcel, 7, paramhx.rC(), false);
    b.a(paramParcel, 8, paramhx.rw(), paramInt, false);
    b.a(paramParcel, 9, paramhx.rx());
    b.a(paramParcel, 10, paramhx.getRating());
    b.c(paramParcel, 11, paramhx.ry());
    b.a(paramParcel, 12, paramhx.rz());
    b.b(paramParcel, 13, paramhx.rs(), false);
    b.c(paramParcel, 1000, paramhx.qh);
    b.D(paramParcel, i);
  }
  
  public hx aI(Parcel paramParcel)
  {
    int k = a.j(paramParcel);
    int j = 0;
    String str2 = null;
    ArrayList localArrayList = null;
    Bundle localBundle = null;
    hz localhz = null;
    LatLng localLatLng = null;
    float f2 = 0.0F;
    LatLngBounds localLatLngBounds = null;
    String str1 = null;
    Uri localUri = null;
    boolean bool = false;
    float f1 = 0.0F;
    int i = 0;
    long l = 0L;
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
      case 2: 
        localBundle = a.o(paramParcel, m);
        break;
      case 3: 
        localhz = (hz)a.a(paramParcel, m, hz.Qd);
        break;
      case 4: 
        localLatLng = (LatLng)a.a(paramParcel, m, LatLng.Vo);
        break;
      case 5: 
        f2 = a.j(paramParcel, m);
        break;
      case 6: 
        localLatLngBounds = (LatLngBounds)a.a(paramParcel, m, LatLngBounds.Vr);
        break;
      case 7: 
        str1 = a.m(paramParcel, m);
        break;
      case 8: 
        localUri = (Uri)a.a(paramParcel, m, Uri.CREATOR);
        break;
      case 9: 
        bool = a.c(paramParcel, m);
        break;
      case 10: 
        f1 = a.j(paramParcel, m);
        break;
      case 11: 
        i = a.g(paramParcel, m);
        break;
      case 12: 
        l = a.h(paramParcel, m);
        break;
      case 13: 
        localArrayList = a.c(paramParcel, m, ht.PH);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new hx(j, str2, localArrayList, localBundle, localhz, localLatLng, f2, localLatLngBounds, str1, localUri, bool, f1, i, l);
  }
  
  public hx[] dc(int paramInt)
  {
    return new hx[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/fc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */