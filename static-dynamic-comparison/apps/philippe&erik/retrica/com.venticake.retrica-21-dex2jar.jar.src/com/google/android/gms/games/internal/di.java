package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;

final class di
  implements Achievements.UpdateAchievementResult
{
  private final Status a;
  private final String b;
  
  di(int paramInt, String paramString)
  {
    this.a = new Status(paramInt);
    this.b = paramString;
  }
  
  public String getAchievementId()
  {
    return this.b;
  }
  
  public Status getStatus()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */