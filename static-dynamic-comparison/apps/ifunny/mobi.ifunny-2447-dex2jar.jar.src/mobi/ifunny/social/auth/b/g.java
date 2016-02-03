package mobi.ifunny.social.auth.b;

import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyOAuthRequest;
import mobi.ifunny.social.auth.n;
import mobi.ifunny.social.auth.x;

public class g
        extends d {
    protected final int h = 5;
    private final String i = "TASK_LOGIN_IFUNNY_FACEBOOK";

    private void b(String paramString, n paramn) {
        if (this.b != 0) {
            b();
            return;
        }
        this.b = 5;
        IFunnyOAuthRequest.getTokenByGPlus(this, "TASK_LOGIN_IFUNNY_FACEBOOK", paramn.a, paramString, new h(paramn));
    }

    protected void a(String paramString1, String paramString2, n paramn) {
        super.a(paramString1, paramString2, paramn);
        j().a(paramString1, paramString2, paramn);
    }

    protected void a(String paramString, n paramn) {
        super.a(paramString, paramn);
        b(paramString, paramn);
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
        super.b();
        x localx = j();
        if (localx != null) {
            localx.n();
        }
    }

    protected String h() {
        return "gplus";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */