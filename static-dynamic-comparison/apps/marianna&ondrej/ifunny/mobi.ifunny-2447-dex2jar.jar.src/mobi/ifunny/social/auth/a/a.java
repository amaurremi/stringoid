package mobi.ifunny.social.auth.a;

import com.facebook.Session;
import mobi.ifunny.social.auth.n;

public class a
        extends d {
    protected void a(String paramString1, String paramString2, n paramn) {
        super.a(paramString1, paramString2, paramn);
        ((b) getTargetFragment()).b(paramString1, paramString2, paramn);
    }

    public void a(boolean paramBoolean) {
        b(paramBoolean);
    }

    protected void b() {
        ((b) getTargetFragment()).g();
        super.b();
    }

    protected void b(n paramn) {
        super.b(paramn);
        b localb = (b) getTargetFragment();
        Session localSession = Session.getActiveSession();
        if (localSession.isOpened()) {
            localb.b(paramn, localSession.getAccessToken());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */