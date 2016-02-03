package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;

final class av
  implements TurnBasedMultiplayer.LoadMatchesResult
{
  private final Status a;
  private final LoadMatchesResponse b;
  
  av(Status paramStatus, Bundle paramBundle)
  {
    this.a = paramStatus;
    this.b = new LoadMatchesResponse(paramBundle);
  }
  
  public LoadMatchesResponse getMatches()
  {
    return this.b;
  }
  
  public Status getStatus()
  {
    return this.a;
  }
  
  public void release()
  {
    this.b.close();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */