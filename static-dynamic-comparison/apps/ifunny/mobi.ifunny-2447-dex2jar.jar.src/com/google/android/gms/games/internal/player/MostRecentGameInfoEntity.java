package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MostRecentGameInfoEntity
        implements SafeParcelable, MostRecentGameInfo {
    public static final a CREATOR = new a();
    private final int a;
    private final String b;
    private final String c;
    private final long d;
    private final Uri e;
    private final Uri f;
    private final Uri g;

    MostRecentGameInfoEntity(int paramInt, String paramString1, String paramString2, long paramLong, Uri paramUri1, Uri paramUri2, Uri paramUri3) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramLong;
        this.e = paramUri1;
        this.f = paramUri2;
        this.g = paramUri3;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo paramMostRecentGameInfo) {
        this.a = 2;
        this.b = paramMostRecentGameInfo.r_();
        this.c = paramMostRecentGameInfo.c();
        this.d = paramMostRecentGameInfo.d();
        this.e = paramMostRecentGameInfo.e();
        this.f = paramMostRecentGameInfo.f();
        this.g = paramMostRecentGameInfo.g();
    }

    static int a(MostRecentGameInfo paramMostRecentGameInfo) {
        return ad.a(new Object[]{paramMostRecentGameInfo.r_(), paramMostRecentGameInfo.c(), Long.valueOf(paramMostRecentGameInfo.d()), paramMostRecentGameInfo.e(), paramMostRecentGameInfo.f(), paramMostRecentGameInfo.g()});
    }

    static boolean a(MostRecentGameInfo paramMostRecentGameInfo, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof MostRecentGameInfo)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramMostRecentGameInfo == paramObject);
            paramObject = (MostRecentGameInfo) paramObject;
            if ((!ad.a(((MostRecentGameInfo) paramObject).r_(), paramMostRecentGameInfo.r_())) || (!ad.a(((MostRecentGameInfo) paramObject).c(), paramMostRecentGameInfo.c())) || (!ad.a(Long.valueOf(((MostRecentGameInfo) paramObject).d()), Long.valueOf(paramMostRecentGameInfo.d()))) || (!ad.a(((MostRecentGameInfo) paramObject).e(), paramMostRecentGameInfo.e())) || (!ad.a(((MostRecentGameInfo) paramObject).f(), paramMostRecentGameInfo.f()))) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(((MostRecentGameInfo) paramObject).g(), paramMostRecentGameInfo.g()));
        return false;
    }

    static String b(MostRecentGameInfo paramMostRecentGameInfo) {
        return ad.a(paramMostRecentGameInfo).a("GameId", paramMostRecentGameInfo.r_()).a("GameName", paramMostRecentGameInfo.c()).a("ActivityTimestampMillis", Long.valueOf(paramMostRecentGameInfo.d())).a("GameIconUri", paramMostRecentGameInfo.e()).a("GameHiResUri", paramMostRecentGameInfo.f()).a("GameFeaturedUri", paramMostRecentGameInfo.g()).toString();
    }

    public String c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public Uri e() {
        return this.e;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public Uri f() {
        return this.f;
    }

    public Uri g() {
        return this.g;
    }

    public int h() {
        return this.a;
    }

    public int hashCode() {
        return a(this);
    }

    public MostRecentGameInfo i() {
        return this;
    }

    public String r_() {
        return this.b;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/player/MostRecentGameInfoEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */