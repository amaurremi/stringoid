package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;

final class cq
  extends b
{
  cq(GamesClientImpl paramGamesClientImpl, RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
  {
    super(paramGamesClientImpl, paramRoomUpdateListener, paramDataHolder);
  }
  
  public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
  {
    paramRoomUpdateListener.onRoomConnected(paramInt, paramRoom);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */