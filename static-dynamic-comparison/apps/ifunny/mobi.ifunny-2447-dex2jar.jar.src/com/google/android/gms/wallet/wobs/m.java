package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class m
        implements Parcelable.Creator<f> {
    static void a(f paramf, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramf.a());
        c.a(paramParcel, 2, paramf.a, false);
        c.a(paramParcel, 3, paramf.b, paramInt, false);
        c.a(paramParcel, 4, paramf.c, false);
        c.a(paramParcel, 5, paramf.d, paramInt, false);
        c.a(paramParcel, i);
    }

    public f a(Parcel paramParcel) {
        l locall = null;
        int j = a.b(paramParcel);
        int i = 0;
        String str1 = null;
        g localg = null;
        String str2 = null;
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
                    str2 = a.o(paramParcel, k);
                    break;
                case 3:
                    localg = (g) a.a(paramParcel, k, g.CREATOR);
                    break;
                case 4:
                    str1 = a.o(paramParcel, k);
                    break;
                case 5:
                    locall = (l) a.a(paramParcel, k, l.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new f(i, str2, localg, str1, locall);
    }

    public f[] a(int paramInt) {
        return new f[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/wobs/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */