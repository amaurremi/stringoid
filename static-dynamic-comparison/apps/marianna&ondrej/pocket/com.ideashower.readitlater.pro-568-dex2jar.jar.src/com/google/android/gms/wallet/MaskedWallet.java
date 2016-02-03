package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MaskedWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new g();
  String a;
  String b;
  String[] c;
  String d;
  Address e;
  Address f;
  LoyaltyWalletObject[] g;
  OfferWalletObject[] h;
  private final int i;
  
  public MaskedWallet()
  {
    this.i = 2;
  }
  
  MaskedWallet(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, Address paramAddress1, Address paramAddress2, LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject, OfferWalletObject[] paramArrayOfOfferWalletObject)
  {
    this.i = paramInt;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayOfString;
    this.d = paramString3;
    this.e = paramAddress1;
    this.f = paramAddress2;
    this.g = paramArrayOfLoyaltyWalletObject;
    this.h = paramArrayOfOfferWalletObject;
  }
  
  public int a()
  {
    return this.i;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/wallet/MaskedWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */