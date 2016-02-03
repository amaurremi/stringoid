package com.parse;

import android.app.Service;
import org.json.JSONObject;

public abstract class PushCallback
  implements Runnable
{
  protected String channel;
  protected JSONObject localData;
  protected JSONObject pushData;
  protected Service service;
  
  public void setChannel(String paramString)
  {
    this.channel = paramString;
  }
  
  public void setLocalData(JSONObject paramJSONObject)
  {
    this.localData = paramJSONObject;
  }
  
  public void setPushData(JSONObject paramJSONObject)
  {
    this.pushData = paramJSONObject;
  }
  
  public void setService(Service paramService)
  {
    this.service = paramService;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/PushCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */