package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;

@ii
public class ac
        implements Application.ActivityLifecycleCallbacks {
    private Activity a;
    private Context b;
    private final Object c = new Object();

    public ac(Application paramApplication, Activity paramActivity) {
        paramApplication.registerActivityLifecycleCallbacks(this);
        a(paramActivity);
        this.b = paramApplication.getApplicationContext();
    }

    private void a(Activity paramActivity) {
        synchronized (this.c) {
            if (!paramActivity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.a = paramActivity;
            }
            return;
        }
    }

    public Activity a() {
        return this.a;
    }

    public Context b() {
        return this.b;
    }

    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {
    }

    public void onActivityDestroyed(Activity paramActivity) {
        synchronized (this.c) {
            if (this.a == null) {
                return;
            }
            if (this.a.equals(paramActivity)) {
                this.a = null;
            }
            return;
        }
    }

    public void onActivityPaused(Activity paramActivity) {
        a(paramActivity);
    }

    public void onActivityResumed(Activity paramActivity) {
        a(paramActivity);
    }

    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {
    }

    public void onActivityStarted(Activity paramActivity) {
        a(paramActivity);
    }

    public void onActivityStopped(Activity paramActivity) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */