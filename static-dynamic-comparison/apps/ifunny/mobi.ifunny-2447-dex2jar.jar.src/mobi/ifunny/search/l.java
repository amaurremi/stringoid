package mobi.ifunny.search;

import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

class l
        extends SimpleRestHttpHandler<Void, i> {
    private int a;

    private l(int paramInt) {
        this.a = paramInt;
    }

    public void a(i parami) {
    }

    public void a(i parami, Throwable paramThrowable) {
        super.onExceptionCallback(parami, paramThrowable);
        i.b(parami, this.a);
    }

    public void a(i parami, Void paramVoid) {
    }

    public void a(i parami, RestError paramRestError) {
        super.onFailureCallback(parami, paramRestError);
        i.b(parami, this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/search/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */