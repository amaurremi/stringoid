package mobi.ifunny.social.auth.c;

import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyOAuthRequest;
import mobi.ifunny.social.auth.AuthHelper.AuthInfo;
import mobi.ifunny.social.auth.l;
import mobi.ifunny.social.auth.n;
import mobi.ifunny.social.auth.x;

public class b
        extends a {
    protected void a(String paramString1, String paramString2, n paramn) {
        super.a(paramString1, paramString2, paramn);
        j().a(paramString1, paramString2, paramn);
    }

    protected void a(User paramUser) {
        super.a(paramUser);
        e();
        j().a(this.e, paramUser);
    }

    public void a(AuthHelper.AuthInfo paramAuthInfo) {
        if (this.b != 0) {
            b();
            return;
        }
        d();
        l.a().b(getActivity());
        this.b = 1;
        n localn = new n();
        localn.b = paramAuthInfo.a;
        IFunnyOAuthRequest.getTokenByPassword(this, "TASK_IFUNNY_LOGIN", paramAuthInfo.b, paramAuthInfo.c, new c(localn));
    }

    protected void b() {
        if (this.b != 1) {
            a(new String[]{"TASK_IFUNNY_LOGIN"});
        }
        j().n();
        super.b();
    }

    protected String h() {
        return "password";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */