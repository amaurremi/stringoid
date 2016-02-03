package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ih;
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
  String ajf;
  String ajg;
  String ajh;
  String aji;
  String ajj;
  String ajk;
  String ajl;
  String ajm;
  String ajn;
  ArrayList<p> ajo;
  l ajp;
  ArrayList<LatLng> ajq;
  String ajr;
  String ajs;
  ArrayList<d> ajt;
  boolean aju;
  ArrayList<n> ajv;
  ArrayList<com.google.android.gms.wallet.wobs.j> ajw;
  ArrayList<n> ajx;
  f ajy;
  String eC;
  int state;
  private final int xJ;
  
  LoyaltyWalletObject()
  {
    this.xJ = 4;
    this.ajo = ih.fV();
    this.ajq = ih.fV();
    this.ajt = ih.fV();
    this.ajv = ih.fV();
    this.ajw = ih.fV();
    this.ajx = ih.fV();
  }
  
  LoyaltyWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt2, ArrayList<p> paramArrayList, l paraml, ArrayList<LatLng> paramArrayList1, String paramString11, String paramString12, ArrayList<d> paramArrayList2, boolean paramBoolean, ArrayList<n> paramArrayList3, ArrayList<com.google.android.gms.wallet.wobs.j> paramArrayList4, ArrayList<n> paramArrayList5, f paramf)
  {
    this.xJ = paramInt1;
    this.eC = paramString1;
    this.ajf = paramString2;
    this.ajg = paramString3;
    this.ajh = paramString4;
    this.aji = paramString5;
    this.ajj = paramString6;
    this.ajk = paramString7;
    this.ajl = paramString8;
    this.ajm = paramString9;
    this.ajn = paramString10;
    this.state = paramInt2;
    this.ajo = paramArrayList;
    this.ajp = paraml;
    this.ajq = paramArrayList1;
    this.ajr = paramString11;
    this.ajs = paramString12;
    this.ajt = paramArrayList2;
    this.aju = paramBoolean;
    this.ajv = paramArrayList3;
    this.ajw = paramArrayList4;
    this.ajx = paramArrayList5;
    this.ajy = paramf;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountId()
  {
    return this.ajf;
  }
  
  public String getAccountName()
  {
    return this.aji;
  }
  
  public String getBarcodeAlternateText()
  {
    return this.ajj;
  }
  
  public String getBarcodeType()
  {
    return this.ajk;
  }
  
  public String getBarcodeValue()
  {
    return this.ajl;
  }
  
  public String getId()
  {
    return this.eC;
  }
  
  public String getIssuerName()
  {
    return this.ajg;
  }
  
  public String getProgramName()
  {
    return this.ajh;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wallet/LoyaltyWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */