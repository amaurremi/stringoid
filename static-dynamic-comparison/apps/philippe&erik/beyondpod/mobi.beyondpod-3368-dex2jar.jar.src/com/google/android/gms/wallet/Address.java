package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Address
  implements SafeParcelable
{
  public static final Parcelable.Creator<Address> CREATOR = new a();
  String Ga;
  String Gb;
  String Gc;
  String Gd;
  String Ge;
  String Gf;
  String Gg;
  boolean Gh;
  String Gi;
  String id;
  private final int kg;
  String name;
  
  Address()
  {
    this.kg = 1;
  }
  
  Address(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, String paramString10)
  {
    this.kg = paramInt;
    this.name = paramString1;
    this.Ga = paramString2;
    this.Gb = paramString3;
    this.Gc = paramString4;
    this.id = paramString5;
    this.Gd = paramString6;
    this.Ge = paramString7;
    this.Gf = paramString8;
    this.Gg = paramString9;
    this.Gh = paramBoolean;
    this.Gi = paramString10;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress1()
  {
    return this.Ga;
  }
  
  public String getAddress2()
  {
    return this.Gb;
  }
  
  public String getAddress3()
  {
    return this.Gc;
  }
  
  public String getCity()
  {
    return this.Gd;
  }
  
  public String getCompanyName()
  {
    return this.Gi;
  }
  
  public String getCountryCode()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPhoneNumber()
  {
    return this.Gg;
  }
  
  public String getPostalCode()
  {
    return this.Gf;
  }
  
  public String getState()
  {
    return this.Ge;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public boolean isPostBox()
  {
    return this.Gh;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/wallet/Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */