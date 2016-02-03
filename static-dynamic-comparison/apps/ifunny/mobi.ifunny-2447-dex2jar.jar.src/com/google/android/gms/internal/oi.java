package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class oi
        implements Parcelable.Creator<hs> {
    static void a(hs paramhs, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramhs.b, paramInt, false);
        c.a(paramParcel, 1000, paramhs.a);
        c.a(paramParcel, 2, paramhs.c);
        c.a(paramParcel, 3, paramhs.d);
        c.a(paramParcel, 4, paramhs.e, false);
        c.a(paramParcel, 5, paramhs.f, paramInt, false);
        c.a(paramParcel, i);
    }

    public hs a(Parcel paramParcel) {
        int i = 0;
        he localhe = null;
        int k = a.b(paramParcel);
        long l = 0L;
        String str = null;
        hg localhg = null;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    localhg = (hg) a.a(paramParcel, m, hg.CREATOR);
                    break;
                case 1000:
                    j = a.g(paramParcel, m);
                    break;
                case 2:
                    l = a.i(paramParcel, m);
                    break;
                case 3:
                    i = a.g(paramParcel, m);
                    break;
                case 4:
                    str = a.o(paramParcel, m);
                    break;
                case 5:
                    localhe = (he) a.a(paramParcel, m, he.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new hs(j, localhg, l, i, str, localhe);
    }

    public hs[] a(int paramInt) {
        return new hs[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/oi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */