package com.inmobi.monetization.internal;

import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsEndPointsConfig;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.ErrorCode;
import com.inmobi.commons.network.Request;
import com.inmobi.commons.network.Request.Format;
import com.inmobi.commons.network.Request.Method;
import com.inmobi.commons.network.Response;
import com.inmobi.commons.network.ServiceProvider;
import com.inmobi.commons.network.abstraction.INetworkListener;
import com.inmobi.monetization.internal.objects.LtvpRuleCache;

import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONObject;

public class LtvpRuleProcessor
        implements INetworkListener {
    private ServiceProvider a = ServiceProvider.getInstance();

    public static LtvpRuleProcessor getInstance() {
        return new LtvpRuleProcessor();
    }

    public void dispatchLtvpRule() {
        Log.internal("[InMobi]-[Monetization]", "Fetching LTVP Rule");
        Request localRequest = new Request(AnalyticsInitializer.getConfigParams().getEndPoints().getRulesUrl(), Request.Format.KEY_VAL, Request.Method.GET);
        localRequest.fillAppInfo();
        localRequest.fillDeviceInfo();
        this.a.executeTask(localRequest, this);
    }

    public LtvpRuleProcessor.ActionsRule getLtvpRuleConfig(long paramLong) {
        LtvpRuleProcessor.ActionsRule.MEDIATION.getValue();
        LtvpRuleCache localLtvpRuleCache = LtvpRuleCache.getInstance(InternalSDKUtil.getContext());
        if ((localLtvpRuleCache.getHardExpiryForLtvpRule() <= System.currentTimeMillis()) || (localLtvpRuleCache.getHardExpiryForLtvpRule() == 0L)) {
            Log.internal("[InMobi]-[Monetization]", "Hard Expiry or 1st rule fetch. Default mediation. Fetching Rule");
            dispatchLtvpRule();
            localLtvpRuleCache.clearLtvpRuleCache();
            return LtvpRuleProcessor.ActionsRule.MEDIATION;
        }
        if (localLtvpRuleCache.getSoftExpiryForLtvpRule() <= System.currentTimeMillis()) {
            Log.internal("[InMobi]-[Monetization]", "Soft Expiry. Default mediation. Fetching Rule");
            dispatchLtvpRule();
        }
        for (int i = localLtvpRuleCache.getLtvpRule(paramLong); ; i = localLtvpRuleCache.getLtvpRule(paramLong)) {
            return LtvpRuleProcessor.ActionsRule.a(i);
            Log.internal("[InMobi]-[Monetization]", "Valid rule");
        }
    }

    public void onRequestFailed(Request paramRequest, Response paramResponse) {
        try {
            Log.internal("[InMobi]-[Monetization]", "Ltvp Rule error" + paramResponse.getError().toString());
            return;
        } catch (Exception paramRequest) {
            Log.internal("[InMobi]-[Monetization]", "Ltvp Rule exception", paramRequest);
        }
    }

    public void onRequestSucceded(Request paramRequest, Response paramResponse) {
        long l1;
        Object localObject;
        long l2;
        long l3;
        try {
            if (paramResponse.getStatusCode() != 200) {
                return;
            }
            paramRequest = new JSONObject(paramResponse.getResponseBody());
            if (!paramRequest.getBoolean("success")) {
                int i = paramRequest.getInt("error_code");
                paramRequest = paramRequest.getString("error_message");
                Log.internal("[InMobi]-[Monetization]", "Received LTVP rule fetch failure: " + i + " : " + paramRequest);
                return;
            }
            JSONObject localJSONObject = paramRequest.getJSONObject("response");
            Log.debug("[InMobi]-[Monetization]", "Received LTVP rule fetch success: " + localJSONObject.toString());
            paramRequest = new LtvpRulesObject();
            paramResponse = localJSONObject.getString("rule_id");
            l1 = localJSONObject.getLong("ts");
            localObject = localJSONObject.getJSONObject("exp");
            l2 = ((JSONObject) localObject).getLong("se");
            l3 = ((JSONObject) localObject).getLong("he");
            localObject = new HashMap();
            localJSONObject = localJSONObject.getJSONObject("rules");
            Iterator localIterator = localJSONObject.keys();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                ((HashMap) localObject).put(str, Integer.valueOf(localJSONObject.getInt(String.valueOf(str))));
            }
            paramRequest.setRuleId(paramResponse);
        } catch (Exception paramRequest) {
            Log.internal("[InMobi]-[Monetization]", "Exception getting ltvp rule", paramRequest);
            return;
        }
        paramRequest.setTimeStamp(l1);
        paramRequest.setSoftExpiry(l2);
        paramRequest.setHardExpiry(l3);
        paramRequest.setRules((HashMap) localObject);
        Log.internal("[InMobi]-[Monetization]", "Ltvp Rule received" + paramRequest.getRules().toString());
        LtvpRuleCache.getInstance(InternalSDKUtil.getContext()).setLtvpRuleConfig(paramRequest);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/LtvpRuleProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */