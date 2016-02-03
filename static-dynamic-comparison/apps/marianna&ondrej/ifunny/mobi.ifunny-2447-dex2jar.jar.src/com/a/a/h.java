package com.a.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

import java.lang.ref.WeakReference;

@TargetApi(14)
class h
        implements Application.ActivityLifecycleCallbacks, g {
    private WeakReference<Application> a;

    public void a(Application paramApplication) {
        if ((this.a != null) && (this.a.get() == paramApplication)) {
            return;
        }
        this.a = new WeakReference(paramApplication);
        paramApplication.registerActivityLifecycleCallbacks(this);
    }

    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {
    }

    public void onActivityDestroyed(Activity paramActivity) {
        c.c(paramActivity);
    }

    public void onActivityPaused(Activity paramActivity) {
    }

    public void onActivityResumed(Activity paramActivity) {
    }

    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {
    }

    public void onActivityStarted(Activity paramActivity) {
    }

    public void onActivityStopped(Activity paramActivity) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */