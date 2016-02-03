package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class m
        implements Parcelable.Creator<h> {
    static void a(h paramh, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramh.b(), false);
        c.a(paramParcel, 1000, paramh.a());
        c.a(paramParcel, 2, paramh.c(), false);
        c.a(paramParcel, 3, paramh.d(), false);
        c.a(paramParcel, 4, paramh.e(), false);
        c.a(paramParcel, 5, paramh.f(), false);
        c.a(paramParcel, 6, paramh.g(), false);
        c.a(paramParcel, 7, paramh.h(), false);
        c.a(paramParcel, 8, paramh.i(), false);
        c.a(paramParcel, 9, paramh.j(), paramInt, false);
        c.a(paramParcel, i);
    }

    public h a(Parcel paramParcel) {
        PlusCommonExtras localPlusCommonExtras = null;
        int j = a.b(paramParcel);
        int i = 0;
        String str1 = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] arrayOfString1 = null;
        String[] arrayOfString2 = null;
        String[] arrayOfString3 = null;
        String str5 = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    str5 = a.o(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    arrayOfString3 = a.A(paramParcel, k);
                    break;
                case 3:
                    arrayOfString2 = a.A(paramParcel, k);
                    break;
                case 4:
                    arrayOfString1 = a.A(paramParcel, k);
                    break;
                case 5:
                    str4 = a.o(paramParcel, k);
                    break;
                case 6:
                    str3 = a.o(paramParcel, k);
                    break;
                case 7:
                    str2 = a.o(paramParcel, k);
                    break;
                case 8:
                    str1 = a.o(paramParcel, k);
                    break;
                case 9:
                    localPlusCommonExtras = (PlusCommonExtras) a.a(paramParcel, k, PlusCommonExtras.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new h(i, str5, arrayOfString3, arrayOfString2, arrayOfString1, str4, str3, str2, str1, localPlusCommonExtras);
    }

    public h[] a(int paramInt) {
        return new h[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/plus/internal/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */