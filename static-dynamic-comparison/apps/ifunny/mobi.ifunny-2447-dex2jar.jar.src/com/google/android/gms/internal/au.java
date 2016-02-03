package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class au
        implements Parcelable.Creator<ay> {
    static void a(ay paramay, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramay.a);
        c.a(paramParcel, 2, paramay.b, false);
        c.a(paramParcel, 3, paramay.c);
        c.a(paramParcel, 4, paramay.d);
        c.a(paramParcel, 5, paramay.e);
        c.a(paramParcel, 6, paramay.f);
        c.a(paramParcel, 7, paramay.g);
        c.a(paramParcel, 8, paramay.h, paramInt, false);
        c.a(paramParcel, i);
    }

    public ay a(Parcel paramParcel) {
        ay[] arrayOfay = null;
        int i = 0;
        int i1 = a.b(paramParcel);
        int j = 0;
        boolean bool = false;
        int k = 0;
        int m = 0;
        String str = null;
        int n = 0;
        while (paramParcel.dataPosition() < i1) {
            int i2 = a.a(paramParcel);
            switch (a.a(i2)) {
                default:
                    a.b(paramParcel, i2);
                    break;
                case 1:
                    n = a.g(paramParcel, i2);
                    break;
                case 2:
                    str = a.o(paramParcel, i2);
                    break;
                case 3:
                    m = a.g(paramParcel, i2);
                    break;
                case 4:
                    k = a.g(paramParcel, i2);
                    break;
                case 5:
                    bool = a.c(paramParcel, i2);
                    break;
                case 6:
                    j = a.g(paramParcel, i2);
                    break;
                case 7:
                    i = a.g(paramParcel, i2);
                    break;
                case 8:
                    arrayOfay = (ay[]) a.b(paramParcel, i2, ay.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != i1) {
            throw new b("Overread allowed size end=" + i1, paramParcel);
        }
        return new ay(n, str, m, k, bool, j, i, arrayOfay);
    }

    public ay[] a(int paramInt) {
        return new ay[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */