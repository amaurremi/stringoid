package mobi.ifunny.social.auth.b;

import android.text.TextUtils;
import mobi.ifunny.rest.content.AccessToken;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;
import mobi.ifunny.social.auth.n;

public class h
        extends SimpleRestHttpHandler<AccessToken, g> {
    private n a;

    public h(n paramn) {
        this.a = paramn;
    }

    public void a(g paramg, Throwable paramThrowable) {
        super.onExceptionCallback(paramg, paramThrowable);
        g.a(paramg);
    }

    public void a(g paramg, AccessToken paramAccessToken) {
        if ((paramAccessToken == null) || (TextUtils.isEmpty(paramAccessToken.access_token)) || (paramAccessToken.expires_in <= 0L)) {
            g.a(paramg, 2131689594);
            return;
        }
        g.a(paramg, paramAccessToken);
    }

    public void a(g paramg, RestError paramRestError) {
        g.a(paramg, paramRestError.error, 2131689594, this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */