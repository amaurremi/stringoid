package mobi.ifunny.social.auth;

import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

class v
        extends SimpleRestHttpHandler<User, t> {
    public void a(t paramt, Throwable paramThrowable) {
        paramt.c();
    }

    public void a(t paramt, RestError paramRestError) {
        paramt.a(paramRestError.error, paramRestError.errorMessage, null);
    }

    public void a(t paramt, User paramUser) {
        paramt.a(paramUser);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */