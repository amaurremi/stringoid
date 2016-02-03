package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.model.Game;
import com.scoreloop.client.android.core.model.Payment;
import com.scoreloop.client.android.core.model.Payment.State;
import com.scoreloop.client.android.core.model.PaymentCredential;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.User;
import com.scoreloop.client.android.core.server.Request;
import com.scoreloop.client.android.core.server.RequestCompletionCallback;
import com.scoreloop.client.android.core.server.RequestMethod;
import com.scoreloop.client.android.core.server.Response;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentController
  extends RequestController
{
  private PaymentCredential b;
  private Payment c;
  private boolean d;
  
  public PaymentController(Session paramSession, RequestControllerObserver paramRequestControllerObserver)
  {
    super(paramSession, paramRequestControllerObserver);
  }
  
  private void j()
  {
    b localb = new b(c(), a(), e(), this.b, null, this.c.a());
    h();
    a(localb);
  }
  
  boolean a(Request paramRequest, Response paramResponse)
    throws Exception
  {
    if (paramResponse.f() == 200)
    {
      paramResponse = new Payment(paramResponse.e().getJSONObject(Payment.c()));
      switch (1.a[((a)paramRequest).p().ordinal()])
      {
      default: 
        throw new IllegalStateException("Invalid request type");
      case 1: 
        if (this.c.b() != Payment.State.CREATED) {
          throw new IllegalStateException("Payment state should be CREATED");
        }
        break;
      case 2: 
        if (this.c.b() != Payment.State.BOOKED) {
          throw new IllegalStateException("Payment state should be BOOKED");
        }
        break;
      }
      this.c = paramResponse;
    }
    for (int i = 1;; i = 0)
    {
      if (this.d)
      {
        this.d = false;
        if (i != 0) {
          j();
        }
        return false;
      }
      return true;
    }
  }
  
  boolean g()
  {
    return true;
  }
  
  protected void h()
  {
    this.d = false;
    super.h();
  }
  
  private abstract class a
    extends Request
  {
    protected final Game a;
    protected final User b;
    protected final PaymentCredential c;
    protected final JSONObject e;
    
    public a(RequestCompletionCallback paramRequestCompletionCallback, Game paramGame, User paramUser, PaymentCredential paramPaymentCredential, JSONObject paramJSONObject)
    {
      super();
      this.a = paramGame;
      this.b = paramUser;
      this.c = paramPaymentCredential;
      this.e = paramJSONObject;
    }
    
    public JSONObject b()
    {
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        JSONObject localJSONObject2 = o();
        if (this.e != null)
        {
          Iterator localIterator = this.e.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject2.put(str, this.e.get(str));
          }
        }
        localJSONException.put("payment", localJSONObject2);
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalStateException("Invalid payment data", localJSONException);
      }
      return localJSONException;
    }
    
    protected abstract JSONObject o();
    
    protected abstract PaymentController.c p();
  }
  
  private class b
    extends PaymentController.a
  {
    protected final String g;
    
    public b(RequestCompletionCallback paramRequestCompletionCallback, Game paramGame, User paramUser, PaymentCredential paramPaymentCredential, JSONObject paramJSONObject, String paramString)
    {
      super(paramRequestCompletionCallback, paramGame, paramUser, paramPaymentCredential, paramJSONObject);
      this.g = paramString;
    }
    
    public String a()
    {
      return String.format("/service/games/%s/users/%s/payments/%s", new Object[] { this.a.getIdentifier(), this.b.getIdentifier(), this.g });
    }
    
    public RequestMethod c()
    {
      return RequestMethod.PUT;
    }
    
    protected JSONObject o()
    {
      return this.c.a();
    }
    
    protected PaymentController.c p()
    {
      return PaymentController.c.SubmitPayment;
    }
  }
  
  private static enum c
  {
    private c() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/PaymentController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */