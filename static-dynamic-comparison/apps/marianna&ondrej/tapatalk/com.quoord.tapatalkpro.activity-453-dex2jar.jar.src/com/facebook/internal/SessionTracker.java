package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;

public class SessionTracker {
    private final LocalBroadcastManager broadcastManager;
    private final Session.StatusCallback callback;
    private boolean isTracking = false;
    private final BroadcastReceiver receiver;
    private Session session;

    public SessionTracker(Context paramContext, Session.StatusCallback paramStatusCallback) {
        this(paramContext, paramStatusCallback, null);
    }

    SessionTracker(Context paramContext, Session.StatusCallback paramStatusCallback, Session paramSession) {
        this(paramContext, paramStatusCallback, paramSession, true);
    }

    public SessionTracker(Context paramContext, Session.StatusCallback paramStatusCallback, Session paramSession, boolean paramBoolean) {
        this.callback = new CallbackWrapper(paramStatusCallback);
        this.session = paramSession;
        this.receiver = new ActiveSessionBroadcastReceiver(null);
        this.broadcastManager = LocalBroadcastManager.getInstance(paramContext);
        if (paramBoolean) {
            startTracking();
        }
    }

    private void addBroadcastReceiver() {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_SET");
        localIntentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_UNSET");
        this.broadcastManager.registerReceiver(this.receiver, localIntentFilter);
    }

    public Session getOpenSession() {
        Session localSession = getSession();
        if ((localSession != null) && (localSession.isOpened())) {
            return localSession;
        }
        return null;
    }

    public Session getSession() {
        if (this.session == null) {
            return Session.getActiveSession();
        }
        return this.session;
    }

    public boolean isTracking() {
        return this.isTracking;
    }

    public boolean isTrackingActiveSession() {
        return this.session == null;
    }

    public void setSession(Session paramSession) {
        if (paramSession == null) {
            if (this.session != null) {
                this.session.removeCallback(this.callback);
                this.session = null;
                addBroadcastReceiver();
                if (getSession() != null) {
                    getSession().addCallback(this.callback);
                }
            }
            return;
        }
        if (this.session == null) {
            Session localSession = Session.getActiveSession();
            if (localSession != null) {
                localSession.removeCallback(this.callback);
            }
            this.broadcastManager.unregisterReceiver(this.receiver);
        }
        for (; ; ) {
            this.session = paramSession;
            this.session.addCallback(this.callback);
            return;
            this.session.removeCallback(this.callback);
        }
    }

    public void startTracking() {
        if (this.isTracking) {
            return;
        }
        if (this.session == null) {
            addBroadcastReceiver();
        }
        if (getSession() != null) {
            getSession().addCallback(this.callback);
        }
        this.isTracking = true;
    }

    public void stopTracking() {
        if (!this.isTracking) {
            return;
        }
        Session localSession = getSession();
        if (localSession != null) {
            localSession.removeCallback(this.callback);
        }
        this.broadcastManager.unregisterReceiver(this.receiver);
        this.isTracking = false;
    }

    private class ActiveSessionBroadcastReceiver
            extends BroadcastReceiver {
        private ActiveSessionBroadcastReceiver() {
        }

        public void onReceive(Context paramContext, Intent paramIntent) {
            if ("com.facebook.sdk.ACTIVE_SESSION_SET".equals(paramIntent.getAction())) {
                paramContext = Session.getActiveSession();
                if (paramContext != null) {
                    paramContext.addCallback(SessionTracker.this.callback);
                }
            }
        }
    }

    private class CallbackWrapper
            implements Session.StatusCallback {
        private final Session.StatusCallback wrapped;

        public CallbackWrapper(Session.StatusCallback paramStatusCallback) {
            this.wrapped = paramStatusCallback;
        }

        public void call(Session paramSession, SessionState paramSessionState, Exception paramException) {
            if ((this.wrapped != null) && (SessionTracker.this.isTracking())) {
                this.wrapped.call(paramSession, paramSessionState, paramException);
            }
            if ((paramSession == SessionTracker.this.session) && (paramSessionState.isClosed())) {
                SessionTracker.this.setSession(null);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/internal/SessionTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */