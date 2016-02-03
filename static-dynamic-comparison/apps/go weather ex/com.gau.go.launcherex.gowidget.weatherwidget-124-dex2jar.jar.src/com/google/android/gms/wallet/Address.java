package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address
  implements SafeParcelable
{
  public static final Parcelable.Creator<Address> CREATOR = new a();
  String NB;
  String NC;
  String ND;
  String NI;
  String NK;
  boolean NL;
  String NM;
  String aba;
  String abb;
  String name;
  String qd;
  private final int xH;
  
  Address()
  {
    this.xH = 1;
  }
  
  Address(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, String paramString10)
  {
    this.xH = paramInt;
    this.name = paramString1;
    this.NB = paramString2;
    this.NC = paramString3;
    this.ND = paramString4;
    this.qd = paramString5;
    this.aba = paramString6;
    this.abb = paramString7;
    this.NI = paramString8;
    this.NK = paramString9;
    this.NL = paramBoolean;
    this.NM = paramString10;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress1()
  {
    return this.NB;
  }
  
  public String getAddress2()
  {
    return this.NC;
  }
  
  public String getAddress3()
  {
    return this.ND;
  }
  
  public String getCity()
  {
    return this.aba;
  }
  
  public String getCompanyName()
  {
    return this.NM;
  }
  
  public String getCountryCode()
  {
    return this.qd;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPhoneNumber()
  {
    return this.NK;
  }
  
  public String getPostalCode()
  {
    return this.NI;
  }
  
  public String getState()
  {
    return this.abb;
  }
  
  public int getVersionCode()
  {
    return this.xH;
  }
  
  public boolean isPostBox()
  {
    return this.NL;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/wallet/Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */