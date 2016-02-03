package android.support.v4.a;

import java.util.concurrent.CountDownLatch;

final class b
        extends r<Void, Void, D>
        implements Runnable {
    D a;
    boolean b;
    private CountDownLatch e = new CountDownLatch(1);

    b(a parama) {
    }

    protected D a(Void... paramVarArgs) {
        this.a = this.c.d();
        return (D) this.a;
    }

    protected void a() {
        try {
            this.c.a(this, this.a);
            return;
        } finally {
            this.e.countDown();
        }
    }

    protected void a(D paramD) {
        try {
            this.c.b(this, paramD);
            return;
        } finally {
            this.e.countDown();
        }
    }

    public void run() {
        this.b = false;
        this.c.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */