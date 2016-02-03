package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;

abstract class a
  extends Games.BaseGamesApiMethodImpl<Achievements.LoadAchievementsResult>
{
  public Achievements.LoadAchievementsResult a(final Status paramStatus)
  {
    new Achievements.LoadAchievementsResult()
    {
      public AchievementBuffer getAchievements()
      {
        return new AchievementBuffer(DataHolder.af(14));
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
      
      public void release() {}
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */