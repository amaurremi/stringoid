package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

public final class AchievementEntity
        implements SafeParcelable, Achievement {
    public static final a CREATOR = new a();
    private final int a;
    private final String b;
    private final int c;
    private final String d;
    private final String e;
    private final Uri f;
    private final String g;
    private final Uri h;
    private final String i;
    private final int j;
    private final String k;
    private final PlayerEntity l;
    private final int m;
    private final int n;
    private final String o;
    private final long p;
    private final long q;

    AchievementEntity(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, Uri paramUri1, String paramString4, Uri paramUri2, String paramString5, int paramInt3, String paramString6, PlayerEntity paramPlayerEntity, int paramInt4, int paramInt5, String paramString7, long paramLong1, long paramLong2) {
        this.a = paramInt1;
        this.b = paramString1;
        this.c = paramInt2;
        this.d = paramString2;
        this.e = paramString3;
        this.f = paramUri1;
        this.g = paramString4;
        this.h = paramUri2;
        this.i = paramString5;
        this.j = paramInt3;
        this.k = paramString6;
        this.l = paramPlayerEntity;
        this.m = paramInt4;
        this.n = paramInt5;
        this.o = paramString7;
        this.p = paramLong1;
        this.q = paramLong2;
    }

    public AchievementEntity(Achievement paramAchievement) {
        this.a = 1;
        this.b = paramAchievement.j_();
        this.c = paramAchievement.c();
        this.d = paramAchievement.d();
        this.e = paramAchievement.e();
        this.f = paramAchievement.f();
        this.g = paramAchievement.g();
        this.h = paramAchievement.h();
        this.i = paramAchievement.i();
        this.l = ((PlayerEntity) paramAchievement.l().a());
        this.m = paramAchievement.m();
        this.p = paramAchievement.p();
        this.q = paramAchievement.q();
        if (paramAchievement.c() == 1) {
            this.j = paramAchievement.j();
            this.k = paramAchievement.k();
            this.n = paramAchievement.n();
        }
        for (this.o = paramAchievement.o(); ; this.o = null) {
            b.a(this.b);
            b.a(this.e);
            return;
            this.j = 0;
            this.k = null;
            this.n = 0;
        }
    }

    static int a(Achievement paramAchievement) {
        int i2;
        int i1;
        if (paramAchievement.c() == 1) {
            i2 = paramAchievement.n();
            i1 = paramAchievement.j();
        }
        for (; ; ) {
            return ad.a(new Object[]{paramAchievement.j_(), paramAchievement.d(), Integer.valueOf(paramAchievement.c()), paramAchievement.e(), Long.valueOf(paramAchievement.q()), Integer.valueOf(paramAchievement.m()), Long.valueOf(paramAchievement.p()), paramAchievement.l(), Integer.valueOf(i2), Integer.valueOf(i1)});
            i1 = 0;
            i2 = 0;
        }
    }

    static boolean a(Achievement paramAchievement, Object paramObject) {
        boolean bool3 = true;
        boolean bool2;
        if (!(paramObject instanceof Achievement)) {
            bool2 = false;
        }
        do {
            return bool2;
            bool2 = bool3;
        } while (paramAchievement == paramObject);
        paramObject = (Achievement) paramObject;
        boolean bool1;
        if (paramAchievement.c() == 1) {
            bool2 = ad.a(Integer.valueOf(((Achievement) paramObject).n()), Integer.valueOf(paramAchievement.n()));
            bool1 = ad.a(Integer.valueOf(((Achievement) paramObject).j()), Integer.valueOf(paramAchievement.j()));
        }
        for (; ; ) {
            if ((ad.a(((Achievement) paramObject).j_(), paramAchievement.j_())) && (ad.a(((Achievement) paramObject).d(), paramAchievement.d())) && (ad.a(Integer.valueOf(((Achievement) paramObject).c()), Integer.valueOf(paramAchievement.c()))) && (ad.a(((Achievement) paramObject).e(), paramAchievement.e())) && (ad.a(Long.valueOf(((Achievement) paramObject).q()), Long.valueOf(paramAchievement.q()))) && (ad.a(Integer.valueOf(((Achievement) paramObject).m()), Integer.valueOf(paramAchievement.m()))) && (ad.a(Long.valueOf(((Achievement) paramObject).p()), Long.valueOf(paramAchievement.p()))) && (ad.a(((Achievement) paramObject).l(), paramAchievement.l())) && (bool2)) {
                bool2 = bool3;
                if (bool1) {
                    break;
                }
            }
            return false;
            bool1 = true;
            bool2 = true;
        }
    }

    static String b(Achievement paramAchievement) {
        af localaf = ad.a(paramAchievement).a("Id", paramAchievement.j_()).a("Type", Integer.valueOf(paramAchievement.c())).a("Name", paramAchievement.d()).a("Description", paramAchievement.e()).a("Player", paramAchievement.l()).a("State", Integer.valueOf(paramAchievement.m()));
        if (paramAchievement.c() == 1) {
            localaf.a("CurrentSteps", Integer.valueOf(paramAchievement.n()));
            localaf.a("TotalSteps", Integer.valueOf(paramAchievement.j()));
        }
        return localaf.toString();
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.e;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public Uri f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public Uri h() {
        return this.h;
    }

    public int hashCode() {
        return a(this);
    }

    public String i() {
        return this.i;
    }

    public int j() {
        return this.j;
    }

    public String j_() {
        return this.b;
    }

    public String k() {
        return this.k;
    }

    public Player l() {
        return this.l;
    }

    public int m() {
        return this.m;
    }

    public int n() {
        return this.n;
    }

    public String o() {
        return this.o;
    }

    public long p() {
        return this.p;
    }

    public long q() {
        return this.q;
    }

    public int r() {
        return this.a;
    }

    public Achievement s() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/achievement/AchievementEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */