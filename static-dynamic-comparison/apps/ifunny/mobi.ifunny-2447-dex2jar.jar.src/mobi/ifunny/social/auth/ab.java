package mobi.ifunny.social.auth;

import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

public class ab
        extends SimpleRestHttpHandler<Object, aa> {
    public void a(aa paramaa, Object paramObject) {
        paramaa.j();
    }

    public void a(aa paramaa, Throwable paramThrowable) {
        super.onExceptionCallback(paramaa, paramThrowable);
        paramaa.c();
    }

    public void a(aa paramaa, RestError paramRestError) {
        paramaa.a(paramRestError.error, paramRestError.errorMessage, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */