package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard
  implements SafeParcelable
{
  public static final Parcelable.Creator<ProxyCard> CREATOR = new o();
  String ajV;
  String ajW;
  int ajX;
  int ajY;
  private final int xM;
  
  ProxyCard(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    this.xM = paramInt1;
    this.ajV = paramString1;
    this.ajW = paramString2;
    this.ajX = paramInt2;
    this.ajY = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCvn()
  {
    return this.ajW;
  }
  
  public int getExpirationMonth()
  {
    return this.ajX;
  }
  
  public int getExpirationYear()
  {
    return this.ajY;
  }
  
  public String getPan()
  {
    return this.ajV;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    o.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/ProxyCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */