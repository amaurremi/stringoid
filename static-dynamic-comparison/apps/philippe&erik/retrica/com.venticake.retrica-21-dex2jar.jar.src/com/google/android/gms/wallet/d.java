package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class d
  implements SafeParcelable
{
  public static final Parcelable.Creator<d> CREATOR = new e();
  LoyaltyWalletObject aiO;
  OfferWalletObject aiP;
  private final int xM;
  
  d()
  {
    this.xM = 2;
  }
  
  d(int paramInt, LoyaltyWalletObject paramLoyaltyWalletObject, OfferWalletObject paramOfferWalletObject)
  {
    this.xM = paramInt;
    this.aiO = paramLoyaltyWalletObject;
    this.aiP = paramOfferWalletObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */