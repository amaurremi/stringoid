package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.flurry.android.FlurryAgent;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;

import java.io.IOException;
import java.util.HashMap;

public class CustomTracker {
    public static void comScorePause(Activity paramActivity) {
        Object localObject = null;
        try {
            String str = convertStreamToString(paramActivity.getResources().getAssets().open("comScore.properties"));
            localObject = str;
        } catch (IOException localIOException) {
            for (; ; ) {
                localIOException.printStackTrace();
            }
        }
        if (localObject != null) {
            paramActivity.getResources().getBoolean(2131558401);
        }
    }

    public static void comScoreResume(Activity paramActivity) {
        paramActivity.getResources().getBoolean(2131558401);
    }

    /* Error */
    public static String convertStreamToString(java.io.InputStream paramInputStream)
            throws IOException {
        // Byte code:
        //   0: new 48	java/io/StringWriter
        //   3: dup
        //   4: invokespecial 49	java/io/StringWriter:<init>	()V
        //   7: astore_2
        //   8: sipush 2048
        //   11: newarray <illegal type>
        //   13: astore_3
        //   14: new 51	java/io/BufferedReader
        //   17: dup
        //   18: new 53	java/io/InputStreamReader
        //   21: dup
        //   22: aload_0
        //   23: ldc 55
        //   25: invokespecial 58	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
        //   28: invokespecial 61	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   31: astore 4
        //   33: aload 4
        //   35: aload_3
        //   36: invokevirtual 67	java/io/Reader:read	([C)I
        //   39: istore_1
        //   40: iload_1
        //   41: iconst_m1
        //   42: if_icmpne +12 -> 54
        //   45: aload_0
        //   46: invokevirtual 72	java/io/InputStream:close	()V
        //   49: aload_2
        //   50: invokevirtual 76	java/lang/Object:toString	()Ljava/lang/String;
        //   53: areturn
        //   54: aload_2
        //   55: aload_3
        //   56: iconst_0
        //   57: iload_1
        //   58: invokevirtual 82	java/io/Writer:write	([CII)V
        //   61: goto -28 -> 33
        //   64: astore_2
        //   65: aload_0
        //   66: invokevirtual 72	java/io/InputStream:close	()V
        //   69: aload_2
        //   70: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	71	0	paramInputStream	java.io.InputStream
        //   39	19	1	i	int
        //   7	48	2	localStringWriter	java.io.StringWriter
        //   64	6	2	localObject	Object
        //   13	43	3	arrayOfChar	char[]
        //   31	3	4	localBufferedReader	java.io.BufferedReader
        // Exception table:
        //   from	to	target	type
        //   14	33	64	finally
        //   33	40	64	finally
        //   54	61	64	finally
    }

    public static void flurryTrackEvent(Context paramContext, String paramString) {
        try {
            int i = TapatalkIdFactory.getTapatalkId(paramContext).getAuid();
            if (i != -1) {
                paramContext = new HashMap();
                paramContext.put("tapatalkid", i);
                FlurryAgent.logEvent(paramString, paramContext);
                return;
            }
            FlurryAgent.logEvent(paramString);
            return;
        } catch (Exception paramContext) {
        }
    }

    public static void flurryTrackEvent(String paramString) {
        try {
            FlurryAgent.logEvent(paramString);
            return;
        } catch (Exception paramString) {
        }
    }

    public static void setComScoreContext(Context paramContext) {
    }

    public static void start(Activity paramActivity) {
        if (paramActivity.getResources().getBoolean(2131558401)) {
            "".length();
        }
        if (!paramActivity.getResources().getBoolean(2131558401)) {
            FlurryAgent.onStartSession(paramActivity, "CFHZ9XB39BD8B8TKYKVY");
            FlurryAgent.setLogEnabled(true);
        }
    }

    public static void stop(Activity paramActivity) {
        if (!paramActivity.getResources().getBoolean(2131558401)) {
            FlurryAgent.onEndSession(paramActivity);
        }
        if (paramActivity.getResources().getBoolean(2131558401)) {
            "".length();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/CustomTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */