package com.inmobi.commons.analytics.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class ThinICEConfig
{
  public static final int CELL_OP_FLAGS_DEFAULT = 0;
  public static final boolean ENABLED_DEFAULT = true;
  public static final String END_POINT_DEFAULT = "";
  public static final long MAX_RETRY_DEFAULT = 3L;
  public static final long RETRY_INTERVAL = 3L;
  public static final boolean SAMPLE_CELL_CONNECTED_WIFI_ENABLED_DEFAULT = true;
  public static final boolean SAMPLE_CELL_ENABLED_DEFAULT = true;
  public static final boolean SAMPLE_CELL_OPERATOR_ENABLED_DEFAULT = true;
  public static final boolean SAMPLE_CELL_VISIBLE_WIFI_ENABLED_DEFAULT = true;
  public static final int SAMPLE_HISTORY_SIZE_DEFAULT = 50;
  public static final long SAMPLE_INTERVAL_DEFAULT = 60L;
  public static final long STOP_REQUEST_TIMEOUT_DEFAULT = 3L;
  public static final int WIFI_FLAGS_DEFAULT = 0;
  private long a = 60L;
  private long b = 3L;
  private long c = 3L;
  private long d = 3L;
  private int e = 50;
  private int f = 0;
  private int g = 0;
  private String h = "";
  private boolean i = true;
  private boolean j = true;
  private boolean k = true;
  private boolean l = true;
  private boolean m = true;
  private boolean n = false;
  private long o = 86400L;
  private boolean p = false;
  private long q = 180L;
  private long r = 50L;
  
  public long getActivityDetectionInterval()
  {
    return this.q * 1000L;
  }
  
  public long getActivityDetectionMaxSize()
  {
    return this.r;
  }
  
  public long getAppDetectionInterval()
  {
    return this.o * 1000L;
  }
  
  public int getCellOpsFlag()
  {
    return this.g;
  }
  
  public String getEndpointUrl()
  {
    return this.h;
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
  
  public boolean isActivityDetectionEnabled()
  {
    return this.p;
  }
  
  public boolean isAppDetectionEnabled()
  {
    return this.n;
  }
  
  public boolean isCellEnabled()
  {
    return this.k;
  }
  
  public boolean isConnectedWifiEnabled()
  {
    return this.l;
  }
  
  public boolean isEnabled()
  {
    return this.i;
  }
  
  public boolean isOperatorEnabled()
  {
    return this.j;
  }
  
  public boolean isVisibleWifiEnabled()
  {
    return this.m;
  }
  
  public final void setFromMap(Map<String, Object> paramMap)
  {
    this.a = InternalSDKUtil.getLongFromMap(paramMap, "si", 1L, Long.MAX_VALUE);
    this.b = InternalSDKUtil.getLongFromMap(paramMap, "srt", 1L, Long.MAX_VALUE);
    this.e = InternalSDKUtil.getIntFromMap(paramMap, "shs", 1, 2147483647L);
    this.f = InternalSDKUtil.getIntFromMap(paramMap, "wfd", 0, 15L);
    this.g = InternalSDKUtil.getIntFromMap(paramMap, "cof", 0, 15L);
    this.i = InternalSDKUtil.getBooleanFromMap(paramMap, "e");
    this.l = InternalSDKUtil.getBooleanFromMap(paramMap, "sccw");
    this.k = InternalSDKUtil.getBooleanFromMap(paramMap, "sced");
    this.j = InternalSDKUtil.getBooleanFromMap(paramMap, "scoe");
    this.m = InternalSDKUtil.getBooleanFromMap(paramMap, "scvw");
    this.h = InternalSDKUtil.getStringFromMap(paramMap, "ep");
    this.d = InternalSDKUtil.getLongFromMap(paramMap, "mr", 0L, Long.MAX_VALUE);
    this.c = InternalSDKUtil.getLongFromMap(paramMap, "ri", 1L, Long.MAX_VALUE);
    this.n = InternalSDKUtil.getBooleanFromMap(paramMap, "ao");
    this.o = InternalSDKUtil.getLongFromMap(paramMap, "aoi", 1L, Long.MAX_VALUE);
    this.p = InternalSDKUtil.getBooleanFromMap(paramMap, "as");
    this.q = InternalSDKUtil.getLongFromMap(paramMap, "assi", 1L, Long.MAX_VALUE);
    this.r = InternalSDKUtil.getLongFromMap(paramMap, "asm", 1L, Long.MAX_VALUE);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/bootstrapper/ThinICEConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */