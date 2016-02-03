package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

public final class MaskedWalletRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new l();
  Cart YD;
  String Yr;
  String Yu;
  boolean Ze;
  boolean Zf;
  boolean Zg;
  String Zh;
  String Zi;
  boolean Zj;
  boolean Zk;
  CountrySpecification[] Zl;
  boolean Zm;
  boolean Zn;
  ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> Zo;
  private final int qh;
  
  MaskedWalletRequest()
  {
    this.qh = 3;
    this.Zm = true;
    this.Zn = true;
  }
  
  MaskedWalletRequest(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4, Cart paramCart, boolean paramBoolean4, boolean paramBoolean5, CountrySpecification[] paramArrayOfCountrySpecification, boolean paramBoolean6, boolean paramBoolean7, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> paramArrayList)
  {
    this.qh = paramInt;
    this.Yu = paramString1;
    this.Ze = paramBoolean1;
    this.Zf = paramBoolean2;
    this.Zg = paramBoolean3;
    this.Zh = paramString2;
    this.Yr = paramString3;
    this.Zi = paramString4;
    this.YD = paramCart;
    this.Zj = paramBoolean4;
    this.Zk = paramBoolean5;
    this.Zl = paramArrayOfCountrySpecification;
    this.Zm = paramBoolean6;
    this.Zn = paramBoolean7;
    this.Zo = paramArrayList;
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
    l.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/wallet/MaskedWalletRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */