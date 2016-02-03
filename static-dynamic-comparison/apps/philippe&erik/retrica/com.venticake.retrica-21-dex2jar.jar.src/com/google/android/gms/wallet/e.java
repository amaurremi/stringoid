package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e
  implements Parcelable.Creator<d>
{
  static void a(d paramd, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramd.getVersionCode());
    b.a(paramParcel, 2, paramd.aiO, paramInt, false);
    b.a(paramParcel, 3, paramd.aiP, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public d bT(Parcel paramParcel)
  {
    OfferWalletObject localOfferWalletObject = null;
    int j = a.B(paramParcel);
    int i = 0;
    LoyaltyWalletObject localLoyaltyWalletObject = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = a.g(paramParcel, k);
        continue;
        localLoyaltyWalletObject = (LoyaltyWalletObject)a.a(paramParcel, k, LoyaltyWalletObject.CREATOR);
        continue;
        localOfferWalletObject = (OfferWalletObject)a.a(paramParcel, k, OfferWalletObject.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new d(i, localLoyaltyWalletObject, localOfferWalletObject);
  }
  
  public d[] dz(int paramInt)
  {
    return new d[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */