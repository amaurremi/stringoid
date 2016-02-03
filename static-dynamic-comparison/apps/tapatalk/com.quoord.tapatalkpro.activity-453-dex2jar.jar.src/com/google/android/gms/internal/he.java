package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class he
        implements Parcelable.Creator<hd> {
    static void a(hd paramhd, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.a(paramParcel, 1, paramhd.getRequestId(), false);
        b.c(paramParcel, 1000, paramhd.getVersionCode());
        b.a(paramParcel, 2, paramhd.getExpirationTime());
        b.a(paramParcel, 3, paramhd.hS());
        b.a(paramParcel, 4, paramhd.getLatitude());
        b.a(paramParcel, 5, paramhd.getLongitude());
        b.a(paramParcel, 6, paramhd.hT());
        b.c(paramParcel, 7, paramhd.hU());
        b.c(paramParcel, 8, paramhd.getNotificationResponsiveness());
        b.c(paramParcel, 9, paramhd.hV());
        b.F(paramParcel, paramInt);
    }

    public hd aC(Parcel paramParcel) {
        int n = a.o(paramParcel);
        int m = 0;
        String str = null;
        int k = 0;
        short s = 0;
        double d2 = 0.0D;
        double d1 = 0.0D;
        float f = 0.0F;
        long l = 0L;
        int j = 0;
        int i = -1;
        while (paramParcel.dataPosition() < n) {
            int i1 = a.n(paramParcel);
            switch (a.R(i1)) {
                default:
                    a.b(paramParcel, i1);
                    break;
                case 1:
                    str = a.n(paramParcel, i1);
                    break;
                case 1000:
                    m = a.g(paramParcel, i1);
                    break;
                case 2:
                    l = a.i(paramParcel, i1);
                    break;
                case 3:
                    s = a.f(paramParcel, i1);
                    break;
                case 4:
                    d2 = a.l(paramParcel, i1);
                    break;
                case 5:
                    d1 = a.l(paramParcel, i1);
                    break;
                case 6:
                    f = a.k(paramParcel, i1);
                    break;
                case 7:
                    k = a.g(paramParcel, i1);
                    break;
                case 8:
                    j = a.g(paramParcel, i1);
                    break;
                case 9:
                    i = a.g(paramParcel, i1);
            }
        }
        if (paramParcel.dataPosition() != n) {
            throw new a.a("Overread allowed size end=" + n, paramParcel);
        }
        return new hd(m, str, k, s, d2, d1, f, l, j, i);
    }

    public hd[] bD(int paramInt) {
        return new hd[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/he.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */