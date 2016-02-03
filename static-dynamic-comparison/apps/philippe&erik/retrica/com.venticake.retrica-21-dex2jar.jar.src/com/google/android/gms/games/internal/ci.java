package com.google.android.gms.games.internal;

import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.b;

final class ci
  extends hb<IGamesService>.b<OnRequestReceivedListener>
{
  private final GameRequest b;
  
  ci(GamesClientImpl paramGamesClientImpl, OnRequestReceivedListener paramOnRequestReceivedListener, GameRequest paramGameRequest)
  {
    super(paramGamesClientImpl, paramOnRequestReceivedListener);
    this.b = paramGameRequest;
  }
  
  protected void a(OnRequestReceivedListener paramOnRequestReceivedListener)
  {
    paramOnRequestReceivedListener.onRequestReceived(this.b);
  }
  
  protected void fu() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */