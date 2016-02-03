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
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RankingController
  extends RequestController
{
  private Ranking b = new Ranking();
  private SearchList c = null;
  
  @PublishedFor__1_0_0
  public RankingController(RequestControllerObserver paramRequestControllerObserver)
  {
    this(null, paramRequestControllerObserver);
  }
  
  @PublishedFor__1_0_0
  public RankingController(Session paramSession, RequestControllerObserver paramRequestControllerObserver)
  {
    super(paramSession, paramRequestControllerObserver);
    if (a() == null) {
      throw new IllegalStateException("I think there's no point in getting a rank of a score in a null game..");
    }
    this.c = SearchList.getDefaultScoreSearchList();
  }
  
  boolean a(Request paramRequest, Response paramResponse)
    throws Exception
  {
    if (paramResponse.f() != 200) {
      throw new Exception("Request failed");
    }
    paramRequest = paramResponse.d();
    this.b = new Ranking();
    this.b.a(paramRequest.getJSONObject(0).getJSONObject("ranking"));
    return true;
  }
  
  boolean g()
  {
    return true;
  }
  
  @PublishedFor__1_0_0
  public Ranking getRanking()
  {
    return this.b;
  }
  
  @PublishedFor__1_0_0
  public SearchList getSearchList()
  {
    return this.c;
  }
  
  @PublishedFor__1_0_0
  public void loadRankingForScore(Score paramScore)
  {
    if (paramScore == null) {
      throw new IllegalArgumentException("score parameter cannot be null");
    }
    if (this.c == null) {
      throw new IllegalArgumentException("Search list or user is required for score ranking");
    }
    if (paramScore.getUser() == null) {
      paramScore.a(d().getUser());
    }
    paramScore = new a(c(), a(), this.c, null, paramScore, paramScore.getMode());
    h();
    a(paramScore);
  }
  
  @PublishedFor__1_0_0
  public void loadRankingForScoreResult(Double paramDouble, Map<String, Object> paramMap)
  {
    loadRankingForScore(new Score(paramDouble, paramMap));
  }
  
  @PublishedFor__1_0_0
  public void loadRankingForUserInGameMode(User paramUser, Integer paramInteger)
  {
    if (paramUser == null) {
      throw new IllegalArgumentException("user paramter cannot be null");
    }
    paramUser = new a(c(), a(), this.c, paramUser, null, paramInteger);
    h();
    a(paramUser);
  }
  
  @PublishedFor__1_0_0
  public void setSearchList(SearchList paramSearchList)
  {
    this.c = paramSearchList;
  }
  
  private static class a
    extends Request
  {
    private final Game a;
    private final Integer b;
    private final Score c;
    private final SearchList e;
    private final User f;
    
    public a(RequestCompletionCallback paramRequestCompletionCallback, Game paramGame, SearchList paramSearchList, User paramUser, Score paramScore, Integer paramInteger)
    {
      super();
      if (paramGame == null) {
        throw new IllegalStateException("internal error: aGame not being set");
      }
      this.a = paramGame;
      this.e = paramSearchList;
      this.f = paramUser;
      this.c = paramScore;
      this.b = paramInteger;
    }
    
    public String a()
    {
      return String.format("/service/games/%s/scores/rankings", new Object[] { this.a.getIdentifier() });
    }
    
    public JSONObject b()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        if (this.e != null) {
          localJSONObject.putOpt("search_list_id", this.e.getIdentifier());
        }
        if (this.c != null)
        {
          localJSONObject.put("score", this.c.c());
          return localJSONObject;
        }
        localJSONObject.put("user_id", this.f.getIdentifier());
        if (this.b != null)
        {
          localJSONObject.put("mode", this.b);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalStateException("Invalid challenge data", localJSONException);
      }
      return localJSONException;
    }
    
    public RequestMethod c()
    {
      return RequestMethod.GET;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/RankingController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */