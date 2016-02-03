package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fg;
import com.google.android.gms.internal.fg.b;
import com.google.android.gms.internal.fq;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class b
        implements GoogleApiClient {
    private final a AL = new a() {
        public void b(b.c<?> paramAnonymousc) {
            b.a(b.this).lock();
            try {
                b.this.Bp.remove(paramAnonymousc);
                return;
            } finally {
                b.a(b.this).unlock();
            }
        }
    };
    private final Looper AS;
    private final Lock Ba = new ReentrantLock();
    private final Condition Bb = this.Ba.newCondition();
    private final fg Bc = new fg(paramContext, paramLooper, this.Br);
    final Queue<c<?>> Bd = new LinkedList();
    private ConnectionResult Be;
    private int Bf;
    private int Bg = 4;
    private int Bh = 0;
    private boolean Bi = false;
    private int Bj;
    private long Bk = 5000L;
    final Handler Bl;
    private final Bundle Bm = new Bundle();
    private final Map<Api.c<?>, Api.a> Bn = new HashMap();
    private boolean Bo;
    final Set<c<?>> Bp = new HashSet();
    final GoogleApiClient.ConnectionCallbacks Bq = new GoogleApiClient.ConnectionCallbacks() {
        public void onConnected(Bundle paramAnonymousBundle) {
            b.a(b.this).lock();
            try {
                if (b.b(b.this) == 1) {
                    if (paramAnonymousBundle != null) {
                        b.c(b.this).putAll(paramAnonymousBundle);
                    }
                    b.d(b.this);
                }
                return;
            } finally {
                b.a(b.this).unlock();
            }
        }

        public void onConnectionSuspended(int paramAnonymousInt) {
            b.a(b.this).lock();
            for (; ; ) {
                try {
                    b.a(b.this, paramAnonymousInt);
                    switch (paramAnonymousInt) {
                        default:
                            return;
                    }
                } finally {
                    b.a(b.this).unlock();
                }
                b.this.connect();
                continue;
                boolean bool = b.e(b.this);
                if (bool) {
                    b.a(b.this).unlock();
                    return;
                }
                b.b(b.this, 2);
                b.this.Bl.sendMessageDelayed(b.this.Bl.obtainMessage(1), b.f(b.this));
            }
        }
    };
    private final fg.b Br = new fg.b() {
        public Bundle dG() {
            return null;
        }

        public boolean em() {
            return b.g(b.this);
        }

        public boolean isConnected() {
            return b.this.isConnected();
        }
    };

    public b(Context paramContext, Looper paramLooper, fc paramfc, Map<Api<?>, Api.ApiOptions> paramMap, Set<GoogleApiClient.ConnectionCallbacks> paramSet, Set<GoogleApiClient.OnConnectionFailedListener> paramSet1) {
        this.AS = paramLooper;
        this.Bl = new b(paramLooper);
        paramSet = paramSet.iterator();
        final Object localObject1;
        while (paramSet.hasNext()) {
            localObject1 = (GoogleApiClient.ConnectionCallbacks) paramSet.next();
            this.Bc.registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) localObject1);
        }
        paramSet = paramSet1.iterator();
        while (paramSet.hasNext()) {
            paramSet1 = (GoogleApiClient.OnConnectionFailedListener) paramSet.next();
            this.Bc.registerConnectionFailedListener(paramSet1);
        }
        paramSet = paramMap.keySet().iterator();
        while (paramSet.hasNext()) {
            paramSet1 = (Api) paramSet.next();
            localObject1 = paramSet1.dY();
            Object localObject2 = paramMap.get(paramSet1);
            this.Bn.put(paramSet1.ea(), a((Api.b) localObject1, localObject2, paramContext, paramLooper, paramfc, this.Bq, new GoogleApiClient.OnConnectionFailedListener() {
                public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult) {
                    b.a(b.this).lock();
                    try {
                        if ((b.h(b.this) == null) || (localObject1.getPriority() < b.i(b.this))) {
                            b.a(b.this, paramAnonymousConnectionResult);
                            b.c(b.this, localObject1.getPriority());
                        }
                        b.d(b.this);
                        return;
                    } finally {
                        b.a(b.this).unlock();
                    }
                }
            }));
        }
    }

    private void E(int paramInt) {
        this.Ba.lock();
        Object localObject2;
        try {
            if (this.Bg == 3) {
                break label328;
            }
            if (paramInt != -1) {
                break label195;
            }
            if (isConnecting()) {
                Iterator localIterator1 = this.Bd.iterator();
                while (localIterator1.hasNext()) {
                    localObject2 = (c) localIterator1.next();
                    if (((c) localObject2).ef() != 1) {
                        ((c) localObject2).cancel();
                        localIterator1.remove();
                    }
                }
            }
            this.Bd.clear();
        } finally {
            this.Ba.unlock();
        }
        Iterator localIterator2 = this.Bp.iterator();
        while (localIterator2.hasNext()) {
            ((c) localIterator2.next()).cancel();
        }
        this.Bp.clear();
        if ((this.Be == null) && (!this.Bd.isEmpty())) {
            this.Bi = true;
            this.Ba.unlock();
            return;
        }
        label195:
        boolean bool1 = isConnecting();
        boolean bool2 = isConnected();
        this.Bg = 3;
        if (bool1) {
            if (paramInt == -1) {
                this.Be = null;
            }
            this.Bb.signalAll();
        }
        this.Bo = false;
        localIterator2 = this.Bn.values().iterator();
        while (localIterator2.hasNext()) {
            localObject2 = (Api.a) localIterator2.next();
            if (((Api.a) localObject2).isConnected()) {
                ((Api.a) localObject2).disconnect();
            }
        }
        this.Bo = true;
        this.Bg = 4;
        if (bool2) {
            if (paramInt != -1) {
                this.Bc.O(paramInt);
            }
            this.Bo = false;
        }
        label328:
        this.Ba.unlock();
    }

    private static <C extends Api.a, O> C a(Api.b<C, O> paramb, Object paramObject, Context paramContext, Looper paramLooper, fc paramfc, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
        return paramb.a(paramContext, paramLooper, paramfc, paramObject, paramConnectionCallbacks, paramOnConnectionFailedListener);
    }

    private <A extends Api.a> void a(c<A> paramc)
            throws DeadObjectException {
        boolean bool2 = true;
        this.Ba.lock();
        for (; ; ) {
            try {
                if (!isConnected()) {
                    if (ek()) {
                        break label154;
                        fq.a(bool1, "GoogleApiClient is not connected yet.");
                        if (paramc.ea() != null) {
                            bool1 = bool2;
                            fq.b(bool1, "This task can not be executed or enqueued (it's probably a Batch or malformed)");
                            this.Bp.add(paramc);
                            paramc.a(this.AL);
                            if (!ek()) {
                                continue;
                            }
                            paramc.k(new Status(8));
                        }
                    } else {
                        bool1 = false;
                        continue;
                    }
                    bool1 = false;
                    continue;
                    paramc.b(a(paramc.ea()));
                    return;
                }
            } finally {
                this.Ba.unlock();
            }
            label154:
            boolean bool1 = true;
        }
    }

    private void ei() {
        this.Ba.lock();
        for (; ; ) {
            try {
                this.Bj -= 1;
                if (this.Bj == 0) {
                    if (this.Be == null) {
                        break label128;
                    }
                    this.Bi = false;
                    E(3);
                    if (ek()) {
                        this.Bh -= 1;
                    }
                    if (ek()) {
                        this.Bl.sendMessageDelayed(this.Bl.obtainMessage(1), this.Bk);
                        this.Bo = false;
                    }
                } else {
                    return;
                }
                this.Bc.a(this.Be);
                continue;
                this.Bg = 2;
            } finally {
                this.Ba.unlock();
            }
            label128:
            el();
            this.Bb.signalAll();
            ej();
            if (!this.Bi) {
                break;
            }
            this.Bi = false;
            E(-1);
        }
        if (this.Bm.isEmpty()) {
        }
        for (Bundle localBundle = null; ; localBundle = this.Bm) {
            this.Bc.b(localBundle);
            break;
        }
    }

    private void ej() {
        boolean bool;
        if ((isConnected()) || (ek())) {
            bool = true;
        }
        for (; ; ) {
            fq.a(bool, "GoogleApiClient is not connected yet.");
            this.Ba.lock();
            try {
                for (; ; ) {
                    bool = this.Bd.isEmpty();
                    if (bool) {
                        break;
                    }
                    try {
                        a((c) this.Bd.remove());
                    } catch (DeadObjectException localDeadObjectException) {
                        Log.w("GoogleApiClientImpl", "Service died while flushing queue", localDeadObjectException);
                    }
                }
                bool = false;
            } finally {
                this.Ba.unlock();
            }
        }
        this.Ba.unlock();
    }

    /* Error */
    private boolean ek() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 72	com/google/android/gms/common/api/b:Ba	Ljava/util/concurrent/locks/Lock;
        //   4: invokeinterface 201 1 0
        //   9: aload_0
        //   10: getfield 89	com/google/android/gms/common/api/b:Bh	I
        //   13: istore_1
        //   14: iload_1
        //   15: ifeq +16 -> 31
        //   18: iconst_1
        //   19: istore_2
        //   20: aload_0
        //   21: getfield 72	com/google/android/gms/common/api/b:Ba	Ljava/util/concurrent/locks/Lock;
        //   24: invokeinterface 220 1 0
        //   29: iload_2
        //   30: ireturn
        //   31: iconst_0
        //   32: istore_2
        //   33: goto -13 -> 20
        //   36: astore_3
        //   37: aload_0
        //   38: getfield 72	com/google/android/gms/common/api/b:Ba	Ljava/util/concurrent/locks/Lock;
        //   41: invokeinterface 220 1 0
        //   46: aload_3
        //   47: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	48	0	this	b
        //   13	2	1	i	int
        //   19	14	2	bool	boolean
        //   36	11	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	14	36	finally
    }

    private void el() {
        this.Ba.lock();
        try {
            this.Bh = 0;
            this.Bl.removeMessages(1);
            return;
        } finally {
            this.Ba.unlock();
        }
    }

    public <C extends Api.a> C a(Api.c<C> paramc) {
        paramc = (Api.a) this.Bn.get(paramc);
        fq.b(paramc, "Appropriate Api was not requested.");
        return paramc;
    }

    /* Error */
    public <A extends Api.a, T extends a.b<? extends Result, A>> T a(T paramT) {
        // Byte code:
        //   0: aload_0
        //   1: getfield 72	com/google/android/gms/common/api/b:Ba	Ljava/util/concurrent/locks/Lock;
        //   4: invokeinterface 201 1 0
        //   9: aload_0
        //   10: invokevirtual 232	com/google/android/gms/common/api/b:isConnected	()Z
        //   13: ifeq +20 -> 33
        //   16: aload_0
        //   17: aload_1
        //   18: invokevirtual 374	com/google/android/gms/common/api/b:b	(Lcom/google/android/gms/common/api/a$b;)Lcom/google/android/gms/common/api/a$b;
        //   21: pop
        //   22: aload_0
        //   23: getfield 72	com/google/android/gms/common/api/b:Ba	Ljava/util/concurrent/locks/Lock;
        //   26: invokeinterface 220 1 0
        //   31: aload_1
        //   32: areturn
        //   33: aload_0
        //   34: getfield 85	com/google/android/gms/common/api/b:Bd	Ljava/util/Queue;
        //   37: aload_1
        //   38: invokeinterface 375 2 0
        //   43: pop
        //   44: goto -22 -> 22
        //   47: astore_1
        //   48: aload_0
        //   49: getfield 72	com/google/android/gms/common/api/b:Ba	Ljava/util/concurrent/locks/Lock;
        //   52: invokeinterface 220 1 0
        //   57: aload_1
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	b
        //   0	59	1	paramT	T
        // Exception table:
        //   from	to	target	type
        //   9	22	47	finally
        //   33	44	47	finally
    }

    public <A extends Api.a, T extends a.b<? extends Result, A>> T b(T paramT) {
        if ((isConnected()) || (ek())) {
        }
        for (boolean bool = true; ; bool = false) {
            fq.a(bool, "GoogleApiClient is not connected yet.");
            ej();
            try {
                a(paramT);
                return paramT;
            } catch (DeadObjectException localDeadObjectException) {
                E(1);
            }
        }
        return paramT;
    }

    public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit) {
        boolean bool;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            bool = true;
        }
        for (; ; ) {
            fq.a(bool, "blockingConnect must not be called on the UI thread");
            this.Ba.lock();
            try {
                connect();
                paramLong = paramTimeUnit.toNanos(paramLong);
                for (; ; ) {
                    bool = isConnecting();
                    if (!bool) {
                        break;
                    }
                    try {
                        long l = this.Bb.awaitNanos(paramLong);
                        paramLong = l;
                        if (l <= 0L) {
                            paramTimeUnit = new ConnectionResult(14, null);
                            return paramTimeUnit;
                        }
                    } catch (InterruptedException paramTimeUnit) {
                        Thread.currentThread().interrupt();
                        paramTimeUnit = new ConnectionResult(15, null);
                        return paramTimeUnit;
                    }
                }
                bool = false;
                continue;
                if (isConnected()) {
                    paramTimeUnit = ConnectionResult.Ag;
                    return paramTimeUnit;
                }
                if (this.Be != null) {
                    paramTimeUnit = this.Be;
                    return paramTimeUnit;
                }
                paramTimeUnit = new ConnectionResult(13, null);
                return paramTimeUnit;
            } finally {
                this.Ba.unlock();
            }
        }
    }

    public void connect() {
        this.Ba.lock();
        try {
            this.Bi = false;
            if (!isConnected()) {
                boolean bool = isConnecting();
                if (!bool) {
                }
            } else {
                return;
            }
            this.Bo = true;
            this.Be = null;
            this.Bg = 1;
            this.Bm.clear();
            this.Bj = this.Bn.size();
            Iterator localIterator = this.Bn.values().iterator();
            while (localIterator.hasNext()) {
                ((Api.a) localIterator.next()).connect();
            }
        } finally {
            this.Ba.unlock();
        }
    }

    public void disconnect() {
        el();
        E(-1);
    }

    public Looper getLooper() {
        return this.AS;
    }

    /* Error */
    public boolean isConnected() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 72	com/google/android/gms/common/api/b:Ba	Ljava/util/concurrent/locks/Lock;
        //   4: invokeinterface 201 1 0
        //   9: aload_0
        //   10: getfield 87	com/google/android/gms/common/api/b:Bg	I
        //   13: istore_1
        //   14: iload_1
        //   15: iconst_2
        //   16: if_icmpne +16 -> 32
        //   19: iconst_1
        //   20: istore_2
        //   21: aload_0
        //   22: getfield 72	com/google/android/gms/common/api/b:Ba	Ljava/util/concurrent/locks/Lock;
        //   25: invokeinterface 220 1 0
        //   30: iload_2
        //   31: ireturn
        //   32: iconst_0
        //   33: istore_2
        //   34: goto -13 -> 21
        //   37: astore_3
        //   38: aload_0
        //   39: getfield 72	com/google/android/gms/common/api/b:Ba	Ljava/util/concurrent/locks/Lock;
        //   42: invokeinterface 220 1 0
        //   47: aload_3
        //   48: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	49	0	this	b
        //   13	4	1	i	int
        //   20	14	2	bool	boolean
        //   37	11	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	14	37	finally
    }

    /* Error */
    public boolean isConnecting() {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: aload_0
        //   3: getfield 72	com/google/android/gms/common/api/b:Ba	Ljava/util/concurrent/locks/Lock;
        //   6: invokeinterface 201 1 0
        //   11: aload_0
        //   12: getfield 87	com/google/android/gms/common/api/b:Bg	I
        //   15: istore_1
        //   16: iload_1
        //   17: iconst_1
        //   18: if_icmpne +14 -> 32
        //   21: aload_0
        //   22: getfield 72	com/google/android/gms/common/api/b:Ba	Ljava/util/concurrent/locks/Lock;
        //   25: invokeinterface 220 1 0
        //   30: iload_2
        //   31: ireturn
        //   32: iconst_0
        //   33: istore_2
        //   34: goto -13 -> 21
        //   37: astore_3
        //   38: aload_0
        //   39: getfield 72	com/google/android/gms/common/api/b:Ba	Ljava/util/concurrent/locks/Lock;
        //   42: invokeinterface 220 1 0
        //   47: aload_3
        //   48: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	49	0	this	b
        //   15	4	1	i	int
        //   1	33	2	bool	boolean
        //   37	11	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   11	16	37	finally
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
        return this.Bc.isConnectionCallbacksRegistered(paramConnectionCallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
        return this.Bc.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
        this.Bc.registerConnectionCallbacks(paramConnectionCallbacks);
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
        this.Bc.registerConnectionFailedListener(paramOnConnectionFailedListener);
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
        this.Bc.unregisterConnectionCallbacks(paramConnectionCallbacks);
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
        this.Bc.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
    }

    static abstract interface a {
        public abstract void b(b.c<?> paramc);
    }

    class b
            extends Handler {
        b(Looper paramLooper) {
            super();
        }

        public void handleMessage(Message paramMessage) {
            if (paramMessage.what == 1) {
                b.a(b.this).lock();
                try {
                    if ((!b.this.isConnected()) && (!b.this.isConnecting())) {
                        b.this.connect();
                    }
                    return;
                } finally {
                    b.a(b.this).unlock();
                }
            }
            Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
        }
    }

    static abstract interface c<A extends Api.a> {
        public abstract void a(b.a parama);

        public abstract void b(A paramA)
                throws DeadObjectException;

        public abstract void cancel();

        public abstract Api.c<A> ea();

        public abstract int ef();

        public abstract void k(Status paramStatus);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/common/api/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */