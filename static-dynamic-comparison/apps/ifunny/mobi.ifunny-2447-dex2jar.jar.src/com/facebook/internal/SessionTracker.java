package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.v4.a.n;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;

public class SessionTracker {
    private final n broadcastManager;
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
        this.callback = new SessionTracker.CallbackWrapper(this, paramStatusCallback);
        this.session = paramSession;
        this.receiver = new SessionTracker.ActiveSessionBroadcastReceiver(this, null);
        this.broadcastManager = n.a(paramContext);
        if (paramBoolean) {
            startTracking();
        }
    }

    private void addBroadcastReceiver() {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_SET");
        localIntentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_UNSET");
        this.broadcastManager.a(this.receiver, localIntentFilter);
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
            this.broadcastManager.a(this.receiver);
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
        this.broadcastManager.a(this.receiver);
        this.isTracking = false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/SessionTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */