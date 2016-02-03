package com.scoreloop.client.android.core.controller;

import android.os.Handler;
import android.os.Message;
import com.scoreloop.client.android.core.model.Game;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.Session.State;
import com.scoreloop.client.android.core.model.User;
import com.scoreloop.client.android.core.server.Request;
import com.scoreloop.client.android.core.server.RequestCompletionCallback;
import com.scoreloop.client.android.core.server.Response;
import com.scoreloop.client.android.core.server.Server;
import com.scoreloop.client.android.core.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class RequestController
{
  private final a b;
  private Exception c;
  private final RequestControllerObserver d;
  private Request e;
  private final Session f;
  private a g;
  
  static
  {
    if (!RequestController.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  RequestController(Session paramSession, RequestControllerObserver paramRequestControllerObserver)
  {
    if (paramRequestControllerObserver == null) {
      throw new IllegalArgumentException("observer parameter cannot be null");
    }
    if (paramSession == null) {}
    for (this.f = Session.getCurrentSession(); (!a) && (this.f == null); this.f = paramSession) {
      throw new AssertionError();
    }
    this.d = paramRequestControllerObserver;
    this.b = new a(null);
    i();
  }
  
  static Integer a(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("error"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("error");
      if (paramJSONObject != null) {
        return Integer.valueOf(paramJSONObject.getInt("code"));
      }
    }
    return null;
  }
  
  private void b(Request paramRequest)
  {
    this.e = paramRequest;
  }
  
  private void d(Exception paramException)
  {
    Logger.a("onRequestCompleted", "failed with exception: ", paramException);
    c(paramException);
    this.d.requestControllerDidFail(this, paramException);
  }
  
  private Request j()
  {
    return this.e;
  }
  
  private void k()
  {
    Logger.a("RequestController.invokeDidReceiveResponse", " observer = " + this.d.toString());
    this.d.requestControllerDidReceiveResponse(this);
  }
  
  final Game a()
  {
    return d().getGame();
  }
  
  void a(Request paramRequest)
  {
    if (g())
    {
      Session.State localState = d().c();
      if ((localState != Session.State.AUTHENTICATED) && (localState != Session.State.AUTHENTICATING))
      {
        if (this.g == null) {
          this.g = new a(d(), new c(null));
        }
        this.g.j();
      }
    }
    b(paramRequest);
    this.f.b().a(paramRequest);
  }
  
  void a(Exception paramException)
  {
    Request localRequest = j();
    if (localRequest != null)
    {
      localRequest.a(paramException);
      d(paramException);
    }
  }
  
  abstract boolean a(Request paramRequest, Response paramResponse)
    throws Exception;
  
  RequestControllerObserver b()
  {
    return this.d;
  }
  
  protected void b(Exception paramException)
  {
    Logger.a("RequestController.invokeDelayedDidReceiveResponse", " observer = " + this.d.toString());
    new b(this.d, true, paramException).obtainMessage().sendToTarget();
  }
  
  a c()
  {
    return this.b;
  }
  
  protected void c(Exception paramException)
  {
    this.c = paramException;
  }
  
  final Session d()
  {
    return this.f;
  }
  
  final User e()
  {
    return d().getUser();
  }
  
  protected void f()
  {
    Logger.a("RequestController.invokeDelayedDidReceiveResponse", " observer = " + this.d.toString());
    new b(this.d, false, null).obtainMessage().sendToTarget();
  }
  
  abstract boolean g();
  
  void h()
  {
    c(null);
    if (this.e != null)
    {
      if (!this.e.k()) {
        this.f.b().b(this.e);
      }
      this.e = null;
    }
  }
  
  void i()
  {
    if (a() != null) {
      return;
    }
    throw new IllegalStateException("we do not allow game id to be null at all, please initialize Client with valid game id and secret");
  }
  
  private class a
    implements RequestCompletionCallback
  {
    private a() {}
    
    public void a(Request paramRequest)
    {
      RequestController.this.c(null);
      switch (RequestController.1.a[paramRequest.j().ordinal()])
      {
      default: 
        throw new IllegalStateException("onRequestCompleted called for not completed request");
      case 1: 
        Logger.a("RequestController", "RequestCallback.onRequestCompleted: request completed: " + paramRequest.toString());
        try
        {
          if (RequestController.this.a(paramRequest, paramRequest.i())) {
            RequestController.a(RequestController.this);
          }
          return;
        }
        catch (Exception paramRequest)
        {
          RequestController.a(RequestController.this, paramRequest);
          return;
        }
      case 2: 
        Logger.a("RequestController", "RequestCallback.onRequestCompleted: request failed: " + paramRequest.toString());
        RequestController.a(RequestController.this, paramRequest.f());
        return;
      }
      Logger.a("RequestController", "RequestCallback.onRequestCompleted: request cancelled: " + paramRequest.toString());
      RequestController.a(RequestController.this, new RequestCancelledException());
    }
    
    public void b(Request paramRequest) {}
  }
  
  private class b
    extends Handler
  {
    private final Exception b;
    private final boolean c;
    private final RequestControllerObserver d;
    
    public b(RequestControllerObserver paramRequestControllerObserver, boolean paramBoolean, Exception paramException)
    {
      this.d = paramRequestControllerObserver;
      this.b = paramException;
      this.c = paramBoolean;
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (this.c)
      {
        this.d.requestControllerDidFail(RequestController.this, this.b);
        return;
      }
      this.d.requestControllerDidReceiveResponse(RequestController.this);
    }
  }
  
  private class c
    implements RequestControllerObserver
  {
    private c() {}
    
    public void requestControllerDidFail(RequestController paramRequestController, Exception paramException)
    {
      Logger.a("RequestController", "Session authentication failed, failing _request");
      RequestController.b(RequestController.this).a(paramException);
      RequestController.b(RequestController.this).e().a(RequestController.b(RequestController.this));
      RequestController.a(RequestController.this, null);
    }
    
    public void requestControllerDidReceiveResponse(RequestController paramRequestController)
    {
      RequestController.a(RequestController.this, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/RequestController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */