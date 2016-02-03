package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class oc
        implements Parcelable.Creator<hk> {
    static void a(hk paramhk, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramhk.b);
        c.a(paramParcel, 1000, paramhk.a);
        c.a(paramParcel, 2, paramhk.c, false);
        c.a(paramParcel, paramInt);
    }

    public hk a(Parcel paramParcel) {
        int j = 0;
        int k = a.b(paramParcel);
        Bundle localBundle = null;
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    j = a.g(paramParcel, m);
                    break;
                case 1000:
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    localBundle = a.q(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new hk(i, j, localBundle);
    }

    public hk[] a(int paramInt) {
        return new hk[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/oc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */