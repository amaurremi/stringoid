package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class a
        implements Parcelable.Creator<AccountChangeEvent> {
    static void a(AccountChangeEvent paramAccountChangeEvent, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramAccountChangeEvent.a);
        c.a(paramParcel, 2, paramAccountChangeEvent.b);
        c.a(paramParcel, 3, paramAccountChangeEvent.c, false);
        c.a(paramParcel, 4, paramAccountChangeEvent.d);
        c.a(paramParcel, 5, paramAccountChangeEvent.e);
        c.a(paramParcel, 6, paramAccountChangeEvent.f, false);
        c.a(paramParcel, paramInt);
    }

    public AccountChangeEvent a(Parcel paramParcel) {
        String str1 = null;
        int i = 0;
        int m = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        long l = 0L;
        int j = 0;
        String str2 = null;
        int k = 0;
        while (paramParcel.dataPosition() < m) {
            int n = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(n)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, n);
                    break;
                case 1:
                    k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
                    break;
                case 2:
                    l = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, n);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, n);
                    break;
                case 4:
                    j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
                    break;
                case 5:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
                    break;
                case 6:
                    str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new AccountChangeEvent(k, l, str2, j, i, str1);
    }

    public AccountChangeEvent[] a(int paramInt) {
        return new AccountChangeEvent[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/auth/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */