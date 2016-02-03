package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address
  implements SafeParcelable
{
  public static final Parcelable.Creator<Address> CREATOR = new a();
  String UE;
  String UF;
  String UG;
  String UL;
  String UN;
  boolean UO;
  String UP;
  String aiF;
  String aiG;
  String name;
  String rc;
  private final int xJ;
  
  Address()
  {
    this.xJ = 1;
  }
  
  Address(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, String paramString10)
  {
    this.xJ = paramInt;
    this.name = paramString1;
    this.UE = paramString2;
    this.UF = paramString3;
    this.UG = paramString4;
    this.rc = paramString5;
    this.aiF = paramString6;
    this.aiG = paramString7;
    this.UL = paramString8;
    this.UN = paramString9;
    this.UO = paramBoolean;
    this.UP = paramString10;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress1()
  {
    return this.UE;
  }
  
  public String getAddress2()
  {
    return this.UF;
  }
  
  public String getAddress3()
  {
    return this.UG;
  }
  
  public String getCity()
  {
    return this.aiF;
  }
  
  public String getCompanyName()
  {
    return this.UP;
  }
  
  public String getCountryCode()
  {
    return this.rc;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPhoneNumber()
  {
    return this.UN;
  }
  
  public String getPostalCode()
  {
    return this.UL;
  }
  
  public String getState()
  {
    return this.aiG;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public boolean isPostBox()
  {
    return this.UO;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wallet/Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */