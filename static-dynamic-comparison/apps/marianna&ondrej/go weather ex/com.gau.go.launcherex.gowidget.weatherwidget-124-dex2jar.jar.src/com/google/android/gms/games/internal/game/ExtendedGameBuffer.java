package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class ExtendedGameBuffer
  extends d<ExtendedGame>
{
  public ExtendedGameBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected ExtendedGame d(int paramInt1, int paramInt2)
  {
    return new ExtendedGameRef(this.BB, paramInt1, paramInt2);
  }
  
  protected String getPrimaryDataMarkerColumn()
  {
    return "external_game_id";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/internal/game/ExtendedGameBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */