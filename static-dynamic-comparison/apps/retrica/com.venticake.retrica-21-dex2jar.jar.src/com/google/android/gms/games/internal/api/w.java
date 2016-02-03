package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;

abstract class w
  extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LoadMatchResult>
{
  public TurnBasedMultiplayer.LoadMatchResult a(final Status paramStatus)
  {
    new TurnBasedMultiplayer.LoadMatchResult()
    {
      public TurnBasedMatch getMatch()
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */