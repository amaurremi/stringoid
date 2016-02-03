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

public class he
  implements Parcelable.Creator<hd>
{
  static void a(hd paramhd, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.a(paramParcel, 1, paramhd.getId(), false);
    b.a(paramParcel, 2, paramhd.ee(), false);
    b.a(paramParcel, 3, paramhd.ef(), paramInt, false);
    b.a(paramParcel, 4, paramhd.dX(), paramInt, false);
    b.a(paramParcel, 5, paramhd.dY());
    b.a(paramParcel, 6, paramhd.dZ(), paramInt, false);
    b.a(paramParcel, 7, paramhd.eg(), false);
    b.a(paramParcel, 8, paramhd.ea(), paramInt, false);
    b.a(paramParcel, 9, paramhd.eb());
    b.a(paramParcel, 10, paramhd.getRating());
    b.c(paramParcel, 11, paramhd.ec());
    b.a(paramParcel, 12, paramhd.ed());
    b.b(paramParcel, 13, paramhd.dW(), false);
    b.c(paramParcel, 1000, paramhd.kg);
    b.D(paramParcel, i);
  }
  
  public hd ao(Parcel paramParcel)
  {
    int k = a.n(paramParcel);
    int j = 0;
    String str2 = null;
    ArrayList localArrayList = null;
    Bundle localBundle = null;
    hf localhf = null;
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
      int m = a.m(paramParcel);
      switch (a.M(m))
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
        localhf = (hf)a.a(paramParcel, m, hf.CREATOR);
        break;
      case 4: 
        localLatLng = (LatLng)a.a(paramParcel, m, LatLng.CREATOR);
        break;
      case 5: 
        f2 = a.j(paramParcel, m);
        break;
      case 6: 
        localLatLngBounds = (LatLngBounds)a.a(paramParcel, m, LatLngBounds.CREATOR);
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
        localArrayList = a.c(paramParcel, m, gx.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new hd(j, str2, localArrayList, localBundle, localhf, localLatLng, f2, localLatLngBounds, str1, localUri, bool, f1, i, l);
  }
  
  public hd[] be(int paramInt)
  {
    return new hd[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/he.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */