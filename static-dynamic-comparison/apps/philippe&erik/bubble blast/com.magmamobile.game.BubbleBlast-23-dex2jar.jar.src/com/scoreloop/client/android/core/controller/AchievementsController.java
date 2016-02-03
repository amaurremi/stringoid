package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.model.Achievement;
import com.scoreloop.client.android.core.model.Award;
import com.scoreloop.client.android.core.model.AwardList;
import com.scoreloop.client.android.core.model.Game;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.User;
import com.scoreloop.client.android.core.server.Request;
import com.scoreloop.client.android.core.server.RequestCompletionCallback;
import com.scoreloop.client.android.core.server.RequestMethod;
import com.scoreloop.client.android.core.server.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class AchievementsController
  extends RequestController
{
  private List<Achievement> b = Collections.emptyList();
  private User c = null;
  private AwardList d = null;
  
  public AchievementsController(Session paramSession, RequestControllerObserver paramRequestControllerObserver)
  {
    super(paramSession, paramRequestControllerObserver);
  }
  
  protected void a(List<Achievement> paramList)
  {
    this.b = Collections.unmodifiableList(paramList);
  }
  
  boolean a(Request paramRequest, Response paramResponse)
    throws Exception
  {
    try
    {
      if (paramResponse.f() != 200) {
        throw new IllegalStateException("invalid response status: " + paramResponse.f());
      }
    }
    catch (Exception paramRequest)
    {
      throw new IllegalStateException(paramRequest);
    }
    HashMap localHashMap = new HashMap();
    paramResponse = paramResponse.e().getJSONArray("achievements");
    paramRequest = l();
    Object localObject1 = Achievement.h();
    int j = paramResponse.length();
    int i = 0;
    while (i < j)
    {
      localObject2 = new Achievement(paramRequest, paramResponse.getJSONObject(i).getJSONObject((String)localObject1), true);
      localHashMap.put(((Achievement)localObject2).a().a(), localObject2);
      i += 1;
    }
    localObject1 = new ArrayList();
    Object localObject2 = paramRequest.b().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Award localAward = (Award)((Iterator)localObject2).next();
      paramResponse = (Achievement)localHashMap.get(localAward.a());
      paramRequest = paramResponse;
      if (paramResponse == null) {
        paramRequest = new Achievement(localAward, m());
      }
      ((List)localObject1).add(paramRequest);
    }
    a((List)localObject1);
    return true;
  }
  
  boolean g()
  {
    return true;
  }
  
  public void k()
  {
    h();
    a(new a(c(), m(), a(), l()));
  }
  
  public AwardList l()
  {
    if (this.d == null) {
      this.d = AwardList.a(d().d(), a().getIdentifier());
    }
    return this.d;
  }
  
  public User m()
  {
    return this.c;
  }
  
  public List<Achievement> n()
  {
    return this.b;
  }
  
  private static final class a
    extends Request
  {
    private User a;
    private Game b;
    private AwardList c;
    
    public a(RequestCompletionCallback paramRequestCompletionCallback, User paramUser, Game paramGame, AwardList paramAwardList)
    {
      super();
      this.a = paramUser;
      this.b = paramGame;
      this.c = paramAwardList;
    }
    
    public String a()
    {
      return String.format("/service/games/%s/achievements", new Object[] { this.b.getIdentifier() });
    }
    
    /* Error */
    public JSONObject b()
    {
      // Byte code:
      //   0: new 45	org/json/JSONObject
      //   3: dup
      //   4: invokespecial 48	org/json/JSONObject:<init>	()V
      //   7: astore_2
      //   8: aload_2
      //   9: ldc 50
      //   11: aload_0
      //   12: getfield 19	com/scoreloop/client/android/core/controller/AchievementsController$a:a	Lcom/scoreloop/client/android/core/model/User;
      //   15: invokevirtual 53	com/scoreloop/client/android/core/model/User:getIdentifier	()Ljava/lang/String;
      //   18: invokevirtual 57	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   21: pop
      //   22: aload_0
      //   23: getfield 23	com/scoreloop/client/android/core/controller/AchievementsController$a:c	Lcom/scoreloop/client/android/core/model/AwardList;
      //   26: ifnull +21 -> 47
      //   29: aload_0
      //   30: getfield 23	com/scoreloop/client/android/core/controller/AchievementsController$a:c	Lcom/scoreloop/client/android/core/model/AwardList;
      //   33: invokevirtual 61	com/scoreloop/client/android/core/model/AwardList:a	()Ljava/lang/String;
      //   36: astore_1
      //   37: aload_2
      //   38: ldc 63
      //   40: aload_1
      //   41: invokevirtual 57	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   44: pop
      //   45: aload_2
      //   46: areturn
      //   47: aconst_null
      //   48: astore_1
      //   49: goto -12 -> 37
      //   52: astore_1
      //   53: new 65	java/lang/IllegalStateException
      //   56: dup
      //   57: ldc 67
      //   59: aload_1
      //   60: invokespecial 70	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   63: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	64	0	this	a
      //   36	13	1	str	String
      //   52	8	1	localJSONException	org.json.JSONException
      //   7	39	2	localJSONObject	JSONObject
      // Exception table:
      //   from	to	target	type
      //   8	37	52	org/json/JSONException
      //   37	45	52	org/json/JSONException
    }
    
    public RequestMethod c()
    {
      return RequestMethod.GET;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/AchievementsController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */