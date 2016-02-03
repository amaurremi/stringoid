package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ig;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<CommonWalletObject> CREATOR = new a();
  ArrayList<n> ajA;
  String ajj;
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
  ArrayList<j> ajz;
  String eC;
  String name;
  int state;
  private final int xM;
  
  CommonWalletObject()
  {
    this.xM = 1;
    this.ajr = ig.ga();
    this.ajt = ig.ga();
    this.ajw = ig.ga();
    this.ajy = ig.ga();
    this.ajz = ig.ga();
    this.ajA = ig.ga();
  }
  
  CommonWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, ArrayList<p> paramArrayList, l paraml, ArrayList<LatLng> paramArrayList1, String paramString9, String paramString10, ArrayList<d> paramArrayList2, boolean paramBoolean, ArrayList<n> paramArrayList3, ArrayList<j> paramArrayList4, ArrayList<n> paramArrayList5)
  {
    this.xM = paramInt1;
    this.eC = paramString1;
    this.ajq = paramString2;
    this.name = paramString3;
    this.ajj = paramString4;
    this.ajm = paramString5;
    this.ajn = paramString6;
    this.ajo = paramString7;
    this.ajp = paramString8;
    this.state = paramInt2;
    this.ajr = paramArrayList;
    this.ajs = paraml;
    this.ajt = paramArrayList1;
    this.aju = paramString9;
    this.ajv = paramString10;
    this.ajw = paramArrayList2;
    this.ajx = paramBoolean;
    this.ajy = paramArrayList3;
    this.ajz = paramArrayList4;
    this.ajA = paramArrayList5;
  }
  
  public static CommonWalletObject.a nk()
  {
    CommonWalletObject localCommonWalletObject = new CommonWalletObject();
    localCommonWalletObject.getClass();
    return new CommonWalletObject.a(localCommonWalletObject, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.eC;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/wobs/CommonWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */