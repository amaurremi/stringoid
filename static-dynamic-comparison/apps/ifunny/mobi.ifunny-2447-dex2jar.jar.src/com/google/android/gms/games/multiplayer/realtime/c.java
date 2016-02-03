package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.multiplayer.ParticipantEntity;

import java.util.ArrayList;

final class c
        extends d {
    public RoomEntity a(Parcel paramParcel) {
        if ((RoomEntity.a(RoomEntity.m())) || (RoomEntity.b(RoomEntity.class.getCanonicalName()))) {
            return super.a(paramParcel);
        }
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        long l = paramParcel.readLong();
        int j = paramParcel.readInt();
        String str3 = paramParcel.readString();
        int k = paramParcel.readInt();
        Bundle localBundle = paramParcel.readBundle();
        int m = paramParcel.readInt();
        ArrayList localArrayList = new ArrayList(m);
        int i = 0;
        while (i < m) {
            localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
            i += 1;
        }
        return new RoomEntity(2, str1, str2, l, j, str3, k, localBundle, localArrayList, -1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */