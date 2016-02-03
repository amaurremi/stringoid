package android.support.v4.a;

import android.os.Message;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class r<Params, Progress, Result> {
    private static final ThreadFactory a = new s();
    private static final BlockingQueue<Runnable> b = new LinkedBlockingQueue(10);
    private static final x c = new x(null);
    public static final Executor d = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, b, a);
    private static volatile Executor e = d;
    private final z<Params, Result> f = new t(this);
    private final FutureTask<Result> g = new u(this, this.f);
    private volatile y h = y.a;
    private final AtomicBoolean i = new AtomicBoolean();

    private void c(Result paramResult) {
        if (!this.i.get()) {
            d(paramResult);
        }
    }

    private Result d(Result paramResult) {
        c.obtainMessage(1, new w(this, new Object[]{paramResult})).sendToTarget();
        return paramResult;
    }

    private void e(Result paramResult) {
        if (c()) {
            b(paramResult);
        }
        for (; ; ) {
            this.h = y.c;
            return;
            a(paramResult);
        }
    }

    public final r<Params, Progress, Result> a(Executor paramExecutor, Params... paramVarArgs) {
        if (this.h != y.a) {
        }
        switch (v.a[this.h.ordinal()]) {
            default:
                this.h = y.b;
                b();
                this.f.b = paramVarArgs;
                paramExecutor.execute(this.g);
                return this;
            case 1:
                throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    protected abstract Result a(Params... paramVarArgs);

    protected void a() {
    }

    protected void a(Result paramResult) {
    }

    public final boolean a(boolean paramBoolean) {
        return this.g.cancel(paramBoolean);
    }

    protected void b() {
    }

    protected void b(Result paramResult) {
        a();
    }

    protected void b(Progress... paramVarArgs) {
    }

    public final boolean c() {
        return this.g.isCancelled();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */