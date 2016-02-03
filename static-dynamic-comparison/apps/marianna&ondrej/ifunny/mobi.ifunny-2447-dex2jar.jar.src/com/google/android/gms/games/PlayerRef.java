package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.b;

public final class PlayerRef
        extends f
        implements Player {
    private final b c;
    private final PlayerLevelInfo d;
    private final MostRecentGameInfoRef e;

    public PlayerRef(DataHolder paramDataHolder, int paramInt) {
        this(paramDataHolder, paramInt, null);
    }

    public PlayerRef(DataHolder paramDataHolder, int paramInt, String paramString) {
        super(paramDataHolder, paramInt);
        this.c = new b(paramString);
        this.e = new MostRecentGameInfoRef(paramDataHolder, paramInt, this.c);
        int i;
        if (p()) {
            paramInt = c(this.c.k);
            i = c(this.c.n);
            paramString = new PlayerLevel(paramInt, b(this.c.l), b(this.c.m));
            if (paramInt == i) {
                break label178;
            }
        }
        label178:
        for (paramDataHolder = new PlayerLevel(i, b(this.c.m), b(this.c.o)); ; paramDataHolder = paramString) {
            this.d = new PlayerLevelInfo(b(this.c.j), b(this.c.p), paramString, paramDataHolder);
            return;
            this.d = null;
            return;
        }
    }

    private boolean p() {
        if (i(this.c.j)) {
        }
        while (b(this.c.j) == -1L) {
            return false;
        }
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return e(this.c.d);
    }

    public boolean equals(Object paramObject) {
        return PlayerEntity.a(this, paramObject);
    }

    public Uri f() {
        return h(this.c.e);
    }

    public String g() {
        return e(this.c.f);
    }

    public String g_() {
        return e(this.c.a);
    }

    public long h() {
        return b(this.c.g);
    }

    public String h_() {
        return e(this.c.b);
    }

    public int hashCode() {
        return PlayerEntity.a(this);
    }

    public long i() {
        if ((!a(this.c.i)) || (i(this.c.i))) {
            return -1L;
        }
        return b(this.c.i);
    }

    public Uri i_() {
        return h(this.c.c);
    }

    public int j() {
        return c(this.c.h);
    }

    public boolean k() {
        return d(this.c.s);
    }

    public String l() {
        return e(this.c.q);
    }

    public PlayerLevelInfo m() {
        return this.d;
    }

    public MostRecentGameInfo n() {
        if (i(this.c.t)) {
            return null;
        }
        return this.e;
    }

    public Player o() {
        return new PlayerEntity(this);
    }

    public String toString() {
        return PlayerEntity.b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((PlayerEntity) o()).writeToParcel(paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/PlayerRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */