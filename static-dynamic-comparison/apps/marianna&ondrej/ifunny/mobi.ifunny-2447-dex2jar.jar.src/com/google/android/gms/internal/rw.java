package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class rw
        implements Parcelable.Creator<ny> {
    static void a(ny paramny, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        Set localSet = paramny.a;
        if (localSet.contains(Integer.valueOf(1))) {
            c.a(paramParcel, 1, paramny.b);
        }
        if (localSet.contains(Integer.valueOf(2))) {
            c.a(paramParcel, 2, paramny.c, true);
        }
        if (localSet.contains(Integer.valueOf(3))) {
            c.a(paramParcel, 3, paramny.d, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(4))) {
            c.a(paramParcel, 4, paramny.e, true);
        }
        if (localSet.contains(Integer.valueOf(5))) {
            c.a(paramParcel, 5, paramny.f, true);
        }
        if (localSet.contains(Integer.valueOf(6))) {
            c.a(paramParcel, 6, paramny.g);
        }
        if (localSet.contains(Integer.valueOf(7))) {
            c.a(paramParcel, 7, paramny.h, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(8))) {
            c.a(paramParcel, 8, paramny.i, true);
        }
        if (localSet.contains(Integer.valueOf(9))) {
            c.a(paramParcel, 9, paramny.j, true);
        }
        if (localSet.contains(Integer.valueOf(12))) {
            c.a(paramParcel, 12, paramny.k);
        }
        if (localSet.contains(Integer.valueOf(14))) {
            c.a(paramParcel, 14, paramny.l, true);
        }
        if (localSet.contains(Integer.valueOf(15))) {
            c.a(paramParcel, 15, paramny.m, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(16))) {
            c.a(paramParcel, 16, paramny.n);
        }
        if (localSet.contains(Integer.valueOf(19))) {
            c.a(paramParcel, 19, paramny.p, paramInt, true);
        }
        if (localSet.contains(Integer.valueOf(18))) {
            c.a(paramParcel, 18, paramny.o, true);
        }
        if (localSet.contains(Integer.valueOf(21))) {
            c.a(paramParcel, 21, paramny.r);
        }
        if (localSet.contains(Integer.valueOf(20))) {
            c.a(paramParcel, 20, paramny.q, true);
        }
        if (localSet.contains(Integer.valueOf(23))) {
            c.c(paramParcel, 23, paramny.t, true);
        }
        if (localSet.contains(Integer.valueOf(22))) {
            c.c(paramParcel, 22, paramny.s, true);
        }
        if (localSet.contains(Integer.valueOf(25))) {
            c.a(paramParcel, 25, paramny.v);
        }
        if (localSet.contains(Integer.valueOf(24))) {
            c.a(paramParcel, 24, paramny.u);
        }
        if (localSet.contains(Integer.valueOf(27))) {
            c.a(paramParcel, 27, paramny.x, true);
        }
        if (localSet.contains(Integer.valueOf(26))) {
            c.a(paramParcel, 26, paramny.w, true);
        }
        if (localSet.contains(Integer.valueOf(29))) {
            c.a(paramParcel, 29, paramny.z);
        }
        if (localSet.contains(Integer.valueOf(28))) {
            c.c(paramParcel, 28, paramny.y, true);
        }
        c.a(paramParcel, i);
    }

    public ny a(Parcel paramParcel) {
        int i2 = a.b(paramParcel);
        HashSet localHashSet = new HashSet();
        int i1 = 0;
        String str10 = null;
        ny.a locala = null;
        String str9 = null;
        String str8 = null;
        int n = 0;
        ny.b localb = null;
        String str7 = null;
        String str6 = null;
        int m = 0;
        String str5 = null;
        ny.c localc = null;
        boolean bool2 = false;
        String str4 = null;
        ny.d locald = null;
        String str3 = null;
        int k = 0;
        ArrayList localArrayList3 = null;
        ArrayList localArrayList2 = null;
        int j = 0;
        int i = 0;
        String str2 = null;
        String str1 = null;
        ArrayList localArrayList1 = null;
        boolean bool1 = false;
        while (paramParcel.dataPosition() < i2) {
            int i3 = a.a(paramParcel);
            switch (a.a(i3)) {
                case 10:
                case 11:
                case 13:
                case 17:
                default:
                    a.b(paramParcel, i3);
                    break;
                case 1:
                    i1 = a.g(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str10 = a.o(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    locala = (ny.a) a.a(paramParcel, i3, ny.a.CREATOR);
                    localHashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str9 = a.o(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str8 = a.o(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    n = a.g(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    localb = (ny.b) a.a(paramParcel, i3, ny.b.CREATOR);
                    localHashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str7 = a.o(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str6 = a.o(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(9));
                    break;
                case 12:
                    m = a.g(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(12));
                    break;
                case 14:
                    str5 = a.o(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    localc = (ny.c) a.a(paramParcel, i3, ny.c.CREATOR);
                    localHashSet.add(Integer.valueOf(15));
                    break;
                case 16:
                    bool2 = a.c(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(16));
                    break;
                case 19:
                    locald = (ny.d) a.a(paramParcel, i3, ny.d.CREATOR);
                    localHashSet.add(Integer.valueOf(19));
                    break;
                case 18:
                    str4 = a.o(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(18));
                    break;
                case 21:
                    k = a.g(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(21));
                    break;
                case 20:
                    str3 = a.o(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(20));
                    break;
                case 23:
                    localArrayList2 = a.c(paramParcel, i3, ny.g.CREATOR);
                    localHashSet.add(Integer.valueOf(23));
                    break;
                case 22:
                    localArrayList3 = a.c(paramParcel, i3, ny.f.CREATOR);
                    localHashSet.add(Integer.valueOf(22));
                    break;
                case 25:
                    i = a.g(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(25));
                    break;
                case 24:
                    j = a.g(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(24));
                    break;
                case 27:
                    str1 = a.o(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(27));
                    break;
                case 26:
                    str2 = a.o(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(26));
                    break;
                case 29:
                    bool1 = a.c(paramParcel, i3);
                    localHashSet.add(Integer.valueOf(29));
                    break;
                case 28:
                    localArrayList1 = a.c(paramParcel, i3, ny.h.CREATOR);
                    localHashSet.add(Integer.valueOf(28));
            }
        }
        if (paramParcel.dataPosition() != i2) {
            throw new b("Overread allowed size end=" + i2, paramParcel);
        }
        return new ny(localHashSet, i1, str10, locala, str9, str8, n, localb, str7, str6, m, str5, localc, bool2, str4, locald, str3, k, localArrayList3, localArrayList2, j, i, str2, str1, localArrayList1, bool1);
    }

    public ny[] a(int paramInt) {
        return new ny[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/rw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */