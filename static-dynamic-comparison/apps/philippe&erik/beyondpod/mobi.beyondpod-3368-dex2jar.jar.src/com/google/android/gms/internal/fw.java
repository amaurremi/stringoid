package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.a;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class fw
  implements Leaderboards
{
  public Intent getAllLeaderboardsIntent(GoogleApiClient paramGoogleApiClient)
  {
    return Games.j(paramGoogleApiClient).getAllLeaderboardsIntent();
  }
  
  public Intent getLeaderboardIntent(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return Games.j(paramGoogleApiClient).getLeaderboardIntent(paramString);
  }
  
  public PendingResult<Leaderboards.LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient paramGoogleApiClient, final String paramString, final int paramInt1, final int paramInt2)
  {
    paramGoogleApiClient.a(new b(paramString)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, null, paramString, paramInt1, paramInt2);
      }
    });
  }
  
  public PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient paramGoogleApiClient, final String paramString, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new a(paramString)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, paramString, paramBoolean);
      }
    });
  }
  
  public PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new a(paramBoolean)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, paramBoolean);
      }
    });
  }
  
  public PendingResult<Leaderboards.LoadScoresResult> loadMoreScores(GoogleApiClient paramGoogleApiClient, final LeaderboardScoreBuffer paramLeaderboardScoreBuffer, final int paramInt1, final int paramInt2)
  {
    paramGoogleApiClient.a(new c(paramLeaderboardScoreBuffer)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, paramLeaderboardScoreBuffer, paramInt1, paramInt2);
      }
    });
  }
  
  public PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return loadPlayerCenteredScores(paramGoogleApiClient, paramString, paramInt1, paramInt2, paramInt3, false);
  }
  
  public PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient paramGoogleApiClient, final String paramString, final int paramInt1, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new c(paramString)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.b(this, paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
      }
    });
  }
  
  public PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return loadTopScores(paramGoogleApiClient, paramString, paramInt1, paramInt2, paramInt3, false);
  }
  
  public PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient paramGoogleApiClient, final String paramString, final int paramInt1, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new c(paramString)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
      }
    });
  }
  
  public void submitScore(GoogleApiClient paramGoogleApiClient, String paramString, long paramLong)
  {
    submitScore(paramGoogleApiClient, paramString, paramLong, null);
  }
  
  public void submitScore(GoogleApiClient paramGoogleApiClient, String paramString1, long paramLong, String paramString2)
  {
    Games.j(paramGoogleApiClient).a(null, paramString1, paramLong, paramString2);
  }
  
  public PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient paramGoogleApiClient, String paramString, long paramLong)
  {
    return submitScoreImmediate(paramGoogleApiClient, paramString, paramLong, null);
  }
  
  public PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient paramGoogleApiClient, final String paramString1, final long paramLong, String paramString2)
  {
    paramGoogleApiClient.b(new d()
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, paramString1, paramLong, this.vg);
      }
    });
  }
  
  private static abstract class a
    extends Games.a<Leaderboards.LeaderboardMetadataResult>
  {
    public Leaderboards.LeaderboardMetadataResult x(final Status paramStatus)
    {
      new Leaderboards.LeaderboardMetadataResult()
      {
        public LeaderboardBuffer getLeaderboards()
        {
          return new LeaderboardBuffer(DataHolder.empty(14));
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
    extends Games.a<Leaderboards.LoadPlayerScoreResult>
  {
    public Leaderboards.LoadPlayerScoreResult y(final Status paramStatus)
    {
      new Leaderboards.LoadPlayerScoreResult()
      {
        public LeaderboardScore getScore()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class c
    extends Games.a<Leaderboards.LoadScoresResult>
  {
    public Leaderboards.LoadScoresResult z(final Status paramStatus)
    {
      new Leaderboards.LoadScoresResult()
      {
        public Leaderboard getLeaderboard()
        {
          return null;
        }
        
        public LeaderboardScoreBuffer getScores()
        {
          return new LeaderboardScoreBuffer(DataHolder.empty(14));
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
  
  protected static abstract class d
    extends Games.a<Leaderboards.SubmitScoreResult>
  {
    public Leaderboards.SubmitScoreResult A(final Status paramStatus)
    {
      new Leaderboards.SubmitScoreResult()
      {
        public ScoreSubmissionData getScoreData()
        {
          return new ScoreSubmissionData(DataHolder.empty(14));
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/fw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */