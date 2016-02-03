package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class l
        implements Parcelable.Creator<PlusCommonExtras> {
    static void a(PlusCommonExtras paramPlusCommonExtras, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramPlusCommonExtras.b(), false);
        c.a(paramParcel, 1000, paramPlusCommonExtras.a());
        c.a(paramParcel, 2, paramPlusCommonExtras.c(), false);
        c.a(paramParcel, paramInt);
    }

    public PlusCommonExtras a(Parcel paramParcel) {
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
                    str1 = a.o(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    str2 = a.o(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new PlusCommonExtras(i, str1, str2);
    }

    public PlusCommonExtras[] a(int paramInt) {
        return new PlusCommonExtras[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/plus/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */