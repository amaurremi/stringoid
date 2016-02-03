package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class pi
        implements Parcelable.Creator<ji.a> {
    static void a(ji.a parama, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, parama.a());
        c.a(paramParcel, 2, parama.b());
        c.a(paramParcel, 3, parama.c());
        c.a(paramParcel, 4, parama.d());
        c.a(paramParcel, 5, parama.e());
        c.a(paramParcel, 6, parama.f(), false);
        c.a(paramParcel, 7, parama.g());
        c.a(paramParcel, 8, parama.i(), false);
        c.a(paramParcel, 9, parama.k(), paramInt, false);
        c.a(paramParcel, i);
    }

    public ji.a a(Parcel paramParcel) {
        jd localjd = null;
        int i = 0;
        int n = a.b(paramParcel);
        String str1 = null;
        String str2 = null;
        boolean bool1 = false;
        int j = 0;
        boolean bool2 = false;
        int k = 0;
        int m = 0;
        while (paramParcel.dataPosition() < n) {
            int i1 = a.a(paramParcel);
            switch (a.a(i1)) {
                default:
                    a.b(paramParcel, i1);
                    break;
                case 1:
                    m = a.g(paramParcel, i1);
                    break;
                case 2:
                    k = a.g(paramParcel, i1);
                    break;
                case 3:
                    bool2 = a.c(paramParcel, i1);
                    break;
                case 4:
                    j = a.g(paramParcel, i1);
                    break;
                case 5:
                    bool1 = a.c(paramParcel, i1);
                    break;
                case 6:
                    str2 = a.o(paramParcel, i1);
                    break;
                case 7:
                    i = a.g(paramParcel, i1);
                    break;
                case 8:
                    str1 = a.o(paramParcel, i1);
                    break;
                case 9:
                    localjd = (jd) a.a(paramParcel, i1, jd.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != n) {
            throw new b("Overread allowed size end=" + n, paramParcel);
        }
        return new ji.a(m, k, bool2, j, bool1, str2, i, str1, localjd);
    }

    public ji.a[] a(int paramInt) {
        return new ji.a[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */