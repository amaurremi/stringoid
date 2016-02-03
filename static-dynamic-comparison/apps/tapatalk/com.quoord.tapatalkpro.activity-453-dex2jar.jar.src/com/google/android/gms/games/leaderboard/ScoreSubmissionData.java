package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;
import com.google.android.gms.internal.fq;

import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] LN = {"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private int Ah;
    private String Ie;
    private String LP;
    private HashMap<Integer, Result> Mt;

    public ScoreSubmissionData(DataHolder paramDataHolder) {
        this.Ah = paramDataHolder.getStatusCode();
        this.Mt = new HashMap();
        int j = paramDataHolder.getCount();
        if (j == 3) {
        }
        for (boolean bool = true; ; bool = false) {
            fq.z(bool);
            int i = 0;
            while (i < j) {
                int k = paramDataHolder.G(i);
                if (i == 0) {
                    this.LP = paramDataHolder.getString("leaderboardId", i, k);
                    this.Ie = paramDataHolder.getString("playerId", i, k);
                }
                if (paramDataHolder.getBoolean("hasResult", i, k)) {
                    a(new Result(paramDataHolder.getLong("rawScore", i, k), paramDataHolder.getString("formattedScore", i, k), paramDataHolder.getString("scoreTag", i, k), paramDataHolder.getBoolean("newBest", i, k)), paramDataHolder.getInteger("timeSpan", i, k));
                }
                i += 1;
            }
        }
    }

    private void a(Result paramResult, int paramInt) {
        this.Mt.put(Integer.valueOf(paramInt), paramResult);
    }

    public String getLeaderboardId() {
        return this.LP;
    }

    public String getPlayerId() {
        return this.Ie;
    }

    public Result getScoreResult(int paramInt) {
        return (Result) this.Mt.get(Integer.valueOf(paramInt));
    }

    public String toString() {
        fo.a locala = fo.e(this).a("PlayerId", this.Ie).a("StatusCode", Integer.valueOf(this.Ah));
        int i = 0;
        if (i < 3) {
            Object localObject = (Result) this.Mt.get(Integer.valueOf(i));
            locala.a("TimesSpan", TimeSpan.bd(i));
            if (localObject == null) {
            }
            for (localObject = "null"; ; localObject = ((Result) localObject).toString()) {
                locala.a("Result", localObject);
                i += 1;
                break;
            }
        }
        return locala.toString();
    }

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long paramLong, String paramString1, String paramString2, boolean paramBoolean) {
            this.rawScore = paramLong;
            this.formattedScore = paramString1;
            this.scoreTag = paramString2;
            this.newBest = paramBoolean;
        }

        public String toString() {
            return fo.e(this).a("RawScore", Long.valueOf(this.rawScore)).a("FormattedScore", this.formattedScore).a("ScoreTag", this.scoreTag).a("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/leaderboard/ScoreSubmissionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */