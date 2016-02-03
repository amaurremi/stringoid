package mobi.ifunny.userlists;

import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

class i
        extends SimpleRestHttpHandler<Void, g> {
    private final String a;

    private i(String paramString) {
        this.a = paramString;
    }

    public void a(g paramg) {
        super.onStartCallback(paramg);
        g.a(paramg, this.a);
    }

    public void a(g paramg, Throwable paramThrowable) {
        super.onExceptionCallback(paramg, paramThrowable);
        g.b(paramg, this.a);
    }

    public void a(g paramg, Void paramVoid) {
    }

    public void a(g paramg, RestError paramRestError) {
        super.onFailureCallback(paramg, paramRestError);
        g.b(paramg, this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/userlists/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */