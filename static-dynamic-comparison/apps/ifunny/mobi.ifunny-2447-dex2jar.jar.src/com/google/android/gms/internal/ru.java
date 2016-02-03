package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ru
        implements Parcelable.Creator<nt> {
    static void a(nt paramnt, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        Set localSet = paramnt.a;
        if (localSet.contains(Integer.valueOf(1))) {
            c.a(paramParcel, 1, paramnt.b);
        }
        if (localSet.contains(Integer.valueOf(2))) {
            c.a(paramParcel, 2, paramnt.c, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(3))) {
            c.b(paramParcel, 3, paramnt.d, true);
        }
        if (localSet.contains(Integer.valueOf(4))) {
            c.a(paramParcel, 4, paramnt.e, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(5))) {
            c.a(paramParcel, 5, paramnt.f, true);
        }
        if (localSet.contains(Integer.valueOf(6))) {
            c.a(paramParcel, 6, paramnt.g, true);
        }
        if (localSet.contains(Integer.valueOf(7))) {
            c.a(paramParcel, 7, paramnt.h, true);
        }
        if (localSet.contains(Integer.valueOf(8))) {
            c.c(paramParcel, 8, paramnt.i, true);
        }
        if (localSet.contains(Integer.valueOf(9))) {
            c.a(paramParcel, 9, paramnt.j);
        }
        if (localSet.contains(Integer.valueOf(10))) {
            c.c(paramParcel, 10, paramnt.k, true);
        }
        if (localSet.contains(Integer.valueOf(11))) {
            c.a(paramParcel, 11, paramnt.l, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(12))) {
            c.c(paramParcel, 12, paramnt.m, true);
        }
        if (localSet.contains(Integer.valueOf(13))) {
            c.a(paramParcel, 13, paramnt.n, true);
        }
        if (localSet.contains(Integer.valueOf(14))) {
            c.a(paramParcel, 14, paramnt.o, true);
        }
        if (localSet.contains(Integer.valueOf(15))) {
            c.a(paramParcel, 15, paramnt.p, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(17))) {
            c.a(paramParcel, 17, paramnt.r, true);
        }
        if (localSet.contains(Integer.valueOf(16))) {
            c.a(paramParcel, 16, paramnt.q, true);
        }
        if (localSet.contains(Integer.valueOf(19))) {
            c.c(paramParcel, 19, paramnt.t, true);
        }
        if (localSet.contains(Integer.valueOf(18))) {
            c.a(paramParcel, 18, paramnt.s, true);
        }
        if (localSet.contains(Integer.valueOf(21))) {
            c.a(paramParcel, 21, paramnt.v, true);
        }
        if (localSet.contains(Integer.valueOf(20))) {
            c.a(paramParcel, 20, paramnt.u, true);
        }
        if (localSet.contains(Integer.valueOf(23))) {
            c.a(paramParcel, 23, paramnt.x, true);
        }
        if (localSet.contains(Integer.valueOf(22))) {
            c.a(paramParcel, 22, paramnt.w, true);
        }
        if (localSet.contains(Integer.valueOf(25))) {
            c.a(paramParcel, 25, paramnt.z, true);
        }
        if (localSet.contains(Integer.valueOf(24))) {
            c.a(paramParcel, 24, paramnt.y, true);
        }
        if (localSet.contains(Integer.valueOf(27))) {
            c.a(paramParcel, 27, paramnt.B, true);
        }
        if (localSet.contains(Integer.valueOf(26))) {
            c.a(paramParcel, 26, paramnt.A, true);
        }
        if (localSet.contains(Integer.valueOf(29))) {
            c.a(paramParcel, 29, paramnt.D, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(28))) {
            c.a(paramParcel, 28, paramnt.C, true);
        }
        if (localSet.contains(Integer.valueOf(31))) {
            c.a(paramParcel, 31, paramnt.F, true);
        }
        if (localSet.contains(Integer.valueOf(30))) {
            c.a(paramParcel, 30, paramnt.E, true);
        }
        if (localSet.contains(Integer.valueOf(34))) {
            c.a(paramParcel, 34, paramnt.I, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(32))) {
            c.a(paramParcel, 32, paramnt.G, true);
        }
        if (localSet.contains(Integer.valueOf(33))) {
            c.a(paramParcel, 33, paramnt.H, true);
        }
        if (localSet.contains(Integer.valueOf(38))) {
            c.a(paramParcel, 38, paramnt.L);
        }
        if (localSet.contains(Integer.valueOf(39))) {
            c.a(paramParcel, 39, paramnt.M, true);
        }
        if (localSet.contains(Integer.valueOf(36))) {
            c.a(paramParcel, 36, paramnt.J);
        }
        if (localSet.contains(Integer.valueOf(37))) {
            c.a(paramParcel, 37, paramnt.K, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(42))) {
            c.a(paramParcel, 42, paramnt.P, true);
        }
        if (localSet.contains(Integer.valueOf(43))) {
            c.a(paramParcel, 43, paramnt.Q, true);
        }
        if (localSet.contains(Integer.valueOf(40))) {
            c.a(paramParcel, 40, paramnt.N, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(41))) {
            c.c(paramParcel, 41, paramnt.O, true);
        }
        if (localSet.contains(Integer.valueOf(46))) {
            c.a(paramParcel, 46, paramnt.T, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(47))) {
            c.a(paramParcel, 47, paramnt.U, true);
        }
        if (localSet.contains(Integer.valueOf(44))) {
            c.a(paramParcel, 44, paramnt.R, true);
        }
        if (localSet.contains(Integer.valueOf(45))) {
            c.a(paramParcel, 45, paramnt.S, true);
        }
        if (localSet.contains(Integer.valueOf(51))) {
            c.a(paramParcel, 51, paramnt.Y, true);
        }
        if (localSet.contains(Integer.valueOf(50))) {
            c.a(paramParcel, 50, paramnt.X, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(49))) {
            c.a(paramParcel, 49, paramnt.W, true);
        }
        if (localSet.contains(Integer.valueOf(48))) {
            c.a(paramParcel, 48, paramnt.V, true);
        }
        if (localSet.contains(Integer.valueOf(55))) {
            c.a(paramParcel, 55, paramnt.ac, true);
        }
        if (localSet.contains(Integer.valueOf(54))) {
            c.a(paramParcel, 54, paramnt.ab, true);
        }
        if (localSet.contains(Integer.valueOf(53))) {
            c.a(paramParcel, 53, paramnt.aa, true);
        }
        if (localSet.contains(Integer.valueOf(52))) {
            c.a(paramParcel, 52, paramnt.Z, true);
        }
        if (localSet.contains(Integer.valueOf(56))) {
            c.a(paramParcel, 56, paramnt.ad, true);
        }
        c.a(paramParcel, i);
    }

    public nt a(Parcel paramParcel) {
        int k = a.b(paramParcel);
        HashSet localHashSet = new HashSet();
        int j = 0;
        nt localnt10 = null;
        ArrayList localArrayList6 = null;
        nt localnt9 = null;
        String str35 = null;
        String str34 = null;
        String str33 = null;
        ArrayList localArrayList5 = null;
        int i = 0;
        ArrayList localArrayList4 = null;
        nt localnt8 = null;
        ArrayList localArrayList3 = null;
        String str32 = null;
        String str31 = null;
        nt localnt7 = null;
        String str30 = null;
        String str29 = null;
        String str28 = null;
        ArrayList localArrayList2 = null;
        String str27 = null;
        String str26 = null;
        String str25 = null;
        String str24 = null;
        String str23 = null;
        String str22 = null;
        String str21 = null;
        String str20 = null;
        String str19 = null;
        nt localnt6 = null;
        String str18 = null;
        String str17 = null;
        String str16 = null;
        String str15 = null;
        nt localnt5 = null;
        double d2 = 0.0D;
        nt localnt4 = null;
        double d1 = 0.0D;
        String str14 = null;
        nt localnt3 = null;
        ArrayList localArrayList1 = null;
        String str13 = null;
        String str12 = null;
        String str11 = null;
        String str10 = null;
        nt localnt2 = null;
        String str9 = null;
        String str8 = null;
        String str7 = null;
        nt localnt1 = null;
        String str6 = null;
        String str5 = null;
        String str4 = null;
        String str3 = null;
        String str2 = null;
        String str1 = null;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                case 35:
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    j = a.g(paramParcel, m);
                    localHashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    localnt10 = (nt) a.a(paramParcel, m, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    localArrayList6 = a.C(paramParcel, m);
                    localHashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    localnt9 = (nt) a.a(paramParcel, m, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str35 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str34 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str33 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    localArrayList5 = a.c(paramParcel, m, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    i = a.g(paramParcel, m);
                    localHashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    localArrayList4 = a.c(paramParcel, m, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    localnt8 = (nt) a.a(paramParcel, m, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(11));
                    break;
                case 12:
                    localArrayList3 = a.c(paramParcel, m, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(12));
                    break;
                case 13:
                    str32 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(13));
                    break;
                case 14:
                    str31 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    localnt7 = (nt) a.a(paramParcel, m, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(15));
                    break;
                case 17:
                    str29 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(17));
                    break;
                case 16:
                    str30 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(16));
                    break;
                case 19:
                    localArrayList2 = a.c(paramParcel, m, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(19));
                    break;
                case 18:
                    str28 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(18));
                    break;
                case 21:
                    str26 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(21));
                    break;
                case 20:
                    str27 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(20));
                    break;
                case 23:
                    str24 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(23));
                    break;
                case 22:
                    str25 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(22));
                    break;
                case 25:
                    str22 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(25));
                    break;
                case 24:
                    str23 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(24));
                    break;
                case 27:
                    str20 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(27));
                    break;
                case 26:
                    str21 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(26));
                    break;
                case 29:
                    localnt6 = (nt) a.a(paramParcel, m, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(29));
                    break;
                case 28:
                    str19 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(28));
                    break;
                case 31:
                    str17 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(31));
                    break;
                case 30:
                    str18 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(30));
                    break;
                case 34:
                    localnt5 = (nt) a.a(paramParcel, m, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(34));
                    break;
                case 32:
                    str16 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(32));
                    break;
                case 33:
                    str15 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(33));
                    break;
                case 38:
                    d1 = a.m(paramParcel, m);
                    localHashSet.add(Integer.valueOf(38));
                    break;
                case 39:
                    str14 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(39));
                    break;
                case 36:
                    d2 = a.m(paramParcel, m);
                    localHashSet.add(Integer.valueOf(36));
                    break;
                case 37:
                    localnt4 = (nt) a.a(paramParcel, m, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(37));
                    break;
                case 42:
                    str13 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(42));
                    break;
                case 43:
                    str12 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(43));
                    break;
                case 40:
                    localnt3 = (nt) a.a(paramParcel, m, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(40));
                    break;
                case 41:
                    localArrayList1 = a.c(paramParcel, m, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(41));
                    break;
                case 46:
                    localnt2 = (nt) a.a(paramParcel, m, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(46));
                    break;
                case 47:
                    str9 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(47));
                    break;
                case 44:
                    str11 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(44));
                    break;
                case 45:
                    str10 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(45));
                    break;
                case 51:
                    str6 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(51));
                    break;
                case 50:
                    localnt1 = (nt) a.a(paramParcel, m, nt.CREATOR);
                    localHashSet.add(Integer.valueOf(50));
                    break;
                case 49:
                    str7 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(49));
                    break;
                case 48:
                    str8 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(48));
                    break;
                case 55:
                    str2 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(55));
                    break;
                case 54:
                    str3 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(54));
                    break;
                case 53:
                    str4 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(53));
                    break;
                case 52:
                    str5 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(52));
                    break;
                case 56:
                    str1 = a.o(paramParcel, m);
                    localHashSet.add(Integer.valueOf(56));
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new nt(localHashSet, j, localnt10, localArrayList6, localnt9, str35, str34, str33, localArrayList5, i, localArrayList4, localnt8, localArrayList3, str32, str31, localnt7, str30, str29, str28, localArrayList2, str27, str26, str25, str24, str23, str22, str21, str20, str19, localnt6, str18, str17, str16, str15, localnt5, d2, localnt4, d1, str14, localnt3, localArrayList1, str13, str12, str11, str10, localnt2, str9, str8, str7, localnt1, str6, str5, str4, str3, str2, str1);
    }

    public nt[] a(int paramInt) {
        return new nt[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */