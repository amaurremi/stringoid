package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataBuffer;

public final class GameRequestSummaryBuffer
  extends DataBuffer<GameRequestSummary>
{
  public GameRequestSummary cB(int paramInt)
  {
    return new GameRequestSummaryRef(this.DG, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/request/GameRequestSummaryBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */