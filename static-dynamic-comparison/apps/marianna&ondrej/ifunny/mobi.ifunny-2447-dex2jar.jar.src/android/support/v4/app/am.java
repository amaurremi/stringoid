package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class am
        extends al {
    public Intent a(Activity paramActivity) {
        Intent localIntent2 = an.a(paramActivity);
        Intent localIntent1 = localIntent2;
        if (localIntent2 == null) {
            localIntent1 = b(paramActivity);
        }
        return localIntent1;
    }

    public String a(Context paramContext, ActivityInfo paramActivityInfo) {
        String str2 = an.a(paramActivityInfo);
        String str1 = str2;
        if (str2 == null) {
            str1 = super.a(paramContext, paramActivityInfo);
        }
        return str1;
    }

    public boolean a(Activity paramActivity, Intent paramIntent) {
        return an.a(paramActivity, paramIntent);
    }

    Intent b(Activity paramActivity) {
        return super.a(paramActivity);
    }

    public void b(Activity paramActivity, Intent paramIntent) {
        an.b(paramActivity, paramIntent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */