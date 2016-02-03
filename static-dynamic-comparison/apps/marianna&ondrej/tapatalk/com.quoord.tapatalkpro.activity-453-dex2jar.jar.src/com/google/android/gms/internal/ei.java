package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;

public final class ei
        extends ff<ek> {
    private final String wG;

    public ei(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, String[] paramArrayOfString) {
        super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
        this.wG = ((String) fq.f(paramString));
    }

    public void a(a.d<AppStateManager.StateListResult> paramd) {
        try {
            ((ek) eM()).a(new c(paramd));
            return;
        } catch (RemoteException paramd) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void a(a.d<AppStateManager.StateDeletedResult> paramd, int paramInt) {
        try {
            ((ek) eM()).b(new a(paramd), paramInt);
            return;
        } catch (RemoteException paramd) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void a(a.d<AppStateManager.StateResult> paramd, int paramInt, String paramString, byte[] paramArrayOfByte) {
        try {
            ((ek) eM()).a(new e(paramd), paramInt, paramString, paramArrayOfByte);
            return;
        } catch (RemoteException paramd) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void a(a.d<AppStateManager.StateResult> paramd, int paramInt, byte[] paramArrayOfByte) {
        if (paramd == null) {
        }
        for (paramd = null; ; paramd = new e(paramd)) {
            try {
                ((ek) eM()).a(paramd, paramInt, paramArrayOfByte);
                return;
            } catch (RemoteException paramd) {
                Log.w("AppStateClient", "service died");
            }
        }
    }

    protected void a(fm paramfm, ff.e parame)
            throws RemoteException {
        paramfm.a(parame, 4452000, getContext().getPackageName(), this.wG, eL());
    }

    public void b(a.d<Status> paramd) {
        try {
            ((ek) eM()).b(new g(paramd));
            return;
        } catch (RemoteException paramd) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void b(a.d<AppStateManager.StateResult> paramd, int paramInt) {
        try {
            ((ek) eM()).a(new e(paramd), paramInt);
            return;
        } catch (RemoteException paramd) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected void b(String... paramVarArgs) {
        int i = 0;
        boolean bool = false;
        while (i < paramVarArgs.length) {
            if (paramVarArgs[i].equals("https://www.googleapis.com/auth/appstate")) {
                bool = true;
            }
            i += 1;
        }
        fq.a(bool, String.format("App State APIs requires %s to function.", new Object[]{"https://www.googleapis.com/auth/appstate"}));
    }

    protected String bg() {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String bh() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public int dv() {
        try {
            int i = ((ek) eM()).dv();
            return i;
        } catch (RemoteException localRemoteException) {
            Log.w("AppStateClient", "service died");
        }
        return 2;
    }

    public int dw() {
        try {
            int i = ((ek) eM()).dw();
            return i;
        } catch (RemoteException localRemoteException) {
            Log.w("AppStateClient", "service died");
        }
        return 2;
    }

    protected ek u(IBinder paramIBinder) {
        return ek.a.w(paramIBinder);
    }

    final class a
            extends eh {
        private final a.d<AppStateManager.StateDeletedResult> wH;

        public a() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Result holder must not be null"));
        }

        public void b(int paramInt1, int paramInt2) {
            Status localStatus = new Status(paramInt1);
            ei.this.a(new ei.b(ei.this, this.wH, localStatus, paramInt2));
        }
    }

    final class b
            extends ff<ek>.b<a.d<AppStateManager.StateDeletedResult>>
            implements AppStateManager.StateDeletedResult {
        private final Status wJ;
        private final int wK;

        public b(Status paramStatus, int paramInt) {
            super(paramStatus);
            this.wJ = paramInt;
            int i;
            this.wK = i;
        }

        public void c(a.d<AppStateManager.StateDeletedResult> paramd) {
            paramd.b(this);
        }

        protected void dx() {
        }

        public int getStateKey() {
            return this.wK;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class c
            extends eh {
        private final a.d<AppStateManager.StateListResult> wH;

        public c() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Result holder must not be null"));
        }

        public void a(DataHolder paramDataHolder) {
            Status localStatus = new Status(paramDataHolder.getStatusCode());
            ei.this.a(new ei.d(ei.this, this.wH, localStatus, paramDataHolder));
        }
    }

    final class d
            extends ff<ek>.d<a.d<AppStateManager.StateListResult>>
            implements AppStateManager.StateListResult {
        private final Status wJ;
        private final AppStateBuffer wL;

        public d(Status paramStatus, DataHolder paramDataHolder) {
            super(paramStatus, localDataHolder);
            this.wJ = paramDataHolder;
            this.wL = new AppStateBuffer(localDataHolder);
        }

        public void a(a.d<AppStateManager.StateListResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }

        public AppStateBuffer getStateBuffer() {
            return this.wL;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class e
            extends eh {
        private final a.d<AppStateManager.StateResult> wH;

        public e() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Result holder must not be null"));
        }

        public void a(int paramInt, DataHolder paramDataHolder) {
            ei.this.a(new ei.f(ei.this, this.wH, paramInt, paramDataHolder));
        }
    }

    final class f
            extends ff<ek>.d<a.d<AppStateManager.StateResult>>
            implements AppStateManager.StateConflictResult, AppStateManager.StateLoadedResult, AppStateManager.StateResult {
        private final Status wJ;
        private final int wK;
        private final AppStateBuffer wL;

        public f(int paramInt, DataHolder paramDataHolder) {
            super(paramInt, localDataHolder);
            this.wK = paramDataHolder;
            this.wJ = new Status(localDataHolder.getStatusCode());
            this.wL = new AppStateBuffer(localDataHolder);
        }

        private boolean dy() {
            return this.wJ.getStatusCode() == 2000;
        }

        public void a(a.d<AppStateManager.StateResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }

        public AppStateManager.StateConflictResult getConflictResult() {
            if (dy()) {
                return this;
            }
            return null;
        }

        public AppStateManager.StateLoadedResult getLoadedResult() {
            f localf = this;
            if (dy()) {
                localf = null;
            }
            return localf;
        }

        public byte[] getLocalData() {
            if (this.wL.getCount() == 0) {
                return null;
            }
            return this.wL.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            if (this.wL.getCount() == 0) {
                return null;
            }
            return this.wL.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            if (this.wL.getCount() == 0) {
                return null;
            }
            return this.wL.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.wK;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public void release() {
            this.wL.close();
        }
    }

    final class g
            extends eh {
        a.d<Status> wH;

        public g() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void du() {
            Status localStatus = new Status(0);
            ei.this.a(new ei.h(ei.this, this.wH, localStatus));
        }
    }

    final class h
            extends ff<ek>.b<a.d<Status>> {
        private final Status wJ;

        public h(Status paramStatus) {
            super(paramStatus);
            Status localStatus;
            this.wJ = localStatus;
        }

        public void c(a.d<Status> paramd) {
            paramd.b(this.wJ);
        }

        protected void dx() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */