package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UserAddress
  implements SafeParcelable
{
  public static final Parcelable.Creator<UserAddress> CREATOR = new b();
  private final int BR;
  String adC;
  String adD;
  String adE;
  String adF;
  String adG;
  String adH;
  String adI;
  String adJ;
  String adK;
  String adL;
  boolean adM;
  String adN;
  String adO;
  String name;
  String uW;
  
  UserAddress()
  {
    this.BR = 1;
  }
  
  UserAddress(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean, String paramString13, String paramString14)
  {
    this.BR = paramInt;
    this.name = paramString1;
    this.adC = paramString2;
    this.adD = paramString3;
    this.adE = paramString4;
    this.adF = paramString5;
    this.adG = paramString6;
    this.adH = paramString7;
    this.adI = paramString8;
    this.uW = paramString9;
    this.adJ = paramString10;
    this.adK = paramString11;
    this.adL = paramString12;
    this.adM = paramBoolean;
    this.adN = paramString13;
    this.adO = paramString14;
  }
  
  public static UserAddress fromIntent(Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.hasExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS"))) {
      return null;
    }
    return (UserAddress)paramIntent.getParcelableExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS");
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
  
  public String getAddress4()
  {
    return this.adF;
  }
  
  public String getAddress5()
  {
    return this.adG;
  }
  
  public String getAdministrativeArea()
  {
    return this.adH;
  }
  
  public String getCompanyName()
  {
    return this.adN;
  }
  
  public String getCountryCode()
  {
    return this.uW;
  }
  
  public String getEmailAddress()
  {
    return this.adO;
  }
  
  public String getLocality()
  {
    return this.adI;
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
  
  public String getSortingCode()
  {
    return this.adK;
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
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/identity/intents/model/UserAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */