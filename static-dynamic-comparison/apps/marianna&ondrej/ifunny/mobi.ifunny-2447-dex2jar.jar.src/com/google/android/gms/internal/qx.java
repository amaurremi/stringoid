package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class qx
        implements Parcelable.Creator<lr> {
    static void a(lr paramlr, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramlr.a);
        c.a(paramParcel, 1000, paramlr.a());
        c.a(paramParcel, 2, paramlr.b, false);
        c.a(paramParcel, paramInt);
    }

    public lr a(Parcel paramParcel) {
        int j = 0;
        int k = a.b(paramParcel);
        String str = null;
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    j = a.g(paramParcel, m);
                    break;
                case 1000:
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    str = a.o(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new lr(i, j, str);
    }

    public lr[] a(int paramInt) {
        return new lr[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/qx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */