package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.a;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;

public final class fs
  implements Achievements
{
  public Intent getAchievementsIntent(GoogleApiClient paramGoogleApiClient)
  {
    return Games.j(paramGoogleApiClient).getAchievementsIntent();
  }
  
  public void increment(GoogleApiClient paramGoogleApiClient, final String paramString, final int paramInt)
  {
    paramGoogleApiClient.b(new b(paramString)
    {
      public void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(null, paramString, paramInt);
      }
    });
  }
  
  public PendingResult<Achievements.UpdateAchievementResult> incrementImmediate(GoogleApiClient paramGoogleApiClient, final String paramString, final int paramInt)
  {
    paramGoogleApiClient.b(new b(paramString)
    {
      public void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, paramString, paramInt);
      }
    });
  }
  
  public PendingResult<Achievements.LoadAchievementsResult> load(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new a(paramBoolean)
    {
      public void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.b(this, paramBoolean);
      }
    });
  }
  
  public void reveal(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.b(new b(paramString)
    {
      public void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.b(null, paramString);
      }
    });
  }
  
  public PendingResult<Achievements.UpdateAchievementResult> revealImmediate(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.b(new b(paramString)
    {
      public void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.b(this, paramString);
      }
    });
  }
  
  public void setSteps(GoogleApiClient paramGoogleApiClient, final String paramString, final int paramInt)
  {
    paramGoogleApiClient.b(new b(paramString)
    {
      public void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.b(null, paramString, paramInt);
      }
    });
  }
  
  public PendingResult<Achievements.UpdateAchievementResult> setStepsImmediate(GoogleApiClient paramGoogleApiClient, final String paramString, final int paramInt)
  {
    paramGoogleApiClient.b(new b(paramString)
    {
      public void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.b(this, paramString, paramInt);
      }
    });
  }
  
  public void unlock(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.b(new b(paramString)
    {
      public void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.c(null, paramString);
      }
    });
  }
  
  public PendingResult<Achievements.UpdateAchievementResult> unlockImmediate(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.b(new b(paramString)
    {
      public void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.c(this, paramString);
      }
    });
  }
  
  private static abstract class a
    extends Games.a<Achievements.LoadAchievementsResult>
  {
    public Achievements.LoadAchievementsResult t(final Status paramStatus)
    {
      new Achievements.LoadAchievementsResult()
      {
        public AchievementBuffer getAchievements()
        {
          return new AchievementBuffer(DataHolder.empty(14));
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
  
  private static abstract class b
    extends Games.a<Achievements.UpdateAchievementResult>
  {
    private final String uS;
    
    public b(String paramString)
    {
      this.uS = paramString;
    }
    
    public Achievements.UpdateAchievementResult u(final Status paramStatus)
    {
      new Achievements.UpdateAchievementResult()
      {
        public String getAchievementId()
        {
          return fs.b.a(fs.b.this);
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/fs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */