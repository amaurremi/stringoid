package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class cd
        implements Parcelable.Creator<ce> {
    static void a(ce paramce, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramce.versionCode);
        b.a(paramParcel, 2, paramce.og, paramInt, false);
        b.a(paramParcel, 3, paramce.aO(), false);
        b.a(paramParcel, 4, paramce.aP(), false);
        b.a(paramParcel, 5, paramce.aQ(), false);
        b.a(paramParcel, 6, paramce.aR(), false);
        b.a(paramParcel, 7, paramce.ol, false);
        b.a(paramParcel, 8, paramce.om);
        b.a(paramParcel, 9, paramce.on, false);
        b.a(paramParcel, 10, paramce.aT(), false);
        b.c(paramParcel, 11, paramce.orientation);
        b.c(paramParcel, 12, paramce.op);
        b.a(paramParcel, 13, paramce.nO, false);
        b.a(paramParcel, 14, paramce.kK, paramInt, false);
        b.a(paramParcel, 15, paramce.aS(), false);
        b.a(paramParcel, 16, paramce.or, false);
        b.F(paramParcel, i);
    }

    public ce e(Parcel paramParcel) {
        int m = a.o(paramParcel);
        int k = 0;
        cb localcb = null;
        IBinder localIBinder6 = null;
        IBinder localIBinder5 = null;
        IBinder localIBinder4 = null;
        IBinder localIBinder3 = null;
        String str4 = null;
        boolean bool = false;
        String str3 = null;
        IBinder localIBinder2 = null;
        int j = 0;
        int i = 0;
        String str2 = null;
        dx localdx = null;
        IBinder localIBinder1 = null;
        String str1 = null;
        while (paramParcel.dataPosition() < m) {
            int n = a.n(paramParcel);
            switch (a.R(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    localcb = (cb) a.a(paramParcel, n, cb.CREATOR);
                    break;
                case 3:
                    localIBinder6 = a.o(paramParcel, n);
                    break;
                case 4:
                    localIBinder5 = a.o(paramParcel, n);
                    break;
                case 5:
                    localIBinder4 = a.o(paramParcel, n);
                    break;
                case 6:
                    localIBinder3 = a.o(paramParcel, n);
                    break;
                case 7:
                    str4 = a.n(paramParcel, n);
                    break;
                case 8:
                    bool = a.c(paramParcel, n);
                    break;
                case 9:
                    str3 = a.n(paramParcel, n);
                    break;
                case 10:
                    localIBinder2 = a.o(paramParcel, n);
                    break;
                case 11:
                    j = a.g(paramParcel, n);
                    break;
                case 12:
                    i = a.g(paramParcel, n);
                    break;
                case 13:
                    str2 = a.n(paramParcel, n);
                    break;
                case 14:
                    localdx = (dx) a.a(paramParcel, n, dx.CREATOR);
                    break;
                case 15:
                    localIBinder1 = a.o(paramParcel, n);
                    break;
                case 16:
                    str1 = a.n(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new a.a("Overread allowed size end=" + m, paramParcel);
        }
        return new ce(k, localcb, localIBinder6, localIBinder5, localIBinder4, localIBinder3, str4, bool, str3, localIBinder2, j, i, str2, localdx, localIBinder1, str1);
    }

    public ce[] i(int paramInt) {
        return new ce[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */