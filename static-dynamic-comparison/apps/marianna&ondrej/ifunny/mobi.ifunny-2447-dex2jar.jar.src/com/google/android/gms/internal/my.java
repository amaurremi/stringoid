package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class my
        implements Parcelable.Creator<gt> {
    static void a(gt paramgt, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramgt.a);
        c.a(paramParcel, 2, paramgt.b, false);
        c.a(paramParcel, 3, paramgt.c);
        c.a(paramParcel, 4, paramgt.d);
        c.a(paramParcel, 5, paramgt.e);
        c.a(paramParcel, paramInt);
    }

    public gt a(Parcel paramParcel) {
        boolean bool = false;
        int m = a.b(paramParcel);
        String str = null;
        int i = 0;
        int j = 0;
        int k = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    str = a.o(paramParcel, n);
                    break;
                case 3:
                    j = a.g(paramParcel, n);
                    break;
                case 4:
                    i = a.g(paramParcel, n);
                    break;
                case 5:
                    bool = a.c(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new gt(k, str, j, i, bool);
    }

    public gt[] a(int paramInt) {
        return new gt[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/my.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */