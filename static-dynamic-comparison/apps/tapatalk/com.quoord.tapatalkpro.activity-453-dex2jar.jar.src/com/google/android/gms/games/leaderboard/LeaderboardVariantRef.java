package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;

public final class LeaderboardVariantRef
        extends b
        implements LeaderboardVariant {
    LeaderboardVariantRef(DataHolder paramDataHolder, int paramInt) {
        super(paramDataHolder, paramInt);
    }

    public boolean equals(Object paramObject) {
        return LeaderboardVariantEntity.a(this, paramObject);
    }

    public int getCollection() {
        return getInteger("collection");
    }

    public String getDisplayPlayerRank() {
        return getString("player_display_rank");
    }

    public String getDisplayPlayerScore() {
        return getString("player_display_score");
    }

    public long getNumScores() {
        if (ai("total_scores")) {
            return -1L;
        }
        return getLong("total_scores");
    }

    public long getPlayerRank() {
        if (ai("player_rank")) {
            return -1L;
        }
        return getLong("player_rank");
    }

    public String getPlayerScoreTag() {
        return getString("player_score_tag");
    }

    public long getRawPlayerScore() {
        if (ai("player_raw_score")) {
            return -1L;
        }
        return getLong("player_raw_score");
    }

    public int getTimeSpan() {
        return getInteger("timespan");
    }

    public String hG() {
        return getString("top_page_token_next");
    }

    public String hH() {
        return getString("window_page_token_prev");
    }

    public String hI() {
        return getString("window_page_token_next");
    }

    public LeaderboardVariant hJ() {
        return new LeaderboardVariantEntity(this);
    }

    public boolean hasPlayerInfo() {
        return !ai("player_raw_score");
    }

    public int hashCode() {
        return LeaderboardVariantEntity.a(this);
    }

    public String toString() {
        return LeaderboardVariantEntity.b(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardVariantRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */