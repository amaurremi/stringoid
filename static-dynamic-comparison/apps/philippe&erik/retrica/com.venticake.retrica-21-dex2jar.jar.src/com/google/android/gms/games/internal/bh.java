package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;

final class bh
  extends AbstractGamesCallbacks
{
  private final OnTurnBasedMatchUpdateReceivedListener b;
  
  bh(GamesClientImpl paramGamesClientImpl, OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
  {
    this.b = paramOnTurnBasedMatchUpdateReceivedListener;
  }
  
  public void onTurnBasedMatchRemoved(String paramString)
  {
    this.a.a(new bg(this.a, this.b, paramString));
  }
  
  public void t(DataHolder paramDataHolder)
  {
    TurnBasedMatchBuffer localTurnBasedMatchBuffer = new TurnBasedMatchBuffer(paramDataHolder);
    paramDataHolder = null;
    try
    {
      if (localTurnBasedMatchBuffer.getCount() > 0) {
        paramDataHolder = (TurnBasedMatch)((TurnBasedMatch)localTurnBasedMatchBuffer.get(0)).freeze();
      }
      localTurnBasedMatchBuffer.close();
      if (paramDataHolder != null) {
        this.a.a(new bi(this.a, this.b, paramDataHolder));
      }
      return;
    }
    finally
    {
      localTurnBasedMatchBuffer.close();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */