package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class RoomBuffer
  extends g<Room>
{
  public RoomBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected String eZ()
  {
    return "external_match_id";
  }
  
  protected Room h(int paramInt1, int paramInt2)
  {
    return new RoomRef(this.DG, paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */