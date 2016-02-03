package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h
  implements Parcelable.Creator<InstrumentInfo>
{
  static void a(InstrumentInfo paramInstrumentInfo, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramInstrumentInfo.getVersionCode());
    b.a(paramParcel, 2, paramInstrumentInfo.getInstrumentType(), false);
    b.a(paramParcel, 3, paramInstrumentInfo.getInstrumentDetails(), false);
    b.G(paramParcel, paramInt);
  }
  
  public InstrumentInfo bW(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.B(paramParcel);
    int i = 0;
    String str1 = null;
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
        str1 = a.o(paramParcel, k);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new InstrumentInfo(i, str1, str2);
  }
  
  public InstrumentInfo[] dC(int paramInt)
  {
    return new InstrumentInfo[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wallet/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */