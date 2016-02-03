package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PlayerLevelInfo
        implements SafeParcelable {
    public static final f CREATOR = new f();
    private final int a;
    private final long b;
    private final long c;
    private final PlayerLevel d;
    private final PlayerLevel e;

    PlayerLevelInfo(int paramInt, long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2) {
        if (paramLong1 != -1L) {
        }
        for (boolean bool = true; ; bool = false) {
            ag.a(bool);
            ag.a(paramPlayerLevel1);
            ag.a(paramPlayerLevel2);
            this.a = paramInt;
            this.b = paramLong1;
            this.c = paramLong2;
            this.d = paramPlayerLevel1;
            this.e = paramPlayerLevel2;
            return;
        }
    }

    public PlayerLevelInfo(long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2) {
        this(1, paramLong1, paramLong2, paramPlayerLevel1, paramPlayerLevel2);
    }

    public int a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public PlayerLevel d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public PlayerLevel e() {
        return this.e;
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof PlayerLevelInfo)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramObject == this);
            paramObject = (PlayerLevelInfo) paramObject;
            if ((!ad.a(Long.valueOf(this.b), Long.valueOf(((PlayerLevelInfo) paramObject).b))) || (!ad.a(Long.valueOf(this.c), Long.valueOf(((PlayerLevelInfo) paramObject).c))) || (!ad.a(this.d, ((PlayerLevelInfo) paramObject).d))) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(this.e, ((PlayerLevelInfo) paramObject).e));
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{Long.valueOf(this.b), Long.valueOf(this.c), this.d, this.e});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        f.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/PlayerLevelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */