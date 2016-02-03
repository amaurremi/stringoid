package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.model.Activity;
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
import org.json.JSONObject;

public class ActivitiesController
  extends RequestController
{
  private List<Activity> b = Collections.emptyList();
  
  @PublishedFor__1_0_0
  public ActivitiesController(RequestControllerObserver paramRequestControllerObserver)
  {
    this(null, paramRequestControllerObserver);
  }
  
  @PublishedFor__1_0_0
  public ActivitiesController(Session paramSession, RequestControllerObserver paramRequestControllerObserver)
  {
    super(paramSession, paramRequestControllerObserver);
  }
  
  private void a(List<Activity> paramList)
  {
    this.b = Collections.unmodifiableList(paramList);
  }
  
  boolean a(Request paramRequest, Response paramResponse)
    throws Exception
  {
    if (paramResponse.f() == 200)
    {
      paramRequest = new ArrayList();
      paramResponse = paramResponse.d();
      int i = 0;
      while (i < paramResponse.length())
      {
        paramRequest.add(new Activity(paramResponse.getJSONObject(i).getJSONObject("activity")));
        i += 1;
      }
      a(paramRequest);
      return true;
    }
    throw new IllegalStateException("invalid response status: " + paramResponse.f());
  }
  
  boolean g()
  {
    return true;
  }
  
  @PublishedFor__1_0_0
  public List<Activity> getActivities()
  {
    return this.b;
  }
  
  @PublishedFor__1_0_0
  public void loadBuddyActivities()
  {
    h();
    a(new b(c(), a(), e(), a.buddy));
  }
  
  @PublishedFor__1_0_0
  public void loadGameActivities()
  {
    if (a() == null) {
      throw new IllegalArgumentException("using loadGameActivities does not make sense without gameID being set on AcitiviesController instance");
    }
    h();
    a(new b(c(), a(), null, a.game));
  }
  
  private static enum a
  {
    static
    {
      other = new a("other", 3);
    }
    
    private a() {}
  }
  
  private class b
    extends Request
  {
    private final Game b;
    private final ActivitiesController.a c;
    private final User e;
    
    public b(RequestCompletionCallback paramRequestCompletionCallback, Game paramGame, User paramUser, ActivitiesController.a parama)
    {
      super();
      this.e = paramUser;
      this.c = parama;
      this.b = paramGame;
    }
    
    public String a()
    {
      switch (ActivitiesController.1.a[this.c.ordinal()])
      {
      default: 
        return "/service/activities";
      case 1: 
        if (this.e == null) {
          throw new IllegalStateException("internal error: no _user set");
        }
        return String.format("/service/users/%s/buddies/last_activities", new Object[] { this.e.getIdentifier() });
      case 2: 
        if (this.b == null) {
          throw new IllegalStateException("internal error: no _game set");
        }
        return String.format("/service/games/%s/activities", new Object[] { this.b.getIdentifier() });
      }
      if (this.e == null) {
        throw new IllegalStateException("internal error: no _user set");
      }
      return String.format("/service/users/%s/activities", new Object[] { this.e.getIdentifier() });
    }
    
    public RequestMethod c()
    {
      return RequestMethod.GET;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/ActivitiesController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */