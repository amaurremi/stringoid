package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;

public final class GameBadgeBuffer
  extends DataBuffer<GameBadge>
{
  public GameBadge cp(int paramInt)
  {
    return new GameBadgeRef(this.DD, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/game/GameBadgeBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */