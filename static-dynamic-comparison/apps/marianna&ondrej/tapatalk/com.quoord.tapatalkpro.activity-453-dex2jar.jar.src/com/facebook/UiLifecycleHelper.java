package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

public class UiLifecycleHelper {
    private static final String ACTIVITY_NULL_MESSAGE = "activity cannot be null";
    private final Activity activity;
    private final LocalBroadcastManager broadcastManager;
    private final Session.StatusCallback callback;
    private final BroadcastReceiver receiver;

    public UiLifecycleHelper(Activity paramActivity, Session.StatusCallback paramStatusCallback) {
        if (paramActivity == null) {
            throw new IllegalArgumentException("activity cannot be null");
        }
        this.activity = paramActivity;
        this.callback = paramStatusCallback;
        this.receiver = new ActiveSessionBroadcastReceiver(null);
        this.broadcastManager = LocalBroadcastManager.getInstance(paramActivity);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        Session localSession = Session.getActiveSession();
        if (localSession != null) {
            localSession.onActivityResult(this.activity, paramInt1, paramInt2, paramIntent);
        }
    }

    public void onCreate(Bundle paramBundle) {
        Session localSession = Session.getActiveSession();
        if (localSession == null) {
            if (paramBundle != null) {
                localSession = Session.restoreSession(this.activity, null, this.callback, paramBundle);
            }
            paramBundle = localSession;
            if (localSession == null) {
                paramBundle = new Session(this.activity);
            }
            Session.setActiveSession(paramBundle);
        }
    }

    public void onDestroy() {
    }

    public void onPause() {
        this.broadcastManager.unregisterReceiver(this.receiver);
        if (this.callback != null) {
            Session localSession = Session.getActiveSession();
            if (localSession != null) {
                localSession.removeCallback(this.callback);
            }
        }
    }

    public void onResume() {
        Object localObject = Session.getActiveSession();
        if (localObject != null) {
            if (this.callback != null) {
                ((Session) localObject).addCallback(this.callback);
            }
            if (SessionState.CREATED_TOKEN_LOADED.equals(((Session) localObject).getState())) {
                ((Session) localObject).openForRead(null);
            }
        }
        localObject = new IntentFilter();
        ((IntentFilter) localObject).addAction("com.facebook.sdk.ACTIVE_SESSION_SET");
        ((IntentFilter) localObject).addAction("com.facebook.sdk.ACTIVE_SESSION_UNSET");
        this.broadcastManager.registerReceiver(this.receiver, (IntentFilter) localObject);
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        Session.saveSession(Session.getActiveSession(), paramBundle);
    }

    private class ActiveSessionBroadcastReceiver
            extends BroadcastReceiver {
        private ActiveSessionBroadcastReceiver() {
        }

        public void onReceive(Context paramContext, Intent paramIntent) {
            if ("com.facebook.sdk.ACTIVE_SESSION_SET".equals(paramIntent.getAction())) {
                paramContext = Session.getActiveSession();
                if ((paramContext != null) && (UiLifecycleHelper.this.callback != null)) {
                    paramContext.addCallback(UiLifecycleHelper.this.callback);
                }
            }
            do {
                do {
                    return;
                } while (!"com.facebook.sdk.ACTIVE_SESSION_UNSET".equals(paramIntent.getAction()));
                paramContext = Session.getActiveSession();
            } while ((paramContext == null) || (UiLifecycleHelper.this.callback == null));
            paramContext.removeCallback(UiLifecycleHelper.this.callback);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/UiLifecycleHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */