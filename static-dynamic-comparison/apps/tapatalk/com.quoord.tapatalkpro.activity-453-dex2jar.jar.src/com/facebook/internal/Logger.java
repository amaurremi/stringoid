package com.facebook.internal;

import android.util.Log;
import com.facebook.LoggingBehavior;
import com.facebook.Settings;

import java.util.HashMap;

public class Logger {
    public static final String LOG_TAG_BASE = "FacebookSDK.";
    private static final HashMap<String, String> stringsToReplace = new HashMap();
    private final LoggingBehavior behavior;
    private StringBuilder contents;
    private int priority = 3;
    private final String tag;

    public Logger(LoggingBehavior paramLoggingBehavior, String paramString) {
        Validate.notNullOrEmpty(paramString, "tag");
        this.behavior = paramLoggingBehavior;
        this.tag = ("FacebookSDK." + paramString);
        this.contents = new StringBuilder();
    }

    public static void log(LoggingBehavior paramLoggingBehavior, int paramInt, String paramString1, String paramString2) {
        if (Settings.isLoggingBehaviorEnabled(paramLoggingBehavior)) {
            String str = replaceStrings(paramString2);
            paramString2 = paramString1;
            if (!paramString1.startsWith("FacebookSDK.")) {
                paramString2 = "FacebookSDK." + paramString1;
            }
            Log.println(paramInt, paramString2, str);
            if (paramLoggingBehavior == LoggingBehavior.DEVELOPER_ERRORS) {
                new Exception().printStackTrace();
            }
        }
    }

    public static void log(LoggingBehavior paramLoggingBehavior, String paramString1, String paramString2) {
        log(paramLoggingBehavior, 3, paramString1, paramString2);
    }

    public static void log(LoggingBehavior paramLoggingBehavior, String paramString1, String paramString2, Object... paramVarArgs) {
        if (Settings.isLoggingBehaviorEnabled(paramLoggingBehavior)) {
            log(paramLoggingBehavior, 3, paramString1, String.format(paramString2, paramVarArgs));
        }
    }

    public static void registerAccessToken(String paramString) {
        try {
            if (!Settings.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                registerStringToReplace(paramString, "ACCESS_TOKEN_REMOVED");
            }
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    public static void registerStringToReplace(String paramString1, String paramString2) {
        try {
            stringsToReplace.put(paramString1, paramString2);
            return;
        } finally {
            paramString1 =finally;
            throw paramString1;
        }
    }

    /* Error */
    private static String replaceStrings(String paramString) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 27	com/facebook/internal/Logger:stringsToReplace	Ljava/util/HashMap;
        //   6: invokevirtual 119	java/util/HashMap:entrySet	()Ljava/util/Set;
        //   9: invokeinterface 125 1 0
        //   14: astore_2
        //   15: aload_2
        //   16: invokeinterface 131 1 0
        //   21: istore_1
        //   22: iload_1
        //   23: ifne +8 -> 31
        //   26: ldc 2
        //   28: monitorexit
        //   29: aload_0
        //   30: areturn
        //   31: aload_2
        //   32: invokeinterface 135 1 0
        //   37: checkcast 137	java/util/Map$Entry
        //   40: astore_3
        //   41: aload_0
        //   42: aload_3
        //   43: invokeinterface 140 1 0
        //   48: checkcast 142	java/lang/CharSequence
        //   51: aload_3
        //   52: invokeinterface 145 1 0
        //   57: checkcast 142	java/lang/CharSequence
        //   60: invokevirtual 149	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //   63: astore_0
        //   64: goto -49 -> 15
        //   67: astore_0
        //   68: ldc 2
        //   70: monitorexit
        //   71: aload_0
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	paramString	String
        //   21	2	1	bool	boolean
        //   14	18	2	localIterator	java.util.Iterator
        //   40	12	3	localEntry	java.util.Map.Entry
        // Exception table:
        //   from	to	target	type
        //   3	15	67	finally
        //   15	22	67	finally
        //   31	64	67	finally
    }

    private boolean shouldLog() {
        return Settings.isLoggingBehaviorEnabled(this.behavior);
    }

    public void append(String paramString) {
        if (shouldLog()) {
            this.contents.append(paramString);
        }
    }

    public void append(String paramString, Object... paramVarArgs) {
        if (shouldLog()) {
            this.contents.append(String.format(paramString, paramVarArgs));
        }
    }

    public void append(StringBuilder paramStringBuilder) {
        if (shouldLog()) {
            this.contents.append(paramStringBuilder);
        }
    }

    public void appendKeyValue(String paramString, Object paramObject) {
        append("  %s:\t%s\n", new Object[]{paramString, paramObject});
    }

    public String getContents() {
        return replaceStrings(this.contents.toString());
    }

    public int getPriority() {
        return this.priority;
    }

    public void log() {
        logString(this.contents.toString());
        this.contents = new StringBuilder();
    }

    public void logString(String paramString) {
        log(this.behavior, this.priority, this.tag, paramString);
    }

    public void setPriority(int paramInt) {
        Validate.oneOf(Integer.valueOf(paramInt), "value", new Object[]{Integer.valueOf(7), Integer.valueOf(3), Integer.valueOf(6), Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(5)});
        this.priority = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/internal/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */