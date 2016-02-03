package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class fp
        implements Parcelable.Creator<dm> {
    static void a(dm paramdm, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramdm.a);
        c.a(paramParcel, 2, paramdm.b, paramInt, false);
        c.a(paramParcel, 3, paramdm.a(), false);
        c.a(paramParcel, 4, paramdm.b(), false);
        c.a(paramParcel, 5, paramdm.c(), false);
        c.a(paramParcel, 6, paramdm.d(), false);
        c.a(paramParcel, 7, paramdm.g, false);
        c.a(paramParcel, 8, paramdm.h);
        c.a(paramParcel, 9, paramdm.i, false);
        c.a(paramParcel, 10, paramdm.f(), false);
        c.a(paramParcel, 11, paramdm.k);
        c.a(paramParcel, 12, paramdm.l);
        c.a(paramParcel, 13, paramdm.m, false);
        c.a(paramParcel, 14, paramdm.n, paramInt, false);
        c.a(paramParcel, 15, paramdm.e(), false);
        c.a(paramParcel, 17, paramdm.q, paramInt, false);
        c.a(paramParcel, 16, paramdm.p, false);
        c.a(paramParcel, i);
    }

    public dm a(Parcel paramParcel) {
        int m = a.b(paramParcel);
        int k = 0;
        dj localdj = null;
        IBinder localIBinder6 = null;
        IBinder localIBinder5 = null;
        IBinder localIBinder4 = null;
        IBinder localIBinder3 = null;
        String str4 = null;
        boolean bool = false;
        String str3 = null;
        IBinder localIBinder2 = null;
        int j = 0;
        int i = 0;
        String str2 = null;
        gt localgt = null;
        IBinder localIBinder1 = null;
        String str1 = null;
        x localx = null;
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
                    localdj = (dj) a.a(paramParcel, n, dj.CREATOR);
                    break;
                case 3:
                    localIBinder6 = a.p(paramParcel, n);
                    break;
                case 4:
                    localIBinder5 = a.p(paramParcel, n);
                    break;
                case 5:
                    localIBinder4 = a.p(paramParcel, n);
                    break;
                case 6:
                    localIBinder3 = a.p(paramParcel, n);
                    break;
                case 7:
                    str4 = a.o(paramParcel, n);
                    break;
                case 8:
                    bool = a.c(paramParcel, n);
                    break;
                case 9:
                    str3 = a.o(paramParcel, n);
                    break;
                case 10:
                    localIBinder2 = a.p(paramParcel, n);
                    break;
                case 11:
                    j = a.g(paramParcel, n);
                    break;
                case 12:
                    i = a.g(paramParcel, n);
                    break;
                case 13:
                    str2 = a.o(paramParcel, n);
                    break;
                case 14:
                    localgt = (gt) a.a(paramParcel, n, gt.CREATOR);
                    break;
                case 15:
                    localIBinder1 = a.p(paramParcel, n);
                    break;
                case 17:
                    localx = (x) a.a(paramParcel, n, x.CREATOR);
                    break;
                case 16:
                    str1 = a.o(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new dm(k, localdj, localIBinder6, localIBinder5, localIBinder4, localIBinder3, str4, bool, str3, localIBinder2, j, i, str2, localgt, localIBinder1, str1, localx);
    }

    public dm[] a(int paramInt) {
        return new dm[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */