package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ff;
import com.google.android.gms.internal.ff.b;
import com.google.android.gms.internal.ff.c;
import com.google.android.gms.internal.ff.d;
import com.google.android.gms.internal.ff.e;
import com.google.android.gms.internal.ff.g;
import com.google.android.gms.internal.fk;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.gg;
import com.google.android.gms.internal.ie;
import com.google.android.gms.internal.ih;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class e
        extends ff<d>
        implements GooglePlayServicesClient {
    private Person Ub;
    private final h Uc;

    public e(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, h paramh) {
        super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramh.iP());
        this.Uc = paramh;
    }

    @Deprecated
    public e(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, h paramh) {
        this(paramContext, paramContext.getMainLooper(), new ff.c(paramConnectionCallbacks), new ff.g(paramOnConnectionFailedListener), paramh);
    }

    public fk a(a.d<People.LoadPeopleResult> paramd, int paramInt, String paramString) {
        bT();
        paramd = new e(paramd);
        try {
            paramString = ((d) eM()).a(paramd, 1, paramInt, -1, paramString);
            return paramString;
        } catch (RemoteException paramString) {
            paramd.a(DataHolder.empty(8), null);
        }
        return null;
    }

    protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle) {
        if ((paramInt == 0) && (paramBundle != null) && (paramBundle.containsKey("loaded_person"))) {
            this.Ub = ih.i(paramBundle.getByteArray("loaded_person"));
        }
        super.a(paramInt, paramIBinder, paramBundle);
    }

    public void a(a.d<Moments.LoadMomentsResult> paramd, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3) {
        bT();
        if (paramd != null) {
        }
        for (paramd = new b(paramd); ; paramd = null) {
            try {
                ((d) eM()).a(paramd, paramInt, paramString1, paramUri, paramString2, paramString3);
                return;
            } catch (RemoteException paramString1) {
                paramd.a(DataHolder.empty(8), null, null);
            }
        }
    }

    public void a(a.d<Status> paramd, Moment paramMoment) {
        bT();
        if (paramd != null) {
        }
        for (paramd = new a(paramd); ; paramd = null) {
            try {
                paramMoment = gg.a((ie) paramMoment);
                ((d) eM()).a(paramd, paramMoment);
                return;
            } catch (RemoteException paramMoment) {
                if (paramd != null) {
                    break;
                }
                throw new IllegalStateException(paramMoment);
                paramd.Z(new Status(8, null, null));
            }
        }
    }

    public void a(a.d<People.LoadPeopleResult> paramd, Collection<String> paramCollection) {
        bT();
        paramd = new e(paramd);
        try {
            ((d) eM()).a(paramd, new ArrayList(paramCollection));
            return;
        } catch (RemoteException paramCollection) {
            paramd.a(DataHolder.empty(8), null);
        }
    }

    protected void a(fm paramfm, ff.e parame)
            throws RemoteException {
        Bundle localBundle = this.Uc.iX();
        localBundle.putStringArray("request_visible_actions", this.Uc.iQ());
        paramfm.a(parame, 4452000, this.Uc.iT(), this.Uc.iS(), eL(), this.Uc.getAccountName(), localBundle);
    }

    protected d aR(IBinder paramIBinder) {
        return d.a.aQ(paramIBinder);
    }

    protected String bg() {
        return "com.google.android.gms.plus.service.START";
    }

    public boolean bg(String paramString) {
        return Arrays.asList(eL()).contains(paramString);
    }

    protected String bh() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public void clearDefaultAccount() {
        bT();
        try {
            this.Ub = null;
            ((d) eM()).clearDefaultAccount();
            return;
        } catch (RemoteException localRemoteException) {
            throw new IllegalStateException(localRemoteException);
        }
    }

    public void d(a.d<People.LoadPeopleResult> paramd, String[] paramArrayOfString) {
        a(paramd, Arrays.asList(paramArrayOfString));
    }

    public String getAccountName() {
        bT();
        try {
            String str = ((d) eM()).getAccountName();
            return str;
        } catch (RemoteException localRemoteException) {
            throw new IllegalStateException(localRemoteException);
        }
    }

    public Person getCurrentPerson() {
        bT();
        return this.Ub;
    }

    public void l(a.d<Moments.LoadMomentsResult> paramd) {
        a(paramd, 20, null, null, null, "me");
    }

    public void m(a.d<People.LoadPeopleResult> paramd) {
        bT();
        paramd = new e(paramd);
        try {
            ((d) eM()).a(paramd, 2, 1, -1, null);
            return;
        } catch (RemoteException localRemoteException) {
            paramd.a(DataHolder.empty(8), null);
        }
    }

    public void n(a.d<Status> paramd) {
        bT();
        clearDefaultAccount();
        paramd = new g(paramd);
        try {
            ((d) eM()).b(paramd);
            return;
        } catch (RemoteException localRemoteException) {
            paramd.e(8, null);
        }
    }

    public fk o(a.d<People.LoadPeopleResult> paramd, String paramString) {
        return a(paramd, 0, paramString);
    }

    public void removeMoment(String paramString) {
        bT();
        try {
            ((d) eM()).removeMoment(paramString);
            return;
        } catch (RemoteException paramString) {
            throw new IllegalStateException(paramString);
        }
    }

    final class a
            extends a {
        private final a.d<Status> TG;

        public a() {
            a.d locald;
            this.TG = locald;
        }

        public void Z(Status paramStatus) {
            e.this.a(new e.d(e.this, this.TG, paramStatus));
        }
    }

    final class b
            extends a {
        private final a.d<Moments.LoadMomentsResult> TG;

        public b() {
            a.d locald;
            this.TG = locald;
        }

        public void a(DataHolder paramDataHolder, String paramString1, String paramString2) {
            if (paramDataHolder.getMetadata() != null) {
            }
            for (Object localObject = (PendingIntent) paramDataHolder.getMetadata().getParcelable("pendingIntent"); ; localObject = null) {
                localObject = new Status(paramDataHolder.getStatusCode(), null, (PendingIntent) localObject);
                if ((!((Status) localObject).isSuccess()) && (paramDataHolder != null)) {
                    if (!paramDataHolder.isClosed()) {
                        paramDataHolder.close();
                    }
                    paramDataHolder = null;
                }
                for (; ; ) {
                    e.this.a(new e.c(e.this, this.TG, (Status) localObject, paramDataHolder, paramString1, paramString2));
                    return;
                }
            }
        }
    }

    final class c
            extends ff<d>.d<a.d<Moments.LoadMomentsResult>>
            implements Moments.LoadMomentsResult {
        private final String EM;
        private final String Ue;
        private MomentBuffer Uf;
        private final Status wJ;

        public c(Status paramStatus, DataHolder paramDataHolder, String paramString1, String paramString2) {
            super(paramStatus, paramString1);
            this.wJ = paramDataHolder;
            this.EM = paramString2;
            String str;
            this.Ue = str;
        }

        protected void a(a.d<Moments.LoadMomentsResult> paramd, DataHolder paramDataHolder) {
            if (paramDataHolder != null) {
            }
            for (paramDataHolder = new MomentBuffer(paramDataHolder); ; paramDataHolder = null) {
                this.Uf = paramDataHolder;
                paramd.b(this);
                return;
            }
        }

        public MomentBuffer getMomentBuffer() {
            return this.Uf;
        }

        public String getNextPageToken() {
            return this.EM;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public String getUpdated() {
            return this.Ue;
        }

        public void release() {
            if (this.Uf != null) {
                this.Uf.close();
            }
        }
    }

    final class d
            extends ff<d>.b<a.d<Status>> {
        private final Status wJ;

        public d(Status paramStatus) {
            super(paramStatus);
            Status localStatus;
            this.wJ = localStatus;
        }

        protected void c(a.d<Status> paramd) {
            if (paramd != null) {
                paramd.b(this.wJ);
            }
        }

        protected void dx() {
        }
    }

    final class e
            extends a {
        private final a.d<People.LoadPeopleResult> TG;

        public e() {
            a.d locald;
            this.TG = locald;
        }

        public void a(DataHolder paramDataHolder, String paramString) {
            if (paramDataHolder.getMetadata() != null) {
            }
            for (Object localObject = (PendingIntent) paramDataHolder.getMetadata().getParcelable("pendingIntent"); ; localObject = null) {
                localObject = new Status(paramDataHolder.getStatusCode(), null, (PendingIntent) localObject);
                if ((!((Status) localObject).isSuccess()) && (paramDataHolder != null)) {
                    if (!paramDataHolder.isClosed()) {
                        paramDataHolder.close();
                    }
                    paramDataHolder = null;
                }
                for (; ; ) {
                    e.this.a(new e.f(e.this, this.TG, (Status) localObject, paramDataHolder, paramString));
                    return;
                }
            }
        }
    }

    final class f
            extends ff<d>.d<a.d<People.LoadPeopleResult>>
            implements People.LoadPeopleResult {
        private final String EM;
        private PersonBuffer Ug;
        private final Status wJ;

        public f(Status paramStatus, DataHolder paramDataHolder, String paramString) {
            super(paramStatus, paramString);
            this.wJ = paramDataHolder;
            String str;
            this.EM = str;
        }

        protected void a(a.d<People.LoadPeopleResult> paramd, DataHolder paramDataHolder) {
            if (paramDataHolder != null) {
            }
            for (paramDataHolder = new PersonBuffer(paramDataHolder); ; paramDataHolder = null) {
                this.Ug = paramDataHolder;
                paramd.b(this);
                return;
            }
        }

        public String getNextPageToken() {
            return this.EM;
        }

        public PersonBuffer getPersonBuffer() {
            return this.Ug;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public void release() {
            if (this.Ug != null) {
                this.Ug.close();
            }
        }
    }

    final class g
            extends a {
        private final a.d<Status> TG;

        public g() {
            a.d locald;
            this.TG = locald;
        }

        public void e(int paramInt, Bundle paramBundle) {
            if (paramBundle != null) {
            }
            for (paramBundle = (PendingIntent) paramBundle.getParcelable("pendingIntent"); ; paramBundle = null) {
                paramBundle = new Status(paramInt, null, paramBundle);
                e.this.a(new e.h(e.this, this.TG, paramBundle));
                return;
            }
        }
    }

    final class h
            extends ff<d>.b<a.d<Status>> {
        private final Status wJ;

        public h(Status paramStatus) {
            super(paramStatus);
            Status localStatus;
            this.wJ = localStatus;
        }

        protected void c(a.d<Status> paramd) {
            e.this.disconnect();
            if (paramd != null) {
                paramd.b(this.wJ);
            }
        }

        protected void dx() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/plus/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */