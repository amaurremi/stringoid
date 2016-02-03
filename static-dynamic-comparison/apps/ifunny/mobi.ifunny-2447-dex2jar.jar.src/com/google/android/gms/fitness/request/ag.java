package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class ag
        implements Parcelable.Creator<t> {
    static void a(t paramt, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramt.a(), paramInt, false);
        c.a(paramParcel, 1000, paramt.b());
        c.a(paramParcel, i);
    }

    public t a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        PendingIntent localPendingIntent = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localPendingIntent = (PendingIntent) a.a(paramParcel, k, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new t(i, localPendingIntent);
    }

    public t[] a(int paramInt) {
        return new t[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */