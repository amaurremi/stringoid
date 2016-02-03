package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.ih;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator<CommonWalletObject>
{
  static void a(CommonWalletObject paramCommonWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramCommonWalletObject.getVersionCode());
    b.a(paramParcel, 2, paramCommonWalletObject.eC, false);
    b.a(paramParcel, 3, paramCommonWalletObject.ajn, false);
    b.a(paramParcel, 4, paramCommonWalletObject.name, false);
    b.a(paramParcel, 5, paramCommonWalletObject.ajg, false);
    b.a(paramParcel, 6, paramCommonWalletObject.ajj, false);
    b.a(paramParcel, 7, paramCommonWalletObject.ajk, false);
    b.a(paramParcel, 8, paramCommonWalletObject.ajl, false);
    b.a(paramParcel, 9, paramCommonWalletObject.ajm, false);
    b.c(paramParcel, 10, paramCommonWalletObject.state);
    b.b(paramParcel, 11, paramCommonWalletObject.ajo, false);
    b.a(paramParcel, 12, paramCommonWalletObject.ajp, paramInt, false);
    b.b(paramParcel, 13, paramCommonWalletObject.ajq, false);
    b.a(paramParcel, 14, paramCommonWalletObject.ajr, false);
    b.a(paramParcel, 15, paramCommonWalletObject.ajs, false);
    b.a(paramParcel, 17, paramCommonWalletObject.aju);
    b.b(paramParcel, 16, paramCommonWalletObject.ajt, false);
    b.b(paramParcel, 19, paramCommonWalletObject.ajw, false);
    b.b(paramParcel, 18, paramCommonWalletObject.ajv, false);
    b.b(paramParcel, 20, paramCommonWalletObject.ajx, false);
    b.G(paramParcel, i);
  }
  
  public CommonWalletObject cj(Parcel paramParcel)
  {
    int k = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    int j = 0;
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
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(m))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
        break;
      case 1: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
        break;
      case 2: 
        str10 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
        break;
      case 3: 
        str9 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
        break;
      case 4: 
        str8 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
        break;
      case 5: 
        str7 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
        break;
      case 6: 
        str6 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
        break;
      case 7: 
        str5 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
        break;
      case 8: 
        str4 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
        break;
      case 9: 
        str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
        break;
      case 10: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
        break;
      case 11: 
        localArrayList6 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, m, p.CREATOR);
        break;
      case 12: 
        locall = (l)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, l.CREATOR);
        break;
      case 13: 
        localArrayList5 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, m, LatLng.CREATOR);
        break;
      case 14: 
        str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
        break;
      case 15: 
        str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
        break;
      case 17: 
        bool = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, m);
        break;
      case 16: 
        localArrayList4 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, m, d.CREATOR);
        break;
      case 19: 
        localArrayList2 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, m, j.CREATOR);
        break;
      case 18: 
        localArrayList3 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, m, n.CREATOR);
        break;
      case 20: 
        localArrayList1 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, m, n.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new CommonWalletObject(j, str10, str9, str8, str7, str6, str5, str4, str3, i, localArrayList6, locall, localArrayList5, str2, str1, localArrayList4, bool, localArrayList3, localArrayList2, localArrayList1);
  }
  
  public CommonWalletObject[] dR(int paramInt)
  {
    return new CommonWalletObject[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wallet/wobs/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */