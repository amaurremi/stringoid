package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;

abstract class x
  extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LoadMatchesResult>
{
  public TurnBasedMultiplayer.LoadMatchesResult a(final Status paramStatus)
  {
    new TurnBasedMultiplayer.LoadMatchesResult()
    {
      public LoadMatchesResponse getMatches()
      {
        return new LoadMatchesResponse(new Bundle());
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
      
      public void release() {}
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */