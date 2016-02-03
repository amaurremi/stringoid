package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Address
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  String a;
  String b;
  String c;
  String d;
  String e;
  String f;
  String g;
  String h;
  String i;
  boolean j;
  String k;
  private final int l;
  
  public Address()
  {
    this.l = 1;
  }
  
  Address(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, String paramString10)
  {
    this.l = paramInt;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
    this.i = paramString9;
    this.j = paramBoolean;
    this.k = paramString10;
  }
  
  public int a()
  {
    return this.l;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/wallet/Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */