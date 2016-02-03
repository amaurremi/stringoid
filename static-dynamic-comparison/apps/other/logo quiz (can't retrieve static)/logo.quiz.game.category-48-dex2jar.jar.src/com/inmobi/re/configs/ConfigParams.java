package com.inmobi.re.configs;

import android.graphics.Color;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigParams
{
  UID a = new UID();
  String b = "#00000000";
  int c = 320;
  int d = 480;
  int e = 100;
  
  public ConfigParams()
  {
    setFromJSON(new JSONObject());
  }
  
  public int getPicHeight()
  {
    return this.d;
  }
  
  public int getPicQuality()
  {
    return this.e;
  }
  
  public int getPicWidth()
  {
    return this.c;
  }
  
  public UID getUID()
  {
    return this.a;
  }
  
  public int getWebviewBgColor()
  {
    try
    {
      int i = Color.parseColor(this.b);
      return i;
    }
    catch (Exception localException)
    {
      Log.internal("IMRE_3.7.1", "Invalid bg color. Reverting to default", localException);
    }
    return Color.parseColor("#00000000");
  }
  
  public void setFromJSON(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      this.b = InternalSDKUtil.getStringFromJSON(paramJSONObject, "wthc", "#00000000");
      this.d = InternalSDKUtil.getIntFromJSON(paramJSONObject, "picH", 480, 1, Integer.MAX_VALUE);
      this.c = InternalSDKUtil.getIntFromJSON(paramJSONObject, "picW", 320, 1, Integer.MAX_VALUE);
      this.e = InternalSDKUtil.getIntFromJSON(paramJSONObject, "picA", 100, 1, 100);
      paramJSONObject = paramJSONObject.getJSONObject("ids");
      this.a.setFromJSON(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.debug("IMRE_3.7.1", "Unable to read UID configs");
    }
  }
  
  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = this.a.toJSON();
    localJSONObject1.put("wthc", this.b);
    localJSONObject1.put("ids", localJSONObject2);
    return localJSONObject1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/re/configs/ConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */