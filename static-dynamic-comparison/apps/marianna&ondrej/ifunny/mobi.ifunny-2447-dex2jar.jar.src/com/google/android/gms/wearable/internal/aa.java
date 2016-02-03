package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class aa
        implements Parcelable.Creator<v> {
    static void a(v paramv, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramv.a);
        c.a(paramParcel, 2, paramv.b);
        c.c(paramParcel, 3, paramv.c, false);
        c.a(paramParcel, paramInt);
    }

    public v a(Parcel paramParcel) {
        int j = 0;
        int k = a.b(paramParcel);
        ArrayList localArrayList = null;
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
                    j = a.g(paramParcel, m);
                    break;
                case 3:
                    localArrayList = a.c(paramParcel, m, ak.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new v(i, j, localArrayList);
    }

    public v[] a(int paramInt) {
        return new v[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */