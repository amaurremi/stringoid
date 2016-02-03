package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class fh
        implements Parcelable.Creator<dj> {
    static void a(dj paramdj, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramdj.a);
        c.a(paramParcel, 2, paramdj.b, false);
        c.a(paramParcel, 3, paramdj.c, false);
        c.a(paramParcel, 4, paramdj.d, false);
        c.a(paramParcel, 5, paramdj.e, false);
        c.a(paramParcel, 6, paramdj.f, false);
        c.a(paramParcel, 7, paramdj.g, false);
        c.a(paramParcel, 8, paramdj.h, false);
        c.a(paramParcel, paramInt);
    }

    public dj a(Parcel paramParcel) {
        String str1 = null;
        int j = a.b(paramParcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
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
                    str7 = a.o(paramParcel, k);
                    break;
                case 3:
                    str6 = a.o(paramParcel, k);
                    break;
                case 4:
                    str5 = a.o(paramParcel, k);
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
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new dj(i, str7, str6, str5, str4, str3, str2, str1);
    }

    public dj[] a(int paramInt) {
        return new dj[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */