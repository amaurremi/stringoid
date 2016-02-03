package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OfferWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new j();
  String a;
  String b;
  private final int c;
  
  public OfferWalletObject()
  {
    this.c = 2;
  }
  
  OfferWalletObject(int paramInt, String paramString1, String paramString2)
  {
    this.c = paramInt;
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/wallet/OfferWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */