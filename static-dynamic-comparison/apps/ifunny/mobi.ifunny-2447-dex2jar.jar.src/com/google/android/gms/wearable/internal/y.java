package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class y
        implements Parcelable.Creator<t> {
    static void a(t paramt, Parcel paramParcel, int paramInt) {
        int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramt.a);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramt.b);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramt.c, paramInt, false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
    }

    public t a(Parcel paramParcel) {
        int j = 0;
        int k = a.b(paramParcel);
        com.google.android.gms.wearable.c[] arrayOfc = null;
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    j = a.g(paramParcel, m);
                    break;
                case 3:
                    arrayOfc = (com.google.android.gms.wearable.c[]) a.b(paramParcel, m, com.google.android.gms.wearable.c.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new t(i, j, arrayOfc);
    }

    public t[] a(int paramInt) {
        return new t[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */