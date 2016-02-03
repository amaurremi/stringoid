package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataBuffer;

public final class GameNotificationBuffer
  extends DataBuffer<GameNotification>
{
  public GameNotification dO(int paramInt)
  {
    return new GameNotificationRef(this.IC, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/notification/GameNotificationBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */