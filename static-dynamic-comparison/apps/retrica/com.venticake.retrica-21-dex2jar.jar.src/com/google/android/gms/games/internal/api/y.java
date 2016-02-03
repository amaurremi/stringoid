package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;

abstract class y
  extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.UpdateMatchResult>
{
  public TurnBasedMultiplayer.UpdateMatchResult a(final Status paramStatus)
  {
    new TurnBasedMultiplayer.UpdateMatchResult()
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */