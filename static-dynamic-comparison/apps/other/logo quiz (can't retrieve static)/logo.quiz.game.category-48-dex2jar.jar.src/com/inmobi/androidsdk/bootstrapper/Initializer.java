package com.inmobi.androidsdk.bootstrapper;

import android.content.Context;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.CacheController.Validator;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.internal.CommonsException;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UIDUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Initializer
{
  public static final String PRODUCT_ADNETWORK = "adNetwork";
  private static Context a = null;
  private static JSONObject b = null;
  private static Map<String, String> c = new HashMap();
  private static ConfigParams d = new ConfigParams();
  private static CacheController.Validator e = new a();
  
  private static void a(Context paramContext)
  {
    if ((paramContext != null) && (a == null)) {
      if (a == null) {}
    }
    while ((a != null) || (paramContext != null))
    {
      return;
      a = paramContext.getApplicationContext();
      c = getUidMap(paramContext);
      try
      {
        b(CacheController.getConfig("adNetwork", paramContext, c, e).getData());
        return;
      }
      catch (CommonsException paramContext)
      {
        return;
      }
    }
    throw new NullPointerException();
  }
  
  private static String b(String paramString)
  {
    c = getUidMap(a);
    try
    {
      JSONObject localJSONObject3 = new JSONObject(paramString);
      try
      {
        paramString = localJSONObject3.getJSONObject("common");
      }
      catch (Exception paramString)
      {
        try
        {
          for (;;)
          {
            JSONObject localJSONObject1 = localJSONObject3.getJSONObject("AND");
            b = InternalSDKUtil.populateToNewJSON(localJSONObject1, paramString, true);
            d.setFromJSON(b);
            try
            {
              localJSONObject3.put("AND", d.toJSON());
              paramString = localJSONObject3.toString();
              return paramString;
            }
            catch (JSONException paramString)
            {
              JSONObject localJSONObject2;
              for (;;) {}
            }
            paramString = paramString;
            paramString = new JSONObject();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localJSONObject2 = new JSONObject();
          }
        }
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.debug("InMobiAndroidSDK_3.7.1", "Config couldn't be parsed", paramString);
    }
  }
  
  private static void b(Context paramContext)
  {
    a(paramContext);
    try
    {
      CacheController.getConfig("adNetwork", paramContext, c, e);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static ConfigParams getConfigParams(Context paramContext)
  {
    b(paramContext);
    return d;
  }
  
  public static Map<String, String> getUidMap(Context paramContext)
  {
    return UIDUtil.getMap(a, d.getUID());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/bootstrapper/Initializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */