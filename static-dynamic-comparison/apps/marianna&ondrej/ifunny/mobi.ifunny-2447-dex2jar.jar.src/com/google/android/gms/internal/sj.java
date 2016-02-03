package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class sj
        implements Parcelable.Creator<oo> {
    static void a(oo paramoo, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramoo.a());
        c.a(paramParcel, 2, paramoo.a, false);
        c.a(paramParcel, 3, paramoo.b, false);
        c.a(paramParcel, paramInt);
    }

    public oo a(Parcel paramParcel) {
        String[] arrayOfString = null;
        int j = a.b(paramParcel);
        int i = 0;
        byte[][] arrayOfByte = (byte[][]) null;
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
                    arrayOfString = a.A(paramParcel, k);
                    break;
                case 3:
                    arrayOfByte = a.s(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new oo(i, arrayOfString, arrayOfByte);
    }

    public oo[] a(int paramInt) {
        return new oo[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/sj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */