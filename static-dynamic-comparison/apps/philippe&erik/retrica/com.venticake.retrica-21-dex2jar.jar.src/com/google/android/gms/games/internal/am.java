package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;

final class am
  extends b
  implements Achievements.LoadAchievementsResult
{
  private final AchievementBuffer a;
  
  am(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.a = new AchievementBuffer(paramDataHolder);
  }
  
  public AchievementBuffer getAchievements()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */