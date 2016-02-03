package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

import java.util.ArrayList;

public final class ExtendedGameEntity
        extends GamesDowngradeableSafeParcel
        implements ExtendedGame {
    public static final b CREATOR = new a();
    private final int a;
    private final GameEntity b;
    private final int c;
    private final boolean d;
    private final int e;
    private final long f;
    private final long g;
    private final String h;
    private final long i;
    private final String j;
    private final ArrayList<GameBadgeEntity> k;
    private final SnapshotMetadataEntity l;

    ExtendedGameEntity(int paramInt1, GameEntity paramGameEntity, int paramInt2, boolean paramBoolean, int paramInt3, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, ArrayList<GameBadgeEntity> paramArrayList, SnapshotMetadataEntity paramSnapshotMetadataEntity) {
        this.a = paramInt1;
        this.b = paramGameEntity;
        this.c = paramInt2;
        this.d = paramBoolean;
        this.e = paramInt3;
        this.f = paramLong1;
        this.g = paramLong2;
        this.h = paramString1;
        this.i = paramLong3;
        this.j = paramString2;
        this.k = paramArrayList;
        this.l = paramSnapshotMetadataEntity;
    }

    public ExtendedGameEntity(ExtendedGame paramExtendedGame) {
        this.a = 2;
        Object localObject1 = paramExtendedGame.n_();
        if (localObject1 == null) {
            localObject1 = null;
            this.b = ((GameEntity) localObject1);
            this.c = paramExtendedGame.m_();
            this.d = paramExtendedGame.e();
            this.e = paramExtendedGame.f();
            this.f = paramExtendedGame.g();
            this.g = paramExtendedGame.h();
            this.h = paramExtendedGame.i();
            this.i = paramExtendedGame.j();
            this.j = paramExtendedGame.k();
            localObject1 = paramExtendedGame.l();
            if (localObject1 != null) {
                break label213;
            }
        }
        label213:
        for (localObject1 = localObject2; ; localObject1 = new SnapshotMetadataEntity((SnapshotMetadata) localObject1)) {
            this.l = ((SnapshotMetadataEntity) localObject1);
            paramExtendedGame = paramExtendedGame.l_();
            int n = paramExtendedGame.size();
            this.k = new ArrayList(n);
            int m = 0;
            while (m < n) {
                this.k.add((GameBadgeEntity) ((GameBadge) paramExtendedGame.get(m)).a());
                m += 1;
            }
            localObject1 = new GameEntity((Game) localObject1);
            break;
        }
    }

    static int a(ExtendedGame paramExtendedGame) {
        return ad.a(new Object[]{paramExtendedGame.n_(), Integer.valueOf(paramExtendedGame.m_()), Boolean.valueOf(paramExtendedGame.e()), Integer.valueOf(paramExtendedGame.f()), Long.valueOf(paramExtendedGame.g()), Long.valueOf(paramExtendedGame.h()), paramExtendedGame.i(), Long.valueOf(paramExtendedGame.j()), paramExtendedGame.k()});
    }

    static boolean a(ExtendedGame paramExtendedGame, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof ExtendedGame)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramExtendedGame == paramObject);
            paramObject = (ExtendedGame) paramObject;
            if ((!ad.a(((ExtendedGame) paramObject).n_(), paramExtendedGame.n_())) || (!ad.a(Integer.valueOf(((ExtendedGame) paramObject).m_()), Integer.valueOf(paramExtendedGame.m_()))) || (!ad.a(Boolean.valueOf(((ExtendedGame) paramObject).e()), Boolean.valueOf(paramExtendedGame.e()))) || (!ad.a(Integer.valueOf(((ExtendedGame) paramObject).f()), Integer.valueOf(paramExtendedGame.f()))) || (!ad.a(Long.valueOf(((ExtendedGame) paramObject).g()), Long.valueOf(paramExtendedGame.g()))) || (!ad.a(Long.valueOf(((ExtendedGame) paramObject).h()), Long.valueOf(paramExtendedGame.h()))) || (!ad.a(((ExtendedGame) paramObject).i(), paramExtendedGame.i())) || (!ad.a(Long.valueOf(((ExtendedGame) paramObject).j()), Long.valueOf(paramExtendedGame.j())))) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(((ExtendedGame) paramObject).k(), paramExtendedGame.k()));
        return false;
    }

    static String b(ExtendedGame paramExtendedGame) {
        return ad.a(paramExtendedGame).a("Game", paramExtendedGame.n_()).a("Availability", Integer.valueOf(paramExtendedGame.m_())).a("Owned", Boolean.valueOf(paramExtendedGame.e())).a("AchievementUnlockedCount", Integer.valueOf(paramExtendedGame.f())).a("LastPlayedServerTimestamp", Long.valueOf(paramExtendedGame.g())).a("PriceMicros", Long.valueOf(paramExtendedGame.h())).a("FormattedPrice", paramExtendedGame.i()).a("FullPriceMicros", Long.valueOf(paramExtendedGame.j())).a("FormattedFullPrice", paramExtendedGame.k()).a("Snapshot", paramExtendedGame.l()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.d;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public int f() {
        return this.e;
    }

    public long g() {
        return this.f;
    }

    public long h() {
        return this.g;
    }

    public int hashCode() {
        return a(this);
    }

    public String i() {
        return this.h;
    }

    public long j() {
        return this.i;
    }

    public String k() {
        return this.j;
    }

    public SnapshotMetadata l() {
        return this.l;
    }

    public ArrayList<GameBadge> l_() {
        return new ArrayList(this.k);
    }

    public int m() {
        return this.a;
    }

    public int m_() {
        return this.c;
    }

    public GameEntity n() {
        return this.b;
    }

    public ExtendedGame o() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        int n = 0;
        if (!d()) {
            b.a(this, paramParcel, paramInt);
            return;
        }
        this.b.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.c);
        if (this.d) {
        }
        for (int m = 1; ; m = 0) {
            paramParcel.writeInt(m);
            paramParcel.writeInt(this.e);
            paramParcel.writeLong(this.f);
            paramParcel.writeLong(this.g);
            paramParcel.writeString(this.h);
            paramParcel.writeLong(this.i);
            paramParcel.writeString(this.j);
            int i1 = this.k.size();
            paramParcel.writeInt(i1);
            m = n;
            while (m < i1) {
                ((GameBadgeEntity) this.k.get(m)).writeToParcel(paramParcel, paramInt);
                m += 1;
            }
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/game/ExtendedGameEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */