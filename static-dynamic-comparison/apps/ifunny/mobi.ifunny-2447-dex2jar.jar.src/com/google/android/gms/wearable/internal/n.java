package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class n
        implements Parcelable.Creator<au> {
    static void a(au paramau, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramau.a);
        c.a(paramParcel, 2, paramau.b);
        c.a(paramParcel, 3, paramau.c);
        c.c(paramParcel, 4, paramau.d, false);
        c.a(paramParcel, paramInt);
    }

    public au a(Parcel paramParcel) {
        int i = 0;
        int k = a.b(paramParcel);
        long l = 0L;
        ArrayList localArrayList = null;
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
                    l = a.i(paramParcel, m);
                    break;
                case 4:
                    localArrayList = a.c(paramParcel, m, am.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new au(j, i, l, localArrayList);
    }

    public au[] a(int paramInt) {
        return new au[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */