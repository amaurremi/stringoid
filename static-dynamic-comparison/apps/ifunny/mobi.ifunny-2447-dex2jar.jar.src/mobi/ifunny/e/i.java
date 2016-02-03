package mobi.ifunny.e;

import mobi.ifunny.util.cache.f;
import mobi.ifunny.util.cache.m;
import mobi.ifunny.util.cache.n;

public final class i<T extends mobi.ifunny.l.h, R>
        extends n<T, R> {
    private h<T, R> a;

    public i(T paramT, String paramString, f<R> paramf, h<T, R> paramh) {
        super(paramT, paramString, paramf);
        this.a = paramh;
    }

    protected void a(T paramT, m<R> paramm) {
        super.onPostExecute(paramT, paramm);
        if ((paramm != null) && (paramm.a != null)) {
            this.a.a(paramT, paramm);
            return;
        }
        this.a.b(paramT);
    }

    protected void a(T paramT, Integer... paramVarArgs) {
        super.onProgressUpdate(paramT, paramVarArgs);
        this.a.a(paramT, paramVarArgs[0].intValue());
    }

    protected void b(T paramT, m<R> paramm) {
        super.onCancelled(paramT, paramm);
        this.a.b(paramT, paramm);
    }

    protected void onFinished(T paramT) {
        super.onFinished(paramT);
        this.a.c(paramT);
    }

    protected void onStarted(T paramT) {
        super.onStarted(paramT);
        this.a.a(paramT);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/e/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */