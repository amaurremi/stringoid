package com.millennialmedia.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

@Deprecated
public class MMBroadcastReceiver
        extends BroadcastReceiver {
    public static final String ACTION_AD_SINGLE_TAP = "millennialmedia.action.ACTION_AD_SINGLE_TAP";
    public static final String ACTION_DISPLAY_STARTED = "millennialmedia.action.ACTION_DISPLAY_STARTED";
    public static final String ACTION_FETCH_FAILED = "millennialmedia.action.ACTION_FETCH_FAILED";
    public static final String ACTION_FETCH_STARTED_CACHING = "millennialmedia.action.ACTION_FETCH_STARTED_CACHING";
    public static final String ACTION_FETCH_SUCCEEDED = "millennialmedia.action.ACTION_FETCH_SUCCEEDED";
    public static final String ACTION_GETAD_FAILED = "millennialmedia.action.ACTION_GETAD_FAILED";
    public static final String ACTION_GETAD_SUCCEEDED = "millennialmedia.action.ACTION_GETAD_SUCCEEDED";
    public static final String ACTION_INTENT_STARTED = "millennialmedia.action.ACTION_INTENT_STARTED";
    public static final String ACTION_OVERLAY_CLOSED = "millennialmedia.action.ACTION_OVERLAY_CLOSED";
    public static final String ACTION_OVERLAY_OPENED = "millennialmedia.action.ACTION_OVERLAY_OPENED";
    @Deprecated
    public static final String ACTION_OVERLAY_TAP = "millennialmedia.action.ACTION_OVERLAY_TAP";
    public static final String CATEGORY_SDK = "millennialmedia.category.CATEGORY_SDK";

    public static IntentFilter createIntentFilter() {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addCategory("millennialmedia.category.CATEGORY_SDK");
        localIntentFilter.addAction("millennialmedia.action.ACTION_DISPLAY_STARTED");
        localIntentFilter.addAction("millennialmedia.action.ACTION_FETCH_FAILED");
        localIntentFilter.addAction("millennialmedia.action.ACTION_FETCH_SUCCEEDED");
        localIntentFilter.addAction("millennialmedia.action.ACTION_FETCH_STARTED_CACHING");
        localIntentFilter.addAction("millennialmedia.action.ACTION_GETAD_FAILED");
        localIntentFilter.addAction("millennialmedia.action.ACTION_GETAD_SUCCEEDED");
        localIntentFilter.addAction("millennialmedia.action.ACTION_INTENT_STARTED");
        localIntentFilter.addAction("millennialmedia.action.ACTION_OVERLAY_CLOSED");
        localIntentFilter.addAction("millennialmedia.action.ACTION_OVERLAY_OPENED");
        localIntentFilter.addAction("millennialmedia.action.ACTION_OVERLAY_TAP");
        localIntentFilter.addAction("millennialmedia.action.ACTION_AD_SINGLE_TAP");
        return localIntentFilter;
    }

    public void displayStarted(MMAd paramMMAd) {
        MMLog.c("MMBroadcastReceiver", "Millennial Media display started.");
    }

    public void fetchFailure(MMAd paramMMAd) {
        MMLog.c("MMBroadcastReceiver", "Millennial Media fetch failed.");
    }

    public void fetchFinishedCaching(MMAd paramMMAd) {
        MMLog.c("MMBroadcastReceiver", "Millennial Media fetch finished caching.");
    }

    public void fetchStartedCaching(MMAd paramMMAd) {
        MMLog.c("MMBroadcastReceiver", "Millennial Media fetch started caching.");
    }

    public void getAdFailure(MMAd paramMMAd) {
        MMLog.c("MMBroadcastReceiver", "Millennial Media ad Failure.");
    }

    public void getAdSuccess(MMAd paramMMAd) {
        MMLog.c("MMBroadcastReceiver", "Millennial Media ad Success.");
    }

    public void intentStarted(MMAd paramMMAd, String paramString) {
        if (paramString != null) {
            MMLog.c("MMBroadcastReceiver", "Millennial Media started intent: " + paramString);
        }
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        String str2 = paramIntent.getAction();
        Object localObject = paramIntent.getStringExtra("packageName");
        long l = paramIntent.getLongExtra("internalId", -4L);
        String str1 = null;
        if (!paramContext.getPackageName().equals(localObject)) {
        }
        do {
            return;
            paramContext = str1;
            if (l != -4L) {
                localObject = MMAdImplController.a(l);
                paramContext = str1;
                if (localObject != null) {
                    paramContext = ((MMAdImpl) localObject).d();
                }
            }
            localObject = new StringBuilder().append(" @@ Intent - Ad in receiver = ");
            if (paramContext == null) {
            }
            for (str1 = " null"; ; str1 = paramContext.toString()) {
                MMLog.a("MMBroadcastReceiver", str1);
                if (!str2.equals("millennialmedia.action.ACTION_OVERLAY_OPENED")) {
                    break;
                }
                overlayOpened(paramContext);
                return;
            }
            if (str2.equals("millennialmedia.action.ACTION_OVERLAY_CLOSED")) {
                overlayClosed(paramContext);
                return;
            }
            if (str2.equals("millennialmedia.action.ACTION_OVERLAY_TAP")) {
                overlayTap(paramContext);
                return;
            }
            if (str2.equals("millennialmedia.action.ACTION_AD_SINGLE_TAP")) {
                onSingleTap(paramContext);
                return;
            }
            if (str2.equals("millennialmedia.action.ACTION_DISPLAY_STARTED")) {
                displayStarted(paramContext);
                return;
            }
            if (str2.equals("millennialmedia.action.ACTION_FETCH_FAILED")) {
                fetchFailure(paramContext);
                return;
            }
            if (str2.equals("millennialmedia.action.ACTION_FETCH_SUCCEEDED")) {
                fetchFinishedCaching(paramContext);
                return;
            }
            if (str2.equals("millennialmedia.action.ACTION_FETCH_STARTED_CACHING")) {
                fetchStartedCaching(paramContext);
                return;
            }
            if (str2.equals("millennialmedia.action.ACTION_GETAD_FAILED")) {
                getAdFailure(paramContext);
                return;
            }
            if (str2.equals("millennialmedia.action.ACTION_GETAD_SUCCEEDED")) {
                getAdSuccess(paramContext);
                return;
            }
        } while (!str2.equals("millennialmedia.action.ACTION_INTENT_STARTED"));
        intentStarted(paramContext, paramIntent.getStringExtra("intentType"));
    }

    public void onSingleTap(MMAd paramMMAd) {
        MMLog.c("MMBroadcastReceiver", "Millennial Media ad Tap.");
    }

    public void overlayClosed(MMAd paramMMAd) {
        MMLog.c("MMBroadcastReceiver", "Millennial Media overlay closed.");
    }

    public void overlayOpened(MMAd paramMMAd) {
        MMLog.c("MMBroadcastReceiver", "Millennial Media overlay opened.");
    }

    @Deprecated
    public void overlayTap(MMAd paramMMAd) {
        MMLog.c("MMBroadcastReceiver", "Millennial Media overlay Tap.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */