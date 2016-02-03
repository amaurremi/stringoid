package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
        implements Parcelable.Creator<PlayerLevel> {
    static void a(PlayerLevel paramPlayerLevel, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramPlayerLevel.b());
        c.a(paramParcel, 1000, paramPlayerLevel.a());
        c.a(paramParcel, 2, paramPlayerLevel.c());
        c.a(paramParcel, 3, paramPlayerLevel.d());
        c.a(paramParcel, paramInt);
    }

    public PlayerLevel a(Parcel paramParcel) {
        long l1 = 0L;
        int i = 0;
        int k = a.b(paramParcel);
        long l2 = 0L;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    i = a.g(paramParcel, m);
                    break;
                case 1000:
                    j = a.g(paramParcel, m);
                    break;
                case 2:
                    l2 = a.i(paramParcel, m);
                    break;
                case 3:
                    l1 = a.i(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new PlayerLevel(j, i, l2, l1);
    }

    public PlayerLevel[] a(int paramInt) {
        return new PlayerLevel[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */