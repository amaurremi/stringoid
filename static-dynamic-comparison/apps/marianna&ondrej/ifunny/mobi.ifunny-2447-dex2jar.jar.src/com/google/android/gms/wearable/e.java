package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e
        implements Parcelable.Creator<c> {
    static void a(c paramc, Parcel paramParcel, int paramInt) {
        paramInt = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramc.a);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramc.a(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramc.b(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 4, paramc.c());
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 5, paramc.d());
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 6, paramc.g());
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 7, paramc.e());
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 8, paramc.f(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, paramInt);
    }

    public c a(Parcel paramParcel) {
        String str1 = null;
        boolean bool1 = false;
        int m = a.b(paramParcel);
        boolean bool2 = false;
        int i = 0;
        int j = 0;
        String str2 = null;
        String str3 = null;
        int k = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    str3 = a.o(paramParcel, n);
                    break;
                case 3:
                    str2 = a.o(paramParcel, n);
                    break;
                case 4:
                    j = a.g(paramParcel, n);
                    break;
                case 5:
                    i = a.g(paramParcel, n);
                    break;
                case 6:
                    bool2 = a.c(paramParcel, n);
                    break;
                case 7:
                    bool1 = a.c(paramParcel, n);
                    break;
                case 8:
                    str1 = a.o(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new c(k, str3, str2, j, i, bool2, bool1, str1);
    }

    public c[] a(int paramInt) {
        return new c[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */