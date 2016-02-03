package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class MaskedWalletRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new h();
  String a;
  boolean b;
  boolean c;
  boolean d;
  String e;
  String f;
  String g;
  Cart h;
  boolean i;
  boolean j;
  private final int k;
  
  public MaskedWalletRequest()
  {
    this.k = 2;
  }
  
  MaskedWalletRequest(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4, Cart paramCart, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.k = paramInt;
    this.a = paramString1;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramBoolean3;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    this.h = paramCart;
    this.i = paramBoolean4;
    this.j = paramBoolean5;
  }
  
  public int a()
  {
    return this.k;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/wallet/MaskedWalletRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */