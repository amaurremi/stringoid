package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.d;

abstract class b
  extends hb<IGamesService>.d<RoomUpdateListener>
{
  b(GamesClientImpl paramGamesClientImpl, RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
  {
    super(paramGamesClientImpl, paramRoomUpdateListener, paramDataHolder);
  }
  
  protected void a(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
  {
    a(paramRoomUpdateListener, GamesClientImpl.a(this.a, paramDataHolder), paramDataHolder.getStatusCode());
  }
  
  protected abstract void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */