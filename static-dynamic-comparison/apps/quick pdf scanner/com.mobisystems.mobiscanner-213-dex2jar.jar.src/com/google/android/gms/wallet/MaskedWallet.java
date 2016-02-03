package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<MaskedWallet> CREATOR = new k();
  UserAddress YA;
  UserAddress YB;
  InstrumentInfo[] YC;
  String Yt;
  String Yu;
  String Yw;
  Address Yx;
  Address Yy;
  String[] Yz;
  LoyaltyWalletObject[] Zc;
  OfferWalletObject[] Zd;
  private final int qh;
  
  private MaskedWallet()
  {
    this.qh = 2;
  }
  
  MaskedWallet(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, Address paramAddress1, Address paramAddress2, LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject, OfferWalletObject[] paramArrayOfOfferWalletObject, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo)
  {
    this.qh = paramInt;
    this.Yt = paramString1;
    this.Yu = paramString2;
    this.Yz = paramArrayOfString;
    this.Yw = paramString3;
    this.Yx = paramAddress1;
    this.Yy = paramAddress2;
    this.Zc = paramArrayOfLoyaltyWalletObject;
    this.Zd = paramArrayOfOfferWalletObject;
    this.YA = paramUserAddress1;
    this.YB = paramUserAddress2;
    this.YC = paramArrayOfInstrumentInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/wallet/MaskedWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */