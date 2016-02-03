package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class gh
        implements Parcelable.Creator<gg> {
    static void a(gg paramgg, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramgg.getVersionCode());
        b.a(paramParcel, 2, paramgg.fq(), false);
        b.a(paramParcel, 3, paramgg.fr(), paramInt, false);
        b.F(paramParcel, i);
    }

    public gg[] Z(int paramInt) {
        return new gg[paramInt];
    }

    public gg x(Parcel paramParcel) {
        gd localgd = null;
        int j = a.o(paramParcel);
        int i = 0;
        Parcel localParcel = null;
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
                    localParcel = a.B(paramParcel, k);
                    break;
                case 3:
                    localgd = (gd) a.a(paramParcel, k, gd.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new gg(i, localParcel, localgd);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */