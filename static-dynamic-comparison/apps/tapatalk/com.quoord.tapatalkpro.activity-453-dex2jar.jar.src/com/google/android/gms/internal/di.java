package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class di {
    private final Object li = new Object();
    private boolean pV = false;
    private final String qA;
    private long qB = -1L;
    private long qC = -1L;
    private long qD = -1L;
    private long qE = 0L;
    private long qF = -1L;
    private long qG = -1L;
    private final dj qx;
    private final LinkedList<a> qy;
    private final String qz;

    public di(dj paramdj, String paramString1, String paramString2) {
        this.qx = paramdj;
        this.qz = paramString1;
        this.qA = paramString2;
        this.qy = new LinkedList();
    }

    public di(String paramString1, String paramString2) {
        this(dj.bq(), paramString1, paramString2);
    }

    public void bk() {
        synchronized (this.li) {
            if ((this.qG != -1L) && (this.qC == -1L)) {
                this.qC = SystemClock.elapsedRealtime();
                this.qx.a(this);
            }
            dj localdj = this.qx;
            dj.bu().bk();
            return;
        }
    }

    public void bl() {
        synchronized (this.li) {
            if (this.qG != -1L) {
                Object localObject2 = new a();
                ((a) localObject2).bp();
                this.qy.add(localObject2);
                this.qE += 1L;
                localObject2 = this.qx;
                dj.bu().bl();
                this.qx.a(this);
            }
            return;
        }
    }

    public void bm() {
        synchronized (this.li) {
            if ((this.qG != -1L) && (!this.qy.isEmpty())) {
                a locala = (a) this.qy.getLast();
                if (locala.bn() == -1L) {
                    locala.bo();
                    this.qx.a(this);
                }
            }
            return;
        }
    }

    public void f(ah paramah) {
        synchronized (this.li) {
            this.qF = SystemClock.elapsedRealtime();
            dj localdj = this.qx;
            dj.bu().b(paramah, this.qF);
            return;
        }
    }

    public void h(long paramLong) {
        synchronized (this.li) {
            this.qG = paramLong;
            if (this.qG != -1L) {
                this.qx.a(this);
            }
            return;
        }
    }

    public void i(long paramLong) {
        synchronized (this.li) {
            if (this.qG != -1L) {
                this.qB = paramLong;
                this.qx.a(this);
            }
            return;
        }
    }

    public void m(boolean paramBoolean) {
        synchronized (this.li) {
            if (this.qG != -1L) {
                this.qD = SystemClock.elapsedRealtime();
                if (!paramBoolean) {
                    this.qC = this.qD;
                    this.qx.a(this);
                }
            }
            return;
        }
    }

    public void n(boolean paramBoolean) {
        synchronized (this.li) {
            if (this.qG != -1L) {
                this.pV = paramBoolean;
                this.qx.a(this);
            }
            return;
        }
    }

    public Bundle toBundle() {
        ArrayList localArrayList;
        synchronized (this.li) {
            Bundle localBundle1 = new Bundle();
            localBundle1.putString("seqnum", this.qz);
            localBundle1.putString("slotid", this.qA);
            localBundle1.putBoolean("ismediation", this.pV);
            localBundle1.putLong("treq", this.qF);
            localBundle1.putLong("tresponse", this.qG);
            localBundle1.putLong("timp", this.qC);
            localBundle1.putLong("tload", this.qD);
            localBundle1.putLong("pcc", this.qE);
            localBundle1.putLong("tfetch", this.qB);
            localArrayList = new ArrayList();
            Iterator localIterator = this.qy.iterator();
            if (localIterator.hasNext()) {
                localArrayList.add(((a) localIterator.next()).toBundle());
            }
        }
        localBundle2.putParcelableArrayList("tclick", localArrayList);
        return localBundle2;
    }

    private static final class a {
        private long qH = -1L;
        private long qI = -1L;

        public long bn() {
            return this.qI;
        }

        public void bo() {
            this.qI = SystemClock.elapsedRealtime();
        }

        public void bp() {
            this.qH = SystemClock.elapsedRealtime();
        }

        public Bundle toBundle() {
            Bundle localBundle = new Bundle();
            localBundle.putLong("topen", this.qH);
            localBundle.putLong("tclose", this.qI);
            return localBundle;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */