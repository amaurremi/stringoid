package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class c
        implements Parcelable.Creator<b> {
    static void a(b paramb, Parcel paramParcel, int paramInt) {
        paramInt = com.google.android.gms.common.internal.safeparcel.b.p(paramParcel);
        com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramb.Oh);
        com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1000, paramb.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 2, paramb.Oi);
        com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramb.Oj);
        com.google.android.gms.common.internal.safeparcel.b.F(paramParcel, paramInt);
    }

    public b aB(Parcel paramParcel) {
        int i = 1;
        int m = a.o(paramParcel);
        int k = 0;
        long l = 0L;
        int j = 1;
        while (paramParcel.dataPosition() < m) {
            int n = a.n(paramParcel);
            switch (a.R(n)) {
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
            throw new a.a("Overread allowed size end=" + m, paramParcel);
        }
        return new b(k, j, i, l);
    }

    public b[] bA(int paramInt) {
        return new b[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/location/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */