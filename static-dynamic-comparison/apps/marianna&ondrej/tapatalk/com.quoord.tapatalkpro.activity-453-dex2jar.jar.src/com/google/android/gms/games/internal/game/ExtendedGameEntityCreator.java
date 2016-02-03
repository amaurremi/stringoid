package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;

import java.util.ArrayList;

public class ExtendedGameEntityCreator
        implements Parcelable.Creator<ExtendedGameEntity> {
    static void a(ExtendedGameEntity paramExtendedGameEntity, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.a(paramParcel, 1, paramExtendedGameEntity.hf(), paramInt, false);
        b.c(paramParcel, 1000, paramExtendedGameEntity.getVersionCode());
        b.c(paramParcel, 2, paramExtendedGameEntity.gX());
        b.a(paramParcel, 3, paramExtendedGameEntity.gY());
        b.c(paramParcel, 4, paramExtendedGameEntity.gZ());
        b.a(paramParcel, 5, paramExtendedGameEntity.ha());
        b.a(paramParcel, 6, paramExtendedGameEntity.hb());
        b.a(paramParcel, 7, paramExtendedGameEntity.hc(), false);
        b.a(paramParcel, 8, paramExtendedGameEntity.hd());
        b.a(paramParcel, 9, paramExtendedGameEntity.he(), false);
        b.b(paramParcel, 10, paramExtendedGameEntity.gW(), false);
        b.F(paramParcel, i);
    }

    public ExtendedGameEntity aq(Parcel paramParcel) {
        int m = a.o(paramParcel);
        int k = 0;
        GameEntity localGameEntity = null;
        int j = 0;
        boolean bool = false;
        int i = 0;
        long l3 = 0L;
        long l2 = 0L;
        String str2 = null;
        long l1 = 0L;
        String str1 = null;
        ArrayList localArrayList = null;
        while (paramParcel.dataPosition() < m) {
            int n = a.n(paramParcel);
            switch (a.R(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    localGameEntity = (GameEntity) a.a(paramParcel, n, GameEntity.CREATOR);
                    break;
                case 1000:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    j = a.g(paramParcel, n);
                    break;
                case 3:
                    bool = a.c(paramParcel, n);
                    break;
                case 4:
                    i = a.g(paramParcel, n);
                    break;
                case 5:
                    l3 = a.i(paramParcel, n);
                    break;
                case 6:
                    l2 = a.i(paramParcel, n);
                    break;
                case 7:
                    str2 = a.n(paramParcel, n);
                    break;
                case 8:
                    l1 = a.i(paramParcel, n);
                    break;
                case 9:
                    str1 = a.n(paramParcel, n);
                    break;
                case 10:
                    localArrayList = a.c(paramParcel, n, GameBadgeEntity.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new a.a("Overread allowed size end=" + m, paramParcel);
        }
        return new ExtendedGameEntity(k, localGameEntity, j, bool, i, l3, l2, str2, l1, str1, localArrayList);
    }

    public ExtendedGameEntity[] be(int paramInt) {
        return new ExtendedGameEntity[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/internal/game/ExtendedGameEntityCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */