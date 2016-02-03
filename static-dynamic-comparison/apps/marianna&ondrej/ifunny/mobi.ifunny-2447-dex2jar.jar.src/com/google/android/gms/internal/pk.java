package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class pk
        implements Parcelable.Creator<jm> {
    static void a(jm paramjm, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramjm.b());
        c.c(paramParcel, 2, paramjm.c(), false);
        c.a(paramParcel, 3, paramjm.d(), false);
        c.a(paramParcel, paramInt);
    }

    public jm a(Parcel paramParcel) {
        String str = null;
        int j = a.b(paramParcel);
        int i = 0;
        ArrayList localArrayList = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localArrayList = a.c(paramParcel, k, jm.a.CREATOR);
                    break;
                case 3:
                    str = a.o(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new jm(i, localArrayList, str);
    }

    public jm[] a(int paramInt) {
        return new jm[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */