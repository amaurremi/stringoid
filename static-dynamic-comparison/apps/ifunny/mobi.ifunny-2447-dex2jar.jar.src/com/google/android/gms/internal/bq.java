package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class bq
        implements Parcelable.Creator<bj> {
    static void a(bj parambj, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, parambj.a);
        c.a(paramParcel, 2, parambj.b);
        c.a(paramParcel, 3, parambj.c);
        c.a(paramParcel, 4, parambj.d);
        c.a(paramParcel, 5, parambj.e);
        c.a(paramParcel, 6, parambj.f);
        c.a(paramParcel, 7, parambj.g);
        c.a(paramParcel, 8, parambj.h);
        c.a(paramParcel, 9, parambj.i);
        c.a(paramParcel, 10, parambj.j, false);
        c.a(paramParcel, 11, parambj.k);
        c.a(paramParcel, 12, parambj.l, false);
        c.a(paramParcel, 13, parambj.m);
        c.a(paramParcel, 14, parambj.n);
        c.a(paramParcel, 15, parambj.o, false);
        c.a(paramParcel, paramInt);
    }

    public bj a(Parcel paramParcel) {
        int i8 = a.b(paramParcel);
        int i7 = 0;
        int i6 = 0;
        int i5 = 0;
        int i4 = 0;
        int i3 = 0;
        int i2 = 0;
        int i1 = 0;
        int n = 0;
        int m = 0;
        String str3 = null;
        int k = 0;
        String str2 = null;
        int j = 0;
        int i = 0;
        String str1 = null;
        while (paramParcel.dataPosition() < i8) {
            int i9 = a.a(paramParcel);
            switch (a.a(i9)) {
                default:
                    a.b(paramParcel, i9);
                    break;
                case 1:
                    i7 = a.g(paramParcel, i9);
                    break;
                case 2:
                    i6 = a.g(paramParcel, i9);
                    break;
                case 3:
                    i5 = a.g(paramParcel, i9);
                    break;
                case 4:
                    i4 = a.g(paramParcel, i9);
                    break;
                case 5:
                    i3 = a.g(paramParcel, i9);
                    break;
                case 6:
                    i2 = a.g(paramParcel, i9);
                    break;
                case 7:
                    i1 = a.g(paramParcel, i9);
                    break;
                case 8:
                    n = a.g(paramParcel, i9);
                    break;
                case 9:
                    m = a.g(paramParcel, i9);
                    break;
                case 10:
                    str3 = a.o(paramParcel, i9);
                    break;
                case 11:
                    k = a.g(paramParcel, i9);
                    break;
                case 12:
                    str2 = a.o(paramParcel, i9);
                    break;
                case 13:
                    j = a.g(paramParcel, i9);
                    break;
                case 14:
                    i = a.g(paramParcel, i9);
                    break;
                case 15:
                    str1 = a.o(paramParcel, i9);
            }
        }
        if (paramParcel.dataPosition() != i8) {
            throw new b("Overread allowed size end=" + i8, paramParcel);
        }
        return new bj(i7, i6, i5, i4, i3, i2, i1, n, m, str3, k, str2, j, i, str1);
    }

    public bj[] a(int paramInt) {
        return new bj[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */