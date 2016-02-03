package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class a
        implements Parcelable.Creator<z> {
    static void a(z paramz, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramz.a);
        c.a(paramParcel, 2, paramz.b);
        c.a(paramParcel, 3, paramz.c, paramInt, false);
        c.a(paramParcel, i);
    }

    public z a(Parcel paramParcel) {
        int j = 0;
        int k = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        ParcelFileDescriptor localParcelFileDescriptor = null;
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(m)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
                    break;
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                    break;
                case 3:
                    localParcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, ParcelFileDescriptor.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new z(i, j, localParcelFileDescriptor);
    }

    public z[] a(int paramInt) {
        return new z[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */