package mobi.ifunny.social.auth.d;

import android.text.TextUtils;
import mobi.ifunny.rest.content.AccessToken;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;
import mobi.ifunny.social.auth.n;

public class k
        extends SimpleRestHttpHandler<AccessToken, j> {
    private n a;

    public k(n paramn) {
        this.a = paramn;
    }

    public void a(j paramj, Throwable paramThrowable) {
        super.onExceptionCallback(paramj, paramThrowable);
        j.a(paramj);
    }

    public void a(j paramj, AccessToken paramAccessToken) {
        if ((paramAccessToken == null) || (TextUtils.isEmpty(paramAccessToken.access_token)) || (paramAccessToken.expires_in <= 0L)) {
            j.a(paramj, 2131689594);
            return;
        }
        j.a(paramj, paramAccessToken);
    }

    public void a(j paramj, RestError paramRestError) {
        paramj.a(paramRestError.error, paramRestError.errorMessage, this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */