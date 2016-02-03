package com.inmobi.androidsdk.impl.metric;

import com.inmobi.commons.internal.Log;
import org.json.JSONObject;

public class EventLog
{
  private EventType a;
  private JSONObject b;
  
  public EventLog(EventType paramEventType, JSONObject paramJSONObject)
  {
    this.a = paramEventType;
    this.b = paramJSONObject;
  }
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("t", this.a.getValue());
      localJSONObject.put("v", this.b);
      return localJSONObject.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.debug("InMobiAndroidSDK_3.7.1", "Unable to log json.", localException);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/metric/EventLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */