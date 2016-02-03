package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address
  implements SafeParcelable
{
  public static final Parcelable.Creator<Address> CREATOR = new a();
  private final int BR;
  String adC;
  String adD;
  String adE;
  String adJ;
  String adL;
  boolean adM;
  String adN;
  String asi;
  String asj;
  String name;
  String uW;
  
  Address()
  {
    this.BR = 1;
  }
  
  Address(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, String paramString10)
  {
    this.BR = paramInt;
    this.name = paramString1;
    this.adC = paramString2;
    this.adD = paramString3;
    this.adE = paramString4;
    this.uW = paramString5;
    this.asi = paramString6;
    this.asj = paramString7;
    this.adJ = paramString8;
    this.adL = paramString9;
    this.adM = paramBoolean;
    this.adN = paramString10;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress1()
  {
    return this.adC;
  }
  
  public String getAddress2()
  {
    return this.adD;
  }
  
  public String getAddress3()
  {
    return this.adE;
  }
  
  public String getCity()
  {
    return this.asi;
  }
  
  public String getCompanyName()
  {
    return this.adN;
  }
  
  public String getCountryCode()
  {
    return this.uW;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPhoneNumber()
  {
    return this.adL;
  }
  
  public String getPostalCode()
  {
    return this.adJ;
  }
  
  public String getState()
  {
    return this.asj;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public boolean isPostBox()
  {
    return this.adM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wallet/Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */