package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;

public final class GameBadgeBuffer
  extends DataBuffer<GameBadge>
{
  public GameBadge dK(int paramInt)
  {
    return new GameBadgeRef(this.IC, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/game/GameBadgeBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */