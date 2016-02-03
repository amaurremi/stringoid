package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;

final class cg
  extends AbstractGamesCallbacks
{
  final RealTimeMultiplayer.ReliableMessageSentCallback a;
  
  public cg(GamesClientImpl paramGamesClientImpl, RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback)
  {
    this.a = paramReliableMessageSentCallback;
  }
  
  public void b(int paramInt1, int paramInt2, String paramString)
  {
    this.b.a(new cf(this.b, this.a, paramInt1, paramInt2, paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */