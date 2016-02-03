package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class ra
        implements Parcelable.Creator<mb> {
    static void a(mb parammb, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, parammb.f(), false);
        c.a(paramParcel, 1000, parammb.a());
        c.a(paramParcel, 2, parammb.g());
        c.a(paramParcel, 3, parammb.b());
        c.a(paramParcel, 4, parammb.c());
        c.a(paramParcel, 5, parammb.d());
        c.a(paramParcel, 6, parammb.e());
        c.a(paramParcel, 7, parammb.h());
        c.a(paramParcel, 8, parammb.i());
        c.a(paramParcel, 9, parammb.j());
        c.a(paramParcel, paramInt);
    }

    public mb a(Parcel paramParcel) {
        int n = a.b(paramParcel);
        int m = 0;
        String str = null;
        int k = 0;
        short s = 0;
        double d2 = 0.0D;
        double d1 = 0.0D;
        float f = 0.0F;
        long l = 0L;
        int j = 0;
        int i = -1;
        while (paramParcel.dataPosition() < n) {
            int i1 = a.a(paramParcel);
            switch (a.a(i1)) {
                default:
                    a.b(paramParcel, i1);
                    break;
                case 1:
                    str = a.o(paramParcel, i1);
                    break;
                case 1000:
                    m = a.g(paramParcel, i1);
                    break;
                case 2:
                    l = a.i(paramParcel, i1);
                    break;
                case 3:
                    s = a.f(paramParcel, i1);
                    break;
                case 4:
                    d2 = a.m(paramParcel, i1);
                    break;
                case 5:
                    d1 = a.m(paramParcel, i1);
                    break;
                case 6:
                    f = a.l(paramParcel, i1);
                    break;
                case 7:
                    k = a.g(paramParcel, i1);
                    break;
                case 8:
                    j = a.g(paramParcel, i1);
                    break;
                case 9:
                    i = a.g(paramParcel, i1);
            }
        }
        if (paramParcel.dataPosition() != n) {
            throw new b("Overread allowed size end=" + n, paramParcel);
        }
        return new mb(m, str, k, s, d2, d1, f, l, j, i);
    }

    public mb[] a(int paramInt) {
        return new mb[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */