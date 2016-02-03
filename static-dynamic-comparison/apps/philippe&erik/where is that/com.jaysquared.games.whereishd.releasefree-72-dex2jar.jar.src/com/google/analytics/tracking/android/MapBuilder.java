package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class MapBuilder
{
  private Map<String, String> map = new HashMap();
  
  static String booleanToString(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return null;
    }
    if (paramBoolean.booleanValue()) {
      return "1";
    }
    return "0";
  }
  
  public static MapBuilder createAppView()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_APP_VIEW);
    MapBuilder localMapBuilder = new MapBuilder();
    localMapBuilder.set("&t", "appview");
    return localMapBuilder;
  }
  
  public static MapBuilder createEvent(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_EVENT);
    MapBuilder localMapBuilder = new MapBuilder();
    localMapBuilder.set("&t", "event");
    localMapBuilder.set("&ec", paramString1);
    localMapBuilder.set("&ea", paramString2);
    localMapBuilder.set("&el", paramString3);
    if (paramLong == null) {}
    for (paramString1 = null;; paramString1 = Long.toString(paramLong.longValue()))
    {
      localMapBuilder.set("&ev", paramString1);
      return localMapBuilder;
    }
  }
  
  public static MapBuilder createException(String paramString, Boolean paramBoolean)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_EXCEPTION);
    MapBuilder localMapBuilder = new MapBuilder();
    localMapBuilder.set("&t", "exception");
    localMapBuilder.set("&exd", paramString);
    localMapBuilder.set("&exf", booleanToString(paramBoolean));
    return localMapBuilder;
  }
  
  public static MapBuilder createItem(String paramString1, String paramString2, String paramString3, String paramString4, Double paramDouble, Long paramLong, String paramString5)
  {
    Object localObject = null;
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_ITEM);
    MapBuilder localMapBuilder = new MapBuilder();
    localMapBuilder.set("&t", "item");
    localMapBuilder.set("&ti", paramString1);
    localMapBuilder.set("&ic", paramString3);
    localMapBuilder.set("&in", paramString2);
    localMapBuilder.set("&iv", paramString4);
    if (paramDouble == null)
    {
      paramString1 = null;
      localMapBuilder.set("&ip", paramString1);
      if (paramLong != null) {
        break label125;
      }
    }
    label125:
    for (paramString1 = (String)localObject;; paramString1 = Long.toString(paramLong.longValue()))
    {
      localMapBuilder.set("&iq", paramString1);
      localMapBuilder.set("&cu", paramString5);
      return localMapBuilder;
      paramString1 = Double.toString(paramDouble.doubleValue());
      break;
    }
  }
  
  public static MapBuilder createSocial(String paramString1, String paramString2, String paramString3)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_SOCIAL);
    MapBuilder localMapBuilder = new MapBuilder();
    localMapBuilder.set("&t", "social");
    localMapBuilder.set("&sn", paramString1);
    localMapBuilder.set("&sa", paramString2);
    localMapBuilder.set("&st", paramString3);
    return localMapBuilder;
  }
  
  public static MapBuilder createTiming(String paramString1, Long paramLong, String paramString2, String paramString3)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_TIMING);
    MapBuilder localMapBuilder = new MapBuilder();
    localMapBuilder.set("&t", "timing");
    localMapBuilder.set("&utc", paramString1);
    paramString1 = null;
    if (paramLong != null) {
      paramString1 = Long.toString(paramLong.longValue());
    }
    localMapBuilder.set("&utt", paramString1);
    localMapBuilder.set("&utv", paramString2);
    localMapBuilder.set("&utl", paramString3);
    return localMapBuilder;
  }
  
  public static MapBuilder createTransaction(String paramString1, String paramString2, Double paramDouble1, Double paramDouble2, Double paramDouble3, String paramString3)
  {
    Object localObject = null;
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_TRANSACTION);
    MapBuilder localMapBuilder = new MapBuilder();
    localMapBuilder.set("&t", "transaction");
    localMapBuilder.set("&ti", paramString1);
    localMapBuilder.set("&ta", paramString2);
    if (paramDouble1 == null)
    {
      paramString1 = null;
      localMapBuilder.set("&tr", paramString1);
      if (paramDouble2 != null) {
        break label120;
      }
      paramString1 = null;
      label70:
      localMapBuilder.set("&tt", paramString1);
      if (paramDouble3 != null) {
        break label131;
      }
    }
    label120:
    label131:
    for (paramString1 = (String)localObject;; paramString1 = Double.toString(paramDouble3.doubleValue()))
    {
      localMapBuilder.set("&ts", paramString1);
      localMapBuilder.set("&cu", paramString3);
      return localMapBuilder;
      paramString1 = Double.toString(paramDouble1.doubleValue());
      break;
      paramString1 = Double.toString(paramDouble2.doubleValue());
      break label70;
    }
  }
  
  public Map<String, String> build()
  {
    return new HashMap(this.map);
  }
  
  public String get(String paramString)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_GET);
    return (String)this.map.get(paramString);
  }
  
  public MapBuilder set(String paramString1, String paramString2)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_SET);
    if (paramString1 != null)
    {
      this.map.put(paramString1, paramString2);
      return this;
    }
    Log.w(" MapBuilder.set() called with a null paramName.");
    return this;
  }
  
  public MapBuilder setAll(Map<String, String> paramMap)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_SET_ALL);
    if (paramMap == null) {
      return this;
    }
    this.map.putAll(new HashMap(paramMap));
    return this;
  }
  
  public MapBuilder setCampaignParamsFromUrl(String paramString)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
    paramString = Utils.filterCampaign(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return this;
    }
    paramString = Utils.parseURLParameters(paramString);
    set("&cc", (String)paramString.get("utm_content"));
    set("&cm", (String)paramString.get("utm_medium"));
    set("&cn", (String)paramString.get("utm_campaign"));
    set("&cs", (String)paramString.get("utm_source"));
    set("&ck", (String)paramString.get("utm_term"));
    set("&ci", (String)paramString.get("utm_id"));
    set("&gclid", (String)paramString.get("gclid"));
    set("&dclid", (String)paramString.get("dclid"));
    set("&gmob_t", (String)paramString.get("gmob_t"));
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/analytics/tracking/android/MapBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */