package com.google.android.gms.a;

import android.content.Context;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.pq;
import com.google.android.gms.internal.pr;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

class az
        implements af, ag, w {
    private volatile long a;
    private volatile bc b;
    private volatile ac c;
    private ah d;
    private ah e;
    private final c f;
    private final aj g;
    private final Context h;
    private final Queue<bf> i = new ConcurrentLinkedQueue();
    private volatile int j;
    private volatile Timer k;
    private volatile Timer l;
    private volatile Timer m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private pq r;
    private long s = 300000L;

    az(Context paramContext, aj paramaj) {
        this(paramContext, paramaj, null, c.a(paramContext));
    }

    az(Context paramContext, aj paramaj, ah paramah, c paramc) {
        this.e = paramah;
        this.h = paramContext;
        this.g = paramaj;
        this.f = paramc;
        this.r = pr.c();
        this.j = 0;
        this.b = bc.g;
    }

    private Timer a(Timer paramTimer) {
        if (paramTimer != null) {
            paramTimer.cancel();
        }
        return null;
    }

    private void g() {
        this.k = a(this.k);
        this.l = a(this.l);
        this.m = a(this.m);
    }

    private void h() {
        for (; ; ) {
            try {
                if (!Thread.currentThread().equals(this.g.d())) {
                    this.g.c().add(new ba(this));
                    return;
                }
                if (this.o) {
                    f();
                }
                switch (bb.a[this.b.ordinal()]) {
                    case 1:
                        if (this.i.isEmpty()) {
                            break;
                        }
                        bf localbf1 = (bf) this.i.poll();
                        bt.c("Sending hit to store  " + localbf1);
                        this.d.a(localbf1.a(), localbf1.b(), localbf1.c(), localbf1.d());
                        break;
                    case 7:
                        bt.c("Blocked. Dropping hits.");
                }
            } finally {
            }
            this.i.clear();
            continue;
            if (this.n) {
                i();
                continue;
                if (!this.i.isEmpty()) {
                    bf localbf2 = (bf) this.i.peek();
                    bt.c("Sending hit to service   " + localbf2);
                    if (!this.f.b()) {
                        this.c.a(localbf2.a(), localbf2.b(), localbf2.c(), localbf2.d());
                    }
                    for (; ; ) {
                        this.i.poll();
                        break;
                        bt.c("Dry run enabled. Hit not actually sent to service.");
                    }
                }
                this.a = this.r.b();
                continue;
                bt.c("Need to reconnect");
                if (!this.i.isEmpty()) {
                    k();
                }
            }
        }
    }

    private void i() {
        this.d.c();
        this.n = false;
    }

    private void j() {
        try {
            bc localbc1 = this.b;
            bc localbc2 = bc.c;
            if (localbc1 == localbc2) {
            }
            for (; ; ) {
                return;
                if ((this.h == null) || (!"com.google.android.gms".equals(this.h.getPackageName()))) {
                    break;
                }
                this.b = bc.d;
                this.c.c();
                bt.d("Attempted to fall back to local store from service.");
            }
            g();
        } finally {
        }
        bt.c("falling back to local store");
        if (this.e != null) {
        }
        aw localaw;
        for (this.d = this.e; ; this.d = localaw.d()) {
            this.b = bc.c;
            h();
            break;
            localaw = aw.c();
            localaw.a(this.h, this.g);
        }
    }

    private void k() {
        for (; ; ) {
            try {
                if ((!this.q) && (this.c != null)) {
                    bc localbc1 = this.b;
                    bc localbc2 = bc.c;
                    if (localbc1 != localbc2) {
                        try {
                            this.j += 1;
                            a(this.l);
                            this.b = bc.a;
                            this.l = new Timer("Failed Connect");
                            this.l.schedule(new be(this, null), 3000L);
                            bt.c("connecting to Analytics service");
                            this.c.b();
                            return;
                        } catch (SecurityException localSecurityException) {
                            bt.d("security exception on connectToService");
                            j();
                            continue;
                        }
                    }
                }
                bt.d("client not initialized.");
            } finally {
            }
            j();
        }
    }

    private void l() {
        try {
            if ((this.c != null) && (this.b == bc.b)) {
                this.b = bc.f;
                this.c.c();
            }
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    private void m() {
        this.k = a(this.k);
        this.k = new Timer("Service Reconnect");
        this.k.schedule(new bg(this, null), 5000L);
    }

    public void a() {
        for (; ; ) {
            try {
                boolean bool = this.q;
                if (bool) {
                    return;
                }
                bt.c("setForceLocalDispatch called.");
                this.q = true;
                switch (bb.a[this.b.ordinal()]) {
                    case 1:
                    case 4:
                    case 5:
                    case 6:
                    case 2:
                        l();
                        break;
                    case 3:
                        this.p = true;
                }
            } finally {
            }
        }
    }

    /* Error */
    public void a(int paramInt, android.content.Intent paramIntent) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getstatic 319	com/google/android/gms/a/bc:e	Lcom/google/android/gms/a/bc;
        //   6: putfield 88	com/google/android/gms/a/az:b	Lcom/google/android/gms/a/bc;
        //   9: aload_0
        //   10: getfield 82	com/google/android/gms/a/az:j	I
        //   13: iconst_2
        //   14: if_icmpge +39 -> 53
        //   17: new 168	java/lang/StringBuilder
        //   20: dup
        //   21: invokespecial 169	java/lang/StringBuilder:<init>	()V
        //   24: ldc_w 321
        //   27: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   30: iload_1
        //   31: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   34: ldc_w 326
        //   37: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   40: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   43: invokestatic 259	com/google/android/gms/a/bt:d	(Ljava/lang/String;)V
        //   46: aload_0
        //   47: invokespecial 328	com/google/android/gms/a/az:m	()V
        //   50: aload_0
        //   51: monitorexit
        //   52: return
        //   53: new 168	java/lang/StringBuilder
        //   56: dup
        //   57: invokespecial 169	java/lang/StringBuilder:<init>	()V
        //   60: ldc_w 321
        //   63: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   66: iload_1
        //   67: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   70: ldc_w 330
        //   73: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   76: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   79: invokestatic 259	com/google/android/gms/a/bt:d	(Ljava/lang/String;)V
        //   82: aload_0
        //   83: invokespecial 100	com/google/android/gms/a/az:j	()V
        //   86: goto -36 -> 50
        //   89: astore_2
        //   90: aload_0
        //   91: monitorexit
        //   92: aload_2
        //   93: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	94	0	this	az
        //   0	94	1	paramInt	int
        //   0	94	2	paramIntent	android.content.Intent
        // Exception table:
        //   from	to	target	type
        //   2	50	89	finally
        //   53	86	89	finally
    }

    public void a(Map<String, String> paramMap, long paramLong, String paramString, List<hb> paramList) {
        bt.c("putHit called");
        this.i.add(new bf(paramMap, paramLong, paramString, paramList));
        h();
    }

    public void b() {
        switch (bb.a[this.b.ordinal()]) {
            default:
                this.n = true;
            case 2:
                return;
        }
        i();
    }

    public void c() {
        if (this.c != null) {
            return;
        }
        this.c = new ad(this.h, this, this);
        k();
    }

    /* Error */
    public void d() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: aload_0
        //   4: aload_0
        //   5: getfield 112	com/google/android/gms/a/az:l	Ljava/util/Timer;
        //   8: invokespecial 110	com/google/android/gms/a/az:a	(Ljava/util/Timer;)Ljava/util/Timer;
        //   11: putfield 112	com/google/android/gms/a/az:l	Ljava/util/Timer;
        //   14: aload_0
        //   15: iconst_0
        //   16: putfield 82	com/google/android/gms/a/az:j	I
        //   19: ldc_w 344
        //   22: invokestatic 187	com/google/android/gms/a/bt:c	(Ljava/lang/String;)V
        //   25: aload_0
        //   26: getstatic 303	com/google/android/gms/a/bc:b	Lcom/google/android/gms/a/bc;
        //   29: putfield 88	com/google/android/gms/a/az:b	Lcom/google/android/gms/a/bc;
        //   32: aload_0
        //   33: getfield 316	com/google/android/gms/a/az:p	Z
        //   36: ifeq +15 -> 51
        //   39: aload_0
        //   40: invokespecial 239	com/google/android/gms/a/az:l	()V
        //   43: aload_0
        //   44: iconst_0
        //   45: putfield 316	com/google/android/gms/a/az:p	Z
        //   48: aload_0
        //   49: monitorexit
        //   50: return
        //   51: aload_0
        //   52: invokespecial 97	com/google/android/gms/a/az:h	()V
        //   55: aload_0
        //   56: aload_0
        //   57: aload_0
        //   58: getfield 114	com/google/android/gms/a/az:m	Ljava/util/Timer;
        //   61: invokespecial 110	com/google/android/gms/a/az:a	(Ljava/util/Timer;)Ljava/util/Timer;
        //   64: putfield 114	com/google/android/gms/a/az:m	Ljava/util/Timer;
        //   67: aload_0
        //   68: new 91	java/util/Timer
        //   71: dup
        //   72: ldc_w 346
        //   75: invokespecial 283	java/util/Timer:<init>	(Ljava/lang/String;)V
        //   78: putfield 114	com/google/android/gms/a/az:m	Ljava/util/Timer;
        //   81: aload_0
        //   82: getfield 114	com/google/android/gms/a/az:m	Ljava/util/Timer;
        //   85: new 348	com/google/android/gms/a/bd
        //   88: dup
        //   89: aload_0
        //   90: aconst_null
        //   91: invokespecial 349	com/google/android/gms/a/bd:<init>	(Lcom/google/android/gms/a/az;Lcom/google/android/gms/a/ba;)V
        //   94: aload_0
        //   95: getfield 65	com/google/android/gms/a/az:s	J
        //   98: invokevirtual 294	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
        //   101: goto -53 -> 48
        //   104: astore_1
        //   105: aload_0
        //   106: monitorexit
        //   107: aload_1
        //   108: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	109	0	this	az
        //   104	4	1	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	48	104	finally
        //   51	101	104	finally
    }

    public void e() {
        for (; ; ) {
            try {
                if (this.b == bc.d) {
                    bt.c("Service blocked.");
                    g();
                    return;
                }
                if (this.b == bc.f) {
                    bt.c("Disconnected from service");
                    g();
                    this.b = bc.g;
                    continue;
                }
                bt.c("Unexpected disconnect.");
            } finally {
            }
            this.b = bc.e;
            if (this.j < 2) {
                m();
            } else {
                j();
            }
        }
    }

    public void f() {
        bt.c("clearHits called");
        this.i.clear();
        switch (bb.a[this.b.ordinal()]) {
            default:
                this.o = true;
                return;
            case 1:
                this.d.a(0L);
                this.o = false;
                return;
        }
        this.c.a();
        this.o = false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */