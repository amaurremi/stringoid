package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;

import java.util.ArrayList;
import java.util.List;

public final class QuestEntity
        implements SafeParcelable, Quest {
    public static final b CREATOR = new b();
    private final int c;
    private final GameEntity d;
    private final String e;
    private final long f;
    private final Uri g;
    private final String h;
    private final String i;
    private final long j;
    private final long k;
    private final Uri l;
    private final String m;
    private final String n;
    private final long o;
    private final long p;
    private final int q;
    private final int r;
    private final ArrayList<MilestoneEntity> s;

    QuestEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, long paramLong1, Uri paramUri1, String paramString2, String paramString3, long paramLong2, long paramLong3, Uri paramUri2, String paramString4, String paramString5, long paramLong4, long paramLong5, int paramInt2, int paramInt3, ArrayList<MilestoneEntity> paramArrayList) {
        this.c = paramInt1;
        this.d = paramGameEntity;
        this.e = paramString1;
        this.f = paramLong1;
        this.g = paramUri1;
        this.h = paramString2;
        this.i = paramString3;
        this.j = paramLong2;
        this.k = paramLong3;
        this.l = paramUri2;
        this.m = paramString4;
        this.n = paramString5;
        this.o = paramLong4;
        this.p = paramLong5;
        this.q = paramInt2;
        this.r = paramInt3;
        this.s = paramArrayList;
    }

    public QuestEntity(Quest paramQuest) {
        this.c = 2;
        this.d = new GameEntity(paramQuest.j());
        this.e = paramQuest.B_();
        this.f = paramQuest.m();
        this.i = paramQuest.d();
        this.g = paramQuest.e();
        this.h = paramQuest.f();
        this.j = paramQuest.n();
        this.l = paramQuest.g();
        this.m = paramQuest.h();
        this.k = paramQuest.o();
        this.n = paramQuest.c();
        this.o = paramQuest.p();
        this.p = paramQuest.q();
        this.q = paramQuest.k();
        this.r = paramQuest.l();
        paramQuest = paramQuest.i();
        int i2 = paramQuest.size();
        this.s = new ArrayList(i2);
        int i1 = 0;
        while (i1 < i2) {
            this.s.add((MilestoneEntity) ((Milestone) paramQuest.get(i1)).a());
            i1 += 1;
        }
    }

    static int a(Quest paramQuest) {
        return ad.a(new Object[]{paramQuest.j(), paramQuest.B_(), Long.valueOf(paramQuest.m()), paramQuest.e(), paramQuest.d(), Long.valueOf(paramQuest.n()), paramQuest.g(), Long.valueOf(paramQuest.o()), paramQuest.i(), paramQuest.c(), Long.valueOf(paramQuest.p()), Long.valueOf(paramQuest.q()), Integer.valueOf(paramQuest.k())});
    }

    static boolean a(Quest paramQuest, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof Quest)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramQuest == paramObject);
            paramObject = (Quest) paramObject;
            if ((!ad.a(((Quest) paramObject).j(), paramQuest.j())) || (!ad.a(((Quest) paramObject).B_(), paramQuest.B_())) || (!ad.a(Long.valueOf(((Quest) paramObject).m()), Long.valueOf(paramQuest.m()))) || (!ad.a(((Quest) paramObject).e(), paramQuest.e())) || (!ad.a(((Quest) paramObject).d(), paramQuest.d())) || (!ad.a(Long.valueOf(((Quest) paramObject).n()), Long.valueOf(paramQuest.n()))) || (!ad.a(((Quest) paramObject).g(), paramQuest.g())) || (!ad.a(Long.valueOf(((Quest) paramObject).o()), Long.valueOf(paramQuest.o()))) || (!ad.a(((Quest) paramObject).i(), paramQuest.i())) || (!ad.a(((Quest) paramObject).c(), paramQuest.c())) || (!ad.a(Long.valueOf(((Quest) paramObject).p()), Long.valueOf(paramQuest.p()))) || (!ad.a(Long.valueOf(((Quest) paramObject).q()), Long.valueOf(paramQuest.q())))) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(Integer.valueOf(((Quest) paramObject).k()), Integer.valueOf(paramQuest.k())));
        return false;
    }

    static String b(Quest paramQuest) {
        return ad.a(paramQuest).a("Game", paramQuest.j()).a("QuestId", paramQuest.B_()).a("AcceptedTimestamp", Long.valueOf(paramQuest.m())).a("BannerImageUri", paramQuest.e()).a("BannerImageUrl", paramQuest.f()).a("Description", paramQuest.d()).a("EndTimestamp", Long.valueOf(paramQuest.n())).a("IconImageUri", paramQuest.g()).a("IconImageUrl", paramQuest.h()).a("LastUpdatedTimestamp", Long.valueOf(paramQuest.o())).a("Milestones", paramQuest.i()).a("Name", paramQuest.c()).a("NotifyTimestamp", Long.valueOf(paramQuest.p())).a("StartTimestamp", Long.valueOf(paramQuest.q())).a("State", Integer.valueOf(paramQuest.k())).toString();
    }

    public String B_() {
        return this.e;
    }

    public String c() {
        return this.n;
    }

    public String d() {
        return this.i;
    }

    public int describeContents() {
        return 0;
    }

    public Uri e() {
        return this.g;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public String f() {
        return this.h;
    }

    public Uri g() {
        return this.l;
    }

    public String h() {
        return this.m;
    }

    public int hashCode() {
        return a(this);
    }

    public List<Milestone> i() {
        return new ArrayList(this.s);
    }

    public Game j() {
        return this.d;
    }

    public int k() {
        return this.q;
    }

    public int l() {
        return this.r;
    }

    public long m() {
        return this.f;
    }

    public long n() {
        return this.j;
    }

    public long o() {
        return this.k;
    }

    public long p() {
        return this.o;
    }

    public long q() {
        return this.p;
    }

    public int r() {
        return this.c;
    }

    public Quest s() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/quest/QuestEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */