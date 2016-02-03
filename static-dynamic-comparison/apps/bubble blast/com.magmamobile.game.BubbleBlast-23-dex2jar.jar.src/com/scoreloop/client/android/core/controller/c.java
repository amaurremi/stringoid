package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.model.Device;
import com.scoreloop.client.android.core.model.Device.State;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.server.Request;
import com.scoreloop.client.android.core.server.RequestCompletionCallback;
import com.scoreloop.client.android.core.server.RequestMethod;
import com.scoreloop.client.android.core.server.Response;
import com.scoreloop.client.android.core.server.Server;
import com.scoreloop.client.android.core.utils.Logger;
import java.nio.channels.IllegalSelectorException;
import org.json.JSONException;
import org.json.JSONObject;

class c
  extends RequestController
{
  private Request b;
  private Device c;
  private Request d;
  
  c(Session paramSession, RequestControllerObserver paramRequestControllerObserver)
  {
    super(paramSession, paramRequestControllerObserver);
    this.c = paramSession.a();
  }
  
  boolean a(Request paramRequest, Response paramResponse)
    throws Exception
  {
    int i = paramResponse.f();
    paramResponse = paramResponse.e().optJSONObject("device");
    if (((a)paramRequest).o() == b.VERIFY)
    {
      if (i == 404) {
        return false;
      }
      if (this.b != null) {
        this.b.l();
      }
      this.b = null;
    }
    if (((i == 200) || (i == 201)) && (paramResponse != null))
    {
      this.c.a(paramResponse.getString("id"));
      if ("freed".equalsIgnoreCase(paramResponse.optString("state")))
      {
        this.c.a(Device.State.FREED);
        return true;
      }
      if (i == 200) {}
      for (paramRequest = Device.State.VERIFIED;; paramRequest = Device.State.CREATED)
      {
        this.c.a(paramRequest);
        break;
      }
    }
    throw new Exception("Request failed with status: " + i);
  }
  
  boolean g()
  {
    return false;
  }
  
  protected void h()
  {
    Logger.a("DeviceController", "reset()");
    super.h();
    if (this.d != null)
    {
      if (!this.d.k())
      {
        Logger.a("DeviceController", "reset() - canceling verify request");
        d().b().b(this.d);
      }
      this.d = null;
    }
  }
  
  Device j()
  {
    return this.c;
  }
  
  void k()
  {
    h();
    this.d = new a(c(), j(), b.VERIFY);
    a(this.d);
    this.b = new a(c(), j(), b.CREATE);
    a(this.b);
  }
  
  private static class a
    extends Request
  {
    private final Device a;
    private final c.b b;
    
    public a(RequestCompletionCallback paramRequestCompletionCallback, Device paramDevice, c.b paramb)
    {
      super();
      this.a = paramDevice;
      this.b = paramb;
    }
    
    public String a()
    {
      return "/service/device";
    }
    
    public JSONObject b()
    {
      JSONObject localJSONObject1 = new JSONObject();
      for (;;)
      {
        try
        {
          switch (c.1.a[this.b.ordinal()])
          {
          case 1: 
            throw new IllegalSelectorException();
          }
        }
        catch (JSONException localJSONException)
        {
          throw new IllegalStateException("Invalid device data", localJSONException);
        }
        localJSONException.put("uuid", this.a.f());
        localJSONException.put("system", this.a.b());
        return localJSONException;
        localJSONException.put("device", this.a.g());
        return localJSONException;
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("uuid", this.a.f());
        localJSONObject2.put("id", this.a.a());
        localJSONObject2.put("system", this.a.b());
        localJSONObject2.put("state", "freed");
        localJSONException.put("device", localJSONObject2);
        return localJSONException;
        localJSONException.put("device", this.a.g());
        return localJSONException;
      }
    }
    
    public RequestMethod c()
    {
      switch (c.1.a[this.b.ordinal()])
      {
      default: 
        throw new IllegalSelectorException();
      case 1: 
        return RequestMethod.GET;
      case 2: 
        return RequestMethod.POST;
      }
      return RequestMethod.PUT;
    }
    
    public c.b o()
    {
      return this.b;
    }
  }
  
  static enum b
  {
    private final int a;
    
    private b(int paramInt)
    {
      this.a = paramInt;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */