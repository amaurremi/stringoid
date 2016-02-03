package mobi.ifunny.userlists;

import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

class j
        extends SimpleRestHttpHandler<Void, g> {
    private final String a;

    private j(String paramString) {
        this.a = paramString;
    }

    public void a(g paramg) {
        super.onStartCallback(paramg);
        g.c(paramg, this.a);
    }

    public void a(g paramg, Throwable paramThrowable) {
        g.d(paramg, this.a);
    }

    public void a(g paramg, Void paramVoid) {
    }

    public void a(g paramg, RestError paramRestError) {
        g.d(paramg, this.a);
    }

    public void b(g paramg) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/userlists/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */