package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class h
  implements Parcelable.Creator
{
  static void a(MaskedWalletRequest paramMaskedWalletRequest, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramMaskedWalletRequest.a());
    c.a(paramParcel, 2, paramMaskedWalletRequest.a, false);
    c.a(paramParcel, 3, paramMaskedWalletRequest.b);
    c.a(paramParcel, 4, paramMaskedWalletRequest.c);
    c.a(paramParcel, 5, paramMaskedWalletRequest.d);
    c.a(paramParcel, 6, paramMaskedWalletRequest.e, false);
    c.a(paramParcel, 7, paramMaskedWalletRequest.f, false);
    c.a(paramParcel, 8, paramMaskedWalletRequest.g, false);
    c.a(paramParcel, 9, paramMaskedWalletRequest.h, paramInt, false);
    c.a(paramParcel, 10, paramMaskedWalletRequest.i);
    c.a(paramParcel, 11, paramMaskedWalletRequest.j);
    c.a(paramParcel, i);
  }
  
  public MaskedWalletRequest a(Parcel paramParcel)
  {
    Cart localCart = null;
    boolean bool1 = false;
    int j = a.b(paramParcel);
    boolean bool2 = false;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    String str4 = null;
    int i = 0;
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
        str4 = a.l(paramParcel, k);
        break;
      case 3: 
        bool5 = a.c(paramParcel, k);
        break;
      case 4: 
        bool4 = a.c(paramParcel, k);
        break;
      case 5: 
        bool3 = a.c(paramParcel, k);
        break;
      case 6: 
        str3 = a.l(paramParcel, k);
        break;
      case 7: 
        str2 = a.l(paramParcel, k);
        break;
      case 8: 
        str1 = a.l(paramParcel, k);
        break;
      case 9: 
        localCart = (Cart)a.a(paramParcel, k, Cart.CREATOR);
        break;
      case 10: 
        bool2 = a.c(paramParcel, k);
        break;
      case 11: 
        bool1 = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new MaskedWalletRequest(i, str4, bool5, bool4, bool3, str3, str2, str1, localCart, bool2, bool1);
  }
  
  public MaskedWalletRequest[] a(int paramInt)
  {
    return new MaskedWalletRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/wallet/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */