package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class pl
        implements Parcelable.Creator<jm.a> {
    static void a(jm.a parama, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, parama.a);
        c.a(paramParcel, 2, parama.b, false);
        c.c(paramParcel, 3, parama.c, false);
        c.a(paramParcel, paramInt);
    }

    public jm.a a(Parcel paramParcel) {
        ArrayList localArrayList = null;
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
                    localArrayList = a.c(paramParcel, k, jm.b.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new jm.a(i, str, localArrayList);
    }

    public jm.a[] a(int paramInt) {
        return new jm.a[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */