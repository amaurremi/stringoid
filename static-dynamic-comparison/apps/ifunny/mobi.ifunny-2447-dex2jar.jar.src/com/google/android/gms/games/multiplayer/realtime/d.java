package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.multiplayer.ParticipantEntity;

import java.util.ArrayList;

public class d
        implements Parcelable.Creator<RoomEntity> {
    static void a(RoomEntity paramRoomEntity, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramRoomEntity.w_(), false);
        c.a(paramParcel, 1000, paramRoomEntity.j());
        c.a(paramParcel, 2, paramRoomEntity.x_(), false);
        c.a(paramParcel, 3, paramRoomEntity.y_());
        c.a(paramParcel, 4, paramRoomEntity.e());
        c.a(paramParcel, 5, paramRoomEntity.f(), false);
        c.a(paramParcel, 6, paramRoomEntity.g());
        c.a(paramParcel, 7, paramRoomEntity.h(), false);
        c.c(paramParcel, 8, paramRoomEntity.l(), false);
        c.a(paramParcel, 9, paramRoomEntity.i());
        c.a(paramParcel, paramInt);
    }

    public RoomEntity a(Parcel paramParcel) {
        int i = 0;
        ArrayList localArrayList = null;
        int n = a.b(paramParcel);
        long l = 0L;
        Bundle localBundle = null;
        int j = 0;
        String str1 = null;
        int k = 0;
        String str2 = null;
        String str3 = null;
        int m = 0;
        while (paramParcel.dataPosition() < n) {
            int i1 = a.a(paramParcel);
            switch (a.a(i1)) {
                default:
                    a.b(paramParcel, i1);
                    break;
                case 1:
                    str3 = a.o(paramParcel, i1);
                    break;
                case 1000:
                    m = a.g(paramParcel, i1);
                    break;
                case 2:
                    str2 = a.o(paramParcel, i1);
                    break;
                case 3:
                    l = a.i(paramParcel, i1);
                    break;
                case 4:
                    k = a.g(paramParcel, i1);
                    break;
                case 5:
                    str1 = a.o(paramParcel, i1);
                    break;
                case 6:
                    j = a.g(paramParcel, i1);
                    break;
                case 7:
                    localBundle = a.q(paramParcel, i1);
                    break;
                case 8:
                    localArrayList = a.c(paramParcel, i1, ParticipantEntity.CREATOR);
                    break;
                case 9:
                    i = a.g(paramParcel, i1);
            }
        }
        if (paramParcel.dataPosition() != n) {
            throw new b("Overread allowed size end=" + n, paramParcel);
        }
        return new RoomEntity(m, str3, str2, l, k, str1, j, localBundle, localArrayList, i);
    }

    public RoomEntity[] a(int paramInt) {
        return new RoomEntity[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */