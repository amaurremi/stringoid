package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

import java.util.ArrayList;

public class b
        implements Parcelable.Creator<ExtendedGameEntity> {
    static void a(ExtendedGameEntity paramExtendedGameEntity, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramExtendedGameEntity.n(), paramInt, false);
        c.a(paramParcel, 1000, paramExtendedGameEntity.m());
        c.a(paramParcel, 2, paramExtendedGameEntity.m_());
        c.a(paramParcel, 3, paramExtendedGameEntity.e());
        c.a(paramParcel, 4, paramExtendedGameEntity.f());
        c.a(paramParcel, 5, paramExtendedGameEntity.g());
        c.a(paramParcel, 6, paramExtendedGameEntity.h());
        c.a(paramParcel, 7, paramExtendedGameEntity.i(), false);
        c.a(paramParcel, 8, paramExtendedGameEntity.j());
        c.a(paramParcel, 9, paramExtendedGameEntity.k(), false);
        c.c(paramParcel, 10, paramExtendedGameEntity.l_(), false);
        c.a(paramParcel, 11, paramExtendedGameEntity.l(), paramInt, false);
        c.a(paramParcel, i);
    }

    public ExtendedGameEntity a(Parcel paramParcel) {
        int m = a.b(paramParcel);
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
        SnapshotMetadataEntity localSnapshotMetadataEntity = null;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
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
                    str2 = a.o(paramParcel, n);
                    break;
                case 8:
                    l1 = a.i(paramParcel, n);
                    break;
                case 9:
                    str1 = a.o(paramParcel, n);
                    break;
                case 10:
                    localArrayList = a.c(paramParcel, n, GameBadgeEntity.CREATOR);
                    break;
                case 11:
                    localSnapshotMetadataEntity = (SnapshotMetadataEntity) a.a(paramParcel, n, SnapshotMetadataEntity.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + m, paramParcel);
        }
        return new ExtendedGameEntity(k, localGameEntity, j, bool, i, l3, l2, str2, l1, str1, localArrayList, localSnapshotMetadataEntity);
    }

    public ExtendedGameEntity[] a(int paramInt) {
        return new ExtendedGameEntity[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/game/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */