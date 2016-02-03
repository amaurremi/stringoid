package com.flurry.sdk;

import java.util.List;

public class ok {
    private static final oi[] f = new oi[0];
    protected final mw a;
    protected List<oi> b;
    protected oi[] c;
    protected of d;
    protected Object e;

    public ok(mw parammw) {
        this.a = parammw;
    }

    public List<oi> a() {
        return this.b;
    }

    public void a(of paramof) {
        this.d = paramof;
    }

    public void a(Object paramObject) {
        this.e = paramObject;
    }

    public void a(List<oi> paramList) {
        this.b = paramList;
    }

    public void a(oi[] paramArrayOfoi) {
        this.c = paramArrayOfoi;
    }

    public jk<?> b() {
        if ((this.b == null) || (this.b.isEmpty())) {
            if (this.d == null) {
                return null;
            }
        }
        for (oi[] arrayOfoi = f; ; arrayOfoi = (oi[]) this.b.toArray(new oi[this.b.size()])) {
            return new oj(this.a.a(), arrayOfoi, this.c, this.d, this.e);
        }
    }

    public oj c() {
        return oj.a(this.a.b());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ok.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */