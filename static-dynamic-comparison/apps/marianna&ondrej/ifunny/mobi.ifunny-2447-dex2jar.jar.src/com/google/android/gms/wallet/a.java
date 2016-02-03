package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class a
        implements Parcelable.Creator<Address> {
    static void a(Address paramAddress, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramAddress.a());
        c.a(paramParcel, 2, paramAddress.a, false);
        c.a(paramParcel, 3, paramAddress.b, false);
        c.a(paramParcel, 4, paramAddress.c, false);
        c.a(paramParcel, 5, paramAddress.d, false);
        c.a(paramParcel, 6, paramAddress.e, false);
        c.a(paramParcel, 7, paramAddress.f, false);
        c.a(paramParcel, 8, paramAddress.g, false);
        c.a(paramParcel, 9, paramAddress.h, false);
        c.a(paramParcel, 10, paramAddress.i, false);
        c.a(paramParcel, 11, paramAddress.j);
        c.a(paramParcel, 12, paramAddress.k, false);
        c.a(paramParcel, paramInt);
    }

    public Address a(Parcel paramParcel) {
        int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int i = 0;
        String str10 = null;
        String str9 = null;
        String str8 = null;
        String str7 = null;
        String str6 = null;
        String str5 = null;
        String str4 = null;
        String str3 = null;
        String str2 = null;
        boolean bool = false;
        String str1 = null;
        while (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
                    break;
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
                    break;
                case 2:
                    str10 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 3:
                    str9 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 4:
                    str8 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 5:
                    str7 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 6:
                    str6 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 7:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 8:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 9:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 10:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 11:
                    bool = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k);
                    break;
                case 12:
                    str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new Address(i, str10, str9, str8, str7, str6, str5, str4, str3, str2, bool, str1);
    }

    public Address[] a(int paramInt) {
        return new Address[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */