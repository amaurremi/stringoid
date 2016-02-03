package com.inmobi.commons.analytics.db;

import android.content.Context;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;

import java.util.Map;

public class FunctionLevelBegin
        extends AnalyticsFunctions {
    private Context a;
    private Map<String, String> b;
    private int c;
    private String d;

    public FunctionLevelBegin(Context paramContext, int paramInt, String paramString, Map<String, String> paramMap) {
        this.a = paramContext;
        this.b = paramMap;
        this.c = paramInt;
        this.d = paramString;
    }

    private AnalyticsEvent a() {
        if (SessionInfo.getSessionId(this.a) != null) {
            AnalyticsEvent localAnalyticsEvent = new AnalyticsEvent("lb");
            localAnalyticsEvent.setEventLevelId(Integer.toString(this.c));
            localAnalyticsEvent.setEventLevelName(this.d);
            if (this.b != null) {
                localAnalyticsEvent.setEventAttributeMap(AnalyticsUtils.convertToJSON(this.b));
            }
            localAnalyticsEvent.setEventSessionId(SessionInfo.getSessionId(this.a));
            localAnalyticsEvent.setEventSessionTimeStamp(SessionInfo.getSessionTime(this.a));
            localAnalyticsEvent.setEventTimeStamp(System.currentTimeMillis() / 1000L);
            insertInDatabase(localAnalyticsEvent);
            return localAnalyticsEvent;
        }
        return null;
    }

    protected Map<String, String> getLbMap() {
        return this.b;
    }

    protected int getLevelId() {
        return this.c;
    }

    protected String getLevelName() {
        return this.d;
    }

    public AnalyticsEvent processFunction() {
        return a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/db/FunctionLevelBegin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */