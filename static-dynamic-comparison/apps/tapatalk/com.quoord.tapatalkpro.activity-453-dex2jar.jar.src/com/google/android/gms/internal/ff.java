package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.a;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.data.DataHolder;

import java.util.ArrayList;

public abstract class ff<T extends IInterface>
        implements GooglePlayServicesClient, Api.a, fg.b {
    public static final String[] Dg = {"service_esmobile", "service_googleme"};
    private final Looper AS;
    private final fg Bc;
    private T Da;
    private final ArrayList<ff<T>.b<?>> Db = new ArrayList();
    private ff<T>.f Dc;
    private volatile int Dd = 1;
    private final String[] De;
    boolean Df = false;
    private final Context mContext;
    final Handler mHandler;

    protected ff(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs) {
        this.mContext = ((Context) fq.f(paramContext));
        this.AS = ((Looper) fq.b(paramLooper, "Looper must not be null"));
        this.Bc = new fg(paramContext, paramLooper, this);
        this.mHandler = new a(paramLooper);
        b(paramVarArgs);
        this.De = paramVarArgs;
        registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) fq.f(paramConnectionCallbacks));
        registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) fq.f(paramOnConnectionFailedListener));
    }

    protected ff(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs) {
        this(paramContext, paramContext.getMainLooper(), new c(paramConnectionCallbacks), new g(paramOnConnectionFailedListener), paramVarArgs);
    }

    private void M(int paramInt) {
        int i = this.Dd;
        this.Dd = paramInt;
        if (i != paramInt) {
            if (paramInt != 3) {
                break label25;
            }
            onConnected();
        }
        label25:
        while ((i != 3) || (paramInt != 1)) {
            return;
        }
        onDisconnected();
    }

    public void N(int paramInt) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(paramInt)));
    }

    protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new h(paramInt, paramIBinder, paramBundle)));
    }

    public final void a(ff<T>.b<?> paramff) {
        synchronized (this.Db) {
            this.Db.add(paramff);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(2, paramff));
            return;
        }
    }

    protected abstract void a(fm paramfm, e parame)
            throws RemoteException;

    protected void b(String... paramVarArgs) {
    }

    protected final void bT() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected abstract String bg();

    protected abstract String bh();

    public void connect() {
        this.Df = true;
        M(2);
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (i != 0) {
            M(1);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(i)));
        }
        do {
            return;
            if (this.Dc != null) {
                Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
                this.Da = null;
                fh.x(this.mContext).b(bg(), this.Dc);
            }
            this.Dc = new f();
        } while (fh.x(this.mContext).a(bg(), this.Dc));
        Log.e("GmsClient", "unable to connect to service: " + bg());
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
    }

    public Bundle dG() {
        return null;
    }

    public void disconnect() {
        this.Df = false;
        synchronized (this.Db) {
            int j = this.Db.size();
            int i = 0;
            while (i < j) {
                ((b) this.Db.get(i)).eO();
                i += 1;
            }
            this.Db.clear();
            M(1);
            this.Da = null;
            if (this.Dc != null) {
                fh.x(this.mContext).b(bg(), this.Dc);
                this.Dc = null;
            }
            return;
        }
    }

    public final String[] eL() {
        return this.De;
    }

    protected final T eM() {
        bT();
        return this.Da;
    }

    public boolean em() {
        return this.Df;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.AS;
    }

    public boolean isConnected() {
        return this.Dd == 3;
    }

    public boolean isConnecting() {
        return this.Dd == 2;
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks) {
        return this.Bc.isConnectionCallbacksRegistered(new c(paramConnectionCallbacks));
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
        return this.Bc.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
    }

    protected void onConnected() {
    }

    protected void onDisconnected() {
    }

    protected abstract T r(IBinder paramIBinder);

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks) {
        this.Bc.registerConnectionCallbacks(new c(paramConnectionCallbacks));
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
        this.Bc.registerConnectionCallbacks(paramConnectionCallbacks);
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
        this.Bc.registerConnectionFailedListener(paramOnConnectionFailedListener);
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
        this.Bc.registerConnectionFailedListener(paramOnConnectionFailedListener);
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks) {
        this.Bc.unregisterConnectionCallbacks(new c(paramConnectionCallbacks));
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
        this.Bc.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
    }

    protected final void z(IBinder paramIBinder) {
        try {
            a(fm.a.C(paramIBinder), new e(this));
            return;
        } catch (RemoteException paramIBinder) {
            Log.w("GmsClient", "service died");
        }
    }

    final class a
            extends Handler {
        public a(Looper paramLooper) {
            super();
        }

        public void handleMessage(Message paramMessage) {
            if ((paramMessage.what == 1) && (!ff.this.isConnecting())) {
                paramMessage = (ff.b) paramMessage.obj;
                paramMessage.dx();
                paramMessage.unregister();
                return;
            }
            if (paramMessage.what == 3) {
                ff.a(ff.this).a(new ConnectionResult(((Integer) paramMessage.obj).intValue(), null));
                return;
            }
            if (paramMessage.what == 4) {
                ff.a(ff.this, 1);
                ff.a(ff.this, null);
                ff.a(ff.this).O(((Integer) paramMessage.obj).intValue());
                return;
            }
            if ((paramMessage.what == 2) && (!ff.this.isConnected())) {
                paramMessage = (ff.b) paramMessage.obj;
                paramMessage.dx();
                paramMessage.unregister();
                return;
            }
            if ((paramMessage.what == 2) || (paramMessage.what == 1)) {
                ((ff.b) paramMessage.obj).eN();
                return;
            }
            Log.wtf("GmsClient", "Don't know how to handle this message.");
        }
    }

    protected abstract class b<TListener> {
        private boolean Di;
        private TListener mListener;

        public b() {
            Object localObject;
            this.mListener = localObject;
            this.Di = false;
        }

        protected abstract void a(TListener paramTListener);

        protected abstract void dx();

        /* Error */
        public void eN() {
            // Byte code:
            //   0: aload_0
            //   1: monitorenter
            //   2: aload_0
            //   3: getfield 24	com/google/android/gms/internal/ff$b:mListener	Ljava/lang/Object;
            //   6: astore_1
            //   7: aload_0
            //   8: getfield 26	com/google/android/gms/internal/ff$b:Di	Z
            //   11: ifeq +33 -> 44
            //   14: ldc 37
            //   16: new 39	java/lang/StringBuilder
            //   19: dup
            //   20: invokespecial 40	java/lang/StringBuilder:<init>	()V
            //   23: ldc 42
            //   25: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   28: aload_0
            //   29: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   32: ldc 51
            //   34: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   37: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   40: invokestatic 61	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
            //   43: pop
            //   44: aload_0
            //   45: monitorexit
            //   46: aload_1
            //   47: ifnull +34 -> 81
            //   50: aload_0
            //   51: aload_1
            //   52: invokevirtual 63	com/google/android/gms/internal/ff$b:a	(Ljava/lang/Object;)V
            //   55: aload_0
            //   56: monitorenter
            //   57: aload_0
            //   58: iconst_1
            //   59: putfield 26	com/google/android/gms/internal/ff$b:Di	Z
            //   62: aload_0
            //   63: monitorexit
            //   64: aload_0
            //   65: invokevirtual 66	com/google/android/gms/internal/ff$b:unregister	()V
            //   68: return
            //   69: astore_1
            //   70: aload_0
            //   71: monitorexit
            //   72: aload_1
            //   73: athrow
            //   74: astore_1
            //   75: aload_0
            //   76: invokevirtual 68	com/google/android/gms/internal/ff$b:dx	()V
            //   79: aload_1
            //   80: athrow
            //   81: aload_0
            //   82: invokevirtual 68	com/google/android/gms/internal/ff$b:dx	()V
            //   85: goto -30 -> 55
            //   88: astore_1
            //   89: aload_0
            //   90: monitorexit
            //   91: aload_1
            //   92: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	93	0	this	b
            //   6	46	1	localObject1	Object
            //   69	4	1	localObject2	Object
            //   74	6	1	localRuntimeException	RuntimeException
            //   88	4	1	localObject3	Object
            // Exception table:
            //   from	to	target	type
            //   2	44	69	finally
            //   44	46	69	finally
            //   70	72	69	finally
            //   50	55	74	java/lang/RuntimeException
            //   57	64	88	finally
            //   89	91	88	finally
        }

        public void eO() {
            try {
                this.mListener = null;
                return;
            } finally {
            }
        }

        public void unregister() {
            eO();
            synchronized (ff.b(ff.this)) {
                ff.b(ff.this).remove(this);
                return;
            }
        }
    }

    public static final class c
            implements GoogleApiClient.ConnectionCallbacks {
        private final GooglePlayServicesClient.ConnectionCallbacks Dj;

        public c(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks) {
            this.Dj = paramConnectionCallbacks;
        }

        public boolean equals(Object paramObject) {
            if ((paramObject instanceof c)) {
                return this.Dj.equals(((c) paramObject).Dj);
            }
            return this.Dj.equals(paramObject);
        }

        public void onConnected(Bundle paramBundle) {
            this.Dj.onConnected(paramBundle);
        }

        public void onConnectionSuspended(int paramInt) {
            this.Dj.onDisconnected();
        }
    }

    public abstract class d<TListener>
            extends ff<T>.b<TListener> {
        private final DataHolder BB;

        public d(DataHolder paramDataHolder) {
            super(paramDataHolder);
            DataHolder localDataHolder;
            this.BB = localDataHolder;
        }

        protected final void a(TListener paramTListener) {
            a(paramTListener, this.BB);
        }

        protected abstract void a(TListener paramTListener, DataHolder paramDataHolder);

        protected void dx() {
            if (this.BB != null) {
                this.BB.close();
            }
        }
    }

    public static final class e
            extends fl.a {
        private ff Dk;

        public e(ff paramff) {
            this.Dk = paramff;
        }

        public void b(int paramInt, IBinder paramIBinder, Bundle paramBundle) {
            fq.b("onPostInitComplete can be called only once per call to getServiceFromBroker", this.Dk);
            this.Dk.a(paramInt, paramIBinder, paramBundle);
            this.Dk = null;
        }
    }

    final class f
            implements ServiceConnection {
        f() {
        }

        public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
            ff.this.z(paramIBinder);
        }

        public void onServiceDisconnected(ComponentName paramComponentName) {
            ff.this.mHandler.sendMessage(ff.this.mHandler.obtainMessage(4, Integer.valueOf(1)));
        }
    }

    public static final class g
            implements GoogleApiClient.OnConnectionFailedListener {
        private final GooglePlayServicesClient.OnConnectionFailedListener Dl;

        public g(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
            this.Dl = paramOnConnectionFailedListener;
        }

        public boolean equals(Object paramObject) {
            if ((paramObject instanceof g)) {
                return this.Dl.equals(((g) paramObject).Dl);
            }
            return this.Dl.equals(paramObject);
        }

        public void onConnectionFailed(ConnectionResult paramConnectionResult) {
            this.Dl.onConnectionFailed(paramConnectionResult);
        }
    }

    protected final class h
            extends ff<T>.b<Boolean> {
        public final Bundle Dm;
        public final IBinder Dn;
        public final int statusCode;

        public h(int paramInt, IBinder paramIBinder, Bundle paramBundle) {
            super(Boolean.valueOf(true));
            this.statusCode = paramInt;
            this.Dn = paramIBinder;
            this.Dm = paramBundle;
        }

        protected void b(Boolean paramBoolean) {
            if (paramBoolean == null) {
                ff.a(ff.this, 1);
                return;
            }
            switch (this.statusCode) {
                default:
                    if (this.Dm == null) {
                        break;
                    }
            }
            for (paramBoolean = (PendingIntent) this.Dm.getParcelable("pendingIntent"); ; paramBoolean = null) {
                if (ff.d(ff.this) != null) {
                    fh.x(ff.e(ff.this)).b(ff.this.bg(), ff.d(ff.this));
                    ff.a(ff.this, null);
                }
                ff.a(ff.this, 1);
                ff.a(ff.this, null);
                ff.a(ff.this).a(new ConnectionResult(this.statusCode, paramBoolean));
                return;
                try {
                    paramBoolean = this.Dn.getInterfaceDescriptor();
                    if (ff.this.bh().equals(paramBoolean)) {
                        ff.a(ff.this, ff.this.r(this.Dn));
                        if (ff.c(ff.this) != null) {
                            ff.a(ff.this, 3);
                            ff.a(ff.this).bV();
                            return;
                        }
                    }
                } catch (RemoteException paramBoolean) {
                    fh.x(ff.e(ff.this)).b(ff.this.bg(), ff.d(ff.this));
                    ff.a(ff.this, null);
                    ff.a(ff.this, 1);
                    ff.a(ff.this, null);
                    ff.a(ff.this).a(new ConnectionResult(8, null));
                    return;
                }
                ff.a(ff.this, 1);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            }
        }

        protected void dx() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */