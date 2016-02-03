package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.model.Game;
import com.scoreloop.client.android.core.model.Ranking;
import com.scoreloop.client.android.core.model.Score;
import com.scoreloop.client.android.core.model.SearchList;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.User;
import com.scoreloop.client.android.core.server.Request;
import com.scoreloop.client.android.core.server.RequestCompletionCallback;
import com.scoreloop.client.android.core.server.RequestMethod;
import com.scoreloop.client.android.core.server.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ScoresController
  extends RequestController
{
  private RankingController b;
  private SearchList c = null;
  private Score d = null;
  private Integer e = null;
  private b f;
  private d<Score> g = new d();
  
  @PublishedFor__1_0_0
  public ScoresController(RequestControllerObserver paramRequestControllerObserver)
  {
    this(null, paramRequestControllerObserver);
  }
  
  @PublishedFor__1_0_0
  public ScoresController(Session paramSession, RequestControllerObserver paramRequestControllerObserver)
  {
    super(paramSession, paramRequestControllerObserver);
  }
  
  private void a(int paramInt)
  {
    this.g.a(paramInt);
    b localb = new b(c(), a(), getSearchList(), d().getUser(), getMode(), this.g.a(), paramInt);
    h();
    a(localb);
  }
  
  private void a(Integer paramInteger)
  {
    int i = 1;
    if (paramInteger != null)
    {
      i = getRangeLength() / 2;
      i = Math.max(1, paramInteger.intValue() - i);
    }
    b(i - 1);
    paramInteger = this.f;
    this.f = null;
    h();
    a(paramInteger);
  }
  
  private void b(int paramInt)
  {
    if (this.f == null) {
      throw new IllegalStateException("_nextRequest must not be null");
    }
    this.g.c(paramInt);
    this.f.a(paramInt);
  }
  
  private RankingController j()
  {
    if (this.b == null) {
      this.b = new RankingController(d(), new a(null));
    }
    return this.b;
  }
  
  private void k()
  {
    this.g.a(0);
    this.f = new b(c(), a(), getSearchList(), d().getUser(), getMode(), this.g.a(), 0);
  }
  
  boolean a(Request paramRequest, Response paramResponse)
    throws Exception
  {
    if (paramResponse.f() != 200)
    {
      h();
      throw new Exception("Request failed, returned status: " + paramResponse.f());
    }
    paramResponse = paramResponse.e().getJSONArray("scores");
    if (this.d == null) {}
    ArrayList localArrayList;
    for (paramRequest = null;; paramRequest = this.d.getRank())
    {
      localArrayList = new ArrayList();
      int i = this.g.b();
      int j = 0;
      i += 1;
      while (j < paramResponse.length())
      {
        Score localScore = new Score(paramResponse.getJSONObject(j).getJSONObject("score"));
        int k = i;
        if (paramRequest != null)
        {
          k = i;
          if (i == paramRequest.intValue()) {
            if (this.d.getIdentifier() != null)
            {
              k = i;
              if (localScore.getIdentifier().equals(this.d.getIdentifier())) {}
            }
            else
            {
              localScore.a(Integer.valueOf(i));
              localArrayList.add(this.d);
              k = i + 1;
            }
          }
        }
        localScore.a(Integer.valueOf(k));
        localArrayList.add(localScore);
        i = k + 1;
        j += 1;
      }
    }
    this.g.a(localArrayList);
    return true;
  }
  
  boolean g()
  {
    return true;
  }
  
  @PublishedFor__1_0_0
  public Integer getMode()
  {
    return this.e;
  }
  
  @PublishedFor__1_0_0
  public int getRangeLength()
  {
    return this.g.f();
  }
  
  @PublishedFor__1_0_0
  public List<Score> getScores()
  {
    return this.g.d();
  }
  
  @PublishedFor__1_0_0
  public SearchList getSearchList()
  {
    return this.c;
  }
  
  protected void h()
  {
    if (this.b != null) {
      this.b.h();
    }
    super.h();
  }
  
  @PublishedFor__1_0_0
  public boolean hasNextRange()
  {
    return this.g.h();
  }
  
  @PublishedFor__1_0_0
  public boolean hasPreviousRange()
  {
    return this.g.i();
  }
  
  @PublishedFor__1_0_0
  public void loadNextRange()
  {
    if (!hasNextRange()) {
      throw new IllegalStateException("There's no next range");
    }
    if (this.g.g())
    {
      a(this.g.c());
      return;
    }
    a(0);
  }
  
  @PublishedFor__1_0_0
  public void loadPreviousRange()
  {
    if (!hasPreviousRange()) {
      throw new IllegalStateException("There's no previous range");
    }
    if (this.g.g())
    {
      a(this.g.e());
      return;
    }
    a(0);
  }
  
  @PublishedFor__1_0_0
  public void loadRangeAtRank(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("rank must be a positive integer");
    }
    a(paramInt - 1);
  }
  
  @PublishedFor__1_0_0
  public void loadRangeForScore(Score paramScore)
  {
    h();
    k();
    RankingController localRankingController = j();
    localRankingController.setSearchList(getSearchList());
    this.d = paramScore;
    this.d.a(null);
    localRankingController.loadRankingForScore(paramScore);
  }
  
  @PublishedFor__1_0_0
  public void loadRangeForScoreResult(Double paramDouble, Map<String, Object> paramMap)
  {
    loadRangeForScore(new Score(paramDouble, paramMap));
  }
  
  @PublishedFor__1_0_0
  public void loadRangeForUser(User paramUser)
  {
    h();
    k();
    this.d = null;
    RankingController localRankingController = j();
    localRankingController.setSearchList(getSearchList());
    localRankingController.loadRankingForUserInGameMode(paramUser, getMode());
  }
  
  @PublishedFor__1_0_0
  public void setMode(Integer paramInteger)
  {
    this.e = paramInteger;
  }
  
  @PublishedFor__1_0_0
  public void setRangeLength(int paramInt)
  {
    this.g.b(paramInt);
  }
  
  @PublishedFor__1_0_0
  public void setSearchList(SearchList paramSearchList)
  {
    if (this.c != paramSearchList)
    {
      this.c = paramSearchList;
      if (this.d != null) {
        this.d.a(null);
      }
    }
  }
  
  private class a
    implements RequestControllerObserver
  {
    private a() {}
    
    public void requestControllerDidFail(RequestController paramRequestController, Exception paramException)
    {
      ScoresController.this.b().requestControllerDidFail(ScoresController.this, paramException);
    }
    
    public void requestControllerDidReceiveResponse(RequestController paramRequestController)
    {
      paramRequestController = ((RankingController)paramRequestController).getRanking();
      if ((ScoresController.a(ScoresController.this) != null) && (ScoresController.a(ScoresController.this).getRank() == null)) {
        ScoresController.a(ScoresController.this).a(paramRequestController.getRank());
      }
      ScoresController.a(ScoresController.this, paramRequestController.getRank());
    }
  }
  
  private static class b
    extends Request
  {
    private final Game a;
    private final Integer b;
    private int c;
    private final int e;
    private final SearchList f;
    private final User g;
    
    public b(RequestCompletionCallback paramRequestCompletionCallback, Game paramGame, SearchList paramSearchList, User paramUser, Integer paramInteger, int paramInt1, int paramInt2)
    {
      super();
      if (paramGame == null) {
        throw new IllegalStateException("internal error: null game");
      }
      this.a = paramGame;
      this.f = paramSearchList;
      this.g = paramUser;
      this.b = paramInteger;
      this.e = paramInt1;
      this.c = paramInt2;
    }
    
    public String a()
    {
      return String.format("/service/games/%s/scores", new Object[] { this.a.getIdentifier() });
    }
    
    public void a(int paramInt)
    {
      this.c = paramInt;
    }
    
    public JSONObject b()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        if (this.f != null) {
          localJSONObject.putOpt("search_list_id", this.f.getIdentifier());
        }
        localJSONObject.put("user_id", this.g.getIdentifier());
        localJSONObject.put("offset", this.c);
        localJSONObject.put("per_page", this.e);
        if (this.b != null) {
          localJSONObject.put("mode", this.b);
        }
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalStateException("Invalid challenge data", localJSONException);
      }
    }
    
    public RequestMethod c()
    {
      return RequestMethod.GET;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/ScoresController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */