package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import java.util.ArrayList;

abstract class a
  extends c
{
  private final ArrayList<String> c = new ArrayList();
  
  a(GamesClientImpl paramGamesClientImpl, RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
  {
    super(paramGamesClientImpl, paramRoomStatusUpdateListener, paramDataHolder);
    int i = 0;
    int j = paramArrayOfString.length;
    while (i < j)
    {
      this.c.add(paramArrayOfString[i]);
      i += 1;
    }
  }
  
  protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
  {
    a(paramRoomStatusUpdateListener, paramRoom, this.c);
  }
  
  protected abstract void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */