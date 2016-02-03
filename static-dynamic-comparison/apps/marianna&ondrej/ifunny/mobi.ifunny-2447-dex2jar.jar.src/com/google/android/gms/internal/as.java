package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class as
        implements Parcelable.Creator<av> {
    static void a(av paramav, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramav.a);
        c.a(paramParcel, 2, paramav.b);
        c.a(paramParcel, 3, paramav.c, false);
        c.a(paramParcel, 4, paramav.d);
        c.b(paramParcel, 5, paramav.e, false);
        c.a(paramParcel, 6, paramav.f);
        c.a(paramParcel, 7, paramav.g);
        c.a(paramParcel, 8, paramav.h);
        c.a(paramParcel, 9, paramav.i, false);
        c.a(paramParcel, 10, paramav.j, paramInt, false);
        c.a(paramParcel, 11, paramav.k, paramInt, false);
        c.a(paramParcel, 12, paramav.l, false);
        c.a(paramParcel, 13, paramav.m, false);
        c.a(paramParcel, i);
    }

    public av a(Parcel paramParcel) {
        int m = a.b(paramParcel);
        int k = 0;
        long l = 0L;
        Bundle localBundle2 = null;
        int j = 0;
        ArrayList localArrayList = null;
        boolean bool2 = false;
        int i = 0;
        boolean bool1 = false;
        String str2 = null;
        bj localbj = null;
        Location localLocation = null;
        String str1 = null;
        Bundle localBundle1 = null;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    l = a.i(paramParcel, n);
                    break;
                case 3:
                    localBundle2 = a.q(paramParcel, n);
                    break;
                case 4:
                    j = a.g(paramParcel, n);
                    break;
                case 5:
                    localArrayList = a.C(paramParcel, n);
                    break;
                case 6:
                    bool2 = a.c(paramParcel, n);
                    break;
                case 7:
                    i = a.g(paramParcel, n);
                    break;
                case 8:
                    bool1 = a.c(paramParcel, n);
                    break;
                case 9:
                    str2 = a.o(paramParcel, n);
                    break;
                case 10:
                    localbj = (bj) a.a(paramParcel, n, bj.CREATOR);
                    break;
                case 11:
                    localLocation = (Location) a.a(paramParcel, n, Location.CREATOR);
                    break;
                case 12:
                    str1 = a.o(paramParcel, n);
                    break;
                case 13:
                    localBundle1 = a.q(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new av(k, l, localBundle2, j, localArrayList, bool2, i, bool1, str2, localbj, localLocation, str1, localBundle1);
    }

    public av[] a(int paramInt) {
        return new av[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */