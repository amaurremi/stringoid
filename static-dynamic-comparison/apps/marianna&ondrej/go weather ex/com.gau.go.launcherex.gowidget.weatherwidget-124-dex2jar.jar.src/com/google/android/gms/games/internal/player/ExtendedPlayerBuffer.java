package com.google.android.gms.games.internal.player;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class ExtendedPlayerBuffer
  extends DataBuffer<ExtendedPlayer>
{
  public ExtendedPlayerBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public ExtendedPlayer bk(int paramInt)
  {
    return new ExtendedPlayerRef(this.BB, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/internal/player/ExtendedPlayerBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */