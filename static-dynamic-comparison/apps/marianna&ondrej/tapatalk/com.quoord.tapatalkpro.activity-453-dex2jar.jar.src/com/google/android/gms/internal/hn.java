package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hn
        implements Parcelable.Creator<hm> {
    static void a(hm paramhm, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.a(paramParcel, 1, paramhm.Rd, false);
        b.c(paramParcel, 1000, paramhm.xH);
        b.F(paramParcel, paramInt);
    }

    public hm aG(Parcel paramParcel) {
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
                    str = a.n(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new hm(i, str);
    }

    public hm[] bH(int paramInt) {
        return new hm[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/hn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */