package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g
  implements Parcelable.Creator<FullWalletRequest>
{
  static void a(FullWalletRequest paramFullWalletRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramFullWalletRequest.lX());
    b.a(paramParcel, 2, paramFullWalletRequest.Yt, false);
    b.a(paramParcel, 3, paramFullWalletRequest.Yu, false);
    b.a(paramParcel, 4, paramFullWalletRequest.YD, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public FullWalletRequest bC(Parcel paramParcel)
  {
    Cart localCart = null;
    int j = a.j(paramParcel);
    int i = 0;
    String str2 = null;
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
        break;
      case 4: 
        localCart = (Cart)a.a(paramParcel, k, Cart.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new FullWalletRequest(i, str1, str2, localCart);
  }
  
  public FullWalletRequest[] eu(int paramInt)
  {
    return new FullWalletRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/wallet/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */