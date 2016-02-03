package com.inmobi.androidsdk.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class MetricConfigParams
{
  int a = 432000;
  int b = 1000;
  int c = 1000;
  int d = 10;
  String e = "";
  boolean f = false;
  
  public MetricConfigParams()
  {
    setFromJSON(new JSONObject());
  }
  
  public int getDumpThreshhold()
  {
    return this.d;
  }
  
  public int getMaxInQueue()
  {
    return this.b;
  }
  
  public int getNextRetryInterval()
  {
    return this.a;
  }
  
  public int getSamplingFactor()
  {
    return this.c;
  }
  
  public String getUrl()
  {
    return this.e;
  }
  
  public boolean isEnabled()
  {
    return this.f;
  }
  
  public void setFromJSON(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.c = InternalSDKUtil.getIntFromJSON(paramJSONObject, "sf", this.c, 1, Integer.MAX_VALUE);
    this.d = InternalSDKUtil.getIntFromJSON(paramJSONObject, "dt", this.d, 1, Integer.MAX_VALUE);
    this.b = InternalSDKUtil.getIntFromJSON(paramJSONObject, "max", this.b, 1, Integer.MAX_VALUE);
    this.a = InternalSDKUtil.getIntFromJSON(paramJSONObject, "nri", this.a, 1, Integer.MAX_VALUE);
    this.e = InternalSDKUtil.getStringFromJSON(paramJSONObject, "url", this.e);
    this.f = InternalSDKUtil.getBooleanFromJSON(paramJSONObject, "e", this.f);
  }
  
  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("dt", this.d);
    localJSONObject.put("max", this.b);
    localJSONObject.put("nri", this.a);
    localJSONObject.put("sf", this.c);
    localJSONObject.put("url", this.e);
    return localJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/bootstrapper/MetricConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */