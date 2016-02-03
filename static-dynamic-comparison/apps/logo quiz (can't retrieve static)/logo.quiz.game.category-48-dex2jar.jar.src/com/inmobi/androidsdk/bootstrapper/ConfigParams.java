package com.inmobi.androidsdk.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigParams
{
  int a = 20;
  int b = 60;
  int c = 60;
  int d = 60;
  String e = "#00000000";
  IMAIConfigParams f = new IMAIConfigParams();
  MetricConfigParams g = new MetricConfigParams();
  UID h = new UID();
  AppGalleryConfigParams i = new AppGalleryConfigParams();
  
  public ConfigParams()
  {
    this(null);
  }
  
  public ConfigParams(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      setFromJSON(paramJSONObject);
      return;
    }
    setFromJSON(new JSONObject());
  }
  
  public AppGalleryConfigParams getAppAppGalleryConfigParams()
  {
    return this.i;
  }
  
  public int getDefaultRefreshRate()
  {
    return this.b;
  }
  
  public int getFetchTimeOut()
  {
    return this.c * 1000;
  }
  
  public IMAIConfigParams getImai()
  {
    return this.f;
  }
  
  public MetricConfigParams getMetric()
  {
    return this.g;
  }
  
  public int getMinimumRefreshRate()
  {
    return this.a;
  }
  
  public int getRenderTimeOut()
  {
    return this.d * 1000;
  }
  
  public UID getUID()
  {
    return this.h;
  }
  
  public String getWebviewBgColor()
  {
    return this.e;
  }
  
  public void setFromJSON(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.a = InternalSDKUtil.getIntFromJSON(paramJSONObject, "mrr", this.a, 1, Integer.MAX_VALUE);
    this.b = InternalSDKUtil.getIntFromJSON(paramJSONObject, "drr", this.b, 1, Integer.MAX_VALUE);
    this.c = InternalSDKUtil.getIntFromJSON(paramJSONObject, "fto", this.c, 1, Integer.MAX_VALUE);
    this.d = InternalSDKUtil.getIntFromJSON(paramJSONObject, "rto", this.d, 1, Integer.MAX_VALUE);
    this.e = InternalSDKUtil.getStringFromJSON(paramJSONObject, "wthc", this.e);
    try
    {
      localJSONObject = paramJSONObject.getJSONObject("imai");
      this.f.setFromJSON(localJSONObject);
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        localJSONObject = paramJSONObject.getJSONObject("metric");
        this.g.setFromJSON(localJSONObject);
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          for (;;)
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject("ag");
            this.i.setFromJSON(localJSONObject);
            try
            {
              paramJSONObject = paramJSONObject.getJSONObject("ids");
              this.h.setFromJSON(paramJSONObject);
              return;
            }
            catch (JSONException paramJSONObject)
            {
              Log.debug("InMobiAndroidSDK_3.7.1", "Unable to read UID configs");
              return;
            }
            localJSONException1 = localJSONException1;
            Log.debug("InMobiAndroidSDK_3.7.1", "Unable to read IMAI configs");
            continue;
            localJSONException2 = localJSONException2;
            Log.debug("InMobiAndroidSDK_3.7.1", "Unable to read metrics configs");
          }
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            Log.debug("InMobiAndroidSDK_3.7.1", "Unable to read app gallery configs");
          }
        }
      }
    }
  }
  
  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("mrr", this.a);
    localJSONObject.put("fto", this.c);
    localJSONObject.put("drr", this.b);
    localJSONObject.put("rto", this.d);
    localJSONObject.put("wthc", this.e);
    localJSONObject.put("ids", this.h.toJSON());
    localJSONObject.put("ag", this.i.toJSON());
    localJSONObject.put("imai", this.f.toJSON());
    localJSONObject.put("metric", this.g.toJSON());
    return localJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/bootstrapper/ConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */