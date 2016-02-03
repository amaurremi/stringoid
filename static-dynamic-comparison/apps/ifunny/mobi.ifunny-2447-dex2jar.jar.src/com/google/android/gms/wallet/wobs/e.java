package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.internal.pn;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class e
        implements Parcelable.Creator<CommonWalletObject> {
    static void a(CommonWalletObject paramCommonWalletObject, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramCommonWalletObject.b());
        c.a(paramParcel, 2, paramCommonWalletObject.a, false);
        c.a(paramParcel, 3, paramCommonWalletObject.b, false);
        c.a(paramParcel, 4, paramCommonWalletObject.c, false);
        c.a(paramParcel, 5, paramCommonWalletObject.d, false);
        c.a(paramParcel, 6, paramCommonWalletObject.e, false);
        c.a(paramParcel, 7, paramCommonWalletObject.f, false);
        c.a(paramParcel, 8, paramCommonWalletObject.g, false);
        c.a(paramParcel, 9, paramCommonWalletObject.h, false);
        c.a(paramParcel, 10, paramCommonWalletObject.i);
        c.c(paramParcel, 11, paramCommonWalletObject.j, false);
        c.a(paramParcel, 12, paramCommonWalletObject.k, paramInt, false);
        c.c(paramParcel, 13, paramCommonWalletObject.l, false);
        c.a(paramParcel, 14, paramCommonWalletObject.m, false);
        c.a(paramParcel, 15, paramCommonWalletObject.n, false);
        c.a(paramParcel, 17, paramCommonWalletObject.p);
        c.c(paramParcel, 16, paramCommonWalletObject.o, false);
        c.c(paramParcel, 19, paramCommonWalletObject.r, false);
        c.c(paramParcel, 18, paramCommonWalletObject.q, false);
        c.c(paramParcel, 20, paramCommonWalletObject.s, false);
        c.a(paramParcel, i);
    }

    public CommonWalletObject a(Parcel paramParcel) {
        int k = a.b(paramParcel);
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
        ArrayList localArrayList6 = pn.a();
        l locall = null;
        ArrayList localArrayList5 = pn.a();
        String str2 = null;
        String str1 = null;
        ArrayList localArrayList4 = pn.a();
        boolean bool = false;
        ArrayList localArrayList3 = pn.a();
        ArrayList localArrayList2 = pn.a();
        ArrayList localArrayList1 = pn.a();
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    j = a.g(paramParcel, m);
                    break;
                case 2:
                    str10 = a.o(paramParcel, m);
                    break;
                case 3:
                    str9 = a.o(paramParcel, m);
                    break;
                case 4:
                    str8 = a.o(paramParcel, m);
                    break;
                case 5:
                    str7 = a.o(paramParcel, m);
                    break;
                case 6:
                    str6 = a.o(paramParcel, m);
                    break;
                case 7:
                    str5 = a.o(paramParcel, m);
                    break;
                case 8:
                    str4 = a.o(paramParcel, m);
                    break;
                case 9:
                    str3 = a.o(paramParcel, m);
                    break;
                case 10:
                    i = a.g(paramParcel, m);
                    break;
                case 11:
                    localArrayList6 = a.c(paramParcel, m, p.CREATOR);
                    break;
                case 12:
                    locall = (l) a.a(paramParcel, m, l.CREATOR);
                    break;
                case 13:
                    localArrayList5 = a.c(paramParcel, m, LatLng.CREATOR);
                    break;
                case 14:
                    str2 = a.o(paramParcel, m);
                    break;
                case 15:
                    str1 = a.o(paramParcel, m);
                    break;
                case 17:
                    bool = a.c(paramParcel, m);
                    break;
                case 16:
                    localArrayList4 = a.c(paramParcel, m, d.CREATOR);
                    break;
                case 19:
                    localArrayList2 = a.c(paramParcel, m, j.CREATOR);
                    break;
                case 18:
                    localArrayList3 = a.c(paramParcel, m, n.CREATOR);
                    break;
                case 20:
                    localArrayList1 = a.c(paramParcel, m, n.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new CommonWalletObject(j, str10, str9, str8, str7, str6, str5, str4, str3, i, localArrayList6, locall, localArrayList5, str2, str1, localArrayList4, bool, localArrayList3, localArrayList2, localArrayList1);
    }

    public CommonWalletObject[] a(int paramInt) {
        return new CommonWalletObject[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/wobs/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */