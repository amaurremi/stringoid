package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;
import com.google.android.gms.internal.fq;
import com.google.android.gms.internal.gm;

public final class LeaderboardScoreEntity
        implements LeaderboardScore {
    private final long LU;
    private final String LV;
    private final String LW;
    private final long LX;
    private final long LY;
    private final String LZ;
    private final Uri Ma;
    private final Uri Mb;
    private final PlayerEntity Mc;
    private final String Md;
    private final String Me;
    private final String Mf;

    public LeaderboardScoreEntity(LeaderboardScore paramLeaderboardScore) {
        this.LU = paramLeaderboardScore.getRank();
        this.LV = ((String) fq.f(paramLeaderboardScore.getDisplayRank()));
        this.LW = ((String) fq.f(paramLeaderboardScore.getDisplayScore()));
        this.LX = paramLeaderboardScore.getRawScore();
        this.LY = paramLeaderboardScore.getTimestampMillis();
        this.LZ = paramLeaderboardScore.getScoreHolderDisplayName();
        this.Ma = paramLeaderboardScore.getScoreHolderIconImageUri();
        this.Mb = paramLeaderboardScore.getScoreHolderHiResImageUri();
        Object localObject = paramLeaderboardScore.getScoreHolder();
        if (localObject == null) {
        }
        for (localObject = null; ; localObject = (PlayerEntity) ((Player) localObject).freeze()) {
            this.Mc = ((PlayerEntity) localObject);
            this.Md = paramLeaderboardScore.getScoreTag();
            this.Me = paramLeaderboardScore.getScoreHolderIconImageUrl();
            this.Mf = paramLeaderboardScore.getScoreHolderHiResImageUrl();
            return;
        }
    }

    static int a(LeaderboardScore paramLeaderboardScore) {
        return fo.hashCode(new Object[]{Long.valueOf(paramLeaderboardScore.getRank()), paramLeaderboardScore.getDisplayRank(), Long.valueOf(paramLeaderboardScore.getRawScore()), paramLeaderboardScore.getDisplayScore(), Long.valueOf(paramLeaderboardScore.getTimestampMillis()), paramLeaderboardScore.getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolder()});
    }

    static boolean a(LeaderboardScore paramLeaderboardScore, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof LeaderboardScore)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramLeaderboardScore == paramObject);
            paramObject = (LeaderboardScore) paramObject;
            if ((!fo.equal(Long.valueOf(((LeaderboardScore) paramObject).getRank()), Long.valueOf(paramLeaderboardScore.getRank()))) || (!fo.equal(((LeaderboardScore) paramObject).getDisplayRank(), paramLeaderboardScore.getDisplayRank())) || (!fo.equal(Long.valueOf(((LeaderboardScore) paramObject).getRawScore()), Long.valueOf(paramLeaderboardScore.getRawScore()))) || (!fo.equal(((LeaderboardScore) paramObject).getDisplayScore(), paramLeaderboardScore.getDisplayScore())) || (!fo.equal(Long.valueOf(((LeaderboardScore) paramObject).getTimestampMillis()), Long.valueOf(paramLeaderboardScore.getTimestampMillis()))) || (!fo.equal(((LeaderboardScore) paramObject).getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderDisplayName())) || (!fo.equal(((LeaderboardScore) paramObject).getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderIconImageUri())) || (!fo.equal(((LeaderboardScore) paramObject).getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri())) || (!fo.equal(((LeaderboardScore) paramObject).getScoreHolder(), paramLeaderboardScore.getScoreHolder()))) {
                break;
            }
            bool1 = bool2;
        } while (fo.equal(((LeaderboardScore) paramObject).getScoreTag(), paramLeaderboardScore.getScoreTag()));
        return false;
    }

    static String b(LeaderboardScore paramLeaderboardScore) {
        fo.a locala = fo.e(paramLeaderboardScore).a("Rank", Long.valueOf(paramLeaderboardScore.getRank())).a("DisplayRank", paramLeaderboardScore.getDisplayRank()).a("Score", Long.valueOf(paramLeaderboardScore.getRawScore())).a("DisplayScore", paramLeaderboardScore.getDisplayScore()).a("Timestamp", Long.valueOf(paramLeaderboardScore.getTimestampMillis())).a("DisplayName", paramLeaderboardScore.getScoreHolderDisplayName()).a("IconImageUri", paramLeaderboardScore.getScoreHolderIconImageUri()).a("IconImageUrl", paramLeaderboardScore.getScoreHolderIconImageUrl()).a("HiResImageUri", paramLeaderboardScore.getScoreHolderHiResImageUri()).a("HiResImageUrl", paramLeaderboardScore.getScoreHolderHiResImageUrl());
        if (paramLeaderboardScore.getScoreHolder() == null) {
        }
        for (Object localObject = null; ; localObject = paramLeaderboardScore.getScoreHolder()) {
            return locala.a("Player", localObject).a("ScoreTag", paramLeaderboardScore.getScoreTag()).toString();
        }
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public String getDisplayRank() {
        return this.LV;
    }

    public void getDisplayRank(CharArrayBuffer paramCharArrayBuffer) {
        gm.b(this.LV, paramCharArrayBuffer);
    }

    public String getDisplayScore() {
        return this.LW;
    }

    public void getDisplayScore(CharArrayBuffer paramCharArrayBuffer) {
        gm.b(this.LW, paramCharArrayBuffer);
    }

    public long getRank() {
        return this.LU;
    }

    public long getRawScore() {
        return this.LX;
    }

    public Player getScoreHolder() {
        return this.Mc;
    }

    public String getScoreHolderDisplayName() {
        if (this.Mc == null) {
            return this.LZ;
        }
        return this.Mc.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer paramCharArrayBuffer) {
        if (this.Mc == null) {
            gm.b(this.LZ, paramCharArrayBuffer);
            return;
        }
        this.Mc.getDisplayName(paramCharArrayBuffer);
    }

    public Uri getScoreHolderHiResImageUri() {
        if (this.Mc == null) {
            return this.Mb;
        }
        return this.Mc.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        if (this.Mc == null) {
            return this.Mf;
        }
        return this.Mc.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        if (this.Mc == null) {
            return this.Ma;
        }
        return this.Mc.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        if (this.Mc == null) {
            return this.Me;
        }
        return this.Mc.getIconImageUrl();
    }

    public String getScoreTag() {
        return this.Md;
    }

    public long getTimestampMillis() {
        return this.LY;
    }

    public LeaderboardScore hF() {
        return this;
    }

    public int hashCode() {
        return a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return b(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardScoreEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */