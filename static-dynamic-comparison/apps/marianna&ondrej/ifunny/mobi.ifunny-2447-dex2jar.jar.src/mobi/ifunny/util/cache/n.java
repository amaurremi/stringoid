package mobi.ifunny.util.cache;

import mobi.ifunny.l.h;
import mobi.ifunny.l.i;

public class n<T extends h, R>
        extends i<T, String, Integer, m<R>> {
    private final f<R> a;
    private final e b = new o(this);

    public n(T paramT, String paramString, f<R> paramf) {
        super(paramT, paramString);
        this.a = paramf;
    }

    protected m<R> a(String... paramVarArgs) {
        return a.a(paramVarArgs[0], this.a, this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/cache/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */