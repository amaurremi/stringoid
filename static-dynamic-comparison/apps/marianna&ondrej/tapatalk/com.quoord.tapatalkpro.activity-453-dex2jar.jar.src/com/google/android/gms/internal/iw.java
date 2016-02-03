package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class iw
        implements Parcelable.Creator<iv> {
    static void a(iv paramiv, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramiv.getVersionCode());
        b.a(paramParcel, 2, paramiv.acs, false);
        b.F(paramParcel, paramInt);
    }

    public iv bl(Parcel paramParcel) {
        int j = a.o(paramParcel);
        int i = 0;
        int[] arrayOfInt = null;
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
                    arrayOfInt = a.t(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new iv(i, arrayOfInt);
    }

    public iv[] cx(int paramInt) {
        return new iv[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/iw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */