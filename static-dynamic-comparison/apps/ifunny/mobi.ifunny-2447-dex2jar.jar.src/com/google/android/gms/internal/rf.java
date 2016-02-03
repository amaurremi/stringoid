package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class rf
        implements Parcelable.Creator<mm> {
    static void a(mm parammm, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1000, parammm.b);
        c.a(paramParcel, 2, parammm.a(), paramInt, false);
        c.a(paramParcel, 3, parammm.b());
        c.a(paramParcel, 4, parammm.c());
        c.a(paramParcel, i);
    }

    public mm a(Parcel paramParcel) {
        int k = a.b(paramParcel);
        int j = 0;
        mi localmi = null;
        long l = mm.a;
        int i = 102;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1000:
                    j = a.g(paramParcel, m);
                    break;
                case 2:
                    localmi = (mi) a.a(paramParcel, m, mi.CREATOR);
                    break;
                case 3:
                    l = a.i(paramParcel, m);
                    break;
                case 4:
                    i = a.g(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new mm(j, localmi, l, i);
    }

    public mm[] a(int paramInt) {
        return new mm[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/rf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */