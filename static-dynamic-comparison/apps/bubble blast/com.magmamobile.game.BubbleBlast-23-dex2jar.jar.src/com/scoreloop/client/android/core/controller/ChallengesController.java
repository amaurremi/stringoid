package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.model.Challenge;
import com.scoreloop.client.android.core.model.Game;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.User;
import com.scoreloop.client.android.core.server.Request;
import com.scoreloop.client.android.core.server.RequestCompletionCallback;
import com.scoreloop.client.android.core.server.RequestMethod;
import com.scoreloop.client.android.core.server.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChallengesController
  extends RequestController
{
  private List<Challenge> b = Collections.emptyList();
  private Integer c = null;
  
  @PublishedFor__1_0_0
  public ChallengesController(RequestControllerObserver paramRequestControllerObserver)
  {
    this(null, paramRequestControllerObserver);
  }
  
  @PublishedFor__1_0_0
  public ChallengesController(Session paramSession, RequestControllerObserver paramRequestControllerObserver)
  {
    super(paramSession, paramRequestControllerObserver);
  }
  
  private void a(String paramString)
  {
    Game localGame = a();
    User localUser = d().getUser();
    paramString = new a(c(), localGame, localUser, paramString, this.c);
    h();
    a(paramString);
  }
  
  private void a(List<Challenge> paramList)
  {
    this.b = Collections.unmodifiableList(paramList);
  }
  
  boolean a(Request paramRequest, Response paramResponse)
    throws Exception
  {
    int i = paramResponse.f();
    if (i != 200) {
      throw new Exception("Request failed with status:" + i);
    }
    paramRequest = ((JSONObject)paramResponse.a()).getJSONArray("challenges");
    paramResponse = new ArrayList();
    int j = paramRequest.length();
    i = 0;
    while (i < j)
    {
      paramResponse.add(new Challenge(paramRequest.getJSONObject(i).getJSONObject("challenge")));
      i += 1;
    }
    a(paramResponse);
    return true;
  }
  
  boolean g()
  {
    return true;
  }
  
  @PublishedFor__1_0_0
  public List<Challenge> getChallenges()
  {
    return this.b;
  }
  
  @PublishedFor__1_0_0
  public Integer getMode()
  {
    return this.c;
  }
  
  @PublishedFor__1_0_0
  public void loadChallengeHistory()
  {
    a("#history");
  }
  
  @PublishedFor__1_0_0
  public void loadOpenChallenges()
  {
    a("#open");
  }
  
  @PublishedFor__1_0_0
  public void setMode(Integer paramInteger)
  {
    this.c = paramInteger;
  }
  
  private static class a
    extends Request
  {
    private final Game a;
    private final Integer b;
    private final String c;
    private final User e;
    
    public a(RequestCompletionCallback paramRequestCompletionCallback, Game paramGame, User paramUser, String paramString, Integer paramInteger)
    {
      super();
      if (paramGame == null) {
        throw new IllegalStateException("internal error: aGame should be set");
      }
      this.a = paramGame;
      this.e = paramUser;
      this.c = paramString;
      this.b = paramInteger;
    }
    
    public String a()
    {
      return String.format("/service/games/%s/challenges", new Object[] { this.a.getIdentifier() });
    }
    
    public JSONObject b()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        if (this.c != null) {
          localJSONObject.put("search_list_id", this.c);
        }
        if (this.e != null) {
          localJSONObject.put("user_id", this.e.getIdentifier());
        }
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/ChallengesController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */