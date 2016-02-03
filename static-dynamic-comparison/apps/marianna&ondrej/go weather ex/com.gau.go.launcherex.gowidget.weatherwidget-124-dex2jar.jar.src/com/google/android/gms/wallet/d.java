package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class d
  implements SafeParcelable
{
  public static final Parcelable.Creator<d> CREATOR = new e();
  LoyaltyWalletObject abg;
  private final int xH;
  
  d()
  {
    this.xH = 1;
  }
  
  d(int paramInt, LoyaltyWalletObject paramLoyaltyWalletObject)
  {
    this.xH = paramInt;
    this.abg = paramLoyaltyWalletObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.xH;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/wallet/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */