package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;

abstract class h
  extends Games.BaseGamesApiMethodImpl<Leaderboards.LoadPlayerScoreResult>
{
  public Leaderboards.LoadPlayerScoreResult a(final Status paramStatus)
  {
    new Leaderboards.LoadPlayerScoreResult()
    {
      public LeaderboardScore getScore()
      {
        return null;
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */