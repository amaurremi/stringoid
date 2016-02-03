package mobi.ifunny.profile;

import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

class z
        extends SimpleRestHttpHandler<Void, l> {
    public void a(l paraml, Throwable paramThrowable) {
        super.onExceptionCallback(paraml, paramThrowable);
        paraml.h();
    }

    public void a(l paraml, Void paramVoid) {
        paraml.g();
    }

    public void a(l paraml, RestError paramRestError) {
        super.onFailureCallback(paraml, paramRestError);
        paraml.h();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */