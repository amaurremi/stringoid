package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class rc
        implements Parcelable.Creator<mg> {
    static void a(mg parammg, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, parammg.b());
        c.a(paramParcel, 1000, parammg.a());
        c.a(paramParcel, 2, parammg.c());
        c.a(paramParcel, 3, parammg.d(), paramInt, false);
        c.a(paramParcel, i);
    }

    public mg a(Parcel paramParcel) {
        int j = 0;
        int m = a.b(paramParcel);
        int k = -1;
        mi localmi = null;
        int i = 0;
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
                    i = a.g(paramParcel, n);
                    break;
                case 2:
                    k = a.g(paramParcel, n);
                    break;
                case 3:
                    localmi = (mi) a.a(paramParcel, n, mi.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new mg(i, j, k, localmi);
    }

    public mg[] a(int paramInt) {
        return new mg[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/rc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */