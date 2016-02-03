package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ig;
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
  ArrayList<n> ajA;
  f ajB;
  String aji;
  String ajj;
  String ajk;
  String ajl;
  String ajm;
  String ajn;
  String ajo;
  String ajp;
  String ajq;
  ArrayList<p> ajr;
  l ajs;
  ArrayList<LatLng> ajt;
  String aju;
  String ajv;
  ArrayList<d> ajw;
  boolean ajx;
  ArrayList<n> ajy;
  ArrayList<com.google.android.gms.wallet.wobs.j> ajz;
  String eC;
  int state;
  private final int xM;
  
  LoyaltyWalletObject()
  {
    this.xM = 4;
    this.ajr = ig.ga();
    this.ajt = ig.ga();
    this.ajw = ig.ga();
    this.ajy = ig.ga();
    this.ajz = ig.ga();
    this.ajA = ig.ga();
  }
  
  LoyaltyWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt2, ArrayList<p> paramArrayList, l paraml, ArrayList<LatLng> paramArrayList1, String paramString11, String paramString12, ArrayList<d> paramArrayList2, boolean paramBoolean, ArrayList<n> paramArrayList3, ArrayList<com.google.android.gms.wallet.wobs.j> paramArrayList4, ArrayList<n> paramArrayList5, f paramf)
  {
    this.xM = paramInt1;
    this.eC = paramString1;
    this.aji = paramString2;
    this.ajj = paramString3;
    this.ajk = paramString4;
    this.ajl = paramString5;
    this.ajm = paramString6;
    this.ajn = paramString7;
    this.ajo = paramString8;
    this.ajp = paramString9;
    this.ajq = paramString10;
    this.state = paramInt2;
    this.ajr = paramArrayList;
    this.ajs = paraml;
    this.ajt = paramArrayList1;
    this.aju = paramString11;
    this.ajv = paramString12;
    this.ajw = paramArrayList2;
    this.ajx = paramBoolean;
    this.ajy = paramArrayList3;
    this.ajz = paramArrayList4;
    this.ajA = paramArrayList5;
    this.ajB = paramf;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountId()
  {
    return this.aji;
  }
  
  public String getAccountName()
  {
    return this.ajl;
  }
  
  public String getBarcodeAlternateText()
  {
    return this.ajm;
  }
  
  public String getBarcodeType()
  {
    return this.ajn;
  }
  
  public String getBarcodeValue()
  {
    return this.ajo;
  }
  
  public String getId()
  {
    return this.eC;
  }
  
  public String getIssuerName()
  {
    return this.ajj;
  }
  
  public String getProgramName()
  {
    return this.ajk;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/LoyaltyWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */