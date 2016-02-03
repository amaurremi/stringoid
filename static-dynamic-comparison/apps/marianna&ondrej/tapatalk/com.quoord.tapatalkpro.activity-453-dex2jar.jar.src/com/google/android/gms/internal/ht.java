package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ht
        implements Parcelable.Creator<hs> {
    static void a(hs paramhs, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.a(paramParcel, 1, paramhs.Rl, false);
        b.c(paramParcel, 1000, paramhs.versionCode);
        b.a(paramParcel, 2, paramhs.Rm, false);
        b.F(paramParcel, paramInt);
    }

    public hs aI(Parcel paramParcel) {
        String str2 = null;
        int j = a.o(paramParcel);
        int i = 0;
        String str1 = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    str1 = a.n(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    str2 = a.n(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new hs(i, str1, str2);
    }

    public hs[] bJ(int paramInt) {
        return new hs[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */