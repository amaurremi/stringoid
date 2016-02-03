package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class k
        implements Parcelable.Creator<g> {
    static void a(g paramg, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramg.a());
        c.a(paramParcel, 2, paramg.a);
        c.a(paramParcel, 3, paramg.b, false);
        c.a(paramParcel, 4, paramg.c);
        c.a(paramParcel, 5, paramg.d, false);
        c.a(paramParcel, 6, paramg.e);
        c.a(paramParcel, 7, paramg.f);
        c.a(paramParcel, paramInt);
    }

    public g a(Parcel paramParcel) {
        String str1 = null;
        int j = 0;
        int m = a.b(paramParcel);
        double d = 0.0D;
        long l = 0L;
        int i = -1;
        String str2 = null;
        int k = 0;
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
                    j = a.g(paramParcel, n);
                    break;
                case 3:
                    str2 = a.o(paramParcel, n);
                    break;
                case 4:
                    d = a.m(paramParcel, n);
                    break;
                case 5:
                    str1 = a.o(paramParcel, n);
                    break;
                case 6:
                    l = a.i(paramParcel, n);
                    break;
                case 7:
                    i = a.g(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new g(k, j, str2, d, str1, l, i);
    }

    public g[] a(int paramInt) {
        return new g[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/wobs/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */