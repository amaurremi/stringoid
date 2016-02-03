package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jr;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;
import java.util.ArrayList;

public final class LoyaltyWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new j();
  private final int BR;
  String Dv;
  String asI;
  String asJ;
  String asK;
  String asL;
  String asM;
  String asN;
  String asO;
  String asP;
  ArrayList<p> asQ;
  l asR;
  ArrayList<LatLng> asS;
  String asT;
  String asU;
  ArrayList<d> asV;
  boolean asW;
  ArrayList<n> asX;
  ArrayList<com.google.android.gms.wallet.wobs.j> asY;
  ArrayList<n> asZ;
  f ata;
  String fl;
  int state;
  
  LoyaltyWalletObject()
  {
    this.BR = 4;
    this.asQ = jr.hz();
    this.asS = jr.hz();
    this.asV = jr.hz();
    this.asX = jr.hz();
    this.asY = jr.hz();
    this.asZ = jr.hz();
  }
  
  LoyaltyWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt2, ArrayList<p> paramArrayList, l paraml, ArrayList<LatLng> paramArrayList1, String paramString11, String paramString12, ArrayList<d> paramArrayList2, boolean paramBoolean, ArrayList<n> paramArrayList3, ArrayList<com.google.android.gms.wallet.wobs.j> paramArrayList4, ArrayList<n> paramArrayList5, f paramf)
  {
    this.BR = paramInt1;
    this.fl = paramString1;
    this.asI = paramString2;
    this.asJ = paramString3;
    this.asK = paramString4;
    this.Dv = paramString5;
    this.asL = paramString6;
    this.asM = paramString7;
    this.asN = paramString8;
    this.asO = paramString9;
    this.asP = paramString10;
    this.state = paramInt2;
    this.asQ = paramArrayList;
    this.asR = paraml;
    this.asS = paramArrayList1;
    this.asT = paramString11;
    this.asU = paramString12;
    this.asV = paramArrayList2;
    this.asW = paramBoolean;
    this.asX = paramArrayList3;
    this.asY = paramArrayList4;
    this.asZ = paramArrayList5;
    this.ata = paramf;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountId()
  {
    return this.asI;
  }
  
  public String getAccountName()
  {
    return this.Dv;
  }
  
  public String getBarcodeAlternateText()
  {
    return this.asL;
  }
  
  public String getBarcodeType()
  {
    return this.asM;
  }
  
  public String getBarcodeValue()
  {
    return this.asN;
  }
  
  public String getId()
  {
    return this.fl;
  }
  
  public String getIssuerName()
  {
    return this.asJ;
  }
  
  public String getProgramName()
  {
    return this.asK;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wallet/LoyaltyWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */