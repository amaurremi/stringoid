package com.inmobi.commons.analytics.db;

import android.content.Context;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import java.util.Map;

public class FunctionStartSession
  extends AnalyticsFunctions
{
  private Context a;
  private String b;
  private Map<String, String> c;
  
  public FunctionStartSession(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    this.a = paramContext;
    this.b = paramString;
    this.c = paramMap;
  }
  
  private AnalyticsEvent a()
  {
    if (SessionInfo.getSessionId(this.a) == null)
    {
      SessionInfo.storeAppId(this.a, this.b);
      SessionInfo.storeSessionId(this.a);
      SessionInfo.storeFirstTime(this.a);
      AnalyticsEvent localAnalyticsEvent = new AnalyticsEvent("ss");
      if (this.c != null) {
        localAnalyticsEvent.setEventAttributeMap(AnalyticsUtils.convertToJSON(this.c));
      }
      localAnalyticsEvent.setEventSessionId(SessionInfo.getSessionId(this.a));
      localAnalyticsEvent.setEventSessionTimeStamp(SessionInfo.getSessionTime(this.a));
      localAnalyticsEvent.setEventTimeStamp(SessionInfo.getSessionTime(this.a));
      insertInDatabase(localAnalyticsEvent);
      return localAnalyticsEvent;
    }
    return null;
  }
  
  public AnalyticsEvent processFunction()
  {
    return a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/db/FunctionStartSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */