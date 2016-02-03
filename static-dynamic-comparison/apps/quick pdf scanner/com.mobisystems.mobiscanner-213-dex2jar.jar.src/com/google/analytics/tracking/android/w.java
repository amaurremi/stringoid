package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class w
{
  private Map<String, String> map = new HashMap();
  
  public static w a(String paramString, Boolean paramBoolean)
  {
    GAUsage.jU().a(GAUsage.Field.ki);
    w localw = new w();
    localw.a("&t", "exception");
    localw.a("&exd", paramString);
    localw.a("&exf", a(paramBoolean));
    return localw;
  }
  
  static String a(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return null;
    }
    if (paramBoolean.booleanValue()) {
      return "1";
    }
    return "0";
  }
  
  public w E(String paramString)
  {
    GAUsage.jU().a(GAUsage.Field.jE);
    paramString = ah.J(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return this;
    }
    paramString = ah.I(paramString);
    a("&cc", (String)paramString.get("utm_content"));
    a("&cm", (String)paramString.get("utm_medium"));
    a("&cn", (String)paramString.get("utm_campaign"));
    a("&cs", (String)paramString.get("utm_source"));
    a("&ck", (String)paramString.get("utm_term"));
    a("&ci", (String)paramString.get("utm_id"));
    a("&gclid", (String)paramString.get("gclid"));
    a("&dclid", (String)paramString.get("dclid"));
    a("&gmob_t", (String)paramString.get("gmob_t"));
    return this;
  }
  
  public w a(String paramString1, String paramString2)
  {
    GAUsage.jU().a(GAUsage.Field.jB);
    if (paramString1 != null)
    {
      this.map.put(paramString1, paramString2);
      return this;
    }
    v.D(" MapBuilder.set() called with a null paramName.");
    return this;
  }
  
  public Map<String, String> kg()
  {
    return new HashMap(this.map);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */