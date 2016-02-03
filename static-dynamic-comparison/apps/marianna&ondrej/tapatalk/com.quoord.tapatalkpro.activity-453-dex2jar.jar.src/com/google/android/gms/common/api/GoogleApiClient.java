package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fq;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract interface GoogleApiClient {
    public abstract <C extends Api.a> C a(Api.c<C> paramc);

    public abstract <A extends Api.a, T extends a.b<? extends Result, A>> T a(T paramT);

    public abstract <A extends Api.a, T extends a.b<? extends Result, A>> T b(T paramT);

    public abstract ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit);

    public abstract void connect();

    public abstract void disconnect();

    public abstract Looper getLooper();

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks paramConnectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener paramOnConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);

    public static final class Builder {
        private Looper AS;
        private final Set<String> AT = new HashSet();
        private int AU;
        private View AV;
        private String AW;
        private final Map<Api<?>, Api.ApiOptions> AX = new HashMap();
        private final Set<GoogleApiClient.ConnectionCallbacks> AY = new HashSet();
        private final Set<GoogleApiClient.OnConnectionFailedListener> AZ = new HashSet();
        private final Context mContext;
        private String wG;

        public Builder(Context paramContext) {
            this.mContext = paramContext;
            this.AS = paramContext.getMainLooper();
            this.AW = paramContext.getPackageName();
        }

        public Builder(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
            this(paramContext);
            fq.b(paramConnectionCallbacks, "Must provide a connected listener");
            this.AY.add(paramConnectionCallbacks);
            fq.b(paramOnConnectionFailedListener, "Must provide a connection failed listener");
            this.AZ.add(paramOnConnectionFailedListener);
        }

        public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi) {
            this.AX.put(paramApi, null);
            paramApi = paramApi.dZ();
            int j = paramApi.size();
            int i = 0;
            while (i < j) {
                this.AT.add(((Scope) paramApi.get(i)).en());
                i += 1;
            }
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> paramApi, O paramO) {
            fq.b(paramO, "Null options are not permitted for this Api");
            this.AX.put(paramApi, paramO);
            paramApi = paramApi.dZ();
            int j = paramApi.size();
            int i = 0;
            while (i < j) {
                this.AT.add(((Scope) paramApi.get(i)).en());
                i += 1;
            }
            return this;
        }

        public Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks) {
            this.AY.add(paramConnectionCallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
            this.AZ.add(paramOnConnectionFailedListener);
            return this;
        }

        public Builder addScope(Scope paramScope) {
            this.AT.add(paramScope.en());
            return this;
        }

        public GoogleApiClient build() {
            return new b(this.mContext, this.AS, eh(), this.AX, this.AY, this.AZ);
        }

        public fc eh() {
            return new fc(this.wG, this.AT, this.AU, this.AV, this.AW);
        }

        public Builder setAccountName(String paramString) {
            this.wG = paramString;
            return this;
        }

        public Builder setGravityForPopups(int paramInt) {
            this.AU = paramInt;
            return this;
        }

        public Builder setHandler(Handler paramHandler) {
            fq.b(paramHandler, "Handler must not be null");
            this.AS = paramHandler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View paramView) {
            this.AV = paramView;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }
    }

    public static abstract interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        public abstract void onConnected(Bundle paramBundle);

        public abstract void onConnectionSuspended(int paramInt);
    }

    public static abstract interface OnConnectionFailedListener
            extends GooglePlayServicesClient.OnConnectionFailedListener {
        public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/common/api/GoogleApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */