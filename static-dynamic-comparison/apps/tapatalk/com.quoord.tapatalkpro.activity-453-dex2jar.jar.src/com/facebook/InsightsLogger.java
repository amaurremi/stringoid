package com.facebook;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InsightsLogger {
    private static final String EVENT_NAME_LOG_CONVERSION_PIXEL = "fb_log_offsite_pixel";
    private static final String EVENT_NAME_LOG_MOBILE_PURCHASE = "fb_mobile_purchase";
    private static final String EVENT_PARAMETER_CURRENCY = "fb_currency";
    private static final String EVENT_PARAMETER_PIXEL_ID = "fb_offsite_pixel_id";
    private static final String EVENT_PARAMETER_PIXEL_VALUE = "fb_offsite_pixel_value";
    private static Session appAuthSession = null;
    private final String applicationId;
    private final String clientToken;
    private final Context context;
    private final Session specifiedSession;

    private InsightsLogger(Context paramContext, String paramString1, String paramString2, Session paramSession) {
        Validate.notNull(paramContext, "context");
        Validate.notNullOrEmpty(paramString1, "clientToken");
        String str = paramString2;
        if (paramString2 == null) {
            str = Utility.getMetadataApplicationId(paramContext);
        }
        this.context = paramContext;
        this.clientToken = paramString1;
        this.applicationId = str;
        this.specifiedSession = paramSession;
    }

    private static String buildJSONForEvent(String paramString, double paramDouble, Bundle paramBundle) {
        try {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("_eventName", paramString);
            if (paramDouble != 1.0D) {
                localJSONObject.put("_valueToSum", paramDouble);
            }
            if (paramBundle != null) {
                paramString = paramBundle.keySet().iterator();
            }
            for (; ; ) {
                if (!paramString.hasNext()) {
                    paramString = new JSONArray();
                    paramString.put(localJSONObject);
                    return paramString.toString();
                }
                String str = (String) paramString.next();
                Object localObject = paramBundle.get(str);
                if ((!(localObject instanceof String)) && (!(localObject instanceof Number))) {
                    notifyDeveloperError(String.format("Parameter '%s' must be a string or a numeric type.", new Object[]{str}));
                }
                localJSONObject.put(str, localObject);
            }
            return null;
        } catch (JSONException paramString) {
            notifyDeveloperError(paramString.toString());
        }
    }

    private void logEventNow(final String paramString, final double paramDouble, Bundle paramBundle) {
        Settings.getExecutor().execute(new Runnable() {
            public void run() {
                String str1 = InsightsLogger.buildJSONForEvent(paramString, paramDouble, this.val$parameters);
                if (str1 == null) {
                }
                for (; ; ) {
                    return;
                    Object localObject = GraphObject.Factory.create();
                    ((GraphObject) localObject).setProperty("event", "CUSTOM_APP_EVENTS");
                    ((GraphObject) localObject).setProperty("custom_events", str1);
                    if (Utility.queryAppAttributionSupportAndWait(InsightsLogger.this.applicationId)) {
                        str2 = Settings.getAttributionId(InsightsLogger.this.context.getContentResolver());
                        if (str2 != null) {
                            ((GraphObject) localObject).setProperty("attribution", str2);
                        }
                    }
                    String str2 = String.format("%s/activities", new Object[]{InsightsLogger.this.applicationId});
                    try {
                        localObject = Request.newPostRequest(InsightsLogger.this.sessionToLogTo(), str2, (GraphObject) localObject, null).executeAndWait();
                        if ((((Response) localObject).getError() != null) && (((Response) localObject).getError().getErrorCode() != -1)) {
                            InsightsLogger.notifyDeveloperError(String.format("Error publishing Insights event '%s'\n  Response: %s\n  Error: %s", new Object[]{str1, ((Response) localObject).toString(), ((Response) localObject).getError().toString()}));
                            return;
                        }
                    } catch (Exception localException) {
                        Utility.logd("Insights-exception: ", localException);
                    }
                }
            }
        });
    }

    public static InsightsLogger newLogger(Context paramContext, String paramString) {
        return new InsightsLogger(paramContext, paramString, null, null);
    }

    public static InsightsLogger newLogger(Context paramContext, String paramString1, String paramString2) {
        return new InsightsLogger(paramContext, paramString1, paramString2, null);
    }

    public static InsightsLogger newLogger(Context paramContext, String paramString1, String paramString2, Session paramSession) {
        return new InsightsLogger(paramContext, paramString1, paramString2, paramSession);
    }

    private static void notifyDeveloperError(String paramString) {
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "Insights", paramString);
    }

    private Session sessionToLogTo() {
        try {
            Object localObject3 = this.specifiedSession;
            Object localObject1;
            if (localObject3 != null) {
                localObject1 = localObject3;
                if (((Session) localObject3).isOpened()) {
                }
            } else {
                localObject1 = Session.getActiveSession();
            }
            if ((localObject1 != null) && (((Session) localObject1).isOpened())) {
                localObject3 = localObject1;
                if (((Session) localObject1).getAccessToken() != null) {
                }
            } else {
                if (appAuthSession == null) {
                    localObject1 = AccessToken.createFromString(String.format("%s|%s", new Object[]{this.applicationId, this.clientToken}), null, AccessTokenSource.CLIENT_TOKEN);
                    appAuthSession = new Session(null, this.applicationId, new NonCachingTokenCachingStrategy(), false);
                    appAuthSession.open((AccessToken) localObject1, null);
                }
                localObject3 = appAuthSession;
            }
            return (Session) localObject3;
        } finally {
        }
    }

    public void logConversionPixel(String paramString, double paramDouble) {
        if (paramString == null) {
            notifyDeveloperError("pixelID cannot be null");
            return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("fb_offsite_pixel_id", paramString);
        localBundle.putDouble("fb_offsite_pixel_value", paramDouble);
        logEventNow("fb_log_offsite_pixel", paramDouble, localBundle);
    }

    public void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency) {
        logPurchase(paramBigDecimal, paramCurrency, null);
    }

    public void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle) {
        if (paramBigDecimal == null) {
            notifyDeveloperError("purchaseAmount cannot be null");
            return;
        }
        if (paramCurrency == null) {
            notifyDeveloperError("currency cannot be null");
            return;
        }
        Bundle localBundle = paramBundle;
        if (paramBundle == null) {
            localBundle = new Bundle();
        }
        localBundle.putString("fb_currency", paramCurrency.getCurrencyCode());
        logEventNow("fb_mobile_purchase", paramBigDecimal.doubleValue(), localBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/InsightsLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */