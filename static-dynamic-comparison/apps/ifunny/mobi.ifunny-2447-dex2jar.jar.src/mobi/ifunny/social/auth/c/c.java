package mobi.ifunny.social.auth.c;

import android.text.TextUtils;
import mobi.ifunny.rest.content.AccessToken;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;
import mobi.ifunny.social.auth.n;

public class c
        extends SimpleRestHttpHandler<AccessToken, b> {
    private n a;

    public c(n paramn) {
        this.a = paramn;
    }

    public void a(b paramb, Throwable paramThrowable) {
        super.onExceptionCallback(paramb, paramThrowable);
        b.a(paramb);
    }

    public void a(b paramb, AccessToken paramAccessToken) {
        if ((paramAccessToken == null) || (TextUtils.isEmpty(paramAccessToken.access_token)) || (paramAccessToken.expires_in <= 0L)) {
            b.a(paramb, null, 2131689584, null);
            return;
        }
        b.a(paramb, paramAccessToken);
    }

    public void a(b paramb, RestError paramRestError) {
        b.b(paramb, paramRestError.error, 2131689594, this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */