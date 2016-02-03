package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.jm;
import com.google.android.gms.internal.jo;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.ju;
import com.google.android.gms.internal.jw;
import com.google.android.gms.internal.jy;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class j
  implements Parcelable.Creator<LoyaltyWalletObject>
{
  static void a(LoyaltyWalletObject paramLoyaltyWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = b.p(paramParcel);
    b.c(paramParcel, 1, paramLoyaltyWalletObject.getVersionCode());
    b.a(paramParcel, 2, paramLoyaltyWalletObject.eC, false);
    b.a(paramParcel, 3, paramLoyaltyWalletObject.abz, false);
    b.a(paramParcel, 4, paramLoyaltyWalletObject.abA, false);
    b.a(paramParcel, 5, paramLoyaltyWalletObject.abB, false);
    b.a(paramParcel, 6, paramLoyaltyWalletObject.abC, false);
    b.a(paramParcel, 7, paramLoyaltyWalletObject.abD, false);
    b.a(paramParcel, 8, paramLoyaltyWalletObject.abE, false);
    b.a(paramParcel, 9, paramLoyaltyWalletObject.abF, false);
    b.a(paramParcel, 10, paramLoyaltyWalletObject.abG, false);
    b.a(paramParcel, 11, paramLoyaltyWalletObject.abH, false);
    b.c(paramParcel, 12, paramLoyaltyWalletObject.state);
    b.b(paramParcel, 13, paramLoyaltyWalletObject.abI, false);
    b.a(paramParcel, 14, paramLoyaltyWalletObject.abJ, paramInt, false);
    b.b(paramParcel, 15, paramLoyaltyWalletObject.abK, false);
    b.a(paramParcel, 17, paramLoyaltyWalletObject.abM, false);
    b.a(paramParcel, 16, paramLoyaltyWalletObject.abL, false);
    b.a(paramParcel, 19, paramLoyaltyWalletObject.abO);
    b.b(paramParcel, 18, paramLoyaltyWalletObject.abN, false);
    b.b(paramParcel, 21, paramLoyaltyWalletObject.abQ, false);
    b.b(paramParcel, 20, paramLoyaltyWalletObject.abP, false);
    b.a(paramParcel, 23, paramLoyaltyWalletObject.abS, paramInt, false);
    b.b(paramParcel, 22, paramLoyaltyWalletObject.abR, false);
    b.F(paramParcel, i);
  }
  
  public LoyaltyWalletObject bf(Parcel paramParcel)
  {
    int k = a.o(paramParcel);
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
    ArrayList localArrayList6 = gi.fs();
    ju localju = null;
    ArrayList localArrayList5 = gi.fs();
    String str2 = null;
    String str1 = null;
    ArrayList localArrayList4 = gi.fs();
    boolean bool = false;
    ArrayList localArrayList3 = gi.fs();
    ArrayList localArrayList2 = gi.fs();
    ArrayList localArrayList1 = gi.fs();
    jo localjo = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.n(paramParcel);
      switch (a.R(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        str12 = a.n(paramParcel, m);
        break;
      case 3: 
        str11 = a.n(paramParcel, m);
        break;
      case 4: 
        str10 = a.n(paramParcel, m);
        break;
      case 5: 
        str9 = a.n(paramParcel, m);
        break;
      case 6: 
        str8 = a.n(paramParcel, m);
        break;
      case 7: 
        str7 = a.n(paramParcel, m);
        break;
      case 8: 
        str6 = a.n(paramParcel, m);
        break;
      case 9: 
        str5 = a.n(paramParcel, m);
        break;
      case 10: 
        str4 = a.n(paramParcel, m);
        break;
      case 11: 
        str3 = a.n(paramParcel, m);
        break;
      case 12: 
        i = a.g(paramParcel, m);
        break;
      case 13: 
        localArrayList6 = a.c(paramParcel, m, jy.CREATOR);
        break;
      case 14: 
        localju = (ju)a.a(paramParcel, m, ju.CREATOR);
        break;
      case 15: 
        localArrayList5 = a.c(paramParcel, m, LatLng.CREATOR);
        break;
      case 17: 
        str1 = a.n(paramParcel, m);
        break;
      case 16: 
        str2 = a.n(paramParcel, m);
        break;
      case 19: 
        bool = a.c(paramParcel, m);
        break;
      case 18: 
        localArrayList4 = a.c(paramParcel, m, jm.CREATOR);
        break;
      case 21: 
        localArrayList2 = a.c(paramParcel, m, js.CREATOR);
        break;
      case 20: 
        localArrayList3 = a.c(paramParcel, m, jw.CREATOR);
        break;
      case 23: 
        localjo = (jo)a.a(paramParcel, m, jo.CREATOR);
        break;
      case 22: 
        localArrayList1 = a.c(paramParcel, m, jw.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new LoyaltyWalletObject(j, str12, str11, str10, str9, str8, str7, str6, str5, str4, str3, i, localArrayList6, localju, localArrayList5, str2, str1, localArrayList4, bool, localArrayList3, localArrayList2, localArrayList1, localjo);
  }
  
  public LoyaltyWalletObject[] cr(int paramInt)
  {
    return new LoyaltyWalletObject[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/wallet/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */