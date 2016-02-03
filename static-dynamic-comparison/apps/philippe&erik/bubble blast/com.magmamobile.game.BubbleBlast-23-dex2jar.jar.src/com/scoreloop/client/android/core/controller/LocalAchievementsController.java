package com.scoreloop.client.android.core.controller;

import android.content.Context;
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
import com.scoreloop.client.android.core.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class LocalAchievementsController
  extends AchievementsController
{
  private static a b = new j();
  private AchievementsStore c = null;
  private final List<JSONObject> d = new ArrayList();
  
  public LocalAchievementsController(Session paramSession, RequestControllerObserver paramRequestControllerObserver)
  {
    super(paramSession, paramRequestControllerObserver);
  }
  
  private Achievement a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = r().a(paramString);
      if (localJSONObject != null) {
        return new Achievement(l(), localJSONObject, false);
      }
      paramString = new Achievement(l().a(paramString), m());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      throw new IllegalStateException(paramString);
    }
  }
  
  private void a(Achievement paramAchievement)
  {
    try
    {
      if (paramAchievement.getIdentifier() == null) {
        throw new JSONException("synched achievement without an identifier?");
      }
    }
    catch (JSONException paramAchievement)
    {
      d(paramAchievement);
      return;
    }
    paramAchievement.a(false);
    JSONObject localJSONObject = paramAchievement.g();
    r().a(paramAchievement.a().a(), localJSONObject);
    o();
  }
  
  private void b(List<Achievement> paramList)
    throws JSONException
  {
    AchievementsStore localAchievementsStore = r();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Achievement localAchievement1 = (Achievement)paramList.next();
      String str = localAchievement1.a().a();
      Achievement localAchievement2 = a(str);
      if (localAchievement2.a(localAchievement1)) {
        localAchievementsStore.a(str, localAchievement2.g());
      }
    }
    localAchievementsStore.d();
  }
  
  private void d(Exception paramException)
  {
    Logger.c("failed to synchronize achievement, skipping: " + paramException);
    o();
  }
  
  private void o()
  {
    if (this.d.size() > 0) {
      this.d.remove(0);
    }
    p();
  }
  
  private void p()
  {
    if (this.d.size() > 0) {
      try
      {
        Object localObject = (JSONObject)this.d.get(0);
        localObject = new Achievement(l(), (JSONObject)localObject, false);
        a(new b(c(), m(), a(), (Achievement)localObject));
        return;
      }
      catch (JSONException localJSONException)
      {
        d(localJSONException);
        return;
      }
    }
    f();
  }
  
  private void q()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = l().b().iterator();
    while (localIterator.hasNext())
    {
      Award localAward = (Award)localIterator.next();
      try
      {
        localArrayList.add(a(localAward.a()));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Logger.b("cant create achievement from local store for award: " + localAward);
      }
    }
    a(localArrayList);
  }
  
  private AchievementsStore r()
  {
    if (this.c == null)
    {
      Context localContext = d().d();
      String str = a().getIdentifier();
      this.c = b.a(localContext, str);
    }
    return this.c;
  }
  
  boolean a(Request paramRequest, Response paramResponse)
    throws Exception
  {
    int i = paramResponse.f();
    JSONObject localJSONObject = paramResponse.e();
    if ((paramRequest instanceof b)) {
      if ((i != 200) && (i != 201)) {
        try
        {
          throw new Exception("invalid status code" + i);
        }
        catch (Exception paramRequest)
        {
          d(paramRequest);
        }
      }
    }
    for (;;)
    {
      return false;
      paramRequest = localJSONObject.getJSONObject(Achievement.h());
      a(new Achievement(l(), paramRequest, true));
      continue;
      super.a(paramRequest, paramResponse);
      b(n());
      j();
    }
  }
  
  protected void h()
  {
    this.d.clear();
    super.h();
  }
  
  public void j()
  {
    if (!r().a())
    {
      super.k();
      return;
    }
    h();
    this.d.addAll(r().c());
    p();
  }
  
  public void k()
  {
    q();
    f();
  }
  
  static abstract interface a
  {
    public abstract AchievementsStore a(Context paramContext, String paramString);
  }
  
  private static final class b
    extends Request
  {
    private User a;
    private Game b;
    private Achievement c;
    
    public b(RequestCompletionCallback paramRequestCompletionCallback, User paramUser, Game paramGame, Achievement paramAchievement)
    {
      super();
      this.a = paramUser;
      this.b = paramGame;
      this.c = paramAchievement;
    }
    
    public String a()
    {
      return String.format("/service/games/%s/achievements", new Object[] { this.b.getIdentifier() });
    }
    
    public JSONObject b()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        this.c.a(this.a.getIdentifier());
        this.c.a(false);
        localJSONObject.put(this.c.b(), this.c.g());
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalStateException("Invalid achievement data", localJSONException);
      }
    }
    
    public RequestMethod c()
    {
      return RequestMethod.POST;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/LocalAchievementsController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */