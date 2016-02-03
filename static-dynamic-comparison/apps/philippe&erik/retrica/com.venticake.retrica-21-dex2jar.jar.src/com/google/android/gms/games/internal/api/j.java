package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players.LoadPlayersResult;

abstract class j
  extends Games.BaseGamesApiMethodImpl<Players.LoadPlayersResult>
{
  public Players.LoadPlayersResult a(final Status paramStatus)
  {
    new Players.LoadPlayersResult()
    {
      public PlayerBuffer getPlayers()
      {
        return new PlayerBuffer(DataHolder.af(14));
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
      
      public void release() {}
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */