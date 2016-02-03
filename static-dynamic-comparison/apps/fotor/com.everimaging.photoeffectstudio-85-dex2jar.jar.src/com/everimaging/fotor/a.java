package com.everimaging.fotor;

import android.app.Activity;
import android.content.Context;
import com.everimaging.fotorsdk.utils.CountlyUtils;
import com.flurry.android.FlurryAgent;
import com.google.analytics.tracking.android.l;
import com.umeng.analytics.MobclickAgent;

import java.util.Map;

public class a {
    public static void a(Activity paramActivity) {
        MobclickAgent.onResume(paramActivity);
        FlurryAgent.onStartSession(paramActivity, "ZSH4RFNSBFBH4QKDM6C9");
        l.a(paramActivity).a(paramActivity);
        CountlyUtils.startCountly();
    }

    public static void a(Context paramContext, String paramString) {
        FlurryAgent.logEvent(paramString);
        MobclickAgent.onEvent(paramContext, paramString);
    }

    public static void a(Context paramContext, String paramString, Map<String, String> paramMap) {
        FlurryAgent.logEvent(paramString, paramMap);
        MobclickAgent.onEvent(paramContext, paramString, paramMap);
    }

    public static void b(Activity paramActivity) {
        MobclickAgent.onPause(paramActivity);
        FlurryAgent.onEndSession(paramActivity);
        l.a(paramActivity).b(paramActivity);
        CountlyUtils.stopCountly();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */