package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<FullWalletRequest> CREATOR = new g();
  String aiQ;
  String aiR;
  Cart aja;
  private final int xM;
  
  FullWalletRequest()
  {
    this.xM = 1;
  }
  
  FullWalletRequest(int paramInt, String paramString1, String paramString2, Cart paramCart)
  {
    this.xM = paramInt;
    this.aiQ = paramString1;
    this.aiR = paramString2;
    this.aja = paramCart;
  }
  
  public static FullWalletRequest.Builder newBuilder()
  {
    FullWalletRequest localFullWalletRequest = new FullWalletRequest();
    localFullWalletRequest.getClass();
    return new FullWalletRequest.Builder(localFullWalletRequest, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Cart getCart()
  {
    return this.aja;
  }
  
  public String getGoogleTransactionId()
  {
    return this.aiQ;
  }
  
  public String getMerchantTransactionId()
  {
    return this.aiR;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/FullWalletRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */