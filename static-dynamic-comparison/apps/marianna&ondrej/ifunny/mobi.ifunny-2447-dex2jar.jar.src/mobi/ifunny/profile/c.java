package mobi.ifunny.profile;

import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class c
        extends SimpleRestHttpHandler<User, b> {
    public void a(b paramb, RestError paramRestError) {
        if (paramRestError.status == 403) {
            paramb.a(paramRestError);
            return;
        }
        super.onFailureCallback(paramb, paramRestError);
    }

    public void a(b paramb, User paramUser) {
        paramb.b(paramUser);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */