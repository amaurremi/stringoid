package com.google.android.gms.games.leaderboard;

import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;

public final class ScoreSubmissionData$Result
{
  public final String formattedScore;
  public final boolean newBest;
  public final long rawScore;
  public final String scoreTag;
  
  public ScoreSubmissionData$Result(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.rawScore = paramLong;
    this.formattedScore = paramString1;
    this.scoreTag = paramString2;
    this.newBest = paramBoolean;
  }
  
  public String toString()
  {
    return hk.e(this).a("RawScore", Long.valueOf(this.rawScore)).a("FormattedScore", this.formattedScore).a("ScoreTag", this.scoreTag).a("NewBest", Boolean.valueOf(this.newBest)).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/leaderboard/ScoreSubmissionData$Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */