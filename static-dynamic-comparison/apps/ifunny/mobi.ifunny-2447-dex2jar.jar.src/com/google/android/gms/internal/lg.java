package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@ii
public class lg {
    private final lj a;
    private final LinkedList<li> b;
    private final Object c = new Object();
    private final String d;
    private final String e;
    private long f = -1L;
    private long g = -1L;
    private boolean h = false;
    private long i = -1L;
    private long j = 0L;
    private long k = -1L;
    private long l = -1L;

    public lg(lj paramlj, String paramString1, String paramString2) {
        this.a = paramlj;
        this.d = paramString1;
        this.e = paramString2;
        this.b = new LinkedList();
    }

    public lg(String paramString1, String paramString2) {
        this(lj.a(), paramString1, paramString2);
    }

    public void a() {
        synchronized (this.c) {
            if ((this.l != -1L) && (this.g == -1L)) {
                this.g = SystemClock.elapsedRealtime();
                this.a.a(this);
            }
            lj locallj = this.a;
            lj.e().c();
            return;
        }
    }

    public void a(long paramLong) {
        synchronized (this.c) {
            this.l = paramLong;
            if (this.l != -1L) {
                this.a.a(this);
            }
            return;
        }
    }

    public void a(av paramav) {
        synchronized (this.c) {
            this.k = SystemClock.elapsedRealtime();
            lj locallj = this.a;
            lj.e().a(paramav, this.k);
            return;
        }
    }

    public void a(boolean paramBoolean) {
        synchronized (this.c) {
            if (this.l != -1L) {
                this.i = SystemClock.elapsedRealtime();
                if (!paramBoolean) {
                    this.g = this.i;
                    this.a.a(this);
                }
            }
            return;
        }
    }

    public void b() {
        synchronized (this.c) {
            if (this.l != -1L) {
                Object localObject2 = new li();
                ((li) localObject2).c();
                this.b.add(localObject2);
                this.j += 1L;
                localObject2 = this.a;
                lj.e().b();
                this.a.a(this);
            }
            return;
        }
    }

    public void b(long paramLong) {
        synchronized (this.c) {
            if (this.l != -1L) {
                this.f = paramLong;
                this.a.a(this);
            }
            return;
        }
    }

    public void b(boolean paramBoolean) {
        synchronized (this.c) {
            if (this.l != -1L) {
                this.h = paramBoolean;
                this.a.a(this);
            }
            return;
        }
    }

    public void c() {
        synchronized (this.c) {
            if ((this.l != -1L) && (!this.b.isEmpty())) {
                li localli = (li) this.b.getLast();
                if (localli.a() == -1L) {
                    localli.b();
                    this.a.a(this);
                }
            }
            return;
        }
    }

    public Bundle d() {
        ArrayList localArrayList;
        synchronized (this.c) {
            Bundle localBundle1 = new Bundle();
            localBundle1.putString("seq_num", this.d);
            localBundle1.putString("slotid", this.e);
            localBundle1.putBoolean("ismediation", this.h);
            localBundle1.putLong("treq", this.k);
            localBundle1.putLong("tresponse", this.l);
            localBundle1.putLong("timp", this.g);
            localBundle1.putLong("tload", this.i);
            localBundle1.putLong("pcc", this.j);
            localBundle1.putLong("tfetch", this.f);
            localArrayList = new ArrayList();
            Iterator localIterator = this.b.iterator();
            if (localIterator.hasNext()) {
                localArrayList.add(((li) localIterator.next()).d());
            }
        }
        localBundle2.putParcelableArrayList("tclick", localArrayList);
        return localBundle2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/lg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */