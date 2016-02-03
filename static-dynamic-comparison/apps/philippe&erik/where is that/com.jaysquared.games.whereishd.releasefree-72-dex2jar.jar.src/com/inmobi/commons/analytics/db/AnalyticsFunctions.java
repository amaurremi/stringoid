package com.inmobi.commons.analytics.db;

import android.util.Log;

public abstract class AnalyticsFunctions
{
  private FunctionName a = null;
  
  public FunctionName getFunctionName()
  {
    return this.a;
  }
  
  protected void insertInDatabase(AnalyticsEvent paramAnalyticsEvent)
  {
    try
    {
      AnalyticsDatabaseManager.getInstance().insertEvents(paramAnalyticsEvent);
      return;
    }
    catch (Exception paramAnalyticsEvent)
    {
      Log.w("[InMobi]-[Analytics]-4.1.1", paramAnalyticsEvent);
    }
  }
  
  protected void printWarning(String paramString)
  {
    Log.d("[InMobi]-[Analytics]-4.1.1", "IllegalStateException", new IllegalStateException(paramString));
  }
  
  public abstract AnalyticsEvent processFunction();
  
  public static enum FunctionName
  {
    static
    {
      ES = new FunctionName("ES", 1);
      LB = new FunctionName("LB", 2);
      LE = new FunctionName("LE", 3);
    }
    
    private FunctionName() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/db/AnalyticsFunctions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */