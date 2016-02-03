package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.dr;
import com.google.android.gms.internal.jj;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jp;
import com.google.android.gms.internal.jr;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jv;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class j
  implements Parcelable.Creator<LoyaltyWalletObject>
{
  static void a(LoyaltyWalletObject paramLoyaltyWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramLoyaltyWalletObject.lX());
    b.a(paramParcel, 2, paramLoyaltyWalletObject.eN, false);
    b.a(paramParcel, 3, paramLoyaltyWalletObject.YJ, false);
    b.a(paramParcel, 4, paramLoyaltyWalletObject.YK, false);
    b.a(paramParcel, 5, paramLoyaltyWalletObject.YL, false);
    b.a(paramParcel, 6, paramLoyaltyWalletObject.YM, false);
    b.a(paramParcel, 7, paramLoyaltyWalletObject.YN, false);
    b.a(paramParcel, 8, paramLoyaltyWalletObject.YO, false);
    b.a(paramParcel, 9, paramLoyaltyWalletObject.YP, false);
    b.a(paramParcel, 10, paramLoyaltyWalletObject.YQ, false);
    b.a(paramParcel, 11, paramLoyaltyWalletObject.YR, false);
    b.c(paramParcel, 12, paramLoyaltyWalletObject.state);
    b.b(paramParcel, 13, paramLoyaltyWalletObject.YS, false);
    b.a(paramParcel, 14, paramLoyaltyWalletObject.SE, paramInt, false);
    b.b(paramParcel, 15, paramLoyaltyWalletObject.YT, false);
    b.a(paramParcel, 17, paramLoyaltyWalletObject.YV, false);
    b.a(paramParcel, 16, paramLoyaltyWalletObject.YU, false);
    b.a(paramParcel, 19, paramLoyaltyWalletObject.YX);
    b.b(paramParcel, 18, paramLoyaltyWalletObject.YW, false);
    b.b(paramParcel, 21, paramLoyaltyWalletObject.YZ, false);
    b.b(paramParcel, 20, paramLoyaltyWalletObject.YY, false);
    b.a(paramParcel, 23, paramLoyaltyWalletObject.Zb, paramInt, false);
    b.b(paramParcel, 22, paramLoyaltyWalletObject.Za, false);
    b.D(paramParcel, i);
  }
  
  public LoyaltyWalletObject bF(Parcel paramParcel)
  {
    int k = a.j(paramParcel);
    int j = 0;
    String str12 = null;
    String str11 = null;
    String str10 = null;
    String str9 = null;
    String str8 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    int i = 0;
    ArrayList localArrayList6 = dr.qW();
    jr localjr = null;
    ArrayList localArrayList5 = dr.qW();
    String str2 = null;
    String str1 = null;
    ArrayList localArrayList4 = dr.qW();
    boolean bool = false;
    ArrayList localArrayList3 = dr.qW();
    ArrayList localArrayList2 = dr.qW();
    ArrayList localArrayList1 = dr.qW();
    jl localjl = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.i(paramParcel);
      switch (a.br(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        str12 = a.m(paramParcel, m);
        break;
      case 3: 
        str11 = a.m(paramParcel, m);
        break;
      case 4: 
        str10 = a.m(paramParcel, m);
        break;
      case 5: 
        str9 = a.m(paramParcel, m);
        break;
      case 6: 
        str8 = a.m(paramParcel, m);
        break;
      case 7: 
        str7 = a.m(paramParcel, m);
        break;
      case 8: 
        str6 = a.m(paramParcel, m);
        break;
      case 9: 
        str5 = a.m(paramParcel, m);
        break;
      case 10: 
        str4 = a.m(paramParcel, m);
        break;
      case 11: 
        str3 = a.m(paramParcel, m);
        break;
      case 12: 
        i = a.g(paramParcel, m);
        break;
      case 13: 
        localArrayList6 = a.c(paramParcel, m, jv.CREATOR);
        break;
      case 14: 
        localjr = (jr)a.a(paramParcel, m, jr.CREATOR);
        break;
      case 15: 
        localArrayList5 = a.c(paramParcel, m, LatLng.Vo);
        break;
      case 17: 
        str1 = a.m(paramParcel, m);
        break;
      case 16: 
        str2 = a.m(paramParcel, m);
        break;
      case 19: 
        bool = a.c(paramParcel, m);
        break;
      case 18: 
        localArrayList4 = a.c(paramParcel, m, jj.CREATOR);
        break;
      case 21: 
        localArrayList2 = a.c(paramParcel, m, jp.CREATOR);
        break;
      case 20: 
        localArrayList3 = a.c(paramParcel, m, jt.CREATOR);
        break;
      case 23: 
        localjl = (jl)a.a(paramParcel, m, jl.CREATOR);
        break;
      case 22: 
        localArrayList1 = a.c(paramParcel, m, jt.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new LoyaltyWalletObject(j, str12, str11, str10, str9, str8, str7, str6, str5, str4, str3, i, localArrayList6, localjr, localArrayList5, str2, str1, localArrayList4, bool, localArrayList3, localArrayList2, localArrayList1, localjl);
  }
  
  public LoyaltyWalletObject[] ex(int paramInt)
  {
    return new LoyaltyWalletObject[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/wallet/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */