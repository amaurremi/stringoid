package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.b;

final class bi
  extends hb<IGamesService>.b<OnTurnBasedMatchUpdateReceivedListener>
{
  private final TurnBasedMatch b;
  
  bi(GamesClientImpl paramGamesClientImpl, OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener, TurnBasedMatch paramTurnBasedMatch)
  {
    super(paramGamesClientImpl, paramOnTurnBasedMatchUpdateReceivedListener);
    this.b = paramTurnBasedMatch;
  }
  
  protected void a(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
  {
    paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.b);
  }
  
  protected void fu() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */