package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.b;

final class bj
  extends hb<IGamesService>.b<RealTimeMessageReceivedListener>
{
  private final RealTimeMessage b;
  
  bj(GamesClientImpl paramGamesClientImpl, RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener, RealTimeMessage paramRealTimeMessage)
  {
    super(paramGamesClientImpl, paramRealTimeMessageReceivedListener);
    this.b = paramRealTimeMessage;
  }
  
  public void a(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
  {
    if (paramRealTimeMessageReceivedListener != null) {
      paramRealTimeMessageReceivedListener.onRealTimeMessageReceived(this.b);
    }
  }
  
  protected void fu() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */