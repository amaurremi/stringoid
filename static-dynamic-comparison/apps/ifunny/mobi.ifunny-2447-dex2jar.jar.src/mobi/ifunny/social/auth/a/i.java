package mobi.ifunny.social.auth.a;

import com.facebook.Session;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyOAuthRequest;
import mobi.ifunny.social.auth.n;
import mobi.ifunny.social.auth.x;

public class i
        extends d {
    protected final int h = 5;
    private final String i = "TASK_LOGIN_IFUNNY_FACEBOOK";

    private void c(n paramn) {
        if (this.b != 0) {
            b();
            return;
        }
        this.b = 5;
        Session localSession = Session.getActiveSession();
        IFunnyOAuthRequest.getTokenByFacebook(this, "TASK_LOGIN_IFUNNY_FACEBOOK", paramn.a, localSession.getAccessToken(), new j(paramn));
    }

    protected void a(String paramString1, String paramString2, n paramn) {
        super.a(paramString1, paramString2, paramn);
        j().a(paramString1, paramString2, paramn);
    }

    protected void a(User paramUser) {
        super.a(paramUser);
        e();
        j().a(this.e, paramUser);
    }

    public void a(boolean paramBoolean) {
        d();
        b(paramBoolean);
    }

    protected void b() {
        if (this.b != 5) {
            a(new String[]{"TASK_LOGIN_IFUNNY_FACEBOOK"});
        }
        x localx = j();
        if (localx != null) {
            localx.n();
        }
        super.b();
    }

    protected void b(n paramn) {
        super.b(paramn);
        c(paramn);
    }

    protected String h() {
        return "facebook";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */