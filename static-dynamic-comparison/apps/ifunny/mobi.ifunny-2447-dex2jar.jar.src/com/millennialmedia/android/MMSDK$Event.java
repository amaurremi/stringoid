package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

class MMSDK$Event {
    public static final String INTENT_CALENDAR_EVENT = "calendar";
    public static final String INTENT_EMAIL = "email";
    public static final String INTENT_EXTERNAL_BROWSER = "browser";
    public static final String INTENT_MAPS = "geo";
    public static final String INTENT_MARKET = "market";
    public static final String INTENT_PHONE_CALL = "tel";
    public static final String INTENT_STREAMING_VIDEO = "streamingVideo";
    public static final String INTENT_TXT_MESSAGE = "sms";
    protected static final String a = Event.class.getName();

    static void a(Context paramContext, long paramLong) {
        if (MMSDK.d()) {
            a(paramContext, new Intent("millennialmedia.action.ACTION_OVERLAY_OPENED"), paramLong);
        }
    }

    private static final void a(Context paramContext, Intent paramIntent, long paramLong) {
        if (paramContext != null) {
            paramIntent.addCategory("millennialmedia.category.CATEGORY_SDK");
            if (paramLong != -4L) {
                paramIntent.putExtra("internalId", paramLong);
            }
            paramIntent.putExtra("packageName", paramContext.getPackageName());
            str = paramIntent.getStringExtra("intentType");
            if (TextUtils.isEmpty(str)) {
                break label122;
            }
        }
        label122:
        for (String str = String.format(" Type[%s]", new Object[]{str}); ; str = "") {
            MMLog.a("MMSDK", " @@ Intent: " + paramIntent.getAction() + " " + str + " for " + paramLong);
            paramContext.sendBroadcast(paramIntent);
            return;
        }
    }

    static void a(Context paramContext, String paramString, long paramLong) {
        if ((MMSDK.d()) && (paramString != null)) {
            a(paramContext, new Intent("millennialmedia.action.ACTION_INTENT_STARTED").putExtra("intentType", paramString), paramLong);
        }
    }

    static void a(MMAdImpl paramMMAdImpl) {
        if (paramMMAdImpl == null) {
        }
        do {
            return;
            MMSDK.a(new MMSDK.Event .2 (paramMMAdImpl));
        } while (!MMSDK.d());
        a(paramMMAdImpl.j(), new Intent("millennialmedia.action.ACTION_OVERLAY_TAP"), paramMMAdImpl.h);
        a(paramMMAdImpl.j(), new Intent("millennialmedia.action.ACTION_AD_SINGLE_TAP"), paramMMAdImpl.h);
    }

    static void a(MMAdImpl paramMMAdImpl, MMException paramMMException) {
        if (paramMMAdImpl == null) {
            MMLog.d("MMSDK", "No Context in the listener: ");
        }
        do {
            return;
            MMSDK.a(new MMSDK.Event .7 (paramMMAdImpl, paramMMException));
        } while (!MMSDK.d());
        String str = paramMMAdImpl.m();
        a(paramMMAdImpl.j(), new Intent(str).putExtra("error", paramMMException), paramMMAdImpl.h);
    }

    protected static void a(String paramString) {
        MMLog.b("Logging event to: %s", paramString);
        Utils.ThreadUtils.a(new MMSDK.Event .1 (paramString));
    }

    static void b(MMAdImpl paramMMAdImpl) {
        if (paramMMAdImpl == null) {
            MMLog.d("MMSDK", "No Context in the listener: ");
        }
        do {
            return;
            MMSDK.a(new MMSDK.Event .3 (paramMMAdImpl));
        } while (!MMSDK.d());
        a(paramMMAdImpl.j(), new Intent("millennialmedia.action.ACTION_FETCH_STARTED_CACHING"), paramMMAdImpl.h);
    }

    static void c(MMAdImpl paramMMAdImpl) {
        if (paramMMAdImpl == null) {
            MMLog.d("MMSDK", "No Context in the listener: ");
            return;
        }
        if (MMSDK.d()) {
            a(paramMMAdImpl.j(), new Intent("millennialmedia.action.ACTION_DISPLAY_STARTED"), paramMMAdImpl.h);
        }
        d(paramMMAdImpl);
    }

    static void d(MMAdImpl paramMMAdImpl) {
        if (paramMMAdImpl == null) {
            MMLog.d("MMSDK", "No Context in the listener: ");
            return;
        }
        MMSDK.a(new MMSDK.Event .4 (paramMMAdImpl));
        a(paramMMAdImpl.j(), paramMMAdImpl.h);
    }

    static void e(MMAdImpl paramMMAdImpl) {
        if (paramMMAdImpl == null) {
            MMLog.d("MMSDK", "No Context in the listener: ");
        }
        do {
            return;
            MMSDK.a(new MMSDK.Event .5 (paramMMAdImpl));
        } while ((!MMSDK.d()) || (paramMMAdImpl.j() == null));
        a(paramMMAdImpl.j(), new Intent("millennialmedia.action.ACTION_OVERLAY_CLOSED"), paramMMAdImpl.h);
    }

    static void f(MMAdImpl paramMMAdImpl) {
        if (paramMMAdImpl == null) {
            MMLog.d("MMSDK", "No Context in the listener: ");
        }
        do {
            return;
            MMSDK.a(new MMSDK.Event .6 (paramMMAdImpl));
        } while (!MMSDK.d());
        String str = paramMMAdImpl.n();
        a(paramMMAdImpl.j(), new Intent(str), paramMMAdImpl.h);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMSDK$Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */