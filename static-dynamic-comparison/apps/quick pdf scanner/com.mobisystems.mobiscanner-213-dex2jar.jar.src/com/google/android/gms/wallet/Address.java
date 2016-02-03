package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address
  implements SafeParcelable
{
  public static final Parcelable.Creator<Address> CREATOR = new a();
  String Yo;
  String Yp;
  String name;
  private final int qh;
  String wK;
  String wL;
  String wM;
  String wN;
  String wS;
  String wU;
  boolean wV;
  String wW;
  
  Address()
  {
    this.qh = 1;
  }
  
  Address(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, String paramString10)
  {
    this.qh = paramInt;
    this.name = paramString1;
    this.wL = paramString2;
    this.wM = paramString3;
    this.wN = paramString4;
    this.wK = paramString5;
    this.Yo = paramString6;
    this.Yp = paramString7;
    this.wS = paramString8;
    this.wU = paramString9;
    this.wV = paramBoolean;
    this.wW = paramString10;
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
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/wallet/Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */