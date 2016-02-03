package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataBuffer;

public final class GameRequestSummaryBuffer
  extends DataBuffer<GameRequestSummary>
{
  public GameRequestSummary br(int paramInt)
  {
    return new GameRequestSummaryRef(this.BB, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/request/GameRequestSummaryBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */