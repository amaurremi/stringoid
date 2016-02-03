package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.hw;
import com.google.android.gms.internal.hx;

public final class Panorama {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api(wy, wx, new Scope[0]);
    public static final PanoramaApi PanoramaApi = new hw();
    public static final Api.c<hx> wx = new Api.c();
    static final Api.b<hx, Api.ApiOptions.NoOptions> wy = new Api.b() {
        public hx c(Context paramAnonymousContext, Looper paramAnonymousLooper, fc paramAnonymousfc, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener) {
            return new hx(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/panorama/Panorama.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */