package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.b;

final class bg
  extends hb<IGamesService>.b<OnTurnBasedMatchUpdateReceivedListener>
{
  private final String b;
  
  bg(GamesClientImpl paramGamesClientImpl, OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener, String paramString)
  {
    super(paramGamesClientImpl, paramOnTurnBasedMatchUpdateReceivedListener);
    this.b = paramString;
  }
  
  protected void a(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
  {
    paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.b);
  }
  
  protected void fu() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */