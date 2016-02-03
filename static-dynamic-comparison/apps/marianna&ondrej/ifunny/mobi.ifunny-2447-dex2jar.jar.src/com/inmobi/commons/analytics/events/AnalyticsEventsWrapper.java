package com.inmobi.commons.analytics.events;

import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.db.AnalyticsEventsQueue;
import com.inmobi.commons.analytics.db.FunctionEndSession;
import com.inmobi.commons.analytics.db.FunctionLevelBegin;
import com.inmobi.commons.analytics.db.FunctionLevelEnd;
import com.inmobi.commons.analytics.db.FunctionSetUserAttribute;
import com.inmobi.commons.analytics.db.FunctionStartSession;
import com.inmobi.commons.analytics.db.FunctionTagEvent;
import com.inmobi.commons.analytics.db.FunctionTagTransaction;
import com.inmobi.commons.analytics.net.AnalyticsNetworkManager;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

import java.util.Map;

public final class AnalyticsEventsWrapper {
    private static AnalyticsEventsWrapper a;
    private static boolean c = false;
    private AnalyticsEventsQueue b;

    private void a(String paramString) {
        Log.debug("[InMobi]-[Analytics]-4.5.1", "IllegalArgumentError: " + paramString);
    }

    private boolean a() {
        if ((InternalSDKUtil.getContext() != null) && (SessionInfo.getSessionId(InternalSDKUtil.getContext()) == null)) {
            startSession(InMobi.getAppId(), null);
        }
        while (SessionInfo.getSessionId(InternalSDKUtil.getContext()) != null) {
            return true;
        }
        Log.internal("[InMobi]-[Analytics]-4.5.1", "Please call InMobi.initialize or startSession before calling any events API");
        return false;
    }

    public static AnalyticsEventsWrapper getInstance() {
        try {
            if (AnalyticsUtils.getWebviewUserAgent() == null) {
                AnalyticsUtils.setWebviewUserAgent(InternalSDKUtil.getUserAgent());
            }
            if (a == null) {
                a = new AnalyticsEventsWrapper();
                AnalyticsUtils.setStartHandle(false);
                AnalyticsNetworkManager.startInstance();
            }
            a.b = AnalyticsEventsQueue.getInstance();
            AnalyticsEventsWrapper localAnalyticsEventsWrapper = a;
            return localAnalyticsEventsWrapper;
        } finally {
        }
    }

    public static boolean isEventsUser() {
        return c;
    }

    public static void setIsEventsUser() {
        c = true;
    }

    public void beginSection(int paramInt, String paramString, Map<String, String> paramMap) {
        if (paramString == null) {
        }
        try {
            a("arguments cannot be null");
            return;
        } catch (Exception paramString) {
            Log.internal("[InMobi]-[Analytics]-4.5.1", "Begin Section Exception", paramString);
            return;
        }
        if ((paramMap != null) && (paramMap.size() > 10)) {
            a("attribute map cannot exceed 10 values");
            return;
        }
        if (a()) {
            paramString = new FunctionLevelBegin(InternalSDKUtil.getContext(), paramInt, paramString, paramMap);
            this.b.addElement(paramString);
            this.b.processFunctions();
        }
    }

    public void endSection(int paramInt, String paramString, Map<String, String> paramMap) {
        if (paramString == null) {
        }
        try {
            a("arguments cannot be null");
            return;
        } catch (Exception paramString) {
            Log.internal("[InMobi]-[Analytics]-4.5.1", "End Section Exception", paramString);
            return;
        }
        if ((paramMap != null) && (paramMap.size() > 10)) {
            a("attribute map cannot exceed 10 values");
            return;
        }
        if (a()) {
            paramString = new FunctionLevelEnd(InternalSDKUtil.getContext(), paramInt, paramString, null, paramMap);
            this.b.addElement(paramString);
            this.b.processFunctions();
        }
    }

    public void endSession(Map<String, String> paramMap) {
        if (paramMap != null) {
        }
        try {
            if (paramMap.size() > 10) {
                a("attribute map cannot exceed 10 values");
                return;
            }
            paramMap = new FunctionEndSession(InternalSDKUtil.getContext(), paramMap);
            this.b.addElement(paramMap);
            this.b.processFunctions();
            return;
        } catch (Exception paramMap) {
            Log.internal("[InMobi]-[Analytics]-4.5.1", "End Session Exception", paramMap);
        }
    }

    public void setUserAttribute(String paramString1, String paramString2) {
        if ((paramString1 == null) || (paramString1.trim().equals("")) || (paramString2 == null) || (paramString2.trim().equals(""))) {
            a("arguments cannot be null or empty");
        }
        for (; ; ) {
            return;
            if ((paramString1.length() > 15) || (paramString2.length() > 20)) {
                a("attribute name cannot exceed 15 chars and attribute val cannot exceed 20 chars. Please pass a valid attribute");
                return;
            }
            try {
                if (a()) {
                    paramString1 = new FunctionSetUserAttribute(InternalSDKUtil.getContext(), paramString1, paramString2);
                    this.b.addElement(paramString1);
                    this.b.processFunctions();
                    return;
                }
            } catch (Exception paramString1) {
                Log.internal("[InMobi]-[Analytics]-4.5.1", "Set User Attribute Exception", paramString1);
            }
        }
    }

    public void startSession(String paramString, Map<String, String> paramMap) {
        if (paramString != null) {
        }
        try {
            if (paramString.trim().equals("")) {
                a("appid cannot be null or empty");
                return;
            }
            if ((paramMap != null) && (paramMap.size() > 10)) {
                a("attribute map cannot exceed 10 values");
                return;
            }
        } catch (Exception paramString) {
            Log.internal("[InMobi]-[Analytics]-4.5.1", "Init exception", paramString);
            return;
        }
        paramString = new FunctionStartSession(InternalSDKUtil.getContext(), paramString, paramMap);
        this.b.addElement(paramString);
        this.b.processFunctions();
    }

    public void tagEvent(String paramString, Map<String, String> paramMap) {
        if (paramString != null) {
        }
        try {
            if (paramString.trim().equals("")) {
                a("arguments cannot be null or empty");
                return;
            }
            if ((paramMap != null) && (paramMap.size() > 10)) {
                a("attribute map cannot exceed 10 values");
                return;
            }
        } catch (Exception paramString) {
            Log.internal("[InMobi]-[Analytics]-4.5.1", "Tag Event Exception", paramString);
            return;
        }
        if (a()) {
            paramString = new FunctionTagEvent(InternalSDKUtil.getContext(), paramString, paramMap);
            this.b.addElement(paramString);
            this.b.processFunctions();
        }
    }

    public void tagTransactionManually(Intent paramIntent, Bundle paramBundle) {
        if (paramIntent == null) {
        }
        try {
            a("transaction intent cannot be null or empty");
            return;
        } catch (Exception paramIntent) {
            Log.internal("[InMobi]-[Analytics]-4.5.1", "Tag Transaction Manually Exception", paramIntent);
        }
        if (a()) {
            paramIntent = new FunctionTagTransaction(InternalSDKUtil.getContext(), paramIntent, paramBundle);
            this.b.addElement(paramIntent);
            this.b.processFunctions();
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/events/AnalyticsEventsWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */