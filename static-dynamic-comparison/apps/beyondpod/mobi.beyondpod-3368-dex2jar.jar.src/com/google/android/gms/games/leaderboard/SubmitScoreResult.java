package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ee.a;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.ge;
import java.util.HashMap;

@Deprecated
public final class SubmitScoreResult
{
  private static final String[] wh = { "leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag" };
  private int mC;
  private String tC;
  private String vD;
  private HashMap<Integer, Result> wi;
  
  public SubmitScoreResult(int paramInt, String paramString1, String paramString2)
  {
    this(paramInt, paramString1, paramString2, new HashMap());
  }
  
  public SubmitScoreResult(int paramInt, String paramString1, String paramString2, HashMap<Integer, Result> paramHashMap)
  {
    this.mC = paramInt;
    this.vD = paramString1;
    this.tC = paramString2;
    this.wi = paramHashMap;
  }
  
  public SubmitScoreResult(DataHolder paramDataHolder)
  {
    this.mC = paramDataHolder.getStatusCode();
    this.wi = new HashMap();
    int j = paramDataHolder.getCount();
    if (j == 3) {}
    for (boolean bool = true;; bool = false)
    {
      eg.r(bool);
      int i = 0;
      while (i < j)
      {
        int k = paramDataHolder.C(i);
        if (i == 0)
        {
          this.vD = paramDataHolder.getString("leaderboardId", i, k);
          this.tC = paramDataHolder.getString("playerId", i, k);
        }
        if (paramDataHolder.getBoolean("hasResult", i, k)) {
          a(new Result(paramDataHolder.getLong("rawScore", i, k), paramDataHolder.getString("formattedScore", i, k), paramDataHolder.getString("scoreTag", i, k), paramDataHolder.getBoolean("newBest", i, k)), paramDataHolder.getInteger("timeSpan", i, k));
        }
        i += 1;
      }
    }
  }
  
  private void a(Result paramResult, int paramInt)
  {
    this.wi.put(Integer.valueOf(paramInt), paramResult);
  }
  
  public String getLeaderboardId()
  {
    return this.vD;
  }
  
  public String getPlayerId()
  {
    return this.tC;
  }
  
  public Result getScoreResult(int paramInt)
  {
    return (Result)this.wi.get(Integer.valueOf(paramInt));
  }
  
  public int getStatusCode()
  {
    return this.mC;
  }
  
  public String toString()
  {
    ee.a locala = ee.e(this).a("PlayerId", this.tC).a("StatusCode", Integer.valueOf(this.mC));
    int i = 0;
    if (i < 3)
    {
      Object localObject = (Result)this.wi.get(Integer.valueOf(i));
      locala.a("TimesSpan", ge.aG(i));
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
      return ee.e(this).a("RawScore", Long.valueOf(this.rawScore)).a("FormattedScore", this.formattedScore).a("ScoreTag", this.scoreTag).a("NewBest", Boolean.valueOf(this.newBest)).toString();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/leaderboard/SubmitScoreResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */