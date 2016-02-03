package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class to
        implements Parcelable.Creator<x> {
    static void a(x paramx, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramx.a);
        c.a(paramParcel, 2, paramx.b);
        c.a(paramParcel, 3, paramx.c);
        c.a(paramParcel, paramInt);
    }

    public x a(Parcel paramParcel) {
        boolean bool2 = false;
        int j = a.b(paramParcel);
        boolean bool1 = false;
        int i = 0;
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
                    bool1 = a.c(paramParcel, k);
                    break;
                case 3:
                    bool2 = a.c(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new x(i, bool1, bool2);
    }

    public x[] a(int paramInt) {
        return new x[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/to.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */