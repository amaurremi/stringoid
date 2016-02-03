package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

import java.util.ArrayList;

public class ai
        implements Parcelable.Creator<ah> {
    static void a(ah paramah, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramah.versionCode);
        b.a(paramParcel, 2, paramah.lH);
        b.a(paramParcel, 3, paramah.extras, false);
        b.c(paramParcel, 4, paramah.lI);
        b.a(paramParcel, 5, paramah.lJ, false);
        b.a(paramParcel, 6, paramah.lK);
        b.c(paramParcel, 7, paramah.lL);
        b.a(paramParcel, 8, paramah.lM);
        b.a(paramParcel, 9, paramah.lN, false);
        b.a(paramParcel, 10, paramah.lO, paramInt, false);
        b.a(paramParcel, 11, paramah.lP, paramInt, false);
        b.a(paramParcel, 12, paramah.lQ, false);
        b.F(paramParcel, i);
    }

    public ah a(Parcel paramParcel) {
        int m = a.o(paramParcel);
        int k = 0;
        long l = 0L;
        Bundle localBundle = null;
        int j = 0;
        ArrayList localArrayList = null;
        boolean bool2 = false;
        int i = 0;
        boolean bool1 = false;
        String str2 = null;
        av localav = null;
        Location localLocation = null;
        String str1 = null;
        while (paramParcel.dataPosition() < m) {
            int n = a.n(paramParcel);
            switch (a.R(n)) {
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
                    localBundle = a.p(paramParcel, n);
                    break;
                case 4:
                    j = a.g(paramParcel, n);
                    break;
                case 5:
                    localArrayList = a.A(paramParcel, n);
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
                    str2 = a.n(paramParcel, n);
                    break;
                case 10:
                    localav = (av) a.a(paramParcel, n, av.CREATOR);
                    break;
                case 11:
                    localLocation = (Location) a.a(paramParcel, n, Location.CREATOR);
                    break;
                case 12:
                    str1 = a.n(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new a.a("Overread allowed size end=" + m, paramParcel);
        }
        return new ah(k, l, localBundle, j, localArrayList, bool2, i, bool1, str2, localav, localLocation, str1);
    }

    public ah[] b(int paramInt) {
        return new ah[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */