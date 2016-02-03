package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class GameBuffer
  extends DataBuffer<Game>
{
  public GameBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public Game get(int paramInt)
  {
    return new GameRef(this.BB, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/GameBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */