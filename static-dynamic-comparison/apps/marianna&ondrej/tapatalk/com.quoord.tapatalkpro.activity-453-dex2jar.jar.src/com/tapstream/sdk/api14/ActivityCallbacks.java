package com.tapstream.sdk.api14;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tapstream.sdk.ActivityEventSource;
import com.tapstream.sdk.ActivityEventSource.ActivityListener;

public class ActivityCallbacks
        extends ActivityEventSource
        implements Application.ActivityLifecycleCallbacks {
    private final Application app;
    private int startedActivities = -1;

    public ActivityCallbacks(Application paramApplication) {
        this.app = paramApplication;
        paramApplication.registerActivityLifecycleCallbacks(this);
    }

    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {
    }

    public void onActivityDestroyed(Activity paramActivity) {
    }

    public void onActivityPaused(Activity paramActivity) {
    }

    public void onActivityResumed(Activity paramActivity) {
    }

    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {
    }

    public void onActivityStarted(Activity paramActivity) {
        if (this.app == paramActivity.getApplication()) {
            try {
                this.startedActivities += 1;
                if ((this.startedActivities == 1) && (this.listener != null)) {
                    this.listener.onOpen();
                }
                return;
            } finally {
            }
        }
    }

    public void onActivityStopped(Activity paramActivity) {
        if (this.app == paramActivity.getApplication()) {
            try {
                this.startedActivities -= 1;
                if (this.startedActivities < 0) {
                    this.startedActivities = 0;
                }
                return;
            } finally {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/api14/ActivityCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */