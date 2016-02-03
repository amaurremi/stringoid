package com.inmobi.commons.analytics.net;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.inmobi.commons.analytics.db.AnalyticsEvent;
import com.inmobi.commons.analytics.db.AnalyticsEvent.TRANSACTION_ITEM_TYPE;
import com.inmobi.commons.analytics.db.AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thirdparty.Base62;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnalyticsPayloadBuilder {
    private JSONArray a(List<AnalyticsEvent> paramList) {
        JSONArray localJSONArray = new JSONArray();
        paramList = paramList.iterator();
        for (; ; ) {
            if (paramList.hasNext()) {
                AnalyticsEvent localAnalyticsEvent = (AnalyticsEvent) paramList.next();
                JSONObject localJSONObject = new JSONObject();
                for (; ; ) {
                    try {
                        String str = Base62.fromBase10(localAnalyticsEvent.getEventId());
                        if (str != null) {
                            localJSONObject.put("eid", str);
                        }
                        localJSONObject.put("t", localAnalyticsEvent.getEventType());
                        localJSONObject.put("ts", localAnalyticsEvent.getEventTimeStamp());
                        localJSONObject.put("ld", localAnalyticsEvent.getEventLevelId());
                        localJSONObject.put("ls", localAnalyticsEvent.getEventLevelStatus());
                        localJSONObject.put("ln", localAnalyticsEvent.getEventLevelName());
                        str = localAnalyticsEvent.getEventAttributeMap();
                        if (str == null) {
                        }
                    } catch (Exception localException1) {
                        Log.internal("[InMobi]-[Analytics]-4.5.1", "Creation of events json object failed", localException1);
                        continue;
                    }
                    try {
                        localJSONObject.put("am", new JSONObject(localAnalyticsEvent.getEventAttributeMap()));
                        localJSONObject.put("tt", localAnalyticsEvent.getEventTimeTaken());
                        if (localAnalyticsEvent.getEventAttemptCount() != null) {
                            localJSONObject.put("ac", 1);
                        }
                        localJSONObject.put("at", localAnalyticsEvent.getEventAttemptTime());
                        localJSONObject.put("en", localAnalyticsEvent.getEventCustomName());
                        if ("ae".equals(localAnalyticsEvent.getEventType())) {
                            localJSONObject.put("k", localAnalyticsEvent.getAttributeName());
                            localJSONObject.put("v", localAnalyticsEvent.getAttributeValue());
                        }
                        if ("pi".equals(localAnalyticsEvent.getEventType())) {
                            localJSONObject.put("in", localAnalyticsEvent.getTransactionItemName());
                            int i = localAnalyticsEvent.getTransactionItemCount();
                            if (i > 0) {
                                localJSONObject.put("n", i);
                            }
                            localJSONObject.put("id", localAnalyticsEvent.getTransactionItemDescription());
                            localJSONObject.put("ip", localAnalyticsEvent.getTransactionItemPrice());
                            localJSONObject.put("c", localAnalyticsEvent.getTransactionCurrencyCode());
                            localJSONObject.put("pi", localAnalyticsEvent.getTransactionProductId());
                            localJSONObject.put("ti", localAnalyticsEvent.getTransactionId());
                            i = localAnalyticsEvent.getTransactionItemType();
                            if (AnalyticsEvent.TRANSACTION_ITEM_TYPE.INVALID.getValue() != i) {
                                localJSONObject.put("it", i);
                            }
                            i = localAnalyticsEvent.getTransactionStatus();
                            if (AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.INVALID.getValue() != i) {
                                localJSONObject.put("tp", i);
                            }
                        }
                        localJSONArray.put(localJSONObject);
                    } catch (Exception localException2) {
                        Log.debug("[InMobi]-[Analytics]-4.5.1", "Events attribute map is incorrect. Not sending custom event map.");
                    }
                }
            }
        }
        return localJSONArray;
    }

    private JSONObject a(String paramString, long paramLong, Context paramContext) {
        JSONObject localJSONObject = new JSONObject();
        try {
            localJSONObject.put("ft", SessionInfo.getFirstTime());
            localJSONObject.put("a", paramContext.getPackageName());
            localJSONObject.put("an", AnalyticsUtils.getApplicationName(paramContext));
            localJSONObject.put("av", AnalyticsUtils.getAppVersion(paramContext));
            localJSONObject.put("p", "android");
            localJSONObject.put("pv", Build.VERSION.RELEASE);
            localJSONObject.put("ca", InternalSDKUtil.getConnectivityType(paramContext));
            localJSONObject.put("ma", Build.MANUFACTURER);
            localJSONObject.put("mo", Build.MODEL);
            localJSONObject.put("ss", paramString);
            localJSONObject.put("sts", paramLong);
            localJSONObject.put("sv", "4.5.1");
            if (AnalyticsUtils.getCountryISO(paramContext) != null) {
                localJSONObject.put("co", AnalyticsUtils.getCountryISO(paramContext));
            }
            return localJSONObject;
        } catch (JSONException paramString) {
            Log.internal("[InMobi]-[Analytics]-4.5.1", "Creation of session object failed", paramString);
            return localJSONObject;
        } catch (NullPointerException paramString) {
            Log.internal("[InMobi]-[Analytics]-4.5.1", "null passed as context", paramString);
        }
        return localJSONObject;
    }

    private JSONObject a(JSONObject paramJSONObject, JSONArray paramJSONArray) {
        JSONObject localJSONObject = new JSONObject();
        try {
            localJSONObject.put("session", paramJSONObject);
        } catch (JSONException paramJSONObject) {
            for (; ; ) {
                try {
                    localJSONObject.put("events", paramJSONArray);
                    return localJSONObject;
                } catch (JSONException paramJSONObject) {
                    Log.internal("[InMobi]-[Analytics]-4.5.1", "Events addition to payload failed");
                }
                paramJSONObject = paramJSONObject;
                Log.internal("[InMobi]-[Analytics]-4.5.1", "Session addition to payload failed");
            }
        }
        return localJSONObject;
    }

    public AnalyticsPayload getPayloadList(List<AnalyticsEvent> paramList, Context paramContext) {
        Log.debug("[InMobi]-[Analytics]-4.5.1", "PayloadBuilder->getPayloadList:");
        JSONArray localJSONArray1 = new JSONArray();
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        int i = 0;
        while (i < paramList.size()) {
            localArrayList1.clear();
            AnalyticsEvent localAnalyticsEvent = (AnalyticsEvent) paramList.get(i);
            String str = localAnalyticsEvent.getEventSessionId();
            while ((i < paramList.size()) && (str.equals(((AnalyticsEvent) paramList.get(i)).getEventSessionId()))) {
                localArrayList2.add(Long.valueOf(((AnalyticsEvent) paramList.get(i)).getEventTableId()));
                localArrayList1.add(paramList.get(i));
                i += 1;
            }
            JSONArray localJSONArray2 = a(localArrayList1);
            localJSONArray1.put(a(a(str, localAnalyticsEvent.getEventSessionTimeStamp(), paramContext), localJSONArray2));
        }
        paramContext = new AnalyticsPayload(null, (ArrayList) localArrayList2);
        if (localJSONArray1.length() != 0) {
            paramContext.setCompletePayload(localJSONArray1.toString());
            paramContext.setPayloadSize(paramList.size());
        }
        return paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/net/AnalyticsPayloadBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */