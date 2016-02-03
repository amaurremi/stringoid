package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;

abstract class g
  extends Games.BaseGamesApiMethodImpl<Leaderboards.LeaderboardMetadataResult>
{
  public Leaderboards.LeaderboardMetadataResult a(final Status paramStatus)
  {
    new Leaderboards.LeaderboardMetadataResult()
    {
      public LeaderboardBuffer getLeaderboards()
      {
        return new LeaderboardBuffer(DataHolder.af(14));
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
      
      public void release() {}
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */