package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g
        implements Parcelable.Creator<c> {
    static void a(c paramc, Parcel paramParcel, int paramInt) {
        paramInt = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramc.a);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1000, paramc.a());
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramc.b);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramc.c);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, paramInt);
    }

    public c a(Parcel paramParcel) {
        int i = 1;
        int m = a.b(paramParcel);
        int k = 0;
        long l = 0L;
        int j = 1;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    j = a.g(paramParcel, n);
                    break;
                case 1000:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    i = a.g(paramParcel, n);
                    break;
                case 3:
                    l = a.i(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new c(k, j, i, l);
    }

    public c[] a(int paramInt) {
        return new c[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/location/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */