package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard
  implements SafeParcelable
{
  public static final Parcelable.Creator<ProxyCard> CREATOR = new l();
  String GY;
  String GZ;
  int Ha;
  int Hb;
  private final int kg;
  
  ProxyCard(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    this.kg = paramInt1;
    this.GY = paramString1;
    this.GZ = paramString2;
    this.Ha = paramInt2;
    this.Hb = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCvn()
  {
    return this.GZ;
  }
  
  public int getExpirationMonth()
  {
    return this.Ha;
  }
  
  public int getExpirationYear()
  {
    return this.Hb;
  }
  
  public String getPan()
  {
    return this.GY;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    l.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/wallet/ProxyCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */