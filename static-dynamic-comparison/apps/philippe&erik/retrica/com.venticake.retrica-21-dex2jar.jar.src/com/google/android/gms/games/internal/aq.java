package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;

final class aq
  extends b
  implements GamesMetadata.LoadGameInstancesResult
{
  private final GameInstanceBuffer a;
  
  aq(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.a = new GameInstanceBuffer(paramDataHolder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */