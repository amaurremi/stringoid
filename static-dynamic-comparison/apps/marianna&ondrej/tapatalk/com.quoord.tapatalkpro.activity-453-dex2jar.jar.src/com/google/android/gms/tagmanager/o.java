package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.j;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.gn;
import com.google.android.gms.internal.it.a;

class o
        extends a.a<ContainerHolder> {
    private final Looper AS;
    private final String WJ;
    private long WO;
    private final TagManager WW;
    private final d WZ;
    private final gl Wv;
    private final cf Xa;
    private final int Xb;
    private f Xc;
    private volatile n Xd;
    private volatile boolean Xe;
    private c.j Xf;
    private String Xg;
    private e Xh;
    private a Xi;
    private final Context mContext;

    o(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, f paramf, e parame, gl paramgl, cf paramcf) {
    }

    public o(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, r paramr) {
        this(paramContext, paramTagManager, paramLooper, paramString, paramInt, new cp(paramContext, paramString), new co(paramContext, paramString, paramr), gn.ft(), new bf(30, 900000L, 5000L, "refreshing", gn.ft()));
    }

    private void C(final boolean paramBoolean) {
        this.Xc.a(new b(null));
        this.Xh.a(new c(null));
        cq.c localc = this.Xc.ca(this.Xb);
        if (localc != null) {
            this.Xd = new n(this.WW, this.AS, new Container(this.mContext, this.WW.getDataLayer(), this.WJ, 0L, localc), this.WZ);
        }
        this.Xi = new a() {
            public boolean b(Container paramAnonymousContainer) {
                if (paramBoolean) {
                    if (paramAnonymousContainer.getLastRefreshTime() + 43200000L < o.a(o.this).currentTimeMillis()) {
                    }
                }
                while (!paramAnonymousContainer.isDefault()) {
                    return true;
                    return false;
                }
                return false;
            }
        };
        if (kk()) {
            this.Xh.d(0L, "");
            return;
        }
        this.Xc.km();
    }

    private void a(c.j paramj) {
        try {
            if (this.Xc != null) {
                it.a locala = new it.a();
                locala.aaY = this.WO;
                locala.fK = new c.f();
                locala.aaZ = paramj;
                this.Xc.b(locala);
            }
            return;
        } finally {
            paramj =finally;
            throw paramj;
        }
    }

    private void a(c.j paramj, long paramLong, boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (; ; ) {
            try {
                paramBoolean = this.Xe;
                if (paramBoolean) {
                    return;
                }
                if ((isReady()) && (this.Xd == null)) {
                }
                this.Xf = paramj;
                this.WO = paramLong;
                t(Math.max(0L, Math.min(43200000L, this.WO + 43200000L - this.Wv.currentTimeMillis())));
                paramj = new Container(this.mContext, this.WW.getDataLayer(), this.WJ, paramLong, paramj);
                if (this.Xd == null) {
                    this.Xd = new n(this.WW, this.AS, paramj, this.WZ);
                    if ((!isReady()) && (this.Xi.b(paramj))) {
                        a(this.Xd);
                    }
                } else {
                    this.Xd.a(paramj);
                }
            } finally {
            }
        }
    }

    private boolean kk() {
        cd localcd = cd.kT();
        return ((localcd.kU() == cd.a.YU) || (localcd.kU() == cd.a.YV)) && (this.WJ.equals(localcd.getContainerId()));
    }

    /* Error */
    private void t(long paramLong) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 83	com/google/android/gms/tagmanager/o:Xh	Lcom/google/android/gms/tagmanager/o$e;
        //   6: ifnonnull +12 -> 18
        //   9: ldc_w 290
        //   12: invokestatic 295	com/google/android/gms/tagmanager/bh:z	(Ljava/lang/String;)V
        //   15: aload_0
        //   16: monitorexit
        //   17: return
        //   18: aload_0
        //   19: getfield 83	com/google/android/gms/tagmanager/o:Xh	Lcom/google/android/gms/tagmanager/o$e;
        //   22: lload_1
        //   23: aload_0
        //   24: getfield 95	com/google/android/gms/tagmanager/o:Xf	Lcom/google/android/gms/internal/c$j;
        //   27: getfield 298	com/google/android/gms/internal/c$j:fL	Ljava/lang/String;
        //   30: invokeinterface 188 4 0
        //   35: goto -20 -> 15
        //   38: astore_3
        //   39: aload_0
        //   40: monitorexit
        //   41: aload_3
        //   42: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	43	0	this	o
        //   0	43	1	paramLong	long
        //   38	4	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	15	38	finally
        //   18	35	38	finally
    }

    protected ContainerHolder ac(Status paramStatus) {
        if (this.Xd != null) {
            return this.Xd;
        }
        if (paramStatus == Status.By) {
            bh.w("timer expired: setting result to failure");
        }
        return new n(paramStatus);
    }

    void br(String paramString) {
        try {
            this.Xg = paramString;
            if (this.Xh != null) {
                this.Xh.bu(paramString);
            }
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    String ke() {
        try {
            String str = this.Xg;
            return str;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void kh() {
        Object localObject = this.Xc.ca(this.Xb);
        if (localObject != null) {
            localObject = new Container(this.mContext, this.WW.getDataLayer(), this.WJ, 0L, (cq.c) localObject);
            a(new n(this.WW, this.AS, (Container) localObject, new n.a() {
                public void br(String paramAnonymousString) {
                    o.this.br(paramAnonymousString);
                }

                public String ke() {
                    return o.this.ke();
                }

                public void kg() {
                    bh.z("Refresh ignored: container loaded as default only.");
                }
            }));
        }
        for (; ; ) {
            this.Xh = null;
            this.Xc = null;
            return;
            bh.w("Default was requested, but no default container was found");
            a(ac(new Status(10, "Default was requested, but no default container was found", null)));
        }
    }

    public void ki() {
        C(false);
    }

    public void kj() {
        C(true);
    }

    static abstract interface a {
        public abstract boolean b(Container paramContainer);
    }

    private class b
            implements bg<it.a> {
        private b() {
        }

        public void a(it.a parama) {
            c.j localj;
            if (parama.aaZ != null) {
                localj = parama.aaZ;
            }
            for (; ; ) {
                o.a(o.this, localj, parama.aaY, true);
                return;
                c.f localf = parama.fK;
                localj = new c.j();
                localj.fK = localf;
                localj.fJ = null;
                localj.fL = localf.fg;
            }
        }

        public void a(bg.a parama) {
            if (!o.b(o.this)) {
                o.a(o.this, 0L);
            }
        }

        public void kl() {
        }
    }

    private class c
            implements bg<c.j> {
        private c() {
        }

        public void a(bg.a parama) {
            if (o.f(o.this) != null) {
                o.this.a(o.f(o.this));
            }
            for (; ; ) {
                o.a(o.this, 3600000L);
                return;
                o.this.a(o.this.ac(Status.By));
            }
        }

        public void b(c.j paramj) {
            synchronized (o.this) {
                if (paramj.fK == null) {
                    if (o.c(o.this).fK == null) {
                        bh.w("Current resource is null; network resource is also null");
                        o.a(o.this, 3600000L);
                        return;
                    }
                    paramj.fK = o.c(o.this).fK;
                }
                o.a(o.this, paramj, o.a(o.this).currentTimeMillis(), false);
                bh.y("setting refresh time to current time: " + o.d(o.this));
                if (!o.e(o.this)) {
                    o.a(o.this, paramj);
                }
                return;
            }
        }

        public void kl() {
        }
    }

    private class d
            implements n.a {
        private d() {
        }

        public void br(String paramString) {
            o.this.br(paramString);
        }

        public String ke() {
            return o.this.ke();
        }

        public void kg() {
            if (o.g(o.this).cS()) {
                o.a(o.this, 0L);
            }
        }
    }

    static abstract interface e
            extends Releasable {
        public abstract void a(bg<c.j> parambg);

        public abstract void bu(String paramString);

        public abstract void d(long paramLong, String paramString);
    }

    static abstract interface f
            extends Releasable {
        public abstract void a(bg<it.a> parambg);

        public abstract void b(it.a parama);

        public abstract cq.c ca(int paramInt);

        public abstract void km();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */