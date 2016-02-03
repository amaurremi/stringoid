package mobi.ifunny.social.auth.d;

import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyOAuthRequest;
import mobi.ifunny.social.auth.n;
import mobi.ifunny.social.auth.x;
import mobi.ifunny.social.b.b;

public class j
        extends d {
    protected final int f = 6;
    private final String g = "TASK_LOGIN_IFUNNY_TWITTER";

    private void b(n paramn) {
        if (this.b != 0) {
            b();
            return;
        }
        this.b = 6;
        b localb = b.a();
        IFunnyOAuthRequest.getTokenByTwitter(this, "TASK_LOGIN_IFUNNY_TWITTER", paramn.a, localb.b(), localb.c(), new k(paramn));
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

    protected void a(g paramg) {
        super.a(paramg);
        b(paramg.b());
    }

    public void a(boolean paramBoolean) {
        d();
        b(paramBoolean);
    }

    protected void b() {
        if (this.b != 6) {
            a(new String[]{"TASK_LOGIN_IFUNNY_TWITTER"});
        }
        j().n();
        super.b();
    }

    protected String h() {
        return "twitter";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */