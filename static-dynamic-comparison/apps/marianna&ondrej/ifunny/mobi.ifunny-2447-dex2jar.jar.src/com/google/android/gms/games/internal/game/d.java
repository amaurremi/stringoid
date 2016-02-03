package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class d
        implements Parcelable.Creator<GameBadgeEntity> {
    static void a(GameBadgeEntity paramGameBadgeEntity, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramGameBadgeEntity.o_());
        c.a(paramParcel, 1000, paramGameBadgeEntity.f());
        c.a(paramParcel, 2, paramGameBadgeEntity.p_(), false);
        c.a(paramParcel, 3, paramGameBadgeEntity.q_(), false);
        c.a(paramParcel, 4, paramGameBadgeEntity.e(), paramInt, false);
        c.a(paramParcel, i);
    }

    public GameBadgeEntity a(Parcel paramParcel) {
        int i = 0;
        Uri localUri = null;
        int k = a.b(paramParcel);
        String str1 = null;
        String str2 = null;
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
                    str2 = a.o(paramParcel, m);
                    break;
                case 3:
                    str1 = a.o(paramParcel, m);
                    break;
                case 4:
                    localUri = (Uri) a.a(paramParcel, m, Uri.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new GameBadgeEntity(j, i, str2, str1, localUri);
    }

    public GameBadgeEntity[] a(int paramInt) {
        return new GameBadgeEntity[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/game/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */