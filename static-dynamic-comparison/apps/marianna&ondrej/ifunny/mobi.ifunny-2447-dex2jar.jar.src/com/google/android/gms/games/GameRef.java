package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public final class GameRef
        extends f
        implements Game {
    public GameRef(DataHolder paramDataHolder, int paramInt) {
        super(paramDataHolder, paramInt);
    }

    public String d_() {
        return e("external_game_id");
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return e("secondary_category");
    }

    public String e_() {
        return e("display_name");
    }

    public boolean equals(Object paramObject) {
        return GameEntity.a(this, paramObject);
    }

    public String f() {
        return e("game_description");
    }

    public String f_() {
        return e("primary_category");
    }

    public String g() {
        return e("developer_name");
    }

    public Uri h() {
        return h("game_icon_image_uri");
    }

    public int hashCode() {
        return GameEntity.a(this);
    }

    public String i() {
        return e("game_icon_image_url");
    }

    public Uri j() {
        return h("game_hi_res_image_uri");
    }

    public String k() {
        return e("game_hi_res_image_url");
    }

    public Uri l() {
        return h("featured_image_uri");
    }

    public String m() {
        return e("featured_image_url");
    }

    public boolean n() {
        return d("play_enabled_game");
    }

    public boolean o() {
        return d("muted");
    }

    public boolean p() {
        return d("identity_sharing_confirmed");
    }

    public boolean q() {
        return c("installed") > 0;
    }

    public String r() {
        return e("package_name");
    }

    public int s() {
        return c("gameplay_acl_status");
    }

    public int t() {
        return c("achievement_total_count");
    }

    public String toString() {
        return GameEntity.b(this);
    }

    public int u() {
        return c("leaderboard_count");
    }

    public boolean v() {
        return c("real_time_support") > 0;
    }

    public boolean w() {
        return c("turn_based_support") > 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((GameEntity) z()).writeToParcel(paramParcel, paramInt);
    }

    public boolean x() {
        return c("snapshots_enabled") > 0;
    }

    public String y() {
        return e("theme_color");
    }

    public Game z() {
        return new GameEntity(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/GameRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */