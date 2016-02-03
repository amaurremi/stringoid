package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class rl
        implements Parcelable.Creator<nh> {
    static void a(nh paramnh, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramnh.a);
        c.a(paramParcel, 2, paramnh.b);
        c.a(paramParcel, 3, paramnh.c, false);
        c.a(paramParcel, 4, paramnh.d, false);
        c.a(paramParcel, 5, paramnh.e, false);
        c.a(paramParcel, paramInt);
    }

    public nh a(Parcel paramParcel) {
        Bundle localBundle = null;
        int j = a.b(paramParcel);
        int i = 0;
        long l = 0L;
        byte[] arrayOfByte = null;
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
                    l = a.i(paramParcel, k);
                    break;
                case 3:
                    str = a.o(paramParcel, k);
                    break;
                case 4:
                    arrayOfByte = a.r(paramParcel, k);
                    break;
                case 5:
                    localBundle = a.q(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new nh(i, l, str, arrayOfByte, localBundle);
    }

    public nh[] a(int paramInt) {
        return new nh[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/rl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */