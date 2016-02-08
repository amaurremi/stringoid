package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface Leaderboards$LoadScoresResult
  extends Releasable, Result
{
  public abstract Leaderboard getLeaderboard();
  
  public abstract LeaderboardScoreBuffer getScores();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/leaderboard/Leaderboards$LoadScoresResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */