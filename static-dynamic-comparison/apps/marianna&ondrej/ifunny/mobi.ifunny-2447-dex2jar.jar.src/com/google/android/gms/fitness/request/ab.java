package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class ab
        implements Parcelable.Creator<p> {
    static void a(p paramp, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramp.c(), false);
        c.a(paramParcel, 1000, paramp.b());
        c.a(paramParcel, 2, paramp.a(), paramInt, false);
        c.a(paramParcel, i);
    }

    public p a(Parcel paramParcel) {
        PendingIntent localPendingIntent = null;
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
                    break;
                case 2:
                    localPendingIntent = (PendingIntent) a.a(paramParcel, k, PendingIntent.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new p(i, localIBinder, localPendingIntent);
    }

    public p[] a(int paramInt) {
        return new p[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */