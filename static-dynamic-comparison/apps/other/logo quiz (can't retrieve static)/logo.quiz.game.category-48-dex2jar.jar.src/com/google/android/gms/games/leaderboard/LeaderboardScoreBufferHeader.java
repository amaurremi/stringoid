package com.google.android.gms.games.leaderboard;

import android.os.Bundle;

public final class LeaderboardScoreBufferHeader
{
  private final Bundle MZ;
  
  public LeaderboardScoreBufferHeader(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    this.MZ = localBundle;
  }
  
  public Bundle lz()
  {
    return this.MZ;
  }
  
  public static final class Builder {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/leaderboard/LeaderboardScoreBufferHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */