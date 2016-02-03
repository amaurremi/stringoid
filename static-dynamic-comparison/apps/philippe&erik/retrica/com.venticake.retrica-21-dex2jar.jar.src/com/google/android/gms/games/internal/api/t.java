package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;

abstract class t
  extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.CancelMatchResult>
{
  private final String a;
  
  public t(String paramString)
  {
    this.a = paramString;
  }
  
  public TurnBasedMultiplayer.CancelMatchResult a(final Status paramStatus)
  {
    new TurnBasedMultiplayer.CancelMatchResult()
    {
      public String getMatchId()
      {
        return t.a(t.this);
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */