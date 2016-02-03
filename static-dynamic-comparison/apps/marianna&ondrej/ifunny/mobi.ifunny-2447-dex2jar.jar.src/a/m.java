package a;

final class m
        implements Runnable {
    m(j paramj, k paramk, s params) {
    }

    public void run() {
        try {
            k localk = (k) this.a.then(this.b);
            if (localk == null) {
                this.c.b(null);
                return;
            }
            localk.a(new n(this));
            return;
        } catch (Exception localException) {
            this.c.b(localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */