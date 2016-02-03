package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

final class da
  extends b
  implements Leaderboards.SubmitScoreResult
{
  private final ScoreSubmissionData a;
  
  public da(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    try
    {
      this.a = new ScoreSubmissionData(paramDataHolder);
      return;
    }
    finally
    {
      paramDataHolder.close();
    }
  }
  
  public ScoreSubmissionData getScoreData()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */