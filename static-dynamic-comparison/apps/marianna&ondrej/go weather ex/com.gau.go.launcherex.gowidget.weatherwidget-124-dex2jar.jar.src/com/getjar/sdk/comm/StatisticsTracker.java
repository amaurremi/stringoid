package com.getjar.sdk.comm;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

public class StatisticsTracker
{
  private static ConcurrentHashMap<String, Integer> _SessionRequestCounts = new ConcurrentHashMap();
  private static long _Start = ;
  
  public static void dumpAllStatsToLogCat(Context paramContext) {}
  
  private static void dumpSessionRatesToLogCat() {}
  
  public static void logRequest(Operation paramOperation) {}
  
  public static void logResponse(Operation paramOperation) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/StatisticsTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */