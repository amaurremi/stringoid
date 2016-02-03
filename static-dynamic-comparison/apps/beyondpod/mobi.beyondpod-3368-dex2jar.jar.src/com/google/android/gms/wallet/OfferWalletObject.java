package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class OfferWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<OfferWalletObject> CREATOR = new k();
  String GA;
  String GX;
  private final int kg;
  
  OfferWalletObject()
  {
    this.kg = 2;
  }
  
  OfferWalletObject(int paramInt, String paramString1, String paramString2)
  {
    this.kg = paramInt;
    this.GA = paramString1;
    this.GX = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.GA;
  }
  
  public String getRedemptionCode()
  {
    return this.GX;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/wallet/OfferWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */