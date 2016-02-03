package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UserAddress
  implements SafeParcelable
{
  public static final Parcelable.Creator<UserAddress> CREATOR = new b();
  String name;
  private final int qh;
  String wK;
  String wL;
  String wM;
  String wN;
  String wO;
  String wP;
  String wQ;
  String wR;
  String wS;
  String wT;
  String wU;
  boolean wV;
  String wW;
  String wX;
  
  UserAddress()
  {
    this.qh = 1;
  }
  
  UserAddress(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean, String paramString13, String paramString14)
  {
    this.qh = paramInt;
    this.name = paramString1;
    this.wL = paramString2;
    this.wM = paramString3;
    this.wN = paramString4;
    this.wO = paramString5;
    this.wP = paramString6;
    this.wQ = paramString7;
    this.wR = paramString8;
    this.wK = paramString9;
    this.wS = paramString10;
    this.wT = paramString11;
    this.wU = paramString12;
    this.wV = paramBoolean;
    this.wW = paramString13;
    this.wX = paramString14;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/identity/intents/model/UserAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */