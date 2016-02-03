package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class r
        implements Parcelable.Creator<Session> {
    static void a(Session paramSession, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramSession.a());
        c.a(paramParcel, 1000, paramSession.h());
        c.a(paramParcel, 2, paramSession.b());
        c.a(paramParcel, 3, paramSession.c(), false);
        c.a(paramParcel, 4, paramSession.d(), false);
        c.a(paramParcel, 5, paramSession.e(), false);
        c.a(paramParcel, 7, paramSession.f());
        c.a(paramParcel, 8, paramSession.g(), paramInt, false);
        c.a(paramParcel, i);
    }

    public Session a(Parcel paramParcel) {
        long l1 = 0L;
        int i = 0;
        a locala = null;
        int k = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        String str1 = null;
        String str2 = null;
        String str3 = null;
        long l2 = 0L;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(m)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
                    break;
                case 1:
                    l2 = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, m);
                    break;
                case 1000:
                    j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                    break;
                case 2:
                    l1 = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, m);
                    break;
                case 3:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
                    break;
                case 5:
                    str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                    break;
                case 8:
                    locala = (a) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, a.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new Session(j, l2, l1, str3, str2, str1, i, locala);
    }

    public Session[] a(int paramInt) {
        return new Session[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */