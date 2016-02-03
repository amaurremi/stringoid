package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;

final class g
  implements TurnBasedMultiplayer.CancelMatchResult
{
  private final Status a;
  private final String b;
  
  g(Status paramStatus, String paramString)
  {
    this.a = paramStatus;
    this.b = paramString;
  }
  
  public String getMatchId()
  {
    return this.b;
  }
  
  public Status getStatus()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */