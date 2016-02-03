package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;

abstract class i
  extends Games.BaseGamesApiMethodImpl<Leaderboards.LoadScoresResult>
{
  public Leaderboards.LoadScoresResult a(final Status paramStatus)
  {
    new Leaderboards.LoadScoresResult()
    {
      public Leaderboard getLeaderboard()
      {
        return null;
      }
      
      public LeaderboardScoreBuffer getScores()
      {
        return new LeaderboardScoreBuffer(DataHolder.af(14));
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
      
      public void release() {}
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */