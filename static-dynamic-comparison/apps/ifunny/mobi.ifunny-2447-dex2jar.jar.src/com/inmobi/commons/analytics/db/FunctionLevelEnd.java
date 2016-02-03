package com.inmobi.commons.analytics.db;

import android.content.Context;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMSectionStatus;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;

import java.util.Map;

public class FunctionLevelEnd
        extends FunctionLevelBegin {
    private AnalyticsEventsWrapper.IMSectionStatus a;
    private Context b;

    public FunctionLevelEnd(Context paramContext, int paramInt, String paramString, AnalyticsEventsWrapper.IMSectionStatus paramIMSectionStatus, Map<String, String> paramMap) {
        super(paramContext, paramInt, paramString, paramMap);
        this.b = paramContext;
        this.a = paramIMSectionStatus;
    }

    private AnalyticsEvent a() {
        if (SessionInfo.getSessionId(this.b) != null) {
            AnalyticsEvent localAnalyticsEvent = new AnalyticsEvent("le");
            localAnalyticsEvent.setEventLevelId(Integer.toString(getLevelId()));
            localAnalyticsEvent.setEventLevelName(getLevelName());
            if (getLbMap() != null) {
                localAnalyticsEvent.setEventAttributeMap(AnalyticsUtils.convertToJSON(getLbMap()));
            }
            localAnalyticsEvent.setEventLevelStatus("1");
            localAnalyticsEvent.setEventSessionId(SessionInfo.getSessionId(this.b));
            localAnalyticsEvent.setEventSessionTimeStamp(SessionInfo.getSessionTime(this.b));
            localAnalyticsEvent.setEventTimeStamp(System.currentTimeMillis() / 1000L);
            insertInDatabase(localAnalyticsEvent);
            return localAnalyticsEvent;
        }
        printWarning("Please call startSession before calling levelEnd");
        return null;
    }

    protected AnalyticsEventsWrapper.IMSectionStatus getLevelStatus() {
        return this.a;
    }

    public AnalyticsEvent processFunction() {
        return a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/db/FunctionLevelEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */