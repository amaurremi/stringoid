package mobi.ifunny.social.auth.a;

import android.text.TextUtils;
import mobi.ifunny.rest.content.AccessToken;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;
import mobi.ifunny.social.auth.n;

public class j
        extends SimpleRestHttpHandler<AccessToken, i> {
    private n a;

    public j(n paramn) {
        this.a = paramn;
    }

    public void a(i parami, Throwable paramThrowable) {
        super.onExceptionCallback(parami, paramThrowable);
        i.a(parami);
    }

    public void a(i parami, AccessToken paramAccessToken) {
        if ((paramAccessToken == null) || (TextUtils.isEmpty(paramAccessToken.access_token)) || (paramAccessToken.expires_in <= 0L)) {
            i.a(parami, 2131689584);
            return;
        }
        i.a(parami, paramAccessToken);
    }

    public void a(i parami, RestError paramRestError) {
        i.a(parami, paramRestError.error, 2131689594, this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */