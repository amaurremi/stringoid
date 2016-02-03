package com.quoord.tapatalkpro.dev;

import android.app.Activity;
import android.content.res.Resources;
import com.quoord.tapatalkpro.util.CrashLogHandler;

public class DebugModeUtil {
    public static void opCrashEmial(Activity paramActivity) {
        if (paramActivity.getResources().getBoolean(2131558410)) {
            Thread.setDefaultUncaughtExceptionHandler(CrashLogHandler.createHandler(paramActivity));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/dev/DebugModeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */