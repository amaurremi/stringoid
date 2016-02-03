package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class gb
        implements Parcelable.Creator<ga.a> {
    static void a(ga.a parama, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, parama.getVersionCode());
        b.c(paramParcel, 2, parama.eW());
        b.a(paramParcel, 3, parama.fc());
        b.c(paramParcel, 4, parama.eX());
        b.a(paramParcel, 5, parama.fd());
        b.a(paramParcel, 6, parama.fe(), false);
        b.c(paramParcel, 7, parama.ff());
        b.a(paramParcel, 8, parama.fh(), false);
        b.a(paramParcel, 9, parama.fj(), paramInt, false);
        b.F(paramParcel, i);
    }

    public ga.a[] V(int paramInt) {
        return new ga.a[paramInt];
    }

    public ga.a t(Parcel paramParcel) {
        fv localfv = null;
        int i = 0;
        int n = a.o(paramParcel);
        String str1 = null;
        String str2 = null;
        boolean bool1 = false;
        int j = 0;
        boolean bool2 = false;
        int k = 0;
        int m = 0;
        while (paramParcel.dataPosition() < n) {
            int i1 = a.n(paramParcel);
            switch (a.R(i1)) {
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
                    str2 = a.n(paramParcel, i1);
                    break;
                case 7:
                    i = a.g(paramParcel, i1);
                    break;
                case 8:
                    str1 = a.n(paramParcel, i1);
                    break;
                case 9:
                    localfv = (fv) a.a(paramParcel, i1, fv.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != n) {
            throw new a.a("Overread allowed size end=" + n, paramParcel);
        }
        return new ga.a(m, k, bool2, j, bool1, str2, i, str1, localfv);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/gb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */