package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class rg
        implements Parcelable.Creator<mo> {
    static void a(mo parammo, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, parammo.bx, false);
        c.a(paramParcel, 1000, parammo.bw);
        c.a(paramParcel, paramInt);
    }

    public mo a(Parcel paramParcel) {
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
                    str = a.o(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new mo(i, str);
    }

    public mo[] a(int paramInt) {
        return new mo[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/rg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */