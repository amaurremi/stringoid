package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UserAddress
  implements SafeParcelable
{
  public static final Parcelable.Creator<UserAddress> CREATOR = new b();
  String UH;
  String UI;
  String UJ;
  String UK;
  String UL;
  String UM;
  String UN;
  String UO;
  String UP;
  String UQ;
  boolean UR;
  String US;
  String UT;
  String name;
  String rf;
  private final int xM;
  
  UserAddress()
  {
    this.xM = 1;
  }
  
  UserAddress(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean, String paramString13, String paramString14)
  {
    this.xM = paramInt;
    this.name = paramString1;
    this.UH = paramString2;
    this.UI = paramString3;
    this.UJ = paramString4;
    this.UK = paramString5;
    this.UL = paramString6;
    this.UM = paramString7;
    this.UN = paramString8;
    this.rf = paramString9;
    this.UO = paramString10;
    this.UP = paramString11;
    this.UQ = paramString12;
    this.UR = paramBoolean;
    this.US = paramString13;
    this.UT = paramString14;
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
    return this.UH;
  }
  
  public String getAddress2()
  {
    return this.UI;
  }
  
  public String getAddress3()
  {
    return this.UJ;
  }
  
  public String getAddress4()
  {
    return this.UK;
  }
  
  public String getAddress5()
  {
    return this.UL;
  }
  
  public String getAdministrativeArea()
  {
    return this.UM;
  }
  
  public String getCompanyName()
  {
    return this.US;
  }
  
  public String getCountryCode()
  {
    return this.rf;
  }
  
  public String getEmailAddress()
  {
    return this.UT;
  }
  
  public String getLocality()
  {
    return this.UN;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPhoneNumber()
  {
    return this.UQ;
  }
  
  public String getPostalCode()
  {
    return this.UO;
  }
  
  public String getSortingCode()
  {
    return this.UP;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public boolean isPostBox()
  {
    return this.UR;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/identity/intents/model/UserAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */