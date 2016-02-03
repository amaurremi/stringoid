package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.internal.fc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends ApiOptions> {
    private final ArrayList<Scope> AA;
    private final b<?, O> Ay;
    private final c<?> Az;

    public <C extends a> Api(b<C, O> paramb, c<C> paramc, Scope... paramVarArgs) {
        this.Ay = paramb;
        this.Az = paramc;
        this.AA = new ArrayList(Arrays.asList(paramVarArgs));
    }

    public b<?, O> dY() {
        return this.Ay;
    }

    public List<Scope> dZ() {
        return this.AA;
    }

    public c<?> ea() {
        return this.Az;
    }

    public static abstract interface ApiOptions {
        public static abstract interface HasOptions
                extends Api.ApiOptions {
        }

        public static final class NoOptions
                implements Api.ApiOptions.NotRequiredOptions {
        }

        public static abstract interface NotRequiredOptions
                extends Api.ApiOptions {
        }

        public static abstract interface Optional
                extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions {
        }
    }

    public static abstract interface a {
        public abstract void connect();

        public abstract void disconnect();

        public abstract Looper getLooper();

        public abstract boolean isConnected();
    }

    public static abstract interface b<T extends Api.a, O> {
        public abstract T a(Context paramContext, Looper paramLooper, fc paramfc, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);

        public abstract int getPriority();
    }

    public static final class c<C extends Api.a> {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/common/api/Api.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */