package com.scoreloop.client.android.core.controller;

import android.os.Handler;
import android.os.Message;
import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.model.Challenge;
import com.scoreloop.client.android.core.model.Game;
import com.scoreloop.client.android.core.model.Money;
import com.scoreloop.client.android.core.model.Score;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.User;
import com.scoreloop.client.android.core.server.Request;
import com.scoreloop.client.android.core.server.RequestCompletionCallback;
import com.scoreloop.client.android.core.server.RequestMethod;
import com.scoreloop.client.android.core.server.Response;
import org.json.JSONObject;

public class ChallengeController
  extends RequestController
{
  private Challenge b;
  private b c = new b(this);
  
  @PublishedFor__1_0_0
  public ChallengeController(ChallengeControllerObserver paramChallengeControllerObserver)
  {
    this(null, paramChallengeControllerObserver);
  }
  
  @PublishedFor__1_0_0
  public ChallengeController(Session paramSession, ChallengeControllerObserver paramChallengeControllerObserver)
  {
    super(paramSession, paramChallengeControllerObserver);
  }
  
  private void a(int paramInt, RequestControllerObserver paramRequestControllerObserver)
  {
    Message localMessage = this.c.obtainMessage(paramInt);
    localMessage.obj = paramRequestControllerObserver;
    localMessage.sendToTarget();
  }
  
  boolean a(Request paramRequest, Response paramResponse)
    throws Exception
  {
    paramRequest = (ChallengeControllerObserver)b();
    int i = paramResponse.f();
    if ((i != 200) && (i != 201))
    {
      paramResponse = a(paramResponse.e());
      if (paramResponse == null) {
        throw new Exception("Request failed with status:" + i);
      }
      switch (paramResponse.intValue())
      {
      case 23: 
      case 25: 
      case 26: 
      default: 
        paramRequest.requestControllerDidFail(this, new IllegalArgumentException("error of status: " + i + " and code: " + paramResponse));
      }
    }
    for (;;)
    {
      return false;
      paramRequest.onInsufficientBalance(this);
      continue;
      paramRequest.onCannotAcceptChallenge(this);
      continue;
      Object localObject = paramResponse.e().getJSONObject("challenge");
      paramResponse = getChallenge();
      paramResponse.a((JSONObject)localObject);
      localObject = e();
      if (((((User)localObject).equals(paramResponse.getContender())) && (!paramResponse.isCreated())) || ((((User)localObject).equals(paramResponse.getContestant())) && ((paramResponse.isRejected()) || (paramResponse.isComplete())))) {
        d().setChallenge(null);
      }
      paramRequest.requestControllerDidReceiveResponse(this);
    }
  }
  
  @PublishedFor__1_0_0
  public void acceptChallenge()
  {
    ChallengeControllerObserver localChallengeControllerObserver = (ChallengeControllerObserver)b();
    if (d().getBalance().compareTo(getChallenge().getStake()) < 0)
    {
      a(3, localChallengeControllerObserver);
      return;
    }
    if (!getChallenge().isPlayableForUser(e()))
    {
      a(1, localChallengeControllerObserver);
      return;
    }
    getChallenge().a(e(), true);
    submitChallenge();
  }
  
  @PublishedFor__1_0_0
  public void createChallenge(Money paramMoney, User paramUser)
  {
    if (paramMoney == null) {
      throw new IllegalArgumentException("aSomeMoney parameter cannot be null");
    }
    if (!d().isAuthenticated()) {
      throw new IllegalStateException("session needs to be authenticated before calling ChallengeController.createChallenge");
    }
    User localUser = e();
    if (localUser.a().compareTo(paramMoney) < 0) {
      throw new IllegalStateException("User's balance is not sufficient");
    }
    if (localUser.equals(paramUser)) {
      throw new IllegalStateException("User cannot challenge himself");
    }
    paramMoney = new Challenge(paramMoney);
    paramMoney.setContender(localUser);
    paramMoney.setContestant(paramUser);
    this.b = paramMoney;
    d().setChallenge(paramMoney);
  }
  
  boolean g()
  {
    return true;
  }
  
  @PublishedFor__1_0_0
  public Challenge getChallenge()
  {
    if (this.b == null) {
      this.b = d().getChallenge();
    }
    return this.b;
  }
  
  @PublishedFor__1_0_0
  public void rejectChallenge()
  {
    ChallengeControllerObserver localChallengeControllerObserver = (ChallengeControllerObserver)b();
    if ((!getChallenge().isAssigned()) || (!getChallenge().getContestant().equals(e())))
    {
      a(2, localChallengeControllerObserver);
      return;
    }
    getChallenge().a(e(), false);
    submitChallenge();
  }
  
  @PublishedFor__1_0_0
  public void setChallenge(Challenge paramChallenge)
  {
    this.b = paramChallenge;
  }
  
  @PublishedFor__1_0_0
  public void submitChallenge()
  {
    Challenge localChallenge = getChallenge();
    if (localChallenge == null) {
      throw new IllegalStateException("Set the challenge first");
    }
    if (localChallenge.getIdentifier() == null) {}
    for (Object localObject = new a(c(), d(), a(), localChallenge);; localObject = new c(c(), d(), a(), localChallenge))
    {
      d().setChallenge(localChallenge);
      h();
      a((Request)localObject);
      return;
    }
  }
  
  @PublishedFor__1_0_0
  public void submitChallengeScore(Score paramScore)
  {
    if (paramScore == null) {
      throw new IllegalArgumentException("aScore parameter can't be null");
    }
    Challenge localChallenge = getChallenge();
    if (localChallenge == null) {
      throw new IllegalStateException("no challenge to submit score to");
    }
    if (paramScore.getUser() == null) {
      paramScore.a(e());
    }
    if (!e().equals(paramScore.getUser())) {
      throw new IllegalStateException("User is not participating in the challenge");
    }
    if (paramScore.a() == null) {
      paramScore.a(paramScore.getUser().b());
    }
    if ((localChallenge != null) && (localChallenge.getMode() != paramScore.getMode())) {
      throw new IllegalStateException("Score mode does not match challenge mode");
    }
    localChallenge.a(paramScore);
    submitChallenge();
  }
  
  private static class a
    extends Request
  {
    protected Challenge a;
    protected Game b;
    protected Session c;
    
    public a(RequestCompletionCallback paramRequestCompletionCallback, Session paramSession, Game paramGame, Challenge paramChallenge)
    {
      super();
      if (paramGame == null) {
        throw new IllegalStateException("internal error: aGame should be set");
      }
      this.c = paramSession;
      this.b = paramGame;
      this.a = paramChallenge;
    }
    
    public String a()
    {
      return String.format("/service/games/%s/challenges", new Object[] { this.b.getIdentifier() });
    }
    
    /* Error */
    public JSONObject b()
    {
      // Byte code:
      //   0: new 52	org/json/JSONObject
      //   3: dup
      //   4: invokespecial 55	org/json/JSONObject:<init>	()V
      //   7: astore_2
      //   8: aload_0
      //   9: getfield 26	com/scoreloop/client/android/core/controller/ChallengeController$a:c	Lcom/scoreloop/client/android/core/model/Session;
      //   12: invokevirtual 61	com/scoreloop/client/android/core/model/Session:getUser	()Lcom/scoreloop/client/android/core/model/User;
      //   15: astore_3
      //   16: aload_0
      //   17: getfield 30	com/scoreloop/client/android/core/controller/ChallengeController$a:a	Lcom/scoreloop/client/android/core/model/Challenge;
      //   20: invokevirtual 66	com/scoreloop/client/android/core/model/Challenge:getContender	()Lcom/scoreloop/client/android/core/model/User;
      //   23: ifnull +70 -> 93
      //   26: aload_0
      //   27: getfield 30	com/scoreloop/client/android/core/controller/ChallengeController$a:a	Lcom/scoreloop/client/android/core/model/Challenge;
      //   30: invokevirtual 66	com/scoreloop/client/android/core/model/Challenge:getContender	()Lcom/scoreloop/client/android/core/model/User;
      //   33: aload_3
      //   34: invokevirtual 72	com/scoreloop/client/android/core/model/User:equals	(Ljava/lang/Object;)Z
      //   37: ifeq +56 -> 93
      //   40: aload_0
      //   41: getfield 30	com/scoreloop/client/android/core/controller/ChallengeController$a:a	Lcom/scoreloop/client/android/core/model/Challenge;
      //   44: invokevirtual 76	com/scoreloop/client/android/core/model/Challenge:getContenderScore	()Lcom/scoreloop/client/android/core/model/Score;
      //   47: astore 4
      //   49: aload 4
      //   51: ifnull +26 -> 77
      //   54: aload 4
      //   56: invokevirtual 79	com/scoreloop/client/android/core/model/Score:getUser	()Lcom/scoreloop/client/android/core/model/User;
      //   59: ifnonnull +9 -> 68
      //   62: aload 4
      //   64: aload_3
      //   65: invokevirtual 82	com/scoreloop/client/android/core/model/Score:a	(Lcom/scoreloop/client/android/core/model/User;)V
      //   68: aload 4
      //   70: aload_3
      //   71: invokevirtual 84	com/scoreloop/client/android/core/model/User:b	()Ljava/lang/String;
      //   74: invokevirtual 86	com/scoreloop/client/android/core/model/Score:a	(Ljava/lang/String;)V
      //   77: aload_2
      //   78: ldc 88
      //   80: aload_0
      //   81: getfield 30	com/scoreloop/client/android/core/controller/ChallengeController$a:a	Lcom/scoreloop/client/android/core/model/Challenge;
      //   84: invokevirtual 90	com/scoreloop/client/android/core/model/Challenge:a	()Lorg/json/JSONObject;
      //   87: invokevirtual 94	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   90: pop
      //   91: aload_2
      //   92: areturn
      //   93: aload_0
      //   94: getfield 30	com/scoreloop/client/android/core/controller/ChallengeController$a:a	Lcom/scoreloop/client/android/core/model/Challenge;
      //   97: invokevirtual 97	com/scoreloop/client/android/core/model/Challenge:getContestant	()Lcom/scoreloop/client/android/core/model/User;
      //   100: ifnull -23 -> 77
      //   103: aload_0
      //   104: getfield 30	com/scoreloop/client/android/core/controller/ChallengeController$a:a	Lcom/scoreloop/client/android/core/model/Challenge;
      //   107: invokevirtual 97	com/scoreloop/client/android/core/model/Challenge:getContestant	()Lcom/scoreloop/client/android/core/model/User;
      //   110: aload_3
      //   111: invokevirtual 72	com/scoreloop/client/android/core/model/User:equals	(Ljava/lang/Object;)Z
      //   114: istore_1
      //   115: iload_1
      //   116: ifeq -39 -> 77
      //   119: goto -42 -> 77
      //   122: astore_2
      //   123: new 19	java/lang/IllegalStateException
      //   126: dup
      //   127: ldc 99
      //   129: aload_2
      //   130: invokespecial 102	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   133: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	134	0	this	a
      //   114	2	1	bool	boolean
      //   7	85	2	localJSONObject	JSONObject
      //   122	8	2	localJSONException	org.json.JSONException
      //   15	96	3	localUser	User
      //   47	22	4	localScore	Score
      // Exception table:
      //   from	to	target	type
      //   8	49	122	org/json/JSONException
      //   54	68	122	org/json/JSONException
      //   68	77	122	org/json/JSONException
      //   77	91	122	org/json/JSONException
      //   93	115	122	org/json/JSONException
    }
    
    public RequestMethod c()
    {
      return RequestMethod.POST;
    }
  }
  
  private static class b
    extends Handler
  {
    private ChallengeController a;
    
    public b(ChallengeController paramChallengeController)
    {
      this.a = paramChallengeController;
    }
    
    public void handleMessage(Message paramMessage)
    {
      ChallengeControllerObserver localChallengeControllerObserver = (ChallengeControllerObserver)paramMessage.obj;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        localChallengeControllerObserver.onCannotAcceptChallenge(this.a);
        return;
      case 2: 
        localChallengeControllerObserver.onCannotRejectChallenge(this.a);
        return;
      }
      localChallengeControllerObserver.onInsufficientBalance(this.a);
    }
  }
  
  private static class c
    extends ChallengeController.a
  {
    public c(RequestCompletionCallback paramRequestCompletionCallback, Session paramSession, Game paramGame, Challenge paramChallenge)
    {
      super(paramSession, paramGame, paramChallenge);
    }
    
    public String a()
    {
      return String.format("/service/games/%s/challenges/%s", new Object[] { this.b.getIdentifier(), this.a.getIdentifier() });
    }
    
    public RequestMethod c()
    {
      return RequestMethod.PUT;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/ChallengeController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */