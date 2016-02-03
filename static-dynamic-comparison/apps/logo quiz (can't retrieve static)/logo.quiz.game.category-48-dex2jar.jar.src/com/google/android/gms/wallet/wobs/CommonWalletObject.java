package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jr;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<CommonWalletObject> CREATOR = new a();
  private final int BR;
  String asJ;
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
  ArrayList<j> asY;
  ArrayList<n> asZ;
  String fl;
  String name;
  int state;
  
  CommonWalletObject()
  {
    this.BR = 1;
    this.asQ = jr.hz();
    this.asS = jr.hz();
    this.asV = jr.hz();
    this.asX = jr.hz();
    this.asY = jr.hz();
    this.asZ = jr.hz();
  }
  
  CommonWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, ArrayList<p> paramArrayList, l paraml, ArrayList<LatLng> paramArrayList1, String paramString9, String paramString10, ArrayList<d> paramArrayList2, boolean paramBoolean, ArrayList<n> paramArrayList3, ArrayList<j> paramArrayList4, ArrayList<n> paramArrayList5)
  {
    this.BR = paramInt1;
    this.fl = paramString1;
    this.asP = paramString2;
    this.name = paramString3;
    this.asJ = paramString4;
    this.asL = paramString5;
    this.asM = paramString6;
    this.asN = paramString7;
    this.asO = paramString8;
    this.state = paramInt2;
    this.asQ = paramArrayList;
    this.asR = paraml;
    this.asS = paramArrayList1;
    this.asT = paramString9;
    this.asU = paramString10;
    this.asV = paramArrayList2;
    this.asW = paramBoolean;
    this.asX = paramArrayList3;
    this.asY = paramArrayList4;
    this.asZ = paramArrayList5;
  }
  
  public static a pO()
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
    return this.fl;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
  
  public final class a
  {
    private a() {}
    
    public a dc(String paramString)
    {
      CommonWalletObject.this.fl = paramString;
      return this;
    }
    
    public CommonWalletObject pP()
    {
      return CommonWalletObject.this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wallet/wobs/CommonWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */