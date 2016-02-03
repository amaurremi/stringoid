package mobi.ifunny.social.auth.d;

import mobi.ifunny.social.auth.n;
import twitter4j.auth.AccessToken;

public class a
        extends d {
    protected void a(String paramString1, String paramString2, n paramn) {
        super.a(paramString1, paramString2, paramn);
        ((b) getTargetFragment()).c(paramString1, paramString2, paramn);
    }

    protected void a(g paramg) {
        super.a(paramg);
        ((b) getTargetFragment()).a(paramg.b(), paramg.a().getToken(), paramg.a().getTokenSecret());
    }

    public void a(boolean paramBoolean) {
        b(paramBoolean);
    }

    protected void b() {
        ((b) getTargetFragment()).j();
        super.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */