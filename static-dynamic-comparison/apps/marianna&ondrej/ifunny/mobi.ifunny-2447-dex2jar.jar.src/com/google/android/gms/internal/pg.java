package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class pg
        implements Parcelable.Creator<jf.a> {
    static void a(jf.a parama, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, parama.a);
        c.a(paramParcel, 2, parama.b, false);
        c.a(paramParcel, 3, parama.c);
        c.a(paramParcel, paramInt);
    }

    public jf.a a(Parcel paramParcel) {
        int j = 0;
        int k = a.b(paramParcel);
        String str = null;
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    str = a.o(paramParcel, m);
                    break;
                case 3:
                    j = a.g(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new jf.a(i, str, j);
    }

    public jf.a[] a(int paramInt) {
        return new jf.a[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */