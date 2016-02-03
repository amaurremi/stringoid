package com.facebook;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.Logger;

import java.math.BigDecimal;
import java.util.Currency;

@Deprecated
public class InsightsLogger {
    private static final String EVENT_NAME_LOG_CONVERSION_PIXEL = "fb_log_offsite_pixel";
    private static final String EVENT_PARAMETER_PIXEL_ID = "fb_offsite_pixel_id";
    private static final String EVENT_PARAMETER_PIXEL_VALUE = "fb_offsite_pixel_value";
    private AppEventsLogger appEventsLogger;

    private InsightsLogger(Context paramContext, String paramString, Session paramSession) {
        this.appEventsLogger = AppEventsLogger.newLogger(paramContext, paramString, paramSession);
    }

    public static InsightsLogger newLogger(Context paramContext, String paramString) {
        return new InsightsLogger(paramContext, null, null);
    }

    public static InsightsLogger newLogger(Context paramContext, String paramString1, String paramString2) {
        return new InsightsLogger(paramContext, paramString2, null);
    }

    public static InsightsLogger newLogger(Context paramContext, String paramString1, String paramString2, Session paramSession) {
        return new InsightsLogger(paramContext, paramString2, paramSession);
    }

    public void logConversionPixel(String paramString, double paramDouble) {
        if (paramString == null) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "Insights", "pixelID cannot be null");
            return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("fb_offsite_pixel_id", paramString);
        localBundle.putDouble("fb_offsite_pixel_value", paramDouble);
        this.appEventsLogger.logEvent("fb_log_offsite_pixel", paramDouble, localBundle);
        AppEventsLogger.eagerFlush();
    }

    public void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency) {
        logPurchase(paramBigDecimal, paramCurrency, null);
    }

    public void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle) {
        this.appEventsLogger.logPurchase(paramBigDecimal, paramCurrency, paramBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/InsightsLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */