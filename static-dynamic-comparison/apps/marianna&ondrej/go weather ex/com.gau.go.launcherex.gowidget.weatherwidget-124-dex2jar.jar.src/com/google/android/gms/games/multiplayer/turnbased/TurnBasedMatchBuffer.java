package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class TurnBasedMatchBuffer
  extends d<TurnBasedMatch>
{
  public TurnBasedMatchBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected TurnBasedMatch getEntry(int paramInt1, int paramInt2)
  {
    return new TurnBasedMatchRef(this.BB, paramInt1, paramInt2);
  }
  
  protected String getPrimaryDataMarkerColumn()
  {
    return "external_match_id";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */