package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class ob
        implements Parcelable.Creator<hi> {
    static void a(hi paramhi, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramhi.c, false);
        c.a(paramParcel, 1000, paramhi.b);
        c.a(paramParcel, 3, paramhi.d, paramInt, false);
        c.a(paramParcel, 4, paramhi.e);
        c.a(paramParcel, 5, paramhi.f, false);
        c.a(paramParcel, i);
    }

    public hi a(Parcel paramParcel) {
        byte[] arrayOfByte = null;
        int k = a.b(paramParcel);
        int j = 0;
        int i = -1;
        hq localhq = null;
        String str = null;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    str = a.o(paramParcel, m);
                    break;
                case 1000:
                    j = a.g(paramParcel, m);
                    break;
                case 3:
                    localhq = (hq) a.a(paramParcel, m, hq.CREATOR);
                    break;
                case 4:
                    i = a.g(paramParcel, m);
                    break;
                case 5:
                    arrayOfByte = a.r(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new hi(j, str, localhq, i, arrayOfByte);
    }

    public hi[] a(int paramInt) {
        return new hi[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */