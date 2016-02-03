package com.magmamobile.mmusia.parser;

import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils
{
  private static final boolean verboseLog = false;
  
  public static Date getJSDate(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    return getJSDate(paramJSONObject, paramString, new Date());
  }
  
  public static Date getJSDate(JSONObject paramJSONObject, String paramString, Date paramDate)
    throws JSONException
  {
    if (paramJSONObject.has(paramString)) {
      paramDate = new Date(Date.parse(paramJSONObject.getString(paramString)));
    }
    return paramDate;
  }
  
  public static double getJSDouble(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    return getJSDouble(paramJSONObject, paramString, 0.0D);
  }
  
  public static double getJSDouble(JSONObject paramJSONObject, String paramString, double paramDouble)
    throws JSONException
  {
    if (paramJSONObject.has(paramString)) {
      paramDouble = paramJSONObject.getDouble(paramString);
    }
    return paramDouble;
  }
  
  public static int getJSInt(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    return getJSInt(paramJSONObject, paramString, 0);
  }
  
  public static int getJSInt(JSONObject paramJSONObject, String paramString, int paramInt)
    throws JSONException
  {
    if (paramJSONObject.has(paramString)) {
      paramInt = paramJSONObject.getInt(paramString);
    }
    return paramInt;
  }
  
  public static long getJSLong(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    return getJSLong(paramJSONObject, paramString, 0L);
  }
  
  public static long getJSLong(JSONObject paramJSONObject, String paramString, long paramLong)
    throws JSONException
  {
    if (paramJSONObject.has(paramString)) {
      paramLong = paramJSONObject.getLong(paramString);
    }
    return paramLong;
  }
  
  public static String getJSString(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    return getJSString(paramJSONObject, paramString, "");
  }
  
  public static String getJSString(JSONObject paramJSONObject, String paramString1, String paramString2)
    throws JSONException
  {
    if (paramJSONObject.has(paramString1)) {
      paramString2 = paramJSONObject.getString(paramString1);
    }
    return paramString2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/parser/JsonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */