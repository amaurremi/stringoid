package com.everimaging.fotorsdk.uil.core;

import com.everimaging.fotorsdk.uil.cache.disc.b;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class f {
    final e a;
    private Executor b;
    private Executor c;
    private ExecutorService d;
    private final Map<Integer, String> e = Collections.synchronizedMap(new HashMap());
    private final Map<String, ReentrantLock> f = new WeakHashMap();
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean(false);
    private final Object j = new Object();

    f(e parame) {
        this.a = parame;
        this.b = parame.i;
        this.c = parame.j;
        this.d = Executors.newCachedThreadPool();
    }

    private void e() {
        if ((!this.a.k) && (((ExecutorService) this.b).isShutdown())) {
            this.b = f();
        }
        if ((!this.a.l) && (((ExecutorService) this.c).isShutdown())) {
            this.c = f();
        }
    }

    private Executor f() {
        return a.a(this.a.m, this.a.n, this.a.o);
    }

    String a(com.everimaging.fotorsdk.uil.core.imageaware.a parama) {
        return (String) this.e.get(Integer.valueOf(parama.f()));
    }

    AtomicBoolean a() {
        return this.g;
    }

    ReentrantLock a(String paramString) {
        ReentrantLock localReentrantLock2 = (ReentrantLock) this.f.get(paramString);
        ReentrantLock localReentrantLock1 = localReentrantLock2;
        if (localReentrantLock2 == null) {
            localReentrantLock1 = new ReentrantLock();
            this.f.put(paramString, localReentrantLock1);
        }
        return localReentrantLock1;
    }

    void a(final LoadAndDisplayImageTask paramLoadAndDisplayImageTask) {
        this.d.execute(new Runnable() {
            public void run() {
                boolean bool = f.this.a.q.a(paramLoadAndDisplayImageTask.a()).exists();
                f.a(f.this);
                if (bool) {
                    f.b(f.this).execute(paramLoadAndDisplayImageTask);
                    return;
                }
                f.c(f.this).execute(paramLoadAndDisplayImageTask);
            }
        });
    }

    void a(h paramh) {
        e();
        this.c.execute(paramh);
    }

    void a(com.everimaging.fotorsdk.uil.core.imageaware.a parama, String paramString) {
        this.e.put(Integer.valueOf(parama.f()), paramString);
    }

    Object b() {
        return this.j;
    }

    void b(com.everimaging.fotorsdk.uil.core.imageaware.a parama) {
        this.e.remove(Integer.valueOf(parama.f()));
    }

    boolean c() {
        return this.h.get();
    }

    boolean d() {
        return this.i.get();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */