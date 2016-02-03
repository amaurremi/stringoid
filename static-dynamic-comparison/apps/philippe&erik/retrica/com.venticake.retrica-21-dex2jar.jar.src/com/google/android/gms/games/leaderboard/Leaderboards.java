package com.google.android.gms.games.leaderboard;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

public abstract interface Leaderboards
{
  public abstract Intent getAllLeaderboardsIntent(GoogleApiClient paramGoogleApiClient);
  
  public abstract Intent getLeaderboardIntent(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<Leaderboards.LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt1, int paramInt2);
  
  public abstract PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient paramGoogleApiClient, String paramString, boolean paramBoolean);
  
  public abstract PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
  
  public abstract PendingResult<Leaderboards.LoadScoresResult> loadMoreScores(GoogleApiClient paramGoogleApiClient, LeaderboardScoreBuffer paramLeaderboardScoreBuffer, int paramInt1, int paramInt2);
  
  public abstract PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void submitScore(GoogleApiClient paramGoogleApiClient, String paramString, long paramLong);
  
  public abstract void submitScore(GoogleApiClient paramGoogleApiClient, String paramString1, long paramLong, String paramString2);
  
  public abstract PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient paramGoogleApiClient, String paramString, long paramLong);
  
  public abstract PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient paramGoogleApiClient, String paramString1, long paramLong, String paramString2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/leaderboard/Leaderboards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */