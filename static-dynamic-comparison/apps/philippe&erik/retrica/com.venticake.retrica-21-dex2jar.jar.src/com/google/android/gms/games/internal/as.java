package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;

final class as
  extends b
  implements GamesMetadata.LoadGamesResult
{
  private final GameBuffer a;
  
  as(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.a = new GameBuffer(paramDataHolder);
  }
  
  public GameBuffer getGames()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */