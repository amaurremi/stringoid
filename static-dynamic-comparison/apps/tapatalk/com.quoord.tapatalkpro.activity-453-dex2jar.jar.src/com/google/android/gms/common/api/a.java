package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.fk;
import com.google.android.gms.internal.fq;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class a {
    public static abstract class a<R extends Result>
            implements PendingResult<R>, a.d<R> {
        private final Object AB = new Object();
        private a.c<R> AC;
        private final CountDownLatch AD = new CountDownLatch(1);
        private final ArrayList<PendingResult.a> AE = new ArrayList();
        private ResultCallback<R> AF;
        private volatile R AG;
        private volatile boolean AH;
        private boolean AI;
        private boolean AJ;
        private fk AK;

        a() {
        }

        public a(Looper paramLooper) {
            this.AC = new a.c(paramLooper);
        }

        public a(a.c<R> paramc) {
            this.AC = paramc;
        }

        private void b(R paramR) {
            this.AG = paramR;
            this.AK = null;
            this.AD.countDown();
            paramR = this.AG.getStatus();
            if (this.AF != null) {
                this.AC.eg();
                if (!this.AI) {
                    this.AC.a(this.AF, eb());
                }
            }
            Iterator localIterator = this.AE.iterator();
            while (localIterator.hasNext()) {
                ((PendingResult.a) localIterator.next()).l(paramR);
            }
            this.AE.clear();
        }

        private void c(Result paramResult) {
            if ((paramResult instanceof Releasable)) {
            }
            try {
                ((Releasable) paramResult).release();
                return;
            } catch (Exception paramResult) {
                Log.w("AbstractPendingResult", "Unable to release " + this, paramResult);
            }
        }

        private R eb() {
            for (; ; ) {
                synchronized (this.AB) {
                    if (!this.AH) {
                        bool = true;
                        fq.a(bool, "Result has already been consumed.");
                        fq.a(isReady(), "Result is not ready.");
                        Result localResult = this.AG;
                        ec();
                        return localResult;
                    }
                }
                boolean bool = false;
            }
        }

        private void ed() {
            synchronized (this.AB) {
                if (!isReady()) {
                    a(d(Status.Bw));
                    this.AJ = true;
                }
                return;
            }
        }

        private void ee() {
            synchronized (this.AB) {
                if (!isReady()) {
                    a(d(Status.By));
                    this.AJ = true;
                }
                return;
            }
        }

        public final void a(PendingResult.a parama) {
            if (!this.AH) {
            }
            for (boolean bool = true; ; bool = false) {
                fq.a(bool, "Result has already been consumed.");
                synchronized (this.AB) {
                    if (isReady()) {
                        parama.l(this.AG.getStatus());
                        return;
                    }
                    this.AE.add(parama);
                }
            }
        }

        public final void a(R paramR) {
            boolean bool2 = true;
            for (; ; ) {
                synchronized (this.AB) {
                    if ((this.AJ) || (this.AI)) {
                        c(paramR);
                        return;
                    }
                    if (!isReady()) {
                        bool1 = true;
                        fq.a(bool1, "Results have already been set");
                        if (this.AH) {
                            break label84;
                        }
                        bool1 = bool2;
                        fq.a(bool1, "Result has already been consumed");
                        b(paramR);
                        return;
                    }
                }
                boolean bool1 = false;
                continue;
                label84:
                bool1 = false;
            }
        }

        protected void a(a.c<R> paramc) {
            this.AC = paramc;
        }

        protected final void a(fk paramfk) {
            synchronized (this.AB) {
                this.AK = paramfk;
                return;
            }
        }

        public final R await() {
            boolean bool2 = false;
            boolean bool1;
            if (!this.AH) {
                bool1 = true;
            }
            for (; ; ) {
                fq.a(bool1, "Result has already been consumed");
                if (!isReady()) {
                    bool1 = bool2;
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                    }
                } else {
                    bool1 = true;
                }
                fq.a(bool1, "await must not be called on the UI thread");
                try {
                    this.AD.await();
                    fq.a(isReady(), "Result is not ready.");
                    return eb();
                    bool1 = false;
                } catch (InterruptedException localInterruptedException) {
                    for (; ; ) {
                        ed();
                    }
                }
            }
        }

        public final R await(long paramLong, TimeUnit paramTimeUnit) {
            boolean bool2 = false;
            boolean bool1;
            if (!this.AH) {
                bool1 = true;
            }
            for (; ; ) {
                fq.a(bool1, "Result has already been consumed.");
                if (!isReady()) {
                    bool1 = bool2;
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                    }
                } else {
                    bool1 = true;
                }
                fq.a(bool1, "await must not be called on the UI thread");
                try {
                    if (!this.AD.await(paramLong, paramTimeUnit)) {
                        ee();
                    }
                    fq.a(isReady(), "Result is not ready.");
                    return eb();
                    bool1 = false;
                } catch (InterruptedException paramTimeUnit) {
                    for (; ; ) {
                        ed();
                    }
                }
            }
        }

        public void cancel() {
            synchronized (this.AB) {
                if (this.AI) {
                    return;
                }
                fk localfk = this.AK;
                if (localfk == null) {
                }
            }
            try {
                this.AK.cancel();
                c(this.AG);
                this.AF = null;
                this.AI = true;
                b(d(Status.Bz));
                return;
                localObject2 =finally;
                throw ((Throwable) localObject2);
            } catch (RemoteException localRemoteException) {
                for (; ; ) {
                }
            }
        }

        protected abstract R d(Status paramStatus);

        protected void ec() {
            this.AH = true;
            this.AG = null;
            this.AF = null;
        }

        public boolean isCanceled() {
            synchronized (this.AB) {
                boolean bool = this.AI;
                return bool;
            }
        }

        public final boolean isReady() {
            return this.AD.getCount() == 0L;
        }

        public final void setResultCallback(ResultCallback<R> paramResultCallback) {
            if (!this.AH) {
            }
            for (boolean bool = true; ; bool = false) {
                fq.a(bool, "Result has already been consumed.");
                for (; ; ) {
                    synchronized (this.AB) {
                        if (isCanceled()) {
                            return;
                        }
                        if (isReady()) {
                            this.AC.a(paramResultCallback, eb());
                            return;
                        }
                    }
                    this.AF = paramResultCallback;
                }
            }
        }

        public final void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit) {
            if (!this.AH) {
            }
            for (boolean bool = true; ; bool = false) {
                fq.a(bool, "Result has already been consumed.");
                for (; ; ) {
                    synchronized (this.AB) {
                        if (isCanceled()) {
                            return;
                        }
                        if (isReady()) {
                            this.AC.a(paramResultCallback, eb());
                            return;
                        }
                    }
                    this.AF = paramResultCallback;
                    this.AC.a(this, paramTimeUnit.toMillis(paramLong));
                }
            }
        }
    }

    public static abstract class b<R extends Result, A extends Api.a>
            extends a.a<R>
            implements b.c<A> {
        private b.a AL;
        private final Api.c<A> Az;

        protected b(Api.c<A> paramc) {
            this.Az = ((Api.c) fq.f(paramc));
        }

        private void a(RemoteException paramRemoteException) {
            k(new Status(8, paramRemoteException.getLocalizedMessage(), null));
        }

        protected abstract void a(A paramA)
                throws RemoteException;

        public void a(b.a parama) {
            this.AL = parama;
        }

        public final void b(A paramA)
                throws DeadObjectException {
            a(new a.c(paramA.getLooper()));
            try {
                a(paramA);
                return;
            } catch (DeadObjectException paramA) {
                a(paramA);
                throw paramA;
            } catch (RemoteException paramA) {
                a(paramA);
            }
        }

        public final Api.c<A> ea() {
            return this.Az;
        }

        protected void ec() {
            super.ec();
            if (this.AL != null) {
                this.AL.b(this);
                this.AL = null;
            }
        }

        public int ef() {
            return 0;
        }

        public final void k(Status paramStatus) {
            if (!paramStatus.isSuccess()) {
            }
            for (boolean bool = true; ; bool = false) {
                fq.b(bool, "Failed result must not be success");
                a(d(paramStatus));
                return;
            }
        }
    }

    public static class c<R extends Result>
            extends Handler {
        public c() {
            this(Looper.getMainLooper());
        }

        public c(Looper paramLooper) {
            super();
        }

        public void a(ResultCallback<R> paramResultCallback, R paramR) {
            sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
        }

        public void a(a.a<R> parama, long paramLong) {
            sendMessageDelayed(obtainMessage(2, parama), paramLong);
        }

        protected void b(ResultCallback<R> paramResultCallback, R paramR) {
            paramResultCallback.onResult(paramR);
        }

        public void eg() {
            removeMessages(2);
        }

        public void handleMessage(Message paramMessage) {
            switch (paramMessage.what) {
                default:
                    Log.wtf("GoogleApi", "Don't know how to handle this message.");
                    return;
                case 1:
                    paramMessage = (Pair) paramMessage.obj;
                    b((ResultCallback) paramMessage.first, (Result) paramMessage.second);
                    return;
            }
            a.a.a((a.a) paramMessage.obj);
        }
    }

    public static abstract interface d<R> {
        public abstract void b(R paramR);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/common/api/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */