package com.inmobi.commons.internal;

import org.json.JSONException;
import org.json.JSONObject;

public class ThinICEConfig
{
  public static final int CELL_OP_FLAGS_DEFAULT = 0;
  public static final boolean ENABLED_DEFAULT = true;
  public static String END_POINT_DEFAULT = "https://et.w.inmobi.com/user/e.asm";
  public static long MAX_RETRY_DEFAULT = 3L;
  public static long RETRY_INTERVAL = 3L;
  public static final boolean SAMPLE_CELL_CONNECTED_WIFI_ENABLED_DEFAULT = true;
  public static final boolean SAMPLE_CELL_ENABLED_DEFAULT = true;
  public static final boolean SAMPLE_CELL_LOCATION_ENABLED_DEFAULT = true;
  public static final boolean SAMPLE_CELL_OPERATOR_ENABLED_DEFAULT = true;
  public static final boolean SAMPLE_CELL_VISIBLE_WIFI_ENABLED_DEFAULT = true;
  public static final int SAMPLE_HISTORY_SIZE_DEFAULT = 50;
  public static final long SAMPLE_INTERVAL_DEFAULT = 60L;
  public static final long STOP_REQUEST_TIMEOUT_DEFAULT = 3L;
  public static final int WIFI_FLAGS_DEFAULT = 0;
  long a = 60L;
  long b = 3L;
  long c = RETRY_INTERVAL;
  long d = MAX_RETRY_DEFAULT;
  int e = 50;
  int f = 0;
  int g = 0;
  boolean h = true;
  boolean i = true;
  boolean j = true;
  boolean k = true;
  boolean l = true;
  boolean m = true;
  String n = END_POINT_DEFAULT;
  
  public ThinICEConfig()
  {
    a(new JSONObject());
  }
  
  public ThinICEConfig(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  void a(JSONObject paramJSONObject)
  {
    this.a = InternalSDKUtil.getLongFromJSON(paramJSONObject, "si", this.a, 1L, Long.MAX_VALUE);
    this.b = InternalSDKUtil.getLongFromJSON(paramJSONObject, "srt", this.b, 1L, Long.MAX_VALUE);
    this.e = InternalSDKUtil.getIntFromJSON(paramJSONObject, "shs", this.e, 1, Integer.MAX_VALUE);
    this.f = InternalSDKUtil.getIntFromJSON(paramJSONObject, "shs", this.f, 0, 15);
    this.g = InternalSDKUtil.getIntFromJSON(paramJSONObject, "cof", this.g, 0, 15);
    this.h = InternalSDKUtil.getBooleanFromJSON(paramJSONObject, "e", this.h);
    this.k = InternalSDKUtil.getBooleanFromJSON(paramJSONObject, "sccw", this.k);
    this.j = InternalSDKUtil.getBooleanFromJSON(paramJSONObject, "sced", this.j);
    this.m = InternalSDKUtil.getBooleanFromJSON(paramJSONObject, "scle", this.m);
    this.i = InternalSDKUtil.getBooleanFromJSON(paramJSONObject, "scoe", this.i);
    this.l = InternalSDKUtil.getBooleanFromJSON(paramJSONObject, "scvw", this.l);
    this.n = InternalSDKUtil.getStringFromJSON(paramJSONObject, "ep", this.n);
    this.d = InternalSDKUtil.getLongFromJSON(paramJSONObject, "mr", this.d, 0L, Long.MAX_VALUE);
    this.c = InternalSDKUtil.getLongFromJSON(paramJSONObject, "ri", this.c, 1L, Long.MAX_VALUE);
  }
  
  public int getCellOpsFlag()
  {
    return this.g;
  }
  
  public long getMaxRetry()
  {
    return this.d;
  }
  
  public long getRetryInterval()
  {
    return this.c;
  }
  
  public int getSampleHistorySize()
  {
    return this.e;
  }
  
  public long getSampleInterval()
  {
    return this.a;
  }
  
  public long getStopRequestTimeout()
  {
    return this.b;
  }
  
  public int getWifiFlags()
  {
    return this.f;
  }
  
  public boolean isCellEnabled()
  {
    return this.j;
  }
  
  public boolean isConnectedWifiEnabled()
  {
    return this.k;
  }
  
  public boolean isEnabled()
  {
    return this.h;
  }
  
  public boolean isLocationEnabled()
  {
    return this.m;
  }
  
  public boolean isOperatorEnabled()
  {
    return this.i;
  }
  
  public boolean isVisibleWifiEnabled()
  {
    return this.l;
  }
  
  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("si", this.a);
    localJSONObject.put("srt", this.b);
    localJSONObject.put("shs", this.e);
    localJSONObject.put("wfd", this.f);
    localJSONObject.put("cof", this.g);
    localJSONObject.put("e", this.h);
    localJSONObject.put("sccw", this.k);
    localJSONObject.put("sced", this.j);
    localJSONObject.put("scle", this.m);
    localJSONObject.put("scoe", this.i);
    localJSONObject.put("scvw", this.l);
    localJSONObject.put("ep", this.n);
    localJSONObject.put("mr", this.d);
    localJSONObject.put("ri", this.c);
    return localJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/internal/ThinICEConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */