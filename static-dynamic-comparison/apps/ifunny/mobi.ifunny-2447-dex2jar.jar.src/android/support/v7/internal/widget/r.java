package android.support.v7.internal.widget;

class r
        implements Runnable {
    private r(l paraml) {
    }

    public void run() {
        if (this.a.u) {
            if (this.a.e() != null) {
                this.a.post(this);
            }
            return;
        }
        l.b(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */