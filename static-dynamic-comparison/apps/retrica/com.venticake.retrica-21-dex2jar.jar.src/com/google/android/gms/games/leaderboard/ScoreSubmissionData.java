package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;
import com.google.android.gms.internal.hm;
import java.util.HashMap;

public final class ScoreSubmissionData
{
  private static final String[] Sn = { "leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag" };
  private int CT;
  private String MS;
  private HashMap<Integer, ScoreSubmissionData.Result> ST;
  private String Sp;
  
  public ScoreSubmissionData(DataHolder paramDataHolder)
  {
    this.CT = paramDataHolder.getStatusCode();
    this.ST = new HashMap();
    int j = paramDataHolder.getCount();
    if (j == 3) {}
    for (boolean bool = true;; bool = false)
    {
      hm.C(bool);
      int i = 0;
      while (i < j)
      {
        int k = paramDataHolder.ae(i);
        if (i == 0)
        {
          this.Sp = paramDataHolder.c("leaderboardId", i, k);
          this.MS = paramDataHolder.c("playerId", i, k);
        }
        if (paramDataHolder.d("hasResult", i, k)) {
          a(new ScoreSubmissionData.Result(paramDataHolder.a("rawScore", i, k), paramDataHolder.c("formattedScore", i, k), paramDataHolder.c("scoreTag", i, k), paramDataHolder.d("newBest", i, k)), paramDataHolder.b("timeSpan", i, k));
        }
        i += 1;
      }
    }
  }
  
  private void a(ScoreSubmissionData.Result paramResult, int paramInt)
  {
    this.ST.put(Integer.valueOf(paramInt), paramResult);
  }
  
  public String getLeaderboardId()
  {
    return this.Sp;
  }
  
  public String getPlayerId()
  {
    return this.MS;
  }
  
  public ScoreSubmissionData.Result getScoreResult(int paramInt)
  {
    return (ScoreSubmissionData.Result)this.ST.get(Integer.valueOf(paramInt));
  }
  
  public String toString()
  {
    hk.a locala = hk.e(this).a("PlayerId", this.MS).a("StatusCode", Integer.valueOf(this.CT));
    int i = 0;
    if (i < 3)
    {
      Object localObject = (ScoreSubmissionData.Result)this.ST.get(Integer.valueOf(i));
      locala.a("TimesSpan", TimeSpan.cm(i));
      if (localObject == null) {}
      for (localObject = "null";; localObject = ((ScoreSubmissionData.Result)localObject).toString())
      {
        locala.a("Result", localObject);
        i += 1;
        break;
      }
    }
    return locala.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/leaderboard/ScoreSubmissionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */