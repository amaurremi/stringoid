package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.f;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class AchievementRef
        extends f
        implements Achievement {
    public int c() {
        return c("type");
    }

    public String d() {
        return e("name");
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return e("description");
    }

    public Uri f() {
        return h("unlocked_icon_image_uri");
    }

    public String g() {
        return e("unlocked_icon_image_url");
    }

    public Uri h() {
        return h("revealed_icon_image_uri");
    }

    public String i() {
        return e("revealed_icon_image_url");
    }

    public int j() {
        boolean bool = true;
        if (c() == 1) {
        }
        for (; ; ) {
            b.a(bool);
            return c("total_steps");
            bool = false;
        }
    }

    public String j_() {
        return e("external_achievement_id");
    }

    public String k() {
        boolean bool = true;
        if (c() == 1) {
        }
        for (; ; ) {
            b.a(bool);
            return e("formatted_total_steps");
            bool = false;
        }
    }

    public Player l() {
        return new PlayerRef(this.a, this.b);
    }

    public int m() {
        return c("state");
    }

    public int n() {
        boolean bool = true;
        if (c() == 1) {
        }
        for (; ; ) {
            b.a(bool);
            return c("current_steps");
            bool = false;
        }
    }

    public String o() {
        boolean bool = true;
        if (c() == 1) {
        }
        for (; ; ) {
            b.a(bool);
            return e("formatted_current_steps");
            bool = false;
        }
    }

    public long p() {
        return b("last_updated_timestamp");
    }

    public long q() {
        if ((!a("instance_xp_value")) || (i("instance_xp_value"))) {
            return b("definition_xp_value");
        }
        return b("instance_xp_value");
    }

    public Achievement r() {
        return new AchievementEntity(this);
    }

    public String toString() {
        return AchievementEntity.b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((AchievementEntity) r()).writeToParcel(paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/achievement/AchievementRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */