package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;

import java.util.ArrayList;

public final class TurnBasedMatchEntity
        implements SafeParcelable, TurnBasedMatch {
    public static final b CREATOR = new b();
    private final int b;
    private final GameEntity c;
    private final String d;
    private final String e;
    private final long f;
    private final String g;
    private final long h;
    private final String i;
    private final int j;
    private final int k;
    private final int l;
    private final byte[] m;
    private final ArrayList<ParticipantEntity> n;
    private final String o;
    private final byte[] p;
    private final int q;
    private final Bundle r;
    private final int s;
    private final boolean t;
    private final String u;
    private final String v;

    TurnBasedMatchEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2, String paramString4, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte1, ArrayList<ParticipantEntity> paramArrayList, String paramString5, byte[] paramArrayOfByte2, int paramInt5, Bundle paramBundle, int paramInt6, boolean paramBoolean, String paramString6, String paramString7) {
        this.b = paramInt1;
        this.c = paramGameEntity;
        this.d = paramString1;
        this.e = paramString2;
        this.f = paramLong1;
        this.g = paramString3;
        this.h = paramLong2;
        this.i = paramString4;
        this.j = paramInt2;
        this.s = paramInt6;
        this.k = paramInt3;
        this.l = paramInt4;
        this.m = paramArrayOfByte1;
        this.n = paramArrayList;
        this.o = paramString5;
        this.p = paramArrayOfByte2;
        this.q = paramInt5;
        this.r = paramBundle;
        this.t = paramBoolean;
        this.u = paramString6;
        this.v = paramString7;
    }

    public TurnBasedMatchEntity(TurnBasedMatch paramTurnBasedMatch) {
        this.b = 2;
        this.c = new GameEntity(paramTurnBasedMatch.z_());
        this.d = paramTurnBasedMatch.c();
        this.e = paramTurnBasedMatch.d();
        this.f = paramTurnBasedMatch.e();
        this.g = paramTurnBasedMatch.j();
        this.h = paramTurnBasedMatch.k();
        this.i = paramTurnBasedMatch.m();
        this.j = paramTurnBasedMatch.f();
        this.s = paramTurnBasedMatch.g();
        this.k = paramTurnBasedMatch.i();
        this.l = paramTurnBasedMatch.o();
        this.o = paramTurnBasedMatch.p();
        this.q = paramTurnBasedMatch.r();
        this.r = paramTurnBasedMatch.s();
        this.t = paramTurnBasedMatch.u();
        this.u = paramTurnBasedMatch.h();
        this.v = paramTurnBasedMatch.v();
        byte[] arrayOfByte = paramTurnBasedMatch.n();
        if (arrayOfByte == null) {
            this.m = null;
            arrayOfByte = paramTurnBasedMatch.q();
            if (arrayOfByte != null) {
                break label313;
            }
            this.p = null;
        }
        for (; ; ) {
            paramTurnBasedMatch = paramTurnBasedMatch.l();
            int i2 = paramTurnBasedMatch.size();
            this.n = new ArrayList(i2);
            int i1 = 0;
            while (i1 < i2) {
                this.n.add((ParticipantEntity) ((Participant) paramTurnBasedMatch.get(i1)).a());
                i1 += 1;
            }
            this.m = new byte[arrayOfByte.length];
            System.arraycopy(arrayOfByte, 0, this.m, 0, arrayOfByte.length);
            break;
            label313:
            this.p = new byte[arrayOfByte.length];
            System.arraycopy(arrayOfByte, 0, this.p, 0, arrayOfByte.length);
        }
    }

    static int a(TurnBasedMatch paramTurnBasedMatch) {
        return ad.a(new Object[]{paramTurnBasedMatch.z_(), paramTurnBasedMatch.c(), paramTurnBasedMatch.d(), Long.valueOf(paramTurnBasedMatch.e()), paramTurnBasedMatch.j(), Long.valueOf(paramTurnBasedMatch.k()), paramTurnBasedMatch.m(), Integer.valueOf(paramTurnBasedMatch.f()), Integer.valueOf(paramTurnBasedMatch.g()), paramTurnBasedMatch.h(), Integer.valueOf(paramTurnBasedMatch.i()), Integer.valueOf(paramTurnBasedMatch.o()), paramTurnBasedMatch.l(), paramTurnBasedMatch.p(), Integer.valueOf(paramTurnBasedMatch.r()), paramTurnBasedMatch.s(), Integer.valueOf(paramTurnBasedMatch.t()), Boolean.valueOf(paramTurnBasedMatch.u())});
    }

    static boolean a(TurnBasedMatch paramTurnBasedMatch, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof TurnBasedMatch)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramTurnBasedMatch == paramObject);
            paramObject = (TurnBasedMatch) paramObject;
            if ((!ad.a(((TurnBasedMatch) paramObject).z_(), paramTurnBasedMatch.z_())) || (!ad.a(((TurnBasedMatch) paramObject).c(), paramTurnBasedMatch.c())) || (!ad.a(((TurnBasedMatch) paramObject).d(), paramTurnBasedMatch.d())) || (!ad.a(Long.valueOf(((TurnBasedMatch) paramObject).e()), Long.valueOf(paramTurnBasedMatch.e()))) || (!ad.a(((TurnBasedMatch) paramObject).j(), paramTurnBasedMatch.j())) || (!ad.a(Long.valueOf(((TurnBasedMatch) paramObject).k()), Long.valueOf(paramTurnBasedMatch.k()))) || (!ad.a(((TurnBasedMatch) paramObject).m(), paramTurnBasedMatch.m())) || (!ad.a(Integer.valueOf(((TurnBasedMatch) paramObject).f()), Integer.valueOf(paramTurnBasedMatch.f()))) || (!ad.a(Integer.valueOf(((TurnBasedMatch) paramObject).g()), Integer.valueOf(paramTurnBasedMatch.g()))) || (!ad.a(((TurnBasedMatch) paramObject).h(), paramTurnBasedMatch.h())) || (!ad.a(Integer.valueOf(((TurnBasedMatch) paramObject).i()), Integer.valueOf(paramTurnBasedMatch.i()))) || (!ad.a(Integer.valueOf(((TurnBasedMatch) paramObject).o()), Integer.valueOf(paramTurnBasedMatch.o()))) || (!ad.a(((TurnBasedMatch) paramObject).l(), paramTurnBasedMatch.l())) || (!ad.a(((TurnBasedMatch) paramObject).p(), paramTurnBasedMatch.p())) || (!ad.a(Integer.valueOf(((TurnBasedMatch) paramObject).r()), Integer.valueOf(paramTurnBasedMatch.r()))) || (!ad.a(((TurnBasedMatch) paramObject).s(), paramTurnBasedMatch.s())) || (!ad.a(Integer.valueOf(((TurnBasedMatch) paramObject).t()), Integer.valueOf(paramTurnBasedMatch.t())))) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(Boolean.valueOf(((TurnBasedMatch) paramObject).u()), Boolean.valueOf(paramTurnBasedMatch.u())));
        return false;
    }

    static String b(TurnBasedMatch paramTurnBasedMatch) {
        return ad.a(paramTurnBasedMatch).a("Game", paramTurnBasedMatch.z_()).a("MatchId", paramTurnBasedMatch.c()).a("CreatorId", paramTurnBasedMatch.d()).a("CreationTimestamp", Long.valueOf(paramTurnBasedMatch.e())).a("LastUpdaterId", paramTurnBasedMatch.j()).a("LastUpdatedTimestamp", Long.valueOf(paramTurnBasedMatch.k())).a("PendingParticipantId", paramTurnBasedMatch.m()).a("MatchStatus", Integer.valueOf(paramTurnBasedMatch.f())).a("TurnStatus", Integer.valueOf(paramTurnBasedMatch.g())).a("Description", paramTurnBasedMatch.h()).a("Variant", Integer.valueOf(paramTurnBasedMatch.i())).a("Data", paramTurnBasedMatch.n()).a("Version", Integer.valueOf(paramTurnBasedMatch.o())).a("Participants", paramTurnBasedMatch.l()).a("RematchId", paramTurnBasedMatch.p()).a("PreviousData", paramTurnBasedMatch.q()).a("MatchNumber", Integer.valueOf(paramTurnBasedMatch.r())).a("AutoMatchCriteria", paramTurnBasedMatch.s()).a("AvailableAutoMatchSlots", Integer.valueOf(paramTurnBasedMatch.t())).a("LocallyModified", Boolean.valueOf(paramTurnBasedMatch.u())).a("DescriptionParticipantId", paramTurnBasedMatch.v()).toString();
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public int f() {
        return this.j;
    }

    public int g() {
        return this.s;
    }

    public String h() {
        return this.u;
    }

    public int hashCode() {
        return a(this);
    }

    public int i() {
        return this.k;
    }

    public String j() {
        return this.g;
    }

    public long k() {
        return this.h;
    }

    public ArrayList<Participant> l() {
        return new ArrayList(this.n);
    }

    public String m() {
        return this.i;
    }

    public byte[] n() {
        return this.m;
    }

    public int o() {
        return this.l;
    }

    public String p() {
        return this.o;
    }

    public byte[] q() {
        return this.p;
    }

    public int r() {
        return this.q;
    }

    public Bundle s() {
        return this.r;
    }

    public int t() {
        if (this.r == null) {
            return 0;
        }
        return this.r.getInt("max_automatch_players");
    }

    public String toString() {
        return b(this);
    }

    public boolean u() {
        return this.t;
    }

    public String v() {
        return this.v;
    }

    public int w() {
        return this.b;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }

    public TurnBasedMatch x() {
        return this;
    }

    public Game z_() {
        return this.c;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */