package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class nz
        implements Parcelable.Creator<he> {
    static void a(he paramhe, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramhe.b, paramInt, false);
        c.a(paramParcel, 1000, paramhe.a);
        c.a(paramParcel, 2, paramhe.c, false);
        c.a(paramParcel, 3, paramhe.d);
        c.a(paramParcel, 4, paramhe.e, paramInt, false);
        c.a(paramParcel, i);
    }

    public he a(Parcel paramParcel) {
        boolean bool = false;
        Account localAccount = null;
        int j = a.b(paramParcel);
        String str = null;
        hi[] arrayOfhi = null;
        int i = 0;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    arrayOfhi = (hi[]) a.b(paramParcel, k, hi.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    str = a.o(paramParcel, k);
                    break;
                case 3:
                    bool = a.c(paramParcel, k);
                    break;
                case 4:
                    localAccount = (Account) a.a(paramParcel, k, Account.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new he(i, arrayOfhi, str, bool, localAccount);
    }

    public he[] a(int paramInt) {
        return new he[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/nz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */