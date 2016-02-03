package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g
  implements Parcelable.Creator<LoyaltyWalletObject>
{
  static void a(LoyaltyWalletObject paramLoyaltyWalletObject, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    b.c(paramParcel, 1, paramLoyaltyWalletObject.getVersionCode());
    b.a(paramParcel, 2, paramLoyaltyWalletObject.GA, false);
    b.a(paramParcel, 3, paramLoyaltyWalletObject.GB, false);
    b.a(paramParcel, 4, paramLoyaltyWalletObject.GC, false);
    b.a(paramParcel, 5, paramLoyaltyWalletObject.GD, false);
    b.a(paramParcel, 6, paramLoyaltyWalletObject.GE, false);
    b.a(paramParcel, 7, paramLoyaltyWalletObject.GF, false);
    b.a(paramParcel, 8, paramLoyaltyWalletObject.GG, false);
    b.a(paramParcel, 9, paramLoyaltyWalletObject.GH, false);
    b.D(paramParcel, paramInt);
  }
  
  public LoyaltyWalletObject aK(Parcel paramParcel)
  {
    String str1 = null;
    int j = a.n(paramParcel);
    int i = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
    String str8 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str8 = a.m(paramParcel, k);
        break;
      case 3: 
        str7 = a.m(paramParcel, k);
        break;
      case 4: 
        str6 = a.m(paramParcel, k);
        break;
      case 5: 
        str5 = a.m(paramParcel, k);
        break;
      case 6: 
        str4 = a.m(paramParcel, k);
        break;
      case 7: 
        str3 = a.m(paramParcel, k);
        break;
      case 8: 
        str2 = a.m(paramParcel, k);
        break;
      case 9: 
        str1 = a.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new LoyaltyWalletObject(i, str8, str7, str6, str5, str4, str3, str2, str1);
  }
  
  public LoyaltyWalletObject[] bC(int paramInt)
  {
    return new LoyaltyWalletObject[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/wallet/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */