package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class oq
        implements Parcelable.Creator<il> {
    static void a(il paramil, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramil.a());
        c.a(paramParcel, 2, paramil.b());
        c.a(paramParcel, 3, paramil.c());
        c.a(paramParcel, 4, paramil.d());
        c.a(paramParcel, 5, paramil.f(), paramInt, false);
        c.a(paramParcel, 6, paramil.e());
        c.a(paramParcel, i);
    }

    public il a(Parcel paramParcel) {
        int i = 0;
        int m = a.b(paramParcel);
        double d = 0.0D;
        ApplicationMetadata localApplicationMetadata = null;
        int j = 0;
        boolean bool = false;
        int k = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    d = a.m(paramParcel, n);
                    break;
                case 3:
                    bool = a.c(paramParcel, n);
                    break;
                case 4:
                    j = a.g(paramParcel, n);
                    break;
                case 5:
                    localApplicationMetadata = (ApplicationMetadata) a.a(paramParcel, n, ApplicationMetadata.CREATOR);
                    break;
                case 6:
                    i = a.g(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new il(k, d, bool, j, localApplicationMetadata, i);
    }

    public il[] a(int paramInt) {
        return new il[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/oq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */