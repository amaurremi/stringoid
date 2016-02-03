package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import java.util.ArrayList;

public class b
  implements Parcelable.Creator<CastDevice>
{
  static void a(CastDevice paramCastDevice, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramCastDevice.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramCastDevice.getDeviceId(), false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramCastDevice.Ai, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 4, paramCastDevice.getFriendlyName(), false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 5, paramCastDevice.getModelName(), false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 6, paramCastDevice.getDeviceVersion(), false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 7, paramCastDevice.getServicePort());
    com.google.android.gms.common.internal.safeparcel.b.b(paramParcel, 8, paramCastDevice.getIcons(), false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 9, paramCastDevice.getCapabilities());
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, paramInt);
  }
  
  public CastDevice[] P(int paramInt)
  {
    return new CastDevice[paramInt];
  }
  
  public CastDevice s(Parcel paramParcel)
  {
    int i = 0;
    ArrayList localArrayList = null;
    int m = a.B(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
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
        str5 = a.o(paramParcel, n);
        break;
      case 3: 
        str4 = a.o(paramParcel, n);
        break;
      case 4: 
        str3 = a.o(paramParcel, n);
        break;
      case 5: 
        str2 = a.o(paramParcel, n);
        break;
      case 6: 
        str1 = a.o(paramParcel, n);
        break;
      case 7: 
        j = a.g(paramParcel, n);
        break;
      case 8: 
        localArrayList = a.c(paramParcel, n, WebImage.CREATOR);
        break;
      case 9: 
        i = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new CastDevice(k, str5, str4, str3, str2, str1, j, localArrayList, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */