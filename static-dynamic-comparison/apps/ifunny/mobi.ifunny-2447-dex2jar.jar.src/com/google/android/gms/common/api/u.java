package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class u
        implements Parcelable.Creator<Status> {
    static void a(Status paramStatus, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramStatus.f());
        c.a(paramParcel, 1000, paramStatus.d());
        c.a(paramParcel, 2, paramStatus.c(), false);
        c.a(paramParcel, 3, paramStatus.b(), paramInt, false);
        c.a(paramParcel, i);
    }

    public Status a(Parcel paramParcel) {
        PendingIntent localPendingIntent = null;
        int j = 0;
        int k = a.b(paramParcel);
        String str = null;
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    j = a.g(paramParcel, m);
                    break;
                case 1000:
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    str = a.o(paramParcel, m);
                    break;
                case 3:
                    localPendingIntent = (PendingIntent) a.a(paramParcel, m, PendingIntent.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new Status(i, j, str, localPendingIntent);
    }

    public Status[] a(int paramInt) {
        return new Status[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/api/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */