package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.model.Device;
import com.scoreloop.client.android.core.model.Game;
import com.scoreloop.client.android.core.model.Money;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.Session.State;
import com.scoreloop.client.android.core.model.User;
import com.scoreloop.client.android.core.server.Request;
import com.scoreloop.client.android.core.server.RequestCompletionCallback;
import com.scoreloop.client.android.core.server.RequestMethod;
import com.scoreloop.client.android.core.server.Response;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class a
  extends RequestController
{
  private c b;
  private final RequestControllerObserver c = new b(null);
  
  a(Session paramSession, RequestControllerObserver paramRequestControllerObserver)
  {
    super(paramSession, paramRequestControllerObserver);
  }
  
  private List<Money> a(Money paramMoney)
  {
    String str = paramMoney.d();
    if (paramMoney.compareTo(new Money(str, new BigDecimal(10000))) < 0) {
      return a(str);
    }
    if (paramMoney.compareTo(new Money(str, new BigDecimal(100000))) < 0) {
      return c(str);
    }
    return b(str);
  }
  
  private List<Money> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Money(paramString, new BigDecimal(100)));
    localArrayList.add(new Money(paramString, new BigDecimal(200)));
    localArrayList.add(new Money(paramString, new BigDecimal(500)));
    localArrayList.add(new Money(paramString, new BigDecimal(1000)));
    localArrayList.add(new Money(paramString, new BigDecimal(2000)));
    localArrayList.add(new Money(paramString, new BigDecimal(5000)));
    return localArrayList;
  }
  
  private List<Money> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Money(paramString, new BigDecimal(1000)));
    localArrayList.add(new Money(paramString, new BigDecimal(2500)));
    localArrayList.add(new Money(paramString, new BigDecimal(5000)));
    localArrayList.add(new Money(paramString, new BigDecimal(10000)));
    localArrayList.add(new Money(paramString, new BigDecimal(50000)));
    localArrayList.add(new Money(paramString, new BigDecimal(100000)));
    return localArrayList;
  }
  
  private List<Money> c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Money(paramString, new BigDecimal(500)));
    localArrayList.add(new Money(paramString, new BigDecimal(1000)));
    localArrayList.add(new Money(paramString, new BigDecimal(2500)));
    localArrayList.add(new Money(paramString, new BigDecimal(5000)));
    localArrayList.add(new Money(paramString, new BigDecimal(10000)));
    localArrayList.add(new Money(paramString, new BigDecimal(20000)));
    return localArrayList;
  }
  
  boolean a(Request paramRequest, Response paramResponse)
    throws Exception
  {
    paramRequest = d();
    int i = paramResponse.f();
    paramResponse = paramResponse.e();
    Object localObject = paramResponse.optJSONObject("user");
    if (((i == 200) || (i == 201)) && (localObject != null))
    {
      User localUser = paramRequest.getUser();
      localUser.a((JSONObject)localObject);
      localUser.a(true);
      localObject = paramResponse.optString("characteristic");
      if ((localObject != null) && (paramRequest.getGame() != null)) {
        paramRequest.getGame().a((String)localObject);
      }
      paramRequest.a(a(localUser.a()));
      paramRequest.a(paramResponse);
      paramRequest.a(Session.State.AUTHENTICATED);
      return true;
    }
    paramRequest.a(Session.State.FAILED);
    throw new Exception("Session authentication request failed with status: " + i);
  }
  
  boolean g()
  {
    return false;
  }
  
  void j()
  {
    Session localSession = d();
    Device localDevice = localSession.a();
    if (localSession.c() == Session.State.FAILED) {
      localDevice.a(null);
    }
    a locala = new a(c(), a(), localDevice);
    if ((localDevice.a() == null) && (this.b == null)) {
      this.b = new c(d(), this.c);
    }
    h();
    localSession.a(Session.State.AUTHENTICATING);
    if (localDevice.a() == null) {
      this.b.k();
    }
    a(locala);
  }
  
  private static class a
    extends Request
  {
    private final Device a;
    private final Game b;
    
    public a(RequestCompletionCallback paramRequestCompletionCallback, Game paramGame, Device paramDevice)
    {
      super();
      this.b = paramGame;
      this.a = paramDevice;
    }
    
    public String a()
    {
      if (this.b != null) {
        return String.format("/service/games/%s/session", new Object[] { this.b.getIdentifier() });
      }
      return "/service/session";
    }
    
    public JSONObject b()
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("device_id", this.a.a());
        localJSONObject1.put("user", localJSONObject2);
        return localJSONObject1;
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalStateException("Invalid device data");
      }
    }
    
    public RequestMethod c()
    {
      return RequestMethod.POST;
    }
  }
  
  private final class b
    implements RequestControllerObserver
  {
    static
    {
      if (!a.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        a = bool;
        return;
      }
    }
    
    private b() {}
    
    public void requestControllerDidFail(RequestController paramRequestController, Exception paramException)
    {
      paramRequestController = a.this.d();
      if ((!a) && (paramRequestController.c() != Session.State.AUTHENTICATING)) {
        throw new AssertionError();
      }
      paramRequestController.a(Session.State.FAILED);
      a.this.a(paramException);
      a.a(a.this, null);
    }
    
    public void requestControllerDidReceiveResponse(RequestController paramRequestController)
    {
      paramRequestController = a.this.d();
      if ((!a) && (paramRequestController.c() != Session.State.AUTHENTICATING)) {
        throw new AssertionError();
      }
      if (paramRequestController.a().a() != null)
      {
        paramRequestController.getUser().a(paramRequestController.a().a());
        a.a(a.this, null);
        return;
      }
      throw new IllegalStateException();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */