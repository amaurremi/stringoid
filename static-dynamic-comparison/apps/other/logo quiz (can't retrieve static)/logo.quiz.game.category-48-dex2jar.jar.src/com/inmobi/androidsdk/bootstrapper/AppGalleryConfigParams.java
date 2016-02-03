package com.inmobi.androidsdk.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class AppGalleryConfigParams
{
  String a = "http://inmobi.appgalleries.com/inmobi_sdk";
  
  public AppGalleryConfigParams()
  {
    setFromJSON(new JSONObject());
  }
  
  public String getUrl()
  {
    return this.a;
  }
  
  public void setFromJSON(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.a = InternalSDKUtil.getStringFromJSON(paramJSONObject, "url", this.a);
  }
  
  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("url", this.a);
    return localJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/bootstrapper/AppGalleryConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */