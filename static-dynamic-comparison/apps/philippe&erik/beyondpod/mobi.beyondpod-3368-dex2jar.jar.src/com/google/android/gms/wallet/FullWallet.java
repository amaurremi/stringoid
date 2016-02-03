package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<FullWallet> CREATOR = new d();
  String Gn;
  String Go;
  ProxyCard Gp;
  String Gq;
  Address Gr;
  Address Gs;
  String[] Gt;
  private final int kg;
  
  FullWallet()
  {
    this.kg = 1;
  }
  
  FullWallet(int paramInt, String paramString1, String paramString2, ProxyCard paramProxyCard, String paramString3, Address paramAddress1, Address paramAddress2, String[] paramArrayOfString)
  {
    this.kg = paramInt;
    this.Gn = paramString1;
    this.Go = paramString2;
    this.Gp = paramProxyCard;
    this.Gq = paramString3;
    this.Gr = paramAddress1;
    this.Gs = paramAddress2;
    this.Gt = paramArrayOfString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Address getBillingAddress()
  {
    return this.Gr;
  }
  
  public String getEmail()
  {
    return this.Gq;
  }
  
  public String getGoogleTransactionId()
  {
    return this.Gn;
  }
  
  public String getMerchantTransactionId()
  {
    return this.Go;
  }
  
  public String[] getPaymentDescriptions()
  {
    return this.Gt;
  }
  
  public ProxyCard getProxyCard()
  {
    return this.Gp;
  }
  
  public Address getShippingAddress()
  {
    return this.Gs;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/wallet/FullWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */