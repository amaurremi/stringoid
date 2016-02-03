package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class f
  implements Parcelable.Creator
{
  static void a(LoyaltyWalletObject paramLoyaltyWalletObject, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramLoyaltyWalletObject.a());
    c.a(paramParcel, 2, paramLoyaltyWalletObject.a, false);
    c.a(paramParcel, 3, paramLoyaltyWalletObject.b, false);
    c.a(paramParcel, 4, paramLoyaltyWalletObject.c, false);
    c.a(paramParcel, 5, paramLoyaltyWalletObject.d, false);
    c.a(paramParcel, 6, paramLoyaltyWalletObject.e, false);
    c.a(paramParcel, paramInt);
  }
  
  public LoyaltyWalletObject a(Parcel paramParcel)
  {
    String str1 = null;
    int j = a.b(paramParcel);
    int i = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.f(paramParcel, k);
        break;
      case 2: 
        str5 = a.l(paramParcel, k);
        break;
      case 3: 
        str4 = a.l(paramParcel, k);
        break;
      case 4: 
        str3 = a.l(paramParcel, k);
        break;
      case 5: 
        str2 = a.l(paramParcel, k);
        break;
      case 6: 
        str1 = a.l(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new LoyaltyWalletObject(i, str5, str4, str3, str2, str1);
  }
  
  public LoyaltyWalletObject[] a(int paramInt)
  {
    return new LoyaltyWalletObject[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/wallet/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */