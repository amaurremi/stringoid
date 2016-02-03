package mobi.ifunny.profile.editor;

import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class j
        extends SimpleRestHttpHandler<Void, b> {
    public void a(b paramb, Void paramVoid) {
        b.j(paramb);
    }

    public void a(b paramb, RestError paramRestError) {
        super.onFailureCallback(paramb, paramRestError);
        paramb.d();
        b.k(paramb);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/editor/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */