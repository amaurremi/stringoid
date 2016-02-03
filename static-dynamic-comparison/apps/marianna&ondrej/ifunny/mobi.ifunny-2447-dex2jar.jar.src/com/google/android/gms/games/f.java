package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class f
        implements Parcelable.Creator<PlayerLevelInfo> {
    static void a(PlayerLevelInfo paramPlayerLevelInfo, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramPlayerLevelInfo.b());
        c.a(paramParcel, 1000, paramPlayerLevelInfo.a());
        c.a(paramParcel, 2, paramPlayerLevelInfo.c());
        c.a(paramParcel, 3, paramPlayerLevelInfo.d(), paramInt, false);
        c.a(paramParcel, 4, paramPlayerLevelInfo.e(), paramInt, false);
        c.a(paramParcel, i);
    }

    public PlayerLevelInfo a(Parcel paramParcel) {
        long l1 = 0L;
        PlayerLevel localPlayerLevel1 = null;
        int j = a.b(paramParcel);
        int i = 0;
        PlayerLevel localPlayerLevel2 = null;
        long l2 = 0L;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    l2 = a.i(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    l1 = a.i(paramParcel, k);
                    break;
                case 3:
                    localPlayerLevel2 = (PlayerLevel) a.a(paramParcel, k, PlayerLevel.CREATOR);
                    break;
                case 4:
                    localPlayerLevel1 = (PlayerLevel) a.a(paramParcel, k, PlayerLevel.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new PlayerLevelInfo(i, l2, l1, localPlayerLevel2, localPlayerLevel1);
    }

    public PlayerLevelInfo[] a(int paramInt) {
        return new PlayerLevelInfo[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */