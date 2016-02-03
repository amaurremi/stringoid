package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ce
  implements Parcelable.Creator<cf>
{
  static void a(cf paramcf, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramcf.versionCode);
    b.a(paramParcel, 2, paramcf.nY, false);
    b.a(paramParcel, 3, paramcf.nZ, false);
    b.a(paramParcel, 4, paramcf.mimeType, false);
    b.a(paramParcel, 5, paramcf.packageName, false);
    b.a(paramParcel, 6, paramcf.oa, false);
    b.a(paramParcel, 7, paramcf.ob, false);
    b.a(paramParcel, 8, paramcf.oc, false);
    b.G(paramParcel, paramInt);
  }
  
  public cf e(Parcel paramParcel)
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
    return new cf(i, str7, str6, str5, str4, str3, str2, str1);
  }
  
  public cf[] i(int paramInt)
  {
    return new cf[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */