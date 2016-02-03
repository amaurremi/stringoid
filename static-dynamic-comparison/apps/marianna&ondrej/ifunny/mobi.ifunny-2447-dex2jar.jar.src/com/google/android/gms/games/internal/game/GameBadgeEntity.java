package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameBadgeEntity
        extends GamesDowngradeableSafeParcel
        implements GameBadge {
    public static final d CREATOR = new c();
    private final int a;
    private int b;
    private String c;
    private String d;
    private Uri e;

    GameBadgeEntity(int paramInt1, int paramInt2, String paramString1, String paramString2, Uri paramUri) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramString1;
        this.d = paramString2;
        this.e = paramUri;
    }

    public GameBadgeEntity(GameBadge paramGameBadge) {
        this.a = 1;
        this.b = paramGameBadge.o_();
        this.c = paramGameBadge.p_();
        this.d = paramGameBadge.q_();
        this.e = paramGameBadge.e();
    }

    static int a(GameBadge paramGameBadge) {
        return ad.a(new Object[]{Integer.valueOf(paramGameBadge.o_()), paramGameBadge.p_(), paramGameBadge.q_(), paramGameBadge.e()});
    }

    static boolean a(GameBadge paramGameBadge, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof GameBadge)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramGameBadge == paramObject);
            paramObject = (GameBadge) paramObject;
            if (!ad.a(Integer.valueOf(((GameBadge) paramObject).o_()), paramGameBadge.p_())) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(((GameBadge) paramObject).q_(), paramGameBadge.e()));
        return false;
    }

    static String b(GameBadge paramGameBadge) {
        return ad.a(paramGameBadge).a("Type", Integer.valueOf(paramGameBadge.o_())).a("Title", paramGameBadge.p_()).a("Description", paramGameBadge.q_()).a("IconImageUri", paramGameBadge.e()).toString();
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

    public int f() {
        return this.a;
    }

    public GameBadge g() {
        return this;
    }

    public int hashCode() {
        return a(this);
    }

    public int o_() {
        return this.b;
    }

    public String p_() {
        return this.c;
    }

    public String q_() {
        return this.d;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        if (!d()) {
            d.a(this, paramParcel, paramInt);
            return;
        }
        paramParcel.writeInt(this.b);
        paramParcel.writeString(this.c);
        paramParcel.writeString(this.d);
        if (this.e == null) {
        }
        for (String str = null; ; str = this.e.toString()) {
            paramParcel.writeString(str);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/game/GameBadgeEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */