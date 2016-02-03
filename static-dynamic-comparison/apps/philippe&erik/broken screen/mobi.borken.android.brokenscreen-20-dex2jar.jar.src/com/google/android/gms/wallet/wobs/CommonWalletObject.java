package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ih;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<CommonWalletObject> CREATOR = new a();
  String ajg;
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
  ArrayList<j> ajw;
  ArrayList<n> ajx;
  String eC;
  String name;
  int state;
  private final int xJ;
  
  CommonWalletObject()
  {
    this.xJ = 1;
    this.ajo = ih.fV();
    this.ajq = ih.fV();
    this.ajt = ih.fV();
    this.ajv = ih.fV();
    this.ajw = ih.fV();
    this.ajx = ih.fV();
  }
  
  CommonWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, ArrayList<p> paramArrayList, l paraml, ArrayList<LatLng> paramArrayList1, String paramString9, String paramString10, ArrayList<d> paramArrayList2, boolean paramBoolean, ArrayList<n> paramArrayList3, ArrayList<j> paramArrayList4, ArrayList<n> paramArrayList5)
  {
    this.xJ = paramInt1;
    this.eC = paramString1;
    this.ajn = paramString2;
    this.name = paramString3;
    this.ajg = paramString4;
    this.ajj = paramString5;
    this.ajk = paramString6;
    this.ajl = paramString7;
    this.ajm = paramString8;
    this.state = paramInt2;
    this.ajo = paramArrayList;
    this.ajp = paraml;
    this.ajq = paramArrayList1;
    this.ajr = paramString9;
    this.ajs = paramString10;
    this.ajt = paramArrayList2;
    this.aju = paramBoolean;
    this.ajv = paramArrayList3;
    this.ajw = paramArrayList4;
    this.ajx = paramArrayList5;
  }
  
  public static a nf()
  {
    CommonWalletObject localCommonWalletObject = new CommonWalletObject();
    localCommonWalletObject.getClass();
    return new a(null);
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
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
  
  public final class a
  {
    private a() {}
    
    public a cw(String paramString)
    {
      CommonWalletObject.this.eC = paramString;
      return this;
    }
    
    public CommonWalletObject ng()
    {
      return CommonWalletObject.this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wallet/wobs/CommonWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */