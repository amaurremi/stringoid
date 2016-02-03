package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players.LoadPlayersResult;

final class ay
  extends b
  implements Players.LoadPlayersResult
{
  private final PlayerBuffer a;
  
  ay(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.a = new PlayerBuffer(paramDataHolder);
  }
  
  public PlayerBuffer getPlayers()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */