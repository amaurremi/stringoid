package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class a
        implements Parcelable.Creator<ConnectionInfo> {
    static void a(ConnectionInfo paramConnectionInfo, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramConnectionInfo.b(), false);
        c.a(paramParcel, 1000, paramConnectionInfo.a());
        c.a(paramParcel, 2, paramConnectionInfo.c());
        c.a(paramParcel, paramInt);
    }

    public ConnectionInfo a(Parcel paramParcel) {
        int j = 0;
        int k = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        String str = null;
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(m)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
                    break;
                case 1:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new ConnectionInfo(i, str, j);
    }

    public ConnectionInfo[] a(int paramInt) {
        return new ConnectionInfo[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */