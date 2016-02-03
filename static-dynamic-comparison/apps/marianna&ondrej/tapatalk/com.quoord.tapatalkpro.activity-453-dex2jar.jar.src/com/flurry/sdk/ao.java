package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.android.impl.ads.FlurryAdModule;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ao {
    private static final String b = ao.class.getSimpleName();
    final Map<String, aq> a = new HashMap();
    private final Map<String, aq> c = new LinkedHashMap();
    private final Map<String, as> d = new LinkedHashMap();
    private final av<byte[]> e;
    private final long f;
    private final int g;
    private boolean h = false;
    private WeakReference<a> i = new WeakReference(null);

    ao(String paramString, long paramLong1, long paramLong2, boolean paramBoolean) {
        this.e = new av(new ew(), paramString, paramLong1, paramBoolean);
        this.f = paramLong2;
        if (Runtime.getRuntime().availableProcessors() > 1) {
        }
        for (int j = 2; ; j = 1) {
            this.g = j;
            return;
        }
    }

    private void a(aq paramaq) {
        if (paramaq == null) {
        }
        while ((TextUtils.isEmpty(paramaq.a())) || (this.a.containsKey(paramaq.a()))) {
            return;
        }
        eo.a(3, b, "Precaching: adding cached asset info from persisted storage: " + paramaq.a() + " asset exp: " + paramaq.c() + " saved time: " + paramaq.f());
        synchronized (this.a) {
            this.a.put(paramaq.a(), paramaq);
            return;
        }
    }

    private void a(final aq paramaq, final ar paramar) {
        if ((paramaq == null) || (paramar == null)) {
        }
        final a locala;
        do {
            do {
                return;
            } while (paramar.equals(paramaq.b()));
            eo.a(3, b, "Asset status changed for asset:" + paramaq.a() + " from:" + paramaq.b() + " to:" + paramar);
            paramaq.a(paramar);
            locala = (a) this.i.get();
        } while (locala == null);
        do.a().c(new ff() {
            public void a() {
                locala.a(paramaq.a(), paramar);
            }
        });
    }

    private void b(aq paramaq) {
        if (paramaq == null) {
        }
        do {
            return;
            ???=c(paramaq);
        } while (ar.d.equals( ???));
        if ((ar.c.equals( ? ??))||(ar.b.equals( ? ??))){
        }
        for (; ; ) {
            synchronized (this.c) {
                if (!this.c.containsKey(paramaq.a())) {
                    this.c.put(paramaq.a(), paramaq);
                }
                do.a().c(new ff() {
                    public void a() {
                        ao.a(ao.this);
                    }
                });
                return;
            }
            eo.a(3, b, "Precaching: Queueing asset:" + paramaq.a());
            FlurryAdModule.getInstance().a("precachingDownloadRequested", 1);
            a(paramaq, ar.b);
            synchronized (this.c) {
                this.c.put(paramaq.a(), paramaq);
            }
        }
    }

    private ar c(aq paramaq) {
        if (paramaq == null) {
            return ar.a;
        }
        if (paramaq.d()) {
            return ar.a;
        }
        if ((ar.d.equals(paramaq.b())) && (!this.e.d(paramaq.a()))) {
            a(paramaq, ar.f);
        }
        return paramaq.b();
    }

    private aq d(String paramString) {
        if (!this.h) {
        }
        while (TextUtils.isEmpty(paramString)) {
            return null;
        }
        for (; ; ) {
            aq localaq;
            synchronized (this.a) {
                localaq = (aq) this.a.get(paramString);
                paramString = localaq;
                if (localaq != null) {
                    if (localaq.d()) {
                        eo.a(3, b, "Precaching: expiring cached asset: " + localaq.a() + " asset exp: " + localaq.c() + " device epoch" + System.currentTimeMillis());
                        a(localaq.a());
                        paramString = null;
                    }
                } else {
                    return paramString;
                }
            }
            c(localaq);
            localaq.e();
            paramString = localaq;
        }
    }

    private void d(final aq paramaq) {
        FlurryAdModule.getInstance().a("precachingDownloadStarted", 1);
        eo.a(3, b, "Precaching: Submitting for download: " + paramaq.a());
        ax localax = new ax(this.e, paramaq.a());
        localax.a(paramaq.a());
        localax.a(this.e);
        localax.a(new as.a() {
            public void a(as paramAnonymousas) {
                for (; ; ) {
                    synchronized (ao.b(ao.this)) {
                        ao.b(ao.this).remove(paramaq.a());
                        ao.a(ao.this, paramaq);
                        if (paramAnonymousas.a()) {
                            long l = paramAnonymousas.c();
                            eo.a(3, ao.i(), "Precaching: Download success: " + paramaq.a() + " size: " + l);
                            paramaq.a(l);
                            ao.a(ao.this, paramaq, ar.d);
                            FlurryAdModule.getInstance().a("precachingDownloadSuccess", 1);
                            do.a().c(new ff() {
                                public void a() {
                                    ao.a(ao.this);
                                }
                            });
                            return;
                        }
                    }
                    eo.a(3, ao.i(), "Precaching: Download error: " + paramaq.a());
                    ao.a(ao.this, paramaq, ar.g);
                    FlurryAdModule.getInstance().a("precachingDownloadError", 1);
                }
            }
        });
        localax.d();
        synchronized (this.d) {
            this.d.put(paramaq.a(), localax);
            a(paramaq, ar.c);
            return;
        }
    }

    private void e(aq paramaq) {
        if (paramaq == null) {
            return;
        }
        synchronized (this.c) {
            this.c.remove(paramaq.a());
            return;
        }
    }

    private void j() {
        if (!this.h) {
            return;
        }
        eo.a(3, b, "Precaching: Download files");
        for (; ; ) {
            aq localaq;
            synchronized (this.c) {
                Iterator localIterator = this.c.values().iterator();
                if (!localIterator.hasNext()) {
                    break;
                }
                localaq = (aq) localIterator.next();
                if (this.e.d(localaq.a())) {
                    eo.a(3, b, "Precaching: Asset already cached.  Skipping download:" + localaq.a());
                    localIterator.remove();
                    a(localaq, ar.d);
                }
            }
            if (!ar.c.equals(c(localaq))) {
                if (em.a().b(this) >= this.g) {
                    eo.a(3, b, "Precaching: Download limit reached");
                    return;
                }
                d(localaq);
            }
        }
        eo.a(3, b, "Precaching: No more files to download");
    }

    private void k() {
        eo.a(3, b, "Precaching: Cancelling in-progress downloads");
        synchronized (this.d) {
            Iterator localIterator1 = this.d.entrySet().iterator();
            if (localIterator1.hasNext()) {
                ((as) ((Map.Entry) localIterator1.next()).getValue()).e();
            }
        }
        this.d.clear();
        synchronized (this.c) {
            Iterator localIterator2 = this.c.entrySet().iterator();
            while (localIterator2.hasNext()) {
                aq localaq = (aq) ((Map.Entry) localIterator2.next()).getValue();
                if (!ar.d.equals(c(localaq))) {
                    eo.a(3, b, "Precaching: Download cancelled: " + localaq.f());
                    a(localaq, ar.e);
                }
            }
        }
    }

    private void l() {
        Iterator localIterator = g().iterator();
        while (localIterator.hasNext()) {
            aq localaq = (aq) localIterator.next();
            if (!ar.d.equals(c(localaq))) {
                eo.a(3, b, "Precaching: expiring cached asset: " + localaq.a() + " asset exp: " + localaq.c() + " device epoch: " + System.currentTimeMillis());
                a(localaq.a());
            }
        }
    }

    /* Error */
    public void a() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 67	com/flurry/sdk/ao:h	Z
        //   6: istore_1
        //   7: iload_1
        //   8: ifeq +6 -> 14
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: iconst_3
        //   15: getstatic 48	com/flurry/sdk/ao:b	Ljava/lang/String;
        //   18: ldc_w 345
        //   21: invokestatic 155	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   24: aload_0
        //   25: getfield 84	com/flurry/sdk/ao:e	Lcom/flurry/sdk/av;
        //   28: invokevirtual 347	com/flurry/sdk/av:a	()V
        //   31: invokestatic 188	com/flurry/sdk/do:a	()Lcom/flurry/sdk/do;
        //   34: new 6	com/flurry/sdk/ao$1
        //   37: dup
        //   38: aload_0
        //   39: invokespecial 348	com/flurry/sdk/ao$1:<init>	(Lcom/flurry/sdk/ao;)V
        //   42: invokevirtual 194	com/flurry/sdk/do:c	(Ljava/lang/Runnable;)V
        //   45: aload_0
        //   46: iconst_1
        //   47: putfield 67	com/flurry/sdk/ao:h	Z
        //   50: goto -39 -> 11
        //   53: astore_2
        //   54: aload_0
        //   55: monitorexit
        //   56: aload_2
        //   57: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	58	0	this	ao
        //   6	2	1	bool	boolean
        //   53	4	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	7	53	finally
        //   14	50	53	finally
    }

    public void a(a parama) {
        this.i = new WeakReference(parama);
    }

    public void a(InputStream paramInputStream)
            throws IOException {
        if (paramInputStream == null) {
            try {
                throw new IOException("Invalid input stream!");
            } finally {
            }
        }
        try {
            DataInputStream localDataInputStream = new DataInputStream(paramInputStream);
            int k;
            int j;
            fe.a(localDataInputStream);
        } finally {
            try {
                k = localDataInputStream.readShort();
                j = 0;
                while (j < k) {
                    a(new aq(localDataInputStream));
                    j += 1;
                }
                l();
                fe.a(localDataInputStream);
                return;
            } finally {
                for (; ; ) {
                }
            }
            paramInputStream =finally;
            localDataInputStream = null;
        }
        throw paramInputStream;
    }

    public void a(OutputStream paramOutputStream)
            throws IOException {
        if (paramOutputStream == null) {
            try {
                throw new IOException("Invalid output stream!");
            } finally {
            }
        }
        try {
            localDataOutputStream = new DataOutputStream(paramOutputStream);
            try {
                paramOutputStream = g();
                localDataOutputStream.writeShort(paramOutputStream.size());
                paramOutputStream = paramOutputStream.iterator();
                while (paramOutputStream.hasNext()) {
                    ((aq) paramOutputStream.next()).a(localDataOutputStream);
                }
                fe.a(localDataOutputStream);
            } finally {
            }
        } finally {
            for (; ; ) {
                paramOutputStream =finally;
                DataOutputStream localDataOutputStream = null;
            }
        }
        throw paramOutputStream;
        fe.a(localDataOutputStream);
    }

    public void a(String paramString) {
        if (!this.h) {
        }
        while (TextUtils.isEmpty(paramString)) {
            return;
        }
        synchronized (this.a) {
            this.a.remove(paramString);
            this.e.c(paramString);
            return;
        }
    }

    public boolean a(String arg1, ay paramay, long paramLong) {
        if (!this.h) {
        }
        while ((TextUtils.isEmpty( ? ??))||(paramay == null) || (!ay.b.equals(paramay))){
            return false;
        }
        aq localaq = d( ???);
        if (localaq == null) {
            paramay = new aq( ???,paramay, paramLong);
        }
        for (; ; ) {
            synchronized (this.a) {
                this.a.put(paramay.a(), paramay);
                b(paramay);
                return true;
            }
            if (!ar.d.equals(c(localaq))) {
                b(localaq);
            }
        }
    }

    public ar b(String paramString) {
        if (!this.h) {
            return ar.a;
        }
        return c(d(paramString));
    }

    /* Error */
    public void b() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 67	com/flurry/sdk/ao:h	Z
        //   6: istore_1
        //   7: iload_1
        //   8: ifne +6 -> 14
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: iconst_3
        //   15: getstatic 48	com/flurry/sdk/ao:b	Ljava/lang/String;
        //   18: ldc_w 413
        //   21: invokestatic 155	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   24: aload_0
        //   25: invokespecial 415	com/flurry/sdk/ao:k	()V
        //   28: aload_0
        //   29: getfield 84	com/flurry/sdk/ao:e	Lcom/flurry/sdk/av;
        //   32: invokevirtual 417	com/flurry/sdk/av:b	()V
        //   35: aload_0
        //   36: iconst_0
        //   37: putfield 67	com/flurry/sdk/ao:h	Z
        //   40: goto -29 -> 11
        //   43: astore_2
        //   44: aload_0
        //   45: monitorexit
        //   46: aload_2
        //   47: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	48	0	this	ao
        //   6	2	1	bool	boolean
        //   43	4	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	7	43	finally
        //   14	40	43	finally
    }

    public aw.b c(String paramString) {
        if (!this.h) {
        }
        while (TextUtils.isEmpty(paramString)) {
            return null;
        }
        return this.e.a(paramString);
    }

    /* Error */
    public void c() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 67	com/flurry/sdk/ao:h	Z
        //   6: istore_1
        //   7: iload_1
        //   8: ifne +6 -> 14
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: iconst_3
        //   15: getstatic 48	com/flurry/sdk/ao:b	Ljava/lang/String;
        //   18: ldc_w 422
        //   21: invokestatic 155	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   24: aload_0
        //   25: invokespecial 415	com/flurry/sdk/ao:k	()V
        //   28: goto -17 -> 11
        //   31: astore_2
        //   32: aload_0
        //   33: monitorexit
        //   34: aload_2
        //   35: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	36	0	this	ao
        //   6	2	1	bool	boolean
        //   31	4	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	7	31	finally
        //   14	28	31	finally
    }

    /* Error */
    public void d() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 67	com/flurry/sdk/ao:h	Z
        //   6: istore_1
        //   7: iload_1
        //   8: ifne +6 -> 14
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: iconst_3
        //   15: getstatic 48	com/flurry/sdk/ao:b	Ljava/lang/String;
        //   18: ldc_w 424
        //   21: invokestatic 155	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   24: invokestatic 188	com/flurry/sdk/do:a	()Lcom/flurry/sdk/do;
        //   27: new 8	com/flurry/sdk/ao$2
        //   30: dup
        //   31: aload_0
        //   32: invokespecial 425	com/flurry/sdk/ao$2:<init>	(Lcom/flurry/sdk/ao;)V
        //   35: invokevirtual 194	com/flurry/sdk/do:c	(Ljava/lang/Runnable;)V
        //   38: goto -27 -> 11
        //   41: astore_2
        //   42: aload_0
        //   43: monitorexit
        //   44: aload_2
        //   45: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	46	0	this	ao
        //   6	2	1	bool	boolean
        //   41	4	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	7	41	finally
        //   14	38	41	finally
    }

    public void e() {
        if (!this.h) {
            return;
        }
        Iterator localIterator = g().iterator();
        while (localIterator.hasNext()) {
            a(((aq) localIterator.next()).a());
        }
        this.e.c();
    }

    public void f() {
        if (!this.h) {
        }
        for (; ; ) {
            return;
            Iterator localIterator = g().iterator();
            while (localIterator.hasNext()) {
                c((aq) localIterator.next());
            }
        }
    }

    public List<aq> g() {
        synchronized (this.a) {
            ArrayList localArrayList = new ArrayList(this.a.values());
            return localArrayList;
        }
    }

    public List<aq> h() {
        f();
        return g();
    }

    static abstract interface a {
        public abstract void a(String paramString, ar paramar);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */