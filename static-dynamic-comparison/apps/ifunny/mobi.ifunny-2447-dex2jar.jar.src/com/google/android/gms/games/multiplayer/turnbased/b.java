package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;

import java.util.ArrayList;

public class b
        implements Parcelable.Creator<TurnBasedMatchEntity> {
    static void a(TurnBasedMatchEntity paramTurnBasedMatchEntity, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramTurnBasedMatchEntity.z_(), paramInt, false);
        c.a(paramParcel, 2, paramTurnBasedMatchEntity.c(), false);
        c.a(paramParcel, 3, paramTurnBasedMatchEntity.d(), false);
        c.a(paramParcel, 4, paramTurnBasedMatchEntity.e());
        c.a(paramParcel, 5, paramTurnBasedMatchEntity.j(), false);
        c.a(paramParcel, 6, paramTurnBasedMatchEntity.k());
        c.a(paramParcel, 7, paramTurnBasedMatchEntity.m(), false);
        c.a(paramParcel, 8, paramTurnBasedMatchEntity.f());
        c.a(paramParcel, 10, paramTurnBasedMatchEntity.i());
        c.a(paramParcel, 11, paramTurnBasedMatchEntity.o());
        c.a(paramParcel, 12, paramTurnBasedMatchEntity.n(), false);
        c.c(paramParcel, 13, paramTurnBasedMatchEntity.l(), false);
        c.a(paramParcel, 14, paramTurnBasedMatchEntity.p(), false);
        c.a(paramParcel, 15, paramTurnBasedMatchEntity.q(), false);
        c.a(paramParcel, 17, paramTurnBasedMatchEntity.s(), false);
        c.a(paramParcel, 16, paramTurnBasedMatchEntity.r());
        c.a(paramParcel, 1000, paramTurnBasedMatchEntity.w());
        c.a(paramParcel, 19, paramTurnBasedMatchEntity.u());
        c.a(paramParcel, 18, paramTurnBasedMatchEntity.g());
        c.a(paramParcel, 21, paramTurnBasedMatchEntity.v(), false);
        c.a(paramParcel, 20, paramTurnBasedMatchEntity.h(), false);
        c.a(paramParcel, i);
    }

    public TurnBasedMatchEntity a(Parcel paramParcel) {
        int i2 = a.b(paramParcel);
        int i1 = 0;
        GameEntity localGameEntity = null;
        String str7 = null;
        String str6 = null;
        long l2 = 0L;
        String str5 = null;
        long l1 = 0L;
        String str4 = null;
        int n = 0;
        int m = 0;
        int k = 0;
        byte[] arrayOfByte2 = null;
        ArrayList localArrayList = null;
        String str3 = null;
        byte[] arrayOfByte1 = null;
        int j = 0;
        Bundle localBundle = null;
        int i = 0;
        boolean bool = false;
        String str2 = null;
        String str1 = null;
        while (paramParcel.dataPosition() < i2) {
            int i3 = a.a(paramParcel);
            switch (a.a(i3)) {
                default:
                    a.b(paramParcel, i3);
                    break;
                case 1:
                    localGameEntity = (GameEntity) a.a(paramParcel, i3, GameEntity.CREATOR);
                    break;
                case 2:
                    str7 = a.o(paramParcel, i3);
                    break;
                case 3:
                    str6 = a.o(paramParcel, i3);
                    break;
                case 4:
                    l2 = a.i(paramParcel, i3);
                    break;
                case 5:
                    str5 = a.o(paramParcel, i3);
                    break;
                case 6:
                    l1 = a.i(paramParcel, i3);
                    break;
                case 7:
                    str4 = a.o(paramParcel, i3);
                    break;
                case 8:
                    n = a.g(paramParcel, i3);
                    break;
                case 10:
                    m = a.g(paramParcel, i3);
                    break;
                case 11:
                    k = a.g(paramParcel, i3);
                    break;
                case 12:
                    arrayOfByte2 = a.r(paramParcel, i3);
                    break;
                case 13:
                    localArrayList = a.c(paramParcel, i3, ParticipantEntity.CREATOR);
                    break;
                case 14:
                    str3 = a.o(paramParcel, i3);
                    break;
                case 15:
                    arrayOfByte1 = a.r(paramParcel, i3);
                    break;
                case 17:
                    localBundle = a.q(paramParcel, i3);
                    break;
                case 16:
                    j = a.g(paramParcel, i3);
                    break;
                case 1000:
                    i1 = a.g(paramParcel, i3);
                    break;
                case 19:
                    bool = a.c(paramParcel, i3);
                    break;
                case 18:
                    i = a.g(paramParcel, i3);
                    break;
                case 21:
                    str1 = a.o(paramParcel, i3);
                    break;
                case 20:
                    str2 = a.o(paramParcel, i3);
            }
        }
        if (paramParcel.dataPosition() != i2) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + i2, paramParcel);
        }
        return new TurnBasedMatchEntity(i1, localGameEntity, str7, str6, l2, str5, l1, str4, n, m, k, arrayOfByte2, localArrayList, str3, arrayOfByte1, j, localBundle, i, bool, str2, str1);
    }

    public TurnBasedMatchEntity[] a(int paramInt) {
        return new TurnBasedMatchEntity[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */