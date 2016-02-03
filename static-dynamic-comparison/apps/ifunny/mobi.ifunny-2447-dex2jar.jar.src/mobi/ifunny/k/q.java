package mobi.ifunny.k;

import android.os.AsyncTask;
import android.os.SystemClock;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

import mobi.ifunny.util.a.a;

public final class q<K, D> {
    private p<K, D> a;
    private r<D> b;
    private AtomicBoolean c;
    private long d;
    private AtomicBoolean e;
    private AtomicBoolean f;

    public q(r<D> paramr) {
        this.b = paramr;
        this.c = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
    }

    private boolean a(boolean paramBoolean) {
        if (this.c.get()) {
            this.e.set(true);
            c().b();
            this.f.set(paramBoolean);
            return this.a.a(true);
        }
        return false;
    }

    private boolean g() {
        return this.c.get();
    }

    public a a() {
        return this.b.b;
    }

    public boolean a(m<K, D> paramm) {
        this.a = new p(this, paramm);
        this.c.set(true);
        try {
            this.a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            this.d = SystemClock.uptimeMillis();
            if (!m.f(paramm)) {
                m.d(paramm);
            }
            return true;
        } catch (RejectedExecutionException paramm) {
            this.c.set(false);
            this.a = null;
        }
        return false;
    }

    public String b() {
        return this.b.c;
    }

    public r<D> c() {
        return this.b;
    }

    public D d() {
        return (D) this.b.a.b(a(), c());
    }

    public boolean e() {
        return this.e.get();
    }

    public boolean f() {
        return this.f.get();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/k/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */