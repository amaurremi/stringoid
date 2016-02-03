package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class GameRequestBuffer
  extends g<GameRequest>
{
  public GameRequestBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected String eZ()
  {
    return "external_request_id";
  }
  
  protected GameRequest k(int paramInt1, int paramInt2)
  {
    return new GameRequestRef(this.DG, paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/request/GameRequestBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */