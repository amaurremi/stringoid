package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class an {
    public static Intent a(Activity paramActivity) {
        return paramActivity.getParentActivityIntent();
    }

    public static String a(ActivityInfo paramActivityInfo) {
        return paramActivityInfo.parentActivityName;
    }

    public static boolean a(Activity paramActivity, Intent paramIntent) {
        return paramActivity.shouldUpRecreateTask(paramIntent);
    }

    public static void b(Activity paramActivity, Intent paramIntent) {
        paramActivity.navigateUpTo(paramIntent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */