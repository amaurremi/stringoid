package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<CustomPropertyKey>
{
  static void a(CustomPropertyKey paramCustomPropertyKey, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramCustomPropertyKey.xJ);
    b.a(paramParcel, 2, paramCustomPropertyKey.JI, false);
    b.c(paramParcel, 3, paramCustomPropertyKey.JJ);
    b.G(paramParcel, paramInt);
  }
  
  public CustomPropertyKey az(Parcel paramParcel)
  {
    int j = 0;
    int k = a.B(paramParcel);
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        i = a.g(paramParcel, m);
        break;
      case 2: 
        str = a.o(paramParcel, m);
        break;
      case 3: 
        j = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new CustomPropertyKey(i, str, j);
  }
  
  public CustomPropertyKey[] bv(int paramInt)
  {
    return new CustomPropertyKey[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/metadata/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */