package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.atomic.apps.ringtone.cutter.aa;
import com.google.android.gms.common.internal.safeparcel.a;

public final class n
  implements Parcelable.Creator
{
  public static ak a(Parcel paramParcel)
  {
    int i = 0;
    int i1 = aa.a(paramParcel);
    Object localObject = null;
    int j = 0;
    boolean bool = false;
    int k = 0;
    int m = 0;
    String str = null;
    int n = 0;
    while (paramParcel.dataPosition() < i1)
    {
      int i2 = paramParcel.readInt();
      switch (0xFFFF & i2)
      {
      default: 
        aa.b(paramParcel, i2);
        break;
      case 1: 
        n = aa.d(paramParcel, i2);
        break;
      case 2: 
        str = aa.f(paramParcel, i2);
        break;
      case 3: 
        m = aa.d(paramParcel, i2);
        break;
      case 4: 
        k = aa.d(paramParcel, i2);
        break;
      case 5: 
        bool = aa.c(paramParcel, i2);
        break;
      case 6: 
        j = aa.d(paramParcel, i2);
        break;
      case 7: 
        i = aa.d(paramParcel, i2);
        break;
      case 8: 
        localObject = ak.CREATOR;
        i2 = aa.a(paramParcel, i2);
        int i3 = paramParcel.dataPosition();
        if (i2 == 0) {
          localObject = null;
        }
        for (;;)
        {
          localObject = (ak[])localObject;
          break;
          localObject = paramParcel.createTypedArray((Parcelable.Creator)localObject);
          paramParcel.setDataPosition(i3 + i2);
        }
      }
    }
    if (paramParcel.dataPosition() != i1) {
      throw new a("Overread allowed size end=" + i1, paramParcel);
    }
    return new ak(n, str, m, k, bool, j, i, (ak[])localObject);
  }
  
  static void a(ak paramak, Parcel paramParcel, int paramInt)
  {
    int i = aa.b(paramParcel);
    aa.a(paramParcel, 1, paramak.a);
    aa.a(paramParcel, 2, paramak.b, false);
    aa.a(paramParcel, 3, paramak.c);
    aa.a(paramParcel, 4, paramak.d);
    aa.a(paramParcel, 5, paramak.e);
    aa.a(paramParcel, 6, paramak.f);
    aa.a(paramParcel, 7, paramak.g);
    aa.a(paramParcel, 8, paramak.h, paramInt, false);
    aa.j(paramParcel, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */