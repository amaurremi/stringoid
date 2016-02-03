package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

import java.util.ArrayList;

public class jn
        implements Parcelable.Creator<jm> {
    static void a(jm paramjm, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramjm.getVersionCode());
        b.a(paramParcel, 2, paramjm.add, false);
        b.a(paramParcel, 3, paramjm.ade, false);
        b.b(paramParcel, 4, paramjm.adf, false);
        b.F(paramParcel, paramInt);
    }

    public jm br(Parcel paramParcel) {
        String str2 = null;
        int j = a.o(paramParcel);
        int i = 0;
        ArrayList localArrayList = gi.fs();
        String str1 = null;
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
                    str1 = a.n(paramParcel, k);
                    break;
                case 3:
                    str2 = a.n(paramParcel, k);
                    break;
                case 4:
                    localArrayList = a.c(paramParcel, k, jk.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new jm(i, str1, str2, localArrayList);
    }

    public jm[] cF(int paramInt) {
        return new jm[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/jn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */