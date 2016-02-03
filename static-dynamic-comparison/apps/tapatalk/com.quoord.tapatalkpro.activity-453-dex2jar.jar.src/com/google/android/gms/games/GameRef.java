package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;

public final class GameRef
        extends b
        implements Game {
    public GameRef(DataHolder paramDataHolder, int paramInt) {
        super(paramDataHolder, paramInt);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return GameEntity.a(this, paramObject);
    }

    public Game freeze() {
        return new GameEntity(this);
    }

    public boolean gb() {
        return getBoolean("play_enabled_game");
    }

    public boolean gc() {
        return getBoolean("identity_sharing_confirmed");
    }

    public boolean gd() {
        return getInteger("installed") > 0;
    }

    public String ge() {
        return getString("package_name");
    }

    public int getAchievementTotalCount() {
        return getInteger("achievement_total_count");
    }

    public String getApplicationId() {
        return getString("external_game_id");
    }

    public String getDescription() {
        return getString("game_description");
    }

    public void getDescription(CharArrayBuffer paramCharArrayBuffer) {
        a("game_description", paramCharArrayBuffer);
    }

    public String getDeveloperName() {
        return getString("developer_name");
    }

    public void getDeveloperName(CharArrayBuffer paramCharArrayBuffer) {
        a("developer_name", paramCharArrayBuffer);
    }

    public String getDisplayName() {
        return getString("display_name");
    }

    public void getDisplayName(CharArrayBuffer paramCharArrayBuffer) {
        a("display_name", paramCharArrayBuffer);
    }

    public Uri getFeaturedImageUri() {
        return ah("featured_image_uri");
    }

    public String getFeaturedImageUrl() {
        return getString("featured_image_url");
    }

    public Uri getHiResImageUri() {
        return ah("game_hi_res_image_uri");
    }

    public String getHiResImageUrl() {
        return getString("game_hi_res_image_url");
    }

    public Uri getIconImageUri() {
        return ah("game_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("game_icon_image_url");
    }

    public int getLeaderboardCount() {
        return getInteger("leaderboard_count");
    }

    public String getPrimaryCategory() {
        return getString("primary_category");
    }

    public String getSecondaryCategory() {
        return getString("secondary_category");
    }

    public int gf() {
        return getInteger("gameplay_acl_status");
    }

    public int hashCode() {
        return GameEntity.a(this);
    }

    public boolean isMuted() {
        return getBoolean("muted");
    }

    public boolean isRealTimeMultiplayerEnabled() {
        return getInteger("real_time_support") > 0;
    }

    public boolean isTurnBasedMultiplayerEnabled() {
        return getInteger("turn_based_support") > 0;
    }

    public String toString() {
        return GameEntity.b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((GameEntity) freeze()).writeToParcel(paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/GameRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */