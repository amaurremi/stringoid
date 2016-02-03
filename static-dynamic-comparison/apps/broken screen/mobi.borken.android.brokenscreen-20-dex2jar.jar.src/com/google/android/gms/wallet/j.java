package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.ih;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;
import java.util.ArrayList;

public class j
  implements Parcelable.Creator<LoyaltyWalletObject>
{
  static void a(LoyaltyWalletObject paramLoyaltyWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramLoyaltyWalletObject.getVersionCode());
    b.a(paramParcel, 2, paramLoyaltyWalletObject.eC, false);
    b.a(paramParcel, 3, paramLoyaltyWalletObject.ajf, false);
    b.a(paramParcel, 4, paramLoyaltyWalletObject.ajg, false);
    b.a(paramParcel, 5, paramLoyaltyWalletObject.ajh, false);
    b.a(paramParcel, 6, paramLoyaltyWalletObject.aji, false);
    b.a(paramParcel, 7, paramLoyaltyWalletObject.ajj, false);
    b.a(paramParcel, 8, paramLoyaltyWalletObject.ajk, false);
    b.a(paramParcel, 9, paramLoyaltyWalletObject.ajl, false);
    b.a(paramParcel, 10, paramLoyaltyWalletObject.ajm, false);
    b.a(paramParcel, 11, paramLoyaltyWalletObject.ajn, false);
    b.c(paramParcel, 12, paramLoyaltyWalletObject.state);
    b.b(paramParcel, 13, paramLoyaltyWalletObject.ajo, false);
    b.a(paramParcel, 14, paramLoyaltyWalletObject.ajp, paramInt, false);
    b.b(paramParcel, 15, paramLoyaltyWalletObject.ajq, false);
    b.a(paramParcel, 17, paramLoyaltyWalletObject.ajs, false);
    b.a(paramParcel, 16, paramLoyaltyWalletObject.ajr, false);
    b.a(paramParcel, 19, paramLoyaltyWalletObject.aju);
    b.b(paramParcel, 18, paramLoyaltyWalletObject.ajt, false);
    b.b(paramParcel, 21, paramLoyaltyWalletObject.ajw, false);
    b.b(paramParcel, 20, paramLoyaltyWalletObject.ajv, false);
    b.a(paramParcel, 23, paramLoyaltyWalletObject.ajy, paramInt, false);
    b.b(paramParcel, 22, paramLoyaltyWalletObject.ajx, false);
    b.G(paramParcel, i);
  }
  
  public LoyaltyWalletObject bY(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
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
    ArrayList localArrayList6 = ih.fV();
    l locall = null;
    ArrayList localArrayList5 = ih.fV();
    String str2 = null;
    String str1 = null;
    ArrayList localArrayList4 = ih.fV();
    boolean bool = false;
    ArrayList localArrayList3 = ih.fV();
    ArrayList localArrayList2 = ih.fV();
    ArrayList localArrayList1 = ih.fV();
    f localf = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        str12 = a.o(paramParcel, m);
        break;
      case 3: 
        str11 = a.o(paramParcel, m);
        break;
      case 4: 
        str10 = a.o(paramParcel, m);
        break;
      case 5: 
        str9 = a.o(paramParcel, m);
        break;
      case 6: 
        str8 = a.o(paramParcel, m);
        break;
      case 7: 
        str7 = a.o(paramParcel, m);
        break;
      case 8: 
        str6 = a.o(paramParcel, m);
        break;
      case 9: 
        str5 = a.o(paramParcel, m);
        break;
      case 10: 
        str4 = a.o(paramParcel, m);
        break;
      case 11: 
        str3 = a.o(paramParcel, m);
        break;
      case 12: 
        i = a.g(paramParcel, m);
        break;
      case 13: 
        localArrayList6 = a.c(paramParcel, m, p.CREATOR);
        break;
      case 14: 
        locall = (l)a.a(paramParcel, m, l.CREATOR);
        break;
      case 15: 
        localArrayList5 = a.c(paramParcel, m, LatLng.CREATOR);
        break;
      case 17: 
        str1 = a.o(paramParcel, m);
        break;
      case 16: 
        str2 = a.o(paramParcel, m);
        break;
      case 19: 
        bool = a.c(paramParcel, m);
        break;
      case 18: 
        localArrayList4 = a.c(paramParcel, m, d.CREATOR);
        break;
      case 21: 
        localArrayList2 = a.c(paramParcel, m, com.google.android.gms.wallet.wobs.j.CREATOR);
        break;
      case 20: 
        localArrayList3 = a.c(paramParcel, m, n.CREATOR);
        break;
      case 23: 
        localf = (f)a.a(paramParcel, m, f.CREATOR);
        break;
      case 22: 
        localArrayList1 = a.c(paramParcel, m, n.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new LoyaltyWalletObject(j, str12, str11, str10, str9, str8, str7, str6, str5, str4, str3, i, localArrayList6, locall, localArrayList5, str2, str1, localArrayList4, bool, localArrayList3, localArrayList2, localArrayList1, localf);
  }
  
  public LoyaltyWalletObject[] dE(int paramInt)
  {
    return new LoyaltyWalletObject[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wallet/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */