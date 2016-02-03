package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class cd
  implements Parcelable.Creator<ce>
{
  static void a(ce paramce, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramce.versionCode);
    b.a(paramParcel, 2, paramce.oa, false);
    b.a(paramParcel, 3, paramce.ob, false);
    b.a(paramParcel, 4, paramce.mimeType, false);
    b.a(paramParcel, 5, paramce.packageName, false);
    b.a(paramParcel, 6, paramce.oc, false);
    b.a(paramParcel, 7, paramce.od, false);
    b.a(paramParcel, 8, paramce.oe, false);
    b.G(paramParcel, paramInt);
  }
  
  public ce e(Parcel paramParcel)
  {
    String str1 = null;
    int j = a.B(paramParcel);
    int i = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str7 = a.o(paramParcel, k);
        break;
      case 3: 
        str6 = a.o(paramParcel, k);
        break;
      case 4: 
        str5 = a.o(paramParcel, k);
        break;
      case 5: 
        str4 = a.o(paramParcel, k);
        break;
      case 6: 
        str3 = a.o(paramParcel, k);
        break;
      case 7: 
        str2 = a.o(paramParcel, k);
        break;
      case 8: 
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ce(i, str7, str6, str5, str4, str3, str2, str1);
  }
  
  public ce[] i(int paramInt)
  {
    return new ce[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */