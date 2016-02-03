package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.b;

final class al
  extends hb<IGamesService>.b<RoomUpdateListener>
{
  private final int b;
  private final String c;
  
  al(GamesClientImpl paramGamesClientImpl, RoomUpdateListener paramRoomUpdateListener, int paramInt, String paramString)
  {
    super(paramGamesClientImpl, paramRoomUpdateListener);
    this.b = paramInt;
    this.c = paramString;
  }
  
  public void a(RoomUpdateListener paramRoomUpdateListener)
  {
    paramRoomUpdateListener.onLeftRoom(this.b, this.c);
  }
  
  protected void fu() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */