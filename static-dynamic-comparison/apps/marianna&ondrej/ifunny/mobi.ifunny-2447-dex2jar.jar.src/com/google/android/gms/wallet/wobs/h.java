package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class h
        implements Parcelable.Creator<b> {
    static void a(b paramb, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramb.a());
        c.a(paramParcel, 2, paramb.a, false);
        c.a(paramParcel, 3, paramb.b, false);
        c.a(paramParcel, paramInt);
    }

    public b a(Parcel paramParcel) {
        String str2 = null;
        int j = a.b(paramParcel);
        int i = 0;
        String str1 = null;
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
                    str1 = a.o(paramParcel, k);
                    break;
                case 3:
                    str2 = a.o(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
        }
        return new b(i, str1, str2);
    }

    public b[] a(int paramInt) {
        return new b[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/wobs/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */