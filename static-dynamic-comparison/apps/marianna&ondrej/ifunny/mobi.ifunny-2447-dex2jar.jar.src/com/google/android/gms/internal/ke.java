package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class ke
        implements Parcelable.Creator<fk> {
    static void a(fk paramfk, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramfk.a);
        c.a(paramParcel, 2, paramfk.b, false);
        c.a(paramParcel, 3, paramfk.c, false);
        c.b(paramParcel, 4, paramfk.d, false);
        c.a(paramParcel, 5, paramfk.e);
        c.b(paramParcel, 6, paramfk.f, false);
        c.a(paramParcel, 7, paramfk.g);
        c.a(paramParcel, 8, paramfk.h);
        c.a(paramParcel, 9, paramfk.i);
        c.b(paramParcel, 10, paramfk.j, false);
        c.a(paramParcel, 11, paramfk.k);
        c.a(paramParcel, 12, paramfk.l);
        c.a(paramParcel, 13, paramfk.m, false);
        c.a(paramParcel, 14, paramfk.n);
        c.a(paramParcel, 15, paramfk.o, false);
        c.a(paramParcel, 19, paramfk.q, false);
        c.a(paramParcel, 18, paramfk.p);
        c.a(paramParcel, 21, paramfk.r, false);
        c.a(paramParcel, 23, paramfk.t);
        c.a(paramParcel, 22, paramfk.s);
        c.a(paramParcel, 25, paramfk.v);
        c.a(paramParcel, 24, paramfk.u);
        c.a(paramParcel, paramInt);
    }

    public fk a(Parcel paramParcel) {
        int m = a.b(paramParcel);
        int k = 0;
        String str6 = null;
        String str5 = null;
        ArrayList localArrayList3 = null;
        int j = 0;
        ArrayList localArrayList2 = null;
        long l4 = 0L;
        boolean bool6 = false;
        long l3 = 0L;
        ArrayList localArrayList1 = null;
        long l2 = 0L;
        int i = 0;
        String str4 = null;
        long l1 = 0L;
        String str3 = null;
        boolean bool5 = false;
        String str2 = null;
        String str1 = null;
        boolean bool4 = false;
        boolean bool3 = false;
        boolean bool2 = false;
        boolean bool1 = false;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                case 16:
                case 17:
                case 20:
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    str6 = a.o(paramParcel, n);
                    break;
                case 3:
                    str5 = a.o(paramParcel, n);
                    break;
                case 4:
                    localArrayList3 = a.C(paramParcel, n);
                    break;
                case 5:
                    j = a.g(paramParcel, n);
                    break;
                case 6:
                    localArrayList2 = a.C(paramParcel, n);
                    break;
                case 7:
                    l4 = a.i(paramParcel, n);
                    break;
                case 8:
                    bool6 = a.c(paramParcel, n);
                    break;
                case 9:
                    l3 = a.i(paramParcel, n);
                    break;
                case 10:
                    localArrayList1 = a.C(paramParcel, n);
                    break;
                case 11:
                    l2 = a.i(paramParcel, n);
                    break;
                case 12:
                    i = a.g(paramParcel, n);
                    break;
                case 13:
                    str4 = a.o(paramParcel, n);
                    break;
                case 14:
                    l1 = a.i(paramParcel, n);
                    break;
                case 15:
                    str3 = a.o(paramParcel, n);
                    break;
                case 19:
                    str2 = a.o(paramParcel, n);
                    break;
                case 18:
                    bool5 = a.c(paramParcel, n);
                    break;
                case 21:
                    str1 = a.o(paramParcel, n);
                    break;
                case 23:
                    bool3 = a.c(paramParcel, n);
                    break;
                case 22:
                    bool4 = a.c(paramParcel, n);
                    break;
                case 25:
                    bool1 = a.c(paramParcel, n);
                    break;
                case 24:
                    bool2 = a.c(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new fk(k, str6, str5, localArrayList3, j, localArrayList2, l4, bool6, l3, localArrayList1, l2, i, str4, l1, str3, bool5, str2, str1, bool4, bool3, bool2, bool1);
    }

    public fk[] a(int paramInt) {
        return new fk[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */