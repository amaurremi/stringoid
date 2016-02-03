package com.scoreloop.client.android.core.server;

import org.json.JSONObject;

public class Request
{
  private static int a;
  private final RequestCompletionCallback b;
  private String c;
  private JSONObject e;
  private Exception f;
  private JSONObject g;
  private final int h;
  private RequestMethod i;
  private Response j;
  private State k;
  
  static
  {
    if (!Request.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      a = 0;
      return;
    }
  }
  
  public Request(RequestCompletionCallback paramRequestCompletionCallback)
  {
    this.b = paramRequestCompletionCallback;
    this.k = State.IDLE;
    this.i = RequestMethod.GET;
    this.h = d();
  }
  
  public static int d()
  {
    int m = a;
    a = m + 1;
    return m;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(Response paramResponse)
  {
    if ((!d) && (this.k != State.EXECUTING)) {
      throw new AssertionError();
    }
    this.k = State.COMPLETED;
    this.j = paramResponse;
    this.f = null;
  }
  
  public void a(Exception paramException)
  {
    if ((!d) && (this.k != State.EXECUTING)) {
      throw new AssertionError();
    }
    this.k = State.FAILED;
    this.j = null;
    this.f = paramException;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.g = paramJSONObject;
  }
  
  public JSONObject b()
  {
    return this.e;
  }
  
  public RequestMethod c()
  {
    return this.i;
  }
  
  public RequestCompletionCallback e()
  {
    if (this.b == null) {
      throw new IllegalStateException();
    }
    return this.b;
  }
  
  public Exception f()
  {
    return this.f;
  }
  
  public JSONObject g()
  {
    return this.g;
  }
  
  public int h()
  {
    return this.h;
  }
  
  public Response i()
  {
    return this.j;
  }
  
  public State j()
  {
    try
    {
      State localState = this.k;
      return localState;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean k()
  {
    State localState = j();
    return (localState == State.COMPLETED) || (localState == State.CANCELLED) || (localState == State.FAILED);
  }
  
  public void l()
  {
    if ((!d) && (this.k != State.EXECUTING) && (this.k != State.ENQUEUED)) {
      throw new AssertionError();
    }
    this.k = State.CANCELLED;
    this.j = null;
    this.f = null;
  }
  
  public void m()
  {
    if ((!d) && (this.k != State.IDLE)) {
      throw new AssertionError();
    }
    this.k = State.ENQUEUED;
  }
  
  public void n()
  {
    if ((!d) && (this.k != State.IDLE) && (this.k != State.ENQUEUED)) {
      throw new AssertionError();
    }
    this.k = State.EXECUTING;
  }
  
  public static enum State
  {
    private State() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/server/Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */