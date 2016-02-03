package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class en
        extends ff<ep> {
    private static final er zb = new er("CastClientImpl");
    private static final Object zs = new Object();
    private static final Object zt = new Object();
    private final Handler mHandler;
    private final Cast.Listener xX;
    private double yC;
    private boolean yD;
    private ApplicationMetadata zc;
    private final CastDevice zd;
    private final eq ze;
    private final Map<String, Cast.MessageReceivedCallback> zf;
    private final long zg;
    private String zh;
    private boolean zi;
    private boolean zj;
    private final AtomicLong zk;
    private String zl;
    private String zm;
    private Bundle zn;
    private Map<Long, a.d<Status>> zo;
    private b zp;
    private a.d<Cast.ApplicationConnectionResult> zq;
    private a.d<Status> zr;

    public en(Context paramContext, Looper paramLooper, CastDevice paramCastDevice, long paramLong, Cast.Listener paramListener, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
        super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[]) null);
        this.zd = paramCastDevice;
        this.xX = paramListener;
        this.zg = paramLong;
        this.mHandler = new Handler(paramLooper);
        this.zf = new HashMap();
        this.zj = false;
        this.zc = null;
        this.zh = null;
        this.yC = 0.0D;
        this.yD = false;
        this.zk = new AtomicLong(0L);
        this.zo = new HashMap();
        this.zp = new b(null);
        registerConnectionFailedListener(this.zp);
        this.ze = new eq.a() {
            private boolean D(int paramAnonymousInt) {
                synchronized () {
                    if (en.h(en.this) != null) {
                        en.h(en.this).b(new Status(paramAnonymousInt));
                        en.b(en.this, null);
                        return true;
                    }
                    return false;
                }
            }

            private void b(long paramAnonymousLong, int paramAnonymousInt) {
                synchronized (en.g(en.this)) {
                    a.d locald = (a.d) en.g(en.this).remove(Long.valueOf(paramAnonymousLong));
                    if (locald != null) {
                        locald.b(new Status(paramAnonymousInt));
                    }
                    return;
                }
            }

            public void A(int paramAnonymousInt) {
                synchronized () {
                    if (en.b(en.this) != null) {
                        en.b(en.this).b(new en.a(new Status(paramAnonymousInt)));
                        en.a(en.this, null);
                    }
                    return;
                }
            }

            public void B(int paramAnonymousInt) {
                D(paramAnonymousInt);
            }

            public void C(int paramAnonymousInt) {
                D(paramAnonymousInt);
            }

            public void a(ApplicationMetadata paramAnonymousApplicationMetadata, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean) {
                en.a(en.this, paramAnonymousApplicationMetadata);
                en.a(en.this, paramAnonymousApplicationMetadata.getApplicationId());
                en.b(en.this, paramAnonymousString2);
                synchronized (en.dM()) {
                    if (en.b(en.this) != null) {
                        en.b(en.this).b(new en.a(new Status(0), paramAnonymousApplicationMetadata, paramAnonymousString1, paramAnonymousString2, paramAnonymousBoolean));
                        en.a(en.this, null);
                    }
                    return;
                }
            }

            public void a(String paramAnonymousString, long paramAnonymousLong) {
                b(paramAnonymousLong, 0);
            }

            public void a(String paramAnonymousString, long paramAnonymousLong, int paramAnonymousInt) {
                b(paramAnonymousLong, paramAnonymousInt);
            }

            public void b(final String paramAnonymousString, final double paramAnonymousDouble, boolean paramAnonymousBoolean) {
                en.d(en.this).post(new Runnable() {
                    public void run() {
                        en.a(en.this, paramAnonymousString, paramAnonymousDouble, this.yR);
                    }
                });
            }

            public void b(String paramAnonymousString, byte[] paramAnonymousArrayOfByte) {
                en.dL().b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", new Object[]{paramAnonymousString, Integer.valueOf(paramAnonymousArrayOfByte.length)});
            }

            public void d(final String paramAnonymousString1, final String paramAnonymousString2) {
                en.dL().b("Receive (type=text, ns=%s) %s", new Object[]{paramAnonymousString1, paramAnonymousString2});
                en.d(en.this).post(new Runnable() {
                    public void run() {
                        synchronized (en.e(en.this)) {
                            Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback) en.e(en.this).get(paramAnonymousString1);
                            if (localMessageReceivedCallback != null) {
                                localMessageReceivedCallback.onMessageReceived(en.f(en.this), paramAnonymousString1, paramAnonymousString2);
                                return;
                            }
                        }
                        en.dL().b("Discarded message for unknown namespace '%s'", new Object[]{paramAnonymousString1});
                    }
                });
            }

            public void onApplicationDisconnected(final int paramAnonymousInt) {
                en.a(en.this, null);
                en.b(en.this, null);
                if (D(paramAnonymousInt)) {
                }
                while (en.c(en.this) == null) {
                    return;
                }
                en.d(en.this).post(new Runnable() {
                    public void run() {
                        if (en.c(en.this) != null) {
                            en.c(en.this).onApplicationDisconnected(paramAnonymousInt);
                        }
                    }
                });
            }

            public void z(int paramAnonymousInt) {
                en.dL().b("ICastDeviceControllerListener.onDisconnected: %d", new Object[]{Integer.valueOf(paramAnonymousInt)});
                en.a(en.this, false);
                en.a(en.this, null);
                if (paramAnonymousInt != 0) {
                    en.this.N(2);
                }
            }
        };
    }

    private void a(String paramString, double paramDouble, boolean paramBoolean) {
        if (!eo.a(paramString, this.zh)) {
            this.zh = paramString;
        }
        for (int i = 1; ; i = 0) {
            if ((this.xX != null) && ((i != 0) || (this.zi))) {
                this.xX.onApplicationStatusChanged();
            }
            if (paramDouble != this.yC) {
                this.yC = paramDouble;
            }
            for (boolean bool = true; ; bool = false) {
                if (paramBoolean != this.yD) {
                    this.yD = paramBoolean;
                    bool = true;
                }
                zb.b("hasChange=%b, mFirstStatusUpdate=%b", new Object[]{Boolean.valueOf(bool), Boolean.valueOf(this.zi)});
                if ((this.xX != null) && ((bool) || (this.zi))) {
                    this.xX.onVolumeChanged();
                }
                this.zi = false;
                return;
            }
        }
    }

    private void d(a.d<Cast.ApplicationConnectionResult> paramd) {
        synchronized (zs) {
            if (this.zq != null) {
                this.zq.b(new a(new Status(2002)));
            }
            this.zq = paramd;
            return;
        }
    }

    private void dJ() {
        zb.b("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zf) {
            this.zf.clear();
            return;
        }
    }

    private void dK()
            throws IllegalStateException {
        if (!this.zj) {
            throw new IllegalStateException("not connected to a device");
        }
    }

    private void f(a.d<Status> paramd) {
        synchronized (zt) {
            if (this.zr != null) {
                paramd.b(new Status(2001));
                return;
            }
            this.zr = paramd;
            return;
        }
    }

    public void V(String paramString)
            throws IllegalArgumentException, RemoteException {
        if (TextUtils.isEmpty(paramString)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.zf) {
            Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback) this.zf.remove(paramString);
            if (localMessageReceivedCallback == null) {
            }
        }
    }

    public void a(double paramDouble)
            throws IllegalArgumentException, IllegalStateException, RemoteException {
        if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
            throw new IllegalArgumentException("Volume cannot be " + paramDouble);
        }
        ((ep) eM()).a(paramDouble, this.yC, this.yD);
    }

    protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle) {
        if ((paramInt == 0) || (paramInt == 1001)) {
            this.zj = true;
            this.zi = true;
        }
        for (; ; ) {
            int i = paramInt;
            if (paramInt == 1001) {
                this.zn = new Bundle();
                this.zn.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
                i = 0;
            }
            super.a(i, paramIBinder, paramBundle);
            return;
            this.zj = false;
        }
    }

    protected void a(fm paramfm, ff.e parame)
            throws RemoteException {
        Bundle localBundle = new Bundle();
        zb.b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", new Object[]{this.zl, this.zm});
        this.zd.putInBundle(localBundle);
        localBundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zg);
        if (this.zl != null) {
            localBundle.putString("last_application_id", this.zl);
            if (this.zm != null) {
                localBundle.putString("last_session_id", this.zm);
            }
        }
        paramfm.a(parame, 4452000, getContext().getPackageName(), this.ze.asBinder(), localBundle);
    }

    public void a(String paramString, Cast.MessageReceivedCallback paramMessageReceivedCallback)
            throws IllegalArgumentException, IllegalStateException, RemoteException {
        eo.W(paramString);
        V(paramString);
        if (paramMessageReceivedCallback != null) {
        }
        synchronized (this.zf) {
            this.zf.put(paramString, paramMessageReceivedCallback);
            ((ep) eM()).Z(paramString);
            return;
        }
    }

    public void a(String paramString, a.d<Status> paramd)
            throws IllegalStateException, RemoteException {
        f(paramd);
        ((ep) eM()).Y(paramString);
    }

    public void a(String paramString1, String paramString2, a.d<Status> paramd)
            throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(paramString2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (paramString2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        }
        eo.W(paramString1);
        dK();
        long l = this.zk.incrementAndGet();
        ((ep) eM()).a(paramString1, paramString2, l);
        this.zo.put(Long.valueOf(l), paramd);
    }

    public void a(String paramString, boolean paramBoolean, a.d<Cast.ApplicationConnectionResult> paramd)
            throws IllegalStateException, RemoteException {
        d(paramd);
        ((ep) eM()).e(paramString, paramBoolean);
    }

    public void b(String paramString1, String paramString2, a.d<Cast.ApplicationConnectionResult> paramd)
            throws IllegalStateException, RemoteException {
        d(paramd);
        ((ep) eM()).e(paramString1, paramString2);
    }

    protected String bg() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String bh() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    public Bundle dG() {
        if (this.zn != null) {
            Bundle localBundle = this.zn;
            this.zn = null;
            return localBundle;
        }
        return super.dG();
    }

    public void dH()
            throws IllegalStateException, RemoteException {
        ((ep) eM()).dH();
    }

    public double dI()
            throws IllegalStateException {
        dK();
        return this.yC;
    }

    public void disconnect() {
        dJ();
        try {
            if (isConnected()) {
                ((ep) eM()).disconnect();
            }
            return;
        } catch (RemoteException localRemoteException) {
            zb.b("Error while disconnecting the controller interface: %s", new Object[]{localRemoteException.getMessage()});
            return;
        } finally {
            super.disconnect();
        }
    }

    public void e(a.d<Status> paramd)
            throws IllegalStateException, RemoteException {
        f(paramd);
        ((ep) eM()).dO();
    }

    public ApplicationMetadata getApplicationMetadata()
            throws IllegalStateException {
        dK();
        return this.zc;
    }

    public String getApplicationStatus()
            throws IllegalStateException {
        dK();
        return this.zh;
    }

    public boolean isMute()
            throws IllegalStateException {
        dK();
        return this.yD;
    }

    public void v(boolean paramBoolean)
            throws IllegalStateException, RemoteException {
        ((ep) eM()).a(paramBoolean, this.yC, this.yD);
    }

    protected ep x(IBinder paramIBinder) {
        return ep.a.y(paramIBinder);
    }

    private static final class a
            implements Cast.ApplicationConnectionResult {
        private final String qL;
        private final Status wJ;
        private final String zA;
        private final boolean zB;
        private final ApplicationMetadata zz;

        public a(Status paramStatus) {
            this(paramStatus, null, null, null, false);
        }

        public a(Status paramStatus, ApplicationMetadata paramApplicationMetadata, String paramString1, String paramString2, boolean paramBoolean) {
            this.wJ = paramStatus;
            this.zz = paramApplicationMetadata;
            this.zA = paramString1;
            this.qL = paramString2;
            this.zB = paramBoolean;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.zz;
        }

        public String getApplicationStatus() {
            return this.zA;
        }

        public String getSessionId() {
            return this.qL;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public boolean getWasLaunched() {
            return this.zB;
        }
    }

    private class b
            implements GoogleApiClient.OnConnectionFailedListener {
        private b() {
        }

        public void onConnectionFailed(ConnectionResult paramConnectionResult) {
            en.i(en.this);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/en.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */