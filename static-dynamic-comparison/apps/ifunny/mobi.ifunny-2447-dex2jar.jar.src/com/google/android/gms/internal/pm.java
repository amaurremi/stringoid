package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class pm
        implements Parcelable.Creator<jp> {
    static void a(jp paramjp, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramjp.a());
        c.a(paramParcel, 2, paramjp.e(), false);
        c.a(paramParcel, 3, paramjp.f(), paramInt, false);
        c.a(paramParcel, i);
    }

    public jp a(Parcel paramParcel) {
        jm localjm = null;
        int j = a.b(paramParcel);
        int i = 0;
        Parcel localParcel = null;
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
                    localParcel = a.D(paramParcel, k);
                    break;
                case 3:
                    localjm = (jm) a.a(paramParcel, k, jm.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new jp(i, localParcel, localjm);
    }

    public jp[] a(int paramInt) {
        return new jp[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */