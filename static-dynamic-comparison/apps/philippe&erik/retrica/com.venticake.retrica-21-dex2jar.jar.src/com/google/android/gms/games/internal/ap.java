package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;

final class ap
  extends b
  implements GamesMetadata.LoadExtendedGamesResult
{
  private final ExtendedGameBuffer a;
  
  ap(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.a = new ExtendedGameBuffer(paramDataHolder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */