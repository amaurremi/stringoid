package com.facebook.widget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.Session;
import com.facebook.Session.Builder;
import com.facebook.Session.OpenRequest;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.SessionTracker;

import java.util.Date;
import java.util.List;

public class FacebookFragment
        extends Fragment {
    private SessionTracker sessionTracker;

    private void openSession(String paramString, List<String> paramList, SessionLoginBehavior paramSessionLoginBehavior, int paramInt, SessionAuthorizationType paramSessionAuthorizationType) {
        Session localSession1;
        if (this.sessionTracker != null) {
            Session localSession2 = this.sessionTracker.getSession();
            if (localSession2 != null) {
                localSession1 = localSession2;
                if (!localSession2.getState().isClosed()) {
                }
            } else {
                localSession1 = new Session.Builder(getActivity()).setApplicationId(paramString).build();
                Session.setActiveSession(localSession1);
            }
            if (!localSession1.isOpened()) {
                paramString = new Session.OpenRequest(this).setPermissions(paramList).setLoginBehavior(paramSessionLoginBehavior).setRequestCode(paramInt);
                if (!SessionAuthorizationType.PUBLISH.equals(paramSessionAuthorizationType)) {
                    break label109;
                }
                localSession1.openForPublish(paramString);
            }
        }
        return;
        label109:
        localSession1.openForRead(paramString);
    }

    protected final void closeSession() {
        if (this.sessionTracker != null) {
            Session localSession = this.sessionTracker.getOpenSession();
            if (localSession != null) {
                localSession.close();
            }
        }
    }

    protected final void closeSessionAndClearTokenInformation() {
        if (this.sessionTracker != null) {
            Session localSession = this.sessionTracker.getOpenSession();
            if (localSession != null) {
                localSession.closeAndClearTokenInformation();
            }
        }
    }

    protected final String getAccessToken() {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (this.sessionTracker != null) {
            Session localSession = this.sessionTracker.getOpenSession();
            localObject1 = localObject2;
            if (localSession != null) {
                localObject1 = localSession.getAccessToken();
            }
        }
        return (String) localObject1;
    }

    protected final Date getExpirationDate() {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (this.sessionTracker != null) {
            Session localSession = this.sessionTracker.getOpenSession();
            localObject1 = localObject2;
            if (localSession != null) {
                localObject1 = localSession.getExpirationDate();
            }
        }
        return (Date) localObject1;
    }

    protected final Session getSession() {
        if (this.sessionTracker != null) {
            return this.sessionTracker.getSession();
        }
        return null;
    }

    protected final List<String> getSessionPermissions() {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (this.sessionTracker != null) {
            Session localSession = this.sessionTracker.getSession();
            localObject1 = localObject2;
            if (localSession != null) {
                localObject1 = localSession.getPermissions();
            }
        }
        return (List<String>) localObject1;
    }

    protected final SessionState getSessionState() {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (this.sessionTracker != null) {
            Session localSession = this.sessionTracker.getSession();
            localObject1 = localObject2;
            if (localSession != null) {
                localObject1 = localSession.getState();
            }
        }
        return (SessionState) localObject1;
    }

    protected final boolean isSessionOpen() {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (this.sessionTracker != null) {
            bool1 = bool2;
            if (this.sessionTracker.getOpenSession() != null) {
                bool1 = true;
            }
        }
        return bool1;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.sessionTracker = new SessionTracker(getActivity(), new DefaultSessionStatusCallback(null));
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        this.sessionTracker.getSession().onActivityResult(getActivity(), paramInt1, paramInt2, paramIntent);
    }

    public void onDestroy() {
        super.onDestroy();
        this.sessionTracker.stopTracking();
    }

    protected void onSessionStateChange(SessionState paramSessionState, Exception paramException) {
    }

    protected final void openSession() {
        openSessionForRead(null, null);
    }

    protected final void openSessionForPublish(String paramString, List<String> paramList) {
        openSessionForPublish(paramString, paramList, SessionLoginBehavior.SSO_WITH_FALLBACK, 64206);
    }

    protected final void openSessionForPublish(String paramString, List<String> paramList, SessionLoginBehavior paramSessionLoginBehavior, int paramInt) {
        openSession(paramString, paramList, paramSessionLoginBehavior, paramInt, SessionAuthorizationType.PUBLISH);
    }

    protected final void openSessionForRead(String paramString, List<String> paramList) {
        openSessionForRead(paramString, paramList, SessionLoginBehavior.SSO_WITH_FALLBACK, 64206);
    }

    protected final void openSessionForRead(String paramString, List<String> paramList, SessionLoginBehavior paramSessionLoginBehavior, int paramInt) {
        openSession(paramString, paramList, paramSessionLoginBehavior, paramInt, SessionAuthorizationType.READ);
    }

    public void setSession(Session paramSession) {
        if (this.sessionTracker != null) {
            this.sessionTracker.setSession(paramSession);
        }
    }

    private class DefaultSessionStatusCallback
            implements Session.StatusCallback {
        private DefaultSessionStatusCallback() {
        }

        public void call(Session paramSession, SessionState paramSessionState, Exception paramException) {
            FacebookFragment.this.onSessionStateChange(paramSessionState, paramException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/widget/FacebookFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */