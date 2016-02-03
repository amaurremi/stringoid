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
    paramInt = com.google.android.gms.common.internal.safeparcel.b.k(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramCastDevice.lX());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramCastDevice.getDeviceId(), false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramCastDevice.qo, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 4, paramCastDevice.mc(), false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 5, paramCastDevice.md(), false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 6, paramCastDevice.me(), false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 7, paramCastDevice.mf());
    com.google.android.gms.common.internal.safeparcel.b.b(paramParcel, 8, paramCastDevice.mg(), false);
    com.google.android.gms.common.internal.safeparcel.b.D(paramParcel, paramInt);
  }
  
  public CastDevice[] bh(int paramInt)
  {
    return new CastDevice[paramInt];
  }
  
  public CastDevice e(Parcel paramParcel)
  {
    int i = 0;
    ArrayList localArrayList = null;
    int k = a.j(paramParcel);
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
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
        j = a.g(paramParcel, m);
        break;
      case 2: 
        str5 = a.m(paramParcel, m);
        break;
      case 3: 
        str4 = a.m(paramParcel, m);
        break;
      case 4: 
        str3 = a.m(paramParcel, m);
        break;
      case 5: 
        str2 = a.m(paramParcel, m);
        break;
      case 6: 
        str1 = a.m(paramParcel, m);
        break;
      case 7: 
        i = a.g(paramParcel, m);
        break;
      case 8: 
        localArrayList = a.c(paramParcel, m, WebImage.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new CastDevice(j, str5, str4, str3, str2, str1, i, localArrayList);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/cast/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */