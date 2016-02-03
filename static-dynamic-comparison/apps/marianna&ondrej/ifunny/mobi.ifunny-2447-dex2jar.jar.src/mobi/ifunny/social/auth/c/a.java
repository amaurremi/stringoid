package mobi.ifunny.social.auth.c;

import mobi.ifunny.rest.content.AccessToken;
import mobi.ifunny.social.auth.l;
import mobi.ifunny.social.auth.n;
import mobi.ifunny.social.auth.t;

public class a
        extends t {
    protected void a(String paramString1, String paramString2, n paramn) {
        super.a(paramString1, paramString2, paramn);
        this.b = 0;
    }

    protected void a(AccessToken paramAccessToken) {
        l.a().a(getActivity(), paramAccessToken, 2);
    }

    protected void b() {
        super.b();
        this.b = 0;
    }

    protected int f() {
        return 2131689671;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */