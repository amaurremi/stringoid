package com.inmobi.androidsdk.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class IMAIConfigParams
{
  int a = 3;
  int b = 10;
  int c = 120;
  
  public IMAIConfigParams()
  {
    setFromJSON(new JSONObject());
  }
  
  public int getMaxRetry()
  {
    return this.a;
  }
  
  public int getPingTimeOut()
  {
    return this.c * 1000;
  }
  
  public int getRetryInterval()
  {
    return this.b * 1000;
  }
  
  public void setFromJSON(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.a = InternalSDKUtil.getIntFromJSON(paramJSONObject, "mr", this.a, 0, Integer.MAX_VALUE);
    this.b = InternalSDKUtil.getIntFromJSON(paramJSONObject, "pint", this.b, 1, Integer.MAX_VALUE);
    this.c = InternalSDKUtil.getIntFromJSON(paramJSONObject, "pto", this.c, 1, Integer.MAX_VALUE);
  }
  
  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("mr", this.a);
    localJSONObject.put("mr", this.b);
    return localJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/bootstrapper/IMAIConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */