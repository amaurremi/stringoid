package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class pj
        implements Parcelable.Creator<jm.b> {
    static void a(jm.b paramb, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramb.a);
        c.a(paramParcel, 2, paramb.b, false);
        c.a(paramParcel, 3, paramb.c, paramInt, false);
        c.a(paramParcel, i);
    }

    public jm.b a(Parcel paramParcel) {
        ji.a locala = null;
        int j = a.b(paramParcel);
        int i = 0;
        String str = null;
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
                    str = a.o(paramParcel, k);
                    break;
                case 3:
                    locala = (ji.a) a.a(paramParcel, k, ji.a.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new jm.b(i, str, locala);
    }

    public jm.b[] a(int paramInt) {
        return new jm.b[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */