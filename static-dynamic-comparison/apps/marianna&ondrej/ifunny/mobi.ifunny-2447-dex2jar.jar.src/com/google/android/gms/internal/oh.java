package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class oh
        implements Parcelable.Creator<hq> {
    static void a(hq paramhq, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramhq.b, false);
        c.a(paramParcel, 1000, paramhq.a);
        c.a(paramParcel, 2, paramhq.c, false);
        c.a(paramParcel, 3, paramhq.d);
        c.a(paramParcel, 4, paramhq.e);
        c.a(paramParcel, 5, paramhq.f);
        c.a(paramParcel, 6, paramhq.g, false);
        c.a(paramParcel, 7, paramhq.h, paramInt, false);
        c.a(paramParcel, 8, paramhq.i, false);
        c.a(paramParcel, 11, paramhq.j, false);
        c.a(paramParcel, i);
    }

    public hq a(Parcel paramParcel) {
        boolean bool1 = false;
        String str1 = null;
        int k = a.b(paramParcel);
        int i = 1;
        int[] arrayOfInt = null;
        hk[] arrayOfhk = null;
        String str2 = null;
        boolean bool2 = false;
        String str3 = null;
        String str4 = null;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    str4 = a.o(paramParcel, m);
                    break;
                case 1000:
                    j = a.g(paramParcel, m);
                    break;
                case 2:
                    str3 = a.o(paramParcel, m);
                    break;
                case 3:
                    bool2 = a.c(paramParcel, m);
                    break;
                case 4:
                    i = a.g(paramParcel, m);
                    break;
                case 5:
                    bool1 = a.c(paramParcel, m);
                    break;
                case 6:
                    str2 = a.o(paramParcel, m);
                    break;
                case 7:
                    arrayOfhk = (hk[]) a.b(paramParcel, m, hk.CREATOR);
                    break;
                case 8:
                    arrayOfInt = a.u(paramParcel, m);
                    break;
                case 11:
                    str1 = a.o(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new hq(j, str4, str3, bool2, i, bool1, str2, arrayOfhk, arrayOfInt, str1);
    }

    public hq[] a(int paramInt) {
        return new hq[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/oh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */