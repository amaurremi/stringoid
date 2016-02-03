package com.facebook.internal;

import android.util.Log;
import com.facebook.LoggingBehavior;
import com.facebook.Settings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

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

    private static String replaceStrings(String paramString) {
        try {
            Iterator localIterator = stringsToReplace.entrySet().iterator();
            while (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                paramString = paramString.replace((CharSequence) localEntry.getKey(), (CharSequence) localEntry.getValue());
            }
            return paramString;
        } finally {
        }
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */