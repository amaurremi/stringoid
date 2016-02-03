package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataRef;

import java.util.ArrayList;

public class ExtendedGameRef
        extends f
        implements ExtendedGame {
    private final GameRef c;
    private final SnapshotMetadataRef d;
    private final int e;

    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return d("owned");
    }

    public boolean equals(Object paramObject) {
        return ExtendedGameEntity.a(this, paramObject);
    }

    public int f() {
        return c("achievement_unlocked_count");
    }

    public long g() {
        return b("last_played_server_time");
    }

    public long h() {
        return b("price_micros");
    }

    public int hashCode() {
        return ExtendedGameEntity.a(this);
    }

    public String i() {
        return e("formatted_price");
    }

    public long j() {
        return b("full_price_micros");
    }

    public String k() {
        return e("formatted_full_price");
    }

    public SnapshotMetadata l() {
        return this.d;
    }

    public ArrayList<GameBadge> l_() {
        int i = 0;
        if (this.a.c("badge_title", this.b, this.a.a(this.b)) == null) {
            return new ArrayList(0);
        }
        ArrayList localArrayList = new ArrayList(this.e);
        while (i < this.e) {
            localArrayList.add(new GameBadgeRef(this.a, this.b + i));
            i += 1;
        }
        return localArrayList;
    }

    public ExtendedGame m() {
        return new ExtendedGameEntity(this);
    }

    public int m_() {
        return c("availability");
    }

    public Game n_() {
        return this.c;
    }

    public String toString() {
        return ExtendedGameEntity.b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((ExtendedGameEntity) m()).writeToParcel(paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/game/ExtendedGameRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */