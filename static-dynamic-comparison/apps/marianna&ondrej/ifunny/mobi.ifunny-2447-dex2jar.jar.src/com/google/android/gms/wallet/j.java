package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.internal.pn;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;

import java.util.ArrayList;

public class j
        implements Parcelable.Creator<LoyaltyWalletObject> {
    static void a(LoyaltyWalletObject paramLoyaltyWalletObject, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramLoyaltyWalletObject.a());
        c.a(paramParcel, 2, paramLoyaltyWalletObject.a, false);
        c.a(paramParcel, 3, paramLoyaltyWalletObject.b, false);
        c.a(paramParcel, 4, paramLoyaltyWalletObject.c, false);
        c.a(paramParcel, 5, paramLoyaltyWalletObject.d, false);
        c.a(paramParcel, 6, paramLoyaltyWalletObject.e, false);
        c.a(paramParcel, 7, paramLoyaltyWalletObject.f, false);
        c.a(paramParcel, 8, paramLoyaltyWalletObject.g, false);
        c.a(paramParcel, 9, paramLoyaltyWalletObject.h, false);
        c.a(paramParcel, 10, paramLoyaltyWalletObject.i, false);
        c.a(paramParcel, 11, paramLoyaltyWalletObject.j, false);
        c.a(paramParcel, 12, paramLoyaltyWalletObject.k);
        c.c(paramParcel, 13, paramLoyaltyWalletObject.l, false);
        c.a(paramParcel, 14, paramLoyaltyWalletObject.m, paramInt, false);
        c.c(paramParcel, 15, paramLoyaltyWalletObject.n, false);
        c.a(paramParcel, 17, paramLoyaltyWalletObject.p, false);
        c.a(paramParcel, 16, paramLoyaltyWalletObject.o, false);
        c.a(paramParcel, 19, paramLoyaltyWalletObject.r);
        c.c(paramParcel, 18, paramLoyaltyWalletObject.q, false);
        c.c(paramParcel, 21, paramLoyaltyWalletObject.t, false);
        c.c(paramParcel, 20, paramLoyaltyWalletObject.s, false);
        c.a(paramParcel, 23, paramLoyaltyWalletObject.v, paramInt, false);
        c.c(paramParcel, 22, paramLoyaltyWalletObject.u, false);
        c.a(paramParcel, i);
    }

    public LoyaltyWalletObject a(Parcel paramParcel) {
        int k = a.b(paramParcel);
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
        f localf = null;
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
                    locall = (l) a.a(paramParcel, m, l.CREATOR);
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
                    localf = (f) a.a(paramParcel, m, f.CREATOR);
                    break;
                case 22:
                    localArrayList1 = a.c(paramParcel, m, n.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new LoyaltyWalletObject(j, str12, str11, str10, str9, str8, str7, str6, str5, str4, str3, i, localArrayList6, locall, localArrayList5, str2, str1, localArrayList4, bool, localArrayList3, localArrayList2, localArrayList1, localf);
    }

    public LoyaltyWalletObject[] a(int paramInt) {
        return new LoyaltyWalletObject[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */