package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class d
        implements Parcelable.Creator<ac> {
    static void a(ac paramac, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramac.b(), false);
        c.a(paramParcel, 1000, paramac.a());
        c.a(paramParcel, paramInt);
    }

    public ac a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        IBinder localIBinder = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localIBinder = a.p(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new ac(i, localIBinder);
    }

    public ac[] a(int paramInt) {
        return new ac[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */