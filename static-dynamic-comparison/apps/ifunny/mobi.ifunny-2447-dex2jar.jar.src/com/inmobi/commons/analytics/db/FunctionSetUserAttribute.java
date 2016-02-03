package com.inmobi.commons.analytics.db;

import android.content.Context;
import com.inmobi.commons.analytics.util.SessionInfo;

public class FunctionSetUserAttribute
        extends AnalyticsFunctions {
    private Context a;
    private String b;
    private String c;

    public FunctionSetUserAttribute(Context paramContext, String paramString1, String paramString2) {
        this.a = paramContext;
        this.b = paramString1;
        this.c = paramString2;
    }

    private AnalyticsEvent a() {
        if ((SessionInfo.getSessionId(this.a) != null) && (this.b != null) && (this.c != null) && (!"".equals(this.b.trim())) && (!"".equals(this.c.trim()))) {
            AnalyticsEvent localAnalyticsEvent = new AnalyticsEvent("ae");
            localAnalyticsEvent.setUserAttribute(this.b, this.c);
            localAnalyticsEvent.setEventSessionId(SessionInfo.getSessionId(this.a));
            localAnalyticsEvent.setEventSessionTimeStamp(SessionInfo.getSessionTime(this.a));
            localAnalyticsEvent.setEventTimeStamp(System.currentTimeMillis() / 1000L);
            insertInDatabase(localAnalyticsEvent);
            return localAnalyticsEvent;
        }
        printWarning("Please call startSession before calling track User Attribute");
        return null;
    }

    public AnalyticsEvent processFunction() {
        return a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/db/FunctionSetUserAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */