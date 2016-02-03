package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class gc
        implements Parcelable.Creator<gd.b> {
    static void a(gd.b paramb, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramb.versionCode);
        b.a(paramParcel, 2, paramb.eM, false);
        b.a(paramParcel, 3, paramb.Em, paramInt, false);
        b.F(paramParcel, i);
    }

    public gd.b[] W(int paramInt) {
        return new gd.b[paramInt];
    }

    public gd.b u(Parcel paramParcel) {
        ga.a locala = null;
        int j = a.o(paramParcel);
        int i = 0;
        String str = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    str = a.n(paramParcel, k);
                    break;
                case 3:
                    locala = (ga.a) a.a(paramParcel, k, ga.a.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new gd.b(i, str, locala);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/gc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */