package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jz
        implements Parcelable.Creator<jy> {
    static void a(jy paramjy, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramjy.getVersionCode());
        b.a(paramParcel, 2, paramjy.adn, false);
        b.a(paramParcel, 3, paramjy.pm, false);
        b.a(paramParcel, 4, paramjy.adr, paramInt, false);
        b.a(paramParcel, 5, paramjy.ads, paramInt, false);
        b.a(paramParcel, 6, paramjy.adt, paramInt, false);
        b.F(paramParcel, i);
    }

    public jy bx(Parcel paramParcel) {
        jw localjw1 = null;
        int j = a.o(paramParcel);
        int i = 0;
        jw localjw2 = null;
        ju localju = null;
        String str1 = null;
        String str2 = null;
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
                    str2 = a.n(paramParcel, k);
                    break;
                case 3:
                    str1 = a.n(paramParcel, k);
                    break;
                case 4:
                    localju = (ju) a.a(paramParcel, k, ju.CREATOR);
                    break;
                case 5:
                    localjw2 = (jw) a.a(paramParcel, k, jw.CREATOR);
                    break;
                case 6:
                    localjw1 = (jw) a.a(paramParcel, k, jw.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new jy(i, str2, str1, localju, localjw2, localjw1);
    }

    public jy[] cL(int paramInt) {
        return new jy[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/jz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */