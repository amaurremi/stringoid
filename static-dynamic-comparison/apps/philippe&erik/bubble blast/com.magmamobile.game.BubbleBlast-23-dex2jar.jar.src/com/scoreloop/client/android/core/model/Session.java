package com.scoreloop.client.android.core.model;

import android.content.Context;
import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.server.Server;
import com.scoreloop.client.android.core.utils.JSONUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class Session
{
  private static Session a;
  private final Device b;
  private Game c;
  private final SessionObserver d;
  private final Server e;
  private String f;
  private Challenge g;
  private List<Money> h;
  private State i;
  private final User j;
  private Context k;
  
  public Session(SessionObserver paramSessionObserver, Server paramServer)
  {
    this.e = paramServer;
    this.d = paramSessionObserver;
    this.h = new ArrayList();
    this.j = new User();
    this.b = new Device();
    this.i = State.INITIAL;
  }
  
  static void a(Session paramSession)
  {
    a = paramSession;
  }
  
  @PublishedFor__1_0_0
  public static Session getCurrentSession()
  {
    return a;
  }
  
  public Device a()
  {
    return this.b;
  }
  
  public void a(Context paramContext)
  {
    this.k = paramContext;
  }
  
  public void a(Game paramGame)
  {
    this.c = paramGame;
  }
  
  public void a(State paramState)
  {
    this.i = paramState;
  }
  
  public void a(List<Money> paramList)
  {
    this.h = paramList;
  }
  
  public void a(JSONObject paramJSONObject)
    throws JSONException
  {
    if (JSONUtils.a(paramJSONObject, "direct_pay_url")) {
      this.f = paramJSONObject.getString("direct_pay_url");
    }
  }
  
  public Server b()
  {
    return this.e;
  }
  
  public State c()
  {
    return this.i;
  }
  
  public Context d()
  {
    return this.k;
  }
  
  @PublishedFor__1_0_0
  public Money getBalance()
  {
    return getUser().a();
  }
  
  @PublishedFor__1_0_0
  public Challenge getChallenge()
  {
    return this.g;
  }
  
  @PublishedFor__1_0_0
  public List<Money> getChallengeStakes()
  {
    return this.h;
  }
  
  @PublishedFor__1_0_0
  public Game getGame()
  {
    return this.c;
  }
  
  @PublishedFor__1_0_0
  public String getPaymentURL()
  {
    return this.f;
  }
  
  @PublishedFor__1_0_0
  public List<SearchList> getScoreSearchLists()
  {
    return getUser().c();
  }
  
  @PublishedFor__1_0_0
  public User getUser()
  {
    return this.j;
  }
  
  @PublishedFor__1_0_0
  public boolean isAuthenticated()
  {
    return this.i == State.AUTHENTICATED;
  }
  
  @PublishedFor__1_0_0
  public void setChallenge(Challenge paramChallenge)
  {
    this.g = paramChallenge;
  }
  
  public static enum State
  {
    private State() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/Session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */