package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PlayerLevel
        implements SafeParcelable {
    public static final e CREATOR = new e();
    private final int a;
    private final int b;
    private final long c;
    private final long d;

    PlayerLevel(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
        if (paramLong1 >= 0L) {
            bool1 = true;
            ag.a(bool1, "Min XP must be positive!");
            if (paramLong2 <= paramLong1) {
                break label69;
            }
        }
        label69:
        for (boolean bool1 = bool2; ; bool1 = false) {
            ag.a(bool1, "Max XP must be more than min XP!");
            this.a = paramInt1;
            this.b = paramInt2;
            this.c = paramLong1;
            this.d = paramLong2;
            return;
            bool1 = false;
            break;
        }
    }

    public PlayerLevel(int paramInt, long paramLong1, long paramLong2) {
        this(1, paramInt, paramLong1, paramLong2);
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof PlayerLevel)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (this == paramObject);
            paramObject = (PlayerLevel) paramObject;
            if ((!ad.a(Integer.valueOf(((PlayerLevel) paramObject).b()), Integer.valueOf(b()))) || (!ad.a(Long.valueOf(((PlayerLevel) paramObject).c()), Long.valueOf(c())))) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(Long.valueOf(((PlayerLevel) paramObject).d()), Long.valueOf(d())));
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{Integer.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d)});
    }

    public String toString() {
        return ad.a(this).a("LevelNumber", Integer.valueOf(b())).a("MinXp", Long.valueOf(c())).a("MaxXp", Long.valueOf(d())).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        e.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/PlayerLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */