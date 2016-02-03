package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer
        extends DataBuffer<LeaderboardScore> {
    private final LeaderboardScoreBufferHeader LT;

    public LeaderboardScoreBuffer(DataHolder paramDataHolder) {
        super(paramDataHolder);
        this.LT = new LeaderboardScoreBufferHeader(paramDataHolder.getMetadata());
    }

    public LeaderboardScore get(int paramInt) {
        return new LeaderboardScoreRef(this.BB, paramInt);
    }

    public LeaderboardScoreBufferHeader hD() {
        return this.LT;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */