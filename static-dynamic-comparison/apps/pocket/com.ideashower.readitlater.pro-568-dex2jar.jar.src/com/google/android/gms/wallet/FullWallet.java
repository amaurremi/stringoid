package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new c();
  String a;
  String b;
  ProxyCard c;
  String d;
  Address e;
  Address f;
  String[] g;
  private final int h;
  
  public FullWallet()
  {
    this.h = 1;
  }
  
  FullWallet(int paramInt, String paramString1, String paramString2, ProxyCard paramProxyCard, String paramString3, Address paramAddress1, Address paramAddress2, String[] paramArrayOfString)
  {
    this.h = paramInt;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramProxyCard;
    this.d = paramString3;
    this.e = paramAddress1;
    this.f = paramAddress2;
    this.g = paramArrayOfString;
  }
  
  public int a()
  {
    return this.h;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/wallet/FullWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */