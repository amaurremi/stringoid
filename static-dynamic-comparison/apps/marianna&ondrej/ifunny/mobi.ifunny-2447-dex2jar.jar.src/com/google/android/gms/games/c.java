package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;

final class c
        extends d {
    public PlayerEntity a(Parcel paramParcel) {
        if ((PlayerEntity.a(PlayerEntity.q())) || (PlayerEntity.b(PlayerEntity.class.getCanonicalName()))) {
            return super.a(paramParcel);
        }
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        Object localObject1 = paramParcel.readString();
        Object localObject2 = paramParcel.readString();
        if (localObject1 == null) {
            localObject1 = null;
            if (localObject2 != null) {
                break label98;
            }
        }
        label98:
        for (localObject2 = null; ; localObject2 = Uri.parse((String) localObject2)) {
            return new PlayerEntity(11, str1, str2, (Uri) localObject1, (Uri) localObject2, paramParcel.readLong(), -1, -1L, null, null, null, null, null, true);
            localObject1 = Uri.parse((String) localObject1);
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */