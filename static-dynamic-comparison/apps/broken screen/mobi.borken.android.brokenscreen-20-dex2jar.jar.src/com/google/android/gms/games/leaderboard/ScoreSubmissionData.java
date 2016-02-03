package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.hn;
import java.util.HashMap;

public final class ScoreSubmissionData
{
  private static final String[] Sk = { "leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag" };
  private int CQ;
  private String MP;
  private HashMap<Integer, Result> SQ;
  private String Sm;
  
  public ScoreSubmissionData(DataHolder paramDataHolder)
  {
    this.CQ = paramDataHolder.getStatusCode();
    this.SQ = new HashMap();
    int j = paramDataHolder.getCount();
    if (j == 3) {}
    for (boolean bool = true;; bool = false)
    {
      hn.C(bool);
      int i = 0;
      while (i < j)
      {
        int k = paramDataHolder.ae(i);
        if (i == 0)
        {
          this.Sm = paramDataHolder.c("leaderboardId", i, k);
          this.MP = paramDataHolder.c("playerId", i, k);
        }
        if (paramDataHolder.d("hasResult", i, k)) {
          a(new Result(paramDataHolder.a("rawScore", i, k), paramDataHolder.c("formattedScore", i, k), paramDataHolder.c("scoreTag", i, k), paramDataHolder.d("newBest", i, k)), paramDataHolder.b("timeSpan", i, k));
        }
        i += 1;
      }
    }
  }
  
  private void a(Result paramResult, int paramInt)
  {
    this.SQ.put(Integer.valueOf(paramInt), paramResult);
  }
  
  public String getLeaderboardId()
  {
    return this.Sm;
  }
  
  public String getPlayerId()
  {
    return this.MP;
  }
  
  public Result getScoreResult(int paramInt)
  {
    return (Result)this.SQ.get(Integer.valueOf(paramInt));
  }
  
  public String toString()
  {
    hl.a locala = hl.e(this).a("PlayerId", this.MP).a("StatusCode", Integer.valueOf(this.CQ));
    int i = 0;
    if (i < 3)
    {
      Object localObject = (Result)this.SQ.get(Integer.valueOf(i));
      locala.a("TimesSpan", TimeSpan.cm(i));
      if (localObject == null) {}
      for (localObject = "null";; localObject = ((Result)localObject).toString())
      {
        locala.a("Result", localObject);
        i += 1;
        break;
      }
    }
    return locala.toString();
  }
  
  public static final class Result
  {
    public final String formattedScore;
    public final boolean newBest;
    public final long rawScore;
    public final String scoreTag;
    
    public Result(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.rawScore = paramLong;
      this.formattedScore = paramString1;
      this.scoreTag = paramString2;
      this.newBest = paramBoolean;
    }
    
    public String toString()
    {
      return hl.e(this).a("RawScore", Long.valueOf(this.rawScore)).a("FormattedScore", this.formattedScore).a("ScoreTag", this.scoreTag).a("NewBest", Boolean.valueOf(this.newBest)).toString();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/leaderboard/ScoreSubmissionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */