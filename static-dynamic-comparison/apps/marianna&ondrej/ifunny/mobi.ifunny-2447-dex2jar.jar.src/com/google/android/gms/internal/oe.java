package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class oe
        implements Parcelable.Creator<hm.b> {
    static void a(hm.b paramb, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1000, paramb.c);
        c.a(paramParcel, 1, paramb.a, paramInt, false);
        c.c(paramParcel, 2, paramb.b, false);
        c.a(paramParcel, i);
    }

    public hm.b a(Parcel paramParcel) {
        ArrayList localArrayList = null;
        int j = a.b(paramParcel);
        int i = 0;
        Status localStatus = null;
        if (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
            }
            for (; ; ) {
                break;
                i = a.g(paramParcel, k);
                continue;
                localStatus = (Status) a.a(paramParcel, k, Status.CREATOR);
                continue;
                localArrayList = a.c(paramParcel, k, hs.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new hm.b(i, localStatus, localArrayList);
    }

    public hm.b[] a(int paramInt) {
        return new hm.b[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/oe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */