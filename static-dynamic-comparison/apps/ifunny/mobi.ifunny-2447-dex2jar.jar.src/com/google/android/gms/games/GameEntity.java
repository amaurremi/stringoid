package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameEntity
        extends GamesDowngradeableSafeParcel
        implements Game {
    public static final Parcelable.Creator<GameEntity> CREATOR = new a();
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final Uri h;
    private final Uri i;
    private final Uri j;
    private final boolean k;
    private final boolean l;
    private final String m;
    private final int n;
    private final int o;
    private final int p;
    private final boolean q;
    private final boolean r;
    private final String s;
    private final String t;
    private final String u;
    private final boolean v;
    private final boolean w;
    private final boolean x;
    private final String y;

    GameEntity(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri1, Uri paramUri2, Uri paramUri3, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString8, String paramString9, String paramString10, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString11) {
        this.a = paramInt1;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramString3;
        this.e = paramString4;
        this.f = paramString5;
        this.g = paramString6;
        this.h = paramUri1;
        this.s = paramString8;
        this.i = paramUri2;
        this.t = paramString9;
        this.j = paramUri3;
        this.u = paramString10;
        this.k = paramBoolean1;
        this.l = paramBoolean2;
        this.m = paramString7;
        this.n = paramInt2;
        this.o = paramInt3;
        this.p = paramInt4;
        this.q = paramBoolean3;
        this.r = paramBoolean4;
        this.v = paramBoolean5;
        this.w = paramBoolean6;
        this.x = paramBoolean7;
        this.y = paramString11;
    }

    public GameEntity(Game paramGame) {
        this.a = 5;
        this.b = paramGame.d_();
        this.d = paramGame.f_();
        this.e = paramGame.e();
        this.f = paramGame.f();
        this.g = paramGame.g();
        this.c = paramGame.e_();
        this.h = paramGame.h();
        this.s = paramGame.i();
        this.i = paramGame.j();
        this.t = paramGame.k();
        this.j = paramGame.l();
        this.u = paramGame.m();
        this.k = paramGame.n();
        this.l = paramGame.q();
        this.m = paramGame.r();
        this.n = paramGame.s();
        this.o = paramGame.t();
        this.p = paramGame.u();
        this.q = paramGame.v();
        this.r = paramGame.w();
        this.v = paramGame.o();
        this.w = paramGame.p();
        this.x = paramGame.x();
        this.y = paramGame.y();
    }

    static int a(Game paramGame) {
        return ad.a(new Object[]{paramGame.d_(), paramGame.e_(), paramGame.f_(), paramGame.e(), paramGame.f(), paramGame.g(), paramGame.h(), paramGame.j(), paramGame.l(), Boolean.valueOf(paramGame.n()), Boolean.valueOf(paramGame.q()), paramGame.r(), Integer.valueOf(paramGame.s()), Integer.valueOf(paramGame.t()), Integer.valueOf(paramGame.u()), Boolean.valueOf(paramGame.v()), Boolean.valueOf(paramGame.w()), Boolean.valueOf(paramGame.o()), Boolean.valueOf(paramGame.p()), Boolean.valueOf(paramGame.x()), paramGame.y()});
    }

    static boolean a(Game paramGame, Object paramObject) {
        boolean bool2 = true;
        if (!(paramObject instanceof Game)) {
            bool1 = false;
        }
        do {
            return bool1;
            bool1 = bool2;
        } while (paramGame == paramObject);
        paramObject = (Game) paramObject;
        boolean bool3;
        if ((ad.a(((Game) paramObject).d_(), paramGame.d_())) && (ad.a(((Game) paramObject).e_(), paramGame.e_())) && (ad.a(((Game) paramObject).f_(), paramGame.f_())) && (ad.a(((Game) paramObject).e(), paramGame.e())) && (ad.a(((Game) paramObject).f(), paramGame.f())) && (ad.a(((Game) paramObject).g(), paramGame.g())) && (ad.a(((Game) paramObject).h(), paramGame.h())) && (ad.a(((Game) paramObject).j(), paramGame.j())) && (ad.a(((Game) paramObject).l(), paramGame.l())) && (ad.a(Boolean.valueOf(((Game) paramObject).n()), Boolean.valueOf(paramGame.n()))) && (ad.a(Boolean.valueOf(((Game) paramObject).q()), Boolean.valueOf(paramGame.q()))) && (ad.a(((Game) paramObject).r(), paramGame.r())) && (ad.a(Integer.valueOf(((Game) paramObject).s()), Integer.valueOf(paramGame.s()))) && (ad.a(Integer.valueOf(((Game) paramObject).t()), Integer.valueOf(paramGame.t()))) && (ad.a(Integer.valueOf(((Game) paramObject).u()), Integer.valueOf(paramGame.u()))) && (ad.a(Boolean.valueOf(((Game) paramObject).v()), Boolean.valueOf(paramGame.v())))) {
            bool3 = ((Game) paramObject).w();
            if ((!paramGame.w()) || (!ad.a(Boolean.valueOf(((Game) paramObject).o()), Boolean.valueOf(paramGame.o()))) || (!ad.a(Boolean.valueOf(((Game) paramObject).p()), Boolean.valueOf(paramGame.p())))) {
                break label477;
            }
        }
        label477:
        for (boolean bool1 = true; ; bool1 = false) {
            if ((ad.a(Boolean.valueOf(bool3), Boolean.valueOf(bool1))) && (ad.a(Boolean.valueOf(((Game) paramObject).x()), Boolean.valueOf(paramGame.x())))) {
                bool1 = bool2;
                if (ad.a(((Game) paramObject).y(), paramGame.y())) {
                    break;
                }
            }
            return false;
        }
    }

    static String b(Game paramGame) {
        return ad.a(paramGame).a("ApplicationId", paramGame.d_()).a("DisplayName", paramGame.e_()).a("PrimaryCategory", paramGame.f_()).a("SecondaryCategory", paramGame.e()).a("Description", paramGame.f()).a("DeveloperName", paramGame.g()).a("IconImageUri", paramGame.h()).a("IconImageUrl", paramGame.i()).a("HiResImageUri", paramGame.j()).a("HiResImageUrl", paramGame.k()).a("FeaturedImageUri", paramGame.l()).a("FeaturedImageUrl", paramGame.m()).a("PlayEnabledGame", Boolean.valueOf(paramGame.n())).a("InstanceInstalled", Boolean.valueOf(paramGame.q())).a("InstancePackageName", paramGame.r()).a("AchievementTotalCount", Integer.valueOf(paramGame.t())).a("LeaderboardCount", Integer.valueOf(paramGame.u())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(paramGame.v())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(paramGame.w())).a("AreSnapshotsEnabled", Boolean.valueOf(paramGame.x())).a("ThemeColor", paramGame.y()).toString();
    }

    public Game A() {
        return this;
    }

    public String d_() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.e;
    }

    public String e_() {
        return this.c;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public String f() {
        return this.f;
    }

    public String f_() {
        return this.d;
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
        return this.s;
    }

    public Uri j() {
        return this.i;
    }

    public String k() {
        return this.t;
    }

    public Uri l() {
        return this.j;
    }

    public String m() {
        return this.u;
    }

    public boolean n() {
        return this.k;
    }

    public boolean o() {
        return this.v;
    }

    public boolean p() {
        return this.w;
    }

    public boolean q() {
        return this.l;
    }

    public String r() {
        return this.m;
    }

    public int s() {
        return this.n;
    }

    public int t() {
        return this.o;
    }

    public String toString() {
        return b(this);
    }

    public int u() {
        return this.p;
    }

    public boolean v() {
        return this.q;
    }

    public boolean w() {
        return this.r;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        int i1 = 1;
        Object localObject2 = null;
        if (!d()) {
            b.a(this, paramParcel, paramInt);
            return;
        }
        paramParcel.writeString(this.b);
        paramParcel.writeString(this.c);
        paramParcel.writeString(this.d);
        paramParcel.writeString(this.e);
        paramParcel.writeString(this.f);
        paramParcel.writeString(this.g);
        Object localObject1;
        if (this.h == null) {
            localObject1 = null;
            paramParcel.writeString((String) localObject1);
            if (this.i != null) {
                break label189;
            }
            localObject1 = null;
            label93:
            paramParcel.writeString((String) localObject1);
            if (this.j != null) {
                break label201;
            }
            localObject1 = localObject2;
            label110:
            paramParcel.writeString((String) localObject1);
            if (!this.k) {
                break label213;
            }
            paramInt = 1;
            label125:
            paramParcel.writeInt(paramInt);
            if (!this.l) {
                break label218;
            }
        }
        label189:
        label201:
        label213:
        label218:
        for (paramInt = i1; ; paramInt = 0) {
            paramParcel.writeInt(paramInt);
            paramParcel.writeString(this.m);
            paramParcel.writeInt(this.n);
            paramParcel.writeInt(this.o);
            paramParcel.writeInt(this.p);
            return;
            localObject1 = this.h.toString();
            break;
            localObject1 = this.i.toString();
            break label93;
            localObject1 = this.j.toString();
            break label110;
            paramInt = 0;
            break label125;
        }
    }

    public boolean x() {
        return this.x;
    }

    public String y() {
        return this.y;
    }

    public int z() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/GameEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */