package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class si
        implements Parcelable.Creator<om> {
    static void a(om paramom, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramom.a());
        c.a(paramParcel, 2, paramom.a, false);
        c.a(paramParcel, paramInt);
    }

    public om a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        int[] arrayOfInt = null;
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
                    arrayOfInt = a.u(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new om(i, arrayOfInt);
    }

    public om[] a(int paramInt) {
        return new om[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/si.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */