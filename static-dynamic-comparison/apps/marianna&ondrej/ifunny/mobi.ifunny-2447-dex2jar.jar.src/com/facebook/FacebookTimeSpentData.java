package com.facebook;

import android.os.Bundle;
import com.facebook.internal.Logger;

import java.io.Serializable;

class FacebookTimeSpentData
        implements Serializable {
    private static final long APP_ACTIVATE_SUPPRESSION_PERIOD_IN_MILLISECONDS = 300000L;
    private static final long FIRST_TIME_LOAD_RESUME_TIME = -1L;
    private static final long[] INACTIVE_SECONDS_QUANTA = {300000L, 900000L, 1800000L, 3600000L, 21600000L, 43200000L, 86400000L, 172800000L, 259200000L, 604800000L, 1209600000L, 1814400000L, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};
    private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000L;
    private static final long NUM_MILLISECONDS_IDLE_TO_BE_NEW_SESSION = 60000L;
    private static final String TAG = AppEventsLogger.class.getCanonicalName();
    private static final long serialVersionUID = 1L;
    private String firstOpenSourceApplication;
    private int interruptionCount;
    private boolean isAppActive;
    private boolean isWarmLaunch;
    private long lastActivateEventLoggedTime;
    private long lastResumeTime;
    private long lastSuspendTime;
    private long millisecondsSpentInSession;

    FacebookTimeSpentData() {
        resetSession();
    }

    private FacebookTimeSpentData(long paramLong1, long paramLong2, long paramLong3, int paramInt) {
        resetSession();
        this.lastResumeTime = paramLong1;
        this.lastSuspendTime = paramLong2;
        this.millisecondsSpentInSession = paramLong3;
        this.interruptionCount = paramInt;
    }

    private FacebookTimeSpentData(long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString) {
        resetSession();
        this.lastResumeTime = paramLong1;
        this.lastSuspendTime = paramLong2;
        this.millisecondsSpentInSession = paramLong3;
        this.interruptionCount = paramInt;
        this.firstOpenSourceApplication = paramString;
    }

    private static int getQuantaIndex(long paramLong) {
        int i = 0;
        while ((i < INACTIVE_SECONDS_QUANTA.length) && (INACTIVE_SECONDS_QUANTA[i] < paramLong)) {
            i += 1;
        }
        return i;
    }

    private boolean isColdLaunch() {
        if (!this.isWarmLaunch) {
        }
        for (boolean bool = true; ; bool = false) {
            this.isWarmLaunch = true;
            return bool;
        }
    }

    private void logAppDeactivatedEvent(AppEventsLogger paramAppEventsLogger, long paramLong) {
        Bundle localBundle = new Bundle();
        localBundle.putInt("fb_mobile_app_interruptions", this.interruptionCount);
        localBundle.putString("fb_mobile_time_between_sessions", String.format("session_quanta_%d", new Object[]{Integer.valueOf(getQuantaIndex(paramLong))}));
        localBundle.putString("fb_mobile_launch_source", this.firstOpenSourceApplication);
        paramAppEventsLogger.logEvent("fb_mobile_deactivate_app", this.millisecondsSpentInSession / 1000L, localBundle);
        resetSession();
    }

    private void resetSession() {
        this.isAppActive = false;
        this.lastResumeTime = -1L;
        this.lastSuspendTime = -1L;
        this.interruptionCount = 0;
        this.millisecondsSpentInSession = 0L;
    }

    private boolean wasSuspendedEver() {
        return this.lastSuspendTime != -1L;
    }

    private Object writeReplace() {
        return new FacebookTimeSpentData.SerializationProxyV2(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication);
    }

    void onResume(AppEventsLogger paramAppEventsLogger, long paramLong, String paramString) {
        long l2 = 0L;
        if ((isColdLaunch()) || (paramLong - this.lastActivateEventLoggedTime > 300000L)) {
            Bundle localBundle = new Bundle();
            localBundle.putString("fb_mobile_launch_source", paramString);
            paramAppEventsLogger.logEvent("fb_mobile_activate_app", localBundle);
            this.lastActivateEventLoggedTime = paramLong;
        }
        if (this.isAppActive) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Resume for active app");
            return;
        }
        long l1;
        if (wasSuspendedEver()) {
            l1 = paramLong - this.lastSuspendTime;
            if (l1 >= 0L) {
                break label178;
            }
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
            l1 = l2;
        }
        label178:
        for (; ; ) {
            if (l1 > 60000L) {
                logAppDeactivatedEvent(paramAppEventsLogger, l1);
            }
            for (; ; ) {
                if (this.interruptionCount == 0) {
                    this.firstOpenSourceApplication = paramString;
                }
                this.lastResumeTime = paramLong;
                this.isAppActive = true;
                return;
                l1 = 0L;
                break;
                if (l1 > 1000L) {
                    this.interruptionCount += 1;
                }
            }
        }
    }

    void onSuspend(AppEventsLogger paramAppEventsLogger, long paramLong) {
        long l1 = 0L;
        if (!this.isAppActive) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Suspend for inactive app");
            return;
        }
        long l2 = paramLong - this.lastResumeTime;
        if (l2 < 0L) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
        }
        for (; ; ) {
            this.millisecondsSpentInSession = (l1 + this.millisecondsSpentInSession);
            this.lastSuspendTime = paramLong;
            this.isAppActive = false;
            return;
            l1 = l2;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/FacebookTimeSpentData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */