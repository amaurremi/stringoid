package com.wbtech.ums.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class ReadErrorLog
        extends Thread {
    Context context = null;

    public ReadErrorLog(Context paramContext) {
        this.context = paramContext;
    }

    public void run() {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable) {
                Object localObject = new StringWriter();
                paramAnonymousThread = new PrintWriter((Writer) localObject);
                paramAnonymousThrowable.printStackTrace(paramAnonymousThread);
                localObject = ((StringWriter) localObject).toString();
                paramAnonymousThrowable = ReadErrorLog.this.context.getSharedPreferences("error", 0);
                localObject = paramAnonymousThrowable.getString("info", "") + (String) localObject + "\n";
                paramAnonymousThrowable.edit().putString("info", (String) localObject).commit();
                paramAnonymousThread.close();
            }
        });
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/wbtech/ums/common/ReadErrorLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */