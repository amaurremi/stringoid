package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.Subscription;

public class e
        implements Parcelable.Creator<ae> {
    static void a(ae paramae, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramae.a(), paramInt, false);
        c.a(paramParcel, 1000, paramae.c());
        c.a(paramParcel, 2, paramae.b());
        c.a(paramParcel, i);
    }

    public ae a(Parcel paramParcel) {
        boolean bool = false;
        int j = a.b(paramParcel);
        Subscription localSubscription = null;
        int i = 0;
        if (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
            }
            for (; ; ) {
                break;
                localSubscription = (Subscription) a.a(paramParcel, k, Subscription.CREATOR);
                continue;
                i = a.g(paramParcel, k);
                continue;
                bool = a.c(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new ae(i, localSubscription, bool);
    }

    public ae[] a(int paramInt) {
        return new ae[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */