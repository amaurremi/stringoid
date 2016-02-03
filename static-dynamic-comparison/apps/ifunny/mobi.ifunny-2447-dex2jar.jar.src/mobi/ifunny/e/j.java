package mobi.ifunny.e;

import android.net.Uri;
import mobi.ifunny.l.e;
import mobi.ifunny.l.f;
import mobi.ifunny.util.a.a;
import mobi.ifunny.util.cache.m;

public final class j<T extends e, R>
        extends f<T, Uri, Integer, m<R>> {
    private a a;
    private h<T, R> b;
    private g<R> c;

    public j(T paramT, String paramString, a parama, h<T, R> paramh, g<R> paramg) {
        super(paramT, paramString);
        this.a = parama;
        this.b = paramh;
        this.c = paramg;
    }

    protected m<R> a(Uri... paramVarArgs) {
        paramVarArgs = paramVarArgs[0];
        paramVarArgs = this.c.b(paramVarArgs, this.a);
        m localm = new m();
        localm.a = paramVarArgs;
        return localm;
    }

    protected void a(T paramT) {
        super.onStarted(paramT);
        this.b.a(paramT);
    }

    protected void a(T paramT, m<R> paramm) {
        super.onPostExecute(paramT, paramm);
        if ((paramm != null) && (paramm.a != null)) {
            this.b.a(paramT, paramm);
            return;
        }
        this.b.b(paramT);
    }

    protected void a(T paramT, Integer... paramVarArgs) {
        super.onProgressUpdate(paramT, paramVarArgs);
        this.b.a(paramT, paramVarArgs[0].intValue());
    }

    protected void b(T paramT) {
        super.onFinished(paramT);
        this.b.c(paramT);
    }

    protected void b(T paramT, m<R> paramm) {
        super.onCancelled(paramT, paramm);
        this.b.b(paramT, paramm);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/e/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */