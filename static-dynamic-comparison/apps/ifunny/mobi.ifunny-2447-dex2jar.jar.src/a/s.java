package a;

public class s {
    private s(k paramk) {
    }

    public k<TResult> a() {
        return this.a;
    }

    public boolean a(Exception paramException) {
        synchronized (k.a(this.a)) {
            if (k.b(this.a)) {
                return false;
            }
            k.a(this.a, true);
            k.a(this.a, paramException);
            k.a(this.a).notifyAll();
            k.c(this.a);
            return true;
        }
    }

    public boolean a(TResult paramTResult) {
        synchronized (k.a(this.a)) {
            if (k.b(this.a)) {
                return false;
            }
            k.a(this.a, true);
            k.a(this.a, paramTResult);
            k.a(this.a).notifyAll();
            k.c(this.a);
            return true;
        }
    }

    public void b(Exception paramException) {
        if (!a(paramException)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public void b(TResult paramTResult) {
        if (!a(paramTResult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public boolean b() {
        synchronized (k.a(this.a)) {
            if (k.b(this.a)) {
                return false;
            }
            k.a(this.a, true);
            k.b(this.a, true);
            k.a(this.a).notifyAll();
            k.c(this.a);
            return true;
        }
    }

    public void c() {
        if (!b()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */