package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.dr;
import com.google.android.gms.internal.jj;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jp;
import com.google.android.gms.internal.jr;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jv;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public final class LoyaltyWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new j();
  jr SE;
  String YJ;
  String YK;
  String YL;
  String YM;
  String YN;
  String YO;
  String YP;
  String YQ;
  String YR;
  ArrayList<jv> YS;
  ArrayList<LatLng> YT;
  String YU;
  String YV;
  ArrayList<jj> YW;
  boolean YX;
  ArrayList<jt> YY;
  ArrayList<jp> YZ;
  ArrayList<jt> Za;
  jl Zb;
  String eN;
  private final int qh;
  int state;
  
  LoyaltyWalletObject()
  {
    this.qh = 4;
    this.YS = dr.qW();
    this.YT = dr.qW();
    this.YW = dr.qW();
    this.YY = dr.qW();
    this.YZ = dr.qW();
    this.Za = dr.qW();
  }
  
  LoyaltyWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt2, ArrayList<jv> paramArrayList, jr paramjr, ArrayList<LatLng> paramArrayList1, String paramString11, String paramString12, ArrayList<jj> paramArrayList2, boolean paramBoolean, ArrayList<jt> paramArrayList3, ArrayList<jp> paramArrayList4, ArrayList<jt> paramArrayList5, jl paramjl)
  {
    this.qh = paramInt1;
    this.eN = paramString1;
    this.YJ = paramString2;
    this.YK = paramString3;
    this.YL = paramString4;
    this.YM = paramString5;
    this.YN = paramString6;
    this.YO = paramString7;
    this.YP = paramString8;
    this.YQ = paramString9;
    this.YR = paramString10;
    this.state = paramInt2;
    this.YS = paramArrayList;
    this.SE = paramjr;
    this.YT = paramArrayList1;
    this.YU = paramString11;
    this.YV = paramString12;
    this.YW = paramArrayList2;
    this.YX = paramBoolean;
    this.YY = paramArrayList3;
    this.YZ = paramArrayList4;
    this.Za = paramArrayList5;
    this.Zb = paramjl;
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
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/wallet/LoyaltyWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */