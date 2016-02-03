package com.flurry.sdk;

public final class lf {
    final hj a;
    final iz b;
    final Object[] c;
    private int d;
    private le e;

    public lf(hj paramhj, iz paramiz, int paramInt) {
        this.a = paramhj;
        this.b = paramiz;
        this.d = paramInt;
        this.c = new Object[paramInt];
    }

    protected le a() {
        return this.e;
    }

    public void a(ks paramks, String paramString, Object paramObject) {
        this.e = new le.a(this.e, paramObject, paramks, paramString);
    }

    public void a(kt paramkt, Object paramObject) {
        this.e = new le.c(this.e, paramObject, paramkt);
    }

    public void a(Object paramObject1, Object paramObject2) {
        this.e = new le.b(this.e, paramObject2, paramObject1);
    }

    public void a(kt[] paramArrayOfkt) {
        int i = 0;
        int j = paramArrayOfkt.length;
        while (i < j) {
            kt localkt = paramArrayOfkt[i];
            if (localkt != null) {
                this.c[i] = this.b.a(localkt.k(), localkt, null);
            }
            i += 1;
        }
    }

    public boolean a(int paramInt, Object paramObject) {
        this.c[paramInt] = paramObject;
        paramInt = this.d - 1;
        this.d = paramInt;
        return paramInt <= 0;
    }

    protected final Object[] a(Object[] paramArrayOfObject) {
        if (paramArrayOfObject != null) {
            int i = 0;
            int j = this.c.length;
            while (i < j) {
                if (this.c[i] == null) {
                    Object localObject = paramArrayOfObject[i];
                    if (localObject != null) {
                        this.c[i] = localObject;
                    }
                }
                i += 1;
            }
        }
        return this.c;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/lf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */