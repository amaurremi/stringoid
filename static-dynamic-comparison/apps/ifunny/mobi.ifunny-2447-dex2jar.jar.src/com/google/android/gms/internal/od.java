package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class od
        implements Parcelable.Creator<hm.a> {
    static void a(hm.a parama, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, parama.b, paramInt, false);
        c.a(paramParcel, 1000, parama.a);
        c.a(paramParcel, i);
    }

    public hm.a a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        Account localAccount = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localAccount = (Account) a.a(paramParcel, k, Account.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new hm.a(i, localAccount);
    }

    public hm.a[] a(int paramInt) {
        return new hm.a[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/od.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */