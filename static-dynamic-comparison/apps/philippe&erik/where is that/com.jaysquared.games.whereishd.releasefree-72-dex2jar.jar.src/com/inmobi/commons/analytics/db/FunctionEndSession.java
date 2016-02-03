package com.inmobi.commons.analytics.db;

import android.content.Context;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import java.util.Map;

public class FunctionEndSession
  extends AnalyticsFunctions
{
  private Context a;
  private Map<String, String> b;
  
  public FunctionEndSession(Context paramContext, Map<String, String> paramMap)
  {
    this.a = paramContext;
    this.b = paramMap;
  }
  
  private AnalyticsEvent a()
  {
    if (SessionInfo.getSessionId(this.a) != null)
    {
      AnalyticsEvent localAnalyticsEvent = new AnalyticsEvent("es");
      localAnalyticsEvent.setEventSessionId(SessionInfo.getSessionId(this.a));
      localAnalyticsEvent.setEventSessionTimeStamp(SessionInfo.getSessionTime(this.a));
      localAnalyticsEvent.setEventTimeStamp(System.currentTimeMillis() / 1000L);
      SessionInfo.removeSessionId(this.a);
      if (this.b != null) {
        localAnalyticsEvent.setEventAttributeMap(AnalyticsUtils.convertToJSON(this.b));
      }
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/db/FunctionEndSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */