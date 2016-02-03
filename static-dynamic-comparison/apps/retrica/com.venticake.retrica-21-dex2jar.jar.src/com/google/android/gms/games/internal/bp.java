package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.b;

final class bp
  extends hb<IGamesService>.b<RoomStatusUpdateListener>
{
  private final String b;
  
  bp(GamesClientImpl paramGamesClientImpl, RoomStatusUpdateListener paramRoomStatusUpdateListener, String paramString)
  {
    super(paramGamesClientImpl, paramRoomStatusUpdateListener);
    this.b = paramString;
  }
  
  public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener)
  {
    if (paramRoomStatusUpdateListener != null) {
      paramRoomStatusUpdateListener.onP2PDisconnected(this.b);
    }
  }
  
  protected void fu() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */