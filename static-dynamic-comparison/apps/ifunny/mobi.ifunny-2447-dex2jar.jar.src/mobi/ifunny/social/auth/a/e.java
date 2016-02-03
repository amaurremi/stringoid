package mobi.ifunny.social.auth.a;

import com.facebook.FacebookOperationCanceledException;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;

class e
        implements Session.StatusCallback {
    e(d paramd) {
    }

    public void call(Session paramSession, SessionState paramSessionState, Exception paramException) {
        if (paramSession != Session.getActiveSession()) {
        }
        do {
            do {
                return;
                if (!paramSession.isOpened()) {
                    break;
                }
            } while (d.a(this.a) != 1);
            d.a(this.a, 0);
            d.b(this.a);
            return;
        }
        while (((!paramSessionState.equals(SessionState.CLOSED_LOGIN_FAILED)) && (!paramSessionState.equals(SessionState.CLOSED))) || (1 != d.c(this.a)));
        if ((paramException instanceof FacebookOperationCanceledException)) {
            this.a.b();
            return;
        }
        paramSession = d.a(this.a, paramException, 2131689939);
        d.a(this.a, paramSession);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */