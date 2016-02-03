package com.quoord.tools.tracking;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.analytics.HitBuilders.AppViewBuilder;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.analytics.Tracker;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.util.Util;

public class GoogleAnalyticsTools {
    public static void trackEvent(Context paramContext, String paramString1, String paramString2) {
        if (paramContext != null) {
        }
        try {
            if (paramContext.getApplicationContext() != null) {
                ((TapatalkApp) paramContext.getApplicationContext()).getTracker().send(new HitBuilders.EventBuilder().setCategory(paramString1).setAction(paramString2).build());
            }
            return;
        } catch (Exception paramContext) {
        }
    }

    public static void trackEvent(Context paramContext, String paramString1, String paramString2, String paramString3) {
        if (paramContext != null) {
        }
        try {
            if (paramContext.getApplicationContext() != null) {
                ((TapatalkApp) paramContext.getApplicationContext()).getTracker().send(new HitBuilders.EventBuilder().setCategory(paramString1).setAction(paramString2).setLabel(paramString3).build());
            }
            return;
        } catch (Exception paramContext) {
        }
    }

    public static void trackPageView(Context paramContext, String paramString) {
        if (paramContext != null) {
        }
        try {
            if (paramContext.getApplicationContext() != null) {
                paramContext = ((TapatalkApp) paramContext.getApplicationContext()).getTracker();
                paramContext.setScreenName(paramString);
                paramContext.send(new HitBuilders.AppViewBuilder().build());
            }
            return;
        } catch (Exception paramContext) {
        }
    }

    public static void trackPageView(Context paramContext, String paramString1, String paramString2, String paramString3) {
        if (paramContext != null) {
            try {
                if (paramContext.getApplicationContext() != null) {
                    if (!paramContext.getResources().getBoolean(2131558401)) {
                        paramString1 = "forum/" + paramString1;
                    }
                    for (; ; ) {
                        paramContext = ((TapatalkApp) paramContext.getApplicationContext()).getTracker();
                        paramContext.setScreenName(paramString1);
                        paramContext.send(new HitBuilders.AppViewBuilder().build());
                        return;
                        if (paramContext.getResources().getBoolean(2131558406)) {
                            String[] arrayOfString = Util.getHost(paramString3).split("\\.");
                            paramString2 = Util.getHost(paramString3);
                            if (arrayOfString.length > 2) {
                                paramString2 = arrayOfString[1] + "." + arrayOfString[2];
                            }
                            paramString1 = paramString2 + "/" + paramString1;
                        } else {
                            paramString1 = Util.getHost(TapatalkApp.rebranding_url).replace("www.", "") + "/" + paramString1;
                        }
                    }
                }
                return;
            } catch (Exception paramContext) {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/tracking/GoogleAnalyticsTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */