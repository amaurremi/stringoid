package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;

final class c
        extends d {
    public GameBadgeEntity a(Parcel paramParcel) {
        if ((GameBadgeEntity.a(GameBadgeEntity.h())) || (GameBadgeEntity.b(GameBadgeEntity.class.getCanonicalName()))) {
            return super.a(paramParcel);
        }
        int i = paramParcel.readInt();
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        paramParcel = paramParcel.readString();
        if (paramParcel == null) {
        }
        for (paramParcel = null; ; paramParcel = Uri.parse(paramParcel)) {
            return new GameBadgeEntity(1, i, str1, str2, paramParcel);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/game/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */