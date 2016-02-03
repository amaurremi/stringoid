package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.a.l;
import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.app.af;
import android.support.v4.app.q;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.a;

public class ae
        extends Fragment
        implements DialogInterface.OnCancelListener, android.support.v4.app.ag<a> {
    private boolean a;
    private int b = -1;
    private a c;
    private final Handler d = new Handler(Looper.getMainLooper());
    private final SparseArray<ah> e = new SparseArray();

    public static ae a(android.support.v4.app.k paramk) {
        com.google.android.gms.common.internal.ag.b("Must be called from main thread of process");
        q localq = paramk.f();
        try {
            ae localae = (ae) localq.a("GmsSupportLifecycleFragment");
            if (localae != null) {
                paramk = localae;
                if (!localae.isRemoving()) {
                }
            } else {
                paramk = new ae();
                localq.a().a(paramk, "GmsSupportLifecycleFragment").b();
                localq.b();
            }
            return paramk;
        } catch (ClassCastException paramk) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", paramk);
        }
    }

    private void a() {
        int i = 0;
        this.a = false;
        this.b = -1;
        this.c = null;
        af localaf = getLoaderManager();
        while (i < this.e.size()) {
            int j = this.e.keyAt(i);
            ag localag = c(j);
            if (localag != null) {
                localag.a();
            }
            localaf.a(j, null, this);
            i += 1;
        }
    }

    private void a(int paramInt, a parama) {
        if (!this.a) {
            this.a = true;
            this.b = paramInt;
            this.c = parama;
            this.d.post(new ai(this, paramInt, parama));
        }
    }

    private void b(int paramInt, a parama) {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        Object localObject = (ah) this.e.get(paramInt);
        if (localObject != null) {
            b(paramInt);
            localObject = ((ah) localObject).b;
            if (localObject != null) {
                ((n) localObject).a(parama);
            }
        }
        a();
    }

    private void d(int paramInt) {
        if (paramInt == this.b) {
            a();
        }
    }

    public k a(int paramInt) {
        if (getActivity() != null) {
            ag localag = c(paramInt);
            if (localag != null) {
                return localag.a;
            }
        }
        return null;
    }

    public void a(int paramInt, k paramk, n paramn) {
        com.google.android.gms.common.internal.ag.a(paramk, "GoogleApiClient instance cannot be null");
        if (this.e.indexOfKey(paramInt) < 0) {
        }
        for (boolean bool = true; ; bool = false) {
            com.google.android.gms.common.internal.ag.a(bool, "Already managing a GoogleApiClient with id " + paramInt);
            paramk = new ah(paramk, paramn, null);
            this.e.put(paramInt, paramk);
            if (getActivity() != null) {
                getLoaderManager().a(paramInt, null, this);
            }
            return;
        }
    }

    public void a(l<a> paraml, a parama) {
        if (parama.b()) {
            d(paraml.getId());
            return;
        }
        a(paraml.getId(), parama);
    }

    public void b(int paramInt) {
        getLoaderManager().a(paramInt);
        this.e.remove(paramInt);
    }

    ag c(int paramInt) {
        try {
            ag localag = (ag) getLoaderManager().b(paramInt);
            return localag;
        } catch (ClassCastException localClassCastException) {
            throw new IllegalStateException("Unknown loader in SupportLifecycleFragment", localClassCastException);
        }
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        int i = 1;
        switch (paramInt1) {
            default:
                paramInt1 = 0;
        }
        for (; ; ) {
            if (paramInt1 == 0) {
                break label66;
            }
            a();
            return;
            if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) != 0) {
                break;
            }
            paramInt1 = i;
            continue;
            if (paramInt2 != -1) {
                break;
            }
            paramInt1 = i;
        }
        label66:
        b(this.b, this.c);
    }

    public void onAttach(Activity paramActivity) {
        super.onAttach(paramActivity);
        int i = 0;
        if (i < this.e.size()) {
            int j = this.e.keyAt(i);
            paramActivity = c(j);
            if ((paramActivity != null) && (((ah) this.e.valueAt(i)).a != paramActivity.a)) {
                getLoaderManager().b(j, null, this);
            }
            for (; ; ) {
                i += 1;
                break;
                getLoaderManager().a(j, null, this);
            }
        }
    }

    public void onCancel(DialogInterface paramDialogInterface) {
        b(this.b, this.c);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (paramBundle != null) {
            this.a = paramBundle.getBoolean("resolving_error", false);
            this.b = paramBundle.getInt("failed_client_id", -1);
            if (this.b >= 0) {
                this.c = new a(paramBundle.getInt("failed_status"), (PendingIntent) paramBundle.getParcelable("failed_resolution"));
            }
        }
    }

    public l<a> onCreateLoader(int paramInt, Bundle paramBundle) {
        return new ag(getActivity(), ((ah) this.e.get(paramInt)).a);
    }

    public void onLoaderReset(l<a> paraml) {
        if (paraml.getId() == this.b) {
            a();
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putBoolean("resolving_error", this.a);
        if (this.b >= 0) {
            paramBundle.putInt("failed_client_id", this.b);
            paramBundle.putInt("failed_status", this.c.c());
            paramBundle.putParcelable("failed_resolution", this.c.d());
        }
    }

    public void onStart() {
        super.onStart();
        if (!this.a) {
            int i = 0;
            while (i < this.e.size()) {
                getLoaderManager().a(this.e.keyAt(i), null, this);
                i += 1;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/api/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */