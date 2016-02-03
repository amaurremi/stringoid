package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
        implements Parcelable.Creator<LaunchOptions> {
    static void a(LaunchOptions paramLaunchOptions, Parcel paramParcel, int paramInt) {
        paramInt = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramLaunchOptions.a());
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramLaunchOptions.b());
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramLaunchOptions.c(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, paramInt);
    }

    public LaunchOptions a(Parcel paramParcel) {
        boolean bool = false;
        int j = a.b(paramParcel);
        String str = null;
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
                    bool = a.c(paramParcel, k);
                    break;
                case 3:
                    str = a.o(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new LaunchOptions(i, bool, str);
    }

    public LaunchOptions[] a(int paramInt) {
        return new LaunchOptions[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/cast/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */