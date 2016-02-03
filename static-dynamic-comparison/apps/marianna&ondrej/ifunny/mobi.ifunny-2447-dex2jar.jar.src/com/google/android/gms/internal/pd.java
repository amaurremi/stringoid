package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class pd
        implements Parcelable.Creator<jb> {
    static void a(jb paramjb, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramjb.a);
        c.a(paramParcel, 2, paramjb.b, false);
        c.a(paramParcel, 3, paramjb.c);
        c.a(paramParcel, paramInt);
    }

    public jb a(Parcel paramParcel) {
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
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    str = a.o(paramParcel, m);
                    break;
                case 3:
                    j = a.g(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new jb(i, str, j);
    }

    public jb[] a(int paramInt) {
        return new jb[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */