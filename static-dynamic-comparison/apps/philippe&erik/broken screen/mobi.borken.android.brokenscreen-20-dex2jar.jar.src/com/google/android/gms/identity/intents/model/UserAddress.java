package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UserAddress
  implements SafeParcelable
{
  public static final Parcelable.Creator<UserAddress> CREATOR = new b();
  String UE;
  String UF;
  String UG;
  String UH;
  String UI;
  String UJ;
  String UK;
  String UL;
  String UM;
  String UN;
  boolean UO;
  String UP;
  String UQ;
  String name;
  String rc;
  private final int xJ;
  
  UserAddress()
  {
    this.xJ = 1;
  }
  
  UserAddress(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean, String paramString13, String paramString14)
  {
    this.xJ = paramInt;
    this.name = paramString1;
    this.UE = paramString2;
    this.UF = paramString3;
    this.UG = paramString4;
    this.UH = paramString5;
    this.UI = paramString6;
    this.UJ = paramString7;
    this.UK = paramString8;
    this.rc = paramString9;
    this.UL = paramString10;
    this.UM = paramString11;
    this.UN = paramString12;
    this.UO = paramBoolean;
    this.UP = paramString13;
    this.UQ = paramString14;
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
  
  public String getAddress4()
  {
    return this.UH;
  }
  
  public String getAddress5()
  {
    return this.UI;
  }
  
  public String getAdministrativeArea()
  {
    return this.UJ;
  }
  
  public String getCompanyName()
  {
    return this.UP;
  }
  
  public String getCountryCode()
  {
    return this.rc;
  }
  
  public String getEmailAddress()
  {
    return this.UQ;
  }
  
  public String getLocality()
  {
    return this.UK;
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
  
  public String getSortingCode()
  {
    return this.UM;
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
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/identity/intents/model/UserAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */