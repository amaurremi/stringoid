package mobi.ifunny.social.auth.c;

import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Users;
import mobi.ifunny.social.auth.AuthHelper.AuthInfo;
import mobi.ifunny.social.auth.n;
import mobi.ifunny.social.auth.y;

public class e
        extends a {
    protected final int f = 3;
    private final String g = "REGISTER_PASSWORD_TASK";

    private void a(RestError paramRestError) {
        if (paramRestError != null) {
            a(paramRestError.error, g(), null);
            return;
        }
        a(g());
    }

    private void o() {
        this.b = 3;
    }

    private void p() {
        k().b();
    }

    private void q() {
        this.b = 0;
        e();
    }

    protected void a(String paramString1, String paramString2, n paramn) {
        super.a(paramString1, paramString2, paramn);
        k().a(paramString1, paramString2);
    }

    public void a(AuthHelper.AuthInfo paramAuthInfo) {
        d();
        IFunnyRestRequest.Users.registerPassword(this, "REGISTER_PASSWORD_TASK", paramAuthInfo.a, paramAuthInfo.b, paramAuthInfo.c, new g(null));
    }

    protected void b() {
        if (this.b != 3) {
            a(new String[]{"REGISTER_PASSWORD_TASK"});
        }
        k().P_();
        super.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */