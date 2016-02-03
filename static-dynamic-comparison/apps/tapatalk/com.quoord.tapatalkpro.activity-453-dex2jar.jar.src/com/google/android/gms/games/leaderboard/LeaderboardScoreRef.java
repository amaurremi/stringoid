package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef
        extends b
        implements LeaderboardScore {
    private final PlayerRef Mg;

    LeaderboardScoreRef(DataHolder paramDataHolder, int paramInt) {
        super(paramDataHolder, paramInt);
        this.Mg = new PlayerRef(paramDataHolder, paramInt);
    }

    public boolean equals(Object paramObject) {
        return LeaderboardScoreEntity.a(this, paramObject);
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer paramCharArrayBuffer) {
        a("display_rank", paramCharArrayBuffer);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer paramCharArrayBuffer) {
        a("display_score", paramCharArrayBuffer);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        if (ai("external_player_id")) {
            return null;
        }
        return this.Mg;
    }

    public String getScoreHolderDisplayName() {
        if (ai("external_player_id")) {
            return getString("default_display_name");
        }
        return this.Mg.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer paramCharArrayBuffer) {
        if (ai("external_player_id")) {
            a("default_display_name", paramCharArrayBuffer);
            return;
        }
        this.Mg.getDisplayName(paramCharArrayBuffer);
    }

    public Uri getScoreHolderHiResImageUri() {
        if (ai("external_player_id")) {
            return null;
        }
        return this.Mg.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        if (ai("external_player_id")) {
            return null;
        }
        return this.Mg.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        if (ai("external_player_id")) {
            return ah("default_display_image_uri");
        }
        return this.Mg.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        if (ai("external_player_id")) {
            return getString("default_display_image_url");
        }
        return this.Mg.getIconImageUrl();
    }

    public String getScoreTag() {
        return getString("score_tag");
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public LeaderboardScore hF() {
        return new LeaderboardScoreEntity(this);
    }

    public int hashCode() {
        return LeaderboardScoreEntity.a(this);
    }

    public String toString() {
        return LeaderboardScoreEntity.b(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardScoreRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */