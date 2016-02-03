package com.google.android.gms.games.achievement;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface Achievements$LoadAchievementsResult
  extends Releasable, Result
{
  public abstract AchievementBuffer getAchievements();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/achievement/Achievements$LoadAchievementsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */