package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class n
  implements Parcelable.Creator<OfferWalletObject>
{
  static void a(OfferWalletObject paramOfferWalletObject, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.c(paramParcel, 1, paramOfferWalletObject.lX());
    b.a(paramParcel, 2, paramOfferWalletObject.eN, false);
    b.a(paramParcel, 3, paramOfferWalletObject.Zq, false);
    b.D(paramParcel, paramInt);
  }
  
  public OfferWalletObject bJ(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.j(paramParcel);
    int i = 0;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str1 = a.m(paramParcel, k);
        break;
      case 3: 
        str2 = a.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new OfferWalletObject(i, str1, str2);
  }
  
  public OfferWalletObject[] eB(int paramInt)
  {
    return new OfferWalletObject[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/wallet/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */