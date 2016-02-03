package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
        implements Parcelable.Creator<a> {
    static void a(a parama, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, parama.a(), false);
        c.a(paramParcel, 1000, parama.e());
        c.a(paramParcel, 2, parama.b(), false);
        c.a(paramParcel, 3, parama.c(), false);
        c.a(paramParcel, paramInt);
    }

    public a a(Parcel paramParcel) {
        String str3 = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int i = 0;
        String str2 = null;
        String str1 = null;
        while (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
                    break;
                case 1:
                    str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 3:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
        }
        return new a(i, str1, str2, str3);
    }

    public a[] a(int paramInt) {
        return new a[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */