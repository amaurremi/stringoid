package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public final class PlayerEntity
        extends GamesDowngradeableSafeParcel
        implements Player {
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new c();
    private final int a;
    private final String b;
    private final String c;
    private final Uri d;
    private final Uri e;
    private final long f;
    private final int g;
    private final long h;
    private final String i;
    private final String j;
    private final String k;
    private final MostRecentGameInfoEntity l;
    private final PlayerLevelInfo m;
    private final boolean n;

    PlayerEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, long paramLong1, int paramInt2, long paramLong2, String paramString3, String paramString4, String paramString5, MostRecentGameInfoEntity paramMostRecentGameInfoEntity, PlayerLevelInfo paramPlayerLevelInfo, boolean paramBoolean) {
        this.a = paramInt1;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramUri1;
        this.i = paramString3;
        this.e = paramUri2;
        this.j = paramString4;
        this.f = paramLong1;
        this.g = paramInt2;
        this.h = paramLong2;
        this.k = paramString5;
        this.n = paramBoolean;
        this.l = paramMostRecentGameInfoEntity;
        this.m = paramPlayerLevelInfo;
    }

    public PlayerEntity(Player paramPlayer) {
        this.a = 11;
        this.b = paramPlayer.g_();
        this.c = paramPlayer.h_();
        this.d = paramPlayer.i_();
        this.i = paramPlayer.e();
        this.e = paramPlayer.f();
        this.j = paramPlayer.g();
        this.f = paramPlayer.h();
        this.g = paramPlayer.j();
        this.h = paramPlayer.i();
        this.k = paramPlayer.l();
        this.n = paramPlayer.k();
        Object localObject = paramPlayer.n();
        if (localObject == null) {
            localObject = null;
            this.l = ((MostRecentGameInfoEntity) localObject);
            this.m = paramPlayer.m();
            b.a(this.b);
            b.a(this.c);
            if (this.f <= 0L) {
                break label190;
            }
        }
        label190:
        for (boolean bool = true; ; bool = false) {
            b.a(bool);
            return;
            localObject = new MostRecentGameInfoEntity((MostRecentGameInfo) localObject);
            break;
        }
    }

    static int a(Player paramPlayer) {
        return ad.a(new Object[]{paramPlayer.g_(), paramPlayer.h_(), paramPlayer.i_(), paramPlayer.f(), Long.valueOf(paramPlayer.h()), paramPlayer.l(), paramPlayer.m()});
    }

    static boolean a(Player paramPlayer, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof Player)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramPlayer == paramObject);
            paramObject = (Player) paramObject;
            if ((!ad.a(((Player) paramObject).g_(), paramPlayer.g_())) || (!ad.a(((Player) paramObject).h_(), paramPlayer.h_())) || (!ad.a(((Player) paramObject).i_(), paramPlayer.i_())) || (!ad.a(((Player) paramObject).f(), paramPlayer.f())) || (!ad.a(Long.valueOf(((Player) paramObject).h()), Long.valueOf(paramPlayer.h()))) || (!ad.a(((Player) paramObject).l(), paramPlayer.l()))) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(((Player) paramObject).m(), paramPlayer.m()));
        return false;
    }

    static String b(Player paramPlayer) {
        return ad.a(paramPlayer).a("PlayerId", paramPlayer.g_()).a("DisplayName", paramPlayer.h_()).a("IconImageUri", paramPlayer.i_()).a("IconImageUrl", paramPlayer.e()).a("HiResImageUri", paramPlayer.f()).a("HiResImageUrl", paramPlayer.g()).a("RetrievedTimestamp", Long.valueOf(paramPlayer.h())).a("Title", paramPlayer.l()).a("LevelInfo", paramPlayer.m()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.i;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public Uri f() {
        return this.e;
    }

    public String g() {
        return this.j;
    }

    public String g_() {
        return this.b;
    }

    public long h() {
        return this.f;
    }

    public String h_() {
        return this.c;
    }

    public int hashCode() {
        return a(this);
    }

    public long i() {
        return this.h;
    }

    public Uri i_() {
        return this.d;
    }

    public int j() {
        return this.g;
    }

    public boolean k() {
        return this.n;
    }

    public String l() {
        return this.k;
    }

    public PlayerLevelInfo m() {
        return this.m;
    }

    public MostRecentGameInfo n() {
        return this.l;
    }

    public int o() {
        return this.a;
    }

    public Player p() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        Object localObject2 = null;
        if (!d()) {
            d.a(this, paramParcel, paramInt);
            return;
        }
        paramParcel.writeString(this.b);
        paramParcel.writeString(this.c);
        if (this.d == null) {
            localObject1 = null;
            paramParcel.writeString((String) localObject1);
            if (this.e != null) {
                break label82;
            }
        }
        label82:
        for (Object localObject1 = localObject2; ; localObject1 = this.e.toString()) {
            paramParcel.writeString((String) localObject1);
            paramParcel.writeLong(this.f);
            return;
            localObject1 = this.d.toString();
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/PlayerEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */