package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
        implements Parcelable.Creator<a> {
    static void a(a parama, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, parama.a);
        c.a(paramParcel, 2, parama.b, paramInt, false);
        c.a(paramParcel, 3, parama.c);
        c.a(paramParcel, i);
    }

    public a a(Parcel paramParcel) {
        int i = 0;
        int k = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        ParcelFileDescriptor localParcelFileDescriptor = null;
        int j = 0;
        if (paramParcel.dataPosition() < k) {
            int m = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(m)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
            }
            for (; ; ) {
                break;
                j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                continue;
                localParcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, ParcelFileDescriptor.CREATOR);
                continue;
                i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new a(j, localParcelFileDescriptor, i);
    }

    public a[] a(int paramInt) {
        return new a[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/data/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */