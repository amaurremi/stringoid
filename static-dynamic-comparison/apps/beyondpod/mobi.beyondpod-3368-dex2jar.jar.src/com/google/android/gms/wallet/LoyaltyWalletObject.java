package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LoyaltyWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new g();
  String GA;
  String GB;
  String GC;
  String GD;
  String GE;
  String GF;
  String GG;
  String GH;
  private final int kg;
  
  LoyaltyWalletObject()
  {
    this.kg = 3;
  }
  
  LoyaltyWalletObject(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.kg = paramInt;
    this.GA = paramString1;
    this.GB = paramString2;
    this.GC = paramString3;
    this.GD = paramString4;
    this.GE = paramString5;
    this.GF = paramString6;
    this.GG = paramString7;
    this.GH = paramString8;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountId()
  {
    return this.GB;
  }
  
  public String getAccountName()
  {
    return this.GE;
  }
  
  public String getBarcodeAlternateText()
  {
    return this.GF;
  }
  
  public String getBarcodeType()
  {
    return this.GG;
  }
  
  public String getBarcodeValue()
  {
    return this.GH;
  }
  
  public String getId()
  {
    return this.GA;
  }
  
  public String getIssuerName()
  {
    return this.GC;
  }
  
  public String getProgramName()
  {
    return this.GD;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/wallet/LoyaltyWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */