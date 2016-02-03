package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;

import java.io.PrintWriter;
import java.io.StringWriter;

public class CrashLogHandler
        implements Thread.UncaughtExceptionHandler {
    private Activity _activity = null;

    public static CrashLogHandler createHandler(Activity paramActivity) {
        CrashLogHandler localCrashLogHandler = new CrashLogHandler();
        localCrashLogHandler._activity = paramActivity;
        return localCrashLogHandler;
    }

    public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
        Object localObject = this._activity.getPreferences(0);
        this._activity.getPreferences(0).edit();
        if (((SharedPreferences) localObject).getBoolean("send_crash", true)) {
            try {
                paramThread = new StringWriter();
                paramThrowable.printStackTrace(new PrintWriter(paramThread));
                localObject = new Intent("android.intent.action.SEND");
                ((Intent) localObject).setType("plain/text");
                paramThrowable = paramThread.toString();
                int j = 0;
                paramThread = paramThrowable;
                int i = j;
                try {
                    PackageInfo localPackageInfo = this._activity.getPackageManager().getPackageInfo(this._activity.getPackageName(), 0);
                    paramThread = paramThrowable;
                    i = j;
                    String str = localPackageInfo.versionName;
                    paramThread = paramThrowable;
                    i = j;
                    paramThrowable = paramThrowable + "versionName: " + str + "\n";
                    paramThread = paramThrowable;
                    i = j;
                    j = localPackageInfo.versionCode;
                    paramThread = paramThrowable;
                    i = j;
                    paramThrowable = paramThrowable + "versionCode: " + j + "\n";
                    paramThread = paramThrowable;
                    i = j;
                } catch (Exception paramThrowable) {
                    for (; ; ) {
                        paramThrowable.printStackTrace();
                    }
                }
                ((Intent) localObject).putExtra("android.intent.extra.EMAIL", new String[]{"tracelijing@tapatalk.com"});
                ((Intent) localObject).putExtra("android.intent.extra.SUBJECT", "tapatalk crashed " + i + "  " + (int) (Math.random() * 100000.0D));
                ((Intent) localObject).putExtra("android.intent.extra.TEXT", paramThread);
                this._activity.startActivity(Intent.createChooser((Intent) localObject, "send crash report"));
                this._activity.finish();
                Process.killProcess(Process.myPid());
                System.exit(10);
                return;
            } catch (Exception paramThread) {
                paramThread.printStackTrace();
                return;
            }
        }
        Thread.getDefaultUncaughtExceptionHandler().uncaughtException(paramThread, paramThrowable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/CrashLogHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */