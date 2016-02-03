package com.inmobi.commons.analytics.db;

import android.content.Context;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;

import java.util.Map;

public class FunctionTagEvent
        extends AnalyticsFunctions {
    private Context a;
    private String b;
    private Map<String, String> c;

    public FunctionTagEvent(Context paramContext, String paramString, Map<String, String> paramMap) {
        this.a = paramContext;
        this.b = paramString;
        this.c = paramMap;
    }

    private AnalyticsEvent a() {
        if (SessionInfo.getSessionId(this.a) != null) {
            AnalyticsEvent localAnalyticsEvent = new AnalyticsEvent("ce");
            localAnalyticsEvent.setEventCustomName(this.b);
            if (this.c != null) {
                localAnalyticsEvent.setEventAttributeMap(AnalyticsUtils.convertToJSON(this.c));
            }
            localAnalyticsEvent.setEventSessionId(SessionInfo.getSessionId(this.a));
            localAnalyticsEvent.setEventSessionTimeStamp(SessionInfo.getSessionTime(this.a));
            localAnalyticsEvent.setEventTimeStamp(System.currentTimeMillis() / 1000L);
            insertInDatabase(localAnalyticsEvent);
            return localAnalyticsEvent;
        }
        printWarning("Please call startSession before calling trackEvent");
        return null;
    }

    public AnalyticsEvent processFunction() {
        return a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/db/FunctionTagEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */