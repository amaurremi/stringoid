package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.onlineconfig.UmengOnlineConfigureListener;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMSocialService;
import com.umeng.common.Log;
import com.umeng.common.b;

import java.util.HashMap;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;

public class MobclickAgent {
    private static final String a = "input map is null";
    private static final c b = new c();

    public static void flush(Context paramContext) {
        b.d(paramContext);
    }

    public static c getAgent() {
        return b;
    }

    public static String getConfigParams(Context paramContext, String paramString) {
        return f.a(paramContext).g().getString(paramString, "");
    }

    public static void onEvent(Context paramContext, String paramString) {
        b.a(paramContext, paramString, null, -1L, 1);
    }

    public static void onEvent(Context paramContext, String paramString, int paramInt) {
        b.a(paramContext, paramString, null, -1L, paramInt);
    }

    public static void onEvent(Context paramContext, String paramString1, String paramString2) {
        if (TextUtils.isEmpty(paramString2)) {
            Log.a("MobclickAgent", "label is null or empty");
            return;
        }
        b.a(paramContext, paramString1, paramString2, -1L, 1);
    }

    public static void onEvent(Context paramContext, String paramString1, String paramString2, int paramInt) {
        if (TextUtils.isEmpty(paramString2)) {
            Log.a("MobclickAgent", "label is null or empty");
            return;
        }
        b.a(paramContext, paramString1, paramString2, -1L, paramInt);
    }

    public static void onEvent(Context paramContext, String paramString, Map<String, String> paramMap) {
        if (paramMap == null) {
            Log.b("MobclickAgent", "input map is null");
            return;
        }
        b.a(paramContext, paramString, new HashMap(paramMap), -1L);
    }

    public static void onEventBegin(Context paramContext, String paramString) {
        b.b(paramContext, paramString);
    }

    public static void onEventBegin(Context paramContext, String paramString1, String paramString2) {
        b.a(paramContext, paramString1, paramString2);
    }

    public static void onEventDuration(Context paramContext, String paramString, long paramLong) {
        if (paramLong <= 0L) {
            Log.a("MobclickAgent", "duration is not valid in onEventDuration");
            return;
        }
        b.a(paramContext, paramString, null, paramLong, 1);
    }

    public static void onEventDuration(Context paramContext, String paramString1, String paramString2, long paramLong) {
        if (TextUtils.isEmpty(paramString2)) {
            Log.a("MobclickAgent", "label is null or empty");
            return;
        }
        if (paramLong <= 0L) {
            Log.a("MobclickAgent", "duration is not valid in onEventDuration");
            return;
        }
        b.a(paramContext, paramString1, paramString2, paramLong, 1);
    }

    public static void onEventDuration(Context paramContext, String paramString, Map<String, String> paramMap, long paramLong) {
        if (paramLong <= 0L) {
            Log.a("MobclickAgent", "duration is not valid in onEventDuration");
            return;
        }
        if (paramMap == null) {
            Log.b("MobclickAgent", "input map is null");
            return;
        }
        b.a(paramContext, paramString, new HashMap(paramMap), paramLong);
    }

    public static void onEventEnd(Context paramContext, String paramString) {
        b.c(paramContext, paramString);
    }

    public static void onEventEnd(Context paramContext, String paramString1, String paramString2) {
        b.b(paramContext, paramString1, paramString2);
    }

    public static void onEventValue(Context paramContext, String paramString, Map<String, String> paramMap, int paramInt) {
        if (paramMap == null) {
        }
        for (paramMap = new HashMap(); ; paramMap = new HashMap(paramMap)) {
            paramMap.put("__ct__", Integer.valueOf(paramInt));
            b.a(paramContext, paramString, paramMap, -1L);
            return;
        }
    }

    public static void onKVEventBegin(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2) {
        if (paramMap == null) {
            Log.b("MobclickAgent", "input map is null");
            return;
        }
        b.a(paramContext, paramString1, new HashMap(paramMap), paramString2);
    }

    public static void onKVEventEnd(Context paramContext, String paramString1, String paramString2) {
        b.c(paramContext, paramString1, paramString2);
    }

    public static void onKillProcess(Context paramContext) {
        b.e(paramContext);
    }

    public static void onPageEnd(String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
            b.b(paramString);
            return;
        }
        Log.b("MobclickAgent", "pageName is null or empty");
    }

    public static void onPageStart(String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
            b.a(paramString);
            return;
        }
        Log.b("MobclickAgent", "pageName is null or empty");
    }

    public static void onPause(Context paramContext) {
        b.c(paramContext);
    }

    public static void onResume(Context paramContext) {
        if (paramContext == null) {
            Log.b("MobclickAgent", "unexpected null context in onResume");
            return;
        }
        b.b(paramContext);
    }

    public static void onResume(Context paramContext, String paramString1, String paramString2) {
        if (paramContext == null) {
            Log.b("MobclickAgent", "unexpected null context in onResume");
            return;
        }
        if ((paramString1 == null) || (paramString1.length() == 0)) {
            Log.b("MobclickAgent", "unexpected empty appkey in onResume");
            return;
        }
        AnalyticsConfig.setAppkey(paramString1);
        AnalyticsConfig.setChannel(paramString2);
        b.b(paramContext);
    }

    public static void onSocialEvent(Context paramContext, String paramString, UMPlatformData... paramVarArgs) {
        if (paramContext == null) {
            Log.b("MobclickAgent", "context is null in onShareEvent");
            return;
        }
        com.umeng.analytics.social.e.e = "3";
        UMSocialService.share(paramContext, paramString, paramVarArgs);
    }

    public static void onSocialEvent(Context paramContext, UMPlatformData... paramVarArgs) {
        if (paramContext == null) {
            Log.b("MobclickAgent", "context is null in onShareEvent");
            return;
        }
        com.umeng.analytics.social.e.e = "3";
        UMSocialService.share(paramContext, paramVarArgs);
    }

    public static void openActivityDurationTrack(boolean paramBoolean) {
        AnalyticsConfig.ACTIVITY_DURATION_OPEN = paramBoolean;
    }

    public static void reportError(Context paramContext, String paramString) {
        b.a(paramContext, paramString);
    }

    public static void reportError(Context paramContext, Throwable paramThrowable) {
        b.a(paramContext, paramThrowable);
    }

    public static void setAutoLocation(boolean paramBoolean) {
    }

    public static void setCatchUncaughtExceptions(boolean paramBoolean) {
        AnalyticsConfig.CATCH_EXCEPTION = paramBoolean;
    }

    public static void setDebugMode(boolean paramBoolean) {
        Log.LOG = paramBoolean;
        com.umeng.analytics.social.e.v = paramBoolean;
    }

    public static void setEnableEventBuffer(boolean paramBoolean) {
        AnalyticsConfig.ENABLE_MEMORY_BUFFER = paramBoolean;
    }

    public static void setOnlineConfigureListener(UmengOnlineConfigureListener paramUmengOnlineConfigureListener) {
        b.a(paramUmengOnlineConfigureListener);
    }

    public static void setOpenGLContext(GL10 paramGL10) {
        if (paramGL10 != null) {
            paramGL10 = b.a(paramGL10);
            if (paramGL10.length == 2) {
                AnalyticsConfig.GPU_VENDER = paramGL10[0];
                AnalyticsConfig.GPU_RENDERER = paramGL10[1];
            }
        }
    }

    public static void setSessionContinueMillis(long paramLong) {
        AnalyticsConfig.kContinueSessionMillis = paramLong;
    }

    public static void setUserID(Context paramContext, String paramString1, String paramString2, Gender paramGender, int paramInt) {
        if (!TextUtils.isEmpty(paramString1)) {
            if (TextUtils.isEmpty(paramString2)) {
                break label55;
            }
            label14:
            if ((paramInt <= 0) || (paramInt >= 200)) {
                break label67;
            }
        }
        for (; ; ) {
            f.a(paramContext).a(paramString1, paramString2, paramInt, paramGender.value);
            return;
            Log.c("MobclickAgent", "userID is null or empty");
            paramString1 = null;
            break;
            label55:
            Log.a("MobclickAgent", "id source is null or empty");
            paramString2 = null;
            break label14;
            label67:
            Log.a("MobclickAgent", "not a valid age!");
            paramInt = -1;
        }
    }

    public static void setWrapper(String paramString1, String paramString2) {
        b.a(paramString1, paramString2);
    }

    public static void updateOnlineConfig(Context paramContext) {
        b.a(paramContext);
    }

    public static void updateOnlineConfig(Context paramContext, String paramString1, String paramString2) {
        if ((paramString1 == null) || (paramString1.length() == 0)) {
            Log.b("MobclickAgent", "unexpected empty appkey in onResume");
            return;
        }
        AnalyticsConfig.setAppkey(paramString1);
        AnalyticsConfig.setChannel(paramString2);
        b.a(paramContext);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/MobclickAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */