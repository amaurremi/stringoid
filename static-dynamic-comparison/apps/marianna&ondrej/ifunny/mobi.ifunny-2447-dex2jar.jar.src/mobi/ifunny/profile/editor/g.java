package mobi.ifunny.profile.editor;

import mobi.ifunny.rest.content.NickAvailability;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class g
        extends SimpleRestHttpHandler<NickAvailability, b> {
    public void a(b paramb, Throwable paramThrowable) {
        super.onExceptionCallback(paramb, paramThrowable);
        b.f(paramb);
    }

    public void a(b paramb, NickAvailability paramNickAvailability) {
        if (paramNickAvailability.available) {
            b.g(paramb);
            return;
        }
        b.f(paramb);
    }

    public void a(b paramb, RestError paramRestError) {
        super.onFailureCallback(paramb, paramRestError);
        b.f(paramb);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/editor/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */