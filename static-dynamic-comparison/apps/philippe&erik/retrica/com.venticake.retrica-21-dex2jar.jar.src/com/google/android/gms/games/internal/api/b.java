package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;

abstract class b
  extends Games.BaseGamesApiMethodImpl<Achievements.UpdateAchievementResult>
{
  private final String a;
  
  public b(String paramString)
  {
    this.a = paramString;
  }
  
  public Achievements.UpdateAchievementResult a(final Status paramStatus)
  {
    new Achievements.UpdateAchievementResult()
    {
      public String getAchievementId()
      {
        return b.a(b.this);
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */