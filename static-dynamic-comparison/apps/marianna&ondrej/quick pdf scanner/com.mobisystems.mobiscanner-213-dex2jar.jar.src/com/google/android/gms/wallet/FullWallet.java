package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<FullWallet> CREATOR = new f();
  UserAddress YA;
  UserAddress YB;
  InstrumentInfo[] YC;
  String Yt;
  String Yu;
  ProxyCard Yv;
  String Yw;
  Address Yx;
  Address Yy;
  String[] Yz;
  private final int qh;
  
  private FullWallet()
  {
    this.qh = 1;
  }
  
  FullWallet(int paramInt, String paramString1, String paramString2, ProxyCard paramProxyCard, String paramString3, Address paramAddress1, Address paramAddress2, String[] paramArrayOfString, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo)
  {
    this.qh = paramInt;
    this.Yt = paramString1;
    this.Yu = paramString2;
    this.Yv = paramProxyCard;
    this.Yw = paramString3;
    this.Yx = paramAddress1;
    this.Yy = paramAddress2;
    this.Yz = paramArrayOfString;
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
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/wallet/FullWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */