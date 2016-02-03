package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class a
  extends d<Room>
{
  public a(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected Room b(int paramInt1, int paramInt2)
  {
    return new c(this.nE, paramInt1, paramInt2);
  }
  
  protected String getPrimaryDataMarkerColumn()
  {
    return "external_match_id";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */