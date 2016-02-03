package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.d;

abstract class c
  extends hb<IGamesService>.d<RoomStatusUpdateListener>
{
  c(GamesClientImpl paramGamesClientImpl, RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
  {
    super(paramGamesClientImpl, paramRoomStatusUpdateListener, paramDataHolder);
  }
  
  protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
  {
    a(paramRoomStatusUpdateListener, GamesClientImpl.a(this.b, paramDataHolder));
  }
  
  protected abstract void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */