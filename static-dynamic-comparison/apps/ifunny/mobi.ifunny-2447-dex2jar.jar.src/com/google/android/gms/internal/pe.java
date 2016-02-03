package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class pe
        implements Parcelable.Creator<jd> {
    static void a(jd paramjd, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramjd.a());
        c.a(paramParcel, 2, paramjd.b(), paramInt, false);
        c.a(paramParcel, i);
    }

    public jd a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        jf localjf = null;
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
                    localjf = (jf) a.a(paramParcel, k, jf.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new jd(i, localjf);
    }

    public jd[] a(int paramInt) {
        return new jd[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */