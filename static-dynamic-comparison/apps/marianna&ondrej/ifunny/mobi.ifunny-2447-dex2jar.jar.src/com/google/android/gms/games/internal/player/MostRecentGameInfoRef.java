package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public final class MostRecentGameInfoRef
        extends f
        implements MostRecentGameInfo {
    private final b c;

    public MostRecentGameInfoRef(DataHolder paramDataHolder, int paramInt, b paramb) {
        super(paramDataHolder, paramInt);
        this.c = paramb;
    }

    public String c() {
        return e(this.c.u);
    }

    public long d() {
        return b(this.c.v);
    }

    public int describeContents() {
        return 0;
    }

    public Uri e() {
        return h(this.c.w);
    }

    public boolean equals(Object paramObject) {
        return MostRecentGameInfoEntity.a(this, paramObject);
    }

    public Uri f() {
        return h(this.c.x);
    }

    public Uri g() {
        return h(this.c.y);
    }

    public MostRecentGameInfo h() {
        return new MostRecentGameInfoEntity(this);
    }

    public int hashCode() {
        return MostRecentGameInfoEntity.a(this);
    }

    public String r_() {
        return e(this.c.t);
    }

    public String toString() {
        return MostRecentGameInfoEntity.b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((MostRecentGameInfoEntity) h()).writeToParcel(paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/player/MostRecentGameInfoRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */