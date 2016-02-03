package com.scoreloop.client.android.core.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Payment
{
  private String a;
  private Money b;
  private State c;
  
  public Payment(JSONObject paramJSONObject)
    throws JSONException
  {
    a(paramJSONObject);
  }
  
  public static String c()
  {
    return "payment";
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("id")) {
      this.a = paramJSONObject.getString("id");
    }
    if (paramJSONObject.has("credit_money")) {
      this.b.a(paramJSONObject.getJSONObject("credit_money"));
    }
    if (paramJSONObject.has("state")) {}
  }
  
  public State b()
  {
    return this.c;
  }
  
  public static enum State
  {
    private State() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/Payment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */