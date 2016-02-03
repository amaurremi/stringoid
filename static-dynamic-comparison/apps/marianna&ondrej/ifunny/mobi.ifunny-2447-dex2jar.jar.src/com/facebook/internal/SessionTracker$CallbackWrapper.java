package com.facebook.internal;

import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;

class SessionTracker$CallbackWrapper
        implements Session.StatusCallback {
    private final Session.StatusCallback wrapped;

    public SessionTracker$CallbackWrapper(SessionTracker paramSessionTracker, Session.StatusCallback paramStatusCallback) {
        this.wrapped = paramStatusCallback;
    }

    public void call(Session paramSession, SessionState paramSessionState, Exception paramException) {
        if ((this.wrapped != null) && (this.this$0.isTracking())) {
            this.wrapped.call(paramSession, paramSessionState, paramException);
        }
        if ((paramSession == SessionTracker.access$200(this.this$0)) && (paramSessionState.isClosed())) {
            this.this$0.setSession(null);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/SessionTracker$CallbackWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */