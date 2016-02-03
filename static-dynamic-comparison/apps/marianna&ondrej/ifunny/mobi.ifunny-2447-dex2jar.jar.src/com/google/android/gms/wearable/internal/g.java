package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class g
        implements Parcelable.Creator<ah> {
    static void a(ah paramah, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramah.a);
        c.a(paramParcel, 2, paramah.a());
        c.a(paramParcel, 3, paramah.b(), false);
        c.a(paramParcel, 4, paramah.c(), false);
        c.a(paramParcel, 5, paramah.d(), false);
        c.a(paramParcel, paramInt);
    }

    public ah a(Parcel paramParcel) {
        int i = 0;
        String str1 = null;
        int k = a.b(paramParcel);
        byte[] arrayOfByte = null;
        String str2 = null;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    j = a.g(paramParcel, m);
                    break;
                case 2:
                    i = a.g(paramParcel, m);
                    break;
                case 3:
                    str2 = a.o(paramParcel, m);
                    break;
                case 4:
                    arrayOfByte = a.r(paramParcel, m);
                    break;
                case 5:
                    str1 = a.o(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new ah(j, i, str2, arrayOfByte, str1);
    }

    public ah[] a(int paramInt) {
        return new ah[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */