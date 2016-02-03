package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;

abstract class e
  extends Games.BaseGamesApiMethodImpl<GamesMetadata.LoadGamesResult>
{
  public GamesMetadata.LoadGamesResult a(final Status paramStatus)
  {
    new GamesMetadata.LoadGamesResult()
    {
      public GameBuffer getGames()
      {
        return new GameBuffer(DataHolder.af(14));
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
      
      public void release() {}
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */