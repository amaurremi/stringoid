package mobi.ifunny.profile;

import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

class y
        extends SimpleRestHttpHandler<Void, l> {
    public void a(l paraml, Throwable paramThrowable) {
        super.onExceptionCallback(paraml, paramThrowable);
        paraml.f();
    }

    public void a(l paraml, Void paramVoid) {
        paraml.e();
    }

    public void a(l paraml, RestError paramRestError) {
        super.onFailureCallback(paraml, paramRestError);
        paraml.f();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */