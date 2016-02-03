package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.b;

final class cf
  extends hb<IGamesService>.b<RealTimeMultiplayer.ReliableMessageSentCallback>
{
  private final int b;
  private final String c;
  private final int d;
  
  cf(GamesClientImpl paramGamesClientImpl, RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback, int paramInt1, int paramInt2, String paramString)
  {
    super(paramGamesClientImpl, paramReliableMessageSentCallback);
    this.b = paramInt1;
    this.d = paramInt2;
    this.c = paramString;
  }
  
  public void a(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback)
  {
    if (paramReliableMessageSentCallback != null) {
      paramReliableMessageSentCallback.onRealTimeMessageSent(this.b, this.d, this.c);
    }
  }
  
  protected void fu() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */