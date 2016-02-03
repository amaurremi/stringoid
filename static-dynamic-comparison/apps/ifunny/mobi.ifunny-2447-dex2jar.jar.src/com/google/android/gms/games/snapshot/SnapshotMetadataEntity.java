package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

public final class SnapshotMetadataEntity
        implements SafeParcelable, SnapshotMetadata {
    public static final d CREATOR = new d();
    private final int a;
    private final GameEntity b;
    private final PlayerEntity c;
    private final String d;
    private final Uri e;
    private final String f;
    private final String g;
    private final String h;
    private final long i;
    private final long j;
    private final float k;
    private final String l;

    SnapshotMetadataEntity(int paramInt, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, float paramFloat, String paramString5) {
        this.a = paramInt;
        this.b = paramGameEntity;
        this.c = paramPlayerEntity;
        this.d = paramString1;
        this.e = paramUri;
        this.f = paramString2;
        this.k = paramFloat;
        this.g = paramString3;
        this.h = paramString4;
        this.i = paramLong1;
        this.j = paramLong2;
        this.l = paramString5;
    }

    public SnapshotMetadataEntity(SnapshotMetadata paramSnapshotMetadata) {
        this.a = 3;
        this.b = new GameEntity(paramSnapshotMetadata.C_());
        this.c = new PlayerEntity(paramSnapshotMetadata.c());
        this.d = paramSnapshotMetadata.d();
        this.e = paramSnapshotMetadata.e();
        this.f = paramSnapshotMetadata.f();
        this.k = paramSnapshotMetadata.g();
        this.g = paramSnapshotMetadata.i();
        this.h = paramSnapshotMetadata.j();
        this.i = paramSnapshotMetadata.k();
        this.j = paramSnapshotMetadata.l();
        this.l = paramSnapshotMetadata.h();
    }

    static int a(SnapshotMetadata paramSnapshotMetadata) {
        return ad.a(new Object[]{paramSnapshotMetadata.C_(), paramSnapshotMetadata.c(), paramSnapshotMetadata.d(), paramSnapshotMetadata.e(), Float.valueOf(paramSnapshotMetadata.g()), paramSnapshotMetadata.i(), paramSnapshotMetadata.j(), Long.valueOf(paramSnapshotMetadata.k()), Long.valueOf(paramSnapshotMetadata.l()), paramSnapshotMetadata.h()});
    }

    static boolean a(SnapshotMetadata paramSnapshotMetadata, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof SnapshotMetadata)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramSnapshotMetadata == paramObject);
            paramObject = (SnapshotMetadata) paramObject;
            if ((!ad.a(((SnapshotMetadata) paramObject).C_(), paramSnapshotMetadata.C_())) || (!ad.a(((SnapshotMetadata) paramObject).c(), paramSnapshotMetadata.c())) || (!ad.a(((SnapshotMetadata) paramObject).d(), paramSnapshotMetadata.d())) || (!ad.a(((SnapshotMetadata) paramObject).e(), paramSnapshotMetadata.e())) || (!ad.a(Float.valueOf(((SnapshotMetadata) paramObject).g()), Float.valueOf(paramSnapshotMetadata.g()))) || (!ad.a(((SnapshotMetadata) paramObject).i(), paramSnapshotMetadata.i())) || (!ad.a(((SnapshotMetadata) paramObject).j(), paramSnapshotMetadata.j())) || (!ad.a(Long.valueOf(((SnapshotMetadata) paramObject).k()), Long.valueOf(paramSnapshotMetadata.k()))) || (!ad.a(Long.valueOf(((SnapshotMetadata) paramObject).l()), Long.valueOf(paramSnapshotMetadata.l())))) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(((SnapshotMetadata) paramObject).h(), paramSnapshotMetadata.h()));
        return false;
    }

    static String b(SnapshotMetadata paramSnapshotMetadata) {
        return ad.a(paramSnapshotMetadata).a("Game", paramSnapshotMetadata.C_()).a("Owner", paramSnapshotMetadata.c()).a("SnapshotId", paramSnapshotMetadata.d()).a("CoverImageUri", paramSnapshotMetadata.e()).a("CoverImageUrl", paramSnapshotMetadata.f()).a("CoverImageAspectRatio", Float.valueOf(paramSnapshotMetadata.g())).a("Description", paramSnapshotMetadata.j()).a("LastModifiedTimestamp", Long.valueOf(paramSnapshotMetadata.k())).a("PlayedTime", Long.valueOf(paramSnapshotMetadata.l())).a("UniqueName", paramSnapshotMetadata.h()).toString();
    }

    public Game C_() {
        return this.b;
    }

    public Player c() {
        return this.c;
    }

    public String d() {
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

    public String f() {
        return this.f;
    }

    public float g() {
        return this.k;
    }

    public String h() {
        return this.l;
    }

    public int hashCode() {
        return a(this);
    }

    public String i() {
        return this.g;
    }

    public String j() {
        return this.h;
    }

    public long k() {
        return this.i;
    }

    public long l() {
        return this.j;
    }

    public int m() {
        return this.a;
    }

    public SnapshotMetadata n() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        d.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotMetadataEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */